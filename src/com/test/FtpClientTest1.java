package com.test;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.SocketException;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPListParseEngine;
import org.apache.commons.net.ftp.FTPReply;

import sun.net.TelnetInputStream;


public class FtpClientTest1 {
	private FTPClient ftpClient = new FTPClient();

	/**
	 * 连接ftp服务器
	 * 
	 * @param ip
	 * @param port
	 * @param user
	 * @param password
	 * @return
	 */
	public void connectFtpServer(String ip, int port, String username,String password) {
		try {
			ftpClient.connect(ip, port);
			ftpClient.login(username, password);
			if (!FTPReply.isPositiveCompletion(ftpClient.getReplyCode())) {  
				//TODO 通知相关人员，未连接到FTP的用户名或密码错误。");  
				ftpClient.disconnect();  
			} else {  
				//("FTP连接成功。");  
			}
		} catch (IOException e) {
			// TODO 通知相关人员 ，ftp服务器连接异常
			e.printStackTrace();
		}
	}
	public boolean parseTxtInsertDataBase(String filePath){
		try {
			ftpClient.changeWorkingDirectory("/circulationInfo/factory001/20160701/product001");
			String[] fileNameArr = ftpClient.listNames();
			for (String str : fileNameArr) { 
				
				InputStream in = ftpClient.retrieveFileStream(str);
				InputStreamReader isr = new InputStreamReader(in,"GBK");
				BufferedReader br = new BufferedReader(isr);  
				String data = null;
				StringBuffer resultBuffer = new StringBuffer();
				try {
					while ((data = br.readLine()) != null) {
						resultBuffer.append(data + "\n");  
					}
					System.out.println(resultBuffer.toString());
				} catch (IOException e) {  
					e.printStackTrace();  
				} finally {
					ftpClient.completePendingCommand();//完成未执行的命令
					if(in!=null){
						br.close();
						isr.close();
						in.close();
					}
				}
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		} finally {
			try {
				ftpClient.disconnect();
			} catch (IOException e) {
				// TODO 关闭失败
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		FtpClientTest1 fc = new FtpClientTest1();
		fc.connectFtpServer("192.168.9.250",21,"administrator","124567");
		fc.parseTxtInsertDataBase("");
	}
	
}
