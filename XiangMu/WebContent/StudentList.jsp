<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>

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
<script type="text/javascript">
	$(function() {

		inint();

	});
	function inint() {

		$('#dg').datagrid({
			url : 'chaxun',
			method : 'post',
			pagination : true
		});
	}
	function caozuolei(value,row,index){
		return "<a href='javascript:void(0)' onclick='shanchu("+index+")'>删除</a>"
	}
	function shanchu(index){
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
</script>
</head>
<body>
	<table class="easyui-datagrid" id="dg">
		<thead>
			<tr>
				<th data-options="field:'s_name',width:100">编码</th>
				<th data-options="field:'s_age',width:100">编码</th>
				<th data-options="field:'s_sex',width:100">编码</th>
				<th data-options="field:'s_phone',width:100">编码</th>
				<th data-options="field:'s_education',width:100">编码</th>
				<th data-options="field:'s_status',width:100">编码</th>
				<th data-options="field:'s_qudao',width:100">编码</th>
				<th data-options="field:'s_wangzhan',width:100">编码</th>
				<th data-options="field:'s_guanjian',width:100">编码</th>
				<th data-options="field:'s_qq',width:100">编码</th>
				<th data-options="field:'s_weChat',width:100">编码</th>
				<th data-options="field:'s_baobei',width:100">编码</th>
				<th data-options="field:'s_beizhu',width:100">编码</th>
				<th data-options="field:'u_id',width:100">编码</th>
				<th data-options="field:'s_quyu',width:100">编码</th>
				<th data-options="field:'s_bumen',width:100">编码</th>
				<th data-options="field:'s_kecheng',width:100">编码</th>
				<th data-options="field:'s_youxiao',width:100">编码</th>
				<th data-options="field:'s_dafen',width:100">编码</th>
				<th data-options="field:'s_huifang',width:100">编码</th>
				<th data-options="field:'s_huifangshijian',width:100">编码</th>
				<th data-options="field:'s_shangmen',width:100">编码</th>
				<th data-options="field:'s_shangmenshijian',width:100">编码</th>
				<th data-options="field:'s_wuxiaoyuanyin',width:100">名称</th>
				<th data-options="field:'s_jiaofei',width:100">名称</th>
				<th data-options="field:'s_jiaofeishijian',width:100">名称</th>
				<th data-options="field:'s_price',width:100">名称</th>
				<th data-options="field:'s_tuifei',width:100">名称</th>
				<th data-options="field:'s_jinban',width:100">名称</th>
				<th data-options="field:'s_jinbanshijian',width:100">名称</th>
				<th data-options="field:'s_jinbanbeizhu',width:100">名称</th>
				<th data-options="field:'s_tuifeiyuanyin',width:100">名称</th>
				<th data-options="field:'s_dingjin',width:100">名称</th>
				<th data-options="field:'s_dingjinshijian',width:100">名称</th>
				<th data-options="field:'s_guanzhu',width:100">名称</th>
				<th data-options="field:'u_idw',width:100">名称</th>
				<th data-options="field:'s_zixunbeizhu',width:100">名称</th>
				<th data-options="field:'l_id',width:100">名称</th>
				<th data-options="field:'s_int',width:100">名称</th>
				<th data-options="field:'s_string',width:100">名称</th>
				<th data-options="field:'caozuo',title:'操作',formatter:caozuolei"></th>
			</tr>
		</thead>
	</table>
</body>
</html>