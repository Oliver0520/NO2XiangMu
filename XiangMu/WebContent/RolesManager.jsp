<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="js/jquery-easyui-1.4.3/themes/icon.css">
<link rel="stylesheet" type="text/css"
	href="js/jquery-easyui-1.4.3/themes/default/easyui.css">
<script type="text/javascript"
	src="js/jquery-easyui-1.4.3/jquery.min.js"></script>
<script type="text/javascript"
	src="js/jquery-easyui-1.4.3/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="js/jquery-easyui-1.4.3/locale/easyui-lang-zh_CN.js"></script>
</head>
<body>
	<table id="dg" class="easyui-datagrid">
		<thead>
			<tr>
				<th data-options="field:'r_id',title:'角色编号'"></th>
				<th data-options="field:'r_name',title:'角色名称'"></th>
			</tr>
		</thead>
	</table>
	
	<div id="bar">
   <a href="javascript:void(0)" class="easyui-linkbutton" onclick="xinzeng()" data-options="iconCls:'icon-add',plain:true">新增</a>
	</div>
	
	<!-- 新增信息的dialog -->
	<div id="insert-dialog" class="easyui-dialog" title="新增窗口" style="width:400px;height:300px;"   
        data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true,toolbar:[{
				text:'保存',
				iconCls:'icon-edit',
				handler:function(){insertbaocun();}
			},{
				text:'退出',
				iconCls:'icon-help',
				handler:function(){exitInsert();}
			}]">
    <table>
    <tr>
    <td><label>角色名:</label></td>
    <td><input class="easyui-textbox" type="text" id="rname" /> </td>
    </tr>
    </table>   
</div> 
</body>
<script type="text/javascript">
$(function(){
	init();
})

function init(){
	$("#dg").datagrid({
		url : "selectAll",
		method : "post",
		pagination : true,
		toolbar : "#bar",
		singleSelect:true});
}
function xinzeng(){
	$("#insert-dialog").dialog("open");
}
</script>
</html>