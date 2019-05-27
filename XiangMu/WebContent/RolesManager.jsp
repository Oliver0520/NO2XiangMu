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
	<script type="text/javascript"
	src="js/JSPjs/RolesManager.js"></script>
</head>
<body>
	<table id="dg" class="easyui-datagrid">
		<thead>
			<tr>
				<th data-options="field:'r_id',title:'角色编号'"></th>
				<th data-options="field:'r_name',title:'角色名称'"></th>
				<th data-options="field:'caozuo',title:'操作列',formatter:caozuoformatter"></th>
				<th data-options="field:'shezhi',title:'设置',formatter:shezhiformatter"></th>
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

<!-- 修改信息的dialog -->
	<div id="update-dialog" class="easyui-dialog" title="新增窗口" style="width:400px;height:300px;"   
        data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true,toolbar:[{
				text:'保存',
				iconCls:'icon-edit',
				handler:function(){updatebaocun();}
			},{
				text:'退出',
				iconCls:'icon-help',
				handler:function(){exitUpdate();}
			}]">
			<form id="upfrm">
    <table>
    <tr style="display: none;">
    <td><label>角色ID:</label></td>
    <td><input class="easyui-textbox" type="text" id="ridu" name="r_id"/> </td>
    </tr>
    <tr>
    <td><label>角色名:</label></td>
    <td><input class="easyui-textbox" type="text" id="rnameu" name="r_name"/> </td>
    </tr>
    </table>   
    </form>
</div> 

	<div id="quanxiantree" class="easyui-window"
		style="width: 300px; height: 460px"
		data-options="iconCls:'icon-save',modal:true,closed:true">
		<div class="easyui-layout" data-options="fit:true">
			<div data-options="region:'north',split:true" style="height: 380px">
				<div id="mkdiv" class="easyui-panel" style="padding: 5px">
					<ul id="tt" class="easyui-tree"
						data-options="iconCls:'icon-save',collapsible:true"></ul>
				</div>
			</div>
			<div data-options="region:'center'" style="text-align: center;">
				<a id="btn" href="javascript:void(0)" 
					class="easyui-linkbutton" onclick="tijiaoModules()"
					data-options="iconCls:'icon-ok'">保存</a>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
function insertbaocun(){
	var r_name= $("#rname").textbox("getValue");
	
			$.post("insertRoles",{r_name:r_name},function(res){
				if(res.success){
					$("#dg").datagrid("reload");
					$.messager.alert('提示',res.msg);
					$("#insert-dialog").dialog("close");
				}else{
					$.messager.alert('提示',res.msg);
				}
			},"json");
}

function tijiaoModules() {
	var trees = $("#tt").tree("getChecked", [ "checked", "indeterminate" ]);
	var ids = "";
	for (var i = 0; i < trees.length; i++) {
		if (ids == "") {
			ids = ids + trees[i].id;
		} else {
			ids = ids + "," + trees[i].id;
		}
	}
	$.post("insertRoleModule", {
		m_id : ids,
		r_id : jiaoseid
	}, function(res) {
		if (res>0) {
			$.messager.alert("提示", "设置成功");
			$('#quanxiantree').window('close');
			$("#dg").datagrid("reload");
			
		} else {
			$('#quanxiantree').window('close');
			$("#dg").datagrid("reload");
			$.messager.alert("提示", "设置失败");
		}
	}, "json");

}
</script>
</html>