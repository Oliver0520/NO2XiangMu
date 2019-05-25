function getVerifiCode() {
		$("#yzm_img").prop('src', 'getVerifiCode?a=' + new Date().getTime());

	}
	function chongzhi() {
		$("#subfor").form("reset");
	}
	function denglu() {
		var y = $("[name = 'y']:checked").val();
		
		$.post("denglu", {
			u_loginName : $("#username").val(),
			u_password : $("#pwd").val(),
			yanzhengma : $("#yanzhengma").val(),
           y:y
		}, function(res) {
			if (res.success) {

				$.messager.alert("提示", res.msg);

				window.location.href = "Main.jsp";
			} else {
				$.messager.alert("提示", res.msg);

			}

		}, "json");
	}
	function forget() {
		$("#forget-dialog").dialog("open");
	}
	function exitForget() {
		$("#forget-dialog").dialog("closed");
	}
	function sendyanzhengma(){
		$.post("sendyanzhengma",
				{phone:$("#phone").textbox("getValue")},
				function(res){
			if(res>0){
				$.messager.alert("提示","验证码发送失败，请重试！");
			}else{
				$.messager.alert("提示","验证码已发送，请注意查收！");				
			}
		},"json");
		
	}
	function forgetbaocun() {
		var loginName = $("#loginName").textbox("getValue");
		var yanzheng = $("#yanzheng").textbox("getValue");
		$.post("forgetMima", {
			u_loginName:loginName,
			yanzheng : yanzheng
		}, function(res) {
			if (res.success) {
				$.messager.alert("提示", res.msg);
				$("#forget-dialog").dialog("closed");
			} else {
				$.messager.alert("提示", res.msg);
			}
		}, "json");
	}