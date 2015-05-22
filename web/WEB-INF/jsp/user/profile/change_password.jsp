<%@page import="com.aes.model.UserBean"%>
<% UserBean user = (UserBean)request.getAttribute("account"); %>
<div class="row">
	<div class="col-lg-12">
		<h2 class="page-header">Change Password</h2>
	</div>
	<!-- /.col-lg-12 -->
	<div class="row">
		<div class="col-lg-2">
			
		</div>
		<div class="col-lg-8">
			<form class="form-horizontal" role="form">
				<div class="form-group">
					<label for="inputEmail3" class="col-sm-3 control-label"><strong>Username</strong></label>
					<div class="col-sm-7">
						<%= user.getStrUserName() %>
					</div>
				</div>
				<div class="form-group">
					<label for="inputPassword3" class="col-sm-3 control-label"><strong>Old Password</strong></label>
					<div class="col-sm-7">
						<input class="form-control" type="password" value="">
					</div>
				</div>
				<div class="form-group">
					<label for="inputPassword3" class="col-sm-3 control-label"><strong>New Password</strong></label>
					<div class="col-sm-7">
						<input class="form-control" type="password" value="">
					</div>
				</div>
				<div class="form-group">
					<label for="inputPassword3" class="col-sm-3 control-label"><strong>Confirm Password</strong></label>
					<div class="col-sm-7">
						<input class="form-control" type="password" value="">
					</div>
				</div>
				<div class="form-group">
					<label for="inputPassword3" class="col-sm-3 control-label"></label>
					<div class="col-sm-7">                              
						<button type="submit" class="btn btn-primary">Submit</button>
						<button type="reset" class="btn btn-default">Reset</button>
						<button class="btn btn-danger">Cancel</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>