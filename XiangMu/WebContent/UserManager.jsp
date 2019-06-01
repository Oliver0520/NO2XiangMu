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
	src="js/test.js"></script>
	<script type="text/javascript"
	src="js/JSPjs/UserManager.js"></script>
	<script type="text/javascript">
	function yincang(){
		$("#abd").window("open");
	}
	function hideCol(){
		var spCodesTemp = "";
		$('input:checkbox[name=asdf]:checked').each(function(i){
		if(0==i){
		spCodesTemp = $(this).val();
		}else{
		spCodesTemp += (","+$(this).val());
		}
		});
		var strs= new Array(); //定义一数组 
		strs=spCodesTemp.split(","); //字符分割 
		for (i=0;i<strs.length ;i++ ) 
		{ 
			$('#dg').datagrid('hideColumn',strs[i]);
		}
		 }
			function showCol(){
				var spCodesTemp = "";
		$('input:checkbox[name=asdf]:checked').each(function(i){
		if(0==i){
		spCodesTemp = $(this).val();
		}else{
		spCodesTemp += (","+$(this).val());
		}
		});
		var strs= new Array(); //定义一数组 
		strs=spCodesTemp.split(","); //字符分割 
		for (i=0;i<strs.length ;i++ ) 
		{ 
			$('#dg').datagrid('showColumn',strs[i]);
		}
			}

			function insertbaocun(){
				var lname=$("#lname").val();
				var pwd=$("#pwd").textbox("getValue");
				var email=$("#email").val();
				var phone=$("#phone").val();
				var yhname=$("#yhname").val();
				if(lname==null){
					$.messager.alert('提示','登录名不能为空');
				}else{
				$.post("selectCountByLname",{
					u_loginName:lname
				},function(res){
					if(res>0){
						$.messager.alert('提示','登录名已被占用，请更换！！！');    
					}else{
						$.post("insertUser",{
							u_loginName:lname,
							u_userName:yhname,
							u_password:pwd,
							u_email:email,
							u_phoneNumber:phone,
							u_createTime:getNowFormatDate()
						},function(res){
							if(res.success){
								$("#dg").datagrid("reload");
								$.messager.alert('提示',res.msg); 
								$("#insert-dialog").dialog("close");
							}else{
								$.messager.alert('提示',res.msg); 
							}
						},"json");
					}
				},"json");
				}
				$("#addfrm").form("clear");
			}

			
			  $.extend($.fn.validatebox.defaults.rules, {
				    phoneRex: {
				        validator: function(value){
				        var rex=/^1[3-8]+\d{9}$/;
				        //var rex=/^(([0\+]\d{2,3}-)?(0\d{2,3})-)(\d{7,8})(-(\d{3,}))?$/;
				        //区号：前面一个0，后面跟2-3位数字 ： 0\d{2,3}
				        //电话号码：7-8位数字： \d{7,8
				        //分机号：一般都是3位数字： \d{3,}
				         //这样连接起来就是验证电话的正则表达式了：/^((0\d{2,3})-)(\d{7,8})(-(\d{3,}))?$/        
				        var rex2=/^((0\d{2,3})-)(\d{7,8})(-(\d{3,}))?$/;
				        if(rex.test(value)||rex2.test(value))
				        {
				          // alert('t'+value);
				          return true;
				        }else
				        {
				         //alert('false '+value);
				           return false;
				        }
				          
				        },
				        message: '请输入正确电话或手机格式'
				    }
				});
			  
			  function updatebaocun(){
					var email=$("#uemail").val();
					var phone=$("#uphone").val();
					var u_id=$("#u_id").textbox("getValue");
					var forma=$("#upfrm").form("validate");
					if(forma){
					$.post("updateUser",{
						u_email:email,
						u_phoneNumber:phone,
						u_id:u_id
					},function(res){
						if(res>0){
							$("#dg").datagrid("reload");
							$.messager.alert('提示','编辑成功'); 
							$("#update-dialog").dialog("close");
						}else{
							$.messager.alert('提示','编辑失败'); 
						}
					},"json");}else{
					$.messager.alert("提示","格式不正确");	
					}
					}
			  function shanchu(index){
					var data=$("#dg").datagrid("getData");
					var row=data.rows[index];
					$.messager.confirm('确认','您确认想要删除记录吗？',function(r){    
					    if (r){    
					    	$.post("deleteUser",{u_id:row.u_id},function(res){
								if(res.success){
									$("#dg").datagrid("reload");
									$.messager.alert('提示',res.msg); 
								}else{
									$.messager.alert('提示',res.msg); 
								}
							},"json");
					    }    
					}); 	
				}
	</script>
