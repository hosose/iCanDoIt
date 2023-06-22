package org.kosta.icandoit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.icandoit.model.PostDAO;
import org.kosta.icandoit.model.PostVO;

public class FindPostByNoController implements Controller {
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		/*
		 * HttpSession session = request.getSession(false); if (session == null ||
		 * session.getAttribute("mvo") == null) { System.out.println("비인증"); return
		 * "redirect:FindPostList.do"; }
		 */
		// long no = Long.parseLong(request.getParameter("no"));
		PostVO postVO = PostDAO.getInstance().findPostDetail(1);
		request.setAttribute("postVO", postVO);
		request.setAttribute("url", "post-detail.jsp");
		return "layout.jsp";
	}
}
