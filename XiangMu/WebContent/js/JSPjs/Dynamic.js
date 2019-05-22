function caozuoformatter(value,row,index){
	return "<a href='javascript:void(0)' class='easyui-linkbutton' onclick='xiugai("+index+")'>标记已读</a>";
}
function xiugai(index){
	var data=$("#dynamicdg").datagrid("getData");
	var row=data.rows[index];
	$.post("updateBit",{
		d_id:row.d_id
	},function(res){
		if(res>0){
			$("#dynamicdg").datagrid("reload");
			$.messager.alert("提示","标记已读成功!!!");			
		}else{
			$.messager.alert("提示","标记已读失败!!!");
		}
	},"json");
}