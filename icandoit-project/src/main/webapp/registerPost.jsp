<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<section id="contact" class="contact">
	<div class="container" data-aos="fade-up">

		<div class="section-title">
			<h2>Contact</h2>
			<h3>
				<span>Contact Us</span>
			</h3>
			<p>Ut possimus qui ut temporibus culpa velit eveniet modi omnis
				est adipisci expedita at voluptas atque vitae autem.</p>
		</div>

		<div class="row" data-aos="fade-up" data-aos-delay="100">
			<div class="col-lg-6">
				<div class="info-box mb-4">
					<i class="bx bx-map"></i>
					<h3>Our Address</h3>
					<p>A108 Adam Street, New York, NY 535022</p>
				</div>
			</div>

			<div class="col-lg-3 col-md-6">
				<div class="info-box  mb-4">
					<i class="bx bx-envelope"></i>
					<h3>Email Us</h3>
					<p>contact@example.com</p>
				</div>
			</div>

			<div class="col-lg-3 col-md-6">
				<div class="info-box  mb-4">
					<i class="bx bx-phone-call"></i>
					<h3>Call Us</h3>
					<p>+1 5589 55488 55</p>
				</div>
			</div>

		</div>

		<div class="row" data-aos="fade-up" data-aos-delay="100">
			<!-- LG MD SM -->
			<div class="col-lg-4">
				<!--             <iframe class="mb-4 mb-lg-0" src="https://www.google.com/maps/embed?pb=!1m14!1m8!1m3!1d12097.433213460943!2d-74.0062269!3d40.7101282!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x0%3A0xb89d1fe6bc499443!2sDowntown+Conference+Center!5e0!3m2!1smk!2sbg!4v1539943755621" frameborder="0" style="border:0; width: 100%; height: 384px;" allowfullscreen></iframe> -->
				<img alt="" class="mb-2 mb-lg-0"
					src="https://blog.kakaocdn.net/dn/0mySg/btqCUccOGVk/nQ68nZiNKoIEGNJkooELF1/img.jpg"
					style="border: 0; width: 100%; height: 384px;">
			</div>

			<div class="col-lg-8">
				<form action="forms/contact.php" method="post" role="form"
					class="php-email-form">

					<div class="text-left">
						<button type="button" class="btn btn-primary">모집중</button>
					</div>

					<div class="row">
						<div class="col form-group">
							<input type="text" name="name" class="form-control" id="name"
								placeholder="Your 이름" required>
						</div>
						<div class="col form-group">
							<input type="email" class="form-control" name="email" id="email"
								placeholder="Your 이메일" required>
						</div>
						<div class="col form-group">
							<input type="date" class="form-control" name="date" id="date"
								placeholder="Your 날짜" required>
						</div>
					</div>
					<div class="form-group">
						<input type="text" class="form-control" name="subject"
							id="subject" placeholder="제목을 입력해보세요오" required>
					</div>
					<div class="form-group">
						<textarea class="form-control" name="message" rows="5"
							placeholder="메시지를 입력해보세요오" required></textarea>
					</div>
					<div class="my-3">
						<div class="loading">Loading</div>
						<div class="error-message"></div>
						<div class="sent-message">Your message has been sent. Thank
							you!</div>
					</div>
					<div class="text-center">
						<button type="submit">메시지 보내주세요오</button>
					</div>
					<h3>
						<span>댓글</span>
					</h3>
					<div class="form-group">
						<input type="text" class="comment" name="comment" id="comment"
							placeholder="comment를 입력해주세요오">
					</div>
					<div class="text-left">
						<button type="submit">comment를 보내주세요오dddd</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</section>