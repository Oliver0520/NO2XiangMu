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
			
				checkbox:true,
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
	
 function chaxun(){
		var zxid=$("#zxid").textbox("getValue");
		var zxglid=$("#zxglid").textbox("getValue");
		var zxgljsid=$("#zxgljsid").textbox("getValue");
		var dengluren=$("#zxname").textbox("getValue");
	if(zxgljsid>0){
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

	
	else if(zxglid>0){
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

	
	else{
		if(zxid>0 && dengluren==""){
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
		if(zxid>0 && dengluren!=""){
			alert("您没有权限根据咨询师姓名查询！！！");
			$("#str").form("clear");
			$("#dg").datagrid("reload");
		}
	}
 }
	function caozuolei(value, row, index) {
		var zxid = $("#zxid").textbox("getValue");
		var zxglid = $("#zxglid").textbox("getValue");
		var zxgljsid = $("#zxgljsid").textbox("getValue");
		if(zxgljsid>0){
			return "<a href='javascript:void(0)'  onclick='shanchu("+ index+ ")'>删除</a>  <a href='javascript:void(0)' onclick='chakan("+ index+ ")'>查看</a>  <a href='javascript:void(0)' onclick='xiugai("+ index+ ")'>修改</a> <a href='javascript:void(0)' onclick='chakanrizhi("+ index+ ")'>查看日志</a>  <a href='javascript:void(0)' onclick='insertrizhi("+ index + ")'>添加日志</a>"
		}
		
		else if(zxglid>0){
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
		return row.s_sex == 1 ? "男" : "女";;
	}
	function updatebaocun() {
		var s_id = $("#ups_id").textbox("getValue");
		var s_name = $("#ups_name").textbox("getValue");
		var s_age = $("#ups_age").textbox("getValue");
		var s_sex = $("#ups_sex").textbox("getValue");
		var s_phone = $("#ups_phone").textbox("getValue");
		var s_education = $("#ups_education").combobox("getValue");
		var s_status = $("#ups_status").combobox("getValue");
		var s_qudao = $("#ups_qudao").combobox("getValue");
		var s_wangzhan = $("#ups_wangzhan").combobox("getValue");
		var s_guanjian = $("#ups_guanjian").combobox("getValue");
		var s_qq = $("#ups_qq").textbox("getValue");
		var s_weChat = $("#ups_weChat").textbox("getValue");
		var baobei = $("#upbaobei").combobox("getValue");
		var s_beizhu = $("#ups_beizhu").textbox("getValue");
		var name = $("#zxname1").combobox("getValue");
		var s_quyu = $("#ups_quyu").combobox("getValue");
		var s_bumen = $("#ups_bumen").combobox("getValue");
		var s_kecheng = $("#ups_kecheng").combobox("getValue");
		var youxiao = $("#upyouxiao").combobox("getValue");
		var s_dafen = $("#ups_dafen").combobox("getValue");
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
		var s_education = $("#tjs_education").combobox("getValue");
		var s_status = $("#tjs_status").combobox("getValue");
		var s_qudao = $("#tjs_qudao").combobox("getValue");
		var s_wangzhan = $("#tjs_wangzhan").combobox("getValue");
		var s_guanjian = $("#tjs_guanjian").combobox("getValue");
		var s_qq = $("#tjs_qq").textbox("getValue");
		var s_weChat = $("#tjs_weChat").textbox("getValue");
		var baobei = $("#tjbaobei").combobox("getValue");
		var s_beizhu = $("#tjs_beizhu").textbox("getValue");
		if(s_education=="aa"){
			s_education=null;
		}
		if(s_status=="aa"){
			s_status=null;
		}
		if(s_qudao=="aa"){
			s_qudao=null;
		}
		if(s_wangzhan=="aa"){
			s_wangzhan=null;
		}
		if(s_guanjian=="aa"){
			s_guanjian=null;
		}
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