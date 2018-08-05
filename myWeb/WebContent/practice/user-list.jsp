<%@page import="myWeb.com.ict.test.signupdb.Service"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
Service s = new Service();
String[] ch = request.getParameterValues("ch");
String sch = request.getParameter("sc");

List<Map<String,String>> uList = s.getUserList(ch, sch);
%>

<!DOCTYPE html>
<html>
<link rel="stylesheet" href="/css/bt-337/dist/css/bootstrap-theme.css"/>
<link rel="stylesheet" href="/css/bt-337/dist/css/bootstrap.css"/>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<div class="container">
<a href='/practice/jsp.p/sign_db/signup.jsp'>가입하기</a>

<form>
<input type="checkbox" name="ch" value="uiname" id="name"><label for="name">이름</label>
<input type="checkbox" name="ch" value="uiid" id="id"><label for="id">아이디</label>
<input type="text" name="sc"> 
<button>검색</button>
</form>

	<table class="table table-hover">
		<thead>
			<tr>
				<th>이름</th>
				<th>아이디</th>
				<th>비밀번호</th>
			</tr>
		</thead>
		
		<tbody>
		<%
		for(Map<String,String> us:uList){
		%>
		<tr>
			<td><%=us.get("name")%></td>
			<td><%=us.get("id")%></td>
			<td><%=us.get("pwd")%></td>
		</tr>
		
		
		<%
		}
		%>
		
		</tbody>
		
	
	
	</table>

</div>

</body>
</html>