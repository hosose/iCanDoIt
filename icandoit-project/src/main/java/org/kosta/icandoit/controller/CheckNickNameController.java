package org.kosta.icandoit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.icandoit.model.MemberDAO;

public class CheckNickNameController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String nickName = request.getParameter("nickName");
		int checkResult = MemberDAO.getInstance().checkNickName(nickName);
		String result = null;
		if (checkResult == 0)
			result = "ok";// 기존 닉네임 없으면 사용 가능
		else {
			result = "fail";
		}
		request.setAttribute("responsebody", result);
		return "AjaxView";
	}

}
