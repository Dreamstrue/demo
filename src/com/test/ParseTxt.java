package com.test;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ParseTxt {
	@SuppressWarnings("unchecked")
	public String[] readfile(String filepath) throws Exception {
		FileReader fr = new FileReader(filepath);
		// 将无法识别的字节赋值为'?'
		int c = 63;
		String errmessage = "文件编码不是GBK，不能解析";
		try {
			// 从文件中读取一个字符
			c = fr.read();
		} catch (Exception e) {
			try {
				fr.skip(1);
			} catch (Exception ex) {
				throw new Exception(errmessage, ex);
			}
			c = 63;
		}
		StringBuffer sb = new StringBuffer();
		List list = new ArrayList();
		while (c != -1) {
			// 遇到回车符时保存该行内容，刷新缓存
			if (c == 10) {
				list.add(sb.toString());
				sb = new StringBuffer();
				try {
					// 从文件中继续读取数据
					c = fr.read();
				} catch (Exception e) {
					try {
						fr.skip(1);
					} catch (Exception ex) {
						throw new Exception(errmessage, ex);
					}
					c = 63;
				}
				continue;
			}
			sb.append((char) c);
			try {
				// 从文件中继续读取数据
				c = fr.read();
			} catch (Exception e) {
				try {
					fr.skip(1);
				} catch (Exception ex) {
					throw new Exception(errmessage, ex);
				}
				c = 63;
			}
		}
		// 保存最后一行内容
		if (c == -1 && sb.length() > 0) {
			list.add(sb.toString());
		}
		fr.close();
		// 返回从文本文件中读取的内容
		Object[] obj = list.toArray();
		String[] objs = new String[obj.length];
		for (int i = 0; i < obj.length; i++) {
			objs[i] = (String) obj[i];
		}
		return objs;
	}

	public static void main(String[] args) {
//		ParseTxt trt = new ParseTxt();
//		try {
//			String[] line = trt.readfile("E:/workSpaces/demo/src/com/test/test.txt");
//			for (int i = 0; i < line.length; i++) {
//				System.out.print(line[i].toString());
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		File file = new File("E:/workSpaces/demo/src/com/test");
		File[] fileArr = file.listFiles();
		for(File f : fileArr){
			System.out.println(f.getAbsolutePath());
		}
	}
}
