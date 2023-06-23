package org.kosta.icandoit.model;

public class CommentVO {
	private long commentNo;
	private String commentContent;
	private PostVO postVo;
	private MemberVO memberVO;

	public CommentVO() {
		super();
	}

	public CommentVO(long commentNo, String commentContent, PostVO postVo, MemberVO memberVO) {
		super();
		this.commentNo = commentNo;
		this.commentContent = commentContent;
		this.postVo = postVo;
		this.memberVO = memberVO;
	}

	public long getCommentNo() {
		return commentNo;
	}

	public void setCommentNo(long commentNo) {
		this.commentNo = commentNo;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public PostVO getPostVo() {
		return postVo;
	}

	public void setPostVo(PostVO postVo) {
		this.postVo = postVo;
	}

	public MemberVO getMemberVO() {
		return memberVO;
	}

	public void setMemberVO(MemberVO memberVO) {
		this.memberVO = memberVO;
	}

	@Override
	public String toString() {
		return "CommentVO [commentNo=" + commentNo + ", commentContent=" + commentContent + ", postVo=" + postVo
				+ ", memberVO=" + memberVO + "]";
	}
}
