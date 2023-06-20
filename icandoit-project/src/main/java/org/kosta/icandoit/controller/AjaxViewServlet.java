package org.kosta.icandoit.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Ajax 요청에 대한 응답을 담당하는 서블릿 <br>
 * ( Ajax 응답은 페이지가 아니라 데이터만 하므로 서블릿이 적합 )<br>
 * 데이터 형식은 String or JSON 으로 한다 request 영역에 responsebody name 으로 정보를 가져와
 * out.print() 로 응답한다<br>
 */
@WebServlet("/AjaxView")
public class AjaxViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		Object responseData = request.getAttribute("responsebody");
		if (responseData != null)
			out.print(responseData);
		out.close();
	}
}