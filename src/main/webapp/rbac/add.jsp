<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html class="no-js fixed-layout">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>OA办公系统</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="renderer" content="webkit">
	<meta http-equiv="Cache-Control" content="no-siteapp" />
	<link rel="icon" type="image/png" href="assets/i/favicon.png">
	<link rel="apple-touch-icon-precomposed" href="assets/i/app-icon72x72@2x.png">
	<meta name="apple-mobile-web-app-title" content="Amaze UI" />
	<link rel="stylesheet" href="../assets/css/amazeui.min.css"/>
	<link rel="stylesheet" href="../assets/css/admin.css">
    <style type="text/css">
	    html {
	    	font-size: 10px;
	    	-webkit-tap-highlight-color: rgba(0,0,0,0);
		}
	  	@media only screen{
		  	.am-u-sm-2 {
			    width: 24%;
			}
	  	}
		@media screen and (min-width:375px) and (max-width:675px){
		  	.am-u-sm-2 {
			    width: 20%;
			}
	  	}
    </style>
</head>
<body>
	<!-- content start -->
	<div class="admin-content">
		<ol class="am-breadcrumb">
		  <li>位置：<a href="${pageContext.request.contextPath}/rbac/gtUserList.html?pageSize=10&startPage=1">用户管理</a></li>
		  <li class="am-active">用户添加</li>
		</ol>
		<form action="#" method="post" class="am-form formFrame">
			<div class="am-tabs am-margin" data-am-tabs>
				<ul class="am-tabs-nav am-nav am-nav-tabs">
					<li class="am-active"><a href="#tab2">基本信息</a></li>
				</ul>
					<div class="am-tab-panel am-fade am-in am-active" id="tab2">
					
						<div class="am-g am-margin-top">
							<div class="am-u-sm-2 am-text-right">用户账号</div>
							<div class="am-u-sm-8 am-u-md-6 am-u-end">
								<div class="am-form-group ">
									<div class="field">
										<!-- <input type="text" name="name"
											data-validate="required:用户账号不能为空,email:请输入邮箱" placeholder="用户账号"> -->
											<input id="account" type="text" name="account"
											data-validate="required:用户账号不能为空" placeholder="用户账号">
									</div>
								</div>
							</div>
							<span>*</span>
						</div>

						<div class="am-g am-margin-top">
							<div class="am-u-sm-2 am-text-right">用户昵称</div>
							<div class="am-u-sm-8 am-u-md-6 am-u-end">
								<div class="am-form-group ">
									<div class="field">
										<input id="nickname" type="text" name="nickName" data-validate="required:用户昵称不能为空" placeholder="用户昵称">
									</div>
								</div>
							</div>
							<span>*</span>
						</div>

						<div class="am-g am-margin-top">
							<div class="am-u-sm-2 am-text-right">用户密码</div>
							<div class="am-u-sm-8 am-u-md-6 am-u-end">
								<div class="am-form-group ">
									<div class="field">
										<input id="password" type="password" name="pd" data-validate="required:密码不能为空" placeholder="用户密码">
									</div>
								</div>
							</div>
							<span>*</span>
						</div>

						<div class="am-g am-margin-top">
							<div class="am-u-sm-2 am-text-right">重复密码</div>
							<div class="am-u-sm-8 am-u-md-6 am-u-end">
								<div class="am-form-group ">
									<div class="field">
										<input  id="password-again" type="password"  data-validate="required:密码不能为空,repeat#pd:两次密码输入不一致" placeholder="重复密码">
									</div>
								</div>
							</div>
							<span>*</span>
						</div>
						
						<div class="am-g am-margin-top">
							<div class="am-u-sm-2 am-text-right">所属部门</div>
							<div class="am-u-sm-8 am-u-md-6 am-u-end">
								<div class="am-form-group ">
									<div class="field">
										<select id="dpId" name="dpId">
											<option value="0">--选择部门--</option>
											<c:forEach items="${deptList}" var="dp">
												<option value="${dp.id }">${dp.dpname }</option>
											</c:forEach>
										</select>
									</div>
								</div>
							</div>
							<div class="am-u-sm-4"></div>
						</div>
					</div>
				</div>
			<div class="am-margin">
				<button id="addUser" type="button" class="am-btn am-btn-primary">添加</button>
			</div>
		</form>
	<!-- content end -->
	<!-- <footer>
	  <hr>
	  <p class="am-padding-left">©Copyright &copy;2017 All Rights Reserved huizhouxueyuan development team</p>
	</footer> -->
	</div>
</body>
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/amazeui.min.js"></script>
<script src="${pageContext.request.contextPath}/public/am-dialog/dist/amazeui.dialog.min.js"></script>
<script src="${pageContext.request.contextPath}/rbac/js/userAdd.js"></script>
<script type="text/javascript">
</script>
</html>
