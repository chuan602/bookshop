<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>分类列表</title>
    
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
	}
	table {
		font-family: 宋体; font-size: 11pt; border-color: rgb(78,78,78);  width: 60%;
		margin: 20px;
	}
</style>
  </head>
  
  <body>
    <h2 style="text-align: center;">分类列表</h2>
    <table class="table table-striped">
    	<tr>
    		<th>分类名称</th>
    		<th>操作</th>
    	</tr>
  <c:forEach items ="${categoryList }" var ="category" >
    	<tr bordercolor="rgb(78,78,78)">
    		<td>${category.cname }</td>
    		<td>
    		  <a href="<c:url value='/admin/AdminCategoryServlet?method=editPre&cid=${category.cid }'/>">修改</a> |
    		  <a  onclick = "return confirm('您真的要删除吗')" href="<c:url value='/admin/AdminCategoryServlet?method=delete&cid=${category.cid }'/>">删除</a>
    		</td>
    	</tr>
  </c:forEach> 
    </table>
  </body>
</html>
