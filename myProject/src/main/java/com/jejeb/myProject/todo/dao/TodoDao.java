package com.jejeb.myProject.todo.dao;

import java.util.List;

import com.jejeb.myProject.todo.dto.TodoDto;

public interface TodoDao {
	public List<TodoDto> getList();
	public void delete(int num);
	public void insert(TodoDto dto);
	public TodoDto getData(int num);
	public void update(TodoDto dto);
	
}
