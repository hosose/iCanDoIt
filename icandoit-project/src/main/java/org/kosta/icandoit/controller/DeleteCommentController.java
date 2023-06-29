package org.kosta.icandoit.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.icandoit.model.CommentDAO;

public class DeleteCommentController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (request.getMethod().equals("POST") == false)
			throw new ServletException("POST 방식만 서비스 됩니다");

		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("memberVO") == null) {
			System.out.println("**비인증 상태이므로 서비스 할 수 없습니다**");
			return "redirect:FindHobbyPostList.do";
		}
		long postNo = Long.parseLong(request.getParameter("postNo"));
		long commentNo = Long.parseLong(request.getParameter("commentNo"));
		CommentDAO.getInstance().deleteCommentByNo(commentNo);
		return "redirect:FindHobbyPostByNo.do?postNo=" + postNo;
	}

}
