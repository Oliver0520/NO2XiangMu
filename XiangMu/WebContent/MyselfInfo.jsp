<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="com.xz.entity.User" %>	
<%  User ab=(User)request.getSession().getAttribute("usera");%>
	
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
	src="js/JSPjs/MyselfInfo.js"></script>
	<script type="text/javascript">
	$(function(){
		init();
		
	});
	function init(){
		var a = ${sessionScope.usera.u_qdstatus};
		var w =  ${sessionScope.usera.u_isLockout};
		if(a==1){
			$("#u_qdstatus").textbox("setValue","已签到");
		}
		if(a==2){
			$("#u_qdstatus").textbox("setValue","未签到");
		}
		if(a==3){
			$("#u_qdstatus").textbox("setValue","迟到");
		}
		if(a==4){
			$("#u_qdstatus").textbox("setValue","已签退");
		}
		if(w==0){
			$("#u_isLockout").textbox("setValue","否");	
		}
		if(w==1){
			$("#u_isLockout").textbox("setValue","否");	
		}
		}
		
	function chongzhi(){
		$("#upfrm").form("reset");
		
	}
	$.extend($.fn.validatebox.defaults.rules, {
		phoneRex : {
			validator : function(value) {
				var rex = /^1[3-8]+\d{9}$/;
				//var rex=/^(([0\+]\d{2,3}-)?(0\d{2,3})-)(\d{7,8})(-(\d{3,}))?$/;
				//区号：前面一个0，后面跟2-3位数字 ： 0\d{2,3}
				//电话号码：7-8位数字： \d{7,8
				//分机号：一般都是3位数字： \d{3,}
				//这样连接起来就是验证电话的正则表达式了：/^((0\d{2,3})-)(\d{7,8})(-(\d{3,}))?$/        
				var rex2 = /^((0\d{2,3})-)(\d{7,8})(-(\d{3,}))?$/;
				if (rex.test(value) || rex2.test(value)) {
					// alert('t'+value);
					return true;
				} else {
					//alert('false '+value);
					return false;
				}

			},
			message : '请输入正确电话或手机格式'
		}
	});
	function updateMy(){
		var email=$("#uemail").val();
		var phone=$("#uphone").val();
		var u_id=$("#u_id").textbox("getValue");
		 var fromup = $("#upfrm").form("validate"); 
		if(fromup){
		$.post("updateUser",{
			u_email:email,
			u_phoneNumber:phone,
			u_id:u_id
		},function(res){
			if(res>0){
				$("#dg").datagrid("reload");
				$.messager.alert('提示','编辑成功'); 
				$("#update-dialog").dialog("close");
			}else{
				$.messager.alert('提示','编辑失败'); 
			}
		},"json");}
		else {
			$.messager.alert("提示", "格式不正确");
		}
	}
	</script>
</head>
<body>
<div style="margin-left:500px;">
	<form id="upfrm">
		<table>
			<tr>
			<td><label>编号:</label></td>
				<td><input class="easyui-textbox" type="text" id="u_id"
				  value="${usera.u_id}" disabled="disabled" ></td>
			</tr>
			<%-- <tr>
				<td><label>登录名:</label></td>
				<td><input class="easyui-textbox" type="text" id="loname"
					 value="${ulname}" disabled="disabled" /></td>
			</tr> --%>
			<tr>
				<td><label>用户名:</label></td>
				<td><input class="easyui-textbox" type="text" id="userName"
					value="${usera.u_userName}" disabled="disabled" /></td>
			</tr>
			<tr>
				<td><label>是否锁定:</label></td>
				<td><input class="easyui-textbox" type="text" id="u_isLockout"
					disabled="disabled" /></td>
			</tr>
			<tr>
				<td><label>最后一次登录时间:</label></td>
				<td><input class="easyui-textbox" type="text" id="u_lastLoginTime"
					value="${usera.u_lastLoginTime}"  disabled="disabled" /></td>
			</tr>
			<tr>
				<td><label>账户创立时间:</label></td>
				<td><input class="easyui-textbox" type="text" id="u_createTime"
					value="${usera.u_createTime}"  disabled="disabled" /></td>
			</tr>
			<tr>
				<td><label>邮箱:</label></td>
				<td><input class="easyui-validatebox"
					data-options="required:true,validType:'email'" id="uemail"
					value="${usera.u_email}" /></td>
			</tr>
			<tr>
				<td><label>手机号:</label></td>
				<td><input class="easyui-textbox" type="text" id="uphone"
					data-options="required:true,validType:'phoneRex'" value="${usera.u_phoneNumber}" /></td>
			</tr>
			<tr>
				<td><label>签到时间:</label></td>
				<td><input class="easyui-textbox" type="text" id="u_qdshijian"
					value="${usera.u_qdshijian}" disabled="disabled" /></td>
			</tr>
			<tr>
				<td><label>签到状态:</label></td>
				<td><input class="easyui-textbox" type="text" id="u_qdstatus"
					disabled="disabled" /></td>
			</tr>
			<tr>
				<td><label>权重:</label></td>
				<td><input class="easyui-textbox" type="text" id="u_weight"
					value="${usera.u_weight}" disabled="disabled" /></td>
			</tr>
			<tr>
				<td><label>权重备注:</label></td>
				<td><input class="easyui-textbox" type="text" id="u_weightbeizhu"
					 value="${usera.u_weightbeizhu}" disabled="disabled" /></td>
			</tr>
			<tr>
			   <td><a id="btn" href="javascript:void(0)"
								class="easyui-linkbutton" data-options="iconCls:'icon-ok'"
								onclick="updateMy()">修改</a></td>
			   <td><a id="btn" href="javascript:void(0)"
								class="easyui-linkbutton" data-options="iconCls:'icon-no'"
								onclick="chongzhi()">重置</a></td>
			</tr>
		</table>
	</form>
</div>

</body>
</html>