package org.kosta.icandoit.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.icandoit.model.MemberVO;
import org.kosta.icandoit.model.PostDAO;
import org.kosta.icandoit.model.PostVO;

public class FindPostByNoController implements Controller {
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("mvo") == null) {
			System.out.println("비인증");
			return "redirect:FindPostList.do";
		}
		MemberVO memberVO = (MemberVO) session.getAttribute("memberVO");
		long postNo = Long.parseLong(request.getParameter("no"));
		PostVO postVO = PostDAO.getInstance().findPostDetail(postNo);
		ArrayList<String> joinClubMember = PostDAO.getInstance().findJoinClubMember(postNo);
		if (joinClubMember.contains(memberVO.getNickName())) {
			request.setAttribute("joinClubTF", "ok");
		}
		request.setAttribute("postVO", postVO);
		request.setAttribute("url", "post-detail.jsp");
		return "layout.jsp";
	}
}
