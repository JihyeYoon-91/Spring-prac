package com.gura.spring05.member.dao;

import java.util.List;

import com.gura.spring05.member.dto.MemberDto;

public interface MemberDao {
	public List<MemberDto> getlist();
	public void delete(int num);
	public void insert(MemberDto dto);
	public MemberDto getData(int num);
	public void update(MemberDto dto);
}
