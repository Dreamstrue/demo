package com.parseTxt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;

public class ParseTxtToDoSth {
	public static void main(String argv[]) {
		String rePath = "E:/workSpaces/pqts_interface/delete.txt";
        try {
            String encoding="GBK";
            File file=new File(rePath);
            if(file.isFile() && file.exists()){ //判断文件是否存在
                InputStreamReader read = new InputStreamReader(
                new FileInputStream(file),encoding);//考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                while((lineTxt = bufferedReader.readLine()) != null){
                	String batchId = lineTxt;
                	//TODO 处理你想处理的逻辑
//                	tagSNBaseService.deleteSnBaseBySNBatchId(batchId);//
                }
                read.close();
    }else{
        System.out.println("找不到指定的文件");
    }
    } catch (Exception e) {
        System.out.println("读取文件内容出错");
        e.printStackTrace();
    }
	}

}