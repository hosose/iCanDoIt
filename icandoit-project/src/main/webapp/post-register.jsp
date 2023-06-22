<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<section id="contact" class="contact"
	style="overflow: initial; width: 920px; margin: auto">

	<div class="row" data-aos="fade-up" data-aos-delay="100">
		<!-- LG MD SM -->

		<form action="forms/contact.php" method="post" role="form"
			class="php-email-form" style=" display: flex;
    align-items: center;">
			<div class="col-lg-3">
				<img alt="" class="mb-2 mb-lg-0"
					src="https://blog.kakaocdn.net/dn/0mySg/btqCUccOGVk/nQ68nZiNKoIEGNJkooELF1/img.jpg"
					style="border: 0; width: 100%; height: 100%;">
				<div class="text-center">
					<button type="button" class="btn btn-primary">이미지 넣기</button>
				</div>
			</div>

			<!--======================이름 이메일  =================-->
			<div class="col-lg-9">
				<div class="row">
					<div class="col form-group">
						<p class="form-control" id="name">사용자 이름</p>
					</div>
					<div class="col form-group">
						<p class="form-control" id="email">사용자 이메일</p>
					</div>
				</div>
				<!--======================게시판 제목내용  =================-->
				<div class="row">
					<div class="col form-group">
						<input type="text" name="name" class="form-control" id="name"
							placeholder="카테고리" required>
					</div>

					<div class="col form-group">
						<input type="date" class="form-control" name="date" id="date"
							placeholder="모집 기간" required>
					</div>
					<div class="col form-group">
						<input type="text" name="name" class="form-control" id="name"
							placeholder="최소인원" required>
					</div>
					<div class="col form-group">
						<input type="text" name="name" class="form-control" id="name"
							placeholder="최대인원" required>
					</div>
				</div>
				<!--===========게시판 제목내용 ==================== -->
				<div class="form-group">
					<input type="text" class="form-control" name="subject" id="subject"
						placeholder="제목을 입력해보세요오" required>
				</div>
				<div class="form-group">
					<textarea class="form-control" name="message" rows="10"
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
			</div>
		</form>
	</div>
</section>