<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>


<link rel="stylesheet" type="text/css"
	href="js/jquery-easyui-1.4.3/themes/icon.css">
<link rel="stylesheet" type="text/css"
	href="js/jquery-easyui-1.4.3/themes/default/easyui.css">

	<meta charset="utf-8" />
    <link rel="apple-touch-icon" sizes="76x76" href="assets/img/apple-icon.png">
    <link rel="icon" type="image/png" href="assets/img/favicon.png">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>CRM管理系统</title>
    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no' name='viewport' />
    <!--     Fonts and icons     -->
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700,200" rel="stylesheet" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" />
    <!-- CSS Files -->
    <link href="assets/css/bootstrap.min.css" rel="stylesheet" />
    <link href="assets/css/now-ui-kit.css" rel="stylesheet" />
    <!-- CSS Just for demo purpose, don't include it in your project -->
    <link href="assets/css/demo.css" rel="stylesheet" />
    <script src="assets/js/core/jquery.3.2.1.min.js" type="text/javascript"></script>
<script src="assets/js/core/popper.min.js" type="text/javascript"></script>
<script src="assets/js/core/bootstrap.min.js" type="text/javascript"></script>
<script src="assets/js/plugins/bootstrap-switch.js"></script>
<script src="assets/js/plugins/nouislider.min.js" type="text/javascript"></script>
<script src="assets/js/plugins/bootstrap-datepicker.js" type="text/javascript"></script>
<script src="assets/js/plugins/jquery.sharrre.js" type="text/javascript"></script>
<script src="assets/js/now-ui-kit.js" type="text/javascript"></script>
<script type="text/javascript"
	src="js/jquery-easyui-1.4.3/jquery.min.js"></script>
<script type="text/javascript"
	src="js/jquery-easyui-1.4.3/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="js/jquery-easyui-1.4.3/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript"
	src="js/JSPjs/Login.js"></script>
<script type="text/javascript">
	$(function() {
		$('#dd').dialog({
			title : 'hello', //标题栏
			width : 400, //宽度
			height : 900, //高度
			closed : false, //是否关闭（隐藏）
		// content:'<h1>hello my first jquery</h1>'  //显示的内容
		});
	});
</script>
</head>
<body class="login-page sidebar-collapse">
	<nav class="navbar navbar-expand-lg bg-primary fixed-top navbar-transparent " color-on-scroll="400">
        <div class="container">
          
            <div class="navbar-translate">
                <a class="navbar-brand" href="javascript:void(0);" rel="tooltip" data-placement="bottom" style="font-size: 30px;">
                    CRM系统登录页面
                </a>
                <button class="navbar-toggler navbar-toggler" type="button" data-toggle="collapse" data-target="#navigation" aria-controls="navigation-index" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-bar bar1"></span>
                    <span class="navbar-toggler-bar bar2"></span>
                    <span class="navbar-toggler-bar bar3"></span>
                </button>
            </div>
          
        </div>
    </nav>
    <!-- End Navbar -->
    <div class="page-header" filter-color="orange">
        <div class="page-header-image" style="background-image:url(assets/img/login.jpg)"></div>
        <div class="container">
            <div class="col-md-4 content-center" >
                <div class="card card-login card-plain">
                    <form class="form" method="" action="">
                        <div class="header header-primary text-center">
                           <div class="logo-container" style="width: 300px;" >
                                <img src="assets/img/crm4.png" >
                            </div>
                        </div>
                        <div class="content">
                            <div class="input-group form-group-no-border input-lg">
                                <span class="input-group-addon">
                                    <i class="now-ui-icons users_circle-08"></i>
                                </span>
                                <input type="text" id="username" class="form-control" placeholder="登录名...">
                            </div>
                            <div class="input-group form-group-no-border input-lg">
                                <span class="input-group-addon">
                                    <i class="now-ui-icons text_caps-small"></i>
                                </span>
                                <input type="password" id="pwd" placeholder="密码..." class="form-control" />
                            </div>
                            <div class="input-group form-group-no-border input-lg">
                                <span class="input-group-addon">
                                   
                                </span>
                                <input type="text" id="yanzhengma" placeholder="验证码..." class="form-control" />
                            </div>
                            <div class="input-group form-group-no-border input-lg">
                              <div class="pull-left"> 
                               <img id="yzm_img"
								style="width: 180px; height: 80px; border-radius: 3px; padding-left: 20%"
								title="点击刷新验证码" src="getVerifiCode" />
								</div>
								<div class="pull-right" style="font-size:25px;margin-top:20px">
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<a href="javascript:getVerifiCode()">看不清?</a>
								</div>
                            </div>
                          
                             <div class="input-group form-group-no-border input-lg">
                                 <input type="checkbox" value="yes" name="y">自动登录
                               
                            </div>
                        </div>
                        <div class="footer text-center">
                            <a href="javascript:void(0)" class="btn btn-primary btn-round btn-lg btn-block" onclick="denglu()">登陆</a>
                        
                            <a href="javascript:void(0)" class="btn btn-primary btn-round btn-lg btn-block" onclick="chongzhi()">重置</a>
                        </div>
                        <div class="pull-left">
                            <h3>
                                <a href="javascript:void(0)" onclick="forget()" >忘记密码</a>
                            </h3>
                        </div>
                    </form>
                </div>
            </div>
        </div>
       
    </div>
      <!-- 忘记密码窗口 -->
	<div id="forget-dialog" class="easyui-dialog" title="忘记密码窗口"
		style="width: 400px; height: 300px;"
		data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true,toolbar:[{
				text:'保存',
				iconCls:'icon-edit',
				handler:function(){forgetbaocun();}
			},{
				text:'退出',
				iconCls:'icon-help',
				handler:function(){exitForget();}
			}]">
		<form id="upfrm">
			<table>
				<tr>
					<td><label>登录名:</label></td>
					<td><input class="easyui-textbox" type="text" id="loginName" /></td>
				</tr>
				<tr>
					<td><label>手机号:</label></td>
					<td><input class="easyui-textbox" type="text" id="phone" /></td>
					<td><a href="javascript:void(0)" onclick="sendyanzhengma()">发送验证码</a>
					</td>
				</tr>
				<tr>
					<td><label>验证码:</label></td>
					<td><input class="easyui-textbox" type="text" id="yanzheng" /></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>