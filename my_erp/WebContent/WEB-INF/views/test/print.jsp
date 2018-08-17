<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/common/common.jsp" %>
<%="application : " + application.getAttribute("app") %>
<%="session : " + session.getAttribute("sess") %>
<%="request : " + request.getAttribute("req") %>
<%="pageContext : " + pageContext.getAttribute("page") %>
</body>
</html>