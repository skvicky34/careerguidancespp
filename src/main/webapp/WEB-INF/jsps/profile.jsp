<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>User Profile</title>

<!-- Custom fonts for this template-->
<link href="admin/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link href="admin/css/sb-admin-2.min.css" rel="stylesheet">
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

#careerOptions {
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

.main-nav li:hover a, .main-nav li.active a {
	border: 2px solid #f5a425;
}

footer {
	background-color: #152036;
	text-align: center;
	position: fixed;
	bottom: 0;
	width: 100%;
}

@media ( max-width : 950px) {
	.main-nav li:hover a, .main-nav li.active a {
		border: 2px solid transparent;
		border-bottom: 1px solid rgba(250, 250, 250, 0.25);
	}
}
</style>
<title>Profile Page</title>
</head>

<body id="page-top">

	<!-- Page Wrapper -->
	<div id="wrapper">

		<!-- Sidebar -->
		<!-- End of Sidebar -->

		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">

			<!-- Main Content -->
			<div id="content">

				<!-- Topbar -->
				<nav
					class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow"
					style="background-color: rgba(22, 34, 57, 0.95) !important">



					<!-- Sidebar Toggle (Topbar) -->
					<button id="sidebarToggleTop"
						class="btn btn-link d-md-none rounded-circle mr-3">
						<i class="fa fa-bars"></i>
					</button>

					<!-- Topbar Navbar -->
					<ul class="main-menu">
						<li><a href="#"
							style="text-decoration: none; font-size: 27px; margin-top: 20px; display: inline-block;"><em>Career</em>
								Guidance</a></li>
						<li><a href="home" class="external">Home</a></li>
						<li><a href="#section2">About Us</a></li>
						<li><a href="#section4">Courses</a></li>
						<li><a href="#section5">Video</a></li>
						<li><a href="#section6">Contact</a></li>
					</ul>
					<ul class="navbar-nav ml-auto">

						<!-- Nav Item - Search Dropdown (Visible Only XS) -->
						<li class="nav-item dropdown no-arrow d-sm-none"><a
							class="nav-link dropdown-toggle" href="#" id="searchDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false"> <i class="fas fa-search fa-fw"></i>
						</a> <!-- Dropdown - Messages -->
							<div
								class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in"
								aria-labelledby="searchDropdown">
								<form class="form-inline mr-auto w-100 navbar-search">
									<div class="input-group">
										<input type="text"
											class="form-control bg-light border-0 small"
											placeholder="Search for..." aria-label="Search"
											aria-describedby="basic-addon2">
										<div class="input-group-append">
											<button class="btn btn-primary" type="button">
												<i class="fas fa-search fa-sm"></i>
											</button>
										</div>
									</div>
								</form>
							</div></li>

						<!-- Nav Item - Alerts -->
						<li class="nav-item dropdown no-arrow mx-1"><a
							class="nav-link dropdown-toggle" href="#" id="alertsDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false"> <i class="fas fa-bell fa-fw"></i> <!-- Counter - Alerts -->
								<span class="badge badge-danger badge-counter">3+</span>
						</a> <!-- Dropdown - Alerts -->
							<div
								class="dropdown-list dropdown-menu dropdown-menu-right shadow animated--grow-in"
								aria-labelledby="alertsDropdown">
								<h6 class="dropdown-header">Alerts Center</h6>
								<a class="dropdown-item d-flex align-items-center" href="#">
									<div class="mr-3">
										<div class="icon-circle bg-primary">
											<i class="fas fa-file-alt text-white"></i>
										</div>
									</div>
									<div>
										<div class="small text-gray-900">December 12, 2019</div>
										<span class="font-weight-bold">A new monthly report is
											ready to download!</span>
									</div>
								</a> <a class="dropdown-item d-flex align-items-center" href="#">
									<div class="mr-3">
										<div class="icon-circle bg-success">
											<i class="fas fa-donate text-white"></i>
										</div>
									</div>
									<div>
										<div class="small text-gray-900">December 7, 2019</div>
										$290.29 has been deposited into your account!
									</div>
								</a> <a class="dropdown-item d-flex align-items-center" href="#">
									<div class="mr-3">
										<div class="icon-circle bg-warning">
											<i class="fas fa-exclamation-triangle text-white"></i>
										</div>
									</div>
									<div>
										<div class="small text-gray-900">December 2, 2019</div>
										Spending Alert: We've noticed unusually high spending for your
										account.
									</div>
								</a> <a class="dropdown-item text-center small text-gray-900"
									href="#">Show All Alerts</a>
							</div></li>

						<!-- Nav Item - Messages -->
						<li class="nav-item dropdown no-arrow mx-1"><a
							class="nav-link dropdown-toggle" href="#" id="messagesDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false"> <i class="fas fa-envelope fa-fw"></i>
								<!-- Counter - Messages --> <span
								class="badge badge-danger badge-counter">7</span>
						</a> <!-- Dropdown - Messages -->
							<div
								class="dropdown-list dropdown-menu dropdown-menu-right shadow animated--grow-in"
								aria-labelledby="messagesDropdown">
								<h6 class="dropdown-header">Message Center</h6>
								<a class="dropdown-item d-flex align-items-center" href="#">
									<div class="dropdown-list-image mr-3">
										<img class="rounded-circle" src="img/undraw_profile_1.svg"
											alt="">
										<div class="status-indicator bg-success"></div>
									</div>
									<div class="font-weight-bold">
										<div class="text-truncate">Hi there! I am wondering if
											you can help me with a problem I've been having.</div>
										<div class="small text-gray-900">Emily Fowler � 58m</div>
									</div>
								</a> <a class="dropdown-item d-flex align-items-center" href="#">
									<div class="dropdown-list-image mr-3">
										<img class="rounded-circle" src="img/undraw_profile_2.svg"
											alt="">
										<div class="status-indicator"></div>
									</div>
									<div>
										<div class="text-truncate">I have the photos that you
											ordered last month, how would you like them sent to you?</div>
										<div class="small text-gray-900">Jae Chun � 1d</div>
									</div>
								</a> <a class="dropdown-item d-flex align-items-center" href="#">
									<div class="dropdown-list-image mr-3">
										<img class="rounded-circle" src="img/undraw_profile_3.svg"
											alt="">
										<div class="status-indicator bg-warning"></div>
									</div>
									<div>
										<div class="text-truncate">Last month's report looks
											great, I am very happy with the progress so far, keep up the
											good work!</div>
										<div class="small text-gray-900">Morgan Alvarez � 2d</div>
									</div>
								</a> <a class="dropdown-item d-flex align-items-center" href="#">
									<div class="dropdown-list-image mr-3">
										<img class="rounded-circle"
											src="https://source.unsplash.com/Mv9hjnEUHR4/60x60" alt="">
										<div class="status-indicator bg-success"></div>
									</div>
									<div>
										<div class="text-truncate">Am I a good boy? The reason I
											ask is because someone told me that people say this to all
											dogs, even if they aren't good...</div>
										<div class="small text-gray-900">Chicken the Dog � 2w</div>
									</div>
								</a> <a class="dropdown-item text-center small text-gray-900"
									href="#">Read More Messages</a>
							</div></li>
						<a class="mr-2 d-none d-lg-inline text-gray-900 small" href="home"
							style="padding-top: 25px">Home</a>
						<div class="topbar-divider d-none d-sm-block"></div>

						<!-- Nav Item - User Information -->
						<li class="nav-item dropdown no-arrow"><a
							class="nav-link dropdown-toggle" href="#" id="userDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false"> <span
								class="mr-2 d-none d-lg-inline text-gray-900 small"
								style="color: #fff !important;">Welcome
									${sessionScope.userName}</span> <img
								class="img-profile rounded-circle"
								style="background: #ccc !important;" />
						</a> <!-- Dropdown - User Information -->
							<div
								class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
								aria-labelledby="userDropdown">
								<a class="dropdown-item" href="profile"> <i
									class="fas fa-user fa-sm fa-fw mr-2 text-gray-900"></i> Profile
								</a><a class="dropdown-item" href="#"> <i
									class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-900"></i>
									Settings
								</a> <a class="dropdown-item" href="#"> <i
									class="fas fa-list fa-sm fa-fw mr-2 text-gray-400"></i>
									Activity Log
								</a>
								<div class="dropdown-divider"></div>
								<a class="dropdown-item" href="logout" data-toggle="modal"
									data-target="#logoutModal"> <i
									class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
									Logout
								</a>
							</div></li>

					</ul>

				</nav>
				<!-- End of Topbar -->

				<!-- Begin Page Content -->


				<!-- Content Row -->

				<div class="center" style="margin: auto; width: 435px;">
					<div style="background-color: #D3D3D3; width: 435px;">
						<h4
							style="text-align: center; color: black; font-weight: 500; font-size: 20px">Profile
							Details</h4>
					</div>

					<form action="profile" method="post">

						<input type="hidden" name="userId" id="userId"
							value="${user.getId()}" />
						<table>
							<tr>
								<td><span class="label">First Name<span id="ast"></span>:
								</span></td>
								<td>
									${user.getFirstName()}
								</td>

							</tr>
							<tr>
								<td></td>
							</tr>
							<tr>
								<td><span class="label">Last Name:</span></td>
								<td>
									${user.getLastName()}

								</td>
							</tr>
							<tr>
								<td></td>
							</tr>
							<tr>
								<td><span class="label">Email<span id="ast"></span>:
								</span></td>

								<td>
									${user.getEmail()}
								</td>
							</tr>
							<tr>
								<td></td>
							</tr>
							<tr>
								<td><span class="label">Mobile No.<span id="ast"></span>:
								</span></td>
								<td><input type="text" id="SI6" name="mobileNo"
									value="${user.getMobileNo()}" class="form__input"
									pattern="[\d]{10,25}"
									title="9758264524 and length should be between 10 to 25 digits"
									required /></td>
							</tr>
							<tr>
								<td></td>
							</tr>
							<tr>
								<td><span class="label">Qualification<span id="ast"></span>:
								</span></td>
								<td><select id="qualification" name="qualification"
									style="width: 107px; height: 30px">
										<option value="${user.qualification}">${user.qualification}</option>
										<option value="10th">10th</option>
										<option value="12th">12th</option>
										<option value="Graduation">Graduation</option>
								</select></td>
								<td></td>
								<td><select id="status" name="status"
									style="margin-left: -80px; width: 108px; height: 30px">
										<option value="${user.status}">${user.status}</option>
										<option value="Pass">Pass</option>
										<option value="Appearing">Appearing</option>
										<option value="Flunk">Flunk</option>
								</select></td>
							</tr>
						</table>
						<div style="height: 12px"></div>
						<div id="sub">
							<input type="submit" value="Update" />
						</div>
						<script type="text/javascript">
							if (document.getElementById("qualification").value == '10th'
									&& document.getElementById("status").value == 'Pass') {
								document.getElementById("myText").innerText = '10th';
							} else {
								document.getElementById("myText").innerText = '9th';
							}
						</script>
					</form>
					<br> <span style="color: red"> ${errorMsg}</span>
				</div>
			</div>
		</div>
	</div>


	<!-- Scroll to Top Button-->
	<a class="scroll-to-top rounded" href="#page-top"> <i
		class="fas fa-angle-up"></i>
	</a>

	<!-- Logout Modal-->
	<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
					<button class="close" type="button" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">�</span>
					</button>
				</div>
				<div class="modal-body">Select "Logout" below if you are ready
					to end your current session.</div>
				<div class="modal-footer">
					<button class="btn btn-secondary" type="button"
						data-dismiss="modal">Cancel</button>
					<a class="btn btn-primary" href="logout">Logout</a>
				</div>
			</div>
		</div>
	</div>

	<!-- Bootstrap core JavaScript-->
	<script src="admin/vendor/jquery/jquery.min.js"></script>
	<script src="admin/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Core plugin JavaScript-->
	<script src="admin/vendor/jquery-easing/jquery.easing.min.js"></script>

	<!-- Custom scripts for all pages-->
	<script src="admin/js/sb-admin-2.min.js"></script>

	<!-- Page level plugins -->
	<script src="admin/vendor/chart.js/Chart.min.js"></script>

	<!-- Page level custom scripts -->
	<script src="admin/js/demo/chart-area-demo.js"></script>
	<script src="admin/js/demo/chart-pie-demo.js"></script>

</body>
<script type="text/javascript">
	var optionValues = [];
	$('#qualification option').each(function() {
		if ($.inArray(this.value, optionValues) > -1) {
			$(this).remove()
		} else {
			optionValues.push(this.value);
		}
	});

</script>

<script type="text/javascript">
	
	 var optionValues =[];
		$('#status option').each(function(){
		   if($.inArray(this.value, optionValues) >-1){
		      $(this).remove()
		   }else{
		      optionValues.push(this.value);
		   }
		}); 
</script>

<div style="height: 196px"></div>
<jsp:include page="footer.jsp" />
</html>
