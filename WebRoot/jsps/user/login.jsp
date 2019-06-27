<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>登录</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<meta http-equiv="content-type" content="text/html;charset=utf-8">

<link rel="stylesheet" type="text/css" href="<c:url value='/bootstrap/css/bootstrap.min.css'/>">
<style type="text/css">
html,body{
	width: 100%;
	height: 100%;
	box-sizing: border-box;
	overflow: hidden;
}

body {
	margin: 0;
	background-image: url("../../images/bookshop.jpg");
	background-size: 100% 100%;
	background-color: rgba(255, 255, 255, 0.5);
}

.container {
	width: 400px;
	margin: 100px auto;
	box-shadow: 0px 0px 30px 0px #333;
	background-color: #fff;
	padding: 20px;
	border: 1px solid #eee;
	border-radius: 5px;
}

.login {
	text-align: center;
	margin-top: 0;
	font-family: '微软雅黑';
	letter-spacing: 20px;
	font-weight: 600;
}
.btn-primary{
	padding-left: 20px;
	padding-right: 20px;
}
</style>

</head>

<body>
	<div class="container">
		<h3 class="login">登录</h3>
		<p style="color: red; font-weight: 900">${msg }</p>
		<form action="<c:url value='/UserServlet'/>" method="post"
			target="_top">
			<input type="hidden" name="method" value="login" />
			<div class="form-group">
				<label>用户名：</label> <input class="form-control" type="text"
					name="username" value="${form.username}" /> <span
					style="color: red; font-weight: 900">${errors.username}</span>
			</div>
			<div class="form-group">
				<label>密码：</label>
				<input class="form-control" type="password" name="password" value="${form.password}" />
				<span style="color: red; font-weight: 900">${errors.password}</span>
			</div>
			<input type="submit" class="btn btn-primary" value="登录" />
		</form>
	</div>
</body>
</html>
