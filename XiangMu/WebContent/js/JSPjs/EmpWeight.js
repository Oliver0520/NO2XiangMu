$(function() {
		init();
	});
	function init() {
		$("#dg").datagrid({
			url : "selectUweight",
			method : "post",
			pagination : true,
			toolbar : "#bar",
			singleSelect : true,
			queryParams : {
				u_userName : $("#name").textbox("getValue")
			}
		});
		$("#str").form("clear");
	}
	function weightformatter(value, row, index) {
		return "<a href='javascript:void(0)' class='easyui-linkbutton' onclick='xiugai("
				+ index + ")'>调整</a>";
	}
	function xiugai(index) {
		var data = $("#dg").datagrid("getData");
		var row = data.rows[index];
		$("#xgfrm").form("load", row);
		$("#update-dialog").dialog("open");
	}
	function updatebaocun(){
		var u_weight=$("#weight").textbox("getValue");
		var u_weightbeizhu=$("#weightbeizhu").textbox("getValue");
		var u_id=$("#id").textbox("getValue");
		$.post("updateUweight",{
			u_id:u_id,
			u_weight:u_weight,
			u_weightbeizhu:u_weightbeizhu
		},function(res){
			if(res>0){
				$("#dg").datagrid("reload");
				$.messager.alert("提示","调整权重成功!");
				$("#update-dialog").dialog("close");
			}else{
				$.messager.alert("提示","调整权重失败，请重试!");
			}
		},"json");
	}
	function exitUpdate(){
		$("#update-dialog").dialog("close");
	}