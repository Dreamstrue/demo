<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<script type="text/javascript" src="js/jquery-1.8.0.min.js" charset="utf-8"></script>
<script type="text/javascript">


$(function(){
Wilq32=window.Wilq32||{};
Wilq32.PhotoEffect=(function(){//【(function(){/* code */})()】表示自执行函数

	if (true) {
		alert(222)
		return function(){
			alert(000)
		}
	} else {
		alert(333);
	}
})();
alert(2);
	var element = $("#tbo");
	if(element.Wilq32.PhotoEffect){
		alert(true);
	};

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
		<tbody id="tbo" style="height: 1000px;width:1000px;">
		</tbody>
	</table>
</body>
</html>
