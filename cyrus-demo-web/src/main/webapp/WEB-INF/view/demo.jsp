<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<title>Demo</title>
<%@include file="/include/common_js.jsp"%>
</head>
<body>
	<div ng-app="myApp" >
		<form class="form-horizontal" role="form" id="form" ng-controller="customersCtrl">
			<div class="form-group">
				<label class="col-sm-2 control-label"></label>
				<div class="col-sm-10">
					<h1>Demo</h1>
				</div>
			</div>
			<div class="form-group">
				<label for="firstname" class="col-sm-2 control-label">Username</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" ng-model="name" id="name"
						placeholder="Username">
				</div>
			</div>
			<div class="form-group">
				<label for="lastname" class="col-sm-2 control-label">Password</label>
				<div class="col-sm-10">
					<input type="password" class="form-control" ng-model="password" id="password"
						placeholder="Password">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<div class="checkbox">
						<label> <input type="checkbox"> Remember Me
						</label>
					</div>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" ng-click="clickSubmit()"
						class="btn btn-default">Submit</button>
				</div>
			</div>
		</form>
	</div>
	<script type="text/javascript" src="${ctx}/js/platform/demo.js"></script>
	<%-- <script type="text/javascript" src="${ctx}/js/platform/login.js"></script> --%>
</body>

</html>