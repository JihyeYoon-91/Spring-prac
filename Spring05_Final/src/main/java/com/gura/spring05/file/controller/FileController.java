package com.gura.spring05.file.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FileController {
	
	@Autowired
	private FileController controller;

	//파일목록보기 요청처리
	@RequestMapping("/file/list")
	public ModelAndView list(ModelAndView mView) {
		mView.setViewName("file/list");
		return mView;
	}
}
