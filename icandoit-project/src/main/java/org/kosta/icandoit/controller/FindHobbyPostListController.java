package org.kosta.icandoit.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.icandoit.model.PostDAO;
import org.kosta.icandoit.test.PaginationDemo;

public class FindHobbyPostListController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Cookie[] cookies = request.getCookies(); // Get all cookies sent with the request
		String Status = null;
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("stsBtn")) { // Replace "cookieName" with the actual name of the cookie
					Status = cookie.getValue(); // Get the value of the cookie
					// Process the cookie value as needed
					break; // If you have found the desired cookie, you can stop iterating
				}
			}
		}

		int buttonStatus = 0;
		String pageNo = request.getParameter("pageNo");
		// statusButton이 0이나 1이나 2값이 아니면 error리턴만들기
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
