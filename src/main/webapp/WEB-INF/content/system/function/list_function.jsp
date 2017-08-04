<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
    <base href="<%=basePath%>">

    <title>权限列表</title>

    <meta name="pragma" content="no-cache">
    <meta name="cache-control" content="no-cache">
    <meta name="expires" content="0">

    <%@include file="../../script.html" %>

</head>

<body>
<!-- 表格中展示所有的权限 -->
<table id="funcList" style="height: auto"></table>
<div id="toolbar">
    <a href="javascript:void(0);" onclick="return add('system/function/toAddFunction.action')" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">新建</a>
    <a href="javascript:void(0);" onclick="return del('system/function/deleteFunction.action')" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">删除</a>
    <a href="javascript:void(0);" onclick="return edit('system/function/toAddFunction.action');" id="editBtn" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true">修改</a>
</div>

<script type="text/javascript">
    function edit(url) {
        var funcIds ="";
        var rows = $("#funcList").treegrid("getCheckedNodes");
        if(!rows.length){
            $.messager.alert("提示信息","请选择一条需要修改的权限");
            return;
        }
        if(rows.length>1){
            $.messager.alert("提示信息","请一次选择一条需要修改的权限");
            return;
        }
        funcIds = rows[0].id;
        parent.openTopWindow({
            title : "增加权限",
            width : 800,
            height : 600,
            "url" : url+"?funcIds="+funcIds,
        close:function(){
            $("#funcList").treegrid("clearChecked");
        }
        })
        return;
    }

    function del(url){
        var rows = $("#funcList").treegrid("getCheckedNodes");

        if(!rows.length){
            $.messager.alert("警告","请选择要删除的数据");
            return;
        }

        $.messager.confirm("警告","数据删除后无法恢复，是否确认删除",function(b){
            if(b){
                var funcIds = new Array();
                $.each(rows,function(index,obj){
                    funcIds.push(obj.id);
                });
                //将数组中元素使用,分割拼接为一个字符串
                funcIds = funcIds.join(",");
                $.post(url, {"funcIds" : funcIds}, function(data){
                    if(data && data.success){
                        $.messager.alert("提示",data.message);
                        $("#funcList").treegrid("reload");
                        return;
                    }
                    $.messager.alert("警告",data.message);
                },"json");
            }
        });


    }


    function add(url) {
        parent.openTopWindow({
            title : "增加权限",
            width : 800,
            height : 600,
            url : url
        })

    }


    //删除按钮事件处理函数


    $(function(){
        //加载所有权限
        $("#funcList").treegrid({
            url : "system//function/list.action",
            fitColumns : true,
            idField : "id",
            treeField: "funcName",
            rownumbers : true,
            toolbar : "#toolbar",
            checkbox : true,
            singleSelect : false,
            cascadeCheck : false,
            columns : [[

                {field:"funcName",title:"权限名称",sortable:true,width:10},
                {field:"funcType",title:"权限类型",width:5,formatter:function(value,rowData,index){
                    if(value == 1){
                        return "菜单";
                    }else if(value == 0){
                        return "按钮";
                    }else{
                        return "其他";
                    }
                }},
                {field:"funcUrl",title:"权限URL",width:10},
                {field:"funcNote",title:"权限描述",width:10},
                {field:"createByUserName",title:"创建者",width:5},
                {field:"createTime",title:"创建时间",width:10},
                {field:"updateByUserName",title:"修改者",width:5},
                {field:"updateTime",title:"更新时间",width:10},
                {field:"status",title:"权限状态",formatter:function(value,rowData,index){
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
            loadFilter:function(data){//"_parentId"

                if(data && data.data){
                    $.each(data.data ,function(index,obj){
                        if(obj.parentId){
                            data.data[index]._parentId = obj.parentId;
                        }

                    });
                    return {"rows":data.data};
                }
                return null;
            }
        });
    });

</script>
</body>
</html>
