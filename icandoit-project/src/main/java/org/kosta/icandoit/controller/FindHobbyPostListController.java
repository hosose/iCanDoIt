package org.kosta.icandoit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.icandoit.model.PostDAO;
import org.kosta.icandoit.test.PaginationDemo;

public class FindHobbyPostListController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String Status = request.getParameter("stsBtn");
		System.out.println(Status);
		int buttonStatus = 0;
		String pageNo = request.getParameter("pageNo");

		if (Status == null) {
			buttonStatus = 0;
		} else {
			buttonStatus = Integer.parseInt(Status);
		}
		PaginationDemo pagination = null;
		long totalPostCount = PostDAO.getInstance().findTotalPostCount();
		long totalPostCountByStatus = PostDAO.getInstance().findTotalPostCountByStatus(buttonStatus);
		System.out.println(totalPostCountByStatus);

		if (pageNo == null) {
			pagination = new PaginationDemo(totalPostCountByStatus);
		} else {
			pagination = new PaginationDemo(totalPostCountByStatus, Long.parseLong(pageNo));
		}
		request.setAttribute("pagination", pagination);
		request.setAttribute("post", PostDAO.getInstance().findPostList(pagination,buttonStatus));
		request.setAttribute("url", "list.jsp");
		request.setAttribute("stsBtn", buttonStatus);
		return "layout.jsp";
	}

}
