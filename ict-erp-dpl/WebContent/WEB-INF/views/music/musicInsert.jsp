<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp" %>
<body>
<c:if test="${!empty rMap }">
<script>
	alert('${rMap.msg}');
	if(${rMap.cnt}==1){
		location.href="/member/memberList";
	}
</script>
</c:if>
<div id="wrapper">
<jsp:include page="/WEB-INF/views/menu/left.jsp" />
	<div id="page-content-wrapper">
		<form action="/music/musicInsert" method="post">
		<table class="table table-bordered">
			<tr>
				<th>노래제목</th>
				<td><input type="text" name="mcName"></td>
			</tr>
			<tr>
				<th>가수</th>
				<td><input type="password" name="mcSinger"></td>
			</tr>
			<tr>
				<th>배급사</th>
				<td><input type="text" name="mcVendor"></td>
			</tr>
			<tr>
				<td colspan="2"><button>음악등록</button></td>
			</tr>
		</table>
		</form>
	</div>
</div>
<jsp:include page="/WEB-INF/views/menu/bottom.jsp" />