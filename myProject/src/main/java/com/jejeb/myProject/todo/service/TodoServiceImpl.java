package com.jejeb.myProject.todo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.jejeb.myProject.todo.dao.TodoDao;
import com.jejeb.myProject.todo.dto.TodoDto;

@Service
public class TodoServiceImpl implements TodoService{
	@Autowired
	private TodoDao dao;
	
	@Override
	public void getList(ModelAndView mView) {
		List<TodoDto> list=dao.getList();
		mView.addObject("list",list);
		
	}

	@Override
	public void addTodo(TodoDto dto) {
		dao.insert(dto);
		
	}

	@Override
	public void getTodo(ModelAndView mView, int num) {
		TodoDto dto=dao.getData(num);
		mView.addObject("dto",dto);
		
	}

	@Override
	public void updateTodo(TodoDto dto) {
		dao.update(dto);
		
	}

	@Override
	public void deleteTodo(int num) {
		dao.delete(num);
		
	}

}
