<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'show.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<%@ include file="/WEB-INF/content/script.html" %>
  </head>
  <style>
  	*{
  		margin-left: 10px;
  		padding: 3px;	
  	}
  	.tip{
  		
  		height:30px;
  		text-align: right;
  		background-color: #F5F5F5;
  	}
  </style>
  <body>
  	<table>
  		<tr>
  			<td colspan="4">客户基本信息</td>
  		</tr>
  		<tr>
  			<td class="tip">客户名：</td>
  			<td><input class="easyui-textbox" value="${customerVO.name }" data-options="readonly:true"></td>
  			<td class="tip">客户来源：</td>
  			<td><input class="easyui-textbox validatebox-text validatebox-readonly" value="${customerVO.origin }" data-options="readonly:true"></td>
  		</tr>
  		<tr>
  			<td class="tip">地址：</td>
  			<td><input class="easyui-textbox validatebox-text validatebox-readonly" value="${customerVO.address }" data-options="readonly:true"></td>
  			<td class="tip">邮编：</td>
  			<td><input class="easyui-textbox validatebox-text validatebox-readonly" value="${customerVO.zipcode }" data-options="readonly:true"></td>
  		</tr>
  		<tr>
  			<td class="tip">行业：</td>
  			<td><input class="easyui-textbox validatebox-text validatebox-readonly" value="${customerVO.industry }" data-options="readonly:true"></td>
  			<td class="tip">盈利额：</td>
  			<td><input class="easyui-textbox validatebox-text validatebox-readonly" value="${customerVO.annualrevenue }" data-options="readonly:true"></td>
  		</tr>
  		<tr>
  			<td class="tip">公司性质：</td>
  			<td><input class="easyui-textbox validatebox-text validatebox-readonly" value="${customerVO.ownership }" data-options="readonly:true"></td>
  			<td class="tip">评分：</td>
  			<td><input class="easyui-textbox validatebox-text validatebox-readonly" value="${customerVO.rating }" data-options="readonly:true"></td>
  		</tr>
  		<tr>
  			<td class="tip">客户负责人：</td>
  			<td><input class="easyui-textbox validatebox-text validatebox-readonly" value="${customerVO.oneruserName }" data-options="readonly:true"></td>
  			<td></td>
  			<td></td>
  		</tr>
  		
  		<tr>
  			<td colspan="4">主要联系人</td>
  		</tr>
  		<tr>
  			<td class="tip">姓名：</td>
  			<td><input class="easyui-textbox validatebox-text validatebox-readonly" value="${customerVO.contactsName }"  data-options="readonly:true" ></td>
  			<td class="tip">性别：</td>
  			<td><input class="easyui-textbox validatebox-text validatebox-readonly" value="${customerVO.contactsSex }" data-options="readonly:true"></td>
  		</tr>
  		<tr>
  			<td class="tip">部门：</td>
  			<td><input class="easyui-textbox validatebox-text validatebox-readonly" value="${customerVO.departmentName }" data-options="readonly:true"></td>
  			<td class="tip">职位：</td>
  			<td><input class="easyui-textbox validatebox-text validatebox-readonly" value="${customerVO.departmentPost }" data-options="readonly:true"></td>
  		</tr>
  		<tr>
  			<td class="tip">称呼：</td>
  			<td><input class="easyui-textbox validatebox-text validatebox-readonly" value="${customerVO.contactsSaltname }" data-options="readonly:true"></td>
  			<td class="tip">电话：</td>
  			<td><input class="easyui-textbox validatebox-text validatebox-readonly" value="${customerVO.contactsTelephone }" data-options="readonly:true"></td>
  		</tr>
  		<tr>
  			<td class="tip">QQ：</td>
  			<td><input class="easyui-textbox validatebox-text validatebox-readonly" value="${customerVO.contactsQQno }" data-options="readonly:true"></td>
  			<td class="tip">Email：</td>
  			<td><input class="easyui-textbox validatebox-text validatebox-readonly" value="${customerVO.contactsEmail }" data-options="readonly:true"></td>
  		</tr>
  		<tr>
  			<td class="tip">地址：</td>
  			<td><input class="easyui-textbox validatebox-text validatebox-readonly" value="${customerVO.contactsAddress }" data-options="readonly:true"></td>
  			<td class="tip">邮编：</td>
  			<td><input class="easyui-textbox validatebox-text validatebox-readonly" value="${customerVO.contactsZipcode }" data-options="readonly:true"></td>
  		</tr>

  		<tr>
  			<td class="tip">描述：</td>
  			<td colspan="3">
  				<textarea data-options="multiline:true" style="width:579px;height:60px;" class="easyui-textbox" value="value:${customerVO.contactsDescription }" data-options="readonly:true"></textarea>
  			</td>
  		</tr>
  		
  		<tr>
  			<td colspan="4">系统信息</td>
  		</tr>
  		<tr>
  			<td class="tip">创建人：</td>
  			<td><input class="easyui-textbox validatebox-readonly" value="${customerVO.createByUser }" data-options="readonly:true"></td>
  			<td class="tip">创建时间：</td>
  			<td><input class="easyui-textbox validatebox-readonly" value="${customerVO.createTime }" data-options="readonly:true"></td>
  		</tr>
  	</table>
  </body>
</html>
