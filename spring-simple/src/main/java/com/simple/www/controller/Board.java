package com.simple.www.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.util.NestedServletException;

import com.simple.www.dao.BoardDAO;
import com.simple.www.vo.BoardVO;

@Controller
@RequestMapping("/board/")
public class Board {
	@Autowired
	BoardDAO bDAO;

	@RequestMapping("visitor.van")
	public ModelAndView visitor(ModelAndView mv) {
		List<BoardVO> list = bDAO.visitorList();
		mv.addObject("bmno", 0);
		mv.addObject("LIST", list);
		mv.setViewName("member/showName");
		return mv;
	}

	@RequestMapping("visitorEdit.van")
	public ModelAndView visitorEdit(ModelAndView mv, BoardVO vo) throws NestedServletException {
		List<BoardVO> list = bDAO.visitorList();
		try {
			bDAO.visitorEdit(vo);
			list = bDAO.visitorList();
			mv.addObject("bmno", 0);
		} catch (Exception e) {
			mv.addObject("bmno", 1);
		}

		mv.addObject("LIST", list);
		mv.setViewName("member/showName");
		return mv;
	}
}
