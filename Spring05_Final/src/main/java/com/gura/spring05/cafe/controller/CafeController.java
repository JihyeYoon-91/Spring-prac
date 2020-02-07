package com.gura.spring05.cafe.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gura.spring05.cafe.dao.CafeDao;
import com.gura.spring05.cafe.dto.CafeDto;
import com.gura.spring05.cafe.service.CafeService;



@Controller
public class CafeController {

	 @Autowired
	 private CafeDao dao;
	
	 @Autowired
	 private CafeService service;
	 
	@RequestMapping("/cafe/list")
	public ModelAndView list(ModelAndView mView,
			HttpServletRequest request) {
		service.list(request);
		mView.setViewName("cafe/list");
		return mView; 
	}
	@RequestMapping("/cafe/insertform")
	public ModelAndView authInsertForm(HttpServletRequest request) {
		
		return new ModelAndView("cafe/insertform");		
	}	
	
	@RequestMapping(value = "/cafe/insert", method=RequestMethod.POST)
	public ModelAndView authUpload(HttpServletRequest request,
			@ModelAttribute CafeDto dto) {
		
		service.insert(request, dto);
		return new ModelAndView("redirect:/cafe/list.do");
	}	
     @RequestMapping(value="/cafe/detail" ) 
     public ModelAndView detail(ModelAndView mView, @RequestParam int num) {
    	 service.getCafe( mView, num);
    	 mView.setViewName("cafe/detail");
    	 return mView;
     }
     
     @RequestMapping("/cafe/updateform")
 	public ModelAndView authUpdateform(HttpServletRequest request,
 			@RequestParam int num, ModelAndView mView) {		
    	 service.getCafe(mView, num);
    	 mView.setViewName("cafe/updateform");
    	 return mView;		
 	}	
     
	 @RequestMapping("/cafe/update") 
	 public ModelAndView authUpdate(HttpServletRequest request, @ModelAttribute("dto") CafeDto dto,
			 ModelAndView mView) {
		 //회원정보가 수정되도록 서비스의 메소드 호출
		 service.updateCafe(dto);
		 mView.setViewName("redirect:/cafe/list.do");
		 return mView;
	  }	
	 @RequestMapping("/cafe/delete") 
		public ModelAndView authDelete(ModelAndView mView,
				HttpServletRequest request) {	
			service.removeCafe(request);
			mView.setViewName("redirect:/cafe/list.do");
			return mView;
		}
	 
	 
	 
}
