<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html class="no-js">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>OA办公系统</title>
<meta name="description" content="这是一个 user 页面">
<meta name="keywords" content="user">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="renderer" content="webkit">
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="icon" type="image/png" href="../assets/i/favicon.png">
<link rel="apple-touch-icon-precomposed" href="../assets/i/app-icon72x72@2x.png">
<meta name="apple-mobile-web-app-title" content="Amaze UI" />
<link rel="stylesheet" href="../assets/css/amazeui.min.css" />
<link rel="stylesheet" href="../assets/css/admin.css">
</head>
<body>

	<div class="admin-content">
		<div class="admin-content-body">
			<div class="am-cf am-padding am-padding-bottom-0">
				<div class="am-fl am-cf">
					<strong class="am-text-primary am-text-lg">学生资料</strong> / <small>Personal information</small>
				</div>
			</div>

			<hr />

			<div class="am-g">
				<div class="am-u-sm-12 am-u-md-4 am-u-md-push-8"></div>

				<div class="am-u-sm-12 am-u-md-8 am-u-md-pull-4">
					<form id="form_user" class="am-form am-form-horizontal" action="/HROA/ShUser/applyShUser.html">
						<div class="am-form-group">
							<label for="user-name" class="am-u-sm-3 am-form-label">学生姓名</label>
							<div class="am-u-sm-9">
								<input name="realname" type="text" id="name" placeholder="姓名 / Name" required>
							</div>
						</div>


						<div class="am-form-group">
							<label for="user-name" class="am-u-sm-3 am-form-label">性别</label>
							<div class="am-u-sm-9">
								<label class="am-radio-inline"> <input type="radio" value="男" name="sex" required>男
								</label> <label class="am-radio-inline"> <input type="radio" value="女" name="sex">女
								</label>
							</div>
						</div>

						<div class="am-form-group">
							<label for="user-phone" class="am-u-sm-3 am-form-label">联系电话</label>
							<div class="am-u-sm-9">
								<input type="tel" name="telephone" id="user-phone" placeholder="联系电话 / Telephone" required>
							</div>
						</div>

						<div class="am-form-group">
							<label for="user-QQ" class="am-u-sm-3 am-form-label">身份证</label>
							<div class="am-u-sm-9">
								<input name="idcard" type="text" id="idcard" placeholder="身份证 / IdCard" required>
							</div>
						</div>
						<hr>

						<div class="am-form-group">
							<div class="am-u-sm-9 am-u-sm-push-3">
								<button id="addUser" type="button" class="am-btn am-btn-primary am-btn-block">添加用户信息</button>
							</div>
						</div>

					</form>
				</div>
			</div>
		</div>

		<footer class="admin-content-footer">
			<hr>
			<p class="am-padding-left">© 2014 AllMobilize, Inc. Licensed under MIT license.</p>
		</footer>

	</div>


	<a href="#" class="am-icon-btn am-icon-th-list am-show-sm-only admin-menu" data-am-offcanvas="{target: '#admin-offcanvas'}"></a>

	<footer>
		<hr>
		<p class="am-padding-left">©Copyright &copy;2017 All Rights Reserved huizhouxueyuan development team</p>
	</footer>

	<!--[if lt IE 9]>
<script src="http://libs.baidu.com/jquery/1.11.3/jquery.min.js"></script>
<script src="http://cdn.staticfile.org/modernizr/2.8.3/modernizr.js"></script>
<script src="assets/js/amazeui.ie8polyfill.min.js"></script>
<![endif]-->

	<script type="text/javascript" src="../assets/js/dist/jquery.min.js"></script>
	<script type="text/javascript" src="../assets/js/amazeui.min.js"></script>
	<script type="text/javascript" src="../assets/js/app.js"></script>
	<script type="text/javascript" src="../assets/js/dist/amazeui.page.js"></script>
	<script type="text/javascript" src="../js/dist/amazeui.datatables.min.js"></script>
	<script type="text/javascript" src="../js/dist/dataTables.responsive.min.js"></script>
	<script type="text/javascript" src="../js/dist/amazeui.dialog.js"></script>
	<script type="text/javascript">
		function do_confirm(content,do_confirm_after){
			 AMUI.dialog.confirm(
			 { title: '提示', 
			   content: content, 
			   onConfirm: do_confirm_after, 
			   onCancel: function() { console.log('onCancel') 
			  } });
		}
		$("#addUser").bind('click', function(){
			do_confirm("确定提交?",function(){
				$("form:first").submit();
			});
		});
		$('#form_user').validator({
		    onValid: function(validity) {
		      $(validity.field).closest('.am-form-group').find('.am-alert').hide();
		    },
		
		    onInValid: function(validity) {
		      var $field = $(validity.field);
		      var $group = $field.closest('.am-form-group');
		      var $alert = $group.find('.am-alert');
		      // 使用自定义的提示信息 或 插件内置的提示信息
		      var msg = $field.data('validationMessage') || this.getValidationMessage(validity);
		      $alert.html(msg).show();
		    }
	  });
	</script>
</body>
</html>
