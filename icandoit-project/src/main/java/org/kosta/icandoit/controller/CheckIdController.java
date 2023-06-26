package org.kosta.icandoit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.icandoit.model.MemberDAO;

public class CheckIdController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		int checkResult = MemberDAO.getInstance().checkId(id);
		String result = null;
		if (checkResult == 0)
			result = "ok";
		else
			result = "fail";
		request.setAttribute("responsebody", result);
		return "AjaxView";
	}

}
