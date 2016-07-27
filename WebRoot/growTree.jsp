<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<script type="text/javascript" src="js/jquery-1.12.3.js" charset="utf-8"></script>
<script type="text/javascript" src="js/common/utilTree.js" charset="utf-8"></script>
<script type="text/javascript">
$(function(){
	//创建table
	buildTable(tableheightX,tablewidthY);
	var begin_zb = seedX+"_"+seedY
	//获取指定的td绑定事件
	$("#"+begin_zb).click(function(){
	    var firstTreeBranch = new TreeBranch(begin_zb);
	    firstTreeBranch.level = "1";
	    firstTreeBranch.leftOrRight="M"
		firstTreeBranch.grow();//开始生长
	});

})

function test(){

	var str = "79_55";

	var arr = str.split("_");
	
// 	alert(arr.length);
	var x = parseInt(14);
	var y = parseInt(5);
	
	var z = x%y;
// 	alert($("#79_55").attr('isColor'));
	$("#79_55").attr('isColor','0')
// 	alert($("#79_55").attr('isColor'));
// 	alert(z);

var p = parseInt(4)+1+"";
alert(p);
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
	<table id ="myTable" border=0 cellpadding="0" cellspacing="0">
	</table>
<!-- 	<div style="width:100px;height:100px;background:#008000;"></div> -->
	<button onclick="test();">开始</button>
</body>
</html>
