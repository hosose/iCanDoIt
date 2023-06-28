package org.kosta.icandoit.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.icandoit.model.LikeVO;
import org.kosta.icandoit.model.MemberDAO;
import org.kosta.icandoit.model.MemberVO;

public class FindMyHobbyPostLikeListController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("memberVO") == null) {
			System.out.println("비인증");
			return "redirect:LoginForm.do";
		}
		MemberVO memberVO = (MemberVO) session.getAttribute("memberVO");
		String id = memberVO.getId();
		ArrayList<LikeVO> list = MemberDAO.getInstance().findMyHobbyPostLikeList(id);
		request.setAttribute("likeList", list);
		request.setAttribute("url", "member-like-club.jsp");
		return "layout.jsp";
	}

}
