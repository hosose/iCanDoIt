package org.kosta.icandoit.model;

public class PostVO {
	private long postNo;
	private String title;
	private String postContent;
	private String img;
	private String gatheringType;
	private String gatheringPeriod;
	private String categoryType;
	private String timePosted;
	private int currentCount;
	private int maxCount;
	private MemberVO memberVO;

	public PostVO() {
		super();
	}

	public PostVO(long postNo, String title, String postContent, String img, String gatheringType,
			String gatheringPeriod, String categoryType, String timePosted, int currentCount, int maxCount,
			MemberVO memberVO) {
		super();
		this.postNo = postNo;
		this.title = title;
		this.postContent = postContent;
		this.img = img;
		this.gatheringType = gatheringType;
		this.gatheringPeriod = gatheringPeriod;
		this.categoryType = categoryType;
		this.timePosted = timePosted;
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

	public String getPostContent() {
		return postContent;
	}

	public void setPostContent(String postContent) {
		this.postContent = postContent;
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

	public String getCategoryType() {
		return categoryType;
	}

	public void setCategoryType(String categoryType) {
		this.categoryType = categoryType;
	}

	public String getTimePosted() {
		return timePosted;
	}

	public void setTimePosted(String timePosted) {
		this.timePosted = timePosted;
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
		return "PostVO [postNo=" + postNo + ", title=" + title + ", postContent=" + postContent + ", img=" + img
				+ ", gatheringType=" + gatheringType + ", gatheringPeriod=" + gatheringPeriod + ", categoryType="
				+ categoryType + ", timePosted=" + timePosted + ", currentCount=" + currentCount + ", maxCount="
				+ maxCount + ", memberVO=" + memberVO + "]";
	}

}
