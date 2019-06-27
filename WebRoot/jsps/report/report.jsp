<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>图书列表</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<meta http-equiv="content-type" content="text/html;charset=utf-8">
<link rel="stylesheet" type="text/css" href="<c:url value='/bootstrap/css/bootstrap.min.css'/>">
<style type="text/css">
	html{
		height:100%;
		width: 100%;
		box-sizing: border-box;
	}
	body{
		margin: 0;
		height:100%;
		width: 100%;
		box-sizing: border-box;
		padding: 20px;
		background-image: url("<c:url value='/images/canton.jpg'/>");
		background-size: 100% 100%;
		background-position: center;
	}
	.title{
		border-left: 5px solid orange;
		letter-spacing: 5px;
		font-size: 26px;
		padding-left: 20px;
		margin-top: 0;
		margin-bottom: 20px;
	}
	#main{
		margin-left: 30px;
	}
</style>
</head>

<body>
	
	<h2 class="title">销量榜</h2>
	<div id="main" style="width: 800px;height:400px;"></div>
	
</body>
<script src="<c:url value='/bootstrap/jquery-3.2.1.min.js'/>"></script>
<script src="<c:url value='/bootstrap/echarts.min.js'/>"></script>
<script type="text/javascript">
	// 基于准备好的dom，初始化echarts实例
	var myChart = echarts.init(document.getElementById('main'));
	
	//获取数据
	$.get('/bookstore/OrderServlet?method=sellSituation', function(res, status){
		res = JSON.parse(res);
		var data = res.map(function(item){return item.bname});
		console.log(data);
		// 指定图表的配置项和数据
		var option = {
		    title: {
		        text: '热门图书销售榜'
		    },
		    tooltip: {},
		    legend: {
		        data:['销量']
		    },
		    xAxis: {
		        data: data,
		        axisLabel:{
		        	interval:0
		        }
		    },
		    yAxis: {},
		    series: [{
		        name: '销量',
		        type: 'bar',
		        data: res.map(function(item){return item.totalCount})
		    }]
		};
		
		// 使用刚指定的配置项和数据显示图表。
		myChart.setOption(option);
	})
	
</script>
</html>

