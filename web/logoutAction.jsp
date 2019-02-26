<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%
String service = request.getParameter("service");
if(service == null || "".equals(service)){service = "index";}
dswork.sso.WebFilter.logout(session);
common.auth.AuthUtil.logout(request);
response.sendRedirect(dswork.sso.WebFilter.getLogoutURL(request.getContextPath() + "/"+service+".jsp"));
%>