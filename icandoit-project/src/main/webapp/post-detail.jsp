<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<section id="contact" class="contact">
	<div class="container" data-aos="fade-up">
		<div class="row" data-aos="fade-up" data-aos-delay="100">
			<div class="col-lg-4">
				<img alt="" class="mb-2 mb-lg-0" src="picture/${postVO.img }"
					style="border: 0; width: 100%; height: 70%;">
				<div>
					<c:choose>
						<c:when test="${sessionScope.memberVO.id==postVO.memberVO.id}">
							<button class="btn btn-success" style="margin-left: 30%;"
								onclick="updatePost()">수정</button>
							<button class="btn btn-danger" onclick="deletePost()"
								id="deleteBtn">삭제</button>
							<form id="deletePostForm" action="DeletePost.do" method="post">
								<input type="hidden" name="postNo" value="${postVO.postNo}">
								<script type="text/javascript">
									function deletePost() {
										if (confirm("삭제하시겠습니까?")) {
											document.getElementById(
													"deletePostForm").submit();
										}
									}
								</script>
							</form>
						</c:when>
						<c:when test="${joinTF eq'T'}">
							<form action="LeaveClub.do" method="post">
								<input type="hidden" name="postNo" value="${postVO.postNo}">
								<button class="btn btn-primary"
									style="padding: 20px; margin-left: 45%;" id="leaveClubBtn">모임
									참여 철회</button>
							</form>
						</c:when>
						<c:when test="${postVO.maxCount>postVO.currentCount}">
							<form action="JoinClub.do" method="post">
								<input type="hidden" name="postNo" value="${postVO.postNo}">
								<button class="btn btn-primary"
									style="padding: 20px; margin-left: 45%;" id="joinClubBtn">모임
									참여하기</button>
							</form>
						</c:when>
						<c:otherwise>
							<button class="btn btn-danger"
								style="padding: 25px; margin-left: 45%;">모집 마감</button>
						</c:otherwise>
					</c:choose>
					<form id="deletePostForm" action="DeletePost.do" method="post">
						<input type="hidden" name="no" value="${postVO.postNo}">
					</form>
					<form id="updatePostForm" action="UpdateHobbyPostForm.do"
						method="post">
						<input type="hidden" name="no" value="${postVO.postNo}">
					</form>
					<script type="text/javascript">
						$(function() {
							if ($("#deleteBtn").text() != "") {
								$("#joinClubBtn").css("margin", 10);
							}
						})
						function deletePost() {
							if (confirm("삭제하시겠습니까?")) {
								document.getElementById("deletePostForm")
										.submit();
							}
						}
						function updatePost() {
							if (confirm("수정하시겠습니까?")) {
								document.getElementById("updatePostForm")
										.submit();
							}
						}
					</script>
				</div>
			</div>
			<div class="col-lg-8">
				<div class="row">
					<div class="text-left">
						<c:choose>
							<c:when test="${postVO.gatheringType=='모집마감'}">
								<button style="float: left; margin: 5px 10px 10px 10px;"
									type="button" class="btn btn-danger btn-sm" id="gatheringType">모집마감</button>
							</c:when>
							<c:otherwise>
								<button style="float: left; margin: 5px 10px 10px 10px;"
									type="button" class="btn btn-success btn-sm" id="gatheringType">모집중</button>
							</c:otherwise>
						</c:choose>
						<span style="font-size: 30px; margin-top: 5px;">${postVO.title}</span>
						<span style="font-size: 25px;">👨‍👩</span> <span
							style="font-size: 25px;" id="currentCountSpan">
							${postVO.currentCount}</span>/ <span style="font-size: 25px;">${postVO.maxCount}</span>
					</div>
					<div class="col form-group">
						<p style="margin: 0 10px;">
							📅 ${postVO.gatheringPeriod} &nbsp;&nbsp;&nbsp;
							<c:choose>
								<c:when test="${likeTF eq'T' }">
									<form action="RevomeLike.do" method="post">
										<input type="hidden" name="postNo" value="${postVO.postNo}">
										<button class="btn btn-secondary" id="addLikeBtn">
											<img alt="" src="picture/pullHeart.png" width="25">&nbsp;찜제거
										</button>
									</form>

								</c:when>
								<c:otherwise>
									<form action="AddLike.do" method="post">
										<input type="hidden" name="postNo" value="${postVO.postNo}">
										<button class="btn btn-secondary" id="addLikeBtn">
											<img alt="" src="picture/emptyHeart.png" width="25">&nbsp;찜하기
										</button>
									</form>
								</c:otherwise>
							</c:choose>
						</p>
						<span style="margin: 0 10px;">${postVO.memberVO.nickName}</span>
					</div>
				</div>
				<table class="table table-bordered">
					<tbody style="width: 80%">
						<tr>
							<td><pre><font size="4">${postVO.postContent}</font> </pre></td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="box-content">
				<div class="card-content">
					<div class="clearfix">
						<h4 class="fw-bold py-3 mb-4">댓글</h4>
					</div>
				</div>
				<!-- card-content -->
				<div class="row">
					<!-- Basic Layout -->
					<div class="col-xxl">
						<div class="card mb-4">
							<div class="card-body">
								<form class="form-horizontal form-view" action="RegisterComment.do" role="form"
									method="post">
									<input type="hidden" name="postNo" value="${postVO.postNo}">
									<input type="hidden" name="id" value="${sessionScope.memberVO.id}">
									<div class="input-group margin-bottom-20">
										<input type="text" id="commentContent" name="commentContent" class="form-control" />
										<button value="" class="btn btn-primary" type="submit"
											id="commentAddBtn" style="margin: 0;">등록</button>
									</div>
								</form>
								<br>
								<table class="table">
									<thead>
										<tr>
											<th style="width: 65%;">content</th>
											<th style="width: 10%;">writer</th>
											<th style="width: 5%;"></th>
										</tr>
									</thead>
									<tbody class="table-border-bottom-0">
									<c:forEach var="item" items="${commentVO }">
										<tr >
											<td style="display: none;">${item.commentNo }</td>
											<td>${item.commentContent }</td>
											<td>${item.memberVO.nickName }</td>
											<td>
											<c:choose>
												<c:when test="${sessionScope.memberVO.id==item.memberVO.id}">
													<!-- <button type="button" class="btn me-2 btn-danger btn-sm" onclick="deleteComment()" style="margin:0;">X</button> -->
													<button type="submit" class="btn me-2 btn-danger" onclick="deleteComment()" style="padding: 0.25rem 0.5rem; font-size: 0.5rem; margin: 0;">X</button>
														<form id="deleteCommentForm" action="DeleteComment.do" method="post">
														<input type="hidden" name="commentNo" value="${item.commentNo}">
														<input type="hidden" name="postNo" value="${postVO.postNo}">
														</form>											
												</c:when>
											</c:choose>
											</td>
										</tr>
									</c:forEach>
									</tbody>
								</table>
							</div><!-- /.box-content -->
						</div><!-- card mb-4 -->
					</div><!-- col-xxl -->
				</div><!-- row -->
			</div><!-- box-content -->
		</div>
	</div>
</section>
<div id="preloader"></div>
<a href="#"
	class="back-to-top d-flex align-items-center justify-content-center"><i
	class="bi bi-arrow-up-short"></i></a>
<script src="assets/vendor/purecounter/purecounter_vanilla.js"></script>
<script src="assets/vendor/aos/aos.js"></script>
<script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="assets/vendor/glightbox/js/glightbox.min.js"></script>
<script src="assets/vendor/isotope-layout/isotope.pkgd.min.js"></script>
<script src="assets/vendor/swiper/swiper-bundle.min.js"></script>
<script src="assets/vendor/waypoints/noframework.waypoints.js"></script>
<script src="assets/vendor/php-email-form/validate.js"></script>
<script src="assets/js/main.js"></script>
<script type="text/javascript">
	function deleteComment() {
		if(confirm("댓글을 삭제하시겠습니까?")){
			console.log("댓글 삭제 버튼 눌림");
			document.getElementById("deleteCommentForm").submit();
		}
	}
</script>
</body>
</html>