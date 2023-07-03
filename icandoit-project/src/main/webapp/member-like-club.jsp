<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="row">
	<c:import url="mypage-side-nav.jsp"></c:import>
	<div class="col-sm-7" style="margin: 2%;">
	<div style="font-weight: bold;">❤️찜 목록❤️</div>
	<c:choose>
	<c:when test="${not empty likeList }">
		<c:forEach items="${likeList}" var="likeList">
			<div style="margin: 2%;">
				<table style="width : 80%">
					<tbody>
						<tr>
							<td rowspan="3" style="width: 20%;"><a
								href="FindHobbyPostByNo.do?postNo=${likeList.postVO.postNo}"><img
									src="picture/${likeList.postVO.img}" class="card-img-top"></a></td>
							<td><c:choose>
									<c:when test="${likeList.postVO.gatheringType=='모집마감'}">
										<button type="button" class="btn btn-danger btn-sm">모집마감</button>
									</c:when>
									<c:otherwise>
										<button type="button" class="btn btn-success btn-sm">모집중</button>
									</c:otherwise>
								</c:choose></td>
						</tr>
						<tr>
							<td>
								<h5 class="card-title" style="margin-left: 2%;">
									<a href="FindHobbyPostByNo.do?postNo=${likeList.postVO.postNo}">${likeList.postVO.title}</a>
								</h5>
							</td>
						</tr>
						<tr>
							<td><c:choose>
									<c:when test="${likeList.postVO.categoryType=='운동'}">
										<p class="card-text" style="margin-left: 2%; margin-bottom: 1.5%;">👟
											${likeList.postVO.categoryType}</p>
									</c:when>
									<c:when test="${likeList.postVO.categoryType=='독서'}">
										<p class="card-text" style="margin-left: 2%; margin-bottom: 1.5%;">📚︎
											${likeList.postVO.categoryType}</p>
									</c:when>
									<c:when test="${likeList.postVO.categoryType=='게임'}">
										<p class="card-text" style="margin-left: 2%; margin-bottom: 1.5%;">🎮︎
											${likeList.postVO.categoryType}</p>
									</c:when>
									<c:when test="${likeList.postVO.categoryType=='주식'}">
										<p class="card-text" style="margin-left: 2%; margin-bottom: 1.5%;">📈
											${likeList.postVO.categoryType}</p>
									</c:when>
									<c:when test="${likeList.postVO.categoryType=='캠핑'}">
										<p class="card-text" style="margin-left: 2%; margin-bottom: 1.5%;">🏕
											${likeList.postVO.categoryType}</p>
									</c:when>
									<c:otherwise>
										<p class="card-text" style="margin-left: 2%; margin-bottom: 1.5%;">👯
											${likeList.postVO.categoryType}</p>
									</c:otherwise>
								</c:choose>
						</tr>
					</tbody>
				</table>
			</div>
		</c:forEach>
	</c:when>
	<c:otherwise>
	<div style="margin: 2%;">
	<h3> 찜한 모임이 없습니다!</h3>
	</div>
	</c:otherwise>
	</c:choose>
				<ul class="pagination justify-content-center" style="margin: 20px 0">
			<c:if test="${pagination.previousPageGroup}">
				<li class="page-item"><a class="page-link"
					href="FindMyHobbyPostLikeList.do?pageNo=${pagination.startPageOfPageGroup-4}">Previous</a></li>
			</c:if>
			<c:forEach begin="${pagination.startPageOfPageGroup}"
				end="${pagination.endPageOfPageGroup}" var="page">
				<c:choose>
					<c:when test="${pagination.nowPage==page}">
						<li class="page-item active"><a class="page-link"
							href="FindMyHobbyPostLikeList.do?pageNo=${page}">${page}</a></li>
					</c:when>
					<c:otherwise>
						<li class="page-item"><a class="page-link"
							href="FindMyHobbyPostLikeList.do?pageNo=${page}">${page}</a></li>
					</c:otherwise>
				</c:choose>
			</c:forEach>
			<c:if test="${pagination.nextPageGroup}">
				<li class="page-item"><a class="page-link"
					href="FindMyHobbyPostLikeList.do?pageNo=${pagination.endPageOfPageGroup+1}">Next</a></li>
			</c:if>
		</ul>
	</div>
</div>