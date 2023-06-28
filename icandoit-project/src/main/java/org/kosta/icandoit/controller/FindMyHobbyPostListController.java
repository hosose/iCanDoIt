package org.kosta.icandoit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.icandoit.model.MemberVO;
import org.kosta.icandoit.model.MyPagePagination;
import org.kosta.icandoit.model.PostDAO;

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
		String pageNo = request.getParameter("pageNo");
		MyPagePagination pagination = null;
		long totalMyClubCount = PostDAO.getInstance().findTotalMyClubCount(id);
		if (pageNo == null) {
			pagination = new MyPagePagination(totalMyClubCount);
		} else {
			pagination = new MyPagePagination(totalMyClubCount, Long.parseLong(pageNo));
		}
		request.setAttribute("pagination", pagination);
		request.setAttribute("post", PostDAO.getInstance().findMyHobbyPostList(id, pagination));
		request.setAttribute("url", "member-joining-club.jsp");
		return "layout.jsp";
	}

}
