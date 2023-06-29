package org.kosta.icandoit.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.icandoit.model.PostDAO;
import org.kosta.icandoit.test.PaginationDemo;

public class FindHobbyPostListController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Cookie[] cookies = request.getCookies();
		String Status = null;
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("stsBtn")) {
					Status = cookie.getValue();

					break;
				}
			}
		}

		int buttonStatus = 0;
		String pageNo = request.getParameter("pageNo");

		if (Status == null) {
			buttonStatus = 0;
		} else {
			buttonStatus = Integer.parseInt(Status);
		}
		System.out.println(buttonStatus);
		PaginationDemo pagination = null;
		long totalPostCount = PostDAO.getInstance().findTotalPostCount();

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
