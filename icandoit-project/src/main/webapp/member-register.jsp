<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<!-- ======= Contact Section ======= -->
	<section id="contact" class="contact">
		<div class="container" data-aos="fade-up" >
				<div style="width: 70%">
					<form action="${pageContext.request.contextPath }/RegisterMember.do" method="post" role="form"
						class="php-email-form" >
						<div class="form-group">
							<label for="InputId" class="form-label mt-4">아이디</label> 
							<input type="text" class="form-control" id="id" name="id"
								aria-describedby="emailHelp" placeholder="아이디를 입력해주세요."
								required="required">
							<div class="check_font" id="id_check"></div>
						</div>
						<div class="form-group">
							<label for="InputPassword" class="form-label mt-4">비밀번호</label> 
							<input type="password" class="form-control" id="password" name="password"
								placeholder="비밀번호를 입력해주세요." required="required">
							<div class="check_font" id="pw_check"></div>
						</div>
						<div class="form-group">
<!-- 							
							<input class="form-control" type="hidden" id="postcode" placeholder="우편번호">
							<input class="form-control" type="text" id="roadAddress" name="address" placeholder="도로명주소">
							<input type="button" class="btn btn-primary" onclick="execDaumPostcode()" value="주소 찾기"> -->
							<label for="InputAddress" class="form-label mt-4">주소</label> 
							<input type="text" class="form-control" name="address"
                           id="address" placeholder="주소 검색 버튼으로 주소 선택" required="required"
                           readonly>
                        <div class="input-group-append">
                           <input type="button" class="btn btn-primary" onclick="searchAddress()">주소 검색</input>
                        </div>
						</div>
						<div class="form-group">
							<label for="InputPhone" class="form-label mt-4">핸드폰번호</label> 
							<input	type="text" class="form-control" id="phone" name="phone" 
							placeholder="핸드폰번호를 입력해주세요."
								required="required">
							<div class="check_font" id="phone_check"></div>
						</div>
						<div class="form-group">
							<label for="user_name" class="form-label mt-4">이름</label> <input
								type="text" class="form-control" id="name" name="name"
								placeholder="이름을 입력해주세요." required="required">
							<div class="check_font" id="name_check"></div>
						</div>
						<div class="form-group">
							<label for="InputNick" class="form-label mt-4">닉네임</label> <input
								type="text" class="form-control" id="nickName"
								name="nickName" placeholder="닉네임을 입력해주세요." required="required">
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
   function searchAddress() {
    new daum.Postcode({
        oncomplete: function (data) {
            // 주소를 가져오는 로직을 변경해야 합니다.
            let addr = ''; // 주소 변수

            if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                addr = data.roadAddress;
            } else { // 사용자가 지번 주소를 선택했을 경우(J)
                addr = data.jibunAddress;
            }

            // 주소 필드에 값을 설정하는 방식을 변경해야 합니다.
            // document.getElementById('zipcode').value = data.zonecode;
            document.getElementById('address').value = addr;

            // 상세주소 필드로 커서를 이동하는 부분은 유지합니다.
          //  document.getElementById('addressDetail').focus();

            // 기타 필요한 로직을 추가하거나 수정합니다.
            // addressCheckFlag = true;
            // $('#searchAddressBtn').parent().next().hide();
        }
    }).open();
}
  
/*     $('#phone').keydown(function(event) {
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
    }); */
</script>
