<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp" %>
<body>
<div id="wrapper">
<jsp:include page="/WEB-INF/views/menu/left.jsp" />
	<div id="page-content-wrapper">
<%
List<Map<String,String>> list = new ArrayList<Map<String,String>>();
Map<String,String> map = new HashMap<String,String>();
map.put("name","홍길동");
list.add(map);
list.add(map);
list.add(map);
%>

			<c:forEach items="${list}" var="map">
				${map.name}
			</c:forEach>
	</div>
</div>
<jsp:include page="/WEB-INF/views/menu/bottom.jsp" />