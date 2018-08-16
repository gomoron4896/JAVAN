<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.ict.erp.common.DBCon"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/views/common/common.jsp"%>
<%
	Connection con = DBCon.getCon();
	String sql = "select * from ict_test order by itNo";
	PreparedStatement ps = con.prepareStatement(sql);
	ResultSet rs = ps.executeQuery();
%>
<div class="containerr">
	<table class="table table-bordered table-hover">
		<thead>
			<tr>
				<th><input type="checkbox" onclick="chkAll(this)"></th>
				<th>NO.</th>
				<th>ID</th>
				<th>PWD</th>
			</tr>
		</thead>
		<tbody>
			<%
				if (!rs.isBeforeFirst()) {
			%>
			<tr>
				<td colspan="4">NO DATA</td>
			</tr>
			<%
				} else {
					if(rs.getRow()!=0) {
						rs.beforeFirst();
					}
					while (rs.next()) {
			%>
			<tr onclick="dataDesc(this)">
				<td><input type="checkbox" name="chk" value="<%=rs.getString("itNo")%>"></td>
				<td><%=rs.getString("itNo")%></td>
				<td><%=rs.getString("itText")%></td>
				<td><%=rs.getString("itPwd")%></td>
			</tr>
			<%
				}
					rs.close();
					ps.close();
					DBCon.closeCon();
				}	
			%>
		</tbody>
	</table>
	<br>
	<button onclick="window.location.href='<%=rPath%>/clock/insert.jsp'">데이터
		입력</button>
	<button onclick='deleteData()'>삭제</button>
	<script>
	function deleteData() {
		var chkObjs = document.querySelectorAll('input[name=chk]:checked');
		if(chkObjs.length==0) {
			alert('NO CHECKED DATA');
			return;
		} else {
		var params = '?';
		for(var i = 0; i<chkObjs.length;i++) {
			params += 'chk=' + chkObjs[i].value + '&';
		}
		params = params.substring(0,params.length-1);
		location.href = '<%=rPath%>/clock/deleteOk.jsp' + params;
			}
		}
	function chkAll(obj) {
		var chkObjs = document.querySelectorAll('input[name=chk]');
		for(var i = 0; i<chkObjs.length;i++) {
			chkObjs[i].checked = obj.checked
		}
	}
	function dataDesc(obj) {
		var slcts = document.querySelectorAll(obj.type+'>td');
		for(var i = 0;i<slcts.length;i++) {
			alert(slcts[i]);
		}
	}
	</script>
</div>
</body>
</html>