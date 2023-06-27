package org.kosta.icandoit.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.icandoit.model.MemberDAO;
import org.kosta.icandoit.model.MemberVO;

public class UpdateMemberController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MemberDAO memberDAO = MemberDAO.getInstance();
		if (request.getMethod().equals("POST") == false)
			throw new ServletException("잘못된 접근입니다.");
		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("memberVO") == null) {
			System.out.println("비인증");
			return "redirect:LoginForm.do";
		}
		MemberVO member = (MemberVO) session.getAttribute("memberVO");
		String id = member.getId();
		String password = request.getParameter("password");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String nickName = request.getParameter("nickName");
		MemberVO memberVO = new MemberVO(id, password, address, phone, nickName, null);
		memberDAO.updateMember(memberVO);
		return "Login.do";
	}

}
