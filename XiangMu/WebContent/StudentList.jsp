<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>网络学生</title>

<link rel="stylesheet" type="text/css"
	href="js/jquery-easyui-1.4.3/themes/icon.css">
<link rel="stylesheet" type="text/css"
	href="js/jquery-easyui-1.4.3/themes/default/easyui.css">
<script type="text/javascript"
	src="js/jquery-easyui-1.4.3/jquery.min.js"></script>
<script type="text/javascript"
	src="js/jquery-easyui-1.4.3/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="js/jquery-easyui-1.4.3/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript"
	src="js/test.js"></script>
<script type="text/javascript">
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
	
 
	function caozuolei(value, row, index) {
		var zxid = $("#zxid").textbox("getValue");
		var zxglid = $("#zxglid").textbox("getValue");
		if(zxglid>0){
			return "<a href='javascript:void(0)'  onclick='shanchu("+ index+ ")'>删除</a>  <a href='javascript:void(0)' onclick='chakan("+ index+ ")'>查看</a>  <a href='javascript:void(0)' onclick='xiugai("+ index+ ")'>修改</a> <a href='javascript:void(0)' onclick='chakanrizhi("+ index+ ")'>查看日志</a>  <a href='javascript:void(0)' onclick='insertrizhi("+ index + ")'>添加日志</a>"
		 }
		else{
			if(zxid>0){
				return " <a href='javascript:void(0)' onclick='chakan("+ index+ ")'>查看</a>  <a href='javascript:void(0)' onclick='xiugai("+ index+ ")'>修改</a> <a href='javascript:void(0)' onclick='chakanrizhi("+ index+ ")'>查看日志</a>  <a href='javascript:void(0)' onclick='insertrizhi("+ index + ")'>添加日志</a>"

				}
			} 
		}
	function shanchu(index) {
		var data = $("#dg").datagrid("getData");
		var row = data.rows[index];

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
	function chakan(index) {
		var data = $("#dg").datagrid("getData");
		var row = data.rows[index];
		$("#chakanfrm").form("load", row);
		$("#abaobei").textbox("setValue",row.s_baobei==2?"是":"否");
		$("#ahuifang").textbox("setValue", row.s_huifang == 2?"是":"否");
		$("#ayouxiao").textbox("setValue", row.s_youxiao == 2?"是":"否");
		$("#ashangmen").textbox("setValue", row.s_shangmen == 2?"是":"否");
		$("#ajiaofei").textbox("setValue", row.s_jiaofei == 2?"是":"否");
		$("#atuifei").textbox("setValue", row.s_tuifei == 2?"是":"否");
		$("#ajinban").textbox("setValue", row.s_jinban == 2?"是":"否");
		$("#s_sex").textbox("setValue", row.s_sex == 1 ? "男" : "女");
		$("#chakan-dialog").dialog("open");
	}

	function xiugai(index) {
		var data = $("#dg").datagrid("getData");
		var row = data.rows[index];
		$("#xiugaifrm").form("load", row);
		$("#upbaobei").combobox("setValue", row.s_baobei==2?"是":"否");
		$("#uphuifang").combobox("setValue", row.s_huifang == 2?"是":"否");
		$("#upyouxiao").combobox("setValue", row.s_youxiao == 2?"是":"否");
		$("#upshangmen").combobox("setValue", row.s_shangmen == 2?"是":"否");
		$("#upjiaofei").combobox("setValues", row.s_jiaofei == 2?"是":"否");
		$("#uptuifei").combobox("setValue", row.s_tuifei == 2?"是":"否");
		$("#upjinban").combobox("setValue", row.s_jinban == 2?"是":"否");
		$("#ups_sex").textbox("setValue", row.s_sex == 1 ? "男" : "女");
		$('#zxname1').combobox({
			url : 'selectUname',
			method : "post",
			valueField : 'u_id',
			textField : 'u_userName',
		});
		$('#zxname2').combobox({
			url : 'selectUname',
			method : "post",
			valueField : 'u_id',
			textField : 'u_userName',
		});
		$("#xiugai-dialog").dialog("open");
	}

	function exitUpdate() {
		$("#xiugai-dialog").dialog("close");
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
		return row.s_sex == 2 ? "是" : "否";;
	}
	function updatebaocun() {
		var s_id = $("#ups_id").textbox("getValue");
		var s_name = $("#ups_name").textbox("getValue");
		var s_age = $("#ups_age").textbox("getValue");
		var s_sex = $("#ups_sex").textbox("getValue");
		var s_phone = $("#ups_phone").textbox("getValue");
		var s_education = $("#ups_education").textbox("getValue");
		var s_status = $("#ups_status").textbox("getValue");
		var s_qudao = $("#ups_qudao").textbox("getValue");
		var s_wangzhan = $("#ups_wangzhan").textbox("getValue");
		var s_guanjian = $("#ups_guanjian").textbox("getValue");
		var s_qq = $("#ups_qq").textbox("getValue");
		var s_weChat = $("#ups_weChat").textbox("getValue");
		var baobei = $("#upbaobei").combobox("getValue");
		var s_beizhu = $("#ups_beizhu").textbox("getValue");
		var name = $("#zxname1").combobox("getValue");
		var s_quyu = $("#ups_quyu").textbox("getValue");
		var s_bumen = $("#ups_bumen").textbox("getValue");
		var s_kecheng = $("#ups_kecheng").textbox("getValue");
		var youxiao = $("#upyouxiao").combobox("getValue");
		var s_dafen = $("#ups_dafen").textbox("getValue");
		var huifang = $("#uphuifang").combobox("getValue");
		var s_huifangshijian = $("#ups_huifangshijian").textbox("getValue");
		var shangmen = $("#upshangmen").combobox("getValue");
		var s_shangmenshijian = $("#ups_shangmenshijian").textbox("getValue");
		var s_wuxiaoyuanyin = $("#ups_wuxiaoyuanyin").textbox("getValue");
		var jiaofei = $("#upjiaofei").combobox("getValue");
		var s_jiaofeishijian = $("#ups_jiaofeishijian").textbox("getValue");
		var s_price = $("#ups_price").textbox("getValue");
		var tuifei = $("#uptuifei").combobox("getValue");
		var jinban = $("#upjinban").combobox("getValue");
		var s_jinbanshijian = $("#ups_jinbanshijian").textbox("getValue");
		var s_jinbanbeizhu = $("#ups_jinbanbeizhu").textbox("getValue");
		var s_tuifeiyuanyin = $("#ups_tuifeiyuanyin").textbox("getValue");
		var s_dingjin = $("#ups_dingjin").textbox("getValue");
		var s_dingjinshijian = $("#ups_dingjinshijian").textbox("getValue");
		var s_guanzhu = $("#ups_guanzhu").textbox("getValue");
		var name2 = $("#zxname2").combobox("getValue");
		var s_zixunbeizhu = $("#ups_zixunbeizhu").textbox("getValue");
		if (baobei == "否") {
			baobei = 1
		}
		if (baobei == "是") {
			baobei = 2
		}
	
		if (huifang == "否") {
			huifang = 1
		}
		if (huifang == "是") {
			huifang = 2
		}
		if (youxiao == "否") {
			youxiao = 1
		}
		if (youxiao == "是") {
			youxiao = 2
		}
		if (shangmen == "否") {
			shangmen = 1
		}
		if (shangmen == "是") {
			shangmen = 2
		}
		if (jiaofei == "否") {
			jiaofei = 1
		}
		if (jiaofei == "是") {
			jiaofei = 2
		}
		if (tuifei == "否") {
			tuifei = 1
		}
		if (tuifei == "是") {
			tuifei = 2
		}
		if (jinban == "否") {
			jinban = 1
		}
		if (jinban == "是") {
			jinban = 2
		}
		if (s_sex == "男") {
			s_sex = 1
		}
		if (s_sex == "女") {
			s_sex = 2
		}
		$.post("updaStu", {
			s_id : s_id,
			s_name : s_name,
			s_age : s_age,
			s_sex : s_sex,
			s_phone : s_phone,
			s_education : s_education,
			s_status : s_status,
			s_qudao : s_qudao,
			s_wangzhan : s_wangzhan,
			s_guanjian : s_guanjian,
			s_qq : s_qq,
			s_weChat : s_weChat,
			s_baobei : baobei,
			s_beizhu : s_beizhu,
			u_id : name,
			s_quyu : s_quyu,
			s_bumen : s_bumen,
			s_kecheng : s_kecheng,
			s_youxiao : youxiao,
			s_dafen : s_dafen,
			s_huifang : huifang,
			s_huifangshijian : s_huifangshijian,
			s_shangmen : shangmen,
			s_shangmenshijian : s_shangmenshijian,
			s_wuxiaoyuanyin : s_wuxiaoyuanyin,
			s_jiaofei : jiaofei,
			s_jiaofeishijian : s_jiaofeishijian,
			s_price : s_price,
			s_tuifei : tuifei,
			s_jinban : jinban,
			s_jinbanshijian : s_jinbanshijian,
			s_jinbanbeizhu : s_jinbanbeizhu,
			s_tuifeiyuanyin : s_tuifeiyuanyin,
			s_dingjin : s_dingjin,
			s_dingjinshijian : s_dingjinshijian,
			s_guanzhu : s_guanzhu,
			u_idw : name2,
			s_zixunbeizhu : s_zixunbeizhu
		}, function(res) {
			if (res > 0) {
				$("#dg").datagrid("reload");
				$.messager.alert('提示', '编辑成功');
				$("#xiugai-dialog").dialog("close");
			} else {
				$.messager.alert('提示', '编辑失败');
			}
		}, "json");
		$("#xiugaifrm").form("clear");
	}
	function exitUpdate() {
		$("#xiugai-dialog").dialog("close");
	}
	function insertbaocun() {
		var s_id = $("#tjs_id").textbox("getValue");
		var s_name = $("#tjs_name").textbox("getValue");
		var s_age = $("#tjs_age").textbox("getValue");
		var s_sex = $("#tjs_sex").textbox("getValue");
		var s_phone = $("#tjs_phone").textbox("getValue");
		var s_education = $("#tjs_education").textbox("getValue");
		var s_status = $("#tjs_status").textbox("getValue");
		var s_qudao = $("#tjs_qudao").textbox("getValue");
		var s_wangzhan = $("#tjs_wangzhan").textbox("getValue");
		var s_guanjian = $("#tjs_guanjian").textbox("getValue");
		var s_qq = $("#tjs_qq").textbox("getValue");
		var s_weChat = $("#tjs_weChat").textbox("getValue");
		var baobei = $("#tjbaobei").combobox("getValue");
		var s_beizhu = $("#tjs_beizhu").textbox("getValue");
		if (baobei == "否") {
			baobei = 1
		}
		if (baobei == "是") {
			baobei = 2
		}
		if(s_sex=="男"){
			s_sex=1
			
		}
		if(s_sex=="女"){
			s_sex=2			
		}
		alert(baobei)
		$.post("insertStudent", {
			s_id : s_id,
			s_name : s_name,
			s_age : s_age,
			s_sex : s_sex,
			s_phone : s_phone,
			s_education : s_education,
			s_status : s_status,
			s_qudao : s_qudao,
			s_wangzhan : s_wangzhan,
			s_guanjian : s_guanjian,
			s_qq : s_qq,
			s_weChat : s_weChat,
			s_baobei : baobei,
		}, function(res) {
			if (res > 0) {
				$("#dg").datagrid("reload");
				$.messager.alert('提示', '添加成功');
				$("#insert-dialog").dialog("close");
			} else {
				$.messager.alert('提示', '添加失败');
			}
		}, "json");
		$("#insertfrm").form("clear");		
	}
	function exitInsert() {s
		$("#insert-dialog").dialog("close");
	}
	function insert(index) {
		$("#insert-dialog").dialog("open");
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
		}
		);
	}
	function insertrizhi(index) {
		var data = $("#dg").datagrid("getData");
		var row = data.rows[index];
		$("#s_ida").textbox("setValue", row.s_id);
		$("#u_ida").textbox("setValue", row.u_id);
		$("#tjrizhi-dialog").dialog("open");
	}
	function rizhibaocun() {
		var s_id = $("#s_ida").textbox("getValue");
		var u_id = $("#u_ida").textbox("getValue");
		var l_id = $("#l_id").textbox("getValue");
		var l_genzongstartshijian = $("#l_genzongstartshijian").textbox("getValue");
		var l_genzongendshijian = $("#l_genzongendshijian").textbox("getValue");
		var l_huifang = $("#l_huifang").textbox("getValue");
		var l_fangshi = $("#l_fangshi").textbox("getValue");
		var l_xcshijian = $("#l_xcshijian").textbox("getValue");
		var l_neirong = $("#l_neirong").textbox("getValue");
		$.post("insertRizhi", {
			u_id:u_id,
			s_id : s_id,
			l_id : l_id,
			l_genzongstartshijian : l_genzongstartshijian,
			l_genzongendshijian : l_genzongendshijian,
			l_huifang : l_huifang,
			l_fangshi : l_fangshi,
			l_xcshijian : l_xcshijian,
			l_neirong : l_neirong,
		}, function(res) {
			if (res > 0) {
				$("#dg").datagrid("reload");
				$.messager.alert('提示', '添加成功');
				$("#tjrizhi-dialog").dialog("close");
			} else {
				$.messager.alert('提示', '添加失败');
			}
		}, "json");
		$("#tjrizhifrm").form("clear");
	}
	function tuichu() {
		$("#tjrizhi-dialog").dialog("close");
	}
	function rizhicaozuolei(value,row,index){		
		return "<a href='javascript:void(0)'  onclick='rizhixiangxi("+ index+ ")'>查看</a>"		
	}
	function rizhixiangxi(index){
		var data = $("#rizhidg").datagrid("getData");
		var row = data.rows[index];
		$("#rizhixiangxifrm").form("load", row);
		$("#rizhixiangxidiv").dialog("open");
	}
