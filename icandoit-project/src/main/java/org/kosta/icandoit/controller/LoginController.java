package org.kosta.icandoit.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.icandoit.model.MemberDAO;
import org.kosta.icandoit.model.MemberVO;

public class LoginController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (request.getMethod().equals("POST") == false)
			throw new ServletException("잘못된 접근입니다.");

		String id = request.getParameter("id");
		String password = request.getParameter("password");
		MemberVO vo = MemberDAO.getInstance().login(id, password);
		String path = null;
		if (vo == null) {
			// 회원 정보 없을 경우 이동할 경로
			// path
			System.out.println("로그인 실패:아이디가 없습니다.");
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("memberVO", vo);
			System.out.println(id+"님 로그인 성공");
			path = "redirect:Home.do";
		}
		return path;
	}

}
