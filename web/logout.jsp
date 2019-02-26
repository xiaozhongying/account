<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%
dswork.sso.WebFilter.logout(session);
common.auth.AuthUtil.logout(request);
session.invalidate();
response.sendRedirect(dswork.sso.WebFilter.getLogoutURL(request.getContextPath() + "/manage/frame/index.jsp"));


%>