<%@page import="java.util.HashMap"%>
<%@page import="com.ict.erp.DBcon"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/views/common/common.jsp"%>
<%
	request.setCharacterEncoding("utf-8");

	HashMap<String, String> infoMap = new HashMap<String, String>();

	infoMap.put("miId", request.getParameter("miId"));
	infoMap.put("miEmail", request.getParameter("miEmail"));
	infoMap.put("miName", request.getParameter("miName"));
	infoMap.put("miEtc",request.getParameter("miEtc"));
	infoMap.put("miPwd",request.getParameter("miPwd"));
	infoMap.put("lvl",request.getParameter("lvl"));
		
	if (DBcon.checkInfo(infoMap.get("miId")) == 1) {
		RequestDispatcher rd = request.getRequestDispatcher("signup.jsp");
		rd.forward(request, response);
		return;
	}
	
	
%>
<br>


