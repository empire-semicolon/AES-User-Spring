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
							<h2 class="page-header">Edit Profile</h2>
						</div>
						<!-- /.col-lg-12 -->
					</div>
					<% UserBean user = (UserBean)request.getAttribute("account"); %>
					<div class="row">
						<div class="col-lg-2">
							<a href="#" class="thumbnail">
								<img src="../images/placeholder-400x400.png" alt="...">
							</a>
						</div>

						<div class="col-lg-8">
							<form class="form-horizontal" role="form">
								<div class="form-group">
									<label  class="col-sm-3 control-label"><strong>First Name</strong></label>
									<div class="col-sm-7">
										<input class="form-control"  value="<%= user.getStrFirstName()%>">
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label"><strong>Last Name</strong></label>
									<div class="col-sm-7">
										<input class="form-control" id="inputPassword3" value="<%= user.getStrLastName()%>">
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label"><strong>Username</strong></label>
									<div class="col-sm-7">
										<input class="form-control" id="inputPassword3"  value="<%= user.getStrUserName() %>">
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label"><strong>Business Unit</strong></label>
									<div class="col-sm-7">
										<input class="form-control" id="inputPassword3"  value="<%= user.getStrBusinessUnit()%>">
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label"><strong>Position</strong></label>
									<div class="col-sm-7">
										<input class="form-control" id="inputPassword3"  value="<%= user.getStrPosition() %>">
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label"><strong>Email</strong></label>
									<div class="col-sm-7">
										<input class="form-control" id="inputPassword3"  value="<%= user.getStrEmail()%>">
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-3 control-label"></label>
									<div class="col-sm-7">                              
										<button type="submit" class="btn btn-primary">Submit</button>
										<button class="btn btn-danger">Cancel</button>
									</div>
								</div>
							</form>
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