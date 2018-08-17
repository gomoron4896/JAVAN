<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
session.invalidate();
String rPath = request.getContextPath();
%>
<script type="text/javascript">
	alert('로그아웃 완료!');
	location.href = '<%=rPath%>/views/user/login.jsp';
</script>
