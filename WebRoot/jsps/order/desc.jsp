<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>订单详细</title>
    
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
	html, body {
		width: 100%;
		box-sizing: border-box;
	}
	body{
		margin: 0;
		padding: 0;
	}
	body{
		padding: 10px;
	}
	li {
		margin: 10px;
	}
	#pay{
		width: 50px;
	}
	.current-order, .order-owner-msg{
		border-left: 5px solid orange;
		padding-left: 20px;
		font-size: 26px;
		letter-spacing: 5px;
	}
	.img{
		width: 40px;
		height: 60px;
	}
	table.table>tbody>tr>td{
		vertical-align: middle;
	}
	#form{
		width: 50%;
	}
	.btn{
		width: 50px;
	}
</style>
  </head>
  
  <body>
	<h1 class="current-order">当前订单</h1>
	
	<table class="table table-hover">
		<tr>
			<td colspan="2">订单编号：${order.oid }</td>
			<td colspan="2" align="center">成交时间：<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${order.ordertime }"/></td>　
			<td colspan="2" align="center">金额：<font color="red"><b>${order.total }元</b></font></td>			
		</tr>
	
		<c:forEach items="${order.orderItemList }" var="orderItem">
			<tr>
				<td>
					<img class="img" src="<c:url value='/${orderItem.book.image }'/>"/>
				</td>
				<td>书名：${orderItem.book.bname }</td>
				<td>单价：${orderItem.book.price }元</td>
				<td>作者：${orderItem.book.author }</td>
				<td>数量：${orderItem.count }</td>
				<td>小计：${orderItem.subtotal }元</td>
			</tr>
		</c:forEach>
	</table>
	<br/>
	<h1 class="order-owner-msg">收货人信息</h1>
	<form method="post" action="<c:url value='/OrderServlet'/>" id="form" target="_parent">
		<input type ="hidden" name="method"	value="zhiFu"/>
		<input type="hidden" name="oid" value ="${order.oid}"/>
		<div class="form-group">
			<label>收货人：</label>
			<input class="form-control" type="text" name="name" size="50" placeholder="请输入收货人姓名"/>
		</div>
		<div class="form-group">
			<label>手机号码：</label>
			<input class="form-control" type="text" name="tele" size="50" placeholder="请输入收货人手机号码"/>
		</div>
		<div class="form-group">
			<label>收货地址：</label>
			<input class="form-control" type="text" name="address" size="50" placeholder="请输入收货地址"/>
		</div>
	</form>
	<button class="btn btn-warning" id="pay" href="javascript:document.getElementById('form').submit();">付款</button>

  </body>
</html>

