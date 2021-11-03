<%@ page pageEncoding="utf-8"%>
<%@ include file="common.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	    <title></title>
	    <link href="${ctx}/static/red/images/head/logo.png" rel="SHORTCUT ICON"></link>
		<link rel="stylesheet" type="text/css" href="${ctx}/<spring:theme code="base"/>" />
		<link rel="stylesheet" type="text/css" href="${ctx}/<spring:theme code="head"/>"/>
		<link rel="stylesheet" type="text/css" href="${ctx}/<spring:theme code="global"/>" />
		<link rel="stylesheet" type="text/css" href="${ctx}/<spring:theme code="nav"/>" />
		
		<link rel="stylesheet" type="text/css" href="${ctx}/static/red/js/common/jquery-plugin-boxy/css/boxy.css"></link>
		<link rel="stylesheet" type="text/css" href="${ctx}/static/red/js/common/jquery-plugin-boxy/css/common.css"></link>
		
		<script type="text/javascript">
		var ctx='${ctx}';
		var localeStr='${localeStr}';
		var operateErrorMsg='<spring:message code="margin_common_alert_operateError"/>';
		var alertErrorTitle='<spring:message code="margin_common_alert_title"/>';
		var tradingClose = '<spring:message code="margin_common_li_tradingClose"/>';
		var tradeing = '<spring:message code="margin_common_li_trading"/>';
		var yourLocation="<spring:message code='margin_common_label_location' />";
		</script>
		<script type="text/javascript" src="${ctx}/static/red/js/base/base.js"></script>
		<script type="text/javascript" src="${ctx}/static/red/js/base/jquery-1.7.2.js"></script>
		<!-- if IE6 -->
		<!--  -->
		<script type="text/javascript" src="${ctx}/static/red/js/base/head.js"></script>
		<script type="text/javascript" src="${ctx}/static/red/js/common/datePicker/WdatePicker.js"></script>
		<script type="text/javascript" src="${ctx}/static/red/js/common/jquery.corner.js"></script>
		<script type="text/javascript" src="${ctx}/static/red/js/common/jquery-plugin-boxy/js/jquery.boxy.js"></script>
		<script type="text/javascript" src="${ctx}/static/red/js/base/global.js"></script>
		
    </head>
    <body>
    </body>
</html>
