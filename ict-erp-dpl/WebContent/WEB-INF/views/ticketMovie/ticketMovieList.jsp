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
				<td>${tm.tmStartdat}</td>
				<td>${tm.tmEnddat}</td>
				<td>${tm.tmCredat}</td>
				<td>${tm.tmDesc}</td>
				<td>${tm.tmCnt}</td>
				<td><img src="${tm.tmImg}" height="42" width="42"></td>
			</tr>
		</c:forEach>
	</tbody>
	</table><br>
	<button class="button" data-page="/views/ticketMovie/ticketMovieInsert">새 예매</button>
	<button class="button">예매 수정</button>
	<button class="button">예매 취소</button>
	</div>
</div>
<jsp:include page="/WEB-INF/views/menu/bottom.jsp" />