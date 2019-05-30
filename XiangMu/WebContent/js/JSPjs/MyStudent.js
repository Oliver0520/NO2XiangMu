$(function() {
	$('#zxname').combobox({
		url : 'selectUname',
		method : "post",
		valueField : 'u_id',
		textField : 'u_userName'

	});
	inint();
	$('#zxid').next().hide();
	$('#zxglid').next().hide();
	$('#zxgljsid').next().hide();
});
function inint() {

	var hf = $("#sfhuifang").combobox("getValue");
	var yx = $("#sfyouxiao").combobox("getValue");
	var jf = $("#sfjiaofei").combobox("getValue");
	if (hf == "aa") {
		hf = null;
	}
	if (yx == "aa") {
		yx = null;
	}
	if (jf == "aa") {
		jf = null;
	}
	$('#dg').datagrid({
		url : 'chaxunasd',
		method : "post",
		pagination : true,
		toolbar : "#bar",

		checkbox : true,
		queryParams : {
			s_name : $("#Sname").textbox("getValue"),
			s_phone : $("#Sphone").textbox("getValue"),
			s_qq : $("#sqq").textbox("getValue"),
			u_id : $("#zxname").combobox("getValue"),
			stime : $("#stime").textbox("getValue"),
			etime : $("#etime").textbox("getValue"),
			s_huifang : hf,
			s_youxiao : yx,
			s_jiaofei : jf
		}
	});
	$("#str").form("clear");
}

function chaxun() {
	var zxid = $("#zxid").textbox("getValue");
	var zxglid = $("#zxglid").textbox("getValue");
	var zxgljsid = $("#zxgljsid").textbox("getValue");
	var dengluren = $("#zxname").textbox("getValue");
	if (zxgljsid > 0) {
		var hf = $("#sfhuifang").combobox("getValue");
		var yx = $("#sfyouxiao").combobox("getValue");
		var jf = $("#sfjiaofei").combobox("getValue");
		if (hf == "aa") {
			hf = null;
		}
		if (yx == "aa") {
			yx = null;
		}
		if (jf == "aa") {
			jf = null;
		}
		$('#dg').datagrid({
			url : 'chaxunasd',
			method : "post",
			pagination : true,
			toolbar : "#bar",
			singleSelect : true,
			queryParams : {
				s_name : $("#Sname").textbox("getValue"),
				s_phone : $("#Sphone").textbox("getValue"),
				s_qq : $("#sqq").textbox("getValue"),
				u_id : $("#zxname").combobox("getValue"),
				stime : $("#stime").textbox("getValue"),
				etime : $("#etime").textbox("getValue"),
				s_huifang : hf,
				s_youxiao : yx,
				s_jiaofei : jf
			}
		});
		$("#str").form("clear");
	}

	else if (zxglid > 0) {
		var hf = $("#sfhuifang").combobox("getValue");
		var yx = $("#sfyouxiao").combobox("getValue");
		var jf = $("#sfjiaofei").combobox("getValue");
		if (hf == "aa") {
			hf = null;
		}
		if (yx == "aa") {
			yx = null;
		}
		if (jf == "aa") {
			jf = null;
		}
		$('#dg').datagrid({
			url : 'chaxunasd',
			method : "post",
			pagination : true,
			toolbar : "#bar",
			singleSelect : true,
			queryParams : {
				s_name : $("#Sname").textbox("getValue"),
				s_phone : $("#Sphone").textbox("getValue"),
				s_qq : $("#sqq").textbox("getValue"),
				u_id : $("#zxname").combobox("getValue"),
				stime : $("#stime").textbox("getValue"),
				etime : $("#etime").textbox("getValue"),
				s_huifang : hf,
				s_youxiao : yx,
				s_jiaofei : jf
			}
		});
		$("#str").form("clear");
	}

	else {
		if (zxid > 0 && dengluren == "") {
			var hf = $("#sfhuifang").combobox("getValue");
			var yx = $("#sfyouxiao").combobox("getValue");
			var jf = $("#sfjiaofei").combobox("getValue");
			if (hf == "aa") {
				hf = null;
			}
			if (yx == "aa") {
				yx = null;
			}
			if (jf == "aa") {
				jf = null;
			}
			$('#dg').datagrid({
				url : 'chaxunasd',
				method : "post",
				pagination : true,
				toolbar : "#bar",
				singleSelect : true,
				queryParams : {
					s_name : $("#Sname").textbox("getValue"),
					s_phone : $("#Sphone").textbox("getValue"),
					s_qq : $("#sqq").textbox("getValue"),
					u_id : $("#zxname").combobox("getValue"),
					stime : $("#stime").textbox("getValue"),
					etime : $("#etime").textbox("getValue"),
					s_huifang : hf,
					s_youxiao : yx,
					s_jiaofei : jf
				}
			});
			$("#str").form("clear");
		}
		if (zxid > 0 && dengluren != "") {
			alert("您没有权限根据咨询师姓名查询！！！");
			$("#str").form("clear");
			$("#dg").datagrid("reload");
		}
	}
}

	
/*
 * function shanchu(index) { var data = $("#dg").datagrid("getData"); var row =
 * data.rows[index];
 * 
 * $.messager.confirm('确认', '你确认要删除吗?', function(res) { if (res) {
 * $.post("deleteStudent", { s_id : row.s_id }, function(r) { if (r > 0) {
 * $("#dg").datagrid("reload"); $.messager.alert("提示 ", "删除成功"); } else {
 * $.messager.alert("提示 ", "删除失败"); } }, "json"); } }); }
 */

