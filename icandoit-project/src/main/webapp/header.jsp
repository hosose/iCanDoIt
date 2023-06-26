<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- ======= Top Bar ======= -->
<section id="topbar" class="d-flex align-items-center"></section>
<!-- ======= Header ======= -->
<header id="header" class="d-flex align-items-center">
	<div
		class="container d-flex align-items-center justify-content-between">
		<div>
<<<<<<< HEAD
			<a href="Home.do"><img width="120" src="picture/모여라 동숲.jpg"
				alt="모여라 동숲"></a>
=======
			<img width="120" src="picture/모여라 동숲.jpg" alt="모여라 동숲">
>>>>>>> refs/heads/main
		</div>
		<nav id="navbar" class="navbar">
			<a class="btn btn-4" href="Home.do" style="margin-right: 20px">Home</a><a
				class="btn btn-4" href="FindHobbyPostList.do" style="margin-right: 450px">모임
				게시판</a>
			<c:choose>
				<c:when test="${sessionScope.memberVO!=null }">
					${sessionScope.memberVO.nickName }님<br>
					<a href="javascript:logout()" onclick="logout()">로그아웃</a>
					<form method="post"
						action="${pageContext.request.contextPath }/Logout.do"
						id="logoutForm"></form>
					<script type="text/javascript">
						function logout() {
							if (confirm("로그아웃 하시겠습니까?")) {
								document.getElementById("logoutForm").submit();
							}
						}
					</script>
				</c:when>
				<c:otherwise>
					<a href="LoginForm.do" class="btn btn-4">로그인</a>
				</c:otherwise>
			</c:choose>
		</nav>
		<!-- .navbar -->
	</div>
</header>
<!-- End Header -->