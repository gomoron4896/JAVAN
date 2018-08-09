<%@page import="com.ict.erp.DBcon"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/views/common/common.jsp" %>
<%
out.print(DBcon.getList());
%>