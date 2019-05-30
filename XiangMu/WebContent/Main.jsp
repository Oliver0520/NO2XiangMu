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
			<style>.tree-node-selected{background-color:#8D8D8D;color:#E68900}</style>
			<style>.tree-node{color:white;}</style>
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
	 $("#qiantui").hide();
	 $("#qiandao").show();
 }else{
	 $("#qiantui").show();
	 $("#qiandao").hide();
 }
 $.post("CopyCount",function(res){
	if(res.success){
		$("#weidu-window").window("open");
	} else{
		$.messager.alert("提示",res.msg);
		
		$("#weidu-window").window("close");
	}
 });
});
function showDynamic(){
	 var url="Dynamic.jsp";
	  $('#tt').tabs('add', { //在tt选项卡中，创建一个选项页
        title: '动态消息',
        closable: true,	
        content:"<iframe frameborder='0' src='"+url+"' style='width:100%;height:520px;'/>" //推荐使用iframe引入一个完整页面
    });
	  closeDynamic();

}

function closeDynamic(){
	$("#weidu-window").window("close");
}
function sendyanzhengma(){
	$.post("sendyanzhengma",
			{phone:$("#phone").textbox("getValue")},
			function(res){
				if(res==1){
					$.messager.alert("提示","验证码已发送，请注意查收！");
				}else{
					$.messager.alert("提示","验证码发送失败，请重试！");			
				}
	},"json");
	
}
function qd(){
	$.post("empqd",{time:getNowFormatDate()},function(res){
		if(res.success){
			$.messager.alert("提示", res.msg);
			 $("#qiantui").show();
			 $("#qiandao").hide();
		}else{
			$.messager.alert("提示", res.msg);
			 $("#qiantui").hide();
			 $("#qiandao").show();
		}
	},"json");
}
function qt(){
	$.post("empqt",{time:getNowFormatDate()},function(res){
		if(res.success){
			$.messager.alert("提示", res.msg);
			 $("#qiantui").hide();
			 $("#qiandao").show();
		}else{
			$.messager.alert("提示", res.msg);
			 $("#qiantui").show();
			 $("#qiandao").hide();
		}
	},"json");
}
function updatebaocun(){
	var opwd=$("#opwd").textbox("getValue");
	var npwd=$("#npwd").textbox("getValue");
	var apwd=$("#apwd").textbox("getValue");
	var phone=$("#phone").textbox("getValue");
	var yanzheng=$("#yanzheng").textbox("getValue");
	$.post("xiugaimima",{opwd:opwd,npwd:npwd,apwd:apwd,yanzheng:yanzheng,phone:phone},function(res){
		if(res.success){
			$.messager.alert("提示",res.msg);
			$("#update-dialog").dialog("close");
			window.location.href = "tuichu";
		}else{
			$.messager.alert("提示",res.msg);
		}
	},"json");
}
</script>
 

</head>
<body>
	<div style="margin: 20px 0;"></div>
	<div class="easyui-layout" style="width: 100%; height: 750px;color:white">
		<div data-options="region:'north'" style="height: 50px;background-image: url(assets/img/QQ截图20190523200046.png);">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;CRM系统&nbsp;&nbsp;欢迎您:${usera.u_userName}
			<a href="javascript:void(0)" onclick="tuichu()"
				style="text-decoration: none; color: black;">&nbsp;&nbsp;&nbsp;&nbsp;安全退出</a>
			<a href="javascript:void(0)" onclick="xgPwd()"
				style="text-decoration: none; color: black;">&nbsp;&nbsp;&nbsp;&nbsp;修改登录密码</a>
			<a href="javascript:void(0)" onclick="qd()"
				style="text-decoration: none; color: red;" id="qiandao">&nbsp;&nbsp;&nbsp;&nbsp;签到</a>
			<a href="javascript:void(0)" onclick="qt()"
				style="text-decoration: none; color: red;" id="qiantui">&nbsp;&nbsp;&nbsp;&nbsp;签退</a>

		</div>

		
		<!--<div data-options="region:'east',split:true" title="East" style="width:100px;"></div>-->
		<div data-options="region:'west',split:true" title="导航应用"
			style="width: 200px;background-image: url(assets/img/QQ截图20190523204935.png);">

			<div id="menuTree">
				<!--这个地方显示树状结构-->

			</div>
		</div>
		<div id="centerTabs" data-options="region:'center',iconCls:'icon-ok'"
			style="width: 530px;background-image: url(assets/img/QQ截图20190523201228.png);">
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
	<div id="weidu-window" class="easyui-window" title="My Window" style="width:250px;height:140px"   
        data-options="iconCls:'icon-save',modal:true,close:true">   
   <table>
				<tr>
					<td colspan="2">您有${weidu}条未读消息</td>
					<td></td>
				</tr>
				<tr>
					<td><a href="javascript:void(0)" onclick="showDynamic()"
				class="easyui-linkbutton" data-options="iconCls:'icon-ok'">查看</a></td>
					<td><a href="javascript:void(0)" onclick="closeDynamic()"
				class="easyui-linkbutton" data-options="iconCls:'icon-no'">暂不查看</a></td>
				</tr>
				
			</table>
     </div>  
</body>

</html>