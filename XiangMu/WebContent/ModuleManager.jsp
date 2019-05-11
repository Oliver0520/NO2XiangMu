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
<div class="easyui-layout" style="width:100%;height:700px;">

			<div id="centerTabs" data-options="region:'center',iconCls:'icon-ok',title:'模块信息'" style="width: 530px;">
				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="addInfo()">新增</a>
				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-update" plain="true" onclick="updateInfo()">修改</a>
				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" plain="true" onclick="Info()">删除</a>
				<div id="menuTree">
					<!--这个地方显示树状结构-->

				</div>
			</div>
		</div>
		
		
		<div id="add_window" class="easyui-window" title="添加模块信息" data-options="modal:true,closed:true,iconCls:'icon-save'" style="width:500px;height:300px;padding:10px;">
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
						<td><input class="easyui-numberbox" type="text" name="weight1" id="weight1" data-options="required:true"></input>
						</td>
					</tr>
					<tr>
						<td>URL:</td>
						<td><input class="easyui-textbox" type="text" name="url1" id="url1" data-options="required:true"></input>
						</td>
					</tr>

					<tr>
						<td>模块名称:</td>
						<td><input type="text" class="easyui-textbox" id="name1" name="name1" data-options="required:true"></td>
					</tr>
				</table>
			</form>
			<div style="text-align:center;padding:5px">
				<a href="javascript:void(0)" class="easyui-linkbutton" type="button" onclick="submitaddUserForm()">提交</a>
				<a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearModuleForm()">取消</a>
			</div>
		</div>
		
		
		
		<div id="update_window" class="easyui-window" title="修改员工信息" data-options="modal:true,closed:true,iconCls:'icon-save'" style="width:500px;height:300px;padding:10px;">
			<form id="updateuserForm">
				<table cellpadding="5">
					<tr>
						<td>权重:</td>
						<td><input class="easyui-numberbox" type="text" name="m_weight" id="weight" data-options="required:true"></input>
						</td>
					</tr>
					<tr>
						<td>URL:</td>
						<td><input class="easyui-textbox" type="text" name="m_path" id="url" data-options="required:true"></input>
						</td>
					</tr>

					<tr>
						<td>模块名称:</td>
						<td><input type="text" class="easyui-textbox" id="m_name" name="namey" data-options="required:true"></td>
					</tr>
				</table>
			</form>
			<div style="text-align:center;padding:5px">
				<a href="javascript:void(0)" class="easyui-linkbutton" type="button" onclick="submitupdateUserForm()">提交</a>
				<a href="javascript:void(0)" class="easyui-linkbutton" onclick="uclearModuleForm()">取消</a>
			</div>
		</div>
</body>
<script type="text/javascript">
var mokuai=null;
$(function() {
	myTree();
});

function myTree() {
	$("#menuTree").tree({
		url: "selectModule",
		method:"post",
		lines: true,
		onContextMenu: function(e, node) {
			$("#menuTree").tree('select', node.target);
		}
	});
}
function addInfo() {
	var nodes = $("#menuTree").tree("getSelected");
	if(nodes.text != "") {
		$("#pname").text(nodes.text);
		$("#add_window").window("open");
	} else {
		alert("请选择父节点");
	}
}
function submitaddUserForm() {
	var nodes = $("#menuTree").tree('getSelected');
	var flag = $("#adduserForm").form("validate");
	var moduleName = $("#name1").val();
	var weight = $("#weight1").val();
	var path = $("#url1").val();
	if(flag) {
		$.post("selectMbn",{m_name: moduleName,m_parentId: nodes.id},function(res){
			if(res>0){
				$.messager.alert('提示','模块名称已被占用，请更换！！！');
			}else{
				$.post("insertMod", {
					m_name: moduleName,
					m_parentId: nodes.id,
					m_path: path,
					m_weight: weight
				}, function(res) {
					if(res>0) {
						$.messager.alert("提示","新增成功");
						$("#add_window").window("close");
						$('#adduserForm').form('clear');
						myTree();
					}else{
						$.messager.alert("提示","新增失败");
					}
				}, "json");
			}
		},"json");
		
	}
}
function clearModuleForm() {
	$('#adduserForm').form('clear');
	$("#add_window").window("close");
}


function updateInfo() {
	var nodes = $('#menuTree').tree('getSelected');
	$.post("selectByid", {
		m_id: nodes.id,
	}, function(res) {
		alert(res.message);
		var sss = res.message ;
			mokuai = null;
			mokuai = sss;
			$('#updateuserForm').form('load', sss);
			$('#update_window').window('open');
			}, "json");

}

function submitupdateUserForm() {
	var weight = $("#weight").val();
	var mkurl = $("#url").val();
	var name = $("#namey").val();
	$.post("updateModu", {
		m_id: mokuai.id,
		m_name: name,
		m_parentId: mokuai.parentId,
		m_path: mkurl,
		m_weight: weight
	}, function(res) {
		if(res.success) {
			$('#update_window').window('close');
			myTree();
			$.messager.alert("提示", "更新成功");
		} else {
			$.messager.alert("提示", "更新失败");
		}
	}, "json");

}
function uclearModuleForm() {
	$("#update_window").window("close");
}
function Info() {
	var nodes = $('#menuTree').tree('getSelected');
	$.messager.confirm('确认','您确认想要删除记录吗？',function(r){    
	    if (r){ 
	$.post("deleteMod", {
		m_id: nodes.id
	}, function(res) {
		if(res>0) {
			$.messager.alert("提示", "删除成功");
			myTree();
		} else {
			$.messager.alert("提示", "删除失败");
		}
	},"json");	
    }    
});
}
</script>
</html>