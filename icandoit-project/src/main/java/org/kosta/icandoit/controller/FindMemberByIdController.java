//package org.kosta.icandoit.controller;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.kosta.icandoit.model.MemberDAO;
//import org.kosta.icandoit.model.MemberVO;
//
//public class FindMemberByIdController implements Controller {
//
//	@Override
//	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		String id = request.getParameter("id");
//		MemberVO memberVO = MemberDAO.getInstance().findMemberById(id);
//		if (memberVO == null)
//			// TODO Auto-generated method stub
//			return null;
//	}
//
//}
