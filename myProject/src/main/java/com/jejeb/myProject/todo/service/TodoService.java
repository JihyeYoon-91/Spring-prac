package com.jejeb.myProject.todo.service;

import org.springframework.web.servlet.ModelAndView;

import com.jejeb.myProject.todo.dto.TodoDto;

public interface TodoService {
	public void getList(ModelAndView mView);
	public void addTodo(TodoDto dto);
	public void getTodo(ModelAndView mView,int num);
	public void updateTodo(TodoDto dto);
	public void deleteTodo(int num);
}
