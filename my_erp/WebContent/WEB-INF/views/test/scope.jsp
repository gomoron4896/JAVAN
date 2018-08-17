<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/common/common.jsp" %>
<c:set var="title" value="abc"/>
<%
application.setAttribute("app", "BIG DEAL");
session.setAttribute("sess", "KINDA BIG DEAL");
request.setAttribute("req", "REAL DEAL");
pageContext.setAttribute("page", "JUST DEAL");
//RequestDispatcher rd = request.getRequestDispatcher("print.jsp");
//rd.forward(request, response);
%>
</body>
</html>