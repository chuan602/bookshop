<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>修改分类</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="<c:url value='/bootstrap/css/bootstrap.min.css'/>">
<style type="text/css">
	html, body{
		width: 100%;
		height: 100%;
		box-sizing: border-box;
		overflow: hidden;
	}
	body {
		background-image: url("<c:url value='/images/canton.jpg'/>");
		background-size: 100% 100%;
		background-position: center;
		padding: 20px;
	}
	h1{
		margin-bottom: 20px;
	}
	.btn-primary{
		margin-left: 5px;
	}
</style>
  </head>
  
  <body>
    <h1>修改分类</h1>
    <form  class="form-group form-inline" action="<c:url value ='/admin/AdminCategoryServlet'/>" method="post">
    	<input type="hidden" name="method" value="edit"/>
    	<input type="hidden" name="cid" value="${category.cid }" />
    	<label>分类名称：</label>
    	<input type="text" class="form-control" name="cname" value="${category.cname }"/>
    	<input class="btn btn-primary" type="submit" value="确认修改"/>
    </form>
  </body>
</html>
