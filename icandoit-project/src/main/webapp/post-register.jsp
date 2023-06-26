<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<section id="contact" class="contact"
	style="overflow: initial; width: 1100px; margin: auto">
	<div class="row" data-aos="fade-up" data-aos-delay="100" >
		<form action="RegisterHobbyPost.do" method="post" role="form"
			style="display: flex; align-items: center;">
			<div class="col-lg-4">
				<img alt="" class="mb-2 mb-lg-0"
					src="https://blog.kakaocdn.net/dn/0mySg/btqCUccOGVk/nQ68nZiNKoIEGNJkooELF1/img.jpg"
					style="border-radius: 5%; width: 100%; height: 100%;">
				<div class="text-center"
					style="display: flex; align-items: baseline;">
					이미지 등록 :
					<div class="col form-group">
						<div class="col form-group" style="margin-top: 15px;" >
							<input type="text" name="img" class="form-control" id="img"
								placeholder="이미지 넣기" required="required" >
						</div>
					</div>
				</div>
			</div>
			<div class="col-lg-8">
				<div class="row" style="align-items: baseline;">
					<div class="col form-group">
						<select name="categoryType" id="categoryType" class="form-control"
							required="required" >
							<optgroup label="카테고리">
								<option value="없음">카테고리 선택</option>
								<option value="운동">운동</option>
								<option value="독서">독서</option>
								<option value="게임">게임</option>
								<option value="주식">주식</option>
								<option value="캠핑">캠핑</option>
								<option value="기타">기타</option>
							</optgroup>
						</select>
					</div>
					모집 기간 :
					<div class="col form-group">
						<input type="date" class="form-control" name="gatheringPeriod"
							id="gatheringPeriod" value="2023-06-30" min="2023-06-30"
							max="2025-06-30" >
					</div>
					<div class="col form-group">
						<input type="text" name="maxCount" class="form-control"
							id="maxCount" placeholder="최대인원 입력 (숫자만)" required="required"
							onKeyup="this.value=this.value.replace(/[^0-9]/g,'');" />
					</div>
				</div>
				<div class="form-group">
					<input type="text" class="form-control" name="title" id="title"
						placeholder="제목을 입력해보세요" required="required" >
				</div>
				<div class="form-group">
					<textarea class="form-control" name="postContent" rows="10"
						placeholder="메시지를 입력해보세요 (최대 210자)" required="required" id="textBox" 
						style="resize: none;" ></textarea>
				</div>
				<div class="row">
					<div class="textLengthWrap" style="display: flex;">
						<p class="textCount">0자</p>
						<p class="textTotal">/210자</p>
					</div>
				</div>
				<script type="text/javascript">
					$('#textBox').keyup(function(e) {
						let content = $(this).val();
						// 글자수 세기
						if (content.length == 0 || content == '') {
							$('.textCount').text('0자');
						} else {
							$('.textCount').text(content.length + '자');
						}
						// 글자수 제한
						if (content.length > 210) {
							$(this).val($(this).val().substring(0, 210));
							alert('글자수는 210자까지 입력 가능합니다.');
						};
					});
				</script>
				<div class="text-center"  >
					<button type="submit" class="btn btn-primary" style="font-size:18px">등록</button>
					<button type="reset" class="btn btn-primary" style="font-size:18px">취소</button>
				</div>
			</div>
		</form>
	</div>
</section>