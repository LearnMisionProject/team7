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
   	<table id="positionList" class="easyui-datagrid"></table>
    <div id="toolbar">
    	<span>岗位名称:</span>
		<input id="positionName" style="line-height:26px;border:1px solid #ccc">
		<a href="javascript:void(0);" class="easyui-linkbutton" plain="true" onclick="doSearch()" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true">搜索</a>
    	<a href="javascript:void(0);" onclick="return add('manage/position/toEditPage.action')" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">新建</a>
    	<a href="javascript:void(0);" onclick="return del('manage/position/PositionAction_delete.action')" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">删除</a>
    	<a href="javascript:void(0);" onclick="return edit('manage/position/toEditPage.action');" id="editBtn" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true">修改</a>
	</div>
    </div>
    <script type="text/javascript">
    	//条件查询
 		function doSearch(){
            $('#positionList').datagrid('load',{
                name: $("#positionName").val()
            })
		}
    	//添加用户
            var add = function (uri) {
                parent.openTopWindow({
                    width: 700,
                    height: 500,
                    titile: '添加',
                    url: uri,
                    close: function () {
                        $("#positionList").datagrid("reload");
                    }
                })
            }

            //修改岗位
			function edit(){
				/* var positionId = "";*/
				var rows = $("#positionList").datagrid("getChecked");
				if(rows.length == 0){
					$.messager.alert("提示信息","请选择需要修改的岗位！")
					return;
				}
				if(rows.length > 1){
                	$.messager.alert("提示信息","请选择一条需要修改的岗位！")
                	return;
				}
                if(rows.length == 1){
				    var positionId = rows[0].positionid;
                        parent.openTopWindow({
                            width: 700,
                            height: 500,
                            title: "修改",
                            url: "manage/position/toEditPage.action?positionId=" + positionId,

                            close: function () {
                                $("#positionList").datagrid("reload");
                            }
                        });
			}
        }
        
        
     	//删除岗位
        var del = function (url) {
            var positionIds = new Array();
            //多选删除
            var rows = $("#positionList").datagrid("getChecked");
            //弹出信息框
            $.messager.confirm('删除角色', '确定要删除角色吗?', function(r){
                if (r){
                    //将id数组拼接成一个字符串
                    if (rows) {
                        $.each(rows, function (index, obj) {
                            positionIds.push(obj.positionid);
                        })
                        //以逗号分隔
                        positionIds.join(",");
                    }
                    //执行删除ajax
                    $.post(url, {"positionIds" : positionIds.toString()}, function (result) {
                        if (result.success) {
                            $("#positionList").datagrid("reload");
                            $("#positionList").datagrid("clearChecked");
                        }
                    }, "json")
                }
            });
        }


    
    	//加载用户数据
    	$(function(){
    		$("#positionList").datagrid({
    			url : "manage/position/PositionAction_list1.action",
    			//queryParams:{"positionName":$("#positionName").val()},
    			pagination : true,
    			toolbar : "#toolbar",
    			fitColumns : true,
    			idField : "positionid",
    			rownumbers : true,
				singleSelect:false,
    			columns : [[
    				{field:"positionid",title:"选择岗位",checkbox:true},
    				{field:"name",title:"岗位名称",width:10},
    				{field:"departmentName",title:"所属部门",width:10},
    				{field:"positiontopName",title:"岗位管理上级",width:10},
    				{field:"description",title:"岗位描述",sortable:true,width:10},
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
