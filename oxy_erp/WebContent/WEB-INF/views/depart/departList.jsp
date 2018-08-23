<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/common/common.jsp"%>
<body>
<table class="table table-bordered table-hover">
	<thead>
		<tr>
			<th><input type="checkbox" id="allchck" onclick=""></th>
			<th>번호</th>
			<th>부서코드</th>
			<th>부서이름</th>
			<th>부서설명</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${diList}" var="di">
			<tr>
				<td><input type="checkbox" id="chck" value="${di.diNum}"></td>
				<td>${di.diNum}</td>
				<td>${di.diCode}</td>
				<td>${di.diName}</td>
				<td>${di.diDesc}</td>
			</tr>
		</c:forEach>
		<c:if test="${empty diList}">
			<tr>
				<td colspan="5">NO DATA</td>
			</tr>
		</c:if>
	</tbody>
</table>
<script type="text/javascript">

</script>
</body>
</html>