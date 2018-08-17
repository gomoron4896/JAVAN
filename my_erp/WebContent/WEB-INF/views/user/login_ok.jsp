<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.ict.erp.common.DBCon"%>
<%@page import="java.sql.Connection"%>
<%@include file="/WEB-INF/views/common/common.jsp"%>

<%
	request.setCharacterEncoding("UTF-8");
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");

	Map<String,String> usr = (Map<String,String>)DBCon.getInfo(id, pwd);
	System.out.println(usr);
	if (!usr.isEmpty()) {
		session.setAttribute("usr", usr);
		session.setAttribute("login", true);
		
		RequestDispatcher rd = request.getRequestDispatcher("/views/index.jsp");
		rd.forward(request, response);
		return;
	} else {
		response.sendRedirect("login.jsp");
	}
%>

</body>
</html>