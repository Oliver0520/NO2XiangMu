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
				<th data-options="field:'s_id'">编号</th>
				<th data-options="field:'s_name'">姓名</th>
				<th data-options="field:'s_sex'">性别</th>
				<th data-options="field:'s_age'">年龄</th>
				<th data-options="field:'s_phone'">电话</th>
				<th data-options="field:'uqdstatus',formatter:xzixunformatter">分配咨询师</th>				
			</tr>
		</thead>
	</table>
	<div id="bar">
		<form id="str">
			<label>姓名:</label> <input class="easyui-textbox" type="text" id="name" /> 
				<label>年龄:</label> <input
				class="easyui-datetimebox" type="text" id="age" />  
				 <label>性别:</label>
			<select id="sex" class="easyui-combobox" 
				style="width: 200px;">
				<option value="aa">--请选择--</option>
				<option value="1">男</option>
				<option value="2">女</option>
			</select> <a href="javascript:void(0)" class="easyui-linkbutton"
				onclick="init()" data-options="iconCls:'icon-search',plain:true">查询</a>
				<a href="javascript:void(0)" onclick="zidong()"><input class="easyui-switchbutton"  id="kaiguan" data-options="onText:'Yes',offText:'No'"></a>
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
			<div style="float: left">
				<table>
					<tr style="display: none">
						<td><input class="easyui-textbox" type="text" id="s_id"
							name="s_id"></td>
					</tr>
					<tr>
						<td><label>咨询师:</label></td>
						<td>
						<select id="zixunshi" class="easyui-combobox" 
				style="width: 200px;">
			</select>
						</td>
					</tr>
					</table>
					</div>
					</form>
					</div>
</body>
<script type="text/javascript">
$(function(){
	init();
	$.post("selectIsORNot",function(res){
		if(res==1){
			$("#kaiguan").switchbutton("uncheck");
		}
		if(res==2){
			$("#kaiguan").switchbutton("check");
		}
	},"json");
});
function init(){
	var s = $("#sex").combobox("getValue");
	if (s == "aa") {
		s = null;
	}
	$("#dg").datagrid({
		url:"selectFenpei",
		method:"post",
		pagination : true,
		toolbar : "#bar",
		singleSelect:true,
		queryParams : {
			s_sname : $("#name").textbox("getValue"),
			s_age : $("#age").textbox("getValue"),
			s_sex : s
		}
	});
}

function xzixunformatter(value,row,index){
	return "<a href='javascript:void(0)' class='easyui-linkbutton' onclick='xiugai("+index+")'>分配</a>";
}

function xiugai(index){
	$("#zixunshi").combobox({
		url:'selectZXS',    
	    valueField:'u_id',
	    textField:'u_userName' 
	});
	var data = $("#dg").datagrid("getData");
	var row = data.rows[index];
	$("#xgfrm").form("load",row);
	$("#update-dialog").dialog("open");
}
function updatebaocun(){
	var s = $("#zixunshi").combobox("getValue");
	var s_id=$("#s_id").textbox("getValue");
	$.post("fenpeizx",{
		s_id:s_id,
		u_id:s
	},function(res){
		if(res>0){
			$.messager.alert("提示","分配成功");
			$("#update-dialog").dialog("close");
			$("#dg").datagrid("reload");
		}else{
			$.messager.alert("提示","分配失败");
		}
	},"json");
}
function exitUpdate(){
	$("#update-dialog").dialog("close");
}
function zidong(){
	var zhi=$("#kaiguan")[0].checked;
	var fenpei=null;
	if(zhi){
		fenpei=2;
	}else{
		fenpei=1;
	}
	$.post("updateIsFenpei",{
		fenpei:fenpei},function(res){
			if(res.success){
				$.messager.alert('提示',res.msg); 
			}else{
				$.messager.alert('提示',res.msg); 
			}
		},"json");
}
</script>

</html>