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
		$('#dd').dialog({
			title : 'hello', //标题栏
			width : 400, //宽度
			height : 900, //高度
			closed : false, //是否关闭（隐藏）
		// content:'<h1>hello my first jquery</h1>'  //显示的内容
		});
	});
</script>
</head>
<body>
	<div class="easyui-window"
		data-options="closable:false, title:'登录界面',maximizable:false,minimizable:false,collapsible:false,shadow:true,modal:true,iconCls:'icon-save'">
		<div class="easyui-panel" style="width: 400px; height: 400px;"
			data-options="border:true" id="pppp">
			<form id="subfor">
				<div style="text-align: center">
					<table cellpadding="3" cellspacing="10"
						style="width: 60%; margin: auto">
						<tr>
							<td>登录名:</td>
							<td><input class="easyui-textbox" type="text"
								data-options="required:true" id="username" value="${cookie.u_loginName.value }" onblur="haha()" /></td>
							<td></td>
						</tr>
						<tr>
							<td>密码:</td>
							<td><input class="easyui-textbox" type="password"
								data-options="required:true,validType:'length[6,15]'" value="${cookid.u_password.value}" id="pwd" /></td>
						</tr>
						<tr>
							<td>请输入验证码:</td>
							<td><input class="easyui-textbox" type="text"
								data-options="required:true" id="yanzhengma" /></td>
						</tr>
						<tr>
							<td align="right"><img id="yzm_img"
								style="width: 100px; height: 30px; border-radius: 3px; padding-left: 20%"
								title="点击刷新验证码" src="getVerifiCode" /></td>
							<td><a href="javascript:getVerifiCode()">看不清?</a></td>
						</tr>
						 <tr>
							<td><input type="checkbox" value="yes" name="y">自动登录</td>
			<!-- 				<td align="right" colspan="2"><a href="zhuce.jsp">没有账号?点击立即注册</a></td> -->
						</tr>
						<tr>
							<td><a id="btn" href="javascript:void(0)"
								class="easyui-linkbutton" data-options="iconCls:'icon-ok'"
								onclick="denglu()">登录</a></td>
							<td><a id="btn" href="javascript:void(0)"
								class="easyui-linkbutton" data-options="iconCls:'icon-no'"
								onclick="chongzhi()">重置</a></td>
						</tr>
						<tr>
							<td colspan="2"><a id="btn" href="javascript:void(0)"
								class="easyui-linkbutton" data-options="iconCls:'icon-no'"
								onclick="forget()">忘记密码，点击这里</a></td>
						</tr>
					</table>
				</div>
			</form>
		</div>
	</div>


	<div id="forget-dialog" class="easyui-dialog" title="忘记密码窗口"
		style="width: 400px; height: 300px;"
		data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true,toolbar:[{
				text:'保存',
				iconCls:'icon-edit',
				handler:function(){forgetbaocun();}
			},{
				text:'退出',
				iconCls:'icon-help',
				handler:function(){exitForget();}
			}]">
		<form id="upfrm">
			<table>
				<tr>
					<td><label>登录名:</label></td>
					<td><input class="easyui-textbox" type="text" id="loginName" /></td>
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
<script type="text/javascript">
	function getVerifiCode() {
		$("#yzm_img").prop('src', 'getVerifiCode?a=' + new Date().getTime());

	}
	function chongzhi() {
		$("#subfor").form("reset");
	}
	function denglu() {
		var y = $("[name = 'y']:checked").val();
		alert(y);
		$.post("denglu", {
			u_loginName : $("#username").textbox("getValue"),
			u_password : $("#pwd").textbox("getValue"),
			yanzhengma : $("#yanzhengma").textbox("getValue"),
           y:y
		}, function(res) {
			if (res.success) {

				$.messager.alert("提示", res.msg);

				window.location.href = "Main.jsp";
			} else {
				$.messager.alert("提示", res.msg);

			}

		}, "json");
	}
	function forget() {
		$("#forget-dialog").dialog("open");
	}
	function exitForget() {
		$("#forget-dialog").dialog("closed");
	}
	function sendyanzhengma(){
		$.post("sendyanzhengma",
				{phone:$("#phone").textbox("getValue")},
				function(res){
			if(res=="OK"){
				$.messager.alert("提示","验证码已发送，请注意查收！");
			}else{
				$.messager.alert("提示","验证码发送失败，请重试！");
			}
		},"json");
		
	}

	function forgetbaocun() {
		var loginName = $("#loginName").textbox("getValue");
		var yanzheng = $("#yanzheng").textbox("getValue");
		$.post("forgetMima", {
			u_loginName:loginName,
			yanzheng : yanzheng
		}, function(res) {
			if (res.success) {
				$.messager.alert("提示", res.msg);
				$("#forget-dialog").dialog("closed");
			} else {
				$.messager.alert("提示", res.msg);
			}
		}, "json");
	}
	
	function nihao(){
		$.post("clearCookie",function(res){},"json");
	}
</script>
</html>