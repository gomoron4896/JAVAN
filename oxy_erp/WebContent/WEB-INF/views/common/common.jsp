
<%@page import="com.ict.erp.vo.Menu"%>
<%@page import="java.util.List"%>
<%@page import="com.ict.erp.utils.MenuUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String rPath = request.getContextPath();
	String title = "클라우드 프로젝트";
	String uri = request.getRequestURI();
	List<Menu> menuList = MenuUtils.getMenuList(null);
	
%>
<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title><%=title%></title>
<link rel="stylesheet" href="<%=rPath%>/bs3/css/bootstrap-theme.css">
<link rel="stylesheet" href="<%=rPath%>/bs3/css/bootstrap.css">
<link rel="stylesheet" href="<%=rPath%>/bs3/css/common.css">
<script src="<%=rPath%>/bs3/css/bootstrap.js"></script>
<script src="<%=rPath%>/bs3/css/common.js"></script>
<script src="<%=rPath%>/bs3/css/jquery-3.3.1.js"></script>
</head>
<div class="container">
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="<%=rPath%>"><%=title%></a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<%
						for (Menu m : menuList) {
							String active = "";
							String url = rPath + m.getMiUrl();
							String label = m.getMiLabel();
							if (uri.indexOf(m.getMiUrl()) != -1) {
								active = "active";
							}
					%>
					<li class="<%=active%>"><a href="<%=url%>"><%=label%></a></li>
					<%
						}
					%>
				</ul>
			</div>
		</div>
	</nav>
</div>