<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="col-sm-1 offset-sm-3"
	style="padding-top: 2%; margin-top: 2%; margin-bottom: 2%; border-top: 3px solid #0e6ce8; border-bottom: 3px solid #0e6ce8;">
	<ul class="nav flex-column">
		<li class="nav-item"><a class="nav-link"
			href="UpdateMemberForm.do" style="font-size: 18px;"
			id="UpdateMemberForm">정보 수정</a></li>
		<li class="nav-item"><a class="nav-link"
			href="FindMyHobbyPostLikeList.do" style="font-size: 18px;"
			id="FindMyHobbyPostLikeList">찜 목록</a></li>
		<li class="nav-item"><a class="nav-link"
			href="FindMyHobbyPostList.do" style="font-size: 18px;"
			id="FindMyHobbyPostList">모임 목록</a></li>
	</ul>
	<script type="text/javascript">
		$(function() {
			let pathName = $(location).attr('pathname');
			let lastIndexOfPoint = pathName.lastIndexOf('.')
			let lastIndexOfSlash = pathName.lastIndexOf('/')+1
			let controllerName = pathName.substring(lastIndexOfSlash,lastIndexOfPoint);
			$('#' + controllerName).css("text-decoration", "underline");
		})
	</script>
</div>