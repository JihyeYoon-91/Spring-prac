package com.gura.spring05.cafe.dao;

import java.util.List;

import com.gura.spring05.cafe.dto.CafeDto;

public interface CafeDao {
	public List<CafeDto> getList(CafeDto dto);
	public int getCount(CafeDto dto);
	public void insert(CafeDto dto);
	public CafeDto getCafe(int num);
	public void addViewCount(int num);
	public void updateCafe(CafeDto dto);
	public void delete(int num);

}
