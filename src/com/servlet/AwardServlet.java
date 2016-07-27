package com.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * 抽奖概率算法来自：http://www.helloweba.com/view-blog-216.html
 */
public class AwardServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Object[][] prizeArr = new  Object[][]{
				//id,min,max，prize【奖项】,v【中奖率】
				//外面的转盘转动
//				{1,1,14,"一等奖",1},
//				{2,346,364,"一等奖",1},
//				{3,16,44,"不要灰心",10},
//				{4,46,74,"神马也没有",10},
//				{5,76,104,"祝您好运",10},
//				{6,106,134,"二等奖",2},
//				{7,136,164,"再接再厉",10},
//				{8,166,194,"神马也没有",10},
//				{9,196,224,"运气先攒着",10},
//				{10,226,254,"三等奖",5},
//				{11,256,284,"要加油哦",10},
//				{12,286,314,"神马也没有",10},
//				{13,316,344,"谢谢参与",10}	
				
				//里面的指针转动
				{1,1,14,"一等奖",1},
				{2,346,364,"一等奖",1},
				{3,16,44,"不要灰心",10},
				{4,46,74,"神马也没有",10},
				{5,76,104,"祝您好运",10},
				{6,106,134,"二等奖",2},
				{7,136,164,"再接再厉",10},
				{8,166,194,"神马也没有",10},
				{9,196,224,"运气先攒着",10},
				{10,226,254,"三等奖",5},
				{11,256,284,"要加油哦",10},
				{12,286,314,"神马也没有",10},
				{13,316,344,"谢谢参与",10}
		};
		Object result[] = award(prizeArr);//抽奖后返回角度和奖品等级
