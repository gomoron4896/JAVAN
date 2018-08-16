<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/views/common/common.jsp" %>
<form action="<%=rPath %>/clock/insertOk.jsp">
번호 : <input type="text" name="itNo"><br>
아이디 : <input type="text" name="itText"><br>
비밀번호 : <input type="password" name="itPwd"><br>
<button>입력</button>
</form>
</body>
</html>