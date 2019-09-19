<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html class="no-js">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>OA办公系统</title>
<meta name="description" content="这是一个 给经理查看代理合同页面">
<meta name="keywords" content="user">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="renderer" content="webkit">
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="icon" type="image/png" href="../assets/i/favicon.png">
<link rel="apple-touch-icon-precomposed"
	href="../assets/i/app-icon72x72@2x.png">
<meta name="apple-mobile-web-app-title" content="Amaze UI" />
<link rel="stylesheet" href="../assets/css/amazeui.min.css" />
<link rel="stylesheet" href="../assets/css/admin.css">
</head>
<body>

	<div class="admin-content">
		<div class="admin-content-body">
			<div class="am-cf am-padding am-padding-bottom-0">
				<div class="am-fl am-cf">
					<strong class="am-text-primary am-text-lg">代理合同信息</strong> 
				</div>
			</div>

			<hr />

			<div class="am-g">
				<div class="am-u-sm-12 am-u-md-4 am-u-md-push-8"></div>

				<div class="am-u-sm-12 am-u-md-8 am-u-md-pull-4">
					<form class="am-form am-form-horizontal" enctype="multipart/form-data">
						<div class="am-form-group">
							<label for="user-name" class="am-u-sm-3 am-form-label">代理名称
							</label>
							<div class="am-u-sm-9">
								<input name="agentName" type="text" value="${agentContract.name }" id="agentName"
									placeholder="代理名称 " disabled="disabled">
							</div>
						</div>

						<div class="am-form-group">
							<label for="user-name" class="am-u-sm-3 am-form-label">代理ID
							</label>
							<div class="am-u-sm-9">
								<input name="agentId" type="text" id="agentId" disabled="disabled" value="${agentContract.agentId }" placeholder="代理ID">
							</div>
						</div>

						<div class="am-form-group am-form-inline">
							<label for="user-email" class="am-u-sm-3 am-form-label">地址
							</label>
							<div class="am-form-group am-u-sm-3">
								<select id="s_province" name="province" disabled="disabled">
									<option value="option1">选项一...</option>
									<option value="option2">选项二.....</option>
									<option value="option3">选项三........</option>
								</select> <span class="am-form-caret"></span>
							</div>
							<div class="am-form-group am-u-sm-3">
								<select id="s_city" name="city" disabled="disabled">
									<option value="option1">选项一...</option>
									<option value="option2">选项二.....</option>
									<option value="option3">选项三........</option>
								</select> <span class="am-form-caret"></span>
							</div>
							<div class="am-form-group am-u-sm-3">
								<select id="s_county" name="county" disabled="disabled">
									<option value="option1">选项一...</option>
									<option value="option2">选项二.....</option>
									<option value="option3">选项三........</option>
								</select> <span class="am-form-caret"></span>
							</div>
						</div>

						<div class="am-form-group">
							<label for="user-phone" class="am-u-sm-3 am-form-label">详细地址
							</label>
							<div class="am-u-sm-9">
								<input type="tel" name="agentDetails" disabled="disabled" value="${agentContract.details }" id="agentDetails"
									placeholder="详细地址">
							</div>
						</div>

						<div class="am-form-group">
							<label for="user-name" class="am-u-sm-3 am-form-label">代理学校
							</label>
							<div class="am-u-sm-9">
								<input name="agentSchool" type="text" disabled="disabled" value="${agentContract.school }" id="agentSchool"
									placeholder="代理学校">
							</div>
						</div>

						<div class="am-form-group">
							<label for="user-name" class="am-u-sm-3 am-form-label">代理电话
							</label>
							<div class="am-u-sm-9">
								<input name="agentPhone" type="text" disabled="disabled" value="${agentContract.phone }"id="agentPhone"
									placeholder="代理电话">
							</div>
						</div>

						<div class="am-form-group">
							<label for="user-name" class="am-u-sm-3 am-form-label">签订日期
							</label>
							<div class="am-u-sm-9">
								<input name="signDate" type="date" id="signDate"  disabled="disabled" value="${agentContract.signDate }"placeholder="签订日期">
							</div>
						</div>

						<div class="am-form-group">
							<div class="am-u-sm-9 am-u-sm-push-3">
								<button onclick="location.href='/HROA/AgentContract/downFile.html?filename=${agentContract.url}'"
								 type="button" class="am-btn am-btn-primary am-btn-block">下载合同</button>
							</div>
						</div>

					</form>
				</div>
			</div>
		</div>

		<footer class="admin-content-footer">
			<hr>
			<p class="am-padding-left">© 2014 AllMobilize, Inc. Licensed
				under MIT license.</p>
		</footer>

	</div>


	<a href="#"
		class="am-icon-btn am-icon-th-list am-show-sm-only admin-menu"
		data-am-offcanvas="{target: '#admin-offcanvas'}"></a>

	<footer>
		<hr>
		<p class="am-padding-left">©Copyright &copy;2017 All Rights
			Reserved huizhouxueyuan development team</p>
	</footer>

	<!--[if lt IE 9]>
<script src="http://libs.baidu.com/jquery/1.11.3/jquery.min.js"></script>
<script src="http://cdn.staticfile.org/modernizr/2.8.3/modernizr.js"></script>
<script src="assets/js/amazeui.ie8polyfill.min.js"></script>
<![endif]-->

	<script src="../assets/js/jquery.min.js"></script>
	<script src="../assets/js/amazeui.min.js"></script>

	<script src="../assets/js/app.js"></script>
	<script class="resources library" src="/HROA/company/js/area.js"
		type="text/javascript"></script>
	<script type="text/javascript" src="../js/dist/amazeui.dialog.js"></script>

	<script type="text/javascript">
		_init_area();
	</script>
	<script type="text/javascript">
		var Gid = document.getElementById;
		var showArea = function() {
			Gid('show').innerHTML = "<h3>省" + Gid('s_province').value + " - 市"
					+ Gid('s_city').value + " - 县/区" + Gid('s_county').value
					+ "</h3>"
		}
		/* Gid('s_county').setAttribute('onchange','showArea()');
		 */
		 
 window.onload=function(){
 $("#s_province").find("option[value='${agentContract.province}']").attr("selected",true);
 $("#s_province").trigger("change");
 $("#s_city").find("option[value='${agentContract.city}']").attr("selected",true);
 $("#s_city").trigger("change");
 $("#s_county").find("option[value='${agentContract.county}']").attr("selected",true);
}
		function do_confirm(content, do_confirm_after) {
			AMUI.dialog.confirm({
				title : '提示',
				content : content,
				onConfirm : do_confirm_after,
				onCancel : function() {
					console.log('onCancel')
				}
			});
		}

	</script>
</body>
</html>
