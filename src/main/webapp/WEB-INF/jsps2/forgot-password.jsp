<!DOCTYPE html>
<html lang="en">
<head>
<title>Password Reset Page</title>
<style type="text/css">
#ast {
	color: red;
}

#sub {
	position: absolute;
	left: 646px;
}
</style>
</head>

<body>
<jsp:include page="header.jsp" />

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<div style="height: 148px"></div>
<div align="center" id="main" class="container  ">
	<form action="forgot-password" method="post">
		<h4>Please enter new password</h4>
		<div style="height: 20px"></div>
		<table>
			<tr>
				<td><span class="label">Email Id<span id="ast">*</span>:
				</span></td>
				<td>
				<span name="email" id="email">${email}</span>
				<input type="hidden" name="email" class="form__input"
					pattern="^[a-zA-Z][a-zA-Z0-9._%]+@[a-z0-9.-]+\.[a-zA-Z]{2,4}"
					title="abcd_12@yml.com. It can contain special characters like percentage(%), underscore(_),period(.)and at sign(@)."
					value=${email} /></td>
			</tr>
			<tr>
				<td><div style="height: 8px"></div></td>
			</tr>
			<tr>
				<td><span class="label">New Password<span id="ast">*</span>:
				</span></td>
				<td><input type="password" id="txtNewPassword" name="password"
					class="form__input"
					pattern="^(?=.*[0-9])+(?=.*[a-z])(?=.*[A-Z])+(?=.*[@#$%^&+=]).{8,}"
					title="Abcdef@123 .It should contain atleast 1 upper case letter, 1 lower case letter, 1 digit and 1 special character($@!%*?&) and length should be more than 8"
					required /></td>
			</tr>
			<tr>
				<td><div style="height: 8px"></div></td>
			</tr>
			<tr>
				<td><span class="label">Confirm Password<span id="ast">*</span>:
				</span></td>
				<td><input type="password" id="txtConfirmPassword"
					name="confpassword" class="form__input"
					pattern="^(?=.*[0-9])+(?=.*[a-z])(?=.*[A-Z])+(?=.*[@#$%^&+=]).{8,}"
					title="Abcdef@123 .It should contain atleast 1 upper case letter, 1 lower case letter, 1 digit and 1 special character($@!%*?&) and length should be more than 8"
					required /></td>
			</tr>
			<tr>
				<td></td>
				<td><div class="registrationFormAlert" style="color: green;"
						id="CheckPasswordMatch"></div></td>
			</tr>
		</table>
		<div style="height: 20px"></div>
		<div id="sub">
			<input type="submit" value="Submit">
		</div>
		<br> <br> ${successMsg} ${errorMsg}
	</form>
</div>

<div style="height: 196px"></div>

<script>
	function checkPasswordMatch() {
		var password = $("#txtNewPassword").val();
		var confirmPassword = $("#txtConfirmPassword").val();
		if (password != confirmPassword) {
			var str = "Password does not match!";
			var result = str.fontcolor("red");
			document.getElementById("CheckPasswordMatch").innerHTML = result;
		} else {
			var str = "Password matches.";
			var result = str.fontcolor("green");
			document.getElementById("CheckPasswordMatch").innerHTML = result;
		}
	}

	$(document).ready(function() {
		$("#txtConfirmPassword").keyup(checkPasswordMatch);
	});
</script>

<jsp:include page="footer.jsp" />
</body>
</html>
