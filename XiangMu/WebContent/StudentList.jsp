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
	<script type="text/javascript"
	src="js/JSPjs/StudentList.js"></script>
</head>
<body>
 <input class="easyui-textbox" type="text" id="zxid" value="<%=session.getAttribute("zx") %>"/>
<input class="easyui-textbox" type="text" id="zxglid" value="<%=session.getAttribute("zxgl") %>"/>
	<input class="easyui-textbox" type="text" id="zxgljsid" value="<%=session.getAttribute("zxgljs") %>"/>
	
	<table class="easyui-datagrid" id="dg">
		<thead>
			<tr>
			<th data-options="field:'checkbox',checkbox:true">选择</th>
			<th data-options="field:'s_id',width:110">学生编号</th>
				<th data-options="field:'s_name',width:110">姓名</th>
				<th data-options="field:'s_age',width:110">年龄</th>
				<th data-options="field:'s_sex',width:110,formatter:xingbie">性别</th>
				<th data-options="field:'s_phone',width:110">电话</th>
				<th data-options="field:'s_education',width:110">学历</th>
				<th data-options="field:'s_status',width:110">状态</th>
				<th data-options="field:'s_qudao',width:110">来源渠道</th>
				<th data-options="field:'s_wangzhan',width:110">来源网站</th>
				<th data-options="field:'s_guanjian',width:110">来源关键词</th>
				<th data-options="field:'s_qq',width:110">QQ</th>
				<th data-options="field:'s_weChat',width:110">微信</th>
				<th data-options="field:'s_baobei',width:110,formatter:baobei">是否报备</th>
				<th data-options="field:'s_beizhu',width:110">备注</th>
				<th data-options="field:'name',width:110">咨询师</th>	
				<th data-options="field:'s_quyu',width:110">所在区域</th>
				<th data-options="field:'s_bumen',width:110">来源部门</th>
				<th data-options="field:'s_kecheng',width:110">课程方向</th>
				<th data-options="field:'s_youxiao',width:110,formatter:youxiao">是否有效</th>
				<th data-options="field:'s_dafen',width:110">打分</th>
				<th data-options="field:'s_huifang',width:110,formatter:huifang">是否回访</th>
				<th data-options="field:'s_huifangshijian',width:110">首次回访时间</th>
				<th data-options="field:'s_shangmen',width:110,formatter:shangmen">是否上门</th>
				<th data-options="field:'s_shangmenshijian',width:110">上门时间</th>
				<th data-options="field:'s_wuxiaoyuanyin',width:110">无效原因</th>
				<th data-options="field:'jiaofei',width:110,formatter:jiaofei">是否缴费</th>
				<th data-options="field:'s_jiaofeishijian',width:110">缴费时间</th>
				<th data-options="field:'s_price',width:110">金额</th>
				<th data-options="field:'s_tuifei',width:110,formatter:tuifei">是否退费</th>
				<th data-options="field:'s_jinban',width:110,formatter:jinban">是否进班</th>
				<th data-options="field:'s_jinbanshijian',width:110">进班时间</th>
				<th data-options="field:'s_jinbanbeizhu',width:110">进班备注</th>
				<th data-options="field:'s_tuifeiyuanyin',width:110">退费原因</th>
				<th data-options="field:'s_dingjin',width:110">定金金额</th>
				<th data-options="field:'s_dingjinshijian',width:110">定金时间</th>
				<th data-options="field:'s_guanzhu',width:110">学生关注</th>
				<th data-options="field:'name2',width:110">咨询师(面见)</th>
				<th data-options="field:'s_zixunbeizhu',width:110">咨询师备注</th>
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
					<th data-options="field:'rzname',width:110">姓名</th>
					<th data-options="field:'l_genzongstartshijian',width:110">回访开始时间</th>
					<th data-options="field:'l_genzongendshijian',width:110">回访结束时间</th>
					<th data-options="field:'l_xcshijian',width:110">下次回访时间</th>
					<th data-options="field:'l_neirong',width:110">回访内容</th>
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
				class="easyui-combobox" id="zxname" style="width: 110px;">
			</select> <label>手机号:</label> <input class="easyui-textbox" type="text"
				id="Sphone" /> <label>进班时间:</label> <input
				class="easyui-datetimebox" type="text" id="stime" /> ~ <input
				class="easyui-datetimebox" type="text" id="etime" /> <label>是否缴费:</label>
			<select id="sfjiaofei" class="easyui-combobox" style="width: 110px;">
				<option value="aa">--请选择--</option>
				<option value="1">否</option>
				<option value="2">是</option>
			</select> <label>是否有效:</label> <select id="sfyouxiao" class="easyui-combobox"
				style="width: 110px;">
				<option value="aa">--请选择--</option>
				<option value="1">否</option>
				<option value="2">是</option>
			</select> <label>是否回访:</label> <select id="sfhuifang" class="easyui-combobox"
				style="width: 110px;">
				<option value="aa">--请选择--</option>
				<option value="2">是</option>
				<option value="1">否</option>
			</select> <a href="javascript:void(0)" class="easyui-linkbutton"
				onclick="chaxun()" data-options="iconCls:'icon-search',plain:true">查询</a>
			<a href="javascript:void(0)" class="easyui-linkbutton"
				onclick="insert()" data-options="iconCls:'icon-add',plain:true">新增</a>
				<a
					href="javascript:void(0)" class="easyui-linkbutton"
					onclick="daochuexcel()" data-options="iconCls:'icon-redo'">导出Excel</a>
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
							name="s_wangzhan" disabled="disabled" />
							
							
							</td>
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
							style="width: 110px;">
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
						<td>
							
						<select id="ups_education" class="easyui-combobox"  name="s_education" style="width: 110px;">
							<option>未知</option>
							<option>大专</option>
							<option>高中</option>
							<option>中专</option>
							<option>初中</option>
							<option>本科</option>
							<option>其它</option>
						</select>
							</td>
					</tr>
					<tr>
						<td><label>状态:</label></td>
						<td>
							
					<select id="ups_status" class="easyui-combobox"  name="s_status" style="width: 110px;">
							<option>未知</option>
							<option>待业</option>
							<option>在职</option>
							<option>在读</option>

						</select>
							
							</td>
							
					</tr>
					<tr>
						<td><label>来源渠道:</label></td>
						<td>
							<select id="ups_qudao" class="easyui-combobox"  name="s_qudao" style="width: 110px;">
						
							<option>未知</option>
							<option>百度</option>
							<option>百度移动端</option>
							<option>360</option>
							<option>360移动端</option>
							<option>搜狗</option>
							<option>搜狗移动端</option>
							<option>UC移动端</option>
							<option>直接输入</option>
							<option>自然流量</option>
							<option>直电</option>
							<option>微信</option>
							<option>QQ</option>
						</select>
							</td>
					</tr>
					<tr>
						<td><label>来源网站:</label></td>
						<td>
							<select id="ups_wangzhan" class="easyui-combobox"  name="s_wangzhan" style="width: 110px;">
							
							<option>其它</option>
							<option>职英B站</option>
							<option>高考站</option>
							<option>职英A站</option>
						</select>
							</td>
					</tr>
					<tr>
						<td><label>来源关键词:</label></td>
						<td>
							
							<select id="ups_guanjian" class="easyui-combobox"  name="s_guanjian" style="width: 110px;">
							
							<option>统招</option>
							<option>单招</option>
							<option>预科</option>
							<option>其他</option>
						</select>
							
							</td>
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
							style="width: 110px;">
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
							style="width: 110px;">
						</select></td>
					</tr>
					<tr>
						<td><label>所在区域:</label></td>
						<td>
							<select id="ups_quyu" class="easyui-combobox"  name="s_quyu" style="width: 110px;">
					
							<option>未知</option>
							<option>其它</option>
							<option>郑州</option>
							<option>开封</option>
							<option>洛阳</option>
							<option>南阳</option>
							<option>漯河</option>
							<option>三门峡</option>
							<option>平顶山</option>
							<option>周口</option>
							<option>驻马店</option>
							<option>新乡</option>
							<option>鹤壁</option>
							<option>焦作</option>
							<option>濮阳</option>
							<option>安阳</option>
							<option>商丘</option>
							<option>信阳</option>
							<option>济源</option>
						</select>
							
							</td>
					</tr>
					<tr>
						<td><label>来源部门:</label></td>
						<td>
							<select id="ups_bumen" class="easyui-combobox"  name="s_bumen" style="width: 110px;">
							
							<option>网络</option>
							<option>市场</option>
							<option>教质</option>
							<option>学术</option>
							<option>就业</option>
						
						</select>
							</td>
					</tr>
					<tr>
						<td><label>课程方向:</label></td>
						<td>
								<select id="ups_kecheng" class="easyui-combobox"  name="s_kecheng" style="width: 110px;">
							
							<option>软件开发</option>
							<option>软件设计</option>
							<option>网络营销</option>
							
						
						</select>
							</td>
					</tr>
					<tr>
						<td><label>是否有效:</label></td>
						<td><select id="upyouxiao" class="easyui-combobox"
							style="width: 110px;">
								<option value="2">是</option>
								<option value="1">否</option>
						</select></td>
					</tr>
					<tr>
						<td><label>打分:</label></td>
						<td>
						<select id="ups_dafen" class="easyui-combobox"  name="s_dafen" style="width: 110px;">
							<option>A、近期可报名</option>
							<option>B、一个月内可报名</option>
							<option>C、长期跟踪</option>
							<option>D、无效</option>
						</select>
						</td>
					</tr>
					<tr>
						<td><label>是否回访:</label></td>
						<td><select id="uphuifang" class="easyui-combobox"
							style="width: 110px;">
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
							style="width: 110px;">
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
							style="width: 110px;">
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
							style="width: 110px;">
								<option value="2">是</option>
								<option value="1">否</option>
						</select></td>
					</tr>
					<tr>
						<td><label>是否进班:</label></td>
						<td><select id="upjinban" class="easyui-combobox"
							style="width: 110px;">
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
							style="width: 110px;">
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
						style="width: 110px;">
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
					<td>
						<select id="tjs_education" class="easyui-combobox"  name="s_education" style="width: 110px;">
							<option value="aa">--请选择--</option>
							<option>未知</option>
							<option>大专</option>
							<option>高中</option>
							<option>中专</option>
							<option>初中</option>
							<option>本科</option>
							<option>其它</option>
						</select>
						</td>
				</tr>
				<tr>
					<td><label>状态:</label></td>
					<td>
						<select id="tjs_status" class="easyui-combobox"  name="s_status" style="width: 110px;">
							<option value="aa">--请选择--</option>
						<option>未知</option>
							<option>待业</option>
							<option>在职</option>
							<option>在读</option>
						</select>
						
						</td>
				</tr>
				<tr>
					<td><label>来源渠道:</label></td>
					<td>
						<select id="tjs_qudao" class="easyui-combobox"  name="s_qudao" style="width: 110px;">
							<option value="aa">--请选择--</option>
							<option>未知</option>
							<option>百度</option>
							<option>百度移动端</option>
							<option>360</option>
							<option>360移动端</option>
							<option>搜狗</option>
							<option>搜狗移动端</option>
							<option>UC移动端</option>
							<option>直接输入</option>
							<option>自然流量</option>
							<option>直电</option>
							<option>微信</option>
							<option>QQ</option>
						</select>
	
						</td>
				</tr>
				<tr>
					<td><label>来源网站:</label></td>
					<td>
						
						<select id="tjs_wangzhan" class="easyui-combobox"  name="s_wangzhan" style="width: 110px;">
							<option value="aa">--请选择--</option>
							<option>其它</option>
							<option>职英B站</option>
							<option>高考站</option>
							<option>职英A站</option>
						</select>
						</td>
				</tr>
				<tr>
					<td><label>来源关键词:</label></td>
					<td>
						
						<select id="tjs_guanjian" class="easyui-combobox"  name="s_guanjian" style="width: 110px;">
							<option value="aa">--请选择--</option>
							<option>统招</option>
							<option>单招</option>
							<option>预科</option>
							<option>其他</option>
							
						</select>
						</td>
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
						style="width: 110px;">
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