package com.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestParseTxt {

	public static void main(String[] args) {
		File file = new File("E:/workSpaces/demo/src/com/test/test1.txt");
		BufferedReader is;
		try {
			String data = null;
			is = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			int i = 0 ;
			while((data = is.readLine())!=null){
				i++;
				System.out.println(i);
				System.out.println(data);
			}
			System.out.println("over!!!!!!!!!!!!!!!!!!!");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
}
