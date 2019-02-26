<%@page import="dswork.web.MyRequest"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page language="java" pageEncoding="UTF-8"%><%
String pwdurl=dswork.sso.WebFilter.getPasswordURL("/bs/login.html");
String path = request.getContextPath();
MyRequest req = new MyRequest(request);
boolean flag = false;
common.auth.Auth auth = common.auth.AuthUtil.getLoginUser(request);
if(auth == null)
{
	flag = true;
}
if(flag)
{
	response.sendRedirect(path + "/bs/login.jsp");
	return;
}

%>
<%@page language="java" contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
<title></title>
<meta charset="UTF-8" />
<link rel="stylesheet" type="text/css" href="js/jskey/themes/menu/jskey.menu.css" />
<script type="text/javascript" src="js/jskey/jskey.menu.js"></script>
<script type="text/javascript">
<%if("1".equals(auth.getType())){ %><!--业务操作员  -->
	var treedata = [
	{id:1000, name:'财务管理', img:"", imgOpen:"", url:"", items:[
		{id:1001,name:'客户欠款明细账', img:"", imgOpen:"", url:'/manage/account/user/getUser.htm', items:[]},
		{id:1001,name:'进货明细账', img:"", imgOpen:"", url:'/manage/account/buy/getBuy.htm', items:[]}
	]}
	];
<%}else if("0".equals(auth.getType())){ %>
<%if("admin".equals(auth.getAccount())){ %><!--系统管理员  -->
var treedata = [
	{id:2000, name:'系统管理', img:"", imgOpen:"", url:"", items:[
		{id:2001,name:'用户管理', img:"", imgOpen:"", url:'../../DsCommon/ds/common/user/getUser.htm', items:[]}
		,{id:2001,name:'用户类型管理', img:"", imgOpen:"", url:'../../DsCommon/ds/common/usertype/getUsertype.htm', items:[]}
		,{id:2001,name:'登录日志', img:"", imgOpen:"", url:'../../DsCommon/ds/common/log/getCommonLogin.jsp', items:[]}
	]}
	];

<%} %>
<%} %>
</script>
</head>
<body onselectstart="return false;" oncontextmenu="return true;">
</body>
<script type="text/javascript">
	var jsonData = treedata;
	$jskey.menu.root = "<%=request.getContextPath()%>";
	//$jskey.menu.show(jsonData, false);// 可打开多个
	$jskey.menu.show(jsonData, true);// 只能打开一个，<!DOCTYPE html>
	$jskey.menu.clickBar(0);
</script>
</html>
