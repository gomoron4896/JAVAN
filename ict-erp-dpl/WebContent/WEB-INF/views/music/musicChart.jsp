<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp" %>
<body>
<div id="wrapper">
<jsp:include page="/WEB-INF/views/menu/left.jsp" />
	<div id="page-content-wrapper">
		<div class="container">
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>번호</th>
						<th>노래제목</th>
						<th>가수</th>
						<th>배급사</th>
						<th>좋아요</th>
						<th>싫어요</th>
						<th>점수</th>
						<th>발매일</th>
					</tr>
				</thead>
				<tbody id='menuTbody'>
				<c:forEach items="${musicList}" var="music">
					<tr>
						<td>${music.mcNum}</td>
						<td>${music.mcName}</td>
						<td>${music.mcSinger}</td>
						<td>${music.mcVendor}</td>
						<td>${music.mcLike}</td>
						<td>${music.mcDislike}</td>
						<td>${music.mcLike - music.mcDislike}점</td>
						<td>${music.mcCredat}</td>
					</tr>
				</c:forEach>
				</tbody>				
			</table>
			<button data-page="/views/music/musicInsert">노래입력</button>
		</div>
	</div>
</div>
<jsp:include page="/WEB-INF/views/menu/bottom.jsp" />