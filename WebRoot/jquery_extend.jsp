<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<script type="text/javascript" src="js/jquery-1.12.3.js" charset="utf-8"></script>
<script type="text/javascript" src="js/common/util.js" charset="utf-8"></script>
<script type="text/javascript">
//开始
function begin(){
	//创建table
	buildTable(90,200);
	//获取所有td遍历
	$("td").each(function(i){
		$(this).css({background:"#"+getRandomNum()+getRandomNum()+getRandomNum()+getRandomNum()+getRandomNum()+getRandomNum()});
		// 	获取td的id
		var tdid = $(this).attr("id");
		var oc = new objectColor(tdid);
		oc.cycleRun();
	});
}
//结束
function end(){
alert();
	clearInterval();
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
<div>
<button onclick="begin();">开始</button><button onclick="end();">结束</button>
</div>
	<table id ="myTable" border=0 cellpadding="0" cellspacing="0">
	</table>

<!--  <div id="divid" style="width: 500px;height:500px;"></div> -->
</body>
</html>
