<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<script type="text/javascript" src="js/jquery-1.8.0.min.js" charset="utf-8"></script>
<script type="text/javascript">
		var popType = {
			info: {
				title: "信息",
				icon: "0 0",//蓝色i
				btn: 1
			},
			success: {
				title: "成功",
				icon: "0 -48px",//绿色对勾
				btn: 1
			},
			error: {
				title: "错误",
				icon: "-48px -48px",//红色叉
				btn: 1
			},
			confirm: {
				title: "提示",
				icon: "-48px 0",//黄色问号
				btn: 1
			},
			warning: {
				title: "警告",
				icon: "0 -96px",//黄色叹号
				btn: 1
			},
			input: {
				title: "输入",
				icon: "",
				btn: 1
			},
			custom: {
				title: "",
				icon: "",
				btn: 1
			}
		};
$(function (){
var type = "info1";


var itype = type ? type instanceof Object ? type : popType[type] || {title:1234} : {title:123};//格式化输入的参数:弹窗类型


alert(itype.title);
});
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
