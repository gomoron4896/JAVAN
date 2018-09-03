<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp" %>
<body>
<div id="wrapper">
<jsp:include page="/WEB-INF/views/menu/left.jsp" />
	<div id="page-content-wrapper">
	<table class="table table-hover table-bordered">
	<thead>
		<tr>
			<th><input type="checkbox" id="allchck"></th>
			<th>번호</th>
			<th>이름</th>
			<th>가격</th>
			<th>상영 시작일</th>
			<th>상영 종료일</th>
			<th>예매일</th>
			<th>설명</th>
			<th>예매수</th>
			<th>썸네일</th>
		</tr>
	</thead>
	<tbody>
		<c:if test="${empty tmList}">
			<tr>
				<td>NO DATA</td>
			</tr>
		</c:if>
		<c:forEach items="${tmList}" var="tm">
			<tr>
				<td><input type="checkbox" name="tmNum" value="${tm.tmNum}"></td>
				<td>${tm.tmNum}</td>
				<td>${tm.tmName}</td>
				<td>${tm.tmPrice}</td>
				<td>${tm.StartDat}</td>
				<td>${tm.EndDat}</td>
				<td>${tm.Credat}</td>
				<td>${tm.tmDesc}</td>
				<td>${tm.tmCnt}</td>
				<td>${tm.tmImg}</td>
			</tr>
		</c:forEach>
	</tbody>
	</table>
	</div>
</div>
<jsp:include page="/WEB-INF/views/menu/bottom.jsp" />