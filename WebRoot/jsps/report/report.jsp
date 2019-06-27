<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>图书列表</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<meta http-equiv="content-type" content="text/html;charset=utf-8">
<link rel="stylesheet" type="text/css" href="<c:url value='/bootstrap/css/bootstrap.min.css'/>">
<style type="text/css">
	body{
		margin: 0;
		height:100%;
		width: 100%;
		box-sizing: border-box;
		padding: 20px;
		background-image: url("<c:url value='/images/canton.jpg'/>");
		background-size: 100% 100%;
		background-position: center;
	}
	.title{
		border-left: 5px solid orange;
		letter-spacing: 5px;
		font-size: 26px;
		padding-left: 20px;
		margin-top: 0;
		margin-bottom: 20px;
	}
</style>
</head>

<body>
	
	<h2 class="title">销量榜</h2>
	<table class="table table-striped">
		<tr>
			<th>#</th>
			<th>图片</th>
			<th>书名</th>
			<th>价格</th>
			<th>销量</th>
		</tr>
		<tr>
			
		</tr>
	</table>
</body>

</html>

