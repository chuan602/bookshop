<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>图书详细</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<meta http-equiv="content-type" content="text/html;charset=utf-8">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
body {
	font-size: 10pt;
}

div.img-box {
	margin: 30px;
	border: solid 1px #eee;
	width: 150px;
	height: 150px;
	text-align: center;
	float: left;
}

ul {
	list-style: none;
	margin: 0;
	padding: 0;
}

li {
	margin: 10px;
	margin-left: 0;
}

.price {
	color: #f40;
}
#form {
	display: block;
}
.submit {
	display: block;
	width: 100px;
	text-align: center;
	color: #FFF;
	height: 30px;
	line-height: 30px;
	border-width: 0;
	border-radius: 5px;
	background-color: #F40;
	margin-top: 10px;
	cursor: pointer;
	outline: none;
}
.submit:hover{
	background: #F10;
}
.detail{
	margin-top: 30px;
	margin-left: 15px;
	float: left;
}
</style>
</head>

<body>
	<div class="img-box">
		<img src="<c:url value='/${book.image}'/>" />
	</div>
	<div class="detail">
		<ul>
			<li class="price">单价：￥${book.price}</li>
			<li>书名：${book.bname}</li>
			<li>作者：${book.author }</li>
		</ul>
		<form id="form" action="<c:url value='/CartServlet'/>" method="post">
			<input type="hidden" name="method" value="add" />
			<input type="hidden" name="bid" value="${book.bid}" />
			数量： <input type="text" size="3" name="count" value="1" />
			<input class="submit" type="submit" value="加入购物车"/>
		</form>
	</div>
</body>
</html>
