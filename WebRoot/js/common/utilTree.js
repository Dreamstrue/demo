var tableheightX= 200;
var tablewidthY = 200;
var seedX = 188;
var seedY = 99;
var tdWidth = 5;
var tdHeight= 5;
//定义树枝对象
function TreeBranch(id){
	this.id = id;//树枝的唯一标识id
	this.moveId = id;//随着树枝的生长这是它最新生长的id
	this.leftOrRight = "";//此树枝是树干还是左边树枝亦或者是右边数值：R右树枝，M树干，L左树枝
	this.level = "";//树枝等级，主树干式一级，主树干的分支是二级，分支的分支是三级，以此类推...
	this.intervalId="";//周期运行的id
	this.length=1;//树枝长度，起始长度为1
	this.branchArray=new Array(10);//存储分支的树枝id,每一个树枝最多可以有十个分支
	this.grow=function(){//启动树枝开始生长
			this.intervalId = setInterval(growAction,100,this);
		}
};
//获取生长方向上的坐标
function growDirection(obj){
	//首先判断主干还是分支，主干只往正上方生长，右边分支往右上方或者上方生长，左边分支从左上方或者上方生长
	if(obj.leftOrRight=="M"){//主干
		return getCoordinate(1,obj.moveId);
	}else{
		if(obj.level=="2"){
			if(obj.leftOrRight=="R"){//2级右树枝
				//50%右上方坐标，30%正上方，20%左方
				var lr = getRandomNum(9);
				if(lr<5){
					return getCoordinate(2,obj.moveId);
				}else if(lr>7){
					return getCoordinate(3,obj.moveId);
				}else{
					return getCoordinate(1,obj.moveId);
				}
			}else{//2级左树枝
				//50%左上方坐标，30%正上方，20%右方
				var lr = getRandomNum(9);
				if(lr<5){
					return getCoordinate(0,obj.moveId);
				}else if(lr>7){
					return getCoordinate(4,obj.moveId);
				}else{
					return getCoordinate(1,obj.moveId);
				}
			}
		}else if(obj.level=="3"){
			if(obj.leftOrRight=="R"){//3级右树枝
				//50%右方坐标，30%右上方，20%正上方
				var lr = getRandomNum(9);
				if(lr<5){
					return getCoordinate(4,obj.moveId);
				}else if(lr>7){
					return getCoordinate(1,obj.moveId);
				}else{
					return getCoordinate(2,obj.moveId);
				}
			}else{//3级左树枝
				//50%左方坐标，30%左上方,20%正上方，
				var lr = getRandomNum(9);
				if(lr<5){
					return getCoordinate(3,obj.moveId);
				}else if(lr>7){
					return getCoordinate(1,obj.moveId);
				}else{
					return getCoordinate(0,obj.moveId);
				}
			}
		}else{
			if(obj.leftOrRight=="R"){//多级右树枝
				//50%右方坐标，30%右上方，20%正上方
				var lr = getRandomNum(9);
				if(lr<5){
					return getCoordinate(4,obj.moveId);
				}else if(lr>7){
					return getCoordinate(1,obj.moveId);
				}else{
					return getCoordinate(2,obj.moveId);
				}
			}else{//多级左树枝
				//50%左方坐标，30%左上方,20%正上方，
				var lr = getRandomNum(9);
				if(lr<5){
					return getCoordinate(3,obj.moveId);
				}else if(lr>7){
					return getCoordinate(1,obj.moveId);
				}else{
					return getCoordinate(0,obj.moveId);
				}
			}
		}
	}
}
//获取坐标
function getCoordinate(c,id){
	//0表示左上方；1表示正上方；2表示右上方；3表示左方；4表示右方；
	var arr=id.split("_");
	var x = parseInt(arr[0]);
	var y = parseInt(arr[1]);
	if(c==0){
		y = y - 1;
		x = x - 1;
	}else if(c==1){
		x = x - 1;
	}else if(c==2){
		y = y + 1;
		x = x - 1;
	}else if(c==3){
		y = y - 1;
	}else if(c==4){
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
	var shengzhangzuobiao = growDirection(obj);
	//如果坐标到达边界值或者为负值的话就终止树枝的生长
	var flag = checkValue(shengzhangzuobiao);
	if(flag){
		clearInterval(obj.intervalId);
	}else{
		//2.判断生长坐标是否已经填充过颜色
		if($("#"+shengzhangzuobiao).attr('isColor')=="1"){
			//终止此树枝对象的继续生长
			clearInterval(obj.intervalId);
		}else{
			//3.修改生长坐标的颜色和isColor的值并更新moveId的值,修改树枝长度
			$("#"+shengzhangzuobiao).css({background:"#8B4500"});
			$("#"+shengzhangzuobiao).attr('isColor','1');
			//将此坐标的左右随机生成一个绿叶
			var greenId = getLeftRightCoordinate(getRandomNum(1),obj.moveId)
			if(!checkValue(greenId)){
				//有50%的几率生成绿叶
				if(getRandomNum(1)==1&&obj.leftOrRight!="M"){
					$("#"+greenId).css({background:"#008000"});
					$("#"+greenId).attr('isColor','1');
				}
			}
			obj.moveId = shengzhangzuobiao;
			obj.length = obj.length+1;
			//长出新分支
			growNewBranch(obj);
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
		if(int>170){
			color="#CD853F";
		}
		var tr = "<tr id='tr"+int+"'></tr>"
		$("#myTable").append(tr);
		for ( var int2 = 0; int2 < y; int2++) {
			if(int==188&&int2==99){
				color="#8B4500";
			}else if(int==188){
				color="#CD853F";
			}
			var td = "<td id='"+int+"_"+int2+"' isColor='0' style='width:"+tdWidth+"px;height:"+tdHeight+"px;padding:0 0 0 0;background:"+color+";'></td>";
			$("#tr"+int).append(td);
		}
	}
}
//获取随机色
function getColorParam(){

return "#"+getColorRandomNum()+getColorRandomNum()+getColorRandomNum()+getColorRandomNum()+getColorRandomNum()+getColorRandomNum();

}
//校验是否打到编辑值
function checkValue(id){
	var arr=id.split("_");
	var x = parseInt(arr[0]);
	var y = parseInt(arr[1]);
	if(x<0||x>tableheightX||y<0||y>tablewidthY){
		return true;
	}else{
		return false;
	}
	
}
//4.是否生长新树枝：如果本树枝的长度为5的倍数则有50%的几率生长出新树枝
function growNewBranch(obj){
	var flag = false;
	if(obj.leftOrRight=="M"&&obj.length>19){
		flag = true;
	}else if(obj.leftOrRight!="M"){
		flag = true;
	}
	if(flag&&obj.length%5==0){
		var rdn = getRandomNum(1);
		//4.1 获取新树枝坐标
		var newc = getLeftRightCoordinate(rdn,obj.moveId)
		if(!checkValue(newc)){
			//4.2为新树枝坐标填涂颜色
			$("#"+newc).css({background:"#8B4500"});
			$("#"+newc).attr('isColor','1');
			//4.3创建新树枝对象
				var newtb = new TreeBranch(newc);
				if(rdn==0){
					newtb.leftOrRight="L";
				}else{
					newtb.leftOrRight="R";
				}
				newtb.level = parseInt(obj.level)+1+"";
				//4.4启动新树枝生长
				newtb.grow();
				//4.5修改obj的branchArray的值
				obj.branchArray[obj.branchArray.length] = newtb;
		}
	}
}
