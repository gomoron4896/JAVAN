<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.ict.erp.DBcon"%>
<%@page import="java.sql.Connection"%>
<%@include file="/views/common/common.jsp"%>

<%
	request.setCharacterEncoding("UTF-8");
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");

	HashMap<String, String> memInfo = DBcon.getInfo(id, pwd);

	if (memInfo != null) {
		session.setAttribute("memInfo", memInfo);
		session.setAttribute("login", true);
		
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		response.sendRedirect("index.jsp");
		return;
	} else {
		response.sendRedirect("login.jsp");
	}
%>

</body>
</html>