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
	src="js/JSPjs/Fenpei.js"></script>
</head>
<body>
<table id="dg" class="easyui-datagrid">
		<thead>
			<tr>
				<th data-options="field:'s_id'">编号</th>
				<th data-options="field:'s_name'">姓名</th>
				<th data-options="field:'s_sex',formatter:xingbie">性别</th>
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
				class="easyui-textbox" type="text" id="age" />  
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
</html>