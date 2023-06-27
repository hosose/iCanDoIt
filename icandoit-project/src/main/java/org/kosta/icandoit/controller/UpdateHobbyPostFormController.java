package org.kosta.icandoit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.icandoit.model.PostDAO;
import org.kosta.icandoit.model.PostVO;

public class UpdateHobbyPostFormController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setAttribute("url", "post-update.jsp");
		String postNo =request.getParameter("no");
		PostVO postVO =PostDAO.getInstance().findHobbyPostByNo(Long.valueOf(postNo));
		request.setAttribute("PostVO", postVO);
		return "layout.jsp";
	}

}
