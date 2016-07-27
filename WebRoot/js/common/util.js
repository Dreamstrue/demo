//定义对象
function objectColor(id){
	this.id = id;
	this.intervalId="";
	this.currentColor="";
	this.cycleRun=function(){
			this.intervalId = setInterval(changeColor,10,this);
		}
};
//改变某个页面元素的背景色
function changeColor(obj){
// alert("intervalId=="+obj.id);
// alert("currentColor=="+obj.currentColor);
	if(obj.currentColor=="#8B008B"){
		clearInterval(obj.intervalId);
	}else{
		var p = "#"+getRandomNum()+getRandomNum()+getRandomNum()+getRandomNum()+getRandomNum()+getRandomNum();
		obj.currentColor = p;
		$("#"+obj.id).css({background:p});
	}
}

function getRandomNum(){
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
	for ( var int = 0; int < x; int++) {
		var tr = "<tr id='tr"+int+"'></tr>"
		$("#myTable").append(tr);
		for ( var int2 = 0; int2 < y; int2++) {
			var td = "<td id='"+int+"_"+int2+"' style='width:10px;height:10px;padding:0 0 0 0;'></td>";
			$("#tr"+int).append(td);
		}
	}
}
