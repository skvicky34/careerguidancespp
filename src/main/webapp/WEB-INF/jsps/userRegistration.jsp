<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">

<head>
<style type="text/css">
#ast {
	color: red;
}


#sub {
	position: relative;
	right: -160px;
}

form {
	display: inline-block;
}

.topnav {
	float: none;
	color: lightgrey;
	position: absolute;
	top: 15%;
	left: 50%;
	transform: translate(-50%, 50%);
}

table.center {
	margin: auto;
}
</style>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<link
	href="https://fonts.googleapis.com/css?family=Montserrat:100,200,300,400,500,600,700,800,900"
	rel="stylesheet">

<title>Registration Page</title>

<!-- Bootstrap core CSS -->
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Additional CSS Files -->
<link rel="stylesheet" href="assets/css/fontawesome.css">
<link rel="stylesheet" href="assets/css/templatemo-grad-school.css">
<link rel="stylesheet" href="assets/css/owl.css">
<link rel="stylesheet" href="assets/css/lightbox.css">

</head>

<body>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<!--header-->
	<header class="main-header clearfix" role="header">
		<div class="logo">
			<a href="#"><em>Career</em> Guidance</a>
		</div>
		<a href="#menu" class="menu-link"><i class="fa fa-bars"></i></a>
		<nav id="menu" class="main-nav" role="navigation">
			<ul class="main-menu">
				<li><a href="index" rel="sponsored" class="external">Home</a></li>
				<li class="has-submenu"><a href="index.jsp#section2">About
						Us</a>
					<ul class="sub-menu">
						<li><a href="index#section2" rel="sponsored" class="external">Who
								we are?</a></li>
						<li><a href="index#section3" rel="sponsored" class="external">What
								we do?</a></li>
						<li><a href="index#section3" rel="sponsored" class="external">How
								it works?</a></li>
						<li><a href="https://templatemo.com/about" rel="sponsored"
							class="external">External URL</a></li>
					</ul></li>
				<li><a href="index#section4" rel="sponsored" class="external">Courses</a></li>
				<!-- <li><a href="#section5">Video</a></li> -->
				<li><a href="index#section6" rel="sponsored" class="external">Contact</a></li>
				<li><a href="login" class="external">Log in </a></li>
				<li><a href="userRegistration" class="external">Register</a></li>
			</ul>
		</nav>
	</header>


	<div class="user">
		<header class="user__header">

			<h1 class="user__title"></h1>
			<br> <br>
		</header>
		<br> <br>
		<div class="center" style="margin: auto; width: 400px;">
			<h4 style="text-align: center; font-weight: 500; color:#212529">Registration Form</h4>
			<br>
			<form action="register" method="post"
				onSubmit="return formValidate();">
				<table>
					<tr>
						<td><span class="label">First Name<span id="ast">*</span>:
						</span></td>
						<td><input type="text" id="SI" name="firstName"
							class="form__input" pattern="[a-zA-Z.]{2,30}"
							title="First name must be between 2 and 30 characters" required /></td>
					</tr><tr><td></td></tr>
					<tr>
						<td><span class="label">Last Name:</span></td>
						<td><input type="text" id="SI2" name="lastName"
							class="form__input pattern=" [a-zA-Z.]{2,30}"/></td>
					</tr>
					<tr><td></td></tr>
					<tr>
						<td><span class="label">Email<span id="ast">*</span>:
						</span></td>
						<td><input type="text" id="SI3" name="email"
							class="form__input"
							pattern="^[a-zA-Z][a-zA-Z0-9._%]+@[a-z0-9.-]+\.[a-zA-Z]{2,4}"
							title="abcd_12@yml.com. It can contain special characters like percentage(%), underscore(_),period(.)and at sign(@)."
							required /></td>
					</tr>
					<tr><td></td></tr>
					<tr>
						<td><span class="label">Password<span id="ast">*</span>:
						</span></td>
						<td><input type="password" id="password" name="password"
							class="form__input"
							pattern="^(?=.*[0-9])+(?=.*[a-z])(?=.*[A-Z])+(?=.*[@#$%^&+=]).{8,15}"
							title="Abcdef@123 .It should contain atleast 1 upper case letter, 1 lower case letter, 1 digit and 1 special character($@!%*?&) and length 8-15"
							required /></td>
					</tr>
					<tr><td></td></tr>
					<tr>
						<td><span class="label">Confirm Password<span id="ast">*</span>:
						</span></td>
						<td><input type="password" id="confirmPassword"
							name="confirmPassword" class="form__input"
							pattern="^(?=.*[0-9])+(?=.*[a-z])(?=.*[A-Z])+(?=.*[@#$%^&+=]).{8,15}"
							title="Abcdef@123 .It should contain atleast 1 upper case letter, 1 lower case letter, 1 digit and 1 special character($@!%*?&) and length 8-15"
							required /></td>
					</tr>

					<tr>
						<td></td>
						<td><div class="registrationFormAlert" style="color: black;"
								id="CheckPasswordMatch"></div></td>
					</tr>

					<tr>
						<td><span class="label">Mobile No.<span id="ast">*</span>:
						</span></td>
						<td><input type="text" id="SI6" name="mobileNo"
							class="form__input" pattern="[\d]{10,25}"
							title="9758264524 and length should be between 10 to 25 digits"
							required /></td>
					</tr>
					<tr><td></td></tr>
					<tr>
						<td><span class="label" style="width: 185px;display: inline-block">Current Qualification<span id="ast">*</span>:
						</span></td>
						<td><select id="qualification" name="qualification" style="width:107px; height:30px"
						required>
								<option value="">select</option>
								<option value="10th">10th</option>
								<option value="12th">12th</option>
								<option value="Graduation">Graduation</option>
						</select></td>
						<td><select id="status"
							name="status" style="margin-left:-110px; width:108px; height:30px" required>
								<option value="">status</option>
								<option value="Pass">Pass</option>
								<option value="Appearing">Appearing</option>
								<option value="Flunk">Flunk</option>
						</select></td>
					</tr>
					<tr><td></td></tr>
					<tr>
					<td></td>
					
					<td><input type="submit" value="Register" /></td>
					
					</tr>
				</table>
				
			</form>
			<span style="color: red">${errorMsg}</span>
		</div>
	</div>
	<div style="height: 115px"></div>
	<script>
		function checkPasswordMatch() {
			var password = $("#password").val();
			var confirmPassword = $("#confirmPassword").val();
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
			$("#confirmPassword").keyup(checkPasswordMatch);
		});
	</script>
</body>
</html>
<jsp:include page="footer.jsp" />
