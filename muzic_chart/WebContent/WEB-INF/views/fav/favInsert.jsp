<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file = "/WEB-INF/views/common/common.jsp" %>
<<c:if test="${!empty insertResult}">
<script>
	alert("${insertResult.msg}");
	window.location.href="/fav/favList";
</script>
</c:if>
<body>
<div id="wrapper">
	<div id="page-content-wrapper">
		<div id="container">
		<form action="/fav/favInsert" method="post">
			<table class="table table-hover table-bordered">
				<thead>
					<tr>
						<th>항목</th>
						<th>내용</th>
					</tr>
				</thead>
				<tbody>
				<tr>
					<td>곡명</td>
					<td><input type="text" name="mcName"></td>
				</tr>
				<tr>
					<td>아티스트</td>
					<td><input type="text" name="mcSinger"></td>
				</tr>
				<tr>
					<td>소속사</td>
					<td><input type="text" name="mcVendor"></td>
				</tr>
				<tr>
					<td>좋아요</td>
					<td><input type="text" name="mcLike"></td>
				</tr>
				<tr>
					<td>싫어요</td>
					<td><input type="text" name="mcDisLike"></td>
				</tr>
				<tr>
					<td>출시일</td>
					<td><input type="text" name="mcCreDat"></td>
				</tr>
				<tr>
					<td>설명</td>
					<td><textarea name="mcDesc" rows="4" cols="50"></textarea></td>
				</tr>
				</tbody>
			</table>
			<button>입력</button>
			</form>
		</div>
	</div>
</div>
</body>
</html>