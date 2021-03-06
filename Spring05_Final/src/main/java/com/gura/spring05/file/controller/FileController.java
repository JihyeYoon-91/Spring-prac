package com.gura.spring05.file.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gura.spring05.file.dto.FileDto;
import com.gura.spring05.file.service.FileService;

@Controller
public class FileController {
	
	@Autowired
	private FileService service;

	//파일목록보기 요청처리
	@RequestMapping("/file/list")
	public ModelAndView list(ModelAndView mView,
			HttpServletRequest request) {	
		//파일목록과 페이징 처리에 필요한 값들을 request에 담아주는 서비스 메소드 호출하기
		service.list(request);
		mView.setViewName("file/list");
		return mView;
	}
	//파일 업로드 폼 요청처리
	@RequestMapping("/file/upload_form")
	public ModelAndView authUploadForm(HttpServletRequest request) {
		
		return new ModelAndView("file/upload_form");
		
	}
	@RequestMapping(value = "/file/upload", method=RequestMethod.POST)
	public ModelAndView authUpload(HttpServletRequest request,
			@ModelAttribute FileDto dto) {
		
		service.saveFile(request, dto);
		return new ModelAndView("redirect:/file/list.do");
	}
	//파일 다운로드 처리
	@RequestMapping("/file/download")
	public ModelAndView download(ModelAndView mView,@RequestParam int num) {
		//다운로드 횟수 증가시키도록
		service.addDownCount(num);
		//다운로드 시켜줄 파일데이터를 ModelAndView객체에 담기도록		
		service.getFileData(mView, num);
		//view page정보를 ModelAndView객체에 담기
		mView.setViewName("fileDownView");   
		// ="/views/fileDownView"가 아니라 bean이름을 먼저 찾기 때문에 가능하다.
		return mView;
	}
	@RequestMapping("/file/delete")
	public ModelAndView authDelete(ModelAndView mView,
			HttpServletRequest request) {	
		service.removeFile(request);
		mView.setViewName("redirect:/file/list.do");
		return mView;
	}
}
