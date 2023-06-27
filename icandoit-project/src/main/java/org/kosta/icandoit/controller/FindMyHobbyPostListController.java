package org.kosta.icandoit.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.icandoit.model.MemberVO;
import org.kosta.icandoit.model.PostDAO;
import org.kosta.icandoit.model.PostVO;

public class FindMyHobbyPostListController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("memberVO") == null) {
			System.out.println("비인증");
			return "redirect:LoginForm.do";
		}
		MemberVO memberVO = (MemberVO) session.getAttribute("memberVO");
		String id = memberVO.getId();
		ArrayList<PostVO> list = PostDAO.getInstance().findMyHobbyPostList(id);
		request.setAttribute("post", list);
		request.setAttribute("url", "member-joining-club.jsp");
		return "layout.jsp";
	}

}
