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
				<th data-options="field:'u_id'">编号</th>
				<th data-options="field:'u_userName'">用户名</th>
				<th data-options="field:'u_weight'">权重</th>
				<th data-options="field:'u_weightbeizhu'">权重备注</th>
				<th data-options="field:'uqdstatus',formatter:weightformatter">分配权重</th>
			</tr>
		</thead>
	</table>

	<div id="bar">
		<form id="str">
			<label>姓名:</label> <input class="easyui-textbox" type="text"
				id="name" /> <a href="javascript:void(0)" class="easyui-linkbutton"
				onclick="init()" data-options="iconCls:'icon-search',plain:true">查询</a>
		</form>
	</div>

	<div id="update-dialog" class="easyui-dialog" title="查看"
		style="width: 600px; height: 400px;"
		data-options="resizable:true,modal:true,closed:true,toolbar:[{
				text:'保存',
				iconCls:'icon-edit',
				handler:function(){updatebaocun();}
			},{
				text:'退出',
				iconCls:'icon-cancel',
				handler:function(){exitUpdate();}}]">
		<form id="xgfrm">
			<div>
				<table>
					<tr style="display: none">
						<td><input class="easyui-textbox" type="text" id="id"
							name="u_id"></td>
					</tr>
					<tr>
						<td><label>权重:</label></td>
						<td><input class="easyui-numberspinner"
							data-options="min:1,max:100" type="text"
							id="weight" name="u_weight"></td>
					</tr>
					<tr>
						<td><label>权重备注:</label></td>
						<td><input class="easyui-textbox" type="text"
							id="weightbeizhu" name="u_weightbeizhu"></td>
					</tr>
				</table>
			</div>
		</form>
	</div>
</body>
<script type="text/javascript">
	$(function() {
		init();
	});
	function init() {
		$("#dg").datagrid({
			url : "selectUweight",
			method : "post",
			pagination : true,
			toolbar : "#bar",
			singleSelect : true,
			queryParams : {
				u_userName : $("#name").textbox("getValue")
			}
		});
		$("#str").form("clear");
	}
	function weightformatter(value, row, index) {
		return "<a href='javascript:void(0)' class='easyui-linkbutton' onclick='xiugai("
				+ index + ")'>调整</a>";
	}
	function xiugai(index) {
		var data = $("#dg").datagrid("getData");
		var row = data.rows[index];
		$("#xgfrm").form("load", row);
		$("#update-dialog").dialog("open");
	}
	function updatebaocun(){
		var u_weight=$("#weight").textbox("getValue");
		var u_weightbeizhu=$("#weightbeizhu").textbox("getValue");
		var u_id=$("#id").textbox("getValue");
		$.post("updateUweight",{
			u_id:u_id,
			u_weight:u_weight,
			u_weightbeizhu:u_weightbeizhu
		},function(res){
			if(res>0){
				$("#dg").datagrid("reload");
				$.messager.alert("提示","调整权重成功!");
				$("#update-dialog").dialog("close");
			}else{
				$.messager.alert("提示","调整权重失败，请重试!");
			}
		},"json");
	}
	function exitUpdate(){
		$("#update-dialog").dialog("close");
	}
</script>
</html>