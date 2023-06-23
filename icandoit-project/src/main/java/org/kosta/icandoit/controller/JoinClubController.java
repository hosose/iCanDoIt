package org.kosta.icandoit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.kosta.icandoit.model.PostDAO;

public class JoinClubController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("mvo") == null) {
			System.out.println("비인증");
			return "redirect:FindPostList.do";
		}
		String memberId = (String) session.getAttribute("id");
		long postNo = Long.parseLong(request.getParameter("postNo"));
		int maxCount = PostDAO.getInstance().findPostmaxCount(postNo);
		int currentCount = PostDAO.getInstance().findPostCurrentCount(postNo);
		if (maxCount == currentCount) {
			System.out.println("인원수 초과");
			return "redirect:FindPostByNo.do?no=" + postNo;
		}
		PostDAO.getInstance().joinClub(memberId, postNo);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("currentCount", currentCount);
		request.setAttribute("responsebody", jsonObject);
		return "AjaxView";
	}
}
