<%@page import="com.ict.erp.vo.TestInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/common/common.jsp"%>
<%
	List<TestInfo> tiList = (List<TestInfo>) request.getAttribute("tiList");
%>
<style>
tr>td {
	cursor: pointer;
}
</style>
<body>

	<div class="container">
		<div class="container">
			<select class="select" id="shType">
				<option value="tiNum">번호</option>
				<option value="tiId">아이디</option>
				<option value="tiName">이름</option>
				<option value="tiText">내용</option>
			</select> <input type="text" class="text" id="shText">
			<button onclick="searchTest()">검색</button>
			<br>
		</div>
		<table class="table table-bordered table-hover">
			<thead>
				<tr>
					<th>번호</th>
					<th>아이디</th>
					<th>이름</th>
					<th>내용</th>
				</tr>
			</thead>
			<tbody>
				<%
					for (TestInfo ti : tiList) {
				%>
				<tr onclick="goPage(<%=ti.getTiNum()%>)">
					<td><%=ti.getTiNum()%></td>
					<td><%=ti.getTiId()%></td>
					<td><%=ti.getTiName()%></td>
					<td><%=ti.getTiText()%></td>
				</tr>
				<%
					}
				%>
			</tbody>
		</table>
	</div>
	<script type="text/javascript">
	function searchTest() {
		var shType = document.querySelector('#shType').value;
		var shText = document.querySelector('#shText').value;
		if(shText.trim()=='') {
			alert('검색어는 1글자 이상입니다');
			return;
		}
		location.href='<%=rPath%>/test/testList?shType=' + shType + '&shText=' + shText;
	}
	
	function goPage(tiNum) {
		location.href='<%=rPath%>/test/testView?tiNum=' + tiNum;
	}
	</script>
</body>
</html>