//		response.setContentType("text/html;charset=UTF-8");
//		response.getWriter().write("{\"angle\":\""+result[0]+"\",\"msg\":\""+result[2]+"\"}");
		System.out.println("转动角度:"+result[0]+"\t奖项ID:"+result[1]+"\t提示信息:"+result[2]);
	}
	
	//抽奖并返回角度和奖项
	public Object[] award(Object[][] prizeArr){
		//概率数组
		Integer obj[] = new Integer[prizeArr.length];
		for(int i=0;i<prizeArr.length;i++){
			obj[i] = (Integer) prizeArr[i][4];
		}
		Integer prizeId = getRand(obj); //根据概率获取奖项id
		//旋转角度
		int angle = new Random().nextInt((Integer)prizeArr[prizeId][2]-(Integer)prizeArr[prizeId][1])+(Integer)prizeArr[prizeId][1];
		String msg = (String) prizeArr[prizeId][3];//提示信息
		return new Object[]{angle,prizeId,msg};
	}
	
	//根据概率获取奖项
	public Integer getRand(Integer obj[]){
		Integer result = null;
		try {
			int  sum = 0;//概率数组的总概率精度 
			for(int i=0;i<obj.length;i++){
				sum+=obj[i];
			}
			for(int i=0;i<obj.length;i++){//概率数组循环 
				int randomNum = new Random().nextInt(sum);//随机生成1到sum的整数
				if(randomNum<obj[i]){//中奖
					result = i;
					break;
				}else{
					sum -=obj[i];
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	
	
	public static void main(String[] args) {
		AwardServlet as = new AwardServlet();
		HttpServletRequest request = new HttpServletRequest() {
			
			public void setCharacterEncoding(String arg0)
					throws UnsupportedEncodingException {
				// TODO Auto-generated method stub
				
			}
			
			public void setAttribute(String arg0, Object arg1) {
				// TODO Auto-generated method stub
				
			}
			
			public void removeAttribute(String arg0) {
				// TODO Auto-generated method stub
				
			}
			
			public boolean isSecure() {
				// TODO Auto-generated method stub
				return false;
			}
			
			public int getServerPort() {
				// TODO Auto-generated method stub
				return 0;
			}
			
			public String getServerName() {
				// TODO Auto-generated method stub
				return null;
			}
			
			public String getScheme() {
				// TODO Auto-generated method stub
				return null;
			}
			
			public RequestDispatcher getRequestDispatcher(String arg0) {
				// TODO Auto-generated method stub
				return null;
			}
			
			public int getRemotePort() {
				// TODO Auto-generated method stub
				return 0;
			}
			
			public String getRemoteHost() {
				// TODO Auto-generated method stub
				return null;
			}
			
			public String getRemoteAddr() {
				// TODO Auto-generated method stub
				return null;
			}
			
			public String getRealPath(String arg0) {
				// TODO Auto-generated method stub
				return null;
			}
			
			public BufferedReader getReader() throws IOException {
				// TODO Auto-generated method stub
				return null;
			}
			
			public String getProtocol() {
				// TODO Auto-generated method stub
				return null;
			}
			
			public String[] getParameterValues(String arg0) {
				// TODO Auto-generated method stub
				return null;
			}
			
			public Enumeration getParameterNames() {
				// TODO Auto-generated method stub
				return null;
			}
			
			public Map getParameterMap() {
				// TODO Auto-generated method stub
				return null;
			}
			
			public String getParameter(String arg0) {
				// TODO Auto-generated method stub
				return null;
			}
			
			public Enumeration getLocales() {
				// TODO Auto-generated method stub
				return null;
			}
			
			public Locale getLocale() {
				// TODO Auto-generated method stub
				return null;
			}
			
			public int getLocalPort() {
				// TODO Auto-generated method stub
				return 0;
			}
			
			public String getLocalName() {
				// TODO Auto-generated method stub
				return null;
			}
			
			public String getLocalAddr() {
				// TODO Auto-generated method stub
				return null;
			}
			
			public ServletInputStream getInputStream() throws IOException {
				// TODO Auto-generated method stub
				return null;
			}
			
			public String getContentType() {
				// TODO Auto-generated method stub
				return null;
			}
			
			public int getContentLength() {
				// TODO Auto-generated method stub
				return 0;
			}
			
			public String getCharacterEncoding() {
				// TODO Auto-generated method stub
				return null;
			}
			
			public Enumeration getAttributeNames() {
				// TODO Auto-generated method stub
				return null;
			}
			
			public Object getAttribute(String arg0) {
				// TODO Auto-generated method stub
				return null;
			}
			
			public boolean isUserInRole(String arg0) {
				// TODO Auto-generated method stub
				return false;
			}
			
			public boolean isRequestedSessionIdValid() {
				// TODO Auto-generated method stub
				return false;
			}
			
			public boolean isRequestedSessionIdFromUrl() {
				// TODO Auto-generated method stub
				return false;
			}
			
			public boolean isRequestedSessionIdFromURL() {
				// TODO Auto-generated method stub
				return false;
			}
			
			public boolean isRequestedSessionIdFromCookie() {
				// TODO Auto-generated method stub
				return false;
			}
			
			public Principal getUserPrincipal() {
				// TODO Auto-generated method stub
				return null;
			}
			
			public HttpSession getSession(boolean arg0) {
				// TODO Auto-generated method stub
				return null;
			}
			
			public HttpSession getSession() {
				// TODO Auto-generated method stub
				return null;
			}
			
			public String getServletPath() {
				// TODO Auto-generated method stub
				return null;
			}
			
			public String getRequestedSessionId() {
				// TODO Auto-generated method stub
				return null;
			}
			
			public StringBuffer getRequestURL() {
				// TODO Auto-generated method stub
				return null;
			}
			
			public String getRequestURI() {
				// TODO Auto-generated method stub
				return null;
			}
			
			public String getRemoteUser() {
				// TODO Auto-generated method stub
				return null;
			}
			
			public String getQueryString() {
				// TODO Auto-generated method stub
				return null;
			}
			
			public String getPathTranslated() {
				// TODO Auto-generated method stub
				return null;
			}
			
			public String getPathInfo() {
				// TODO Auto-generated method stub
				return null;
			}
			
			public String getMethod() {
				// TODO Auto-generated method stub
				return null;
			}
			
			public int getIntHeader(String arg0) {
				// TODO Auto-generated method stub
				return 0;
			}
			
			public Enumeration getHeaders(String arg0) {
				// TODO Auto-generated method stub
				return null;
			}
			
			public Enumeration getHeaderNames() {
				// TODO Auto-generated method stub
				return null;
			}
			
			public String getHeader(String arg0) {
				// TODO Auto-generated method stub
				return null;
			}
			
			public long getDateHeader(String arg0) {
				// TODO Auto-generated method stub
				return 0;
			}
			
			public Cookie[] getCookies() {
				// TODO Auto-generated method stub
				return null;
			}
			
			public String getContextPath() {
				// TODO Auto-generated method stub
				return null;
			}
			
			public String getAuthType() {
				// TODO Auto-generated method stub
				return null;
			}
		};
		HttpServletResponse response= new HttpServletResponse() {
			
			public void setLocale(Locale arg0) {
				// TODO Auto-generated method stub
				
			}
			
			public void setContentType(String arg0) {
				// TODO Auto-generated method stub
				
			}
			
			public void setContentLength(int arg0) {
				// TODO Auto-generated method stub
				
			}
			
			public void setCharacterEncoding(String arg0) {
				// TODO Auto-generated method stub
				
			}
			
			public void setBufferSize(int arg0) {
				// TODO Auto-generated method stub
				
			}
			
			public void resetBuffer() {
				// TODO Auto-generated method stub
				
			}
			
			public void reset() {
				// TODO Auto-generated method stub
				
			}
			
			public boolean isCommitted() {
				// TODO Auto-generated method stub
				return false;
			}
			
			public PrintWriter getWriter() throws IOException {
				// TODO Auto-generated method stub
				return null;
			}
			
			public ServletOutputStream getOutputStream() throws IOException {
				// TODO Auto-generated method stub
				return null;
			}
			
			public Locale getLocale() {
				// TODO Auto-generated method stub
				return null;
			}
			
			public String getContentType() {
				// TODO Auto-generated method stub
				return null;
			}
			
			public String getCharacterEncoding() {
				// TODO Auto-generated method stub
				return null;
			}
			
			public int getBufferSize() {
				// TODO Auto-generated method stub
				return 0;
			}
			
			public void flushBuffer() throws IOException {
				// TODO Auto-generated method stub
				
			}
			
			public void setStatus(int arg0, String arg1) {
				// TODO Auto-generated method stub
				
			}
			
			public void setStatus(int arg0) {
				// TODO Auto-generated method stub
				
			}
			
			public void setIntHeader(String arg0, int arg1) {
				// TODO Auto-generated method stub
				
			}
			
			public void setHeader(String arg0, String arg1) {
				// TODO Auto-generated method stub
				
			}
			
			public void setDateHeader(String arg0, long arg1) {
				// TODO Auto-generated method stub
				
			}
			
			public void sendRedirect(String arg0) throws IOException {
				// TODO Auto-generated method stub
				
			}
			
			public void sendError(int arg0, String arg1) throws IOException {
				// TODO Auto-generated method stub
				
			}
			
			public void sendError(int arg0) throws IOException {
				// TODO Auto-generated method stub
				
			}
			
			public String encodeUrl(String arg0) {
				// TODO Auto-generated method stub
				return null;
			}
			
			public String encodeURL(String arg0) {
				// TODO Auto-generated method stub
				return null;
			}
			
			public String encodeRedirectUrl(String arg0) {
				// TODO Auto-generated method stub
				return null;
			}
			
			public String encodeRedirectURL(String arg0) {
				// TODO Auto-generated method stub
				return null;
			}
			
			public boolean containsHeader(String arg0) {
				// TODO Auto-generated method stub
				return false;
			}
			
			public void addIntHeader(String arg0, int arg1) {
				// TODO Auto-generated method stub
				
			}
			
			public void addHeader(String arg0, String arg1) {
				// TODO Auto-generated method stub
				
			}
			
			public void addDateHeader(String arg0, long arg1) {
				// TODO Auto-generated method stub
				
			}
			
			public void addCookie(Cookie arg0) {
				// TODO Auto-generated method stub
				
			}
		};
		try {
			as.doGet(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
