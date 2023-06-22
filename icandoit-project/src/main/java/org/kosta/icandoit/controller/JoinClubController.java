package org.kosta.icandoit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.kosta.icandoit.model.PostDAO;
import org.kosta.icandoit.model.PostVO;

public class JoinClubController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String memberId = request.getParameter("memberId");
		long postNo = Long.parseLong(request.getParameter("postNo"));
		PostDAO.getInstance().joinClub(memberId, postNo);
		PostVO postVO = PostDAO.getInstance().findPostDetail(postNo);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("postVO", postVO);
		request.setAttribute("responsebody", jsonObject);
		return "AjaxView";
	}

}
