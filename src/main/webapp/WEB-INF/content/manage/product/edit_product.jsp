<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
    <meta charset="UTF-8">
    <title>添加角色</title>
    
	<meta name="pragma" content="no-cache">
	<meta name="cache-control" content="no-cache">
	<meta name="content-type" content="text/html;charset=UTF-8">
	<meta name="expires" content="0">    
	<%@ include file="../../script.html" %>
	
  </head>
  
  <body style="width:100%;max-width:600px;padding:30px 60px;">
	<section class="info-section">
		<form id="form" method="post">
			<table>
				<tr>
					<td class="text-title">产品名称：</td>
					<td class="text-content">
						<input type="hidden" name="productVO.productid" value="${productVO.productid }"> 
						<input type="text" name="productVO.name" value="${productVO.name }" 
							class="easyui-textbox theme-textbox-radius" data-options="required:true,validType:'length[3,10]'">
					</td>
				</tr>
				<tr>
					<td class="text-title">详情链接：</td>
					<td class="text-content">
						<input type="text" name="productVO.link" value="${productVO.link }"
							class="easyui-textbox theme-textbox-radius" data-options="required:true">
							<input type="hidden" name="productVO.userName" value="${productVO.userName }">
					</td>
				</tr>
				
				<%-- <tr>
					<td class="text-title">创建人：</td>
					<td class="text-content">
						<input type="hidden" name="productVO.userId" value="${productVO.userId }"
							class="easyui-textbox theme-textbox-radius" data-options="required:true">
					</td>

				</tr>--%>

				<tr>
					
					<td class="text-content">
					    <input type="hidden" name="productVO.updateTime"  value="${productVO.updateTime }" >
						<input type="hidden" name="productVO.createTime"  value="${productVO.createTime }" >
					</td>
				</tr>
				<!-- <tr>
					<td class="text-title">更新时间：</td>
					<td class="text-content">
						<input type="text" name="productVO.updateTime" value="${productVO.updateTime }" class="easyui-textbox theme-textbox-radius"data-options="required:true">
					</td>
				</tr>
				 -->
				<tr>
					<td class="text-title">成本价格：</td>
					<td class="text-content">
						<input type="text" name="productVO.costPrice" value="${productVO.costPrice}"
							class="easyui-textbox theme-textbox-radius" data-options="required:true">
					</td>
				</tr>	
				<tr>
					<td class="text-title">建议价格：</td>
					<td class="text-content">
						<input type="text" name="productVO.suggestedPrice" value="${productVO.suggestedPrice }"
							class="easyui-textbox theme-textbox-radius" data-options="required:true">
					</td>	
				</tr>
				
				<tr>
					<td colspan="2" style="text-align: center;margin-top: 10px;">
						<a href="javascript:void(0);" id="saveBtn" class="easyui-linkbutton button-primary">保存</a> 
						<a href="javascript:void(0);" id="resetBtn" class="easyui-linkbutton button-danger">重置</a>
					</td>
				</tr>
				</table>
		</form>
	</section>
	<script type="text/javascript">
		$(function() {
			//重置按钮
			$("#resetBtn").on("click",function(event){
			    $("#form").form("reset");
			});
			
			//为保存按钮添加事件
			$("#saveBtn").on("click",function(event){
			    $.post("manage/product/ProductAction_save.action",$("#form").serialize(),function (result) {
					if(result) {
                        $.messager.alert('提示信息', '保存成功',"info",function () {
                            parent.closeTopWindow();
                        });
					}else {
                        $.messager.alert('提示信息', '保存失败');
					}
			},"json")
		})

		})
	</script>
</body>
</html>
				
