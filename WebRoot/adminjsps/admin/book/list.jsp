<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>图书分类</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<link rel="stylesheet" type="text/css" href="<c:url value='/bootstrap/css/bootstrap.min.css'/>">
<style type="text/css">
	html, body{
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
	.icon {
		margin: 10px;
		padding-left: 5px;
		padding-right: 5px;
		border: 1px solid #eee;
		width: 160px;
		height: 200px;
		text-align: center;
		float: left;
	}
	.img-box{
		display: block;
		height: 150px;
		overflow: hidden;
		margin-bottom: 5px;
	}
	.img-box img{
		width: 100%;
	}
	.icon:hover img {
		transform: scaleX(1.1) scaleY(1.1);
		transform-origin: center center;
		transition: all 0.5s 
	}
</style>
  </head>
  
  <body>
  
  <c:forEach items ="${bookList }" var="book" >
   <div class="icon">
    <a class="img-box" href="<c:url value='/admin/AdminBookServlet?method=load&bid=${book.bid }'/>">
    	<img src="<c:url value='/${book.image }'/>" border="0"/>
    </a>
   	<a href="<c:url value='/admin/AdminBookServlet?method=load&bid=${book.bid }'/>">${book.bname}</a>
  </div>
   </c:forEach>
  
  </body>
 
</html>

