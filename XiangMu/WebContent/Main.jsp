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
	
<script type="text/javascript">
$(function() {

	$.post("hometree", {treeUlId: "treeUlId"},
			function(res) { //res是返回的html代码
				$("#menuTree").html(res);
				$("#treeUlId").tree(); //让easyUI引擎重新将treeUIId中的html代码转变成树并显示
			},"text");
});
//树状结构的节点是否已在中部显示，参数re是标题，html 是路径
function navTab(re, html) {
	var flag = $("#tt").tabs('exists', re);
	$('#treeUlId').tree({ //和前边加载数据的代码中的"treeUIId"参数,保持一致即可
		onSelect: function(node) {
			var isLeaf = $('#treeUlId').tree('isLeaf', node.target); //是否是叶子节点
			if(isLeaf) { //只有叶子节点才会在选项卡中创建选项页（每个选项页对应1个功能）
				if(!flag) {
					$('#tt').tabs('add', { //在选项卡中，创建1个选项页
						title: re, //选项卡中，选项页的标题（在同一个选项卡中，选项页需要保持一致）。
						closable: true,
						content: "<iframe src='" + html + "' style='width:99%;height:590px' />" //此处做了调整，推荐使用iframe的方式实现
					});
				} else {
					$("#tt").tabs('select', re); //直接选中title对应的选项卡
				}
			}
		}
	},"text");
}

function tuichu() {
	$.messager.confirm('确认', '您确认想要退出吗？', function(r) {
		if(r) {
			window.location.href = "tuichu";
		}
	});
}
function xgPwd(){
	$("#update-dialog").dialog("open");
}
function updatebaocun(){
	var opwd=$("#opwd").textbox("getValue");
	var npwd=$("#npwd").textbox("getValue");
	var apwd=$("#apwd").textbox("getValue");
	alert($("#opwd").textbox("getValue")+$("#npwd").textbox("getValue")+$("#apwd").textbox("getValue"))
	$.post("xiugaimima",{opwd:opwd,npwd:npwd,apwd:apwd},function(res){
		if(res.success){
			$.messager.alert("提示",res.msg);
			$("#update-dialog").dialog("close");
			window.location.href = "tuichu";
		}else{
			$.messager.alert("提示",res.msg);
		}
	},"json");
}
function exitUpdate(){
	$("#update-dialog").dialog("closed");
}
</script>
</head>
<body>
<div style="margin: 20px 0;"></div>
	<div class="easyui-layout" style="width: 100%; height: 700px;">
		<div data-options="region:'north'" style="height: 70px">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;CRM系统&nbsp;&nbsp;欢迎您:${usera.u_userName}  
			<a href="javascript:void(0)" onclick="tuichu()"
				style="text-decoration: none; color: black;">&nbsp;&nbsp;&nbsp;&nbsp;安全退出</a>
				<a href="javascript:void(0)" onclick="xgPwd()"
				style="text-decoration: none; color: black;">&nbsp;&nbsp;&nbsp;&nbsp;修改登录密码</a>
			<marquee onMouseOut="this.start()" onMouseOver="this.stop()">
				<span style="font-weight: bolder; font-size: 20px;">云时代欢迎您！</span>
			</marquee>
			
		</div>
		<div data-options="region:'south',split:true" style="height: 50px;"></div>
		<!--<div data-options="region:'east',split:true" title="East" style="width:100px;"></div>-->
		<div data-options="region:'west',split:true" title="导航应用"
			style="width: 150px;">
			<div id="menuTree">
				<!--这个地方显示树状结构-->

			</div>
		</div>
		<div id="centerTabs" data-options="region:'center',iconCls:'icon-ok'"
			style="width: 530px;">
			<div id="tt" class="easyui-tabs">
				<!--这个地方采用tabs控件进行布局-->

			</div>
		</div>
	</div>
	
<!-- 修改密码窗口  -->
	<div id="update-dialog" class="easyui-dialog" title="修改密码窗口" style="width:400px;height:300px;"   
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
    <tr>
    <td><label>原密码:</label></td>
    <td><input class="easyui-textbox" type="text" id="opwd" /> </td>
    </tr>
    <tr>
    <td><label>新密码:</label></td>
    <td><input class="easyui-textbox" type="text" id="npwd" /> </td>
    </tr>
    <tr>
    <td><label>确认密码:</label></td>
    <td><input class="easyui-textbox" type="text" id="apwd" /> </td>
    </tr>
    </table>   
    </form>
</div>
</body>

</html>