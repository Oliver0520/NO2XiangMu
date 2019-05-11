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
					title: 'hello', //标题栏
					width: 400, //宽度
					height: 900, //高度
					closed: false, //是否关闭（隐藏）
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
								data-options="required:true" id="username" onblur="haha()" /></td>
							<td></td>
						</tr>
						<tr>
							<td>密码:</td>
							<td><input class="easyui-textbox" type="password"
								data-options="required:true,validType:'length[6,15]'" id="pwd" /></td>
						</tr>
						<tr>
							<td>请输入验证码:</td>
							<td><input class="easyui-textbox" type="text"
								data-options="required:true" id="yanzhengma" /></td>
						</tr>
						<tr>
							<td align="right" style="padding-left: 20%">
							<img id="yzm_img" style="width: 100px; height: 30px; border-radius: 3px; padding-left: 20%"
								title="点击刷新验证码" src="getVerifiCode" /></td>
							<td style="padding-left: 35%"><a
								href="javascript:getVerifiCode()">看不清?</a></td>
						</tr>
						<!-- <tr>
							<td><input type="checkbox" value="yes" name="y">自动登录</td>
							<td align="right" colspan="2"><a href="zhuce.jsp">没有账号?点击立即注册</a></td>
						</tr> -->
						<tr>
							<td><a id="btn" href="javascript:void(0)"
								class="easyui-linkbutton" data-options="iconCls:'icon-ok'"
								onclick="denglu()">登录</a></td>
							<td><a id="btn" href="javascript:void(0)"
								class="easyui-linkbutton" data-options="iconCls:'icon-no'"
								onclick="chongzhi()">重置</a></td>
						</tr>
					</table>
				</div>
			</form>
		</div>
	</div>
</body>
<script type="text/javascript">
	function getVerifiCode() {
	    $("#yzm_img").prop('src','getVerifiCode?a='+new Date().getTime());
	    
	}	
	function chongzhi() {
		$("#subfor").form("reset");
	}	
	function denglu() {
		
		alert($("#yanzhengma").textbox("getValue"));
		 $.post("denglu",{
			u_loginName :$("#username").textbox("getValue"),
			u_password :$("#pwd").textbox("getValue"),
			yanzhengma:$("#yanzhengma").textbox("getValue")
			
		},function(res){
			if(res.success){
				
				$.messager.alert("提示",res.msg);
				
				 window.location.href="Main.jsp";
			}else{
				$.messager.alert("提示",res.msg);
				
			}
			
		},"json");	 
	}		
	</script>
</html>