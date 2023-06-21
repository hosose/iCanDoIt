<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<!-- ======= Contact Section ======= -->
	<section id="contact" class="contact">
		<div class="container" data-aos="fade-up" >
				<div style="width: 70%">
					<form action="forms/contact.php" method="post" role="form"
						class="php-email-form" >
						<div class="form-group">
							<label for="InputId" class="form-label mt-4">아이디</label> 
							<input type="text" class="form-control" id="user_id" name="user_id"
								aria-describedby="emailHelp" placeholder="아이디를 입력해주세요."
								required="required">
							<div class="check_font" id="id_check"></div>
						</div>
						<div class="form-group">
							<label for="InputPassword" class="form-label mt-4">비밀번호</label> <input
								type="password" class="form-control" id="user_pw" name="user_pw"
								placeholder="비밀번호를 입력해주세요." required="required">
							<div class="check_font" id="pw_check"></div>
						</div>
						<div class="form-group">
							<label for="InputAddress" class="form-label mt-4">주소</label> 
							<input class="form-control" type="hidden" id="postcode" placeholder="우편번호">
							<input class="form-control" type="text" id="roadAddress" placeholder="도로명주소">
							<input type="button" class="btn btn-primary" onclick="execDaumPostcode()" value="주소 찾기">
							<input class="form-control" type="hidden" id="detailAddress" placeholder="상세주소">
							<input class="form-control" type="hidden" id="extraAddress" placeholder="참고항목">
						</div>
						<div class="form-group">
							<label for="InputPhone" class="form-label mt-4">핸드폰번호</label> <input
								type="text" class="form-control" id="user_phone"
								name="user_phone" placeholder="핸드폰번호를 입력해주세요."
								required="required">
							<div class="check_font" id="phone_check"></div>
						</div>
						<div class="form-group">
							<label for="user_name" class="form-label mt-4">이름</label> <input
								type="text" class="form-control" id="user_name" name="user_name"
								placeholder="이름을 입력해주세요." required="required">
							<div class="check_font" id="name_check"></div>
						</div>
						<div class="form-group">
							<label for="InputNick" class="form-label mt-4">닉네임</label> <input
								type="email" class="form-control" id="user_nick"
								name="user_nick" placeholder="닉네임을 입력해주세요." required="required">
							<div class="check_font" id="nick_check"></div>
						</div>
						<div align="center">
							<button type="submit" class="btn btn-primary" value="회원가입">회원가입</button>
							<button type="reset" class="btn btn-primary" value="재입력">재입력</button>
						</div>
					</form>
				</div>
			</div>
	</section>

	<!-- 주소API -->
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script>
    //본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
    function execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var roadAddr = data.roadAddress; // 도로명 주소 변수
                var extraRoadAddr = ''; // 참고 항목 변수

                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('postcode').value = data.zonecode;
                document.getElementById("roadAddress").value = roadAddr;
                
                // 참고항목 문자열이 있을 경우 해당 필드에 넣는다.
                if(roadAddr !== ''){
                    document.getElementById("extraAddress").value = extraRoadAddr;
                } else {
                    document.getElementById("extraAddress").value = '';
                }
            }
        }).open();
    }
  
    $('#user_phone').keydown(function(event) {
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
        return (key == 8 || key == 9 || key == 46 || (key >= 48 && key <= 57) || (key >= 96 && key <= 105));           
    });
</script>
