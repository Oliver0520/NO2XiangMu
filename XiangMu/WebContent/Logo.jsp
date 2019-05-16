<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>日志</title>

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
			url : 'logoqqqq',
			method : "post",
			pagination : true,
            toolbar:"#tb",
            
            
             queryParams : {
            	s_name:$("#xueshengmingcheng").textbox("getValue"),
            	u_userName:$("#gengzongzhe").textbox("getValue"),
            	l_genzongstartshijian:$("#genzongstartfs").textbox("getValue"),
            	l_genzongendshijian:$("#genzongendfs").textbox("getValue"),
            	l_huifang:$("#huifangqingkuang").textbox("getValue"),
            	
            	l_fangshi:$("#genzongfs").textbox("getValue"),
            	
            } 
		
		});
		$("#ff").form("clear");
	}

	function caozuoformatter(value,row,index){
		return "  <a href='javascript:void(0)' class='easyui-linkbutton' onclick='xiugai("+index+")'>查看</a>  ";
	}
function xiugai(index){
	
	
 var data = $("#dg").datagrid("getData");
	var row = data.rows[index];
	$("#chakanfrm").form("load", row);
	$("#wwwwwww").dialog("open"); 
}

</script>
</head>
<body>
	<table class="easyui-datagrid" id="dg">
		<thead>
			<tr>
				<th data-options="field:'l_id',width:100">日志ID</th>
				<th data-options="field:'studentname',width:100">学生姓名</th>
				<th data-options="field:'username',width:100">咨询师姓名</th>
				<th data-options="field:'l_genzongstartshijian',width:100">回访开始时间</th>
				<th data-options="field:'l_genzongendshijian',width:100">回访结束时间</th>
				<th data-options="field:'l_huifang',width:100">回访</th>
				<th data-options="field:'l_fangshi',width:100">回访方式</th>
				<th data-options="field:'l_xcshijian',width:100">下次回访时间</th>
				<th data-options="field:'l_neirong',width:100">回访内容</th><!-- 
				 <th data-options="field:'caozuosa',width:100,formatter:caozuolie"></th>  -->
<th data-options="field:'caozuo',formatter:caozuoformatter,align:'ceter',title:'操作'"></th>
			</tr>
		</thead>
	</table>
	 <div id="tb">

<form id="ff">   
    <label>学生姓名:</label>   
        <input class="easyui-textbox" id="xueshengmingcheng" type="text" name="name" data-options="required:true" />
    <label>咨询师姓名:</label>   
        <input class="easyui-textbox" id="gengzongzhe" type="text" name="name" data-options="required:true" />
    <label>回访内容:</label>   
        <input class="easyui-textbox" id="huifangqingkuang" type="text" name="name" data-options="required:true" />
    <label>回访方式:</label>   
        <input class="easyui-textbox" id="genzongfs" type="text" name="name" data-options="required:true" />
    <label>回访开始时间:</label>   
        <input class="easyui-datetimebox" id="genzongstartfs" type="text" name="name" data-options="required:true" />      
    <label>回访结束时间:</label>   
        <input class="easyui-datetimebox" id="genzongendfs" type="text" name="name" data-options="required:true" />
        <a href="javascript:void(0)" class="easyui-linkbutton"
				onclick="inint()" data-options="iconCls:'icon-search',plain:true">查询</a>
</form> 
</div>

	 <div id="wwwwwww" class="easyui-dialog" title="查看"
		style="width: 600px; height: 400px;"
		data-options="resizable:true,modal:true,closed:true">
		<form id="chakanfrm">
			
				<table>
					<tr style="display: none">
						<td><input class="easyui-textbox" type="text" id="s_id"
							name="l_id"></td>
					</tr>
					<tr>
						<td><label>学生名称:</label></td>
				
						<td><input class="easyui-textbox" type="text" id="s_id"
							name="studentname" disabled="disabled"></td>
					</tr>
					<tr>
						<td><label>回访者:</label></td>
						<td><input class="easyui-textbox" type="text" id="s_name"
							name="username" disabled="disabled" /></td>
					</tr>
					<tr>
						<td><label>回访情况:</label></td>
						<td><input class="easyui-textbox" type="text" id="s_name"
							name="l_huifang" disabled="disabled" /></td>
					</tr>
					<tr>
						<td><label>回访方式:</label></td>
						<td><input class="easyui-textbox" type="text" id="s_age"
							name="l_fangshi" disabled="disabled" /></td>
					</tr>
					<tr>
						<td><label>回访开始时间:</label></td>
						<td><input class="easyui-textbox" type="text" id="s_sex"
							name="l_genzongstartshijian" disabled="disabled" /></td>
					</tr>
					<tr>
						<td><label>回访结束时间:</label></td>
						<td><input class="easyui-textbox" type="text" id="s_phone"
							name="l_genzongendshijian" disabled="disabled" /></td>
					</tr>
				</table>
			
		</form>
	</div>
</body>
</html>