<%@page import="java.util.Iterator"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/views/common/common.jsp"%>
<%
	Map<String, String[]> reqMap = request.getParameterMap();
	Iterator<String> it = reqMap.keySet().iterator();
	while (it.hasNext()) {
		String name = it.next();
		String[] values = reqMap.get(name);
		if (values[0].length() != 0) {
%>
당신이 입력한 <%=name%> :
<%
	for (String value : values) {
				out.println(value + " ");
			}
			out.print("<br>");
		}
	}
%>
</body>
</html>