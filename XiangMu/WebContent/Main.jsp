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
	src="js/JSPjs/Main.js"></script>
<script type="text/javascript">
$(function() {
 var qdstatus="<%=session.getAttribute("qdstatus")%>";

$.post("hometree", {treeUlId: "treeUlId"},
		function(res) { //res是返回的html代码
			$("#menuTree").html(res);
			$("#treeUlId").tree(); //让easyUI引擎重新将treeUIId中的html代码转变成树并显示
		},"text");
 if(qdstatus=="2"||qdstatus=="4"){
	 $.messager.alert("提示","亲，请先去签到，不要迟到哦！！！");
 }
});
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
			<a href="javascript:void(0)" onclick="qd()"
				style="text-decoration: none; color: red;">&nbsp;&nbsp;&nbsp;&nbsp;签到</a>
			<!-- <marquee onMouseOut="this.start()" onMouseOver="this.stop()">
				<span style="font-weight: bolder; font-size: 20px;">云时代欢迎您！</span>
			</marquee> -->

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
	<div id="update-dialog" class="easyui-dialog" title="修改密码窗口"
		style="width: 400px; height: 300px;"
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
					<td><input class="easyui-textbox" type="password" id="opwd" /></td>
				</tr>
				<tr>
					<td><label>新密码:</label></td>
					<td><input class="easyui-textbox" type="password" id="npwd" /></td>
				</tr>
				<tr>
					<td><label>确认密码:</label></td>
					<td><input class="easyui-textbox" type="password" id="apwd" /></td>
				</tr>
				<tr>
					<td><label>手机号:</label></td>
					<td><input class="easyui-textbox" type="text" id="phone" /></td>
					<td><a href="javascript:void(0)" onclick="sendyanzhengma()">发送验证码</a>
					</td>
				</tr>
				<tr>
					<td><label>验证码:</label></td>
					<td><input class="easyui-textbox" type="text" id="yanzheng" /></td>
				</tr>
			</table>
		</form>
	</div>
</body>

</html>