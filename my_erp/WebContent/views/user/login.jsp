
<%@ include file="/views/common/common.jsp"%>

<div class="login-form">
	<form action="<%=rPath%>views/user/login_ok.jsp" method="post">
		<h2 class="text-center">Sign in</h2>
		<div class="form-group">
			<div class="input-group">
				<span class="input-group-addon"><i class="fa fa-user"></i></span> <input
					type="text" class="form-control" id="id" name="id"
					placeholder="Username" required="required">
			</div>
		</div>
		<div class="form-group">
			<div class="input-group">
				<span class="input-group-addon"><i class="fa fa-lock"></i></span> <input
					type="password" class="form-control" id="pwd" name="pwd"
					placeholder="Password" required="required">
			</div>
		</div>
		<div class="form-group">
			<button type="submit" id="login"
				class="btn btn-primary login-btn btn-block">Sign in</button>
		</div>
		<div class="clearfix">
			<label class="pull-left checkbox-inline"><input
				type="checkbox"> Remember me</label> <a href="#" class="pull-right"
				id="forgotPwd">Forgot Password?</a>
		</div>
	</form>
	<p class="text-center text-muted small">
		Don't have an account? <a href="#" id="join">Sign up here!</a>
	</p>
</div>
</body>
</html>