<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Home Page</title>

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
	left: 159px;
}

.em2 {
	font-size: 36px;
	text-transform: uppercase;
	font-weight: 800;
	color: #fff;
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
	position: relative;
	bottom: -42px;
}

@media ( max-width : 950px) {
	.main-nav li:hover a, .main-nav li.active a {
		border: 2px solid transparent;
		border-bottom: 1px solid rgba(250, 250, 250, 0.25);
	}
}
</style>

<script type="text/javascript">
                    function onBoardSelectSubjects() {
                    	document.getElementById("mark").value = "";
                    	document.getElementById("totalMarks").value = "";
                        var val = document.getElementById("board").value;
                        var xhttp = new XMLHttpRequest();
                        xhttp.onreadystatechange = function() {
                            if (xhttp.readyState === 4 && xhttp.status === 200) {
                                document.getElementById("subjectName").innerHTML = xhttp.responseText;
                            }
                        };
                        xhttp.open("POST", "subjectList?board=" + val, true);
                        xhttp.send();
                    }
                    
                </script>

</head>

<body id="page-top">

	<!-- Page Wrapper -->
	<div id="wrapper">

		<!-- Sidebar -->
		<!-- End of Sidebar -->

		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">

			<!-- Main Content -->
			<div id="content" style="background-color: #fff">

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
						<li><a href="home">Home</a></li>
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
										<div class="small text-gray-500">December 12, 2019</div>
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
										<div class="small text-gray-500">December 7, 2019</div>
										$290.29 has been deposited into your account!
									</div>
								</a> <a class="dropdown-item d-flex align-items-center" href="#">
									<div class="mr-3">
										<div class="icon-circle bg-warning">
											<i class="fas fa-exclamation-triangle text-white"></i>
										</div>
									</div>
									<div>
										<div class="small text-gray-500">December 2, 2019</div>
										Spending Alert: We've noticed unusually high spending for your
										account.
									</div>
								</a> <a class="dropdown-item text-center small text-gray-500"
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
										<div class="small text-gray-500">Emily Fowler · 58m</div>
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
										<div class="small text-gray-500">Jae Chun · 1d</div>
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
										<div class="small text-gray-500">Morgan Alvarez · 2d</div>
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
										<div class="small text-gray-500">Chicken the Dog · 2w</div>
									</div>
								</a> <a class="dropdown-item text-center small text-gray-500"
									href="#">Read More Messages</a>
							</div></li>

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
									class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i> Profile
								</a> <a class="dropdown-item" href="#"> <i
									class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i>
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
					<!--  <p>This helps us tailor your Career Recommendations.<br>
                    Kindly enter percentage and marks</p> -->
					<div style="background-color: #D3D3D3; width: 435px;">
						<h4
							style="text-align: center; color: black; font-weight: 500; font-size: 20px">Academic
							Details</h4>
					</div>
					<form action="userAcadmic" method="post" onsubmit="checkRecord();">
						<input type="hidden" name="userId" id="userId" value="${userId}" />
						<input type="hidden" name="qualification" id="qualification"
							value="${qualification}" /> <input type="hidden" name="status"
							id="status" value="${status}" />
						<table>
							<tr>
								<td colspan="2" style="color: black"><span class="label">Are
										you looking for?</span><span id="ast">*</span> &nbsp; <input
									type="radio" id="course" name="career" value="course"
									required="required"> &nbsp; <label for="course">Courses</label>
									&nbsp; <input type="radio" id="job" name="career" value="job"
									required="required"> &nbsp; <label for="job">Jobs</label>
								</td>
							</tr>


							<tr>
								<td><span class="label"
									style="color: black; width: 156px; display: inline-block;">Current
										Qualification:</span></td>
								<td><span style="color: black">${qualification}</span></td>
							</tr>


							<tr>
								<td><span class="label" style="color: black;">Board:<span
										id="ast">*</span>
								</span></td>
								<td><select id="board" name="board"
									onchange="onBoardSelectSubjects()" required>
										<option value="">Select board name here</option>
										<c:forEach items="${boards}" var="board">
											<option value="${board.name}">${board.name}</option>
										</c:forEach>
								</select></td>
							</tr>
							<tr>
								<td></td>
								<td>
									<p id="errorBoardMsg" style="color: green;"></p>
								</td>
							</tr>

							<tr>
								<td><span class="label" style="color: black;">Total
										marks(%):<span id="ast">*</span>
								</span></td>
								<td><input type="text" id="totalMarks" name="totalMarks"
									required /></td>
							</tr>

							<tr>
								<td><span class="label" style="color: black">Select
										Subject:<span id="ast">*</span>
								</span></td>
								<td><select id="subjectName" name="subjectName" required
									onchange="selectDropdown(this)">
										<option value=""></option>
								</select></td>
							</tr>
							<tr>
								<td><span class="label" style="color: black">Enter
										Marks:<span id="ast">*</span>
								</span></td>
								<td><input type="text"
									oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');"
									autocomplete="off" maxlength="2" id="mark" name="mark"
									onclick="myMarkFunction()" required /></td>
							</tr>
							<tr>
								<td></td>
							</tr>
						</table>

						<div id="sub">
							<input type="submit" value="Add" onclick="addRow('dataTable')">
							<input type="submit" value="Delete"
								onclick="deleteRow('dataTable')">

							<button onclick="checkRecord()" id="submit">submit</button>
							<input type="hidden" id="demo" name="demo" />
							<p id="errorMsg" style="color: red"></p>
							<div id="toggleId" style="display: none">
								<p
									style="margin-top: 10px; margin-left: 0px; position: relative; color: black; font-size: 17px">Subjects
									and marks details:</p>
								<TABLE id="dataTable" width="350px" border="1"
									style="text-align: center; margin-top: -14px; margin-left: 0px; color: black;">
									<tr>
										<th>Subject</th>
										<th>Marks</th>
										<th>Action</th>
									</tr>
								</TABLE>
							</div>
						</div>

					</form>
					<script type="text/javascript">
					var subName = '';
					var map = new Map(); 
		function addRow(tableID) {
			event.preventDefault();
			document.getElementById('toggleId').style.display = "block";
			document.getElementById('errorBoardMsg').innerHTML = "You Can't changed Board now.If you want to do so delete all subject which you added";
			//document.getElementById("board").readOnly = true;
			$('#board').attr("disabled", true); 
			var dropdownValue = document.getElementById("subjectName").value;
			var mark = document.getElementById("mark").value;
			console.log("dropdownValue",dropdownValue)
			console.log("mark",mark)
			if(map.has(dropdownValue) || mark === "" || dropdownValue === ""){
				if(map.has(dropdownValue)){
					document.getElementById("errorMsg").innerHTML = "Duplicate Subject. Already Added in List";
				}else if(mark === ""){
					document.getElementById("errorMsg").innerHTML = "Mark field cannot be blank";
				}
				console.log("not to add")
			}else{
				map.set(dropdownValue, mark); 

				console.log("assign")
				const myJson = {};
				myJson.myMap = mapToObj(map);
				console.log("map.size after adding",map.size)
				$(function(){
				    $("#demo").val(JSON.stringify(myJson));

				});
				$(function() {
					subName = $('#subjectName :selected').text();
				});
				
				var table = document.getElementById(tableID);

				var rowCount = table.rows.length;
				var row = table.insertRow(rowCount);
				
				var cell1 = row.insertCell(0);
				var element1 = document.createElement("input");
				element1.type = "checkbox";
				element1.name="chkbox[]";
				cell1.appendChild(element1);

				var cell2 = row.insertCell(1);
				cell2.innerHTML = rowCount + 1;
				cell1.innerHTML = subName;
				
				var cell3 = row.insertCell(2);
				cell2.innerHTML = document.getElementById("mark").value;
				cell3.appendChild(element1);
				
				}
			
		}

		function deleteRow(tableID) {
			console.log("called")
			event.preventDefault();
			document.getElementById("errorMsg").innerHTML = "";
			try {
			var table = document.getElementById(tableID);
			var rowCount = table.rows.length;
			var keyToRemove;
			console.log("rowCount",rowCount)
			for(var i=0; i<rowCount; i++) {
				var row = table.rows[i];
				var chkbox = row.cells[2].childNodes[0];
				console.log("chkbox",chkbox.checked)
				console.log("i",i)
				if(null != chkbox && true == chkbox.checked) {
					table.deleteRow(i);
					console.log("row.cells[i]",row.cells[0].childNodes[0]);
					console.log("before delete size of map",map.size)
					map.delete(row.cells[0].childNodes[0]);
					console.log("after delete size of map",map.size)
					rowCount--;
					i--;
				}


			  } 

			if(rowCount!= 0){

				for(var i=0; i<rowCount; i++) {
					var row = table.rows[i];
					map = new Map();

					var subKey = row.cells[0].childNodes[0].textContent;
					var markVal = row.cells[1].childNodes[0].textContent;
					
					map.set(subKey,markVal);
				  } 

				for (const [key, value] of map.entries()) {
					  console.log(key, value);
					}
				}else{
					map = new Map();
				}
			
			console.log("new assignment")
			const myJson1 = {};
			myJson1.myMap = mapToObj(map);
			console.log("map.size after delete",map.size)
			$(function(){
			    $("#demo").val(JSON.stringify(myJson1));
			});
			}catch(e) {
				alert(e);
			}
			console.log("rowCount before hide",map.size)
			if(rowCount == 1){
				document.getElementById('toggleId').style.display = "none";
				document.getElementById('errorBoardMsg').innerHTML = "";
				//document.getElementById("board").readOnly = false;
				$('#board').attr("disabled", false);
				
			}
		}

		function mapToObj(map){
			  const obj = {}
			  for (let [k,v] of map)
			    obj[k] = v
			  return obj
			}

	function checkRecord()
	{
		if(map.size == 0){
			event.preventDefault();
			alert("Educational Details Can't be Empty.")
			return false;
		}else{
			$('#board').attr("disabled", false); 
		}
	}
	function selectDropdown(sel) {
		document.getElementById("mark").value = "";
		document.getElementById("errorMsg").innerHTML = "";
	}
	function myMarkFunction() {
		document.getElementById("errorMsg").innerHTML = "";
		}
</script>
					<span style="color: green">${acadmicSuccessMsg}
						${successMsg}</span>
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
						<span aria-hidden="true">×</span>
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

<div style="height: 225px"></div>
<jsp:include page="footer.jsp" />
</html>
