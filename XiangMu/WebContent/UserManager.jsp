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
	<table id="dg" class="easyui-datagrid">
		<thead>
			<tr>
				<th data-options="field:'u_id'">编号</th>
				<th data-options="field:'u_loginName'">登录名</th>
				<th data-options="field:'u_userName'">用户名</th>
				<th data-options="field:'isLockout',formatter:isLockformatter">是否锁定</th>
				<th data-options="field:'u_lastLoginTime'">最后一次登录时间</th>
				<th data-options="field:'u_createTime'">账户创立时间</th>
				<th data-options="field:'u_password'">密码</th>
				<th data-options="field:'u_email'">邮箱</th>
				<th data-options="field:'u_phoneNumber'">手机号码</th>
				<th data-options="field:'u_qdshijian'">签到时间</th>
				<th data-options="field:'u_qdstatus'">签到状态</th>
				<th data-options="field:'u_weight'">权重</th>
				<th data-options="field:'u_weightbeizhu'">权重备注</th>
				<th data-options="field:'caozuo',formatter:caozuoformatter,align:'ceter',title:'操作'"></th>
				<th data-options="field:'chongzhi',formatter:zhongzhiformatter">重置密码</th>
				<th data-options="field:'suoding',formatter:suodingformatter">锁定用户</th>
				<th data-options="field:'jiesuo',formatter:jiesuoformatter">解锁用户</th>
				<th data-options="field:'shezhi',formatter:shezhiformatter">设置角色</th>
			</tr>
		</thead>
	</table>
	<div id="bar">
		<form id="str">
			<label>用户名:</label> <input class="easyui-textbox" type="text"
				id="uname" /> <label>用户创建时间:</label> <input
				class="easyui-datetimebox" type="text" id="stime" /> ~ <input
				class="easyui-datetimebox" type="text" id="etime" /> <label>用户最后登录时间:</label>
			<input class="easyui-datetimebox" type="text" id="lastTime" /> <label>排序规则:</label>
			<select id="paixu" class="easyui-combobox" 
				style="width: 200px;">
				<option value="aa">--请选择--</option>
				<option value="0">用户最后登录时间</option>
				<option value="1">用户创建时间</option>
			</select> <a href="javascript:void(0)" class="easyui-linkbutton"
				onclick="init()" data-options="iconCls:'icon-search',plain:true">查询</a>
			<a href="javascript:void(0)" class="easyui-linkbutton"
				onclick="xinzeng()" data-options="iconCls:'icon-add',plain:true">新增</a>
		</form>
	</div>
	
	
	
	<!-- 新增信息的dialog -->
	<div id="insert-dialog" class="easyui-dialog" title="新增窗口" style="width:400px;height:300px;"   
        data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true,toolbar:[{
				text:'保存',
				iconCls:'icon-edit',
				handler:function(){insertbaocun();}
			},{
				text:'退出',
				iconCls:'icon-help',
				handler:function(){exitInsert();}
			}]">
    <table>
    <tr>
    <td><label>登录名:</label></td>
    <td><input class="easyui-textbox" type="text" id="lname" /> </td>
    </tr>
    <tr>
    <td><label>密码:</label></td>
    <td><input class="easyui-textbox" type="password" id="pwd" /> </td>
    </tr>
    <tr>
    <td><label>邮箱:</label></td>
    <td><input class="easyui-validatebox" data-options="required:true,validType:'email'" id="email" /></td>
    </tr>
    <tr>
    <td><label>手机号:</label></td>
    <td><input class="easyui-textbox" type="text" id="phone" /></td>
    </tr>
    </table>   
