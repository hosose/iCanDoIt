<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- ======= Contact Section ======= -->
<section id="contact" class="contact">
	<div class="container" data-aos="fade-up">
		<div style="width: 50%">
			<form action="forms/contact.php" method="post" role="form"
				class="php-email-form">
				<div class="form-group">
					<input type="text" class="form-control" name="user_id" id="user_id"
						placeholder="아이디를 입력하세요." required>
				</div>
				<div class="form-group">
					<input type="password" class="form-control" name="user_pw"
						id="user_pw" placeholder="비밀번호를 입력하세요." required>
				</div>
				<div class="text-center">
					<button type="submit">로그인</button>
				</div> <br><br>
				<div class="text-center">
					<a href="RegisterMemberForm.do" style="text-decoration: underline;">회원가입 하러 가기</a>
				</div>
			</form>
		</div>
	</div>
</section>
