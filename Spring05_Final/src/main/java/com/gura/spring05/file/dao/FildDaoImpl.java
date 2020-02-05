package com.gura.spring05.file.dao;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gura.spring05.file.dto.FileDto;

@Repository
public class FildDaoImpl implements FileDao{
	
	@Autowired
	private SqlSession session;

	@Override
	public int getCount() {	
		//업로드된 파일의 전체갯수를 select해서 리턴한다.
		return session.selectOne("file.getCount");
	}

	@Override
	public List<FileDto> getList(FileDto dto) {
		List<FileDto> list=session.selectList("file.getList",dto);
		return list;
	}

	@Override
	public void insert(FileDto dto) {
		session.insert("file.insert",dto);
		
	}
}
