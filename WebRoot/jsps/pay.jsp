<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'pay.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  
  成功了，你吗？
  <form action="<c:url value='/OrderServlet?method=payOrder'/>" method="post">
			<input type = "hidden" name = "oid" value = "03E44448CD34448E84688613EDC68132"/>
			<input type = "text" name="address" value=""/>
			<input type = "text" name="phone" value=""/>
			<input type="submit"  value="submit" />
		</form>
  
  </body>
</html>
