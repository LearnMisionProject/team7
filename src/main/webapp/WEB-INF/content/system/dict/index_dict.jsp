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
  <style type="text/css">
  	#container{
  		width:100%;
  		text-align:center;
  	}
  	#left{
  		float:left;
  		width:30%;
  		border:1px solid blue;
  	}
  	#right{
  		float:left;
  		width:69%;
  		border:1px solid blue;
  	}
  	h3{
  		color:green;
  	}
  </style>
  <body>
    <!-- 表格中展示所有的权限 -->
    <div id="container">
    	<div id="left">
    		<h3>字典类型</h3>
	    	<table id="dtList"  style="height:600px"></table>
	    	<div id="toolbarDt">
		    	<a href="javascript:void(0);" onclick="return addDt('system/dicttype/DictTypeAction_edit.action')" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">新建</a>
		    	<a href="javascript:void(0);" onclick="return delDt('system/dicttype/DictTypeAction_remove.action')" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">删除</a>
		    	<a href="javascript:void(0);" onclick="return editDt('system/dicttype/DictTypeAction_edit.action');" id="editBtn" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true">修改</a>
	   		</div>
   		 </div>
    	<div id="right">
    		<h3 id="info">所有字典</h3>
    		<div id="toolbar" >
		    	<a href="javascript:void(0);" onclick="return add('system/dict/DictAction_edit.action')" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">新建</a>
		    	<a href="javascript:void(0);" onclick="return del('system/dict/DictAction_remove.action')" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">删除</a>
		    	<a href="javascript:void(0);" onclick="return edit('system/dict/DictAction_edit.action');" id="editBtn" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true">修改</a>
		    </div>
    		<table id="dictList" class="easyui-datagrid"  style="height:600px"></table>
    	</div>
    </div>
    
    
  
    <script type="text/javascript">
		var currentDt={
			id:"",
			typename:""
		}



		//删除按钮事件处理函数
		//字典类型删除
		function delDt(url) {
			var dictTypeId = $("#dtList").datagrid("getSelected").id;
			$.messager.confirm('删除角色', '确定要删除角色吗?', function(r){
				if (r){
					$.post(url , {"dictTypeVO.id" : dictTypeId}, function (result) {
						if (result.success) {
							$("#dtList").treegrid("reload");
                            loadDictList("ACEAF0031E2C4F92B16EAB5F5D923DE7","allType");
                            $("#dtList").treegrid("clearChecked");
						} else {
                            $.messager.alert("提示",result.message);
						}
					}, "json")
				}
			});
		}

		//字典删除
        function del(url) {
            var dictIds = new Array();
            var rows = $("#dictList").datagrid("getChecked");
            $.messager.confirm('删除角色', '确定要删除字典吗?', function(r){
                if (r){
                    //将id数组拼接成一个字符串
                    if (rows) {
                        $.each(rows, function (index, obj) {
                            dictIds.push(obj.id);
                        })
                        //以逗号分隔
                        dictIds.join(",");
                    }

                    $.post(url , {"dictIds" : dictIds.toString()}, function (result) {
                        if (result.success) {
                            $("#dictList").datagrid("reload");
                            $("#dictList").datagrid("clearChecked");
                        }
                    }, "json")
                }
            });
        }

		//修改按钮事件处理函数
		//字典类型修改
		function editDt(url) {
			var dictTypeId = $("#dtList").datagrid("getSelected").id;
			parent.openTopWindow({
				width: 700,
				height: 500,
				title: "添加字典",
				"url": url + "?dictTypeVO.id=" + dictTypeId,
				close: function () {
					$("#dtList").treegrid("reload");
                    $("#dtList").treegrid("clearChecked");
				}
			});
		}

		//字典修改
		function edit(url) {
			var dictId = $("#dictList").datagrid("getSelected").id;
			parent.openTopWindow({
				width: 700,
				height: 500,
				title: "添加字典",
				"url": url + "?dictVO.id=" + dictId,
				close: function () {
					$("#dictList").datagrid("reload");
                    $("#dictList").datagrid("clearChecked");
				}
			});
		}

		//添加按钮事件处理函数
		//字典类型添加
		function addDt(url){
			var dictTypeId = "";
			parent.openTopWindow({
				width:700,
				height:500,
				title:"添加字典",
				"url":url + "?dictTypeVO.id=" + dictTypeId,
				close:function(){
					$("#dtList").treegrid("reload");
				}
			});
		}

		//字典添加
		function add(url){
			var dictId = "";
			parent.openTopWindow({
				width:700,
				height:500,
				title:"添加字典",
				"url":url + "?dictVO.id=" + dictId,
				close:function(){
					$("#dictList").datagrid("reload");
                    $("#dictList").datagrid("clearChecked");
				}
			});
		}
        
        
    	$(function(){
    		//加载所有字典类型
    		$("#dtList").treegrid({
    			url : "system/dicttype/DictTypeAction_findAll.action",
    			fitColumns : true,
    			idField : "id",
    			treeField: "typename",
    			rownumbers : false,
    			toolbar : "#toolbarDt",
    			//checkbox : true,
    			singleSelect : true,
    			cascadeCheck : false,
    			columns : [[
    				{field:"typename",title:"字典类型名称",sortable:true,width:10},
    				{field:"typecode",title:"编码",sortable:true,width:10,formatter:function(value,rowData,index){
    					if(value == "allType"){
    						return "";
    					}else{
    						return value;
    					}
    					}},
    				{field:"status",title:"状态",formatter:function(value,rowData,index){
    					if("allType"==rowData.typecode){
    						return "";
    					}else if(value == 1){
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
    						if(obj.id!="ACEAF0031E2C4F92B16EAB5F5D923DE7"){
    							data.data[index]._parentId ="ACEAF0031E2C4F92B16EAB5F5D923DE7";
    						}
    					});
    					return {"rows":data.data};
    				}
    				return null;
    			},
    			onClickRow:function(row){
    				loadDictList(row.id,row.typecode);
    				if("allType"==row.typecode){
	    				currentDt.id="";
	    				currentDt.typename="";
	    				$("#info").text("所有字典");
    				}else{
    					currentDt.id=row.id;
    					currentDt.typename=row.typename;
    					$("#info").text("字典 类型为["+currentDt.typename+"]");
    				}
    			}
    		});
    		loadDictList("ACEAF0031E2C4F92B16EAB5F5D923DE7","allType");
    	});
    	
    		//加载字典数据
    function loadDictList(dictTypeId,typecode){
    		$("#dictList").datagrid({
    			url : "system/dict/DictAction_findByDictTypeId.action?dictTypeVO.id="+dictTypeId+"&dictTypeVO.typecode="+typecode,
    			pagination : true,
    			toolbar : "#toolbar",
    			fitColumns : true,
    			idField : "id",
    			rownumbers : true,
    			//singleSelect:true,
    			columns : [[
    				{field:"id",title:"选择",checkbox:true},
    				{field:"dictname",title:"词条名",sortable:true,width:10},
    				{field:"dictcode",title:"编码",width:15},
    				{field:"dictvalue",title:"值",width:20},
    				{field:"dictnote",title:"备注",width:15},
    				{field:"dictType",title:"词条类型",width:15}
    			]],
    			loadFilter:function(data){
    				//data是服务器返回的数据,将服务器端返回的数据转换为datagrid需要的格式
    				return {"total":data.data.totalRows,"rows":data.data.list};
    			}
    		
    		});
    	}
    </script>
  </body>
</html>
