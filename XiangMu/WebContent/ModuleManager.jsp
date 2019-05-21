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
	src="js/JSPjs/ModuleManager.js"></script>
</head>
<body>
	<div class="easyui-layout" style="width: 100%; height: 700px;">

		<div id="centerTabs"
			data-options="region:'center',iconCls:'icon-ok',title:'模块信息'"
			style="width: 530px;">
			<a href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-add" plain="true" onclick="addInfo()">新增</a> <a
				href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-update" plain="true" onclick="updateInfo()">修改</a> <a
				href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-ok" plain="true" onclick="Info()">删除</a>

			<div id="menuTree">
				<!--这个地方显示树状结构-->

			</div>
<div id="mm" class="easyui-menu" style="width: 160px;">
		<div data-options="iconCls:'icon-add',name:'add'" onclick="addInfo()">追加</div>
		<div data-options="iconCls:'icon-edit',name:'edit'" onclick="updateInfo()">修改</div>
		<div data-options="iconCls:'icon-remove',name:'del'" onclick="Info()">删除</div>

	</div>

		</div>

	</div>
	

	<div id="add_window" class="easyui-window" title="添加模块信息"
		data-options="modal:true,closed:true,iconCls:'icon-save'"
		style="width: 500px; height: 300px; padding: 10px;">
		<form id="adduserForm">
			<table cellpadding="5">
				<tr>
					<td>父节点名称:</td>
					<td>
						<div id="pname"></div>
					</td>
				</tr>
				<tr>
					<td>权重:</td>
					<td><input class="easyui-numberbox" type="text" name="weight1"
						id="weight1" data-options="required:true"></input></td>
				</tr>
				<tr>
					<td>URL:</td>
					<td><input class="easyui-textbox" type="text" name="url1"
						id="url1" data-options="required:true"></input></td>
				</tr>

				<tr>
					<td>模块名称:</td>
					<td><input type="text" class="easyui-textbox" id="name1"
						name="name1" data-options="required:true"></td>
				</tr>
			</table>
		</form>
		<div style="text-align: center; padding: 5px">
			<a href="javascript:void(0)" class="easyui-linkbutton" type="button"
				onclick="submitaddUserForm()">提交</a> <a href="javascript:void(0)"
				class="easyui-linkbutton" onclick="clearModuleForm()">取消</a>
		</div>
	</div>



	<div id="update_window" class="easyui-window" title="修改员工信息"
		data-options="modal:true,closed:true,iconCls:'icon-save'"
		style="width: 500px; height: 300px; padding: 10px;">
		<form id="updateuserForm">
			<table cellpadding="5">
				<tr>
					<td>权重:</td>
					<td><input class="easyui-numberbox" type="text"
						name="m_weight" id="weight" data-options="required:true"></input>
					</td>
				</tr>
				<tr>
					<td>路径:</td>
					<td><input class="easyui-textbox" type="text" name="m_path"
						id="url" data-options="required:true"></input></td>
				</tr>
				<tr>
					<td>模块ID:</td>
					<td><input class="easyui-textbox" type="text" name="m_id"
						id="m_id" data-options="required:true"></input></td>
				</tr>
				<tr>
					<td>模块名称:</td>
					<td><input type="text" class="easyui-textbox" id="namey"
						name="m_name" data-options="required:true"></td>
				</tr>
			</table>
		</form>
		<div style="text-align: center; padding: 5px">
			<a href="javascript:void(0)" class="easyui-linkbutton" type="button"
				onclick="submitupdateUserForm()">提交</a> <a href="javascript:void(0)"
				class="easyui-linkbutton" onclick="uclearModuleForm()">取消</a>
		</div>
	</div>
</body>
</html>