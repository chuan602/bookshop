<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'body.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<style type="text/css">
		html, body {
			width: 100%;
			height: 100%;
			box-sizing: border-box;
		}
		body{
			margin: 0;
			padding: 0;
		}
	</style>
  </head>
  <body>
    <img src="<c:url value='/images/mycart.jpg'/>" width="100%" height="100%"/>
  </body>
</html>
