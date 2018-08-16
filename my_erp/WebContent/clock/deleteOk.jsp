<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.ict.erp.common.DBCon"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/views/common/common.jsp"%>
<%
	String[] values = request.getParameterValues("chk");
	Connection con = DBCon.getCon();
	String sql = "delete from ict_test where itNo=?";
	PreparedStatement ps = con.prepareStatement(sql);
	int cnt = 0;
	for (String value : values) {
		ps.setString(1, value);
		cnt += ps.executeUpdate();
	}
	if (cnt == values.length) {
		con.commit();
		ps.close();
		DBCon.closeCon();
%>
<script>
	alert('<%=cnt%> REQUIRE CONFIRMED');
	location.href='<%=rPath%>/clock/list.jsp';
</script>
<%
	} else {
		con.rollback();
		ps.close();
		DBCon.closeCon();
%>
<script>
alert('ACCESS DENIED');
location.href='<%=rPath%>/clock/list.jsp';
</script>
<%
	}
%>