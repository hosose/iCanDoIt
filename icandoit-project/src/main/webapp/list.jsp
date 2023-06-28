<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container">
	<div class="row">
		<form id="statusform" method="post" name="form" action="FindHobbyPostList">
		<button type="submit" class="btn btn-primary btn-sm" id="dfltBtn" >전체글</button>
		<button type="submit" class="btn btn-success btn-sm" id="rcuBtn">모집중</button>
		<button type="submit" class="btn btn-danger btn-sm" id="endBtn">모집마감</button>
		</form>	
		<form action="RegisterHobbyPostForm.do" method="post">
		<div class="form-group">
			<div class="text">
				<button type="submit" class="btn btn-primary">게시글쓰기</button>
			</div>
		</div>
		</form>
<!-- 	</div>
	<div class="row"> -->


		<c:forEach items="${post}" var="postList">
		
			<div class="col-4">
				<div class="card my-4">
					<a href="FindHobbyPostByNo.do?no=${postList.postNo}"><img src="assets/img/sprint.png" class="card-img-top"></a>
					<div class="card-body">
						<c:choose>
							<c:when test="${postList.gatheringType=='모집마감'}">
								<button type="button" class="btn btn-danger btn-sm">모집마감</button>
							</c:when>
							<c:otherwise>
								<button type="button" class="btn btn-success btn-sm">모집중</button>
							</c:otherwise>
						</c:choose>
						<h5 class="card-title"><a href="FindHobbyPostByNo.do?no=${postList.postNo}">${postList.title}</a></h5>
						<p class="card-text">${postList.postContent}</p>
					</div>
				</div>
			</div>
		</c:forEach>
	</div>
</div>


<ul class="pagination justify-content-center" style="margin:20px 0">
	<c:if test="${pagination.previousPageGroup}">	
	<li class="page-item"><a class="page-link" href="FindHobbyPostList.do?pageNo=${pagination.startPageOfPageGroup-1}">Previous</a></li>
	</c:if>
	<c:forEach begin="${pagination.startPageOfPageGroup}" end="${pagination.endPageOfPageGroup}" var ="page">
	<c:choose>
	<c:when test="${pagination.nowPage==page}">
	<li class="page-item active"><a class="page-link" href="FindHobbyPostList.do?pageNo=${page}">${page}</a></li>
	</c:when>
	<c:otherwise>
	<li class="page-item"><a class="page-link" href="FindHobbyPostList.do?pageNo=${page}">${page}</a></li>
	</c:otherwise>
	</c:choose>
	</c:forEach>
	<c:if test="${pagination.nextPageGroup}">		
  	<li class="page-item"><a class="page-link" href="FindHobbyPostList.do?pageNo=${pagination.endPageOfPageGroup+1}">Next</a></li>  
  	</c:if>   

</ul>
<script type="text/javascript">
let stsBtn = 0;
$(document).ready(function() {
	  $("#dfltBtn").click(function() {
		  stsBtn = 0;
	    $("#statusform").attr("action","FindHobbyPostList.do?stsBtn="+stsBtn);
	  });
	  $("#rcuBtn").click(function() {
		  stsBtn = 1;
		  $("#statusform").attr("action","FindHobbyPostList.do?stsBtn="+stsBtn);
	  });
	   $("#endBtn").click(function() {
		   stsBtn = 2;
		   $("#statusform").attr("action","FindHobbyPostList.do?stsBtn="+stsBtn);
	  });
	});
</script>







