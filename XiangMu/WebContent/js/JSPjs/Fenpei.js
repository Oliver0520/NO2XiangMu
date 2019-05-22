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
	var xb=$("#sex").combobox("getValue");
	if(xb=="aa"){
		xb=null;
	}
	if(xb=="男"){
		
		xb=1;
	}
	if(xb=="女"){
		
		xb=2;
	}

	$("#dg").datagrid({
		url:"selectFenpei",
		method:"post",
		pagination : true,
		toolbar : "#bar",
		singleSelect:true,
		queryParams : {
			s_name : $("#name").textbox("getValue"),
			s_age : $("#age").textbox("getValue"),
			s_sex :xb
		}
	});
	$("#str").form("clear");	
	
}
function xingbie(value, row, index) {
	return row.s_sex == 1 ? "男" : "女";
}

function xzixunformatter(value,row,index){
	return "<a href='javascript:void(0)' class='easyui-linkbutton' onclick='xiugai("+index+")'>分配</a>";
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
