<%@page import="com.model.UserBean"%>
<html lang="en">
	<%@include file="includes/header.jsp" %>
	<body>
		<div id="wrapper">
			<!-- Navigation -->
			<jsp:include page="includes/navbar.jsp" />

			<!-- Page Content -->
			<div id="page-wrapper" style="min-height: 99px;">
				<div class="container-fluid">
					<div class="row">
						<div class="col-lg-12">
							<h2 class="page-header">Profile</h2>
						</div>
						<!-- /.col-lg-12 -->
					</div>
					<% UserBean user = (UserBean)request.getAttribute("account"); %>
					<div class="row">
						<div class="col-lg-2">
							<a href="#" class="thumbnail">
								<img src="../images/placeholder-400x400.png" alt="...">
							</a>
							<button type="button" class="btn btn-default btn-block">Upload Picture</button>
							<button type="button" class="btn btn-default btn-block">Edit Profile</button>
							<button type="button" class="btn btn-default btn-block">Reset Password</button>
						</div>
						<div class="col-lg-2">
							<p class="text-right"><strong>First Name</strong></p>
							<p class="text-right"><strong>Last Name</strong></p>
							<p class="text-right"><strong>Username</strong></p>
							<p class="text-right"><strong>Business Unit</strong></p>
							<p class="text-right"><strong>Position</strong></p>
							<p class="text-right"><strong>Email</strong></p>


						</div>
						<div class="col-lg-8">
							<p><%= user.getStrFirstName() %><p>
							<p><%= user.getStrLastName() %><p>
							<p><%= user.getStrUserName() %><p>
							<p><%= user.getStrBusinessUnit() %><p>
							<p><%= user.getStrPosition() %><p>
							<p><%= user.getStrEmail() %><p>
						</div>
					</div>
					<!-- /.row -->
				</div>
				<!-- /.container-fluid -->
			</div>
			<!-- /#page-wrapper -->
		</div>
		<!-- /#wrapper -->
		<%@include file="includes/footer.jsp" %>
	</body>
</html>