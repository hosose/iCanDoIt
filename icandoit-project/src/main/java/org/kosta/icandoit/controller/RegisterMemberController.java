package org.kosta.icandoit.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.icandoit.model.MemberDAO;
import org.kosta.icandoit.model.MemberVO;

public class RegisterMemberController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MemberDAO memberDAO = MemberDAO.getInstance();

		// query string 막기
		if (request.getMethod().equals("POST") == false)
			throw new ServletException("POST 방식만 서비스 됩니다.");

		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String nickName = request.getParameter("nickName");
		String name = request.getParameter("name");

		// 같은 아이디가 존재 할 때
		if (memberDAO.findMemberById(id) != null) {
			return "";
		}
		// 존재하지 않을 때
		MemberVO memberVO = new MemberVO(id, password, address, phone, nickName, name);
		memberDAO.registerMember(memberVO);
		return "redirect:Login.do";
	}

}
