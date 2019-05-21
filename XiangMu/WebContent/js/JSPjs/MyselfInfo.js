
	function updateMy(){
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