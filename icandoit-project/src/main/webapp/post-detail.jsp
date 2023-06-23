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
			<c:if test="${sessionScope.memberVO.id==postVO.memberVO.id}">
				<button  class="btn btn-success" style="margin : 0;" onclick="updatePost()">수정</button>
				<button class="btn btn-danger" onclick="deletePost()">삭제</button>
				<form id="deletePostForm" action="DeletePost.do" method="post"> 
				<input type="hidden" name="no" value="${postVO.no}">
				</form>
				<form id="updatePostForm" action="UpdatePostForm.do" method="post"> 
				<input type="hidden" name="no" value="${postVO.no}">
				</form>
				<script type="text/javascript">
				$("#joinBtn").css("margin", 0);
				function deletePost() {
					if(confirm("삭제하시겠습니까?")){
						document.getElementById("deletePostForm").submit();
					}
				}
				function updatePost() {
					if(confirm("수정하시겠습니까?")){
						document.getElementById("updatePostForm").submit();
					}
				}
				</script>
			</c:if>
				<button class="btn btn-primary"
				style="padding: 20px; margin-left: 50% " id="joinBtn">모임 참여하기</button>
			</div>
			</div>
			<div class="col-lg-8">
					<div class="row">
						<div class="text-left">
							<button type="button" class="btn btn-success"
								style="float: left; margin: 5px 10px 10px 10px;">${postVO.gatheringType}</button>
							<span style="font-size: 30px; margin-top: 5px;">${postVO.title}
							</span> <span style="font-size: 25px;">👨‍👩 ${postVO.currentCount}/${postVO.maxCount}</span>
						</div>
						<div class="col form-group">
							<p style="margin: 0 10px;">
								📅 ${postVO.gatheringPeriod} &nbsp;&nbsp;&nbsp;
								<button class="btn btn-danger">💕 찜</button>
							</p>
							<span style="margin: 0 10px;">${postVO.memberVO.id}</span>
						</div>
					</div>
					<table class="table table-bordered">
						<tbody style="width: 80%">
							<tr>
								<td><pre><font size="4">${postVO.postContent}</font></pre></td>
							</tr>
						</tbody>
					</table>
			</div>
			<form action="forms/contact.php" method="post" role="form"
				class="php-email-form">
				<h3>
					<span>댓글</span>
				</h3>
				<div class="row">
					<div class="col form-group">
						<input type="text" class="comment" name="comment" id="comment"
							placeholder="댓글 작성" style="width: 100%;">
					</div>
					<div class="col form-group">
						<button type="submit">댓글 작성</button>
					</div>
				</div>
				<div>
					<hr>
					<p>
						<b>호소세</b>
					</p>
					<p>재밌겠어요!</p>
					<hr>
				</div>
			</form>

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
</body>
</html>