package com.ftpPool;  
  
import java.io.IOException;  
import java.net.SocketException;
  
public class FtpConnectionPoolingTest extends Thread {  
  
    private static int n = 0;  
  
    private static int m = 1;  
  
    public void run() {  
            /********************业务代码调用样例*********************/  
            System.out.println(m++);  
            FtpClientProxy ftpClientProxy;
			try {
				ftpClientProxy = new FtpClientProxy();
            String t = "连接" + ++n;  
            System.out.println(t + "连接成功,端口号：" + ftpClientProxy.getLocalPort());  
            sleep(1000);  
            System.out.println(t + "释放连接");  
            ftpClientProxy.release();// 释放连接  
			} catch (SocketException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
            /***************************************************/  
    }  
  
    public static void main(String[] args) {  
        /************需要在服务器启动时进行加载**************/  
        FtpClientInfo ftpClientInfo = new FtpClientInfo();  
        ftpClientInfo.setFtpIp("192.168.135.85");  
        ftpClientInfo.setFtpPassword("test");  
        ftpClientInfo.setFtpPort(21);  
        ftpClientInfo.setFtpUserName("test");  
        ftpClientInfo.setMaxConnects(20);  
        FtpConnectionPooling.init(ftpClientInfo);  
        /*******************************************/  
  
        /*************************************************************/  
        try {
            FtpClientProxy ftpClientProxy1 = new FtpClientProxy();  
            System.out.println("本地端口" + ftpClientProxy1.getLocalPort());  
            ftpClientProxy1.release();  
            ftpClientProxy1.release();  
            FtpClientProxy ftpClientProxy2;
				ftpClientProxy2 = new FtpClientProxy();
				System.out.println("本地端口" + ftpClientProxy2.getLocalPort());  
				ftpClientProxy2.release();  
			} catch (SocketException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
  
        /*************************并发测试*******************************/  
        for (int i = 1; i <= 40; i++) {  
            FtpConnectionPoolingTest test = new FtpConnectionPoolingTest();  
            test.start();  
        }  
    }  
}