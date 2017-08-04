<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加员工</title>
<head>
    <base href="<%=basePath%>">
    <%@include file="../../script.html" %>
    <title>修改员工信息</title>
    <style type="text/css">
.tl{
	width:100px;
	text-align: right;
	background-color: #ddd
}
.tc{
	width: 50px
}

input{
	width: 170px;
	height: 32px
}
td{
	height: 30px;
	font-size: 14px
}

</style>

</head>
  
<body>
	<div style="padding-left: 30px">
	<form id="form" method="post">
			<br><p style="color:#0a0;font-size: 16px;margin-left: 150px;margin-top: 10px">添加员工信息</p><br>
			<hr style="margin-right: 30px"><br>
		<table cellspacing="10" cellpadding="0" style="margin-left: 70px">
			<tr>
				<td class="tl">员工姓名:</td>
				<td><input type="text" name="employee.name" value="${employee.name}" class="easyui-textbox theme-textbox-radius"  data-options="required:true"></td>
			</tr>
			<tr>
				<td class="tl">联系电话:</td>
				<td><input type="text" class="easyui-textbox theme-textbox-radius" value="${employee.telephone }" data-options="required:true" name="employee.telephone"></td>
			</tr>
			<tr>
				<td class="tl">邮箱:</td>
				<td><input type="text" name="employee.email" value="${employee.email }"  class="easyui-textbox theme-textbox-radius"></td>
			</tr>
			<tr>
				<td class="tl">地址:</td>
				<td><input name="employee.address" value="${employee.address }" class="easyui-textbox theme-textbox-radius"></td>
			</tr>
			<tr>
			<td><input type="hidden" name="employee.empid" value="${employee.empid }"></td>
			</tr>
			<tr>
				<td colspan="2px" style="text-align: center">
					<a href="javascript:void(0);" id="saveBtn" class="easyui-linkbutton button-primary">保存</a>&nbsp; &nbsp;&nbsp;&nbsp;
					<a href="javascript:void(0);" id="resetBtn" class="easyui-linkbutton button-danger">重置</a>
				</td>
			</tr>
			<ul>
				<li value=""></li>
			</ul>
    </table>	
    </form>
    </div>
	<script type="text/javascript">
		$(function() {
			//重置按钮

			
			//为保存按钮添加事件
			$("#saveBtn").bind("click",function () {
				$.post("manage/employee/Employee_yiedit.action",$("#form").serialize(),function (result) {
                    if (result.success) {
                        $.messager.alert('提示信息', '保存成功',"info",function () {
                            parent.closeTopWindow();
                        });
                    } else {
                        $.messager.alert('提示信息', '保存失败');
                    }
                },"json")
            })
		});
			
	</script>
</body>
</html>
