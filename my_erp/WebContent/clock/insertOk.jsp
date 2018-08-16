<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.ict.erp.common.DBCon"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/views/common/common.jsp"%>
<%
	String itNo = request.getParameter("itNo");
	String itText = request.getParameter("itText");
	String itPwd = request.getParameter("itPwd");
	Connection con = DBCon.getCon();

	String sql = "insert into ict_test values(?,?,?)";
	PreparedStatement ps = con.prepareStatement(sql);
	ps.setString(1, itNo);
	ps.setString(2, itText);
	ps.setString(3, itPwd);
	int cnt = ps.executeUpdate();
	if (cnt == 1) {
		con.commit();
		ps.close();
		DBCon.closeCon();
%>
<script>
alert('입력 성공');
location.href='<%=rPath%>/clock/list.jsp';
</script>
<%
	} else {
%>
alert('입력 실패'); location.href='<%=rPath%>/clock/list.jsp';
<%
	}
%>