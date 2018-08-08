
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/views/common/common.jsp" %>
<%
HashMap<String,String> memInfo = (HashMap<String,String>)session.getAttribute("memInfo");
String name = memInfo.get("name");
String miId = memInfo.get("id");

%>
<body>
	<div class="container">
		WELCOME <%=miId %>, <%=name %>
	</div>
</body>
</html>