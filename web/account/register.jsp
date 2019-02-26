<%@page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta name="viewport"
	content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no,minimal-ui" />
<title>统一身份认证平台</title>
<script type="text/javascript">
	if (top.location != this.location) {
		top.location = this.location;
	}
</script>
<link rel="stylesheet" type="text/css"
	href="/sso/themes/share/fonts/dsworkfont.css" />
<style type="text/css">
html, body {height: 100%;margin: 0px auto;}
body {background-color: #fff;font-family: tahoma, arial, "Microsoft YaHei", "\5B8B\4F53", sans-serif;color: ${c};font-size:16px;line-height:120%;}
i {font-family: dsworkfont;font-weight: normal;font-style: normal;}
.view {overflow: hidden;margin: 0 auto;width: 100%;min-width: 300px;max-width: 1000px;overflow: hidden;padding: 8px 0;}
.title {background-color: ${c};color:#fff;margin:0 0 40px 0;}
.title, .view .title {
	font-weight: bold;
	text-align: center;
	font-size: 32px;
	line-height: 40px;
	padding: 30px 0px;
}
.view{margin-top: 80px;}
.view .title {
	background-color: inherit;
	color: ${c
}

;
margin
:
0;
}
* {
	word-wrap: break-word;
}

html, body, p, form, input {
	margin: 0;
	padding: 0;
}

ul, ol, dl {
	list-style-type: none;
}

html, body {
	*position: static;
}

input.text {
	border: #c2c2c2 solid 1px;
	min-height: 32px;
	width: 300px;
}

input.text:hover {
	border: #0192d0 solid 1px;
}

input.button {
	border: none;
	background: none;
	line-height: 1.5em;
	cursor: pointer;
	background-color: #003c7b;
	color: #fff;
	border-radius: 3px;
}


 .clearfix {
	clear: both;
}

body {
	font-size: 120%;
	line-height: 2em;
}

.pt-5 {
	padding-top: 5px;
}

div.fbox {
	width: 720px;
	margin: 0 auto;
	border: 2px solid #ccc;
	margin-top: 20px;
}
 
.box {
	display: block;
}

.box .top, .box .bottom {
	border: none;
	background-color: #eeeeee;
	text-align: center;
	padding: 5px 0;
}

.box .top {
	border-bottom: 2px solid #ccc;
}

.box .bottom {
	border-top: 2px solid #ccc;
}

.box .left {
	display: block;
	width: 300px;
	text-align: right;
}

.box .right {
	display: block;
	width: 420px;
	text-align: left;
	float: right;
}

.cp {
	color: #666;
	font-size: 12px;
	width: 80%;
	overflow: hidden;
	text-align: center;
	padding: 15px 0;
	margin: 20px auto 0 auto;
	border: none;
	border-top: solid #ccc 1px;
}

.cp a, .cp a:link, .cp a:visited, .cp a:active {
	font-size: 12px;
	font-weight: normal;
	font-family: arial;
	color: ${c
}
;
text-decoration
:underline
;outline
:none
;
}
</style>
<style type="text/css">
body {
	background: #fff url(/sso/themes/share/bg/wave.png) bottom center
		repeat-x;
}

.fieldset a {
	margin: 0 15px;
}
</style>
<link rel="stylesheet" type="text/css" href="/sso/themes/ssomedia.css" />
<%@include file="/commons/include/addAjax.jsp"%>
<script type="text/javascript">
	$dswork.doAjax = true;
	$dswork.callback = function() {
		var qybm = $("input[name='qybm']").val();
		var qymc = $("input[name='qymc']").val();
		if ($dswork.result.type == 1) {
			location.href = "${ctx}/qyxx/getReg.htm?qybm=" + qybm + "&qymc="
					+ qymc;
		}
	};
	$(function() {
		$("#mybtn").click(function() {
			if ($dswork.beforeSubmit()) {
				$("#dataForm").ajaxSubmit($dswork.doAjaxOption);
				return true;
			}
			return false;
		});
	});
</script>
<style type="text/css">
div .left {
	font-size: 20px;
}
.title, .view .title {
    font-weight: bold;
    text-align: center;
    font-size: 32px;
    line-height: 40px;
    padding: 38px 0px;
}
.title {
    background-color: #2a92eb;
    color: #fff;
    margin: 0 0 40px 0;
}
</style>
</head>
<body>
<div class="bg"></div>
<div class="title">&nbsp;广州保税物流业务管理平台</div>
<div class="view">
	<form id="dataForm" action="${ctx}/qyxx/check.htm" method="post">

		<div class="fbox">
			<div class="box clearfix">
				<div class="top">
					<div style="line-height: 50px; text-align: center;">请输入相关信息</div>
				</div>
			</div>
			<div class="box clearfix pt-5">
				<div class="right">
					<input class="text" type="text" name="qymc" datatype="Require" style="width: 250px;"
						value="" />
				</div>
				<div class="left">企业名称：</div>
			</div>
			<div class="box clearfix pt-5">
				<div class="right">
					<input class="text" type="text" id="qybm" datatype="UnitCode" name="qybm" style="width: 250px;"
						value="" />
				</div>
				<div class="left">统一社会信用代码：</div>
			</div>
			<div class="box clearfix pt-5">
				<div class="right">
					<input class="text" type="text" name="frname" datatype="Chinese" style="width: 250px;"
						value="" />
				</div>
				<div class="left">法人代表：</div>
			</div>
			<div class="box clearfix pt-5">
				<div class="right">
					<input class="text" type="text" datatype="IdCard" name="frcard"
						style="width: 250px;" value="" />
				</div>
				<div class="left">法人代表身份证号：</div>
			</div>
			<div class="box clearfix pt-5"></div>
			<div class="box clearfix pt-5">
				<div class="bottom">
					<input type="button" id="mybtn" style="padding: 10px 100px;"
						class="button" value="提交" />
				</div>
			</div>
		</div>
	</form>
	</div>
	<script type="text/javascript">
		$jskey.validator.Init("dataForm", 3, null, null, true);//一开始就要即时验证的话，调用此方法(默认离开显示提示内容)
	</script>
	<div class="cp">&copy; 广州保税物流业务管理系统</div>
</body>
</html>
