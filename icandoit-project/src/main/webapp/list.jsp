
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container">
<<<<<<< HEAD
	<div class="row">
		<div class="form-group">
			<button type="button" class="btn btn-success btn-sm">모집중</button>
			<button type="button" class="btn btn-danger btn-sm">모집마감</button>
		</div>

		<c:if test="${sessionScope.memberVO!=null}">

			<form action="RegisterHobbyPostForm.do" method="post">
				<div class="form-group">
					<div class="text">
						<button type="submit" class="btn btn-primary">게시글쓰기</button>
					</div>
				</div>
			</form>
		</c:if>
		<!-- 	</div>
	<div class="row"> -->


		<c:forEach items="${post}" var="postList">

=======
		<div class="row">
>>>>>>> refs/heads/main
			<div class="col-4">
<<<<<<< HEAD
				<div class="card my-4">
					<a href="FindHobbyPostByNo.do?postNo=${postList.postNo}"><img
						src="assets/img/sprint.png" class="card-img-top"></a>
					<div class="card-body">
						<c:choose>
							<c:when test="${postList.gatheringType=='모집마감'}">
								<button type="button" class="btn btn-danger btn-sm">모집마감</button>
							</c:when>
							<c:otherwise>
								<button type="button" class="btn btn-success btn-sm">모집중</button>
							</c:otherwise>
						</c:choose>
						<h5 class="card-title">
							<a href="FindHobbyPostByNo.do?postNo=${postList.postNo}">${postList.title}</a>
						</h5>
						<p class="card-text">${postList.postContent}</p>
					</div>
=======
				<div class="card">
				<img src="picture/김세호.jpg" class="card-img-top">
				<div class="card-body">
				<button type="button" class="btn btn-danger btn-sm">모집마감</button>
				<h5 class="card-title">당구 모임</h5>
				<p class="card-text">당구 모임</p>
>>>>>>> refs/heads/main
				</div>
<<<<<<< HEAD
			</div>
		</c:forEach>
=======
			</div>	
		</div>
>>>>>>> refs/heads/main
	</div>
</div>












