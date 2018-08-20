<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/common/common.jsp" %>
<body>
<h1>SOMETHING WRONG</h1>
<%
String errMssg = (String)request.getAttribute("error");
out.print(errMssg);
%>
</body>
</html>