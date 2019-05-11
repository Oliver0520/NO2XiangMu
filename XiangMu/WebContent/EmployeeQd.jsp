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
				<th data-options="field:'u_qdshijian'">签到时间</th>
				<th data-options="field:'u_qdstatus'">签到状态</th>
				<th data-options="field:'caozuo',formatter:caozuoformatter,align:'ceter',title:'操作'"></th>
				
			</tr>
		</thead>
	</table>
	<div id="bar">
		<form id="str">
			<label>用户名:</label> <input class="easyui-textbox" type="text"
				id="uname" /> 
				<label>员工签到时间:</label> <input
				class="easyui-datetimebox" type="text" id="stime" /> ~ <input
				class="easyui-datetimebox" type="text" id="etime" /> 
				 <label>签到状态:</label>
			<select id="statusqd" class="easyui-combobox" 
				style="width: 200px;">
				<option value="aa">--请选择--</option>
				<option value="已签到">已签到</option>
				<option value="未签到">未签到</option>
				<option value="迟到">迟到</option>
				<option value="已签退">已签退</option>
			</select> <a href="javascript:void(0)" class="easyui-linkbutton"
				onclick="init()" data-options="iconCls:'icon-search',plain:true">查询</a>
			<a href="javascript:void(0)" class="easyui-linkbutton"
				onclick="xinzeng()" data-options="iconCls:'icon-add',plain:true">新增</a>
		</form>
	</div>
</body>
<script type="text/javascript">
$(function(){
	init();
})
function init(){
	var s = $("#statusqd").combobox("getValue");
	if (s == "aa") {
		s = null;
	}
alert(s);
	$("#dg").datagrid({
		url : "selectUserQD",
		method : "post",
		pagination : true,
		toolbar : "#bar",
		singleSelect:true,
		queryParams : {
			u_userName : $("#uname").textbox("getValue"),
			stime : $("#stime").textbox("getValue"),
			etime : $("#etime").textbox("getValue"),
			u_qdstatus : s
		}
	});
	$("#str").form("clear");
}
function caozuoformatter(value,row,index){
	return "<a href='javascript:void(0)' class='easyui-linkbutton' onclick='xiugai("+index+")'>签退</a>  ";
}
function xiugai(index){
	var data=$("#dg").datagrid("getData");
	var row=data.rows[index];
	$.post("qdCaozuo",{u_id:row.u_id},function(res){
		if(res.success){
			$.messager.alert('提示',res.msg); 
		}else{
			$.messager.alert('提示',res.msg); 
		}
		
	},"json");
	
}
</script>
</html>