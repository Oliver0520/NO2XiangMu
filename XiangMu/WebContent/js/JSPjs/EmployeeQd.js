function xianshiformatter(value,row,index){
	if(row.u_qdstatus==1){
		return "已签到";
	}
	if(row.u_qdstatus==2){
		return "未签到";
	}
	if(row.u_qdstatus==3){
		return "迟到";
	}
	if(row.u_qdstatus==4){
		return "签退";
	}
}
function caozuoformatter(value,row,index){
	return "<a href='javascript:void(0)' class='easyui-linkbutton' onclick='xiugai("+index+")'>签退</a>  ";
}
function xiugai(index){
	var data=$("#dg").datagrid("getData");
	var row=data.rows[index];
	$.post("qdCaozuo",{u_id:row.u_id},function(res){
		if(res.success){
			$.messager.alert('提示',res.msg); 
			$("#dg").datagrid("reload");
		}else{
			$.messager.alert('提示',res.msg); 
		}
		
	},"json");
	
}
