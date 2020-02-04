package com.gura.spring05.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gura.spring05.member.dto.MemberDto;

@Repository
public class MemberDaoImpl implements MemberDao{
	//핵심 의존객체(bean)를 spring으로부터 주입받기(Dependency Injection) DI       /IOC AOP
	//spring bean container에서 알아서 참조값을 넣어준다. 뉴를 안해도된당 
	@Autowired
	private SqlSession session;

	@Override
	public List<MemberDto> getlist() {
		List<MemberDto> list=session.selectList("member.getList");
		return list;
	}

	@Override
	public void delete(int num) {
		session.delete("member.delete",num);
		
	}

	@Override
	public void insert(MemberDto dto) {
		session.insert("member.insert", dto);
		
	}

	@Override
	public MemberDto getData(int num) {
		MemberDto dto=session.selectOne("member.getData",num);
		return dto;
	}

	@Override
	public void update(MemberDto dto) {
		session.update("member.update", dto);
		
	}
	

}
