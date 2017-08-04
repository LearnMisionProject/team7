<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">

<title>编辑权限</title>

<meta name="pragma" content="no-cache">
<meta name="cache-control" content="no-cache">
<meta name="expires" content="0">
<%@include file="../../script.html"%>
</head>
<style type="text/css">
.myselect{
	height:30px;
}
</style>

<body style="width:100%;max-width:100%;padding:10px 30px;">
<form id="form" method="post">
<strong>主要信息</strong>
	<section class="info-section">
		
			<table id="tb">
				<tr>
					<td class="text-title">负责人</td>
					<td class="text-content">
						<span>${businessVO.userByOwneruserName }</span>
					</td>
					<td class="text-title">客户</td>
					<td class="text-content">
						<span>${businessVO.customerName }</span>
					</td>
				</tr>
				<tr>
					<td class="text-title">商机金额</td>
					<td class="text-content">
						<span>${businessVO.salesprice }</span>
					</td>
					<td class="text-title">商机名</td>
					<td class="text-content">
						<span>${businessVO.name }</span>
					</td>
				</tr>
				<tr>
					<td class="text-title">联系人</td>
					<td class="text-content">
						<span>${businessVO.businessContactsName }</span>
					</td>
				</tr>
				<tr>
					<td class="text-title" >合同签订地址</td>
					<td class="text-content">
						<span>${businessVO.contractaddress }</span>
					</td>
				</tr>
				<tr>
					<td class="text-title">商机类型</td>
					<td class="text-content">
						<span>${businessVO.type }</span>
					</td>
					<td class="text-title">状态</td>
					<td class="text-content">
						<span>${businessVO.businessStatusName }</span>
					</td>
				</tr>
				<tr>
					<td class="text-title">商机来源</td>
					<td class="text-content">
						<span>${businessVO.origin }</span>
					</td>
					<td class="text-title">赢单率</td>
					<td class="text-content">
						<span>${businessVO.gainrate }</span>
					</td>
				</tr>
				<tr>
					<td class="text-title">预定成交价</td>
					<td class="text-content">
						<span>${businessVO.estimateprice }</span>
					</td>
					<td class="text-title">下次联系时间</td>
					<td class="text-content">
						<span>${businessVO.nextsteptime }</span>
					</td>
				</tr>
				<tr>
					<td class="text-title">下次联系内容</td>
					<td class="text-content">
						<span>${businessVO.nextstep }</span>
					</td>
					
				</tr>
				
				
				</table>
		
	</section>
	<strong>附加信息</strong>
	<section class="info-section">
			<table>
				<tr>
					<td class="text-title">备注</td>
					<td class="text-content">
						<textarea name="businessVO.description" disabled="disabled" rows="5" style="width:80%;">${businessVO.description }</textarea>
					</td>
				</tr>
				<tr>
					<td colspan="2" style="text-align: center;margin-top: 10px;">
						<a href="javascript:void(0);" id="confirmBtn" class="easyui-linkbutton button-primary" style="margin-left:-70px;">确认</a> 
					</td>
				</tr>
				</table>
	</section>
	</form>
	
	<script type="text/javascript">
	//确认并退出按钮
			$("#confirmBtn").on("click", function(event) {
				parent.closeTopWindow();
			});
		
	</script>
</body>
</html>
				