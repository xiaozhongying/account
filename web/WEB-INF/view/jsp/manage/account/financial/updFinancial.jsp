<%@page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<%@include file="/commons/include/updAjax.jsp"%>
<script type="text/javascript">
$dswork.callback = function(){if($dswork.result.type == 1){
	location.href = "getFinancial.htm?page=${page}";
}};
</script>
</head>
<body>
<table border="0" cellspacing="0" cellpadding="0" class="listLogo">
	<tr>
		<td class="title">修改</td>
		<td class="menuTool">
			<a class="save" id="dataFormSave" href="#">保存</a>
			<a class="back" href="getFinancial.htm?page=${page}">返回</a>
		</td>
	</tr>
</table>
<div class="line"></div>
<form id="dataForm" method="post" action="updFinancial2.htm">
<table border="0" cellspacing="1" cellpadding="0" class="listTable">
	<tr>
		<td class="form_title">欠款人名称</td>
		<td class="form_input"><input type="text" name="name" maxlength="255" value="${fn:escapeXml(po.name)}" /></td>
	</tr>
	<tr>
		<td class="form_title">欠款金额</td>
		<td class="form_input"><input type="text" name="qkje" maxlength="15" value="${fn:escapeXml(po.qkje)}" /></td>
	</tr>
	<tr>
		<td class="form_title">欠款日期</td>
		<td class="form_input"><input type="text" name="datetime" maxlength="255" value="${fn:escapeXml(po.datetime)}" /></td>
	</tr>
	<tr>
		<td class="form_title">欠款描述</td>
		<td class="form_input"><input type="text" name="memo" maxlength="255" value="${fn:escapeXml(po.memo)}" /></td>
	</tr>
</table>
<input type="hidden" name="id" value="${po.id}" />
</form>
</body>
</html>
