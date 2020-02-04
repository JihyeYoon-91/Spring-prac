package com.jejeb.myProject.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.jejeb.myProject.todo.dao.TodoDao;
import com.jejeb.myProject.todo.dto.TodoDto;
import com.jejeb.myProject.todo.service.TodoService;

@Controller
public class TodoController {
	@Autowired
	private TodoDao dao;
	@Autowired
	private TodoService service;
	
	//todo목록보기
	@RequestMapping("/todo/list")
	public ModelAndView list(ModelAndView mView) {
		service.getList(mView);
		mView.setViewName("todo/list");
		return mView;
	}
	@RequestMapping("/todo/insertform")
	public String insertform() {
		return "todo/insertform";
	}
	@RequestMapping("/todo/insert")
	public ModelAndView insert(@ModelAttribute("dto") TodoDto dto,
			ModelAndView mView) {
		service.addTodo(dto);
		mView.setViewName("todo/insert");
		return mView;
	}
	@RequestMapping("/todo/update")
	public ModelAndView update(@ModelAttribute("dto") TodoDto dto,
			ModelAndView mView) {
		service.updateTodo(dto);
		mView.setViewName("todo/update");
		return mView;
	}
	@RequestMapping("/todo/updateform")
	public ModelAndView updateform(@RequestParam int num,
			ModelAndView mView) {
		service.getTodo(mView, num);
		mView.setViewName("todo/updateform");
		return mView;
	}
	@RequestMapping("/todo/delete")
	public String delete(@RequestParam int num) {
		dao.delete(num);
		return "redirect:/todo/list.do";
	}
	
	
}
