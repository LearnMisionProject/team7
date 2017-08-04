<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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

<body style="width:100%;max-width:600px;padding:30px 60px;">
<section class="info-section">
	<form id="form" method="post">
		<table>
			<tr>
				<td class="text-title">权限名称：</td>
				<td class="text-content">
					<input type="hidden" name="functionVO.id" <c:if test="${not empty functionVO}">value="${functionVO.id }"</c:if>>
					<input type="text" name="functionVO.funcName" <c:if test="${not empty functionVO}">value="${functionVO.funcName }"</c:if>
						   class="easyui-textbox theme-textbox-radius" data-options="required:true,validType:'length[2,20]'">
				</td>
			</tr>
			<tr>
				<td class="text-title">权限URL：</td>
				<td class="text-content">
					<input type="text" name="functionVO.funcUrl" <c:if test="${not empty functionVO}">value="${functionVO.funcUrl}"</c:if>
						   class="easyui-textbox theme-textbox-radius">
				</td>
			</tr>

			<tr>
				<td class="text-title">权限编码：</td>
				<td class="text-content">
					<input type="text" name="functionVO.funcCode"  <c:if test="${not empty functionVO}">value="${functionVO.funcCode }"</c:if>
						   class="easyui-textbox theme-textbox-radius" data-options="required:true">
				</td>
			</tr>
			<tr>
				<td class="text-title">权限类型：</td>
				<td class="text-content">
					<select name="functionVO.funcType" class="easyui-combobox theme-textbox-radius">
						<option value="1" ${functionVO.funcType==1 ? 'selected' : ''}>菜单</option>
						<option value="0" ${functionVO.funcType==0 ? 'selected' : ''}>按钮</option>
						<option value="" ${empty functionVO.funcType ? 'selected' : ''}>其它</option>
					</select>
				</td>
			</tr>
			<tr>
				<td class="text-title">上级权限：</td>
				<td class="text-content">
					<select  name="functionVO.parentId" class="easyui-combobox theme-textbox-radius">
						<c:forEach items="${list}" var="function">
							<option value="${function.id}" <c:if test="${function.id eq functionVO.parentId}">selected</c:if>>${function.funcname}</option>
						</c:forEach>

					</select>
				</td>
			</tr>
			<tr>

				<td class="text-content">
					<input type="hidden" name="functionVO.sortNum"  <c:if test="${not empty functionVO}">value="${functionVO.sortNum}"</c:if>
					<%--class="easyui-textbox theme-textbox-radius" data-options="required:true">--%>
				</td>
			</tr>
			<tr>
				<td class="text-title">权限状态：</td>
				<td class="text-content">
					<select name="functionVO.status" class="easyui-combobox theme-textbox-radius">
						<option value="1" ${functionVO.status==1?"selected":"" }>正常</option>
						<option value="0" ${functionVO.status==0?"selected":"" }>禁用</option>
						<option value="2" ${functionVO.status==2?"selected":"" }>已删除</option>
					</select>
				</td>
			</tr>
			<tr>
				<td class="text-title">描述信息：</td>
				<td class="text-content">
					<textarea class="theme-textbox-radius" rows="5"  cols="20" name="functionVO.funcNote"> <c:if test="${not empty functionVO}">${functionVO.funcNote }</c:if></textarea></td>
			</tr>
			<!-- 因为用户关联信息不需要修改，但是如果没有把这些信息传递给服务器端，hibernate对数据进行更新时就会把对应条目设置为null值 -->

			<tr style="display: none;">
				<td colspan="2">
					<input type="hidden" name="functionVO.createByUserName"  <c:if test="${not empty functionVO}" >value="${functionVO.createByUserName}"</c:if>>
					<input type="hidden" name="functionVO.createTime"  <c:if test="${not empty functionVO}" >value="${functionVO.createTime}"</c:if>>
				</td>
			</tr>
			<tr>
				<td colspan="2" style="text-align: center;margin-top: 10px;">
					<a href="javascript:void(0);" id="saveBtn" class="easyui-linkbutton button-primary">保存</a>
					<a href="javascript:void(0);" id="resetBtn" class="easyui-linkbutton button-danger">重置</a>
				</td>
			</tr>
		</table>
	</form>
</section>
<script type="text/javascript">

    $(function() {
        //重置按钮
        $("#resetBtn").on("click",function(event){
            $("#form").form("reset");
        });
        //保存按钮
        $("#saveBtn").on("click", function() {

            $.post("system/function/operateFunction.action",$("#form").serialize(),function(resultData){
                if(resultData.success){
                    alert(resultData.message);
                    parent.closeTopWindow(function () {
                        location.href = "WEB-INF/content/system/list_function.jsp";
                    });
                    return;
                }else{
                    alert(resultData.message);
                    parent.closeTopWindow(function () {
                        location.href = "WEB-INF/content/system/list_function.jsp";
                    });
                }
            },"json")
        });

    });



</script>
</body>
</html>