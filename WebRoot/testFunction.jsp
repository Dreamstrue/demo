<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<script type="text/javascript" src="js/jquery-1.8.0.min.js" charset="utf-8"></script>
<script type="text/javascript">

//匿名函数的调用方式
(function(){alert("匿名函数的调用方式一");})();
(function(){alert("匿名函数的调用方式二");}());
// function(){alert("匿名函数的调用方式二");}();//由于表达式【function(){alert("匿名函数的调用方式二");}】是一个合法的独立的语法格式，所有页面语法校验无法识别【()】
// function sm(){alert("匿名函数的调用方式二");}();//如果在声明的sm函数后面加上()，同样语法校验不会通过


var i = function(){return 10;}();//如果匿名函数前加上运算符，比如= - ！ new等符号和关键字时，就表明这是一个函数表达式
alert("i:"+i);
var j = 1&&function(){return true;}();
alert("j:"+j);

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
