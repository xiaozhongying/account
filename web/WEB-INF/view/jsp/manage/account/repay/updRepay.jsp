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
	location.href = "getRepay.htm?page=${page}";
}};
</script>
</head>
<body>
<table border="0" cellspacing="0" cellpadding="0" class="listLogo">
	<tr>
		<td class="title">修改</td>
		<td class="menuTool">
			<a class="save" id="dataFormSave" href="#">保存</a>
			<a class="back" href="getRepay.htm?page=${page}">返回</a>
		</td>
	</tr>
</table>
<div class="line"></div>
<form id="dataForm" method="post" action="updRepay2.htm">
<table border="0" cellspacing="1" cellpadding="0" class="listTable">
	<tr>
		<td class="form_title">姓名</td>
		<td class="form_input"><input type="text" name="name" maxlength="255" value="${fn:escapeXml(po.name)}" /></td>
	</tr>
	<tr>
		<td class="form_title">还款金额(元)</td>
		<td class="form_input"><input type="text" name="hkje" maxlength="15" value="${fn:escapeXml(po.hkje)}" /></td>
	</tr>
	<tr>
		<td class="form_title">说明</td>
		<td class="form_input"><input type="text" name="memo" maxlength="255" value="${fn:escapeXml(po.memo)}" /></td>
	</tr>
	<tr>
		<td class="form_title">还款日期</td>
		<td class="form_input"><input type="text" name="hkrq" maxlength="255" value="${fn:escapeXml(po.hkrq)}" /></td>
	</tr>
	<tr>
		<td class="form_title">创建时间</td>
		<td class="form_input"><input type="text" name="createtime" maxlength="255" value="${fn:escapeXml(po.createtime)}" /></td>
	</tr>
	<tr>
		<td class="form_title">还款人ID</td>
		<td class="form_input"><input type="text" name="userid" maxlength="19" value="${fn:escapeXml(po.userid)}" /></td>
	</tr>
</table>
<input type="hidden" name="id" value="${po.id}" />
</form>
</body>
</html>
