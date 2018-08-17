<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/common/common.jsp" %>
<%
String name = "김기섭";
request.setAttribute("name", name);
%>
${name}
</body>
</html>