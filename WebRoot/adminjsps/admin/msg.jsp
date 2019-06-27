<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'mgs.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
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
	</style>
  </head>
  <body>
<h2>${msg }</h2>
<ul>
<c:forEach items="${links }" var="link">
	<li>${link }</li>
</c:forEach>
</ul>
  </body>
</html>
