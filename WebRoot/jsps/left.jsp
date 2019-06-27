<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>left</title>
<base target="body" />
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<meta http-equiv="content-type" content="text/html;charset=utf-8">
<link rel="stylesheet" type="text/css" href="<c:url value='/bootstrap/css/bootstrap.min.css'/>">
<style type="text/css">
body {
	margin-left: 0;
	margin-right: 0;
}

* {
	font-size: 10pt;
	text-align: center;
}

div {
	background: #87CEFA;
	margin: 3px;
	padding: 3px;
}

a {
	text-decoration: none;
}
a:focus,a:hover{
	outline: none;
}
li{
	outline: none;
}
.book-category, .else{
	font-size: 16px;
	font-family: "微软雅黑";
	letter-spacing: 5px;
}
.sub-item a{
	text-align: left;
}
</style>
</head>

<body>
	<ul class="nav nav-pills nav-stacked">
		<li class="active">
			<a class="book-category">书籍类别</a>
		</li>
		<li class="sub-item">
			<a class="show-list" href="<c:url value='/BookServlet?method=findAll'/>">所有图书</a>
		</li>
		<c:forEach items="${categoryList}" var="category">
			<li class="sub-item">
				<a href="<c:url value='/BookServlet?method=findByCategory&cid=${category.cid}'/>">${category.cname}</a>
			</li>
		</c:forEach>
		<li class="active">
			<a class="else">其他</a>
		</li>
		<li class="sub-item">
			<a href="<c:url value='/SearchServlet?method=search&keyword=""'/>">图书搜索</a>
		</li>
		<li class="sub-item">
			<a href="<c:url value='/jsps/report/report.jsp'/>">销售情况</a>
		</li>
	</ul>
</body>
<script type="text/javascript">
	var a = document.getElementsByClassName('show-list')[0];
	window.onload = function() {
		a.click();
		a.focus();
	}
</script>
</html>

