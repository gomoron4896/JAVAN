
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/common/common.jsp"%>
<%
String name = user.get("miName");
String miId = user.get("miId");
%>
<body>
	<div class="container">
		WELCOME <%=name %>, <%=miId %>
	</div>
</body>
</html>