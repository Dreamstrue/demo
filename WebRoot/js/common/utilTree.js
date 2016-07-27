var tableheightX= 200;
var tablewidthY = 200;
var seedX = 188;
var seedY = 99;
var tdWidth = 5;
var tdHeight= 5;
//������֦����
function TreeBranch(id){
	this.id = id;//��֦��Ψһ��ʶid
	this.moveId = id;//������֦����������������������id
	this.leftOrRight = "";//����֦�����ɻ��������֦��������ұ���ֵ��R����֦��M���ɣ�L����֦
	this.level = "";//��֦�ȼ���������ʽһ���������ɵķ�֧�Ƕ�������֧�ķ�֧���������Դ�����...
	this.intervalId="";//�������е�id
	this.length=1;//��֦���ȣ���ʼ����Ϊ1
	this.branchArray=new Array(10);//�洢��֧����֦id,ÿһ����֦��������ʮ����֧
	this.grow=function(){//������֦��ʼ����
			this.intervalId = setInterval(growAction,100,this);
		}
};
//��ȡ���������ϵ�����
function growDirection(obj){
	//�����ж����ɻ��Ƿ�֧������ֻ�����Ϸ��������ұ߷�֧�����Ϸ������Ϸ���������߷�֧�����Ϸ������Ϸ�����
	if(obj.leftOrRight=="M"){//����
		return getCoordinate(1,obj.moveId);
	}else{
		if(obj.level=="2"){
			if(obj.leftOrRight=="R"){//2������֦
				//50%���Ϸ����꣬30%���Ϸ���20%��
				var lr = getRandomNum(9);
				if(lr<5){
					return getCoordinate(2,obj.moveId);
				}else if(lr>7){
					return getCoordinate(3,obj.moveId);
				}else{
					return getCoordinate(1,obj.moveId);
				}
			}else{//2������֦
				//50%���Ϸ����꣬30%���Ϸ���20%�ҷ�
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
			if(obj.leftOrRight=="R"){//3������֦
				//50%�ҷ����꣬30%���Ϸ���20%���Ϸ�
				var lr = getRandomNum(9);
				if(lr<5){
					return getCoordinate(4,obj.moveId);
				}else if(lr>7){
					return getCoordinate(1,obj.moveId);
				}else{
					return getCoordinate(2,obj.moveId);
				}
			}else{//3������֦
				//50%�����꣬30%���Ϸ�,20%���Ϸ���
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
			if(obj.leftOrRight=="R"){//�༶����֦
				//50%�ҷ����꣬30%���Ϸ���20%���Ϸ�
				var lr = getRandomNum(9);
				if(lr<5){
					return getCoordinate(4,obj.moveId);
				}else if(lr>7){
					return getCoordinate(1,obj.moveId);
				}else{
					return getCoordinate(2,obj.moveId);
				}
			}else{//�༶����֦
				//50%�����꣬30%���Ϸ�,20%���Ϸ���
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
//��ȡ����
function getCoordinate(c,id){
	//0��ʾ���Ϸ���1��ʾ���Ϸ���2��ʾ���Ϸ���3��ʾ�󷽣�4��ʾ�ҷ���
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
//��ȡ���ҵ�����
function getLeftRightCoordinate(c,id){
	//0��ʾ��1��ʾ��
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
//��֦��������
function growAction(obj){
	/**
	 *����֦obj����һ��
	**/
	//1.���Ȼ�ȡ���������ϵ�����
	var shengzhangzuobiao = growDirection(obj);
	//������굽��߽�ֵ����Ϊ��ֵ�Ļ�����ֹ��֦������
	var flag = checkValue(shengzhangzuobiao);
	if(flag){
		clearInterval(obj.intervalId);
	}else{
		//2.�ж����������Ƿ��Ѿ�������ɫ
		if($("#"+shengzhangzuobiao).attr('isColor')=="1"){
			//��ֹ����֦����ļ�������
			clearInterval(obj.intervalId);
		}else{
			//3.�޸������������ɫ��isColor��ֵ������moveId��ֵ,�޸���֦����
			$("#"+shengzhangzuobiao).css({background:"#8B4500"});
			$("#"+shengzhangzuobiao).attr('isColor','1');
			//��������������������һ����Ҷ
			var greenId = getLeftRightCoordinate(getRandomNum(1),obj.moveId)
			if(!checkValue(greenId)){
				//��50%�ļ���������Ҷ
				if(getRandomNum(1)==1&&obj.leftOrRight!="M"){
					$("#"+greenId).css({background:"#008000"});
					$("#"+greenId).attr('isColor','1');
				}
			}
			obj.moveId = shengzhangzuobiao;
			obj.length = obj.length+1;
			//�����·�֧
			growNewBranch(obj);
		}
	}
}
//��ȡָ����Χ�ڵ�һ�������
function getRandomNum(p){//���pΪ3����ô���ܵ������Ϊ0,1,2,3
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
//��ȡһ��x��y�еı��
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
//��ȡ���ɫ
function getColorParam(){

return "#"+getColorRandomNum()+getColorRandomNum()+getColorRandomNum()+getColorRandomNum()+getColorRandomNum()+getColorRandomNum();

}
//У���Ƿ�򵽱༭ֵ
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
//4.�Ƿ���������֦���������֦�ĳ���Ϊ5�ı�������50%�ļ�������������֦
function growNewBranch(obj){
	var flag = false;
	if(obj.leftOrRight=="M"&&obj.length>19){
		flag = true;
	}else if(obj.leftOrRight!="M"){
		flag = true;
	}
	if(flag&&obj.length%5==0){
		var rdn = getRandomNum(1);
		//4.1 ��ȡ����֦����
		var newc = getLeftRightCoordinate(rdn,obj.moveId)
		if(!checkValue(newc)){
			//4.2Ϊ����֦������Ϳ��ɫ
			$("#"+newc).css({background:"#8B4500"});
			$("#"+newc).attr('isColor','1');
			//4.3��������֦����
				var newtb = new TreeBranch(newc);
				if(rdn==0){
					newtb.leftOrRight="L";
				}else{
					newtb.leftOrRight="R";
				}
				newtb.level = parseInt(obj.level)+1+"";
				//4.4��������֦����
				newtb.grow();
				//4.5�޸�obj��branchArray��ֵ
				obj.branchArray[obj.branchArray.length] = newtb;
		}
	}
}
