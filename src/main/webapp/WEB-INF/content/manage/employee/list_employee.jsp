<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>员工信息表</title>
	<meta name="pragma" content="no-cache">
	<meta name="cache-control" content="no-cache">
	<meta name="expires" content="0">    
	<%@include file="../../script.html" %>

  </head>
  <style type="text/css">
  body{
  	font-size:14px
  }
  </style>
  <body >
    <div id="toolbar" style="padding:0 30px;">
       	<b>员工姓名: </b><input class="easyui-textbox" id="name" type="text" name="name" style="width:166px;height:35px;line-height:35px;"/>
        <a href="javascript:void(0);" id="searchBtn" class="easyui-linkbutton" iconCls="icon-search" data-options="selected:true" style="background-color:#00aa00;color:white">查询</a>
        <a href="javascript:void(0);" id="setBtn" class="easyui-linkbutton" iconCls="icon-reload" style="background-color:#00aa00;color:white;margin-left:10px">重置</a>
        <a href="javascript:void(0);" onclick="return add('manage/employee/EmployeeAction_add.action')" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" style="background-color:#00aa00;color:white;margin-left:10px">添加</a>
    	<a href="javascript:void(0);" onclick="return remove('manage/employee/EmployeeAction_remove.action')" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true" style="background-color:#f00;color:white;margin-left:10px">删除</a>
    	<a href="javascript:void(0);" onclick="return edit('manage/employee/EmployeeAction_edit.action')" id="editBtn" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true" style="background-color:#00aa00;color:white;margin-left:10px">修改</a>
    </div>
    <form id="form1">
    <table id="empList" class="easyui-datagrid" style="font-size:14px"></table>
    </form>
    <script type="text/javascript">
    	//为查询按钮添加处理函数
	    $("#searchBtn").on("click",function(){
                search();
		})
        var search = function () {
	        $('#empList').datagrid('load',{
	            name:$("#name").val()
            })
        }
		//为添加按钮添加事件处理函数
        var add = function(uri) {
            parent.openTopWindow({
                width:700,
                height:500,
                title:"添加",
                url:uri,
                close:function () {
                    $("#empList").datagrid("reload");
                }
            })
        }
        //为重置按钮添加事件处理函数
        $("#setBtn").bind("click", function(){
            $("#name").textbox("setValue", "");
        })

  
    //修改按钮事件处理函数

        var edit = function() {
            var rows = $("#empList").datagrid("getChecked");
            var id = rows[0].empid;
            console.info(id);
            parent.openTopWindow({
                width:700,
                height:500,
                title:"修改",
                url:"manage/employee/EmployeeAction_edit.action?id="+id,

                close:function () {
                    $("#empList").datagrid("reload");
                }
            })
        }

    //删除按钮事件处理函数
        var remove = function(id){
            $.messager.confirm('提示窗口','确认删除?',function(r){
                if (r){
                    //发送一个ajax的post请求
                    //回调函数代表请求成功之后，如果返回数据格式一致，就会进入回调函数
                    $.post("manage/employee/EmployeeAction_remove.action",{"empid":$("input[name='empid']:checked").val()},function(result){
                        if (result.success) {
                            $.messager.alert('提示信息', '删除成功');
                            //刷新表格
                            $('#empList').datagrid('reload');
                        } else {
                            $.messager.alert('提示信息', '删除失败');
                        }
                    },"json")
                }
            });
        }


    //加载用户数据
    $(function(){
        $("#empList").datagrid({
            url : "manage/employee/EmployeeAction_findByPage.action",
            pagination : true,
            toolbar : "#toolbar",
            fitColumns : true,
            idField : "empid",
            rownumbers : true,
            //singleSelect:true,
            columns : [[
                {field:"empid",title:"选择",checkbox:true},
                {field:"name",title:"员工姓名",sortable:true,width:10},
                {field:"telephone",title:"联系电话",sortable:true,width:10},
                {field:"email",title:"邮箱",sortable:true,width:10},
                {field:"address",title:"地址",width:10},
            ]],
            loadFilter:function(data){
                //data是服务器返回的数据,将服务器端返回的数据转换为datagrid需要的格式
                return {"total":data.data.totalRows,"rows":data.data.list};
            }

        });
    });
    </script>
  </body>
</html>
