<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<script type="text/javascript" src="js/jquery-1.12.3.js" charset="utf-8"></script>
<script type="text/javascript">
//定义树枝对象
function TreeBranch(id){
	this.id = id;//树枝的唯一标识id
	this.moveId = id;//随着树枝的生长这是它最新生长的id
	this.leftOrRight = "";//此树枝是树干还是左边树枝亦或者是右边数值：R右树枝，M树干，L左树枝
	this.intervalId="";//周期运行的id
	this.length=1;//树枝长度，其实长度为1
	this.branchArray=new Array(10);//存储分支的树枝id,每一个树枝最多可以有十个分支
	this.grow=function(){//启动树枝开始生长
			this.intervalId = setInterval(growAction,1000,this);
		}
};
//获取生长方向上的坐标
function growDirection(id){
	//首先第一次随机获取0或者1，1表示正上方生长；0表示左上方生长或者右上方生长
	var d1 = getRandomNum(1);
	if(d1==1){
		//获取正上方生长的坐标
		return getCoordinate(1,id);
	}else{
		//第二次随机获取0或者1，0表示左上方生长;1表示右上方生长
		var d2 = getRandomNum(1);
		if(d2==1){
			//获取右上方生长的坐标
			return getCoordinate(3,id);
		}else{
			//获取左上方生长的坐标
			return getCoordinate(0,id);
		}
	}
}
//获取坐标
function getCoordinate(c,id){
	//0表示左上方；1表示正上方；2表示右上方
	var arr=id.split("_");
	var x = parseInt(arr[0])-1;
	var y = parseInt(arr[1]);
	if(c==0){
		y = y - 1;
	}else if(c==1){
		y = y;
	}else{
		y = y + 1;
	}
	return x+"_"+y
	
}
//获取左右的坐标
function getLeftRightCoordinate(c,id){
	//0表示左；1表示右
	var arr=id.split("_");
	var x = parseInt(arr[0]);
	var y = parseInt(arr[1]);
	if(c==0){
		y = y - 1;
	}else{
		y = y + 1;
	}
	return x+"_"+y
	
}
//树枝生长函数
function growAction(obj){
	/**
	 *让树枝obj生长一节
	**/
	//1.首先获取生长方向上的坐标
	var shengzhangzuobiao = growDirection(obj.moveId);
	//2.修改生长坐标的颜色并更新moveId的值
	$("#"+shengzhangzuobiao).css({background:getColorRandomNum()});
	obj.moveId = shengzhangzuobiao;
	//3.修改树枝长度
	obj.length = obj.length+1;
	//4.是否生长新树枝：如果本树枝的长度为5的倍数则有50%的几率生长出新树枝
	if(obj.length%5==0){
		if(getRandomNum(1)==1){//随机一个0或1,1表示生成新树枝，0表示不生成
			//4.1 获取新树枝坐标
			var newc = getLeftRightCoordinate(getRandomNum(1),obj.moveId)
			//4.2为新树枝坐标填涂颜色
			$("#"+newc).css({background:getColorParam()});
			//4.3创建爱你新树枝对象
			var newtb = new TreeBranch(newc);
			//4.4启动新树枝生长
			newtb.grow();
			//4.5修改obj的branchArray的值
			obj.branchArray[obj.branchArray.length] = newtb;
		}
	}
}
//获取指定范围内的一个随机数
function getRandomNum(p){//如果p为3，那么可能的随机数为0,1,2,3
	var num = Math.round(Math.random()*p);
	return num;
}
function getColorRandomNum(){
	var num = Math.round(Math.random()*15);
	var str = getLetter(num);
	return str;
}
function getLetter(param){
		var s16="";
		switch (param) {
			case 10:
				s16 = "A";
				break;
			case 11:
				s16 = "B";
				break;
			case 12:
				s16 = "C";
				break;
			case 13:
				s16 = "D";
				break;
			case 14:
				s16 = "E";
				break;
			case 15:
				s16 = "F";
				break;
			default:
				s16 = param+"";
				break;
		}
		return s16;
}
//获取一个x行y列的表格
function buildTable(x,y){
	var color = "#00FFFF";
	for ( var int = 0; int < x; int++) {
		if(int>69){
			color="#CD853F";
		}
		var tr = "<tr id='tr"+int+"'></tr>"
		$("#myTable").append(tr);
		for ( var int2 = 0; int2 < y; int2++) {
			if(int==79&&int2==99){
				color="#8B4500";
			}else if(int==79){
				color="#CD853F";
			}
			var td = "<td id='"+int+"_"+int2+"' style='width:10px;height:10px;padding:0 0 0 0;background:"+color+";'></td>";
			$("#tr"+int).append(td);
		}
	}
}

function getColorParam(){

return "#"+getColorRandomNum()+getColorRandomNum()+getColorRandomNum()+getColorRandomNum()+getColorRandomNum()+getColorRandomNum();

}







$(function(){
	//创建table
	buildTable(90,200);
	//获取指定的td绑定事件
	$("#79_99").click(function(){
	    var firstTreeBranch = new TreeBranch("79_99");
	    firstTreeBranch.leftOrRight="M"
		firstTreeBranch.grow();//开始生长
	});

})

function test(){

	var str = "79_55";

	var arr = str.split("_");
	
	alert(arr.length);
	var x = parseInt(14);
	var y = parseInt(5);
	
	var z = x%y;
// 	alert(z);
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
	<button onclick="test();">开始</button>
</body>
</html>
