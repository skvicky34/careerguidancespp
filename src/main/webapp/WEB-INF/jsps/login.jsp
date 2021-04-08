<!DOCTYPE html>
<html lang="en">

<head>
<title>Login Page</title>
<style type="text/css">
#ast {
	color: red;
}
#sub {
	position: relative;
	left: -34px;
}
</style>
</head>
<body>
<jsp:include page="header.jsp" />

<div style="height: 148px"></div>
<div align="center" id="main" class="container  ">
	<form method="post" action="login">
		<h4>Log in to Careerguidance</h4>
		<div style="height: 20px"></div>
		<table>
			<tr>
				<td><span class="label">Email Id <span id="ast">*</span>:
				</span></td>
				<td><input type="text" name="email" class="form__input"
					pattern="^[a-zA-Z][a-zA-Z0-9._%]+@[a-z0-9.-]+\.[a-zA-Z]{2,4}"
					title="abcd_12@yml.com. It can contain special characters like percentage(%), underscore(_),period(.)and at sign(@)."
					required /></td>
			</tr>
			<tr>
				<td><div style="height: 8px"></div></td>
			</tr>
			<tr>
				<td><span class="label">Password<span id="ast">*</span>:
				</span></td>
				<td><input type="password" name="password" class="form__input"
					pattern="^(?=.*[0-9])+(?=.*[a-z])(?=.*[A-Z])+(?=.*[@#$%^&+=]).{8,}"
					title="Abcdef@123 .It should contain atleast 1 upper case letter, 1 lower case letter, 1 digit and 1 special character($@!%*?&) and length should be more than 8"
					required /></td>
			</tr>

		</table>
		<div style="height: 12px"></div>
		<div id="sub">
		<input type="submit" value="Login"></div> <a style=color:#212529;margin-left:160px;top:-26px;position:relative;   href="OtpValidation">Forgot
			Password?</a> <br>
		<br> ${successMsg} ${loginErrMsg} ${errorMsg}
	</form>
</div>

<div style="height: 196px"></div>

<jsp:include page="footer.jsp" />
</body>
</html>
