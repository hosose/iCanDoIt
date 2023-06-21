package org.kosta.icandoit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.myproject.model.PostDAO;
import org.kosta.myproject.model.PostVO;

public class FindPostByNoController implements Controller {
	@SuppressWarnings("null")
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("mvo") == null) {
			System.out.println("비인증");
			return "redirect:FindPostList.do";
		}

		long no = Long.parseLong(request.getParameter("no"));
		/*
		 * Cookie oldCookie = null; Calendar expireDay = Calendar.getInstance();
		 * expireDay.add(Calendar.DAY_OF_MONTH, 1); expireDay.set(Calendar.HOUR_OF_DAY,
		 * 0); expireDay.set(Calendar.MINUTE, 0); expireDay.set(Calendar.SECOND, 0);
		 * Cookie[] cookies = request.getCookies(); if (cookies != null) { for (Cookie
		 * cookie : cookies) { if (cookie.getName().equals("boardView")) { oldCookie =
		 * cookie; } } } if (oldCookie != null) { if
		 * (!oldCookie.getValue().contains(String.valueOf(no) + "/")) {
		 * PostDAO.getInstance().updateHits(no); oldCookie.setValue(oldCookie.getValue()
		 * + no + "/"); oldCookie.setPath("/"); oldCookie.setMaxAge( ((int)
		 * (expireDay.getTimeInMillis() - System.currentTimeMillis())) / 1000 + 9 * 60 *
		 * 60); response.addCookie(oldCookie); } } else {
		 * BoardDAO.getInstance().updateHits(no); Cookie newCookie = new
		 * Cookie("boardView", String.valueOf(no) + "/"); newCookie.setPath("/");
		 * newCookie .setMaxAge(((int) (expireDay.getTimeInMillis() -
		 * System.currentTimeMillis())) / 1000 + 9 * 60 * 60);
		 * response.addCookie(newCookie); }
		 * 
		 * // @SuppressWarnings("unchecked") // ArrayList<Long> communityBoardNoList =
		 * (ArrayList<Long>) session.getAttribute("communityBoardNoList"); // if
		 * (communityBoardNoList.contains(no)) { // } else { //
		 * BoardDAO.getInstance().updateHits(no); // communityBoardNoList.add(no); //
		 * session.setAttribute("communityBoardNoList", communityBoardNoList); // }
		 */
		PostVO post = PostDAO.getInstance().findPostDetail(no);
		request.setAttribute("post", post);
		request.setAttribute("url", "post-detail.jsp");
		return "layout.jsp";
	}
}
