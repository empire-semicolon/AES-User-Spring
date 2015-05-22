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
							<h2 class="page-header">Java Assessment</h2>
						</div>
						<!-- /.col-lg-12 -->
					</div>
					<!-- /.row -->
					<div class="row">
						<div class="col-md-10">
							<div class="panel panel-default">
								<div class="panel-body">
									<div class="row">
										<div class="col-md-4">
											<strong>Due</strong>&nbsp;&nbsp;May 25, 2015 @ 11:59pm
										</div>
										<div class="col-md-4">
											<strong>Course</strong>&nbsp;&nbsp;J2EE Intermediate
										</div>
									</div>
									<div class="row">
										<div class="col-md-4">
											<strong>Time Limit</strong>&nbsp;&nbsp;60 mins
										</div>
										<div class="col-md-4">
											<strong>Points</strong>&nbsp;&nbsp;20
										</div>
										<div class="col-md-4">
											<strong>Questions</strong>&nbsp;&nbsp;20
										</div>
									</div>
									<hr/>
									<div class="row">
										<div class="col-md-6">
											<strong>Instructions</strong>
										</div>
									</div>
									<div class="row">
										<div class="col-md-12">
											<p>Description of the course, consectetur adipisicing elit, sed do eiusmod
											tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
											quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
											consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse
											cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non
											proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
										</div>
									</div>
									<div class="row">
										<div class="col-md-4 pull-right">
											<a href="exam.jsp">
												<button class="btn btn-primary">Start Exam</button>
											</a>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- /.container-fluid -->
			</div>
			<!-- /#page-wrapper -->
		</div>
		<!-- /#wrapper -->
		<%@include file="includes/footer.jsp" %>
	</body>
</html>