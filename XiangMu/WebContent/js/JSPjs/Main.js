
//树状结构的节点是否已在中部显示，参数re是标题，html 是路径
function navTab(re, html) {
	var flag = $("#tt").tabs('exists', re);
	$('#treeUlId').tree({ //和前边加载数据的代码中的"treeUIId"参数,保持一致即可
		onSelect: function(node) {
			var isLeaf = $('#treeUlId').tree('isLeaf', node.target); //是否是叶子节点
			if(isLeaf) { //只有叶子节点才会在选项卡中创建选项页（每个选项页对应1个功能）
				if(!flag) {
					$('#tt').tabs('add', { //在选项卡中，创建1个选项页
						title: re, //选项卡中，选项页的标题（在同一个选项卡中，选项页需要保持一致）。
						closable: true,
						content: "<iframe src='" + html + "' style='width:99%;height:590px' />" //此处做了调整，推荐使用iframe的方式实现
					});
				} else {
					$("#tt").tabs('select', re); //直接选中title对应的选项卡
				}
			}
		}
	},"text");
}

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
function qd(){
	$.post("empqd",{time:getNowFormatDate()},function(res){
		if(res.success){
			$.messager.alert("提示", res.msg);
		}else{
			$.messager.alert("提示", res.msg);
		}
	},"json");
}

/**
 * 获取系统当前时间
 */
function getNowFormatDate() {
	var mydate = new Date();  
	 var onedate = mydate.toLocaleString('chinese', { hour12: false }); 
      return onedate;
}



