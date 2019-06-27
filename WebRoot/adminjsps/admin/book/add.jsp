<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>添加图书</title>
    
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
	}
	body {
		background-image: url("<c:url value='/images/canton.jpg'/>");
		background-size: 100% 100%;
		background-position: center;
		padding: 20px;
	}
	form.form{
		width: 50%
	}
	h1{
		margin-top: 10px;
		margin-bottom: 20px;
	}
</style>
  </head>
  
  <body>
    <h1>添加图书</h1>
    <p style="font-weight: 900; color: red">${msg }</p>
    <form class="form" action="<c:url value='/admin/AdminAddBookServlet'/>" method="post" enctype="multipart/form-data">
    	<div class="form-group">
    		<label>图书名称：</label>
    		<input class="form-control" type="text" name="bname"/>
    	</div>
    	<div class="form-group">
    		<label>图书图片：</label>
    		<input class="file-input" type="file" name="image"/>
    	</div>
    	<div class="form-group">
    		<label>图书单价：</label>
    		<input class="form-control" type="text" name="price"/>
    	</div>
    	<div class="form-group">
    		<label>图书作者：</label>
    		<input class="form-control" type="text" name="author"/>
    	</div>
    	<div class="form-group">
    		<label>图书分类：</label>
	    	<select class="form-control" name="cid">
	    		<c:forEach items="${categoryList }" var="category">
				<option value="${category.cid }">${category.cname }</option>
				</c:forEach>
	    	</select>
    	</div>
    	<input class="btn btn-primary" type="submit" value="添加图书"/>
    </form>
  </body>
</html>
