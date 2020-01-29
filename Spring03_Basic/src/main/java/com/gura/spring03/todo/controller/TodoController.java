package com.gura.spring03.todo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TodoController {
	@RequestMapping("/todo/list.do")
	public String list(HttpServletRequest request) {
		
		//3.할 일 목록을 얻어오는 비지니스 로직 처리하기
		List<String> todoList=new ArrayList<>();
		todoList.add("공부");
		todoList.add("놀아");
		todoList.add("집가");		
		//4.비즈니스 로직 처리 결과 모델을 request에 담기
		request.setAttribute("todoList", todoList);
		//5.view page의 정보를 리턴해서 forward이동해서 응답하기
		return "todo/list";
	}
	@RequestMapping("/todo/list2")//.do는 생략가능
	public ModelAndView list2() {
		//Model
		List<String> todoList=new ArrayList<>();
		todoList.add("공부");
		todoList.add("놀아");
		todoList.add("집가");		
		//Model과 view page정보를 담을 수 있는 객체생성
		ModelAndView mView = new ModelAndView();
		//ModelAndView객체에 .addObject(key,value)로 담은 객체는 
		//자동으로 request객체에 담긴다.
		mView.addObject("todoList",todoList); //스프링프레임워크가 알아서 셋 해줌
		//view page정보도 .setViewName()메소드를 이용해서 담는다.
		mView.setViewName("todo/list");
		return mView;
	}
	//메소드의 인자로 ModelAndView 객체를 받을 수 있는 변수를 선언하면
	//스프링 프레임워크가 해당객체를 생성해서 인자로 전달해준다.
	@RequestMapping("/todo/list3")
	public ModelAndView list3(ModelAndView mView) {
		//Model
		List<String> todoList=new ArrayList<>();
		todoList.add("공부");
		todoList.add("놀아");
		todoList.add("집가");				
		//인자로 전달받은 객체에 Model을 담고
		mView.addObject("todoList",todoList);
		//인자로 전달받은 객체에 view page의 정보를 담고
		mView.setViewName("todo/list");		
		//인자로 전달받은 객체의 참조값을 리턴해준다.
		return mView;
	}
}
