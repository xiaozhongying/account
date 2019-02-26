<%@page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<%@include file="/commons/include/get.jsp"%>
<script type="text/javascript">
$(function(){
	$dswork.page.menu("delUser.htm", "updUser1.htm", "", "${pageModel.currentPage}");
});
$dswork.doAjax = true;
$dswork.callback = function(){if($dswork.result.type == 1){
	location.href = "getUser.htm?page=${pageModel.currentPage}";
}};
</script>
</head> 
<body>
<table border="0" cellspacing="0" cellpadding="0" class="listLogo">
	<tr>
		<td class="title">用户表列表</td>
		<td class="menuTool">
			<a class="insert" href="addUser1.htm?page=${pageModel.currentPage}">添加欠款客户</a>
		</td>
	</tr>
</table>
<div class="line"></div>
<form id="queryForm" method="post" action="getUser.htm">
<table border="0" cellspacing="0" cellpadding="0" class="queryTable">
	<tr>
		<td class="input">
			&nbsp;欠款人：<input type="text" class="text" name="username" value="${fn:escapeXml(param.username)}" />
		</td>
		<td class="query"><input id="_querySubmit_" type="button" class="button" value="查询" /></td>
	</tr>
</table>
</form>
<div class="line"></div>
<form id="listForm" method="post" action="delUser.htm">
<table id="dataTable" border="0" cellspacing="1" cellpadding="0" class="listTable">
	<tr class="list_title">
		<td style="width:2%"><input id="chkall" type="checkbox" /></td>
		<td style="width:5%">操作</td>
		<td>欠款人</td>
		<td>欠款记录总额(元)</td>
		<td>已还金额(元)</td>
		<td>当前欠款金额(元)</td>
		<td width="20%">备注</td>
		<td width="30%">操作</td>
		
	</tr>
<c:forEach items="${pageModel.result}" var="d">
	<tr>
		<td><input name="keyIndex" type="checkbox" value="${d.id}" /></td>
		<td class="menuTool" keyIndex="${d.id}">&nbsp;</td>
		<td>${fn:escapeXml(d.username)}</td>
		<td>${fn:escapeXml(d.qkjl)}</td>
		<td>${fn:escapeXml(d.yhje)}</td>
		<td>${fn:escapeXml(d.dqqkje)}</td>
		<td>${fn:escapeXml(d.memo)}</td>
		<td class="menuTool">
			<a class="edit" href="${ctx}/manage/account/financial/addFinancial1.htm?userid=${d.id}&username=${d.username}">添加欠款</a>
			<a class="edit" href="${ctx}/manage/account/financial/getFinancial.htm?userid=${d.id}">欠款明细</a>
			<a class="edit" href="${ctx}/manage/account/repay/addRepay1.htm?userid=${d.id}&username=${d.username}">还款</a>
			<a class="edit" href="${ctx}/manage/account/repay/getRepay.htm?userid=${d.id}">还款明细</a>
		</td>
	</tr>
</c:forEach>
</table>
<input name="page" type="hidden" value="${pageModel.currentPage}" />
</form>
<table border="0" cellspacing="0" cellpadding="0" class="bottomTable">
	<tr><td>${pageNav.page}</td></tr>
</table>
</body>
</html>
