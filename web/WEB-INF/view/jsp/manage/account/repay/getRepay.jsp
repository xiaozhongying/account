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
	$dswork.page.menu("delRepay.htm", "", "", "${pageModel.currentPage}");
});
$dswork.doAjax = true;
$dswork.callback = function(){if($dswork.result.type == 1){
	location.href = "getRepay.htm?page=${pageModel.currentPage}&userid=${userid}";
}};
</script>
</head> 
<body>
<table border="0" cellspacing="0" cellpadding="0" class="listLogo">
	<tr>
		<td class="title">列表</td>
		<td class="menuTool">
			<a class="back" href="${ctx }/manage/account/user/getUser.htm">返回</a>
		</td>
	</tr>
</table>
<div class="line"></div>
<form id="queryForm" method="post" action="getRepay.htm">
<table border="0" cellspacing="0" cellpadding="0" class="queryTable">
	<tr>
		<td class="input">
			&nbsp;还款日期：<input type="text" class="WebDate" format="yyyy-MM-dd" name="hkrq" value="${fn:escapeXml(param.hkrq)}" />
			<input type="hidden" name="userid" value="${userid }">
		</td>
		<td class="query"><input id="_querySubmit_" type="button" class="button" value="查询" /></td>
	</tr>
</table>
</form>
<div class="line"></div>
<form id="listForm" method="post" action="delRepay.htm">
<table id="dataTable" border="0" cellspacing="1" cellpadding="0" class="listTable">
	<tr class="list_title">
		<td style="width:2%"><input id="chkall" type="checkbox" /></td>
		<td style="width:5%">操作</td>
		<td>姓名</td>
		<td>还款金额(元)</td>
		<td width="30%">说明</td>
		<td>还款日期</td>

	</tr>
<c:forEach items="${pageModel.result}" var="d">
	<tr>
		<td><input name="keyIndex" type="checkbox" value="${d.id}" /></td>
		<td class="menuTool" keyIndex="${d.id}">&nbsp;</td>
		<td>${fn:escapeXml(d.name)}</td>
		<td>${fn:escapeXml(d.hkje)}</td>
		<td>${fn:escapeXml(d.memo)}</td>
		<td>${fn:escapeXml(d.hkrq)}</td>
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