</div> 
	
	
	<!-- 编辑窗口 -->
	<div id="update-dialog" class="easyui-dialog" title="修改窗口" style="width:400px;height:300px;"   
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
    <tr style="display: none">  
    <td> <input class="easyui-textbox" type="text" id="u_id" name="u_id" > </td>
    </tr>
    <tr>
    <td><label>登录名:</label></td>
    <td><input class="easyui-textbox" type="text" id="loname"  name="u_loginName" disabled="disabled"  /> </td>
    </tr>    
    <tr>
    <td><label>邮箱:</label></td>
    <td><input class="easyui-validatebox" data-options="required:true,validType:'email'" id="uemail"  name="u_email"/></td>
    </tr>
    <tr>
    <td><label>手机号:</label></td>
    <td><input class="easyui-textbox" type="text" id="uphone" name="u_phoneNumber" /></td>
    </tr>
    </table>   
    </form>
     </div> 
     
     
     
     <!-- 用戶的角色設置 -->
     <div id="jueseWindow" class="easyui-window" data-options="modal:true,closed:true,iconCls:'icon-save'" style="width:500px;height:500px;padding:10px;">
			<table>
				<tr>
					<td width="200px">
						<table id="yhRoles" title="系统所有角色" class="easyui-datagrid" data-options="rownumbers:true,singleSelect:true,method:'post'">
							<thead>
								<tr>
									<th data-options="field:'r_id',width:280,hidden:true">角色ID</th>
									<th data-options="field:'r_name',width:100">角色名</th>
								</tr>
							</thead>
						</table>
					</td>
					<td width="100px">
						<input type="button" value="-->" onclick="addRoles()" /></br>
						<input type="button" value="<--" onclick="delRoles()" />
					</td>
					<td width="200px" valign="top">
						<table id="myRoles" title="当前用户所有角色" class="easyui-datagrid" data-options="rownumbers:true,singleSelect:true,method:'post'">
							<thead>
								<tr>
									<th data-options="field:'r_id',width:280,hidden:true">角色ID</th>
									<th data-options="field:'r_name',width:100">名称</th>
								</tr>
							</thead>
						</table>
					</td>
				</tr>
			</table>
		</div>
