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
  	<form>
   	<table id="productList" class="easyui-datagrid"></table>
    <div id="toolbar"> 
      <!-- <select name="productid">
         <option value="任意字段">任意字段</option>
         <option value="产品名称">产品名称</option>
         <option value="研发时间">研发时间</option>
         <option value="详情连接">详情连接</option>
         <option value="开发团队">开发团队</option>
         <option value="成本价">成本价</option>
         <option value="建议零售价">建议零售价</option>
         <option value="创建人">创建人</option>
         <option value="创建时间">创建时间</option>
         <option value="修改时间">修改时间</option>  
      </select>
    -->
    
      产品名称:<input type="text" name="name" style="width:100px;height:35px;line-height:35px;" class="easyui-textbox theme-textbox-radius"/>
      产品零售价格:<input type="text" name="suggestedPrice" style="width:100px;height:35px;line-height:35px;" class="easyui-textbox theme-textbox-radius"/>
             <input type="reset"  id="setBtn1" class="easyui-linkbutton" data-options="iconCls:'icon-reload' ">
    	
    	<a href="javascript:void(0);" onclick="return mysearch()" id="searchBtn" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true">搜索</a> 
    	<a href="javascript:void(0);" onclick="return add('manage/product/ProductAction_edit.action')" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">添加产品</a>
    	<a href="javascript:void(0);" onclick="return edit('manage/product/ProductAction_edit.action');" id="editBtn" class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true">修改</a>
    	<a href="javascript:void(0);" onclick="return del('manage/product/ProductAction_remove.action')" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">删除</a>
    	<a href="javascript:void(0);" onclick="return assign('manage/user/UserAction_assign.action')" id="setBtn" class="easyui-linkbutton" data-options="iconCls:'icon-tip',plain:true">产品工具</a>
    </div>
    </form>
    <script type="text/javascript">
    	//根据产品名称和产品价格相查询分业展示
    	function mysearch(){
            $("#productList").datagrid("load",{
    	   	 	name:$("input[name=name]").val(),
                suggestedPrice:$("input[name=suggestedPrice]").val()
        	});
        }
    	//修改按钮事件处理函数
    	function edit(url){
            var rows = $("#productList").datagrid("getChecked");
            if(rows.length == 0){
                $.messager.alert("提示信息","请选择需要修改的岗位！")
                return;
            }
            if(rows.length > 1){
                $.messager.alert("提示信息","请选择一条需要修改的岗位！")
                return;
            }
            if(rows.length==1) {
                var productId = rows[0].productid;
                parent.openTopWindow({
                    width:700,
                    height:500,
                    title:"修改",
                    url:"manage/product/ProductAction_edit.action?productId="+productId,
                    close:function () {
                        $("#productList").datagrid("reload");
                    }
                })
            }

    	}
    	//添加按钮事件处理函数
        function add(url){
        	parent.openTopWindow({
    				width:700,
    				height:500,
    				title:"添加产品信息",
    				"url": url,
    				close:function(){
    					$("#productList").datagrid("reload");
    				}
    				
    			});
        }
        //删除按钮事件处理函数
        function del(url){
        	//获取到选中的一行数据
                var productIds = new Array();
    			var rows = $("#productList").datagrid("getChecked");
    			
    			if(!rows.length){
    				$.messager.alert("警告","请选择要删除的数据");
    				return false;
    			}
    			
    			$.messager.confirm("警告","数据删除后无法恢复，是否确认删除",function(b){
                            if(b){
                                if(rows){
                                    $.each(rows,function (index,obj) {
                                        productIds.push(obj.productid);
                                    })
                                }
                                productIds.join(",");
                                $.post(url, {"productIds" : productIds.toString()}, function (result) {
                                    if (result.success) {
                                        $("#productList").datagrid("reload");
                                        $("#productList").datagrid("clearChecked");
                                    }
                                }, "json")
                            }
    			});
        }
    	//加载用户数据
    	$(function(){
    		$("#productList").datagrid({
    			url : "manage/product/ProductAction_findByPage.action",
    			pagination : true,
    			toolbar : "#toolbar",
    			fitColumns : true,
    			idField : "productid",
    			rownumbers : true,
    			//singleSelect:true,
    			columns : [[  
    				{field:"productid",title:"选择",checkbox:true}, 				
    				{field:"name",title:"产品名称",sortable:true,width:10},
    				{field:"link",title:"详情链接",width:10},
    				{field:"userName",title:"创建人",width:10},
    				{field:"createTime",title:"修改时间",width:10},
    				{field:"updateTime",title:"更新时间",width:10},
    				{field:"costPrice",title:"成本价格",width:7},
    				{field:"suggestedPrice",title:"建议价格",width:7},
    				//{field:"operation",title:"操作",formatter:function(value,rowData,index){
  			//return "<a href='javascript:void(0)' onclick='see("+rowData.id+")'>查看</a>"+
  			//" <a href='javascript:void(0)' onclick='editproduct("+rowData.id+")'>编辑</a>"
  			
  			
  		//}},	
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
