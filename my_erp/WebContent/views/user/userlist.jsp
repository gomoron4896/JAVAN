<%@page import="java.sql.SQLException"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.ict.erp.common.DBcon"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/views/common/common.jsp"%>
<div class="container">
	<table class="table table-hover">
		<thead>
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th>아이디</th>
				<th>이메일 주소</th>
				<th>권한</th>
				<th>부서명</th>
			</tr>
		</thead>
		<tbody>
			<%
				try {
					List<Map<String, String>> memberList = DBcon.getList();
					out.println(memberList);
					for (Map<String, String> member : memberList) {
			%>
			<tr>
				<td><%=member.get("MINO")%></td>
				<td><%=member.get("MINAME")%></td>
				<td><%=member.get("MIID")%></td>
				<td><%=member.get("MIEMAIL")%></td>
				<td><%=member.get("CREUSR")%></td>
				<td><%=member.get("DINAME")%></td>
			</tr>
			<%
				}
				} catch (SQLException e) {
					System.out.println(e);
				}
			%>
		</tbody>
	</table>
</div>