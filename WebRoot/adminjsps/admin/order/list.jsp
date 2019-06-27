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

	<c:forEach items="${orderList}" var = "order">
		<table class="table table-striped">
			<tr>
				<td colspan="2">
					订单编号：${order.oid }
				</td>
				<td colspan="2">
					成交时间：${order.ordertime }
				</td>
				<td>
					金额：<font color="red"><b>${order.total}</b></font>
				</td>
				<td>
					<c:choose>
						<c:when test="${order.state eq 1 }">等待买家付款</c:when>
						<c:when test="${order.state eq 2 }"><a href="<c:url value='/AdminOrderServlet?method=sendOrders&oid=${order.oid}'/>">买家已付款，准备发货</a></c:when>
						<c:when test="${order.state eq 3 }">等待买家收货</c:when> 
						<c:when test="${order.state eq 4 }">买家确认收货，本订单结束</c:when>		
					</c:choose>	
				</td>	
			</tr>
			<c:forEach items="${order.orderItemList}" var ="orderItem">
				<tr>
					<td width="10%">
						<img class="img" src="<c:url value='/${orderItem.book.image }'/>"/>
					</td>
					<td>书名：${orderItem.book.bname }</td>
					<td>单价：${orderItem.book.price}元</td>
					<td>作者：${orderItem.book.author}</td>
					<td>数量：${orderItem.count}</td>
					<td>小计：${orderItem.subtotal }元</td>
				</tr>
			</c:forEach>
		</table>
	</c:forEach>
</body>
</html>
