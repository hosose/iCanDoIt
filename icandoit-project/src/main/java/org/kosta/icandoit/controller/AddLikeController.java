package org.kosta.icandoit.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.icandoit.model.LikeDAO;
import org.kosta.icandoit.model.MemberVO;

public class AddLikeController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (request.getMethod().equals("POST") == false)
			throw new ServletException("POST 방식만 서비스 됩니다.");

		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("memberVO") == null) {
			return "redirect:LoginForm.do";
		}

		MemberVO vo = (MemberVO) session.getAttribute("memberVO");
		String id = vo.getId();
		long postNo = Long.parseLong(request.getParameter("postNo"));
		LikeDAO.getInstance().AddLike(id, postNo);
		return "redirect:FindHobbyPostByNo.do?postNo=" + postNo;
	}

}
