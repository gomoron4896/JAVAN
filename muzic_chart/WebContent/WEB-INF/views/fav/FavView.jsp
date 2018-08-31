<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file = "/WEB-INF/views/common/common.jsp" %>
<body>
<div id="container">
				<table class="table table-hover table-bordered">
					<thead>
						<tr>
							<th><input type="checkbox" id="allchck"></th>
							<th>번호</th>
							<th>곡명</th>
							<th>아티스트</th>
							<th>소속사</th>
							<th>좋아요</th>
							<th>싫어요</th>
							<th>출시일</th>
							<th>설명</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${fiList}" var="fi">
							<tr>
								<td><input type="checkbox" id="chck" name="mcNum" value="${fi.mcNum}"></td>
								<td><a href="/fav/favUpdate?mcNum=${fi.mcNum}">${fi.mcNum}</a></td>
								<td>${fi.mcName}</td>
								<td>${fi.mcSinger}</td>
								<td>${fi.mcVendor}</td>
								<td>${fi.mcLike}</td>
								<td>${fi.mcDisLike}</td>
								<td>${fi.mcCreDat}</td>
								<td>${fi.mcDesc}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
</body>
</html>