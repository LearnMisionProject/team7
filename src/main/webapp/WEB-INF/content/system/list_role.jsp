<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
    <base href="<%=basePath%>">

    <title>角色列表</title>

    <meta name="pragma" content="no-cache">
    <meta name="cache-control" content="no-cache">
    <meta name="expires" content="0">
    <%@include file="../script.html" %>

</head>

<body >
<table id="roleList" class="easyui-datagrid"></table>
<div id="toolbar">
    <a href="javascript:void(0);" onclick="return add('system/role/RoleAction_edit.action')" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">新建</a>
    <a href="javascript:void(0);" onclick="return del('system/role/RoleAction_remove.action')" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">删除</a>
    <a href="javascript:void(0);" onclick="return edit('system/role/RoleAction_edit.action');" id="editBtn" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true">修改</a>
    <a href="javascript:void(0);" onclick="return assign('system/function/RoleAction_assign.action')" id="setBtn" class="easyui-linkbutton" data-options="iconCls:'icon-man',plain:true">分配权限</a>
</div>
<script type="text/javascript">
    //分配权限按钮事件处理函数
    function assign(url){
        var rows = $("#roleList").datagrid("getChecked");
        if (!rows.length) {
            $.messager.alert("警告", "请选择一行要分配权限的角色");
            return;
        }
        if (rows.length > 1) {
            $.messager.alert("警告", "同时只能对一个角色分配权限");
            return;
        }
        var roleId = rows[0].id;
        parent.openTopWindow({
            width:700,
            height:500,
            title:"分配权限",
            "url": url + "?roleId=" + roleId,
            isScrolling:true,
            close:function(){
                $("#roleList").datagrid("reload");
            }
        });
    }
    //修改按钮事件处理函数
    function edit(url){
        var roleId = $("#roleList").datagrid("getSelected").id;
        parent.openTopWindow({
            width:700,
            height:500,
            title:"添加角色",
            "url":url + "?roleId=" + roleId,
            close:function(){
                $("#roleList").datagrid("reload");
            }
        });
    }

    //添加按钮事件处理函数
    function add(url){
        parent.openTopWindow({
            width:700,
            height:500,
            title:"添加角色",
            "url": url,
            close:function(){
                $("#roleList").datagrid("reload");
            }
        });
    }
    //删除按钮事件处理函数
    var del = function (url) {
        var roleIds = new Array();
        //多选删除
        var rows = $("#roleList").datagrid("getChecked");
        //弹出信息框
        $.messager.confirm('删除角色', '确定要删除角色吗?', function(r){
            if (r){
                //将id数组拼接成一个字符串
                if (rows) {
                    $.each(rows, function (index, obj) {
                        roleIds.push(obj.id);
                    })
                    //以逗号分隔
                    roleIds.join(",");
                }
                //执行删除ajax
                $.post(url, {"roleId" : roleIds.toString()}, function (result) {
                    if (result.success) {
                        $.messager.alert("提示",result.message);
                        $("#roleList").datagrid("reload");
                        $("#roleList").datagrid("clearChecked");
                    }
                }, "json")
            }
        });
    }
    //加载角色数据
    $(function(){
        $("#roleList").datagrid({
            url : "system/role/RoleAction_findByPage.action",
            pagination : true,
            toolbar : "#toolbar",
            fitColumns : true,
            idField : "id",
            rownumbers : true,
            //singleSelect:true,
            columns : [[
                {field:"id",title:"选择",checkbox:true},
                {field:"roleName",title:"角色名称",sortable:true,width:10},
                {field:"roleNote",title:"角色描述",width:15},
                {field:"userByCreatebyName",title:"创建者",width:10},
                {field:"createTime",title:"创建时间",width:15},
                {field:"userByUpdatebyName",title:"修改者",width:10},
                {field:"updateTime",title:"修改时间",width:15},
                {field:"status",title:"角色状态",formatter:function(value,rowData,index){
                    if(value == 1){
                        return "可用";
                    }else if(value == 0){
                        return "禁用";
                    }else if(value == 2){
                        return "已删除";
                    }else{
                        return "";
                    }
                }}

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
