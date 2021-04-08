<html>
<head>

<style type="text/css">
#ast {

 color: red;

}
#sub {
position: relative;
left: -15px;
}
#sub1 {
position: relative;
top: -25px;
color: #212529;
margin-left:200px;

}
#sub2 {
    position: relative;
    top: -25px;
    margin-left: 200px;
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
	<form action="validationOtp" method="post">
		<h4>OTP has sent to registered Email Id</h4>
		<div style="height: 20px"></div>
		<table>
			<tr>
				<td><span class="label">Email-Id:</span>&nbsp;&nbsp;&nbsp; </td>
				<td><span>${email}</span>
				<input type="hidden" name="email" id="email" value='${email}' />
				</td>
			</tr>
			<tr>
			<td><span class="label" id="otp_lbl">OTP</span><span id="ast">*</span>:
			</td>
			<td>
  			<!-- Modal content -->
    		 <input name="id_otp" id='id_otp' placeholder='Enter OTP' type='text' autocomplete="off" 
                  oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');"
                  maxlength="4" required />
			</td>
			</tr>
		</table>
		<div style="height: 20px"></div>
		<div id="sub">
			<input type="button" value="Validate OTP" />
		</div>
		<div id="sub1">
                <a href="#" onClick="onresend()">Re-send OTP</a>
            </div>
            <div id="sub2">
                <span id="timer"></span>
            </div>
		<br> <br> ${successMsg} ${errorMsg}
	</form>
</div>
<script type="text/javascript">
        let timerOn = true;
 
        function timer(remaining) {
            var m = Math.floor(remaining / 60);
            var s = remaining % 60;
 
            m = m < 10 ? '0' + m : m;
            s = s < 10 ? '0' + s : s;
            document.getElementById('timer').innerHTML = m + ':' + s;
            document.getElementById('sub1').style.display = "none";
            document.getElementById('sub2').style.display = "block";
             document.getElementById('id_otp').readOnly= false; 
            remaining -= 1;
 
            if (remaining >= 0 && timerOn) {
                setTimeout(function() {
                    timer(remaining);
                }, 1000);
                return;
            }
 
            if (!timerOn) {
                document.getElementById('sub1').style.display = "block";
                document.getElementById('sub2').style.display = "none";
                 document.getElementById('id_otp').readOnly= true; 
                return;
            }
 
            document.getElementById('sub1').style.display = "block";
            document.getElementById('sub2').style.display = "none";
              document.getElementById('id_otp').readOnly 
              = true; 
            alert('Timeout for otp');
        }
 
        timer(60);
 
        function onresend() {
             timerOn = true;
             timer(60);
            document.getElementById("id_otp").value = '';
            var val = document.getElementById("email").value;
            var xhttp = new XMLHttpRequest();
            xhttp.onreadystatechange = function() {
                if (xhttp.readyState === 4 && xhttp.status === 200) {
                    document.getElementById("email").innerHTML = xhttp.responseText;
                }
            };
 
            xhttp.open("POST", "resendOtp?email=" + val, true);
            xhttp.send();
 
        }
    </script>



<jsp:include page="footer.jsp" />
</body>
</html>