package com.servlet;

import java.util.Random;

public class ActionSt {

	
	public int getAnumber(){
		Random rd = new Random();
		int num = rd.nextInt(256);
		return num;
	}
	
	public String getRGBStr(){
		String result = "";
		int nu = this.getAnumber();
		while(nu/16!=0){
			int n16 = nu/16;

			result =  result + getLetter(n16);
			nu = nu%16;
		}
		result = result +getLetter(nu%16);
		return result;
	}
	private String getLetter(int n) {
		String s16="";
		switch (n) {
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
			s16 = n+"";
			break;
		}
		return s16;
	}

	public static void main(String[] args) {
		ActionSt as = new ActionSt();
//			
			System.out.println("#"+as.getRGBStr()+as.getRGBStr()+as.getRGBStr());
//		}
	}
}
