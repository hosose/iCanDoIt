<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<section id="topbar" class="d-flex align-items-center"></section>
<header id="header" class="d-flex align-items-center">
    <div class="container d-flex align-items-center justify-content-between">
      <a href="Home.do"><img width="120" src="picture/모여라 동숲.jpg" alt="모여라 동숲"></a>
      <nav id="navbar" class="navbar">
        <ul>
          <li><a class="nav-link scrollto" href="Home.do">홈</a></li>
          <li><a class="nav-link scrollto" href="FindHobbyPostList.do">모임참여</a></li>
          <c:choose>
				<c:when test="${sessionScope.memberVO!=null }">
					<li><a href="UpdateMemberForm.do" >마이페이지</a></li>
					<li><a href="javascript:logout()" onclick="logout()">로그아웃</a></li>
					<form method="post" action="${pageContext.request.contextPath }/Logout.do" id="logoutForm"></form>
					&nbsp;<span style="font-weight: bold;">${sessionScope.memberVO.nickName }님 안녕하세요!</span>
					<script type="text/javascript">
						function logout() {
							if (confirm("로그아웃 하시겠습니까?")) {
								document.getElementById("logoutForm").submit();
							}
						}
					</script>
				</c:when>
				<c:otherwise>
					<li><a class="nav-link scrollto" href="LoginForm.do">로그인</a></li>
				</c:otherwise>
			</c:choose>
        </ul>
        <i class="bi mobile-nav-toggle bi-list"></i>
      </nav>
    </div>
  </header>