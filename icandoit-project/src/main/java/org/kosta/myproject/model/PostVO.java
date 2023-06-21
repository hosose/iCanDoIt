package org.kosta.myproject.model;

public class PostVO {
	private long postNo;
	private String title;
	private String img;
	private String gatheringType;
	private String gatheringPeriod;
	private int currentCount;
	private int maxCount;
	private MemberVO memberVO;
	public PostVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PostVO(long postNo, String title, String img, String gatheringType, String gatheringPeriod, int currentCount,
			int maxCount, MemberVO memberVO) {
		super();
		this.postNo = postNo;
		this.title = title;
		this.img = img;
		this.gatheringType = gatheringType;
		this.gatheringPeriod = gatheringPeriod;
		this.currentCount = currentCount;
		this.maxCount = maxCount;
		this.memberVO = memberVO;
	}
	public long getPostNo() {
		return postNo;
	}
	public void setPostNo(long postNo) {
		this.postNo = postNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getGatheringType() {
		return gatheringType;
	}
	public void setGatheringType(String gatheringType) {
		this.gatheringType = gatheringType;
	}
	public String getGatheringPeriod() {
		return gatheringPeriod;
	}
	public void setGatheringPeriod(String gatheringPeriod) {
		this.gatheringPeriod = gatheringPeriod;
	}
	public int getCurrentCount() {
		return currentCount;
	}
	public void setCurrentCount(int currentCount) {
		this.currentCount = currentCount;
	}
	public int getMaxCount() {
		return maxCount;
	}
	public void setMaxCount(int maxCount) {
		this.maxCount = maxCount;
	}
	public MemberVO getMemberVO() {
		return memberVO;
	}
	public void setMemberVO(MemberVO memberVO) {
		this.memberVO = memberVO;
	}
	@Override
	public String toString() {
		return "PostVO [postNo=" + postNo + ", title=" + title + ", img=" + img + ", gatheringType=" + gatheringType
				+ ", gatheringPeriod=" + gatheringPeriod + ", currentCount=" + currentCount + ", maxCount=" + maxCount
				+ ", memberVO=" + memberVO + "]";
	}
	
	
}
