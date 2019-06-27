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
	<style type="text/css">
		body {
			margin: 0;
			font-family: '微软雅黑';
			background-color: #0c8484;
			background-image: url("../../images/bookshop.jpg");
			background-position: center;
			background-repeat: no-repeat;
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
			right: 10px;
			color: #FFF;
		}
	</style>
  </head>
  
  <body>
	<h1 class="title">维也纳金色书店后台管理</h1>
	<div class="tool-bar">
		<p style="font-size: 11pt;">管理员：张三</p>
	</div>
  </body>
</html>
