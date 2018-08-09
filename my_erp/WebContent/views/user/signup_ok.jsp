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
	infoMap.put("miNo",user.get("miNo"));
		System.out.print(infoMap);
	if (DBcon.checkInfo(infoMap.get("miId")) == 1) {
		RequestDispatcher rd = request.getRequestDispatcher("/views/user/signup.jsp");
		rd.forward(request, response);
		return;
	} else {
		if(DBcon.instInfo(infoMap)==1) {
			System.out.print("입력 성공");
			out.write("가입 완료");
		} else {
			out.write("가입 실패");
		}
	}
	
	
	
	
%>
<br>


