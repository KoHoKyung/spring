package com.simple.www.dao;

import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import com.simple.www.vo.MemberVO;


public class MemberDAO {
	
	@Autowired
	SqlSessionTemplate sqlSession;
	
	public int loginProc(MemberVO vo) {
		int cnt = sqlSession.selectOne("mSQL.Login", vo);
		
		return cnt;
	}
	
	public int joinProc(MemberVO vo) {
		int cnt = sqlSession.update("mSQL.join", vo);
		
		return cnt;
	}
	
	public int idcount(String m_Id) {
//	public int idcount(MemberVO vo) {
		int cnt = sqlSession.selectOne("mSQL.idCount", m_Id);
		return cnt;
	}
	public MemberVO memberInfo(MemberVO vo) {
//	public int idcount(MemberVO vo) {
		vo = sqlSession.selectOne("mSQL.memberInfo", vo);
		return vo;
	}
	
	public String showName(String m_no) {
		
		String mno = sqlSession.selectOne("mSQL.showName", m_no);
		System.out.println(mno);
		return mno;
	}

	
	public List<String> idList() {
		
		 List<String> list = sqlSession.selectList("mSQL.idList");
		return list;
	}
	
	public int infoEdit(MemberVO vo) {
		
		int cnt = sqlSession.update("mSQL.infoEdit", vo);
		return cnt;
	}
	
	public MemberVO showAvatar(MemberVO vo) {
		
		vo = sqlSession.selectOne("mSQL.showavatar", vo);
		return vo;
	}
	

	
}
