<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>    
  <button type="button" class="btn btn-success btn-sm">모집중</button>
  <button type="button" class="btn btn-danger btn-sm">모집마감</button>
<div class="container">
		<div class="row ">
		<c:forEach items="${list}" var="post">
			<div class="col-4">
				<div class="card my-4">
				<img src="sprint.png" class="card-img-top">
				<div class="card-body">
				<button type="button" class="btn btn-danger btn-sm">모집마감</button>
				<h5 class="card-title">${post.title}</h5>
				<p class="card-text">${post}</p>
				</div>
			</div>	
		</div>
		</c:forEach>
	</div>
</div>












