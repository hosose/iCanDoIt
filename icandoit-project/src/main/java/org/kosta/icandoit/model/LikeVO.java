package org.kosta.icandoit.model;

public class LikeVO {
	private long likeNo;
	private PostVO postVO;
	private MemberVO memberVO;

	public LikeVO() {
		super();
	}

	public LikeVO(long likeNo, PostVO postVO, MemberVO memberVO) {
		super();
		this.likeNo = likeNo;
		this.postVO = postVO;
		this.memberVO = memberVO;
	}

	public long getLikeNo() {
		return likeNo;
	}

	public void setLikeNo(long likeNo) {
		this.likeNo = likeNo;
	}

	public PostVO getPostVO() {
		return postVO;
	}

	public void setPostVO(PostVO postVO) {
		this.postVO = postVO;
	}

	public MemberVO getMemberVO() {
		return memberVO;
	}

	public void setMemberVO(MemberVO memberVO) {
		this.memberVO = memberVO;
	}

	@Override
	public String toString() {
		return "LikeVO [likeNo=" + likeNo + ", postVO=" + postVO + ", memberVO=" + memberVO + "]";
	}
}
