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
	location.href = "getBuy.htm?page=${page}";
}};
</script>
</head>
<body>
<table border="0" cellspacing="0" cellpadding="0" class="listLogo">
	<tr>
		<td class="title">修改</td>
		<td class="menuTool">
			<a class="save" id="dataFormSave" href="#">保存</a>
			<a class="back" href="getBuy.htm?page=${page}">返回</a>
		</td>
	</tr>
</table>
<div class="line"></div>
<form id="dataForm" method="post" action="updBuy2.htm">
<table border="0" cellspacing="1" cellpadding="0" class="listTable">
	<tr>
		<td class="form_title">进货人</td>
		<td class="form_input"><input type="text" datatype="Require" name="name" maxlength="255" value="${fn:escapeXml(po.name)}" /></td>
	</tr>
	<tr>
		<td class="form_title">货物名称</td>
		<td class="form_input"><input type="text" datatype="Require" name="hwmc" maxlength="255" value="${fn:escapeXml(po.hwmc)}" /></td>
	</tr>
	<tr>
		<td class="form_title">进货金额</td>
		<td class="form_input"><input type="text" datatype="NumberPlus" name="jhje" maxlength="255" value="${fn:escapeXml(po.jhje)}" /></td>
	</tr>
	<tr>
		<td class="form_title">进货说明</td>
		<td class="form_input">
			<textarea name="memo" style="width: 300px;height: 200px;">${fn:escapeXml(po.memo)}</textarea>
		</td>
	</tr>
	<tr>
		<td class="form_title">进货日期</td>
		<td class="form_input"><input type="text" class="WebDate" format="yyyy-MM-dd"  datatype="Require" name="jhrq" maxlength="255" value="${fn:escapeXml(po.jhrq)}" /></td>
	</tr>
</table>
<input type="hidden" name="id" value="${po.id}" />
<input type="hidden" name="createtime" maxlength="255" value="${fn:escapeXml(po.createtime)}" />
</form>
</body>
</html>
