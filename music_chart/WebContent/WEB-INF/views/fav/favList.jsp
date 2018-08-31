<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>
<body>
	<div id="wrapper">
		<!-- <jsp:include page="/WEB-INF/views/menu/left.jsp" /> -->
		<div id="page-content-wrapper">
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
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		</div>
	</div>