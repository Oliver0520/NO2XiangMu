$(function(){
	init();
	$.post("selectIsORNot",function(res){
		if(res==1){
			$("#kaiguan").switchbutton("uncheck");
		}
		if(res==2){
			$("#kaiguan").switchbutton("check");
		}
	},"json");
});
function init(){
	var s = $("#sex").combobox("getValue");
	if (s == "aa") {
		s = null;
	}
	$("#dg").datagrid({
		url:"selectFenpei",
		method:"post",
		pagination : true,
		toolbar : "#bar",
		singleSelect:true,
		queryParams : {
			s_sname : $("#name").textbox("getValue"),
			s_age : $("#age").textbox("getValue"),
			s_sex : s
		}
	});
}

function xzixunformatter(value,row,index){
	return "<a href='javascript:void(0)' class='easyui-linkbutton' onclick='xiugai("+index+")'>����</a>";
}

function xiugai(index){
	$("#zixunshi").combobox({
		url:'selectZXS',    
	    valueField:'u_id',
	    textField:'u_userName' 
	});
	var data = $("#dg").datagrid("getData");
	var row = data.rows[index];
	$("#xgfrm").form("load",row);
	$("#update-dialog").dialog("open");
}
function updatebaocun(){
	var s = $("#zixunshi").combobox("getValue");
	var s_id=$("#s_id").textbox("getValue");
	$.post("fenpeizx",{
		s_id:s_id,
		u_id:s
	},function(res){
		if(res>0){
			$.messager.alert("提示","分配成功");
			$("#update-dialog").dialog("close");
			$("#dg").datagrid("reload");
		}else{
			$.messager.alert("提示","分配失败");
		}
	},"json");
}
function exitUpdate(){
	$("#update-dialog").dialog("close");
}
function zidong(){
	var zhi=$("#kaiguan")[0].checked;
	var fenpei=null;
	if(zhi){
		fenpei=2;
	}else{
		fenpei=1;
	}
	$.post("updateIsFenpei",{
		fenpei:fenpei},function(res){
			if(res.success){
				$.messager.alert('提示',res.msg); 
			}else{
				$.messager.alert('提示',res.msg); 
			}
		},"json");
}