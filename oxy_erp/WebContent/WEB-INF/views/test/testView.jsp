<%@page import="com.ict.erp.vo.TestInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/common/common.jsp" %>
<%
TestInfo ti = (TestInfo)request.getAttribute("testInfo");
%>
<body>
<%=ti %>
</body>
</html>