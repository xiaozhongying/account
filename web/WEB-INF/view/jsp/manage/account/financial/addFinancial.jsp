<%@page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<%@include file="/commons/include/addAjax.jsp"%>
<script type="text/javascript">
$dswork.callback = function(){if($dswork.result.type == 1){
	location.href = "getFinancial.htm?userid=${userid}";
}};
</script>
</head>
<body>
<table border="0" cellspacing="0" cellpadding="0" class="listLogo">
	<tr>
		<td class="title">添加</td>
		<td class="menuTool">
			<a class="save" id="dataFormSave" href="#">保存</a>
			<a class="back" onclick="window.history.back();return false;" href="#">返回</a>
		</td>
	</tr>
</table>
<div class="line"></div>
<form id="dataForm" method="post" action="addFinancial2.htm">
<table border="0" cellspacing="1" cellpadding="0" class="listTable">
	<tr>
		<td class="form_title">欠款人</td>
		<td class="form_input">${username }</td>
	</tr>
	<tr>
		<td class="form_title">欠款金额(元)</td>
		<td class="form_input"><input type="text"  datatype="NumberPlus" name="qkje" maxlength="15" value="" /></td>
	</tr>
	<tr>
		<td class="form_title">欠款说明</td>
		<td class="form_input">
			<textarea name="memo" style="width: 300px;height: 200px;"></textarea>
		</td>
	</tr>
	<tr>
		<td class="form_title">欠款日期</td>
		<td class="form_input"><input type="text" datatype="Require" class="WebDate" format="yyyy-MM-dd" name="datetime" maxlength="255" value="" /></td>
	</tr>
</table>
<input type="hidden" name="userid" maxlength="255" value="${userid }" />
<input type="hidden"  name="name" maxlength="255" value="${username }" />
</form>
</body>
</html>
