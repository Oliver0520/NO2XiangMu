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
		</form>
	</div>
</body>
<script type="text/javascript">
$(function(){
	init();
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
</script>

</html>