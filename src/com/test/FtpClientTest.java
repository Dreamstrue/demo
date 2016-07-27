package com.test;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPListParseEngine;
import org.apache.commons.net.ftp.FTPReply;

import sun.net.TelnetInputStream;


public class FtpClientTest {
	public FTPClient ftpClient = new FTPClient();
	public FileInputStream inFile = null;  
    public InputStream in = null; 
    public StringBuffer resultBuffer = new StringBuffer();
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
//			ftpClient.setControlEncoding("GBK");
			ftpClient.connect(ip, port);
			ftpClient.login(username, password);
			if (!FTPReply.isPositiveCompletion(ftpClient.getReplyCode())) {  
                //logger.info("未连接到FTP，用户名或密码错误。");  
                ftpClient.disconnect();  
            } else {  
                //logger.info("FTP连接成功。");  
            }
		} catch (IOException ex) {
//			logger.error("连接FTP时异常："+ex.getMessage());
			//TODO 短信通知相关人员处理
		}
	}
	/**
	 * 关闭FTP
	 */
	public void closeFtpConnect() {
		try {
			ftpClient.disconnect();
		} catch (IOException ex) {
//			logger.error("关闭FTP时异常："+ex.getMessage());
			//TODO 短信通知相关人员处理
		}
	}
	
	public static void main(String[] args) {
		FtpClientTest ftts = new FtpClientTest();
		try {
		
			ftts.connectFtpServer("192.168.9.250", 21, "administrator", "124567");
			ftts.ftpClient.setControlEncoding("UTF-8"); // 中文支持  
			ftts.ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);  
			ftts.ftpClient.enterLocalPassiveMode();  
			FTPFile[] ftpArr = ftts.ftpClient.listFiles("/circulationInfo/factory001/20160701/product001");
			for(FTPFile ff : ftpArr){
				if(ff.isFile()){
					System.out.println(ff.getName());
					ftts.ftpClient.changeWorkingDirectory("/circulationInfo/factory001/20160701/product001");  
					ftts.in = ftts.ftpClient.retrieveFileStream(ff.getName());
					if (ftts.in != null) {  
						BufferedReader br = new BufferedReader(new InputStreamReader(ftts.in));  
						String data = null;  
						try {  
							while ((data = br.readLine()) != null) {  
								ftts.resultBuffer.append(data + "\n");  
							}  
						} catch (IOException e) {  
//                logger.error("文件读取错误。");  
							e.printStackTrace();  
						}finally{  
							ftts.closeFtpConnect();  
						}  
					}else{  
//            logger.error("in为空，不能读取。");  
					}
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		FtpTimeTaskService ftts = new FtpTimeTaskService();
//		ftts.connectFtpServer("192.168.9.250", 21, "administrator", "124567");
//		try {
//			TelnetInputStream tis = ftts.ftpClient.nameList("/circulationInfo/factory001/20160701/product001");
//			DataInputStream dis = new DataInputStream(tis);
//			String filename = "";  
//			while((filename = dis.readLine()) != null){
//				System.out.println(filename);
////            	TelnetInputStream tiss = ftts.ftpClient.get(filename);
//				InputStreamReader isr = new InputStreamReader(dis,"GBK");
//				BufferedReader bufferedReader = new BufferedReader(isr);
//				String lineTxt = null;
//				while((lineTxt = bufferedReader.readLine()) != null){
//					System.out.println(lineTxt);
//				}
//				isr.close();
//				System.out.println("\n##########################################\n");
//			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			ftts.closeFtpConnect();
//		}
	}
	
}