</head>
<body>
	<table id="dg" class="easyui-datagrid">
		<thead>
			<tr>
				<th data-options="field:'u_id'">编号</th>
				<th data-options="field:'u_userName'">用户名</th>
				<th data-options="field:'isLockout',formatter:isLockformatter">是否锁定</th>
				<th data-options="field:'u_lastLoginTime'">最后一次登录时间</th>
				<th data-options="field:'u_createTime'">账户创立时间</th>
				<th data-options="field:'u_email'">邮箱</th>
				<th data-options="field:'u_phoneNumber'">手机号码</th>
				<th data-options="field:'u_qdshijian'">签到时间</th>
				<th data-options="field:'u_weight'">权重</th>
				<th data-options="field:'u_weightbeizhu'">权重备注</th>
				<th data-options="field:'caozuo',formatter:caozuoformatter,align:'ceter',title:'操作'"></th>
				<th data-options="field:'chongzhi',formatter:zhongzhiformatter">重置密码</th>
				<th data-options="field:'suoding',formatter:suodingformatter">锁定用户</th>
				<th data-options="field:'jiesuo',formatter:jiesuoformatter">解锁用户</th>
				<th data-options="field:'shezhi',formatter:shezhiformatter">设置角色</th>
			</tr>
		</thead>
	</table>
	<div id="bar">
		<form id="str">
			<label>用户名:</label> <input class="easyui-textbox" type="text"
				id="uname" /> <label>用户创建时间:</label> <input
				class="easyui-datetimebox" type="text" id="stime" /> ~ <input
				class="easyui-datetimebox" type="text" id="etime" /> <label>用户最后登录时间:</label>
			<input class="easyui-datetimebox" type="text" id="lastTime" /> <label>排序规则:</label>
			<select id="paixu" class="easyui-combobox" 
				style="width: 200px;">
				<option value="aa">--请选择--</option>
				<option value="0">用户最后登录时间</option>
				<option value="1">用户创建时间</option>
			</select> <a href="javascript:void(0)" class="easyui-linkbutton"
				onclick="init()" data-options="iconCls:'icon-search',plain:true">查询</a>
			<a href="javascript:void(0)" class="easyui-linkbutton"
				onclick="xinzeng()" data-options="iconCls:'icon-add',plain:true">新增</a>
				<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="yincang()">隐藏</a>
		</form>
	</div>
	
	
	
	<!-- 新增信息的dialog -->
	<div id="insert-dialog" class="easyui-dialog" title="新增窗口" style="width:400px;height:300px;"   
        data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true,toolbar:[{
				text:'保存',
				iconCls:'icon-edit',
				handler:function(){insertbaocun();}
			},{
				text:'退出',
				iconCls:'icon-help',
				handler:function(){exitInsert();}
			}]">
			<form id="addfrm">
    <table>
    <tr>
    <td><label>登录名:</label></td>
    <td><input class="easyui-textbox" type="text"  data-options="required:true" id="lname" /> </td>
    </tr>
        <tr>
    <td><label>用户名:</label></td>
    <td><input class="easyui-textbox" type="text"  data-options="required:true" id="yhname" /> </td>
    </tr>
    <tr>
    <td><label>密码:</label></td>
    <td><input class="easyui-textbox" type="password" data-options="required:true" id="pwd" /> </td>
    </tr>
    <tr>
    <td><label>邮箱:</label></td>
    <td><input class="easyui-validatebox" data-options="required:true,validType:'email'" id="email" /></td>
    </tr>
    <tr>
    <td><label>手机号:</label></td>
    <td><input class="easyui-validatebox" data-options="required:true,validType:'phoneRex'" id="phone" /></td>
    </tr>
    </table>
    </form>   
