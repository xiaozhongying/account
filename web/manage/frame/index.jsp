﻿﻿<%@page import="dswork.web.MyRequest"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page language="java" pageEncoding="UTF-8"%><%
String pwdurl=dswork.sso.WebFilter.getPasswordURL("/account/login.html");
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
	response.sendRedirect(path + "/account/login.jsp");
	return;
}

%><!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no,minimal-ui"/>
<title>舞龙村冼培高财务管理系统</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<link rel="stylesheet" type="text/css" href="style/frame.css" />
<link rel="stylesheet" type="text/css" href="js/easyui/themes/default/layout_panel_tabs.css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/easyui/jquery.layout_panel_tabs.js"></script>
<script language="javascript">
if(top.location != this.location){top.location = "<%=path %>/frame/index.jsp";}
function re(){$('#tt').tabs('resize');}
function GoDorp(o){
	var m=document.getElementById("menu");
	if(m.style.display=="none"){
		o.title="关闭左边菜单";o.src="style/middle/open.gif";m.style.display="";
	}else{
		o.title="打开左边菜单";o.src="style/middle/close.gif";m.style.display="none";
	}
	re();
}
$(function(){
$(window).resize(function(){re();});
doDraw();
});

function $id(id){return document.getElementById(id);}
function reload(){
	try{$('iframe', $("#tt").tabs("getSelected"))[0].contentWindow.location.reload();}catch(e){alert(e.message);}
}
function doDraw(){
	var v = $id("titleDIV").className != "title";
	if(v){
		$id("titleDIV").className = "title";
		$id("toolDiv").className = "xtool tool";
		$id("fontscreen").innerHTML = "&#xf1021;";
		$id("vwin").title = "收缩";
	}
	else{
		$id("titleDIV").className = "minititle";
		$id("toolDiv").className = "xtool minitool";
		$id("fontscreen").innerHTML = "&#xf1022;";
		$id("vwin").title = "恢复";
	}
	try{
		if(v){
			$("body").layout("panel", "north").panel("options").height = 70;
			$("body").layout("panel", "south").panel("options").height = 24;
			$("body").layout("expand", "west");
		}
		else{
			$("body").layout("panel", "north").panel("options").height = 26;
			$("body").layout("panel", "south").panel("options").height = 0;
			$("body").layout("panel", "west").panel("resize", {top:26,height:$("body").layout("panel", "west").panel("options").height + 68});
			$("body").layout("collapse", "west");
		}
	}catch(e){}
	$("body").resize();
}
</script>
<style type="text/css">
/* .topframe{background-color:red;}
.topframe .xtool div{background-color:red;}
.bottomframe{background-color:red;} */
</style>
</head>
<body class="easyui-layout" fit="true" style="min-width:380px;">
<div region="north" data-options="border:false" style="height:70px;overflow:hidden;">
<div class="topframe">
	<div class="left"></div>
	<div class="right"></div>
	<div id="toolDiv" class="xtool minitool">
		<div><i>&#xf1001;</i><b class="show">
		<%=auth.getName() %>(<%=auth.getAccount() %>)
		</b></div>
		<div onclick="$('#tt').tabs('select', 0);"       title="切换首页"><i>&#xf1003;</i><b>首页</b></div>
		<div onclick="reload();"                         title="刷新页面"><i>&#xf1004;</i><b>刷新</b></div>
		<%-- <div onclick="top.location.href='<%=pwdurl %>'" title="修改密码"><i>&#xf1002;</i><b>修改密码</b></div> --%>
		<div onclick="top.location.href='<%=path %>/logout.jsp';" title="退出"><i>&#xf1005;</i><b>退出</b></div>
		<div onclick="doDraw();" title="" id="vwin"><i id="fontscreen" class="mini">&#xf1021;</i></div>
	</div>
</div>
<div id="titleDIV" class="minititle">舞龙村冼培高财务管理系统</div>
</div>
<div region="west" data-options="collapsed:false,split:true" style="width:240px;overflow:hidden;">
	<iframe id="leftFrame" name="leftFrame" scrolling="no" frameborder="0" src="left.jsp"></iframe>
</div>
<div region="center" data-options="border:false" style="overflow:hidden;">
	<div id="tt" class="easyui-tabs" data-options="fit:true,plain:false,tools:'#tab-tools'" style="overflow:hidden;">
		<div title="首页" style="overflow:hidden;" closable="false">
			<div style="overflow:hidden;width:100%;height:100%;"><iframe id="rightFrame" name="rightFrame" scrolling="no" frameborder="0" src="right.jsp"></iframe></div>
		</div>
	</div>
	<div id="tab-tools">
		<a class="easyui-linkbutton" title="关闭当前" data-options="plain:true,iconCls:'icon-closeone'" onclick="var i=$('#tt').tabs('getTabIndex',$('#tt').tabs('getSelected'));if(i>0){$('#tt').tabs('close',i);}return false;" href="#"></a>
		<a class="easyui-linkbutton" title="关闭所有" data-options="plain:true,iconCls:'icon-closeall'" onclick="var v=$('#tt').tabs('tabs').length;while(v > 1){$('#tt').tabs('close', 1);v--;};return false;" href="#"></a>
	</div>
</div>
<div region="south" data-options="border:false" style="height:24px;overflow:hidden;"><div class="bottomframe">
	版权所有&nbsp;<span  class="copyRight">&copy;</span>&nbsp;舞龙村冼培高财务管理系统
</div></div>
</body>
</html>
