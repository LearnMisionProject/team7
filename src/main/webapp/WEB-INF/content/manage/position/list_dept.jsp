<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户列表</title>
    
	<meta name="pragma" content="no-cache">
	<meta name="cache-control" content="no-cache">
	<meta name="expires" content="0">    
	<%@include file="../../script.html" %>

  </head>
  
  <body >
   	<table id="deptList" class="easyui-datagrid"></table>
    <div id="toolbar">
    	<span> 部门名称:</span>
		<input id="departmentName" style="line-height:26px;border:1px solid #ccc">
		<span> 上级部门:</span>
		<input id="departmentParentName" style="line-height:26px;border:1px solid #ccc">
		<a href="javascript:void(0);" class="easyui-linkbutton" plain="true" onclick="doSearch()" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true">搜索</a>
    	<a href="javascript:void(0);" onclick="return add('manage/position/DepartmentAction_edit.action')" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">新建</a>
    	<a href="javascript:void(0);" onclick="return del('manage/position/DepartmentAction_delete.action')" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">删除</a>
    	<a href="javascript:void(0);" onclick="return edit('manage/position/DepartmentAction_edit.action');" id="editBtn" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true">修改</a>
	</div>
    </div>
    <script type="text/javascript">

    	function doSearch(){

		}
 
    	//添加用户
    	function add(url){  		 

        }
        //修改部门
    	function edit(url){

        }
        
        
     	//删除部门
     	function del(url){

        }
    
    	//加载用户数据
    	$(function(){
    		$("#deptList").datagrid({
    			url : "manage/position/DepartmentAction_findByPage.action",
    			pagination : true,
    			toolbar : "#toolbar",
    			fitColumns : true,//设置为 true，则会自动扩大或缩小列的尺寸以适应网格的宽度并且防止水平滚动。
    			idField : "departmentid",
    			rownumbers : true,
    			singleSelect:true,
    			columns : [[
    				{field:"departmentid",title:"选择",checkbox:true,width:10},
    				{field:"name",title:"部门名称",width:10},
    				{field:"parentName",title:"上级部门",width:10},
    				{field:"description",title:"部门描述",width:10},	
    			]],
    			loadFilter:function(data){
    				//data是服务器返回的数据,将服务器端返回的数据转换为datagrid需要的格式
    				return {"total":data.data.totalRows,"rows":data.data.result};
    			}
    		
    		});
    	});
    	
    </script>
  </body>
</html>
