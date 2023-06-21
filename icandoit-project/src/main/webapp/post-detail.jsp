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
				</div>
				<div class="col-lg-8">
					<form action="forms/contact.php" method="post" role="form"
						class="php-email-form">
						<!--======================== 모집여부 button ==================  -->

						<div class="row">
							<div class="text-left">
								<button type="button" class="btn btn-primary">모집여부 무조건 모집중</button>
							</div>
							<div class="col form-group">
								<input type="text" name="name" class="form-control" id="name"
									placeholder="Your 모집기간" required>
							</div>
						</div>

						<!--============첫줄 ====================-->
						<div class="row">
							<div class="col form-group">
								<input type="text" name="name" class="form-control" id="name"
									placeholder="Your 이름" required>
							</div>
							<div class="col form-group">
								<input type="email" class="form-control" name="email" id="email"
									placeholder="Your 이메일">
							</div>
							<div class="col form-group">
								<input type="date" class="form-control" name="date" id="date"
									placeholder="Your 날짜" required>
							</div>
						</div>
						<div class="col form-group">
							<input type="email" class="form-control" name="email" id="email"
								placeholder="Your 컨텐츠">
						</div>
						<div class="col form-group">
							<input type="email" class="form-control" name="email" id="email"
								placeholder="Your 이미지">
						</div>
						<div class="col form-group">
							<input type="email" class="form-control" name="email" id="email"
								placeholder="Your 카테고리">
						</div>
						<!--============두번째 줄 ====================-->

						<div class="row">
							<div class="col form-group">
								<input type="text" class="form-control" name="date" id="date"
									placeholder="최소인원" required>
							</div>
							<div class="col form-group">
								<input type="text" class="form-control" name="date" id="date"
									placeholder="최대인원" required>
							</div>
						</div>
						<div class="col form-group">
							<input type="text" class="form-control" name="date" id="date"
								placeholder="게시글등록시간 자동으로" required>
						</div>
<!--============제목 내용  입력칸 ====================-->
						<div class="form-group">
							<input type="text" class="form-control" name="subject"
								id="subject" placeholder="제목을 입력해보세요오" required>
						</div>
						<div class="form-group">
							<textarea class="form-control" name="message" rows="5"
								placeholder="메시지를 입력해보세요오" required></textarea>
						</div>

						<!-- 						
								<div class="my-3">
								<div class="loading">Loading</div>
								<div class="error-message"></div>
								<div class="sent-message">Your message has been sent.
									Thank you!</div>
							</div> 
							-->
						<div class="text-center">
							<button type="submit">메시지 보내주세요오</button>
						</div>
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
						placeholder="comment를 입력해주세요오">
				</div>
				<div class="col form-group">
					<button type="submit">comment를 보내주세요오dddd</button>
				</div>
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