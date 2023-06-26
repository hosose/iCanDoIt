package org.kosta.icandoit.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.icandoit.model.MemberVO;
import org.kosta.icandoit.model.PostDAO;

public class JoinClubController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (request.getMethod().equals("POST") == false)
			throw new ServletException("POST 방식만 서비스 됩니다");

		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("memberVO") == null) {
			System.out.println("비인증");
			return "redirect:LoginForm.do";
		}

		MemberVO memberVO = (MemberVO) session.getAttribute("memberVO");
		String id = memberVO.getId();
		long postNo = Long.parseLong(request.getParameter("postNo"));
		int maxCount = PostDAO.getInstance().findPostmaxCount(postNo);
		int currentCount = PostDAO.getInstance().findPostCurrentCount(postNo);
		if (maxCount == currentCount) {
			System.out.println("인원수 초과");
			return "redirect:FindHobbyPostByNo.do?postNo=" + postNo;
		}
		PostDAO.getInstance().joinClub(id, postNo);
		currentCount = PostDAO.getInstance().findPostCurrentCount(postNo);
		maxCount = PostDAO.getInstance().findPostmaxCount(postNo);
		if (maxCount == currentCount) {
			PostDAO.getInstance().updataGatheringType(postNo);
		}
		return "redirect:FindHobbyPostByNo.do?postNo=" + postNo;
	}
}
