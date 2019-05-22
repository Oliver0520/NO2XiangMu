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
	<script type="text/javascript"
	src="js/JSPjs/Dynamic.js"></script>
	<script type="text/javascript">
	$(function(){
		init();
	});
	function init(){
		$("#dynamicdg").datagrid({
			url : "selectCopyDynamic",
			method : "post",
			pagination : true,
			singleSelect:true});
	}
	
	</script>
</head>
<body>
<table class="easyui-datagrid" id="dynamicdg">
		<thead>
			<tr>
				<th data-options="field:'d_id',width:100">动态ID</th>
				<th data-options="field:'s_name',width:100">学生姓名</th>
				<th data-options="field:'u_nameSend',width:100">修改咨询师姓名</th>
				<th data-options="field:'d_sendTime',width:100">动态发送时间</th>
				<th data-options="field:'uname',width:100">接收人</th>
				<th data-options="field:'d_body',width:100">修改内容</th> 
                <th data-options="field:'caozuo',formatter:caozuoformatter,title:'标记是否已读'"></th>
			</tr>
		</thead>
	</table>
</body>
</html>