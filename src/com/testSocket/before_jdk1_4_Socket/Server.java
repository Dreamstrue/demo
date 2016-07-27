package com.testSocket.before_jdk1_4_Socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args) {
		try {
			//创建一个ServerSocket实例坚挺8080端口
			ServerSocket server = new ServerSocket(8080);
			//等待请求
			Socket socket = server.accept();
			//接收到请求后使用socket进行通信，创建BufferedReader用于读取数据
			BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String data = null;
			StringBuffer sb = new StringBuffer();
			sb.append("received from client:\n");
			int i = 0 ;
			while ((data = is.readLine()) != null&&!data.equals("")){
				sb.append(data+"\n");
				i++;
//				System.out.println(i);
			}
			System.out.println(sb.toString());
			//创建PrintWriter，用于发送数据
			PrintWriter pw = new PrintWriter(socket.getOutputStream());
			pw.println(" received data : \n"+sb.toString());
			pw.flush();
			//关闭资源
			pw.close();
			is.close();
			socket.close();
			server.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
