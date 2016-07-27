<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<script type="text/javascript" src="js/jquery-1.8.0.min.js" charset="utf-8"></script>
<script type="text/javascript">
//自定义智能小组件toolObject
function toolOjbect(x,y){
    this.id = x+","+y;
	this.x = x;
	this.y = y;
	this.intervalId = null;
}
//执行命令
toolOjbect.prototype.doSth = function (task){
	if(task=="red"){
		console.log("我是"+this.id+",我将要变成"+task+"色。");
	}else{
		console.log("我是"+this.id+",我现在没有事情做。");
	}
// 	console.log("我叫"+this.name+",今年"+this.age+"岁。");
}
//
toolOjbect.prototype.getLoaction = function(p){
	var x_ = 0;
	var y_ = 0;
	if(p==1){
		if(this.x==0||this.y==0){
			return "-1,-1"
		}else{
			x_ = this.x - 1;
			y_ = this.y - 1;
		}
	}else if(p==2){
		if(this.x==0||this.y==0){
			return "-1,-1"
		}else{
			x_ = this.x;
			y_ = this.y - 1;
		}	
	}else if(p==3){
		if(this.x==0||this.y==0){
			return "-1,-1"
		}else{
			x_ = this.x + 1;
			y_ = this.y - 1;
		}
	}else if(p==4){
		if(this.x==0||this.y==0){
			return "-1,-1"
		}else{
			x_ = this.x - 1;
			y_ = this.y;
		}
	}else if(p==6){
		x_ = this.x + 1;
		y_ = this.y;
	}else if(p==7){
		if(this.x==0||this.y==0){
			return "-1,-1"
		}else{
			x_ = this.x - 1;
			y_ = this.y + 1;
		}
	}else if(p=="8"){
		x_ = this.x;
		y_ = this.y + 1;
	}else if(p=="9"){
		x_ = this.x + 1;
		y_ = this.y + 1;
	}
	console.log(x_+","+y_);
	return x_+","+y_;
}
$(function(){

var object = new toolOjbect(2,2);
// object.doSth("red");
// object.getLoaction(1);
// object.getLoaction(2);
// object.getLoaction(3);
// object.getLoaction(4);
// object.getLoaction(6);
// object.getLoaction(7);

// object.getLoaction(8);
// object.getLoaction(9);
object.intervalId = setInterval("refresh("+object+")",2000);

})
function refresh(obj){
obj.doSth("red");
}
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
