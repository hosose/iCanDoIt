package org.kosta.icandoit.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.icandoit.model.MemberVO;
import org.kosta.icandoit.model.PostVO;

public class RegisterHobbyPostController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		if(request.getMethod().equals("POST")==false)
//			throw new ServletException("POST 방식만 서비스 됩니다");
		
		HttpSession session=request.getSession(false);
//		if(session==null||session.getAttribute("memberVO")==null) {
//			System.out.println("**비인증 상태이므로 게시글 전송 할 수 없습니다**");
//			return "redirect:FindPostByNo.do";
//		}	
//		long postNo;
		String title=request.getParameter("title");
		String postContent=request.getParameter("postContent");
		String img=request.getParameter("img");
//		String gatheringType=request.getParameter("gatheringType");
		String gatheringPeriod=request.getParameter("gatheringPeriod");
		String categoryType=request.getParameter("categoryType");
//		String timePosted=request.getParameter("timePosted");
		String currentCount=request.getParameter("currentCount");
		String maxCount=request.getParameter("maxCount");
		MemberVO memberVO=(MemberVO) session.getAttribute("memberVO");
		
		PostVO post=new PostVO();
		post.setTitle(title);
		post.setPostContent(postContent);
		post.setImg(img);
		post.setGatheringType("모집중");
		post.setGatheringPeriod(gatheringPeriod);
		post.setCategoryType(categoryType);
//		post.setTimePosted(timePosted);
		post.setCurrentCount(Integer.parseInt(currentCount));
		post.setMaxCount(Integer.parseInt(maxCount));
		post.setMemberVO(memberVO);
		
		return "FinHobbyPostList.do";
	}

}
