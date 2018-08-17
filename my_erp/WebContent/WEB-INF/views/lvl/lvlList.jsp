<%@page import="com.ict.erp.service.impl.LvlServiceImpl"%>
<%@page import="com.ict.erp.service.LvlService"%>
<%@page import="com.ict.erp.vo.LvlInfo"%>
<%@page import="com.ict.erp.dao.impl.LvlDAOImpl"%>
<%@page import="com.ict.erp.dao.LvlDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/common/common.jsp"%>
<div class="container">
	<table class="table table-bordered table-hover">
		<thead>
			<tr>
				<th>LvL</th>
				<th>레벨명</th>
				<th>설명</th>
			</tr>
		</thead>
		<tbody>
<%
	LvlService ls = new LvlServiceImpl();
	ls.getLiList(request);
%>
			<c:if test="${empty liList}">
				<tr>
					<td colspan="3">NO DATA</td>
				</tr>
			</c:if>
			<c:forEach var="li" items="${liList}">
				<tr>
					<td>${li.lvl}</td>
					<td>${li.liName}</td>
					<td>${li.liDesc}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
</body>
</html>