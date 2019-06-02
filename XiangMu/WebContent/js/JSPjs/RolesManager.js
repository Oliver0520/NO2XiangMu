
function xinzeng(){
	$("#insert-dialog").dialog("open");
}

function caozuoformatter(value,row,index){
	return " <a href='javascript:void(0)' class='easyui-linkbutton' onclick='shanchu("+index+")'>删除</a>     <a href='javascript:void(0)' class='easyui-linkbutton' onclick='xiugai("+index+")'>编辑</a>  ";
}
function shanchu(index){
	var data=$("#dg").datagrid("getData");
	var row=data.rows[index];
	$.messager.confirm('确认','您确认想要删除记录吗？',function(r){    
	    if (r){    
	    	$.post("deleteRoles",{r_id:row.r_id},function(res){
				if(res.success){
					$("#dg").datagrid("reload");
					$.messager.alert("提示", res.msg);
				}else{
					$.messager.alert("提示", res.msg);
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
	var r_name= $("#rnameu").textbox("getValue");
	var r_id= $("#ridu").textbox("getValue");
	$.post("selectRolesl",{r_name:r_name},function(res){
		if(res>0){
			$.messager.alert('提示','角色名称已被占用，请更换！！！');
		}else{
			$.post("updateRoles",{r_name:r_name,r_id:r_id},function(res){
				if(res>0){
					$("#dg").datagrid("reload");
					$.messager.alert('提示','编辑成功');
					$("#update-dialog").dialog("close");
				}else{
					$.messager.alert('提示','编辑失败');
				}
			});
		}
	},"json");
	
}
function shezhiformatter(value,row,index){
	return "  <a href='javascript:void(0)' class='easyui-linkbutton' onclick='kongzhi("+index+")'>设置</a>  ";
}
function exitUpdate(){
	$("#update-dialog").dialog("close");
}

function kongzhi(index) {
	var data = $("#dg").datagrid("getData");
	var row = data.rows[index];
	$("#tt").tree({
		url: "selectMoInR",
		lines: true,
		queryParams: {
			r_id: row.r_id,
		},
		checkbox : true,
		onContextMenu: function(e, node) {
			$("#tt").tree('select', node.target);
		}
	});
	jiaoseid = null;
	jiaoseid = row.r_id;
	$("#quanxiantree").window("open");
}


