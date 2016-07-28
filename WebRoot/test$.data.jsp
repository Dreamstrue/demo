<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<script type="text/javascript" src="js/jquery-1.8.0.min.js" charset="utf-8"></script>
<script type="text/javascript">

	$(function(){
		var dom_ = $("#ddd").get(0);//将jquery对象转化为dom对象
		//向dom_元素中添加age属性，并设置它的值为18
		$.data(dom_,'age','18');
		//向dom_元素中添加name属性，并设置它的值为yyf
		$.data(dom_,'name','yyf');
		//获取dom_元素中所有的数据
		var tv = $.data(dom_);
		console.log(tv);
		console.log(tv.name);
		//获取dom_元素中age的值
		var ov = $.data(dom_,'age');
		console.log(ov);
	})

</script>

<title>自动</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
</head>

<body>
	<table border="1">
		<tbody id="tbo" style="height: 1000px;width:1000px;" data-tt="nmm">
		</tbody>
		
	</table>
	<div id = "ddd"  data-ss="nmm"></div>
</body>
</html>
