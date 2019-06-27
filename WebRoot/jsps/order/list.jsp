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
<link rel="stylesheet" type="text/css" href="<c:url value='/bootstrap/css/bootstrap.min.css'/>">
<style type="text/css">
* {
	font-size: 11pt;
}
body{
	padding: 10px;
}
#buy {
	background: url(< c : url value = '/images/all.png'/ >) no-repeat;
	display: inline-block;
	background-position: 0 -902px;
	margin-left: 30px;
	height: 36px;
	width: 146px;
}
#buy:HOVER {
	background: url(< c : url value = '/images/all.png'/ >) no-repeat;
	display: inline-block;
	background-position: 0 -938px;
	margin-left: 30px;
	height: 36px;
	width: 146px;
}
.my-order{
	border-left: 5px solid orange;
	padding-left: 20px;
	font-size: 26px;
	letter-spacing: 5px;
}
.img{
	width: 40px;
	height: 60px;
}
th{
	text-align: center;
}
.have-not-order{
	padding: 30px;
	color: #ccc;
	font-size: 20px;
	font-style: italic;
	letter-spacing: 10px;
}
table.table>tbody>tr>td{
	vertical-align: middle;
}
.book-name {
	font-weight: 600;
}
</style>
</head>

<body>
	<h1 class="my-order">我的订单</h1>
	<c:if test="${empty orderList}"><p class="have-not-order">你当前还没有订单噢</p></c:if>
	<c:forEach items="${orderList}" var="order">
		<table class="table table-hover">
			<tr>
				<td colspan="2">订单编号：${order.oid }</td>
				<td colspan="2">成交时间：${order.ordertime }</td>
				<td align="center">金额：<font color="red"><b>${order.total}</b></font></td>
				<td align="center">
					<a onclick="confirm('确认删除？')" href="<c:url value='/OrderServlet?method=deleteOrders&oid=${order.oid}'/>">删除</a>&nbsp;|&nbsp;
					<c:choose>
						<c:when test="${order.state eq 1 }">
							<a href="<c:url value='/OrderServlet?method=load&oid=${order.oid}'/>">付款</a>
						</c:when>
						<c:when test="${order.state eq 2 }">等待发货</c:when>
						<c:when test="${order.state eq 3 }">
							<a href="<c:url value='/OrderServlet?method=confirm&oid=${order.oid}'/>">确认收货</a>
						</c:when>
						<c:when test="${order.state eq 4 }">订单结束</c:when>
					</c:choose>
				</td>
			</tr>
			<tr>
				<th>图片</th>
				<th>书名</th>
				<th>单价</th>
				<th>作者</th>
				<th>数量</th>
				<th>小计</th>
			</tr>
			<c:forEach items="${order.orderItemList}" var="orderItem">
				<tr align="center">
					<td width="10%">
						<img class="img" src="<c:url value='/${orderItem.book.image }'/>"/>
					</td>
					<td width="30%" class="book-name">${orderItem.book.bname }</td>
					<td width="20%">${orderItem.book.price}元</td>
					<td>${orderItem.book.author}</td>
					<td>${orderItem.count}</td>
					<td>${orderItem.subtotal }元</td>
				</tr>
			</c:forEach>
		</table>
	</c:forEach>
</body>
</html>
