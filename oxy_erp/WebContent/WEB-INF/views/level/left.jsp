<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String rPath = request.getContextPath();
%>
        <div id="sidebar-wrapper">
            <ul class="sidebar-nav">
                <li class="sidebar-brand active" >
                    <a href="/">
                    	ICT ERP
                    </a>
                </li>
                <li>
                    <a href="<%=rPath%>/test/testList">사원관리</a>
                </li>
                <li>
                    <a href="#">부서관리</a>
                </li>
                <li>
                    <a href="#">이력서</a>
                </li>
                <li>
                    <a href="#">Git</a>
                </li>
                <li>
                    <a href="#">Contact</a>
                </li>
            </ul>
        </div>