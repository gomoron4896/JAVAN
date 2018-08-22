<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/common/common.jsp"%>
<body>
	<div id="wrapper">
		<jsp:include page="/WEB-INF/views/level/left.jsp"></jsp:include>
		<a href="#menu-toggle" class="btn btn-secondary" id="menu-toggle">Toggle Menu</a>
		<div class="container">
			<table id="levelList" class="table table-bordered table-hover">
				<thead>
					<tr>
						<th><input type="checkbox" name="allchck"
							onclick="chckAll(this)"></th>
						<th>번호</th>
						<th>레벨</th>
						<th>이름</th>
						<th>비고</th>
					</tr>
				</thead>
				<tbody id="liTbody">
					<c:forEach items="${liList}" var="li">
						<tr>
							<td><input type="checkbox" name="chck" value="${li.liNum}"></td>
							<td>${li.liNum}</td>
							<td>${li.liLevel}</td>
							<td>${li.liName}</td>
							<td>${li.liDesc}</td>
						</tr>
					</c:forEach>
					<c:if test="${liList}=">
						<tr>
							<td colspan="4">NO DATA</td>
						</tr>
					</c:if>
				</tbody>
			</table>
			<div class="btns">
				<button id="add" onclick="addRow()">레벨추가</button>
				<button id="add" onclick="saveLevel()">레벨저장</button>
				<button id="add" onclick="deleteLevel()">레벨삭제</button>
			</div>
		</div>
	</div>
	<script>
		$("#menu-toggle").click(function(e) {
			e.preventDefault();
			$("#wrapper").toggleClass("toggled");
		});

		function chckAll(obj) {
			var chckObjs = document.querySelectorAll('input[name=chck]');
			for (var i = 0; i < chckObjs.length; i++) {
				chckObjs[i].checked = obj.checked;
			}
		}

		var cnt = '${rMap.cnt}';
		var msg = '${rMap.msg}';

		if (cnt) {
			if (cnt > 0) {
				alert(msg);
				location.href = '/level/levelList';
			}
		}

		var emptyList = '${empty liList}';
		function addRow() {
			var html = '<tr>';
			html += '<td>&nbsp</td>';
			html += '<td><input type="text" name="liLevel"></td>';
			html += '<td><input type="text" name="liName"></td>';
			html += '<td><input type="text" name="liDesc"></td>';
			html += '</tr>';
			var obj = document.querySelector('#liTbody');
			if (emptyList === true) {
				obj.innerHTML = html;
				emptyList = false;
			} else {
				obj.innerHTML += html;
			}
		}

		function makeParam(name) {
			var objs = document.querySelectorAll('input[name=' + name + ']');
			var param = '';
			for (var i = 0; i < objs.length; i++) {
				param += name + '=' + objs[i].value + '&';
			}
			return param;
		}

		function saveLevel() {
			var params = makeParam('liLevel');
			params += makeParam('liName');
			params += makeParam('liDesc');
			location.href = '/level/saveLevelList?' + params;
		}

		function deleteLevel() {
			var chckObjs = document.querySelectorAll('input[name=chck]:checked');
			var param = '';
			for (var i = 0; i < chckObjs.length; i++) {
				param += 'liNum=' + chckObjs[i].value + '&';
			}
			location.href = '/level/deleteLevelList?' + param;
		}
	</script>
</body>
</html>