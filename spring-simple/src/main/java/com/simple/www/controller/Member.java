package com.simple.www.controller;

import java.util.List;

import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.simple.www.dao.*;
import com.simple.www.services.FileService;
import com.simple.www.vo.*;

@Controller
@RequestMapping("/member/")
public class Member {
	@Autowired
	MemberDAO mDAO;
	@Autowired
	FileService fileSrvc;
	
	@RequestMapping("login.van")
	public ModelAndView loginForm(ModelAndView mv) {
		mv.setViewName("member/login");
		
		return mv;
	}
	
	@RequestMapping("loginProc.van")
	public ModelAndView loginProc(HttpSession session, RedirectView rv, ModelAndView mv, MemberVO vo) {
		System.out.println(vo.getM_Id());
		int cnt = mDAO.loginProc(vo);
		if (cnt > 0) {
			// 이 경우는 아이디와 비밀번호가 일치하는 회원이 한명 있따는 이야기이므로
			// 로그인 처리를 해주면 되는데
			// 로그인 처리는 세션에 아이디를 입력해주기로 하자.
			session.setAttribute("SID", vo.getM_Id());
			rv.setUrl("/www/main.van");
		} else {
			// 이 경우는 로그인에 실패한 경우이므로 다시 로그인 페이지로 이동한다.
			rv.setUrl("/www/member/login.van");
		}
		mv.setView(rv);
		return mv;
	}
	
	@RequestMapping("idCheck.van")
	@ResponseBody
	public int idcheck(String m_Id) {
		/*
			우리가 현재 피룡한 데이터는 json 형식의 데이터다
			데이터의 숫자가 적을 경우는 해당 json 형식의 데이터를 만들어 주는 것이 문제 없지만
			여러개 라면 문제가 될 수 있다.
			코드의 길이가 늘어날 수 있고
			확인하는 작업이 불편해진다.
		 */
//		public int idcheck(MemberVO vo) {
		int cnt = mDAO.idcount(m_Id);
//		int cnt = mDAO.idcount(vo);
		return cnt;
	}
	@RequestMapping("memberInfo.van")
	@ResponseBody
	public MemberVO memberInfo(MemberVO vo) {
		vo = mDAO.memberInfo(vo);
		return vo;
	}
	
	@RequestMapping("infoEdit.van")
	@ResponseBody
	public int memberEdit(MemberVO vo) {
		System.out.println(vo.getCode());
		int cnt = mDAO.infoEdit(vo);

		/* vo = mDAO.memberInfo(vo); */
		return cnt;
	}
	
	
	
	@RequestMapping("logout.van")
	public ModelAndView logOut(HttpSession session, ModelAndView mv, RedirectView rv) {
		/* session.invalidate(); */
		session.setAttribute("SID", "");
		rv.setUrl("/www/main.van");
		mv.setView(rv);
		return mv;
	}
	
	@RequestMapping("joinProc.van")
	public ModelAndView joinProc(ModelAndView mv, RedirectView rv, MemberVO vo) {
		int cnt = mDAO.joinProc(vo);
		if(cnt > 0) {
			rv.setUrl("/www/main.van");
		} else {
			rv.setUrl("/www/member/join.van");
		}
		mv.setView(rv);
		return mv;
	}
	
	@RequestMapping("join.van")
	public ModelAndView joinForm(ModelAndView mv) {
		mv.setViewName("member/join");
		
		return mv;
	}
	@RequestMapping("showName.van")
	public ModelAndView showName(ModelAndView mv) {
		List<String>list = mDAO.idList();
		mv.addObject("mno", list);
		mv.setViewName("member/showName");
		
		return mv;
	}
	
//	@RequestMapping("showNameProc.van")
//	public ModelAndView snowName(ModelAndView mv, String m_No) {
//		System.out.println(m_No);
//		String mno = mDAO.showName(m_No);
//		
//		mv.addObject("mno", mno);
//		mv.setViewName("member/showName");
//		return mv;
//	}
	


	
	@RequestMapping("showNameProc.van")
	public ModelAndView showAvatar(ModelAndView mv, MemberVO vo) {
		
		vo = mDAO.showAvatar(vo);
		System.out.println(vo);
		mv.addObject("ava", vo);
		mv.setViewName("member/showName");
		return mv;
	}
	
	@RequestMapping("fileUp.van")
	public void fileUp(MultipartFile upfile, HttpSession session) {
		try {
			fileSrvc.singleUpProc(upfile, session);			
		} catch (Exception e) {}
	}

	
}
