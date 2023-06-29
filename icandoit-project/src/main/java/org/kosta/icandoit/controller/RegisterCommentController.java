package org.kosta.icandoit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.icandoit.model.CommentDAO;
import org.kosta.icandoit.model.CommentVO;
import org.kosta.icandoit.model.MemberVO;
import org.kosta.icandoit.model.PostVO;

public class RegisterCommentController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession(false);

		MemberVO memberVO = (MemberVO) session.getAttribute("memberVO");
		String id = memberVO.getId();
		long postNo = Long.parseLong(request.getParameter("postNo"));
		String commentContent = request.getParameter("commentContent");

		CommentVO vo = new CommentVO();
		vo.setCommentContent(commentContent);
		MemberVO mvo = new MemberVO();
		mvo.setId(id);
		vo.setMemberVO(mvo);
		PostVO pvo = new PostVO();
		pvo.setPostNo(postNo);
		vo.setPostVo(pvo);
		CommentDAO.getInstance().registerComment(vo);
		System.out.println("댓글 등록 완료");

//		request.setAttribute("responsebody", vo);
		return "redirect:FindHobbyPostByNo.do?postNo=" + postNo;
	}

}