</body>
<script type="text/javascript">
	$(function() {
		init();
	})
	function init() {
		var s = $("#paixu").combobox("getValue");
		if (s == "aa") {
			s = null;
		}

		$("#dg").datagrid({
			url : "selectUser",
			method : "post",
			pagination : true,
			toolbar : "#bar",
			singleSelect:true,
			queryParams : {
				u_userName : $("#uname").textbox("getValue"),
				stime : $("#stime").textbox("getValue"),
				etime : $("#etime").textbox("getValue"),
				u_lastLoginTime : $("#lastTime").textbox("getValue"),
				paixu : s
			}
		});
		$("#str").form("clear");
	}
	/* formatter格式化显示是否被锁定 */
	function isLockformatter(value, row, index) {
		return row.u_isLockout == 0 ? "否" : "是";
	}
	/* 打开新增的dialog窗口 */
	function xinzeng(){
		$("#insert-dialog").dialog("open");
	}
	/* 新增的保存按钮，需要先去后台查询登录名是否重复，如果重复则不能使用，否则进行下一步 */
	function insertbaocun(){
		var lname=$("#lname").val();
		var pwd=$("#pwd").textbox("getValue");
		var email=$("#email").val();
		var phone=$("#phone").textbox("getValue");
		if(lname==null){
			$.messager.alert('提示','登录名不能为空');
		}else{
		$.post("selectCountByLname",{
			u_loginName:lname
		},function(res){
			if(res>0){
				$.messager.alert('提示','登录名已被占用，请更换！！！');    
			}else{
				$.post("insertUser",{
					u_loginName:lname,
					u_password:pwd,
					u_email:email,
					u_phoneNumber:phone,
					u_createTime:getNowFormatDate()
				},function(res){
					if(res>0){
						$("#dg").datagrid("reload");
						$.messager.alert('提示','新增成功'); 
						$("#insert-dialog").dialog("close");
					}else{
						$.messager.alert('提示','新增失败'); 
					}
				},"json");
			}
		},"json");
		}
	}
	/* 关闭新增dialog窗口 */
	function exitInsert(){
		$("#insert-dialog").dialog("close");
	}
	/* 获取系统当前时间 */
	function getNowFormatDate() {
		var mydate = new Date();  
		 var onedate = mydate.toLocaleString('chinese', { hour12: false }); 
          return onedate;
    }
	/* 格式化操作列 */
	function caozuoformatter(value,row,index){
		return " <a href='javascript:void(0)' class='easyui-linkbutton' onclick='shanchu("+index+")'>删除</a>     <a href='javascript:void(0)' class='easyui-linkbutton' onclick='xiugai("+index+")'>编辑</a>  ";
	}
	function shanchu(index){
		var data=$("#dg").datagrid("getData");
		var row=data.rows[index];
		$.messager.confirm('确认','您确认想要删除记录吗？',function(r){    
		    if (r){    
		    	$.post("deleteUser",{u_id:row.u_id},function(res){
					if(res>0){
						$("#dg").datagrid("reload");
						$.messager.alert('提示','删除成功'); 
					}else{
						$.messager.alert('提示','删除失败'); 
					}
				},"json");
		    }    
		}); 	
	}
	function xiugai(index){
		var data=$("#dg").datagrid("getData");
		var row=data.rows[index];
		$("#upfrm").form("load",row);
		$("#update-dialog").dialog("open");		
	}
	function updatebaocun(){
		var email=$("#uemail").val();
		var phone=$("#uphone").textbox("getValue");
		var u_id=$("#u_id").textbox("getValue");
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
		},"json");
	}
	function exitUpdate(){
		$("#update-dialog").dialog("close");
	}
	
	function zhongzhiformatter(value,row,index){
		return " <a href='javascript:void(0)' class='easyui-linkbutton' onclick='chongzhimm("+index+")'>重置密码</a> ";
	}
	function chongzhimm(index){
		var data=$("#dg").datagrid("getData");
		var row=data.rows[index];
		$.post("chongzhimima",{u_id:row.u_id},function(res){
			if(res>0){
				$("#dg").datagrid("reload");
				$.messager.alert('提示','重置密码成功'); 
			}else{
				$.messager.alert('提示','重置密码失败'); 
			}
		},"json");
	}
	function suodingformatter(value,row,index){
		return " <a href='javascript:void(0)' class='easyui-linkbutton' onclick='suoding("+index+")'>锁定用户</a> ";
	}
	function jiesuoformatter(value,row,index){
		return " <a href='javascript:void(0)' class='easyui-linkbutton' onclick='jiesuo("+index+")'>解锁用户</a> ";
	}
	function suoding(index){
		var data=$("#dg").datagrid("getData");
		var row=data.rows[index];
		$.post("suoding",{u_id:row.u_id},function(res){
			if(res>0){
				$("#dg").datagrid("reload");
				$.messager.alert('提示','锁定成功'); 
			}else{
				$.messager.alert('提示','锁定失败'); 
			}
		},"json");
	}
	function jiesuo(index){
		var data=$("#dg").datagrid("getData");
		var row=data.rows[index];
		$.post("jiesuo",{u_id:row.u_id},function(res){
			if(res>0){
				$("#dg").datagrid("reload");
				$.messager.alert('提示','解锁成功'); 
			}else{
				$.messager.alert('提示','解锁失败'); 
			}
		},"json");
	}
	
	function shezhiformatter(value,row,index){
		return " <a href='javascript:void(0)' class='easyui-linkbutton' onclick='shezhi("+index+")'>设置</a> ";
	}
	
	function shezhi(index){
		var data = $("#dg").datagrid("getData");
		var row = data.rows[index];
		/* $("#jueseWindow").window({
			title: "您正在设置" + row.LoginName + "的角色！！！！"
		}); */
		$("#jueseWindow").window("open");
		$("#yhRoles").datagrid({
			url: 'selectRole',
			method:"post"
		});
		 $("#myRoles").datagrid({
			url: 'selectMyRole',
			method:"post",
			queryParams: {
				u_id: row.u_id
			}
		}); 
	}
	
	function addRoles() {   /*此事件为给用户添加角色*/
		var u_id = $("#dg").datagrid("getSelected").u_id;
		var role = $("#yhRoles").datagrid("getSelected");
		if(role) {
			$.post("insertRole", {
				u_id: u_id,
				r_id: role.r_id
			}, function(res) {
				if(res>0) {
					$("#myRoles").datagrid("reload");
				} else {
					alert("对不起，新增失败，请重试！！！");
				}
			},"json");
		} else {
			$.messager.alert("请选择角色名！！！！");
		}
	}
	
	function delRoles(){  /*此事件为删除用户已有的角色*/
		var u_id = $("#dg").datagrid("getSelected").u_id;
		var role = $("#myRoles").datagrid("getSelected");
		if(role) {
			$.post("deleteRole", {
				u_id: u_id,
				r_id: role.r_id
			}, function(res) {
				if(res>0) {
					$("#myRoles").datagrid("reload");
				} else {
					alert("对不起，删除失败，请重试！！！");
				}
			},"json");
		} else {
			$.messager.alert("请选择角色名！！！！");
		}
	}
</script>
</html>