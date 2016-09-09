package com.parseTxt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;

public class ParseTxt {
	private static String encoding = "utf-8";
	private static String outFilePath = "E:/workSpaces/demo/test1.doc";

	public static void readTxtFile(String filePath) {
		try {
			File file = new File(filePath);
			int level = 1;
			FileOutputStream fo = new FileOutputStream(outFilePath);
			OutputStreamWriter osw = new OutputStreamWriter(fo);
			BufferedWriter bw = new BufferedWriter(osw);
			dealFile(file, level,bw);
			bw.close();
			osw.close();
			fo.close();
		} catch (Exception e) {
			System.out.println("读取文件内容出错");
			e.printStackTrace();
		}

	}

	private static void dealFile(File file, int level,BufferedWriter bw) {
		int level_ = level + 1;
		if (file.isDirectory()) {
			System.out.println("此文件是目录！对其进行继续迭代！");
			File[] arrFile = file.listFiles();
			for (File f : arrFile) {
				String msg = "第" + level + "级：" + f.getName();
				System.out.println(msg);
				writeMsgToDoc(msg,bw);
				dealFile(f, level_,bw);
			}
		} else {
			System.out.println(file.getName() + "不是目录！对其进行解析！");
			writeToDoc(file,bw);
		}
	}

	/**
	 * 将文件解析插入doc文档
	 * @param file
	 */
	private static void writeToDoc(File file,BufferedWriter bw) {
		try {
			if (file.isFile() && file.exists()) { // 判断文件是否存在
				InputStreamReader read = new InputStreamReader(new FileInputStream(file), encoding);// 考虑到编码格式
				BufferedReader bufferedReader = new BufferedReader(read);
				String line = bufferedReader.readLine();
				while (line != null) {
					System.out.println(line);
					bw.write(line);
					bw.newLine();
					bw.flush();
					line = bufferedReader.readLine();
				}
				bufferedReader.close();
				read.close();
			} else {
				System.out.println("找不到指定的文件");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	/**
	 * 将一段字符串插入doc文档
	 * @param msg
	 */
	private static void writeMsgToDoc(String msg,BufferedWriter bw){
		try {

			String line = msg;
			bw.write(line);
			bw.newLine();
			bw.flush();

		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static void main(String argv[]) {
		String filePath = "E:/workSpaces/zxt/src/com/guangfan/zxt/surveymanage";
		readTxtFile(filePath);
	}

}