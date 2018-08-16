<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/views/common/common.jsp" %>
<%=session.getId() %><br>
<%
Date time = new Date();
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
time.setTime(session.getCreationTime());
out.println("세션생성시간 : " + sdf.format(time));
time.setTime(session.getLastAccessedTime());
out.println("세션 마지막 접근 시간 : " + sdf.format(time));
%>
</body>
</html>