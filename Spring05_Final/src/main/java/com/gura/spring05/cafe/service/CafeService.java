package com.gura.spring05.cafe.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

import com.gura.spring05.cafe.dto.CafeDto;

public interface CafeService {

	public void list(HttpServletRequest request);

	public void insert(HttpServletRequest request, CafeDto dto);

	public void getCafe(ModelAndView mView,int num);

	public void updateCafe(CafeDto dto);

	public void removeCafe(HttpServletRequest request);


}
