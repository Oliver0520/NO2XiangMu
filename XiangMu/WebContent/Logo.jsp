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
	  $(function(){
		  inint();
	  });
	  
	  function inint(){
		  $('#dg').datagrid({
			  url:'logo',
			  method:"post",
			  pagination:true,
			  toolbar: '#tb'

			  
		  });
		  }
    </script>
</head>
<body>
<table class="easyui-datagrid" id="dg">   
    <thead>   
        <tr>   
            <th data-options="field:'l_id',width:100">日志ID</th>   
            <th data-options="field:'s_id',width:100">学生姓名</th>   
            <th data-options="field:'u_id',width:100">咨询师姓名</th>  
            <th data-options="field:'l_genzongstartshijian',width:100">跟踪开始时间</th>
            <th data-options="field:'l_genzongendshijian',width:100">跟踪结束时间</th>
            <th data-options="field:'l_huifang',width:100">回访</th>
            <th data-options="field:'l_fangshi',width:100">回访方式</th>
            <th data-options="field:'l_xcshijian',width:100">下次回访时间</th>
            <th data-options="field:'l_neirong',width:100">回访内容</th>

        </tr>   
    </thead>   
</table>  
<div id="tb">

<form id="ff">   
    <label>学生名称:</label>   
        <input class="easyui-textbox" type="text" name="name" data-options="required:true" />
    <label>跟踪者:</label>   
        <input class="easyui-textbox" type="text" name="name" data-options="required:true" />
    <label>回访情况:</label>   
        <input class="easyui-textbox" type="text" name="name" data-options="required:true" />
    <label>跟踪方式:</label>   
        <input class="easyui-textbox" type="text" name="name" data-options="required:true" />
    <label>跟踪开始方式:</label>   
        <input class="easyui-datetimebox" type="text" name="name" data-options="required:true" />      
    <label>跟踪结束方式:</label>   
        <input class="easyui-datetimebox" type="text" name="name" data-options="required:true" />
</form> 
</div>

</body>
</html>