package com.simple.www.dao;

import java.sql.SQLException;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.util.NestedServletException;

import com.simple.www.vo.BoardVO;

public class BoardDAO {

	@Autowired
	SqlSessionTemplate sqlSession;
	
	public List<BoardVO> visitorList() {
		List<BoardVO> list = sqlSession.selectList("bSQL.boardList");
		return list;
	}
	
	public int visitorEdit(BoardVO vo){

		int cnt = sqlSession.insert("bSQL.visitorEdit", vo);
		
		return cnt;
	}
}
