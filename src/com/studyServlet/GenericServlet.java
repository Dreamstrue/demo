package com.studyServlet;

import java.io.IOException;
import java.io.Serializable;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
/**
 * 
 * @author GF
 *
 */
public abstract class GenericServlet implements Servlet, ServletConfig,Serializable {
	private static final long serialVersionUID = 1L;
	private transient ServletConfig config;
	/**
	 * 创建自己的init无参方法
	 * @throws ServletException
	 */
	public void init() throws ServletException {
	}
	/**
	 * 创建自己的记录日志log方法
	 */
	public void log(String msg) {
		getServletContext().log(getServletName() + ": " + msg);
	}
	/**
	 * 创建自己的记录异常log方法
	 */
	public void log(String message, Throwable t) {
		getServletContext().log(getServletName() + ": " + message, t);
	}
	//#########################实现Servlet接口中的所有方法##############################################################################################################
	/**
	 * 实现Servelt接口的init方法，并将ServletConfig存入自身的属性config中
	 */
	public void init(ServletConfig config) throws ServletException {
		this.config = config;
		init();
	}
	/**
	 * 实现Servelt接口的getServletConfig方法
	 */
	public ServletConfig getServletConfig() {
		return this.config;
	}
	/**
	 * Servelt接口的service方法
	 */
	public abstract void service(ServletRequest paramServletRequest,ServletResponse paramServletResponse) throws ServletException,IOException;
	/**
	 * 实现Servelt接口的getServletInfo方法，默认返回空字符串
	 */
	public String getServletInfo() {
		return "";
	}
	/**
	 * 实现Servelt接口的destroy方法
	 */
	public void destroy() {
	}
	//#######################################################################################################################################
	//￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥实现ServletConfig接口中的方法￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥
	/**
	 * 实现ServletConfig接口中的getServletName方法
	 */
	public String getServletName() {
		return this.config.getServletName();
	}
	/**
	 * 实现ServletConfig接口中的getServletContext方法
	 */
	public ServletContext getServletContext() {
		return getServletConfig().getServletContext();
	}
	/**
	 * 实现ServletConfig接口中的getInitParameter方法
	 */
	public String getInitParameter(String name) {
		return getServletConfig().getInitParameter(name);
	}
	/**
	 * 实现ServletConfig接口中的getInitParameterNames方法
	 */
	public Enumeration<String> getInitParameterNames() {
		return getServletConfig().getInitParameterNames();
	}
}