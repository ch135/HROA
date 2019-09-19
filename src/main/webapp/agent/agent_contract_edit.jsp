<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html class="no-js">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>OA办公系统</title>
<meta name="description" content="这是一个 代理合同编辑修改页面">
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
					<strong class="am-text-primary am-text-lg">代理合同编辑</strong>  
				</div>
			</div>

			<hr />

			<div class="am-g">
				<div class="am-u-sm-12 am-u-md-4 am-u-md-push-8"></div>

				<div class="am-u-sm-12 am-u-md-8 am-u-md-pull-4">
					<form class="am-form am-form-horizontal" action="${pageContext.request.contextPath}/AgentContract/edit.html" Method="post" enctype="multipart/form-data" data-am-validator>
						<div class="am-form-group">
							<label for="user-name" class="am-u-sm-3 am-form-label">代理名称
							</label>
							<div class="am-u-sm-9">
								<input name="agentName" type="text" required value="${agentContract.name }" id="agentName"
									placeholder="代理名称 ">
							</div>
						</div>

						<div class="am-form-group">
							<label for="user-name" class="am-u-sm-3 am-form-label">代理ID
							</label>
							<div class="am-u-sm-9">
								<input name="agentId" type="number" id="agentId"  required value="${agentContract.agentId }" placeholder="代理ID">
							</div>
						</div>

						<div class="am-form-group am-form-inline">
							<label for="user-email" class="am-u-sm-3 am-form-label">地址
							</label>
							<div class="am-form-group am-u-sm-3">
								<select id="s_province" name="province" required>
									<option value="option1">选项一...</option>
									<option value="option2">选项二.....</option>
									<option value="option3">选项三........</option>
								</select> <span class="am-form-caret"></span>
							</div>
							<div class="am-form-group am-u-sm-3">
								<select id="s_city" name="city" required>
									<option value="option1">选项一...</option>
									<option value="option2">选项二.....</option>
									<option value="option3">选项三........</option>
								</select> <span class="am-form-caret"></span>
							</div>
							<div class="am-form-group am-u-sm-3" required>
								<select id="s_county" name="county">
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
								<input type="tel" name="agentDetails" required value="${agentContract.details }" id="agentDetails"
									placeholder="详细地址">
							</div>
						</div>

						<div class="am-form-group">
							<label for="user-name" class="am-u-sm-3 am-form-label">代理学校
							</label>
							<div class="am-u-sm-9">
								<input name="agentSchool" type="text" required value="${agentContract.school }" id="agentSchool"
									placeholder="代理学校">
							</div>
						</div>

						<div class="am-form-group">
							<label for="user-name" class="am-u-sm-3 am-form-label">代理电话
							</label>
							<div class="am-u-sm-9">
								<input name="agentPhone" type="text" required value="${agentContract.phone }"id="agentPhone" class="js-pattern-mobile"
									placeholder="代理电话">
							</div>
						</div>

						<div class="am-form-group">
							<label for="user-name" class="am-u-sm-3 am-form-label">签订日期
							</label>
							<div class="am-u-sm-9">
								<input name="signDate" type="date" id="signDate" required value="${agentContract.signDate }"placeholder="签订日期">
							</div>
						</div>

						<div class="am-form-group am-form-file">
							<label for="user-name" class="am-u-sm-3 am-form-label">合同文件
							</label>
							<div class="am-u-sm-9">
								<button type="button" class="am-btn am-btn-danger am-btn-sm">
									<i class="am-icon-cloud-upload"></i> 上传要更新的的合同文件（可不选）
								</button>
								<input id="doc-form-file" type="file" name="agentContract"  multiple>
							</div>
							<input type="text" value="${agentContract.id }" name="id"  style="display:none">
							<div class="am-u-sm-9">
							<!-- <span class="am-badge">' + this.name
									+ '</span> ' -->
								<div id="file-list"><span class="am-badge">原来保存的文件：${agentContract.contractCode }</span></div>
							</div>
						</div>

						<div class="am-form-group">
							<div class="am-u-sm-9 am-u-sm-push-3">
								<button  type="submit"
									class="am-btn am-btn-primary am-btn-block">修改代理合同信息</button>
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
	if ( $.AMUI.validator) {
   		 $.AMUI.validator.patterns.mobile = /^\s*1\d{10}\s*$/;
 		 }
 		 
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

		$(function() {
			$('#doc-form-file').on(
					'change',
					function() {
						var fileNames = '';
						$.each(this.files, function() {
							fileNames += '<span class="am-badge">' + '将要更新的文件：'+this.name
									+ '</span> ';
						});
						$('#file-list').html(fileNames);
						
					});
		});
/* 		
		function editAgentContract(){
	do_confirm("确认修改?", function() {
		$("form:first").submit();
	});
} */
	</script>
</body>
</html>
