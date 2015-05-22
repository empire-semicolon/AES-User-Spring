<%-- 
    Document   : navbar
    Created on : May 18, 2015, 1:21:21 AM
    Author     : Mark
--%>

<%@page import="com.aes.model.UserBean"%>
<nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0; height: 50">
    <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="index.html">AES</a>
    </div>
    <!-- /.navbar-header -->
    <ul class="nav navbar-top-links navbar-right">
        <li class="dropdown">
            <a class="dropdown-toggle" data-toggle="dropdown" href="#">
							<% if(request.getAttribute("account") != null){
									String username = ((UserBean)request.getAttribute("account")).getStrUserName(); 
							%>
                <i class="fa fa-user fa-fw"></i> <%= username %> <i class="fa fa-caret-down"></i>
							<% } else { %>
								<i class="fa fa-user fa-fw"></i> kimagustin <i class="fa fa-caret-down"></i>
							<% }%>
            </a>
            <ul class="dropdown-menu dropdown-user">
                <li><a href="#"><i class="fa fa-user fa-fw"></i> User Profile</a>
                </li>
                <li class="divider"></li>
                <li><a href="login.html"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
                </li>
            </ul>
            <!-- /.dropdown-user -->
        </li>
        <!-- /.dropdown -->
    </ul>
    <!-- /.navbar-top-links -->
    <!-- Sidebar Navigation Here -->
    <jsp:include page="sidebar.jsp" />
    <!-- /.navbar-static-side -->
</nav>