</script>
</head>
<body>
 <input class="easyui-textbox" type="text" id="zxid" value="<%=session.getAttribute("zx") %>"/>
<input class="easyui-textbox" type="text" id="zxglid" value="<%=session.getAttribute("zxgl") %>"/>
	<table class="easyui-datagrid" id="dg">
		<thead>
			<tr>
				<th data-options="field:'s_name',width:100">姓名</th>
				<th data-options="field:'s_age',width:100">年龄</th>
				<th data-options="field:'s_sex',width:100,formatter:xingbie">性别</th>
				<th data-options="field:'s_phone',width:100">电话</th>
				<th data-options="field:'s_education',width:100">学历</th>
				<th data-options="field:'s_status',width:100">状态</th>
				<th data-options="field:'s_qudao',width:100">来源渠道</th>
				<th data-options="field:'s_wangzhan',width:100">来源网站</th>
				<th data-options="field:'s_guanjian',width:100">来源关键词</th>
				<th data-options="field:'s_qq',width:100">QQ</th>
				<th data-options="field:'s_weChat',width:100">微信</th>
				<th data-options="field:'s_baobei',width:100,formatter:baobei">是否报备</th>
				<th data-options="field:'s_beizhu',width:100">备注</th>
				<th data-options="field:'name',width:100">咨询师</th>	
				<th data-options="field:'s_quyu',width:100">所在区域</th>
				<th data-options="field:'s_bumen',width:100">来源部门</th>
				<th data-options="field:'s_kecheng',width:100">课程方向</th>
				<th data-options="field:'s_youxiao',width:100,formatter:youxiao">是否有效</th>
				<th data-options="field:'s_dafen',width:100">打分</th>
				<th data-options="field:'s_huifang',width:100,formatter:huifang">是否回访</th>
				<th data-options="field:'s_huifangshijian',width:100">首次回访时间</th>
				<th data-options="field:'s_shangmen',width:100,formatter:shangmen">是否上门</th>
				<th data-options="field:'s_shangmenshijian',width:100">上门时间</th>
				<th data-options="field:'s_wuxiaoyuanyin',width:100">无效原因</th>
				<th data-options="field:'jiaofei',width:100,formatter:jiaofei">是否缴费</th>
				<th data-options="field:'s_jiaofeishijian',width:100">缴费时间</th>
				<th data-options="field:'s_price',width:100">金额</th>
				<th data-options="field:'s_tuifei',width:100,formatter:tuifei">是否退费</th>
				<th data-options="field:'s_jinban',width:100,formatter:jinban">是否进班</th>
				<th data-options="field:'s_jinbanshijian',width:100">进班时间</th>
				<th data-options="field:'s_jinbanbeizhu',width:100">进班备注</th>
				<th data-options="field:'s_tuifeiyuanyin',width:100">退费原因</th>
				<th data-options="field:'s_dingjin',width:100">定金金额</th>
				<th data-options="field:'s_dingjinshijian',width:100">定金时间</th>
				<th data-options="field:'s_guanzhu',width:100">学生关注</th>
				<th data-options="field:'name2',width:100">咨询师(面见)</th>
				<th data-options="field:'s_zixunbeizhu',width:100">咨询师备注</th>
				<th data-options="field:'caozuo',title:'操作',formatter:caozuolei"></th>
			</tr>
		</thead>
	</table>
	<div id="rizhi-dialog" class="easyui-dialog" title="查看日志"
		style="width: 800px; height: 400px;"
		data-options="resizable:true,modal:true,closed:true">
		<table id="rizhidg" class="easyui-datagrid">
			<thead>
				<tr>
					<th data-options="field:'rzname',width:100">姓名</th>
					<th data-options="field:'l_genzongstartshijian',width:100">回访开始时间</th>
					<th data-options="field:'l_genzongendshijian',width:100">回访结束时间</th>
					<th data-options="field:'l_xcshijian',width:100">下次回访时间</th>
					<th data-options="field:'l_neirong',width:100">回访内容</th>
					<th data-options="field:'caozuo',title:'操作',formatter:rizhicaozuolei"></th>
				</tr>
			</thead>
		</table>
	</div>

	<div id="bar">
		<form id="str">
			<label>用户名:</label> <input class="easyui-textbox" type="text"
				id=Sname /> <label>QQ:</label> <input class="easyui-textbox"
				type="text" id="sqq" /> <label>咨询师姓名:</label> <select
				class="easyui-combobox" id="zxname" style="width: 100px;">
			</select> <label>手机号:</label> <input class="easyui-textbox" type="text"
				id="Sphone" /> <label>进班时间:</label> <input
				class="easyui-datetimebox" type="text" id="stime" /> ~ <input
				class="easyui-datetimebox" type="text" id="etime" /> <label>是否缴费:</label>
			<select id="sfjiaofei" class="easyui-combobox" style="width: 100px;">
				<option value="aa">--请选择--</option>
				<option value="1">否</option>
				<option value="2">是</option>
			</select> <label>是否有效:</label> <select id="sfyouxiao" class="easyui-combobox"
				style="width: 100px;">
				<option value="aa">--请选择--</option>
				<option value="1">否</option>
				<option value="2">是</option>
			</select> <label>是否回访:</label> <select id="sfhuifang" class="easyui-combobox"
				style="width: 100px;">
				<option value="aa">--请选择--</option>
				<option value="2">是</option>
				<option value="1">否</option>
			</select> <a href="javascript:void(0)" class="easyui-linkbutton"
				onclick="inint()" data-options="iconCls:'icon-search',plain:true">查询</a>
			<a href="javascript:void(0)" class="easyui-linkbutton"
				onclick="insert()" data-options="iconCls:'icon-add',plain:true">新增</a>
		</form>
	</div>

	<div id="chakan-dialog" class="easyui-dialog" title="查看"
		style="width: 600px; height: 520px;"
		data-options="resizable:true,modal:true,closed:true">
		<form id="chakanfrm">
			<div style="float: left">
				<table>
					<tr>
						<td><label>学生部分:</label></td>
					</tr>
					<tr style="display: none">
						<td><input class="easyui-textbox" type="text" id="s_id"
							name="s_id"></td>
					</tr>
					<tr>
						<td><label>姓名:</label></td>
						<td><input class="easyui-textbox" type="text" id="s_name"
							name="s_name" disabled="disabled" /></td>
					</tr>
					<tr>
						<td><label>年龄:</label></td>
						<td><input class="easyui-textbox" type="text" id="s_age"
							name="s_age" disabled="disabled" /></td>
					</tr>
					<tr>
						<td><label>性别:</label></td>
						<td><input class="easyui-textbox" type="text" id="s_sex"
							name="s_sex" disabled="disabled" /></td>
					</tr>
					<tr>
						<td><label>电话:</label></td>
						<td><input class="easyui-textbox" type="text" id="s_phone"
							name="s_phone" disabled="disabled" /></td>
					</tr>
					<tr>
						<td><label>学历:</label></td>
						<td><input class="easyui-textbox" type="text"
							id="s_education" name="s_education" disabled="disabled" /></td>
					</tr>
					<tr>
						<td><label>状态:</label></td>
						<td><input class="easyui-textbox" type="text" id="s_status"
							name="s_status" disabled="disabled" /></td>
					</tr>
					<tr>
						<td><label>来源渠道:</label></td>
						<td><input class="easyui-textbox" type="text" id="s_qudao"
							name="s_qudao" disabled="disabled" /></td>
					</tr>
					<tr>
						<td><label>来源网站:</label></td>
						<td><input class="easyui-textbox" type="text" id="s_wangzhan"
							name="s_wangzhan" disabled="disabled" /></td>
					</tr>
					<tr>
						<td><label>来源关键词:</label></td>
						<td><input class="easyui-textbox" type="text" id="s_guanjian"
							name="s_guanjian" disabled="disabled" /></td>
					</tr>
					<tr>
						<td><label>QQ:</label></td>
						<td><input class="easyui-textbox" type="text" id="s_qq"
							name="s_qq" disabled="disabled" /></td>
					</tr>
					<tr>
						<td><label>微信:</label></td>
						<td><input class="easyui-textbox" type="text" id="s_weChat"
							name="s_weChat" disabled="disabled" /></td>
					</tr>
					<tr>
						<td><label>是否报备:</label></td>
						<td><input class="easyui-textbox" type="text" id="abaobei"
							disabled="disabled" /></td>
					</tr>
					<tr>
						<td><label>备注:</label></td>
						<td><input class="easyui-textbox" type="text" id="s_beizhu"
							name="s_beizhu" disabled="disabled" /></td>
					</tr>

				</table>
			</div>
			<div style="float: right">
				<table>
					<tr>
						<td><label>咨询师部分:</label></td>

					</tr>
					<tr>
						<td><label>咨询姓名:</label></td>
						<td><input class="easyui-textbox" type="text" id="name"
							name="name" disabled="disabled" /></td>
					</tr>
					<tr>
						<td><label>所在区域:</label></td>
						<td><input class="easyui-textbox" type="text" id="s_quyu"
							name="s_quyu" disabled="disabled" /></td>
					</tr>
					<tr>
						<td><label>来源部门:</label></td>
						<td><input class="easyui-textbox" type="text" id="s_bumen"
							name="s_bumen" disabled="disabled" /></td>
					</tr>
					<tr>
						<td><label>课程方向:</label></td>
						<td><input class="easyui-textbox" type="text" id="s_kecheng"
							name="s_kecheng" disabled="disabled" /></td>
					</tr>
					<tr>
						<td><label>是否有效:</label></td>
						<td><input class="easyui-textbox" type="text" id="ayouxiao"
							disabled="disabled" /></td>
					</tr>
					<tr>
						<td><label>打分:</label></td>
						<td><input class="easyui-textbox" type="text" id="s_dafen"
							name="s_dafen" disabled="disabled" /></td>
					</tr>
					<tr>
						<td><label>是否回访:</label></td>
						<td><input class="easyui-textbox" type="text" id="ahuifang"
							disabled="disabled" /></td>
					</tr>
					<tr>
						<td><label>首次回访时间:</label></td>
						<td><input class="easyui-textbox" type="text"
							id="s_huifangshijian" name="s_huifangshijian" disabled="disabled" /></td>
					</tr>
					<tr>
						<td><label>是否上门:</label></td>
						<td><input class="easyui-textbox" type="text" id="ashangmen"
							disabled="disabled" /></td>
					</tr>
					<tr>
						<td><label>上门时间:</label></td>
						<td><input class="easyui-textbox" type="text"
							id="s_shangmenshijian" name="s_shangmenshijian"
							disabled="disabled" /></td>
					</tr>
					<tr>
						<td><label>无效原因:</label></td>
						<td><input class="easyui-textbox" type="text"
							id="s_wuxiaoyuanyin" name="s_wuxiaoyuanyin" disabled="disabled" /></td>
					</tr>
					<tr>
						<td><label>是否缴费:</label></td>
						<td><input class="easyui-textbox" type="text" id="ajiaofei"
							disabled="disabled" /></td>
					</tr>
					<tr>
						<td><label>缴费时间:</label></td>
						<td><input class="easyui-textbox" type="text"
							id="s_jiaofeishijian" name="s_jiaofeishijian" disabled="disabled" /></td>
					</tr>
					<tr>
						<td><label>金额:</label></td>
						<td><input class="easyui-textbox" type="text" id="s_price"
							name="s_price" disabled="disabled" /></td>
					</tr>
					<tr>
						<td><label>是否退费:</label></td>
						<td><input class="easyui-textbox" type="text" id="atuifei"
							disabled="disabled" /></td>
					</tr>
					<tr>
						<td><label>是否进班:</label></td>
						<td><input class="easyui-textbox" type="text" id="ajinban"
							disabled="disabled" /></td>
					</tr>
					<tr>
						<td><label>进班时间:</label></td>
						<td><input class="easyui-textbox" type="text"
							id="s_jinbanshijian" name="s_jinbanshijian" disabled="disabled" /></td>
					</tr>
					<tr>
						<td><label>进班备注:</label></td>
						<td><input class="easyui-textbox" type="text"
							id="s_jinbanbeizhu" name="s_jinbanbeizhu" disabled="disabled" /></td>
					</tr>
					<tr>
						<td><label>退费原因:</label></td>
						<td><input class="easyui-textbox" type="text"
							id="s_tuifeiyuanyin" name="s_tuifeiyuanyin" disabled="disabled" /></td>
					</tr>
					<tr>
						<td><label>定金金额:</label></td>
						<td><input class="easyui-textbox" type="text" id="s_dingjin"
							name="s_dingjin" disabled="disabled" /></td>
					</tr>
					<tr>
						<td><label>定金时间:</label></td>
						<td><input class="easyui-textbox" type="text"
							id="s_dingjinshijian" name="s_dingjinshijian" disabled="disabled" /></td>
					</tr>
					<tr>
						<td><label>学生关注:</label></td>
						<td><input class="easyui-textbox" type="text" id="s_guanzhu"
							name="s_guanzhu" disabled="disabled" /></td>
					</tr>
					<tr>
						<td><label>咨询师(面见):</label></td>
						<td><input class="easyui-textbox" type="text" id="name2"
							name="name2" disabled="disabled" /></td>
					</tr>
					<tr>
						<td><label>咨询师备注:</label></td>
						<td><input class="easyui-textbox" type="text"
							id="s_zixunbeizhu" name="s_zixunbeizhu" disabled="disabled" /></td>
					</tr>


				</table>
			</div>
		</form>
	</div>
	<div id="xiugai-dialog" class="easyui-dialog" title="修改"
		style="width: 600px; height: 400px;"
		data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true,toolbar:[{
				text:'保存',
				iconCls:'icon-edit',
				handler:function(){updatebaocun();}
			},{
				text:'退出',
				iconCls:'icon-cancel',
				handler:function(){exitUpdate();}}]">
		<form id="xiugaifrm">
			<div style="float: left">
				<table>
					<tr>
						<td><label>在线录入:</label></td>

					</tr>
					<tr style="display: none">
						<td><input class="easyui-textbox" type="text" id="ups_id"
							name="s_id"></td>
					</tr>
					<tr>
						<td><label>姓名:</label></td>
						<td><input class="easyui-textbox" type="text" id="ups_name"
							name="s_name" /></td>
					</tr>
					<tr>
						<td><label>年龄:</label></td>
						<td><input class="easyui-textbox" type="text" id="ups_age"
							name="s_age" /></td>
					</tr>
					<tr>
						<td><label>性别:</label></td>
						<td><select id="ups_sex" class="easyui-combobox"
							style="width: 100px;">
								<option value="2">女</option>
								<option value="1">男</option>
						</select></td>
					</tr>

					<tr>
						<td><label>电话:</label></td>
						<td><input class="easyui-textbox" type="text" id="ups_phone"
							name="s_phone" /></td>
					</tr>
					<tr>
						<td><label>学历:</label></td>
						<td><input class="easyui-textbox" type="text"
							id="ups_education" name="s_education" /></td>
					</tr>
					<tr>
						<td><label>状态:</label></td>
						<td><input class="easyui-textbox" type="text" id="ups_status"
							name="s_status" /></td>
					</tr>
					<tr>
						<td><label>来源渠道:</label></td>
						<td><input class="easyui-textbox" type="text" id="ups_qudao"
							name="s_qudao" /></td>
					</tr>
					<tr>
						<td><label>来源网站:</label></td>
						<td><input class="easyui-textbox" type="text"
							id="ups_wangzhan" name="s_wangzhan" /></td>
					</tr>
					<tr>
						<td><label>来源关键词:</label></td>
						<td><input class="easyui-textbox" type="text"
							id="ups_guanjian" name="s_guanjian" /></td>
					</tr>
					<tr>
						<td><label>QQ:</label></td>
						<td><input class="easyui-textbox" type="text" id="ups_qq"
							name="s_qq" /></td>
					</tr>
					<tr>
						<td><label>微信:</label></td>
						<td><input class="easyui-textbox" type="text" id="ups_weChat"
							name="s_weChat" /></td>
					</tr>
					<tr>
						<td><label>是否报备:</label></td>
						<td><select id="upbaobei" class="easyui-combobox"
							style="width: 100px;">
							<option value="3">待定</option>
								<option value="2">是</option>
								<option value="1">否</option>
						</select></td>
					</tr>
					<tr>
						<td><label>备注:</label></td>
						<td><input class="easyui-textbox" type="text" id="ups_beizhu"
							name="s_beizhu" /></td>
					</tr>
				</table>
			</div>
			<div style="float: right">
				<table>
					<tr>
						<td><label>咨询师录入:</label></td>

					</tr>
					<tr>
						<td><label>咨询姓名:</label></td>
						<td><select class="easyui-combobox" id="zxname1"
							style="width: 100px;">
						</select></td>
					</tr>
					<tr>
						<td><label>所在区域:</label></td>
						<td><input class="easyui-textbox" type="text" id="ups_quyu"
							name="s_quyu" /></td>
					</tr>
					<tr>
						<td><label>来源部门:</label></td>
						<td><input class="easyui-textbox" type="text" id="ups_bumen"
							name="s_bumen" /></td>
					</tr>
					<tr>
						<td><label>课程方向:</label></td>
						<td><input class="easyui-textbox" type="text"
							id="ups_kecheng" name="s_kecheng" /></td>
					</tr>
					<tr>
						<td><label>是否有效:</label></td>
						<td><select id="upyouxiao" class="easyui-combobox"
							style="width: 100px;">
								<option value="2">是</option>
								<option value="1">否</option>
						</select></td>
					</tr>
					<tr>
						<td><label>打分:</label></td>
						<td><input class="easyui-textbox" type="text" id="ups_dafen"
							name="s_dafen" /></td>
					</tr>
					<tr>
						<td><label>是否回访:</label></td>
						<td><select id="uphuifang" class="easyui-combobox"
							style="width: 100px;">
								<option value="2">是</option>
								<option value="1">否</option>
						</select></td>
					</tr>
					<tr>
						<td><label>首次回访时间:</label></td>
						<td><input class="easyui-datetimebox" type="text"
							id="ups_huifangshijian" name="s_huifangshijian" /></td>
					</tr>
					<tr>
						<td><label>是否上门:</label></td>
						<td><select id="upshangmen" class="easyui-combobox"
							style="width: 100px;">
								<option value="2">是</option>
								<option value="1">否</option>
						</select></td>
					</tr>
					<tr>
						<td><label>上门时间:</label></td>
						<td><input class="easyui-datetimebox" type="text"
							id="ups_shangmenshijian" name="s_shangmenshijian" /></td>
					</tr>
					<tr>
						<td><label>无效原因:</label></td>
						<td><input class="easyui-textbox" type="text"
							id="ups_wuxiaoyuanyin" name="s_wuxiaoyuanyin" /></td>
					</tr>
					<tr>
						<td><label>是否缴费:</label></td>
						<td><select id="upjiaofei" class="easyui-combobox"
							style="width: 100px;">
								<option value="2">是</option>
								<option value="1">否</option>
						</select></td>
					</tr>
					<tr>
						<td><label>缴费时间:</label></td>
						<td><input class="easyui-datetimebox" type="text"
							id="ups_jiaofeishijian" name="s_jiaofeishijian" /></td>
					</tr>
					<tr>
						<td><label>金额:</label></td>
						<td><input class="easyui-textbox" type="text" id="ups_price"
							name="s_price" /></td>
					</tr>
					<tr>
						<td><label>是否退费:</label></td>
						<td><select id="uptuifei" class="easyui-combobox"
							style="width: 100px;">
								<option value="2">是</option>
								<option value="1">否</option>
						</select></td>
					</tr>
					<tr>
						<td><label>是否进班:</label></td>
						<td><select id="upjinban" class="easyui-combobox"
							style="width: 100px;">
								<option value="2">是</option>
								<option value="1">否</option>
						</select></td>
					</tr>
					<tr>
						<td><label>进班时间:</label></td>
						<td><input class="easyui-datetimebox" type="text"
							id="ups_jinbanshijian" name="s_jinbanshijian" /></td>
					</tr>
					<tr>
						<td><label>进班备注:</label></td>
						<td><input class="easyui-textbox" type="text"
							id="ups_jinbanbeizhu" name="s_jinbanbeizhu" /></td>
					</tr>
					<tr>
						<td><label>退费原因:</label></td>
						<td><input class="easyui-textbox" type="text"
							id="ups_tuifeiyuanyin" name="s_tuifeiyuanyin" /></td>
					</tr>
					<tr>
						<td><label>定金金额:</label></td>
						<td><input class="easyui-textbox" type="text"
							id="ups_dingjin" name="s_dingjin" /></td>
					</tr>
					<tr>
						<td><label>定金时间:</label></td>
						<td><input class="easyui-datetimebox" type="text"
							id="ups_dingjinshijian" name="s_dingjinshijian" /></td>
					</tr>
					<tr>
						<td><label>学生关注:</label></td>
						<td><input class="easyui-textbox" type="text"
							id="ups_guanzhu" name="s_guanzhu" /></td>
					</tr>
					<tr>
						<td><label>咨询师(面见):</label></td>
						<td><select class="easyui-combobox" id="zxname2"
							style="width: 100px;">
						</select></td>
					</tr>
					<tr>
						<td><label>咨询师备注:</label></td>
						<td><input class="easyui-textbox" type="text"
							id="ups_zixunbeizhu" name="s_zixunbeizhu" /></td>
					</tr>
				</table>
			</div>
		</form>
	</div>
	<div id="insert-dialog" class="easyui-dialog" title="添加"
		style="width: 500px; height: 400px;"
		data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true,toolbar:[{
				text:'保存',
				iconCls:'icon-edit',
				handler:function(){insertbaocun();}
			},{
				text:'退出',
				iconCls:'icon-cancel',
				handler:function(){exitInsert();}}]">
		<form id="insertfrm">

			<table>
				<tr style="display: none">
					<td><input class="easyui-textbox" type="text" id="tjs_id"
						name="s_id"></td>
				</tr>
				<tr>
					<td><label>姓名:</label></td>
					<td><input class="easyui-textbox" type="text" id="tjs_name"
						name="s_name" /></td>
				</tr>
				<tr>
					<td><label>年龄:</label></td>
					<td><input class="easyui-textbox" type="text" id="tjs_age"
						name="s_age" /></td>
				</tr>
				<tr>
					<td><label>性别:</label></td>
					<td><select id="tjs_sex" class="easyui-combobox"
						style="width: 100px;">
						<option value="0">--请选择--</option>
							<option value="2">女</option>
							<option value="1">男</option>
					</select></td>
				</tr>
				
				<tr>
					<td><label>电话:</label></td>
					<td><input class="easyui-textbox" type="text" id="tjs_phone"
						name="s_phone" /></td>
				</tr>
				<tr>
					<td><label>学历:</label></td>
					<td><input class="easyui-textbox" type="text"
						id="tjs_education" name="s_education" /></td>
				</tr>
				<tr>
					<td><label>状态:</label></td>
					<td><input class="easyui-textbox" type="text" id="tjs_status"
						name="s_status" /></td>
				</tr>
				<tr>
					<td><label>来源渠道:</label></td>
					<td><input class="easyui-textbox" type="text" id="tjs_qudao"
						name="s_qudao" /></td>
				</tr>
				<tr>
					<td><label>来源网站:</label></td>
					<td><input class="easyui-textbox" type="text"
						id="tjs_wangzhan" name="s_wangzhan" /></td>
				</tr>
				<tr>
					<td><label>来源关键词:</label></td>
					<td><input class="easyui-textbox" type="text"
						id="tjs_guanjian" name="s_guanjian" /></td>
				</tr>
				<tr>
					<td><label>QQ:</label></td>
					<td><input class="easyui-textbox" type="text" id="tjs_qq"
						name="s_qq" /></td>
				</tr>
				<tr>
					<td><label>微信:</label></td>
					<td><input class="easyui-textbox" type="text" id="tjs_weChat"
						name="s_weChat" /></td>
				</tr>
				<tr>
					<td><label>是否报备:</label></td>
					<td><select id="tjbaobei" class="easyui-combobox"
						style="width: 100px;">
						<option value="0">--请选择--</option>
							<option value="2">是</option>
							<option value="1">否</option>
					</select></td>
				</tr>
				<tr>
					<td><label>备注:</label></td>
					<td><input class="easyui-textbox" type="text" id="tjs_beizhu"
						name="s_beizhu" /></td>
				</tr>

			</table>
		</form>
	</div>


	<div id="tjrizhi-dialog" class="easyui-dialog" title="添加日志"
		style="width: 500px; height: 400px;"
		data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true,toolbar:[{
				text:'保存',
				iconCls:'icon-edit',
				handler:function(){rizhibaocun();}
			},{
				text:'退出',
				iconCls:'icon-cancel',
				handler:function(){tuichu();}}]">
		<form id="tjrizhifrm">

			<table>
				<tr style="display: none">
					<td><input class="easyui-textbox" type="text" id="s_ida"></td>
				</tr>
				<tr style="display: none">
					<td><input class="easyui-textbox" type="text" id="u_ida"></td>
				</tr>
				<tr style="display: none">
					<td><input class="easyui-textbox" type="text" id="l_id"
						name="l_id"></td>
				</tr>
				<tr>
					<td><label>回访开始时间:</label></td>
					<td><input class="easyui-datetimebox"
						id="l_genzongstartshijian" name="l_genzongstartshijian" /></td>
				</tr>
				<tr>
					<td><label>回访结束时间:</label></td>
					<td><input class="easyui-datetimebox" id="l_genzongendshijian"
						name="l_genzongendshijian" /></td>
				</tr>
				<tr>
					<td><label>回访情况:</label></td>
					<td><input class="easyui-textbox" type="text" id="l_huifang"
						name="l_huifang" /></td>
				</tr>
				<tr>
					<td><label>回访方式:</label></td>
					<td><input class="easyui-textbox" type="text" id="l_fangshi"
						name="l_fangshi" /></td>
				</tr>

				<tr>
					<td><label>下次回访时间:</label></td>
					<td><input class="easyui-datetimebox" type="text"
						id="l_xcshijian" name="l_xcshijian" /></td>
				</tr>
				<tr>
					<td><label>备注:</label></td>
					<td><input class="easyui-textbox" type="text" id="l_neirong"
						name="l_neirong" /></td>
				</tr>


			</table>
		</form>
	</div>

 <div id="rizhixiangxidiv" class="easyui-dialog" title="查看日志详细信息"
		style="width: 600px; height: 400px;"
		data-options="resizable:true,modal:true,closed:true">
		<form id="rizhixiangxifrm">
			
				<table>
					<tr style="display: none">
						<td><input class="easyui-textbox" type="text" 
							name="l_id"></td>
					</tr>
					<tr>
						<td><label>学生名称:</label></td>
				
						<td><input class="easyui-textbox" type="text" 
							name="rzname" disabled="disabled"></td>
					</tr>
					<tr>
						<td><label>回访开始时间:</label></td>
						<td><input class="easyui-textbox" type="text" 
							name="l_genzongstartshijian" disabled="disabled" /></td>
					</tr>
					<tr>
						<td><label>回访结束时间:</label></td>
						<td><input class="easyui-textbox" type="text" 
							name="l_genzongendshijian" disabled="disabled" /></td>
					</tr>
					<tr>
						<td><label>回访内容:</label></td>
						<td><input class="easyui-textbox" type="text" 
							name="l_neirong" disabled="disabled" /></td>
					</tr>
					<tr>
						<td><label>下次回访时间:</label></td>
						<td><input class="easyui-textbox" type="text"
							name="l_xcshijian" disabled="disabled" /></td>
					</tr>
					
				</table>
			
		</form>
	</div>
</body>
</html>