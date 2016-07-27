<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<script type="text/javascript" src="js/jquery-1.12.3.js" charset="utf-8"></script>
<script type="text/javascript">
jQuery.extend( {
	flatOptions: {//添加静态属性
		url: true,
		context: true
	}
} )

function test(){
	var result=$.extend({},{name:"Tom",age:21},{name:"Jerry",sex:"Boy"})
	alert(result.name);
}
</script>

<title>ajax源码</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
</head>

<body>
	<table border="1">
		<tbody id="tbo" style="height: 5000px;width:5000px;">
		</tbody>
		<a href="javascript:void(0);" onclick="test();">测试</a>
	</table>
</body>
</html>
