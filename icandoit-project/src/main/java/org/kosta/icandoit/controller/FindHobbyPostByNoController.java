package org.kosta.icandoit.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.icandoit.model.MemberVO;
import org.kosta.icandoit.model.PostDAO;
import org.kosta.icandoit.model.PostVO;

public class FindHobbyPostByNoController implements Controller {
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("memberVO") == null) {
			System.out.println("비인증");
			return "redirect:FindPostList.do";
		}
		long no = Long.parseLong(request.getParameter("postNo"));
		MemberVO memberVO = (MemberVO) session.getAttribute("memberVO");
		String nickName = memberVO.getNickName();
		ArrayList<String> joinClubMember = PostDAO.getInstance().findJoinClubMember(no);
		if (joinClubMember.contains(nickName)) {
			request.setAttribute("joinTF", "T");
		}
		PostVO post = PostDAO.getInstance().findPostDetail(no);
		request.setAttribute("postVO", post);
		request.setAttribute("joinClubMember", joinClubMember);
		request.setAttribute("url", "post-detail.jsp");
		return "layout.jsp";
	}
}
