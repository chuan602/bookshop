<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>订单列表</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<meta http-equiv="content-type" content="text/html;charset=utf-8">
<link rel="stylesheet" type="text/css"
	href="<c:url value='/bootstrap/css/bootstrap.min.css'/>">
<style type="text/css">
* {
	font-size: 11pt;
}

html, body {
	width: 100%;
	height: 100%;
	box-sizing: border-box;
}

body {
	background-image: url("<c:url value='/images/canton.jpg'/>");
	background-size: 100% 100%;
	background-position: center;
	padding: 20px;
}

div {
	border: solid 2px rgb(78, 78, 78);
	width: 75px;
	height: 75px;
	text-align: center;
}

li {
	margin: 10px;
}

.my-order {
	border-left: 5px solid orange;
	letter-spacing: 5px;
	font-size: 16px;
	margin-top: 10px;
	margin-bottom: 20px;
	padding-left: 10px;
}

.img {
	width: 40px;
	height: 60px;
}
table.table>tbody>tr>td{
	vertical-align: middle;
	text-align: center;
}
</style>
</head>

<body>
	<h1 class="my-order">我的订单</h1>

	<table class="table table-striped">
		<tr>
			<td colspan="2">
				订单：8691b4150a0641e7a8729fd5e668820c
			</td>
			<td colspan="2">
				成交时间：2013-06-04 15:56:53
			</td>
			<td>
				金额：<font color="red"><b>126.4</b></font>
			</td>
			<td>
				已收货（完成）
			</td>
		</tr>
		<tr align="center">
			<td width="10%"><img class="img"
				src="<c:url value='/book_img/20385925-1_l.jpg'/>" /></td>
			<td>书名：Struts2深入详解</td>
			<td>单价：63.2元</td>
			<td>作者：孙鑫</td>
			<td>数量：2</td>
			<td>小计：126.4元</td>
		</tr>

		<tr>
			<td colspan="6">订单：153839427aa94f359fe51932d9f9e383
				成交时间：2013-06-04 15:02:31 金额：<font color="red"><b>63.2</b></font> <a
				href="javascript:alert('发货成功！')">发货</a>
			</td>
		</tr>
		<tr align="center">
			<td width="10%"><img class="img"
				src="<c:url value='/book_img/20029394-1_l.jpg'/>" /></td>
			<td>书名：精通Spring2.x</td>
			<td>单价：63.2元</td>
			<td>作者：陈华雄</td>
			<td>数量：1</td>
			<td>小计：63.2元</td>
		</tr>

		<tr>
			<td colspan="6">订单：d1b85bfc71564b18bf7802582a9fd934 成交时间：2013-06-04 15:01:01
				金额：<font color="red"><b>137.0</b></font> 已收货（完成）
			</td>
		</tr>
		<tr align="center">
			<td width="10%"><img class="img"
				src="<c:url value='/book_img/20285763-1_l.jpg'/>" /></td>
			<td>书名：Java核心技术卷1</td>
			<td>单价：68.5元</td>
			<td>作者：qdmmy6</td>
			<td>数量：2</td>
			<td>小计：137.0元</td>
		</tr>

		<tr>
			<td colspan="6">订单：o1 成交时间：2013-06-04 12:47:41 金额：<font
				color="red"><b>100.0</b></font> 未付款
			</td>
		</tr>
		<tr align="center">
			<td width="10%"><img class="img" src="<c:url value='/book_img/9317290-1_l.jpg'/>" /></td>
			<td>书名：Java编程思想（第4版）</td>
			<td>单价：75.6元</td>
			<td>作者：qdmmy6</td>
			<td>数量：2</td>
			<td>小计：300.0元</td>
		</tr>
		<tr align="center">
			<td width="10%"><img class="img" src="<c:url value='/book_img/20285763-1_l.jpg'/>" /></td>
			<td>书名：Java核心技术卷1</td>
			<td>单价：68.5元</td>
			<td>作者：qdmmy6</td>
			<td>数量：3</td>
			<td>小计：500.0元</td>
		</tr>
	</table>
</body>
</html>
