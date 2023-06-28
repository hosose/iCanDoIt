package org.kosta.icandoit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.icandoit.model.PostDAO;
import org.kosta.icandoit.model.PostVO;

public class UpdateHobbyPostController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session=request.getSession(false);
		
		String title =request.getParameter("title");
		String postContent=request.getParameter("postContent");
		String img=request.getParameter("img");
		String categoryType=request.getParameter("categoryType");
		String gatheringPeriod=request.getParameter("gatheringPeriod");
		String maxCount = request.getParameter("maxCount");
		String postNo= request.getParameter("postNo");
		
		PostVO post = new PostVO();
		post.setPostNo(Long.parseLong(postNo));
		post.setTitle(title);
		post.setPostContent(postContent);
		post.setImg(img);
		post.setCategoryType(categoryType);
		post.setGatheringPeriod(gatheringPeriod);
		post.setMaxCount(Integer.parseInt(maxCount));
		PostDAO.getInstance().updatePosting(post);
		return "redirect:FindHobbyPostByNo.do?postNo="+postNo;
	}
}
