

function tuichu() {
	$.messager.confirm('确认', '您确认想要退出吗？', function(r) {
		if(r) {
			window.location.href = "tuichu";
		}
	});
}
function xgPwd(){
	$("#update-dialog").dialog("open");
}

function exitUpdate(){
	$("#update-dialog").dialog("closed");
}


/**
 * 获取系统当前时间
 */
function getNowFormatDate() {
	var mydate = new Date();  
	 var onedate = mydate.toLocaleString('chinese', { hour12: false }); 
      return onedate;
}



