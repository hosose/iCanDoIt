package org.kosta.icandoit.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.kosta.icandoit.model.MemberVO;
import org.kosta.icandoit.model.PostDAO;

public class JoinClubController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("memberVO") == null) {
			System.out.println("비인증");
			return "redirect:LoginForm.do";
		}
		MemberVO memberVO = (MemberVO) session.getAttribute("memberVO");
		String nickName = memberVO.getNickName();
		String id = memberVO.getId();
		long postNo = Long.parseLong(request.getParameter("postNo"));
		ArrayList<String> joinClubMember = PostDAO.getInstance().findJoinClubMember(postNo);
		JSONObject jsonObject = new JSONObject();
		if (joinClubMember.contains(nickName)) {
			jsonObject.put("joinTF", "T");
			request.setAttribute("responsebody", jsonObject);
			return "AjaxView";
		}
		int maxCount = PostDAO.getInstance().findPostmaxCount(postNo);
		int currentCount = PostDAO.getInstance().findPostCurrentCount(postNo);
		if (maxCount == currentCount) {
			System.out.println("인원수 초과");
			return "redirect:FindHobbyPostByNo.do?no=" + postNo;
		}
		PostDAO.getInstance().joinClub(id, postNo);
		currentCount = PostDAO.getInstance().findPostCurrentCount(postNo);
		jsonObject.put("joinTF", "T");
		jsonObject.put("currentCount", currentCount);
		request.setAttribute("responsebody", jsonObject);
		return "AjaxView";
	}
}
