package org.kosta.icandoit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.icandoit.model.PostDAO;
import org.kosta.icandoit.test.PaginationDemo;

public class FindHobbyPostListController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String pageNo = request.getParameter("pageNo");

		PaginationDemo pagination = null;
		long totalPostCount = PostDAO.getInstance().findTotalPostCount();
		int buttonStatus = 0;

		if (pageNo == null) {
			pagination = new PaginationDemo(totalPostCount, buttonStatus);
		} else {
			pagination = new PaginationDemo(totalPostCount, Long.parseLong(pageNo), buttonStatus);
		}

		request.setAttribute("pagination", pagination);
		request.setAttribute("post", PostDAO.getInstance().findPostList(pagination));
		request.setAttribute("url", "list.jsp");
		return "layout.jsp";
	}

}
