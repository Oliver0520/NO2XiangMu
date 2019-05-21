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
				<td><input class="easyui-textbox" type="text" id="u_isLockout" name="u_isLockout"
					value="${usera.u_isLockout}" disabled="disabled" /></td>
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
					value="${usera.u_phoneNumber}" /></td>
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