<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<section id="contact" class="contact"
	style="overflow: initial; width: 920px; margin: auto">
	<div class="row" data-aos="fade-up" data-aos-delay="100">
		<!-- LG MD SM -->
		<form action="RegisterHobbyPost.do" method="post" role="form"
			style="display: flex; align-items: center;">
			<div class="col-lg-3">
				<img alt="" class="mb-2 mb-lg-0"
					src="https://blog.kakaocdn.net/dn/0mySg/btqCUccOGVk/nQ68nZiNKoIEGNJkooELF1/img.jpg"
					style="border: 0; width: 100%; height: 100%;">
				<div class="text-center">
					<button type="button" class="btn btn-primary">이미지 넣기</button>
					<div class="col form-group">
						<input type="text" name="img" class="form-control" id="img"
							placeholder="이미지테스트용" required="required">
							<!-- <input type="hidden" value="https://blog.kakaocdn.net/dn/0mySg/btqCUccOGVk/nQ68nZiNKoIEGNJkooELF1/img.jpg"> -->
					</div>
					<!-- 					
				<div class="col form-group">
						<input type="hidden" name="gatheringType" class="form-control"
							id="gatheringType" required="required" value="모집중">
					</div>
					gatheringType 
					-->
				</div>
			</div>
			<div class="col-lg-9">
				<div class="row">
					<div class="col form-group">
						<input type="text" name="categoryType" class="form-control"
							id="categoryType" placeholder="카테고리" required="required">
					</div>
					<div class="col form-group">

						<!-- <p class="form-control" id="name">사용자 이름</p> -->
						<input type="date" class="form-control" name="gatheringPeriod"
							id="gatheringPeriod" value="2023-06-30" min="2023-06-30"
							max="2025-06-30">
						<!-- 								<p><input type="date" value="2019-09-22" min="2019-09-10" max="2019-09-25"></p> -->
					</div>
					<div class="col form-group">
						<input type="text" name="currentCount" class="form-control"
							id="currentCount" placeholder="최소인원" required="required">
					</div>
					<div class="col form-group">
						<input type="text" name="maxCount" class="form-control"
							id="maxCount" placeholder="최대인원" required="required">
					</div>
				</div>
				<!--===========게시판 제목내용 ==================== -->
				<div class="form-group">
					<input type="text" class="form-control" name="title" id="title"
						placeholder="제목을 입력해보세요" required="required">
				</div>
				<div class="form-group">
					<textarea class="form-control" name="postContent" rows="10"
						placeholder="메시지를 입력해보세요" required="required"></textarea>
				</div>

				<div class="text-center">
					<button type="submit" class="btn btn-primary">등록</button>
					<button type="reset" class="btn btn-primary">취소</button>
				</div>
			</div>
		</form>
	</div>
</section>