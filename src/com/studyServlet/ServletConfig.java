package com.studyServlet;

import java.util.Enumeration;

import javax.servlet.ServletContext;

public abstract interface ServletConfig
{
  public abstract String getServletName();

  public abstract ServletContext getServletContext();

  public abstract String getInitParameter(String paramString);

  public abstract Enumeration<String> getInitParameterNames();
}