</div> 
	
	
	<!-- 编辑窗口 -->
	<div id="update-dialog" class="easyui-dialog" title="修改窗口" style="width:400px;height:300px;"   
        data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true,toolbar:[{
				text:'保存',
				iconCls:'icon-edit',
				handler:function(){updatebaocun();}
			},{
				text:'退出',
				iconCls:'icon-help',
				handler:function(){exitUpdate();}
			}]">
			<form id="upfrm">
    <table>
    <tr style="display: none">  
    <td> <input class="easyui-textbox" type="text" id="u_id" name="u_id" > </td>
    </tr>
    <tr>
    <td><label>登录名:</label></td>
    <td><input class="easyui-textbox" type="text" id="loname"  name="u_loginName" disabled="disabled"  /> </td>
    </tr>    
    <tr>
    <td><label>邮箱:</label></td>
    <td><input class="easyui-validatebox" data-options="required:true,validType:'email'" id="uemail"  name="u_email"/></td>
    </tr>
    <tr>
    <td><label>手机号:</label></td>
    <td><input class="easyui-validatebox textbox" data-options="required:true,validType:'phoneRex'" id="uphone" name="u_phoneNumber" /></td>
    </tr>
    </table>   
    </form>
     </div> 
     
     
     
     <!-- 用戶的角色設置 -->
     <div id="jueseWindow" class="easyui-window" data-options="modal:true,closed:true,iconCls:'icon-save'" style="width:500px;height:500px;padding:10px;">
			<table>
				<tr>
					<td width="200px">
						<table id="yhRoles" title="系统所有角色" class="easyui-datagrid" data-options="rownumbers:true,singleSelect:true,method:'post'">
							<thead>
								<tr>
									<th data-options="field:'r_id',width:280,hidden:true">角色ID</th>
									<th data-options="field:'r_name',width:100">角色名</th>
								</tr>
							</thead>
						</table>
					</td>
					<td width="100px">
						<input type="button" value="-->" onclick="addRoles()" /></br>
						<input type="button" value="<--" onclick="delRoles()" />
					</td>
					<td width="200px" valign="top">
						<table id="myRoles" title="当前用户所有角色" class="easyui-datagrid" data-options="rownumbers:true,singleSelect:true,method:'post'">
							<thead>
								<tr>
									<th data-options="field:'r_id',width:280,hidden:true">角色ID</th>
									<th data-options="field:'r_name',width:100">名称</th>
								</tr>
							</thead>
						</table>
					</td>
				</tr>
			</table>
		</div>
		
		<div class="easyui-window" id="abd" data-options="modal:true,closed:true,iconCls:'icon-save'" style="width:700px;height:300px;padding:10px;" >
			<table>
				<tr>
					<td>
						<input type="checkbox" value="u_id" name="asdf" />编号
					</td>
					<td>
						<input type="checkbox" value="u_userName" name="asdf" />用户名
					</td>
					<td>
						<input type="checkbox" value="isLockout" name="asdf" />是否锁定
					</td>
					<td>
						<input type="checkbox" value="u_lastLoginTime" name="asdf" />最后一次登录时间
					</td>
					<td>
						<input type="checkbox" value="u_createTime" name="asdf" />账户创立时间
					</td>					
				</tr>
				<tr>
					<td>
						<input type="checkbox" value="u_email" name="asdf" />邮箱
					</td>
					<td>
						<input type="checkbox" value="u_phoneNumber" name="asdf" />手机号码
					</td>
					<td>
						<input type="checkbox" value="u_qdshijian" name="asdf" />签到时间
					</td>
					<td>
						<input type="checkbox" value="u_weight" name="asdf" />权重
					</td>
					<td>
						<input type="checkbox" value="u_weightbeizhu" name="asdf" />权重备注
					</td>					
				</tr>
				<tr>
					
					<td><input type="button" onclick="hideCol()" value="隐藏">  
					</td>
					
					<td>
						<input type="button" onclick="showCol()" value="显示">
						
					</td>
				</tr>
			</table>
		</div>
</body>
</html>