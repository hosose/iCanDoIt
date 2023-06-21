<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<section id="contact" class="contact">
	<div class="container" data-aos="fade-up">
		<div class="row" data-aos="fade-up" data-aos-delay="100">
			<!-- 	LG MD SM -->
			<div class="col-lg-4">
				<!-- 			            <iframe class="mb-4 mb-lg-0" src="https://www.google.com/maps/embed?pb=!1m14!1m8!1m3!1d12097.433213460943!2d-74.0062269!3d40.7101282!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x0%3A0xb89d1fe6bc499443!2sDowntown+Conference+Center!5e0!3m2!1smk!2sbg!4v1539943755621" frameborder="0" style="border:0; width: 100%; height: 384px;" allowfullscreen></iframe> -->
				<img alt="" class="mb-2 mb-lg-0"
					src="https://blog.kakaocdn.net/dn/0mySg/btqCUccOGVk/nQ68nZiNKoIEGNJkooELF1/img.jpg"
					frameborder="0" style="border: 0; width: 100%; height: 70%;">
				<button class="btn btn-primary"
					style="padding: 25px; margin-left: 45%;">모임 참여하기</button>
			</div>
			<div class="col-lg-8">
				<form action="forms/contact.php" method="post" role="form"
					class="php-email-form">
					<!--======================== 모집여부 button ==================  -->

					<div class="row">
						<div class="text-left">
							<button type="button" class="btn btn-success"
								style="float: left; margin: 5px 10px 10px 10px;">모집중</button>
							<span style="font-size: 30px; margin-top: 5px;">제목 6월
								23일당구모임</span> <span style="font-size: 25px;">👨‍👩 1/4</span>
						</div>
						<div class="col form-group">
							<p style="margin: 0 10px;">
								📅 2023-06-23 &nbsp;&nbsp;&nbsp;
								<button class="btn btn-danger">💕 찜</button>
							</p>
							<span style="margin: 0 10px;">아이유</span>
						</div>
					</div>
					<table class="table table-bordered">
					<tbody  style="width: 80%">
					<tr>
						<%-- 
					pre tag : db에 저장된 글형식 그대로 표현 (줄바꿈 등이 표현됨) 
									pre tag 라인인 행변경없이 한라인으로 표현해야 함
					--%>
						<td >
<pre><font size="4">안녕하세요. 25세 호소세입니다.
안녕하세요. 25세 호소세입니다.
안녕하세요. 25세 호소세입니다.안녕하세요. 25세 호소세입니다.</font></pre></td>
					</tr>
					</tbody>
					</table>
				</form>
			</div>
			<form action="forms/contact.php" method="post" role="form"
				class="php-email-form">
				<h3>
					<span>댓글</span>
				</h3>
				<div class="row">
					<div class="col form-group">
						<input type="text" class="comment" name="comment" id="comment"
							placeholder="댓글 작성" style="width:100%;">
					</div>
					<div class="col form-group">
						<button type="submit">댓글 작성</button>
					</div>
				</div>
				<div>
				<hr>
				<p><b>호소세</b></p>
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

<!-- Vendor JS Files -->
<script src="assets/vendor/purecounter/purecounter_vanilla.js"></script>
<script src="assets/vendor/aos/aos.js"></script>
<script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="assets/vendor/glightbox/js/glightbox.min.js"></script>
<script src="assets/vendor/isotope-layout/isotope.pkgd.min.js"></script>
<script src="assets/vendor/swiper/swiper-bundle.min.js"></script>
<script src="assets/vendor/waypoints/noframework.waypoints.js"></script>
<script src="assets/vendor/php-email-form/validate.js"></script>

<!-- Template Main JS File -->
<script src="assets/js/main.js"></script>

</body>
</html>