<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="row">
	<div class="col-sm-1 offset-sm-3" style="padding-top: 2%; margin-top :2%;margin-bottom :2%; border-top: 3px solid #0e6ce8;border-bottom: 3px solid #0e6ce8;">
	<ul class="nav flex-column">
    <li class="nav-item">
      <a class="nav-link" href="UpdateMemberForm.do" style="font-size: 18px;">정보 수정</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="#" style="font-size: 18px;">찜 목록</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="#" style="font-size: 18px;">참여 모임</a>
    </li>
  </ul>
	</div>
	<div class="col-sm-7">
		<div style="padding: 5%" data-aos="fade-up">
			<div style="width: 70%">
				<form action="${pageContext.request.contextPath }/UpdateMember.do"
					method="post" role="form" id="updateMemberForm"
					onsubmit="checkForm(event)">
					<div class="form-group">
						<input type="text" class="form-control" id="id" name="id"
							readonly="readonly" required="required" value="${sessionScope.memberVO.id}">
					</div>
					<div class="form-group">
						<input type="password" class="form-control" id="password"
							name="password" placeholder="변경하실 비밀번호를 입력해주세요." required="required">
						<div class="check_font" id="pw_check"></div>
					</div>
					<div class="form-group">
						<div class="row">
							<div class="col-sm-8">
								<input type="text" class="form-control" name="address"
									id="address" value="${sessionScope.memberVO.address}" required="required"
									readonly>
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
							value="${sessionScope.memberVO.name}" readonly="readonly" required="required">
						<div class="check_font" id="name_check"></div>
					</div>
					<div class="form-group">
						<input type="text" class="form-control" id="nickName"
							name="nickName" value="${sessionScope.memberVO.nickName}" required="required"
							onkeyup="checkNickName()">
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
	//id중복체크
	let checkNickNameFlag = true;
	function checkForm(event) {
		if (checkNickNameFlag == false) {
			event.preventDefault();
		}
	}
	//닉네임 중복 체크
	function checkNickName() {
		checkNickNameFlag = false;
		let Nick = document.getElementById("nickName");
		let checkNickNameResultSpan = document
				.getElementById("checkNickNameResult");
		if (Nick.value.length <= 2) {
			checkNickNameResultSpan.innerHTML = "<font color=skyblue>닉네임은 2자 이상 입력 되어야합니다.</font>";
		} else {
			let xhr = new XMLHttpRequest();
			xhr.onreadystatechange = function() {
				if (xhr.readyState == 4 && xhr.status == 200) {
					checkNickNameResultSpan.innerHTML = xhr.responseText;
					console.log(checkNickNameFlag);
					if (xhr.responseText == "ok") {
						checkNickNameResultSpan.innerHTML = "<font color=blue>사용 가능한 닉네임입니다.</font>";
						checkNickNameFlag = true;
						console.log(checkNickNameFlag);
					} else {
						checkNickNameResultSpan.innerHTML = "<font color=red>사용 불가한 닉네임입니다.</font>";
						console.log(checkNickNameFlag);
					}
				}
			};
			xhr.open("get", "CheckNickName.do?nickName=" + nickName.value);
			xhr.send();
		}
	}
	//본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
	function searchAddress() {
		new daum.Postcode({
			oncomplete : function(data) {
				// 주소를 가져오는 로직을 변경해야 합니다.
				let addr = ''; // 주소 변수

				if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
					addr = data.roadAddress;
				}

				// 주소 필드에 값을 설정하는 방식을 변경해야 합니다.
				document.getElementById('address').value = addr;
			}
		}).open();
	}

	//
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