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
											<strong>Question #1</strong>
										</div>
									</div>
									<div class="row">
										<div class="col-md-12">
											<h6>OOP is an acronym for: </h6>
										</div>
									</div>
									<div class="row">
										<div class="col-md-12">
											<div class="radio">
												<label>
													<input type="radio" name="radio1" value="option1">
													Object-Oriented Programmer
												</label>
											</div>
											<div class="radio">
												<label>
													<input type="radio" name="radio1" value="option2">
													Object-Oriented Programming
												</label>
											</div>
											<div class="radio">
												<label>
													<input type="radio" name="radio1" value="option2">
													Outer-object programming
												</label>
											</div>
											<div class="radio">
												<label>
													<input type="radio" name="radio1" value="option2">
													Functional Programming
												</label>
											</div>
										</div>
									</div>
									<hr/>
									<div class="row">
										<div class="col-md-4">
											<strong>Question #2</strong>
										</div>
									</div>
									<div class="row">
										<div class="col-md-12">
											<h6> 1 + 1 = __ </h6>
										</div>
									</div>
									<div class="row">
										<div class="col-md-12">
											<div class="radio">
												<label>
													<input type="radio" name="radio2" value="option1">
													Zxc
												</label>
											</div>
											<div class="radio">
												<label>
													<input type="radio" name="radio2" value="option2">
													Asd
												</label>
											</div>
											<div class="radio">
												<label>
													<input type="radio" name="radio2" value="option2">
													Qwe
												</label>
											</div>
											<div class="radio">
												<label>
													<input type="radio" name="radio2" value="option2">
													Test
												</label>
											</div>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-4 pull-right">
										<ul class="pagination">
										<li><a href="#" class="disabled">&laquo;</a></li>
										<li><a href="#" class="active">1</a></li>
										<li><a href="#">2</a></li>
										<li><a href="#">3</a></li>
										<li><a href="#">&raquo;</a></li>
									</ul>
									</div>
								</div>
							</div>
						</div>
						<div class="col-md-2">
							<div class="panel panel-default">
								<div class="panel-heading">
									Time
								</div>
								<div class="panel-body">
									<h6>56 mins</h6>
								</div>
							</div>
						</div>
						<div class="col-md-2">
							<div class="panel panel-default">
								<div class="panel-heading">
									Questions Answered
								</div>
								<div class="panel-body">
									<h6>0/20</h6>
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