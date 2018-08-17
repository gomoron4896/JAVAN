<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>

<div class="container">
	<div class="row centered-form">
		<div
			class="col-xs-12 col-sm-8 col-md-4 col-sm-offset-2 col-md-offset-4">
			<div class="panel panel-default">
				<div class="panel-heading">
					<h3 class="panel-title">Sign up</h3>
				</div>
				<div class="panel-body">
					<form role="form" action="<%=rPath%>/views/user/signup_ok.jsp"
						onsubmit ="return check(this)" method="post">

						<!-- 아이디 패스워드 부 -->
						<div class="form-group">
							<input type="text" name="miId" id="miId"
								class="form-control input-sm" placeholder="ID">
						</div>

						<div class="row">
							<div class="col-xs-6 col-sm-6 col-md-6">
								<div class="form-group">
									<input type="password" name="miPwd" id="miPwd"
										class="form-control input-sm" placeholder="Password">
								</div>
							</div>
							<div class="col-xs-6 col-sm-6 col-md-6">
								<div class="form-group">
									<input type="password" name="pwdCfm" id="pwdCfm"
										class="form-control input-sm" placeholder="Confirm Password">
								</div>
							</div>
						</div>

						<!-- 이메일 부 -->
						<div class="form-group">
							<input type="email" name="miEmail" id="miEmail"
								class="form-control input-sm" placeholder="Email Address">
						</div>

						<div class="form-group" style="margin-top: 40px;"></div>


						<!-- 이름, ETC 부 -->
						<div class="row">
							<div class="col-xs-6 col-sm-6 col-md-6">
								<div class="form-group">
									<input type="text" name="miName" id="miName"
										class="form-control input-sm" placeholder="Name">
								</div>
							</div>
							<div class="col-xs-6 col-sm-6 col-md-6">
								<div class="form-group">
									<select name="lvl" id="lvl" class="form-control input-sm"
										style="color: #999">
										<option value="">Member Level</option>
										<option value="1">User</option>
										<option value="2">Sub-Admin</option>
										<option value="3">Admin</option>
									</select>
								</div>
							</div>
						</div>
						<div class="form-group">
							<input type="text" name="miEtc" id="miEtc"
								class="form-control input-sm" placeholder="etc..">
						</div>
						<input type="submit" value="Register"
							class="btn btn-info btn-block">
					</form>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
<script>
function check(fObj) {
	var miName = fObj.miName.value.trim();
	var miId = fObj.miId.value.trim();
	var miPwd = fObj.miPwd.value.trim();
	var password_confirmation = fObj.pwdCfm.value.trim();
	
	if(miName.length<2) {
		alert("이름은 2자 이상입니다.");
		return false;		
	}
	
	if(miId.length<4) {
		alert("아이디는 4글자 이상입니다.");
		return false;
	}
	
	if(miPwd.length<4) {
		alert("비밀번호는 4글자 이상입니다.");
		return false;
	}
	
	if(miPwd!=password_confirmation) {
		alert("입력된 비밀번호와 다릅니다.");
		return false;
	}
}
 
</script>
</html>