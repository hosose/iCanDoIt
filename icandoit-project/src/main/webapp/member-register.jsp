<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

	<!-- ======= Contact Section ======= -->
	<section id="contact" class="contact">
		<div class="container" data-aos="fade-up" >
				<div style="width: 70%">
					<form action="${pageContext.request.contextPath }/RegisterMember.do" method="post" role="form"
						id="registerMemberForm">
						<div class="form-group">
							<input type="text" class="form-control" id="id" name="id"
								aria-describedby="emailHelp" placeholder="아이디를 입력해주세요."
								required="required">
							<div class="check_font" id="id_check"></div>
						</div>
						<div class="form-group">
							<input type="password" class="form-control" id="password" name="password"
								placeholder="비밀번호를 입력해주세요." required="required">
							<div class="check_font" id="pw_check"></div>
						</div>
						<div class="form-group">
							<div class="row">
								<div class="col-sm-8">								
									<input type="text" class="form-control" name="address"  id="address" 
									placeholder="주소 검색 버튼으로 주소 선택" required="required"  readonly>
								</div>
								<div class="col-sm-4">			
                           			<input type="button" class="btn btn-primary" onclick="searchAddress()"  value="주소 검색">
								</div>
							</div>                       
						</div>
						<div class="form-group">
							<input	type="text" class="form-control" id="phone" name="phone" 
							placeholder="핸드폰번호를 입력해주세요."
								required="required">
							<div class="check_font" id="phone_check"></div>
						</div>
						<div class="form-group">
							<input
								type="text" class="form-control" id="name" name="name"
								placeholder="이름을 입력해주세요." required="required">
							<div class="check_font" id="name_check"></div>
						</div>
						<div class="form-group">
							<input
								type="text" class="form-control" id="nickName"
								name="nickName" placeholder="닉네임을 입력해주세요." required="required">
							<div class="check_font" id="nick_check"></div>
						</div>
						<div align="center">
							<button type="submit" class="btn btn-primary" value="회원가입">회원가입</button>
							<script type="text/javascript">
							$(function(){
								$("#registerMemberForm").submit(function(){
									return confirm("등록하시겠습니까?");
								});
							});
							</script>
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
            }

            // 주소 필드에 값을 설정하는 방식을 변경해야 합니다.
            document.getElementById('address').value = addr;
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
