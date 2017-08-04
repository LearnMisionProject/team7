<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>岗位管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<%@include file="../../script.html" %>
	<style type="text/css">
		table{
			margin:auto;
		}
		input[type="text"]{
			width:85%;
			height:30px;
			border:0.5px solid gray;
		}
		select{
			width:85%;
			height:30px;
			border:0.5px solid gray;
		}
	
		td:only-child{
			text-align:center;
			
		}
	</style>

  </head>
  
  <body> 
    <div>
    	<form  method="post" id="form" >
    		<table>
    			<tr>
    				<td>岗位名称:</td>
    				<td>
    					<input type="hidden" name="positionVO.positionid" value="${positionVO.positionid }">
    					<input type="text" name="positionVO.name" value="${positionVO.name }">
    				</td>
    			</tr>
    			<tr>
    				<td>所属部门:</td>
    				<td>
    					<select name="positionVO.departmentParentId" id="select2">
    						<option value="-1">请选择所属部门</option>
							<c:forEach items="${dl}" var="dl" varStatus="status">
								<option value="${dl.departmentid}" <c:if test="${dl.departmentid eq positionVO.departmentParentId}">selected</c:if> >${dl.name}</option>
							</c:forEach>

    					</select>
    				</td>
    			</tr>
    			<tr>
    				<td>上级岗位:</td>
    				<td>
    					<select id="select1" name="positionVO.positionTopId">
    						<option value="-1">请选择岗位上级</option>
							<c:forEach items="${list}" var="list" varStatus="status">
								<option value="${list.positionid}" <c:if test="${list.positionid eq positionVO.positionTopId}">selected</c:if>>${list.name}</option>
							</c:forEach>
    					</select>    					
    				</td>
    			</tr>
    			<tr>
    				<td>岗位描述:</td>
    				<td><textarea rows="6" cols="50" name="positionVO.description">${positionVO.description}</textarea></td>
    			</tr>
    			<tr>
    				<td colspan="2" style="text-align: center;margin-top: 10px;">
						<a href="javascript:void(0);" id="saveBtn" class="easyui-linkbutton button-primary">保存</a> 
						<a href="javascript:void(0);" id="resetBtn" class="easyui-linkbutton button-danger">重置</a>
					</td>
    			</tr>    			
    		</table>
    	</form>
    </div>
  </body>
  <script type="text/javascript">

	//重置按钮
	$("#resetBtn").on("click",function(event){
	    $("#form").form("reset");
	});
	//保存按钮
	$("#saveBtn").on("click", function(event) {
        $.post("manage/position/Position_save.action",$("#form").serialize(),function (result) {
            if(result){
                $.messager.alert('提示信息', '保存成功',"info",function () {
                    parent.closeTopWindow();
                });
            } else {
                $.messager.alert('提示信息', '保存失败');
            }
		},"json")
	});
  </script>
</html>
