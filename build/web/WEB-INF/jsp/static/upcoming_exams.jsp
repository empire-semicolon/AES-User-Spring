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
							<h2 class="page-header">Upcoming Exams</h2>
						</div>
						<!-- /.col-lg-12 -->
					</div>
					<!-- /.row -->
					<div class="row">
						<div class="col-lg-12">
							<div class="panel panel-default">
								<div class="panel-body">
									<div class="table-responsive">
										<table class="table table-striped">
											<thead>
												<tr>
													<th>Title</th>
													<th>Course</th>
													<th>Due</th>
													<th>Time Limit</th>
													<th></th>
												</tr>
											</thead>
											<tbody>
												<tr>
													<td>Java Assessment</td>
													<td>J2EE Intermediate</td>
													<td>May 15, 2015 11:59pm</td>
													<td>90 mins</td>
													<td>
														<a href="take_exam.jsp">
															<button type="button" class="btn btn-primary">Take Exam</button>
														</a>
													</td>
												</tr>
											</tbody>
										</table>
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