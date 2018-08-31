<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<%
String rPath = request.getContextPath();
%>
<html>
<head>
<meta charset="UTF-8">
<title>Own Chart</title>
<link href="<%=rPath %>/bs3/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<script src="<%=rPath %>/bs3/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="<%=rPath %>/bs3/vendor/jquery/jquery.min.js"></script>
<style>
#container {
padding: 50px;
}
</style>
</head>