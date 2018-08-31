<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/common/common.jsp"%>
<body>
<div id="page-content-wrapper">
	<form action="/depart/departInsert" method="post">
		<table class="table table-bordered">
			<tr>
				<th>부서코드</th>
				<td><input type="text" name="diCode"></td>
			</tr>
			<tr>
				<th>부서이름</th>
				<td><input type="text" name="diName"></td>
			</tr>
			<tr>
				<th>부서설명</th>
				<td><input type="text" name="diDesc"></td>
			</tr>
			<tr>
				<td colspan="2"><button>부서등록</button></td>
			</tr>
		</table>
	</form>
</div>
<script type="text/javascript">
var diInst = ${empty diInst};
if(diInst==false) {
alert("${diInst.cnt}개 ${diInst.msg}");
}
</script>
</body>
</html>