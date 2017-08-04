<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
						<input type="hidden" name="businessVO.businessid" value="${businessVO.businessid }">
						<input type="hidden" name="businessVO.createtime" <c:if test="${empty businessVO}">value="<fmt:formatDate value="<%= new Date()%>" pattern="yyyy-MM-dd HH-mm-dd"/>"</c:if>  value="${businessVO.createtime }">
						<input type="hidden" name="businessVO.userByCreatoruserId" value="${businessVO.userByCreatoruserId }">
						<select class="myselect" name="businessVO.userByOwneruserId">
							<option value="-1">-----请选择负责人-----</option>
							<c:forEach items="${ownerUsers}" var="userVO">
								<option value="${userVO.id}" <c:if test="${userVO.id eq businessVO.userByOwneruserId}">selected</c:if>>${userVO.username}</option>
							</c:forEach>
						</select>
					</td>
					<td class="text-title">客户</td>
					<td class="text-content">
						<select class="myselect" name="businessVO.customerId">
							<option value="-1">-----请选择客户-----</option>
							<c:forEach items="${customers}" var="customerVO">
								<option value="${customerVO.customerid}" <c:if test="${customerVO.customerid eq businessVO.customerId}">selected</c:if>>${customerVO.name}</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td class="text-title">商机金额</td>
					<td class="text-content">
						<input type="text" name="businessVO.salesprice" value="${businessVO.salesprice }"
							class="easyui-textbox theme-textbox-radius" data-options="required:false">
					</td>
					<td class="text-title">商机名</td>
					<td class="text-content">
						<input type="text" name="businessVO.name" value="${businessVO.name }"
							class="easyui-textbox theme-textbox-radius" data-options="required:false">
					</td>
				</tr>
				<tr>
					<td class="text-title">联系人</td>
					<td class="text-content">
						<select class="myselect" name="businessVO.businessContactsId">
							<option value="-1">-----请选择联系人-----</option>
                            <c:forEach items="${businessContactsNames}" var="contact">
                                <option value="${contact.contactsid}" <c:if test="${contact.contactsid eq businessVO.businessContactsId}">selected</c:if>>${contact.name}</option>
                            </c:forEach>
                        </select>
							<a href="javascript:void(0)" class="text-title" style="color:blue;">新建</a>
					</td>
					
				</tr>
				<tr>
					<td class="text-title" >合同签订地址</td>
					<td class="text-content" colspan="3">
						<input type="text" style="width:550px;" name="businessVO.contractaddress" value="${businessVO.contractaddress }"
							class="easyui-textbox theme-textbox-radius" data-options="required:false">
					</td>
				</tr>
				<tr>
					<td class="text-title">商机类型</td>
					<td class="text-content">
						<select class="myselect" name="businessVO.type">
							<option value="-1">-----请选择商机类型-----</option>
                            <c:forEach items="${type}" var="stp">
                                <option value="${stp.dictname}" <c:if test="${stp.dictname eq businessVO.type}">selected</c:if>>${stp.dictname}</option>
                            </c:forEach>
                        </select>
					</td>
					<td class="text-title">状态</td>
					<td class="text-content">
						<select class="myselect" name="businessVO.businessStatusId">
							<option value="-1">-----请选择商机状态-----</option>
							<c:forEach items="${status}" var="sta">
								<option value="${sta.statusid}" <c:if test="${sta.statusid eq businessVO.businessStatusId}">selected</c:if>>${sta.name}</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td class="text-title">商机来源</td>
					<td class="text-content">
						<select class="myselect" name="businessVO.origin">
							<option value="-1">-----请选择商机来源-----</option>
							<c:forEach items="${origins}" var="ori">
								<option value="${ori.dictname}" <c:if test="${ori.dictname eq businessVO.origin}">selected</c:if>>${ori.dictname}</option>
							</c:forEach>
						</select>
					</td>
					<td class="text-title">赢单率</td>
					<td class="text-content">
						<input type="text" name="businessVO.gainrate" value="${businessVO.gainrate }"
							class="easyui-textbox theme-textbox-radius" data-options="required:false">
					</td>
				</tr>
				<tr>
					<td class="text-title">预定成交价</td>
					<td class="text-content">
						<input type="text" name="businessVO.estimateprice" value="${businessVO.estimateprice }"
							class="easyui-textbox theme-textbox-radius" data-options="required:true">
					</td>
					<td class="text-title">下次联系时间</td>
					<td class="text-content">
						<input class="easyui-datetimebox" name="businessVO.nextsteptime" value="${businessVO.nextsteptime }"
	  					  data-options="required:false,showSeconds:false" style="width:150px">
					</td>
				</tr>
				<tr>
					<td class="text-title">下次联系内容</td>
					<td class="text-content">
						<input type="text" name="businessVO.nextstep" value="${businessVO.nextstep }"
							class="easyui-textbox theme-textbox-radius" data-options="required:false">
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
						<textarea name="businessVO.description" rows="5" style="width:80%;">${businessVO.description }</textarea>
					</td>
				</tr>
				<tr>
					<td colspan="2" style="text-align: center;margin-top: 10px;">
						<a href="javascript:void(0);" id="saveBtn" class="easyui-linkbutton button-primary" style="margin-left:-70px;">保存</a> 
						<a href="javascript:void(0);" id="resetBtn" class="easyui-linkbutton button-danger" style="margin-left:30px;">重置</a>
					</td>
				</tr>
				</table>
	</section>
	</form>
	
	<script type="text/javascript">
		$("#saveBtn").on("click",function () {
			$.post("manage/business/BusinessAction_save.action",$("#form").serialize(),function(data){
                if(data && data.success){
                    $.messager.alert("提示",data.message,"", function () {
						parent.closeTopWindow();
                    });
                    return;
                }
                $.messager.alert("警告",data.message);
			},"json");

        })

	</script>
</body>
</html>
				