function shanchu(index) {
	var data = $("#dg").datagrid("getData");
	var row = data.rows[index];
	var youxiao = row.s_youxiao;
	if (youxiao ==2) {
		alert("当前学生有效，暂时无法删除！！！");
	} if(youxiao==1||youxiao==null) {
		$.messager.confirm('确认', '你确认要删除吗?', function(res) {
			if (res) {
				$.post("deleteStudent", {
					s_id : row.s_id
				}, function(r) {
					if (r > 0) {
						$("#dg").datagrid("reload");
						$.messager.alert("提示 ", "删除成功");
					} else {
						$.messager.alert("提示 ", "删除失败");
					}
				}, "json");
			}
		});
	}
}

function chakan(index) {
	var data = $("#dg").datagrid("getData");
	var row = data.rows[index];
	$("#chakanfrm").form("load", row);
	$("#abaobei").textbox("setValue", row.s_baobei == 2 ? "是" : "否");
	$("#ahuifang").textbox("setValue", row.s_huifang == 2 ? "是" : "否");
	$("#ayouxiao").textbox("setValue", row.s_youxiao == 2 ? "是" : "否");
	$("#ashangmen").textbox("setValue", row.s_shangmen == 2 ? "是" : "否");
	$("#ajiaofei").textbox("setValue", row.s_jiaofei == 2 ? "是" : "否");
	$("#atuifei").textbox("setValue", row.s_tuifei == 2 ? "是" : "否");
	$("#ajinban").textbox("setValue", row.s_jinban == 2 ? "是" : "否");
	$("#s_sex").textbox("setValue", row.s_sex == 1 ? "男" : "女");
	$("#chakan-dialog").dialog("open");
}





function baobei(value, row, index) {
	return row.s_huifang == 2 ? "是" : "否";
}
function huifang(value, row, index) {
	return row.s_huifang == 2 ? "是" : "否";
}
function youxiao(value, row, index) {
	return row.s_youxiao == 2 ? "是" : "否";
}
function shangmen(value, row, index) {
	return row.s_shangmen == 2 ? "是" : "否";
}
function jiaofei(value, row, index) {
	return row.s_jiaofei == 2 ? "是" : "否";
}
function tuifei(value, row, index) {
	return row.s_tuifei == 2 ? "是" : "否";
}
function jinban(value, row, index) {
	return row.s_jinban == 2 ? "是" : "否";
}
function xingbie(value, row, index) {
	return row.s_sex == 1 ? "男" : "女";
	
}

function exitUpdate() {
	$("#xiugai-dialog").dialog("close");
}

function exitInsert() {
	
	$("#insert-dialog").dialog("close");
}

function exitInsert() {
	$("#insert-dialog").dialog("close");
}
function chakanrizhi(index) {
	var data = $("#dg").datagrid("getData");
	var row = data.rows[index];
	$('#rzname').combobox({
		url : 'showrzname',
		method : "post",
		valueField : 's_id',
		textField : 's_name',
	});
	$("#rizhi-dialog").dialog("open");
	$("#rizhidg").datagrid({
		url : 'chakanrizhia',
		method : "post",
		pagination : true,
		queryParams : {
			s_id : row.s_id,
		}
	});
}


function tuichu() {
	$("#tjrizhi-dialog").dialog("close");
}
function rizhicaozuolei(value, row, index) {
	return "<a href='javascript:void(0)'  onclick='rizhixiangxi(" + index
			+ ")'>查看</a>"
}
function rizhixiangxi(index) {
	var data = $("#rizhidg").datagrid("getData");
	var row = data.rows[index];
	$("#rizhixiangxifrm").form("load", row);
	$("#rizhixiangxidiv").dialog("open");
}
function daochuexcel() {
	var row = $("#dg").datagrid("getSelections");
	if (row != null && row != "") {
		var s_ids = "";
		for (var i = 0; i < row.length; i++) {
			if (i == 0) {
				s_ids = s_ids + row[i].s_id;
			} else {
				s_ids = s_ids + "," + row[i].s_id;
			}
		}
		
		$.messager.confirm('确认', '您确认想要把当前数据导出Excel吗？', function(r) {
			if (r) {
				window.location.href = "daochuexcel?s_ids=" + s_ids;
			}
		});


	} else {
		$.messager.show({
			title : '我的消息',
			msg : '还未选择学生，请选择！',
			timeout : 1000,
			showType : 'slide',
			style : {
				top : document.body.scrollTop
						+ document.documentElement.scrollTop,
			}
		});
	}
}

		
	
	
