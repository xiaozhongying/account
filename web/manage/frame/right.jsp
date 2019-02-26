<%@page import="
dswork.core.util.TimeUtil,
dswork.web.MyRequest,
java.util.*,
bs.model.SwwBsTz
"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page language="java" pageEncoding="UTF-8"%><%
MyRequest req = new MyRequest(request);
//获取当前用户
common.auth.Auth auth = common.auth.AuthUtil.getLoginUser(request);
//通知部分
bs.service.SwwBsTzService service = (bs.service.SwwBsTzService)dswork.spring.BeanFactory.getBean("swwBsTzService");
Map<String,Object> map=new HashMap<String,Object>();
List<SwwBsTz> tzlist=service.queryList(map);
SwwBsTz tz=new SwwBsTz();
String file="";
if(tzlist.size()>0){
	tz=tzlist.get(0);
	file=tz.getFile().split(":")[1];
}
//进出口数据待办部分
bs.service.SwwBsStatService statservice = (bs.service.SwwBsStatService)dswork.spring.BeanFactory.getBean("swwBsStatService");
//扶持申报数据待办部分
int fcsb=0;
List<Integer> fcsblist=new ArrayList<Integer>();
if("8".equals(auth.getType())){//商务委
	map.put("state", 2);
	fcsblist=statservice.queryFcsbdsh(map);
	if(fcsblist.size()>0){
		fcsb=fcsblist.get(0);
	}
}else if("9".endsWith(auth.getType())){//区商务委
	map.put("state", 1);
	map.put("pq", auth.getExalias());
	fcsblist=statservice.queryFcsbdsh(map);
	if(fcsblist.size()>0){
		fcsb=fcsblist.get(0);
	}
}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript">
function gettime(){
	var d = new Date();
	document.getElementById("time").innerHTML =d;
	window.setTimeout("gettime()",1000);
	}
	window.onload = gettime;
</script>
</head>
<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    </ul>
    </div>

    <div class="welinfo">
    <span><img src="images/mg_user_list.png" alt="天气" /></span>
    <b><%=auth.getName() %>您好，欢迎使用广州市保税物流业务管理系统</b>
    </div>
    
    <div class="welinfo">
    <span><img src="images/time.png" alt="时间" /></span>
    <i id="time"></i>
    </div>
 
    <div class="xline"></div>
    <div class="box"></div>
    
    <div class="welinfo">
    <span><img src="images/dp.png" alt="提醒" /></span>
    <b>商务委最新通知</b>
    </div>
    
    <ul class="infolist">
    <li><span>通知：<%=tz.getName() %></span></li>
    <li><span>通知文件：<%=file%></span></li>
    <li><span>发布时间：<%=tz.getCreatetime() %></span></li>
    </ul>
    <!--判断是商务委或者区商务委才能看到下列菜单 -->
    <%if("8".equals(auth.getType()) || "9".equals(auth.getType())){%>
    <div class="xline"></div>
       <div class="box"></div>
    
    <div class="welinfo">
    <span><img src="images/dp.png" alt="提醒" /></span>
    <b>待办事项</b>
    </div>
    
    <ul class="infolist">
    <li><span>扶持申报数据待审核：<%=fcsb %></span></li>
    </ul>
    <%} %>
</body>
</html>
