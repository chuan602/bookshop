<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>top</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
<style type="text/css">
	body {
		margin: 0;
		font-family: '微软雅黑';
		background-image: url("../images/bookshop.jpg");
		background-position: center;
		background-repeat: no-repeat;
		background-color: rgba(255,255,255,0.5);
		background-size: 100% auto;
		display: flex;
		-ms-display: flex;
		align-items: center;
		-ms-align-items: center;
		justify-content: center;
		-ms-justify-content: center;
	}
	a {
		text-transform:none;
		color: #FFF;
		text-decoration:none;
	} 
	a:hover {
		text-decoration:underline;
	}
	.title{
		color: #FFF;
		font-size: 40px;
		text-shadow: 5px 5px 5px #000;
		-ms-text-shadow: 3px 3px 10px #000;
		letter-spacing: 5px;
		text-align: center;
	}
	.tool-bar {
		position: absolute;
		bottom: 2px;
		right: 15px;
		color: #FFF;
	}
</style>
  </head>
  
  <body>
	<h1 class="title">维也纳金色书店</h1>
	<div class="tool-bar">
		<c:choose>
				<c:when test="${empty sessionScope.session_user }">
					<a href="<c:url value='/jsps/user/login.jsp'/>" target="_parent">登录</a>&nbsp;|&nbsp; 
					<a href="<c:url value='/jsps/user/regist.jsp'/>" target="_parent">注册</a>&nbsp;|&nbsp;
					<a href="<c:url value='/adminjsps/login.jsp'/>" target="_parent">管理者登陆</a>
				</c:when>
			
				<c:otherwise>
				您好：${sessionScope.session_user.username}&nbsp;&nbsp;|&nbsp;&nbsp;
				<a href="<c:url value='/jsps/cart/list.jsp'/>" target="body">我的购物车</a>&nbsp;&nbsp;|&nbsp;&nbsp;
				<a href="<c:url value='/OrderServlet?method=myOrders'/>" target="body">我的订单</a>&nbsp;&nbsp;|&nbsp;&nbsp;
				<a href="<c:url value='/UserServlet?method=quit'/>" target="_parent">退出</a>
				<br/>
				</c:otherwise>
		</c:choose>
	</div>
  </body>
</html>
