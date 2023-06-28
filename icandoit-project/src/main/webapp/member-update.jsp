<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="row">
	<c:import url="mypage-side-nav.jsp"></c:import>
	<div class="col-sm-7">
		<div style="padding: 5%" data-aos="fade-up">
			<div style="width: 70%">
				<form action="${pageContext.request.contextPath }/UpdateMember.do"
					method="post" role="form" id="updateMemberForm"
					onsubmit="checkForm(event)">
					<div class="form-group">
						<input type="text" class="form-control" id="id" name="id"
							readonly="readonly" required="required"
							value="${sessionScope.memberVO.id}">
					</div>
					<div class="form-group">
						<input type="password" class="form-control" id="password"
							name="password" placeholder="변경하실 비밀번호를 입력해주세요."
							required="required">
						<div class="check_font" id="pw_check"></div>
					</div>
					<div class="form-group">
						<div class="row">
							<div class="col-sm-8">
								<input type="text" class="form-control" name="address"
									id="address" value="${sessionScope.memberVO.address}"
									required="required" >
							</div>
							<div class="col-sm-4">
								<input type="button" class="btn btn-primary"
									onclick="searchAddress()" value="주소 변경" style="margin: 0;">
							</div>
						</div>
					</div>
					<div class="form-group">
						<input type="text" class="form-control" id="phone" name="phone"
							value="${sessionScope.memberVO.phone}" required="required">
						<div class="check_font" id="phone_check"></div>
					</div>
					<div class="form-group">
						<input type="text" class="form-control" id="name" name="name"
							value="${sessionScope.memberVO.name}" readonly="readonly"
							required="required">
						<div class="check_font" id="name_check"></div>
					</div>
					<div class="form-group">
						<input type="text" class="form-control" id="nickName"
							name="nickName" value="${sessionScope.memberVO.nickName}"
							required="required" readonly="readonly">
						<div class="check_font" id="nick_check"></div>
						<span id="checkNickNameResult"></span><br>
					</div>
					<div align="center">
						<button type="submit" class="btn btn-primary" value="회원가입">정보수정</button>
						<script type="text/javascript">
							$(function() {
								$("#updateMemberForm").submit(function() {
									return confirm("회원정보 수정하시겠습니까?");
								});
							});
						</script>
						<button type="reset" class="btn btn-primary" value="재입력">재입력</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
<script
	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript">
	function searchAddress() {
		new daum.Postcode({
			oncomplete : function(data) {
				let addr = ''; 
				if (data.userSelectedType === 'R') {
					addr = data.roadAddress;
				}
				document.getElementById('address').value = addr;
			}
		}).open();
	}

	$('#phone')
			.keydown(
					function(event) {
						var key = event.charCode || event.keyCode || 0;
						$text = $(this);
						if (key !== 8 && key !== 9) {
							if ($text.val().length === 3) {
								$text.val($text.val() + '-');
							}
							if ($text.val().length === 8) {
								$text.val($text.val() + '-');
							}
						}
						return (key == 8 || key == 9 || key == 46
								|| (key >= 48 && key <= 57) || (key >= 96 && key <= 105));
					});
</script>