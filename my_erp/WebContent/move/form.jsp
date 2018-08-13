<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/views/common/common.jsp" %>
<form action="<%=rPath%>/test/">
취미 : <br>
<input type="checkbox" name="hobby" value="게임">게임,
<input type="checkbox" name="hobby" value="영화">영화,
<input type="checkbox" name="hobby" value="음악">음악
<br>

거주지역 : <select name="address">
	<option value="서울">서울</option>
	<option value="인천">인천</option>
	<option value="천안">천안</option>
</select>
<br>
이름 : <input type="text" name="name"><br>
ID : <input type="text" name="id"><br>
<button>전송</button>
</form>
</body>
</html>