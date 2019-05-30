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
	
	function xiugai(index){
		var data=$("#dg").datagrid("getData");
		var row=data.rows[index];
		$("#upfrm").form("load",row);
		$("#update-dialog").dialog("open");		
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
			$.messager.alert("提示！！！！！！","请选择角色名！！！！");
		}
	}
	
