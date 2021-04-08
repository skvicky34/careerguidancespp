<html>
<head>

<style type="text/css">
#ast {

 color: red;

}
#sub {
position: relative;
left: 140px;
}

.em2 {
    font-size: 36px;
    text-transform: uppercase;
    font-weight: 800;
    color: #fff;
}

body {
background-color: #f8f9fc;

}

#careerOptions{
margin-left: 75px;
}

em {
    font-style: normal;
    color: #f5a425;
}

.main-menu {
    float: right;
    padding-right: 60px;
}

.main-menu li {
    display: inline-block;
    line-height: 79px;
    margin-left: 15px;
    position: relative;
}

.main-menu li:first-child {
    margin-left: 0px;
}

.main-menu li a {
    padding: 10px 15px;
    font-size: 13px;
    text-transform: uppercase;
    letter-spacing: 0.5px;
    font-weight: 700;
    color: #fff;
    border: 2px solid transparent;
    transition: all 0.5s;
}

.main-menu li.has-submenu a:after {
    content: '\f107';
    font-family: "FontAwesome";
    margin-left: 5px;
}

.main-menu li.has-submenu ul li a:after {
    display: none;
}

.main-menu li .sub-menu {
    position: absolute;
    width: 160px;
    background-color: #18233a;
    opacity: 0;
    visibility: hidden;
    transition: all 0.5s;
}

.main-menu li:hover .sub-menu {
    opacity: 1;
    visibility: visible;
}

.main-menu li .sub-menu li {
    display: block;
    line-height: 20px;
    margin-left: 0px;
    margin-bottom: 15px;
    padding-bottom: 15px;
    border-bottom: 1px solid #121b2f;
}

.main-menu li .sub-menu li:first-child {
    padding-top: 15px;
}

.main-menu li .sub-menu li:last-child {
    margin-bottom: 0px;
    border-bottom: none;
}

.main-menu li .sub-menu li a {
    font-size: 12px;
    font-weight: 500;
    padding: 0px 15px;
    letter-spacing: 0.5px;
    border: none;
    transition: all 0.5s;
}

.main-menu li .sub-menu li a:hover {
    color: #f5a425;
    border: none;
}

.main-nav li:hover a,
.main-nav li.active a {
    border: 2px solid #f5a425;
}

footer {
    
    position: relative;
    width: 100%;
   margin-top: 250px;
}
@media (max-width: 950px) {
  .main-nav li:hover a,
  .main-nav li.active a {
    border: 2px solid transparent;
    border-bottom: 1px solid rgba(250,250,250,0.25);
  }
}

</style>
<title>Email Validation Page</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script type="text/javascript">
</script>
</head>
<body>
<jsp:include page="header.jsp" />

<div style="height: 148px"></div>
<div align="center" id="main" class="container  ">
	<form action="OtpValidation-New" method="post" id="form1">
		<h4>Please enter your Registered Email Id</h4>
		<div style="height: 20px"></div>
		<table>
			<tr>
				<td><span class="label">Email Id<span id="ast">*</span>:
				</span></td>
				<td><input type="text" name="email" class="form__input"
					pattern="^[a-zA-Z][a-zA-Z0-9._%]+@[a-z0-9.-]+\.[a-zA-Z]{2,4}"
					title="abcd_12@yml.com. It can contain special characters 
					like percentage(%), underscore(_),period(.)and at sign(@)."
					required id="email" value="${email}" onclick="myFunction()" style="width: 290px"/></td>
			</tr>
			<tr>
			<td> </td>
			<td>
  			<input type="submit" value="Send OTP">
			</td>
			</tr>
		</table>
		<br> <br><p id="msg"> ${successMsg} ${errorMsg}</p>
	</form>
	<script>
function myFunction() {
  document.getElementById("msg").innerHTML = "";
}
</script>
</div>


<jsp:include page="footer.jsp" />
</body>
</html>