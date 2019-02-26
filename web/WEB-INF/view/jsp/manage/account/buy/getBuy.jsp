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
	$dswork.page.menu("delBuy.htm", "updBuy1.htm", "getBuyById.htm", "${pageModel.currentPage}");
});
$dswork.doAjax = true;
$dswork.callback = function(){if($dswork.result.type == 1){
	location.href = "getBuy.htm?page=${pageModel.currentPage}";
}};
</script>
</head> 
<body>
<table border="0" cellspacing="0" cellpadding="0" class="listLogo">
	<tr>
		<td class="title">列表</td>
		<td class="menuTool">
			<a class="insert" href="addBuy1.htm?page=${pageModel.currentPage}">添加</a>
		</td>
	</tr>
</table>
<div class="line"></div>
<form id="queryForm" method="post" action="getBuy.htm">
<table border="0" cellspacing="0" cellpadding="0" class="queryTable">
	<tr>
		<td class="input">
			&nbsp;进货人：<input type="text" class="text" name="name" value="${fn:escapeXml(param.name)}" />
			&nbsp;货物名称：<input type="text" class="text" name="hwmc" value="${fn:escapeXml(param.hwmc)}" />
			&nbsp;进货日期：<input type="text" class="WebDate" format="yyyy-MM-dd" name="jhrq" value="${fn:escapeXml(param.jhrq)}" />
		</td>
		<td class="query"><input id="_querySubmit_" type="button" class="button" value="查询" /></td>
	</tr>
</table>
</form>
<div class="line"></div>
<form id="listForm" method="post" action="delBuy.htm">
<table id="dataTable" border="0" cellspacing="1" cellpadding="0" class="listTable">
	<tr class="list_title">
		<td style="width:2%"><input id="chkall" type="checkbox" /></td>
		<td style="width:5%">操作</td>
		<td>进货人</td>
		<td>货物名称</td>
		<td>进货金额(元)</td>
		<td width="40%">进货说明</td>
		<td>进货日期</td>
	</tr>
<c:forEach items="${pageModel.result}" var="d">
	<tr>
		<td><input name="keyIndex" type="checkbox" value="${d.id}" /></td>
		<td class="menuTool" keyIndex="${d.id}">&nbsp;</td>
		<td>${fn:escapeXml(d.name)}</td>
		<td>${fn:escapeXml(d.hwmc)}</td>
		<td>${fn:escapeXml(d.jhje)}</td>
		<td>${fn:escapeXml(d.memo)}</td>
		<td>${fn:escapeXml(d.jhrq)}</td>
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
