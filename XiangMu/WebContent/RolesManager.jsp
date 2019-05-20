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
function insertbaocun(){
	var r_name= $("#rname").textbox("getValue");
	$.post("selectRolesl",{r_name:r_name},function(res){
		if(res>0){
			$.messager.alert('提示','角色名称已被占用，请更换！！！');
		}else{
			$.post("insertRoles",{r_name:r_name},function(res){
				if(res>0){
					$("#dg").datagrid("reload");
					$.messager.alert('提示','新增成功');
					$("#insert-dialog").dialog("close");
				}else{
					$.messager.alert('提示','新增失败');
				}
			});
		}
	},"json");
}
function caozuoformatter(value,row,index){
	return " <a href='javascript:void(0)' class='easyui-linkbutton' onclick='shanchu("+index+")'>删除</a>     <a href='javascript:void(0)' class='easyui-linkbutton' onclick='xiugai("+index+")'>编辑</a>  ";
}
function shanchu(index){
	var data=$("#dg").datagrid("getData");
	var row=data.rows[index];
	$.messager.confirm('确认','您确认想要删除记录吗？',function(r){    
	    if (r){    
	    	$.post("deleteRoles",{r_id:row.r_id},function(res){
				if(res.success){
					$("#dg").datagrid("reload");
					$.messager.alert("提示", res.msg);
				}else{
					$.messager.alert("提示", res.msg);
				}
			},"json");
	    }    
	});
}
function xiugai(index){
	var data=$("#dg").datagrid("getData");
	var row=data.rows[index];
	$("#upfrm").form("load",row);
	$("#update-dialog").dialog("open");	
}
function updatebaocun(){
	var r_name= $("#rnameu").textbox("getValue");
	var r_id= $("#ridu").textbox("getValue");
	$.post("selectRolesl",{r_name:r_name},function(res){
		if(res>0){
			$.messager.alert('提示','角色名称已被占用，请更换！！！');
		}else{
			$.post("updateRoles",{r_name:r_name,r_id:r_id},function(res){
				if(res>0){
					$("#dg").datagrid("reload");
					$.messager.alert('提示','编辑成功');
					$("#update-dialog").dialog("close");
				}else{
					$.messager.alert('提示','编辑失败');
				}
			});
		}
	},"json");
	
}
function shezhiformatter(value,row,index){
	return "  <a href='javascript:void(0)' class='easyui-linkbutton' onclick='kongzhi("+index+")'>设置</a>  ";
}
function exitUpdate(){
	$("#update-dialog").dialog("close");
}

function kongzhi(index) {
	var data = $("#dg").datagrid("getData");
	var row = data.rows[index];
	$("#tt").tree({
		url: "selectMoInR",
		lines: true,
		queryParams: {
			r_id: row.r_id,
		},
		checkbox : true,
		onContextMenu: function(e, node) {
			$("#tt").tree('select', node.target);
		}
	});
	jiaoseid = null;
	jiaoseid = row.r_id;
	$("#quanxiantree").window("open");
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
		if (res.success) {
			$.messager.alert("提示", res.msg);
			$('#quanxiantree').window('close');
			$("#dg").datagrid("reload");
			
		} else {
			$('#quanxiantree').window('close');
			$("#dg").datagrid("reload");
			$.messager.alert("提示", res.msg);
		}
	}, "json");

}
</script>
</html>