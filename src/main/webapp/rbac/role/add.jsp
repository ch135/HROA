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
	<link rel="stylesheet" href="/HROA/assets/css/amazeui.min.css"/>
	<link rel="stylesheet" href="/HROA/assets/css/admin.css">
    <style type="text/css">
     	html {
	    	font-size: 10px;
	    	-webkit-tap-highlight-color: rgba(0,0,0,0);
		}
	  	@media screen and (min-width:300px) and (max-width:330px){
		  	.am-u-sm-2 {
			    width: 22%;
			}
	  	}
    </style>
</head>
<body>
	<!-- content start -->
	<div class="admin-content">
		<ol class="am-breadcrumb">
		  <li>位置：<a href="${pageContext.request.contextPath}/rbac/getRlList.html?pageSize=5&startPage=1">角色管理</a></li>
		  <li class="am-active">角色添加</li>
		</ol>
		<div class="am-g">
			<div class="am-u-lg-5 am-u-md-15 am-u-sm-centered">
				<form class="am-form m-form-horizontal" action="#" method="post">
					<div class="am-g am-margin-top">
						<div class="am-u-sm-2 am-text-right">角色名称</div>
						<div class="am-u-sm-8">
							<div class="am-form-group ">
								<div class="field">
									<input type="text" id="role-name" placeholder="角色名称" name="name">
								</div>
							</div>
						</div>
						<div class="am-u-sm-3"></div>
					</div>
					<div class="am-g am-margin-top">
						<div class="am-u-sm-2 am-text-right">部门</div>
						<div class="am-u-sm-8">
							<div class="am-form-group ">
								<div class="field">
									<select id="dpId" name="dpId">
										<option value="">--选择部门--</option>
										<c:forEach items="${deptList}" var="dp">
											<option value="${dp.id }">${dp.dpname }</option>
										</c:forEach>
									</select>
								</div>
							</div>
						</div>
						<div class="am-u-sm-3"></div>
					</div>
					<div class="am-g am-margin-top">
						<div class="am-u-sm-2 am-text-right">角色描述</div>
						<div class="am-u-sm-8">
							<div class="am-form-group">
								<textarea class="" rows="5" id="role-intro" placeholder="简单描述......"></textarea>
					            <small>100字以内...</small>
							</div>
						</div>
						<div class="am-u-sm-3"></div>
					</div>
					
					<div class="am-form-group">
						<div class="am-u-sm-9 am-u-sm-push-3">
							<input id="subRole" type="button" class="am-btn am-btn-primary" value="添加" />
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
		<!-- content end -->
	<footer>
	    <hr>
	    <p class="am-padding-left">©Copyright &copy;2017 All Rights Reserved huizhouxueyuan development team</p>
	</footer>
</body>
<script src="/HROA/js/jquery.min.js"></script>
<script src="/HROA/assets/js/amazeui.min.js"></script>
<script src="${pageContext.request.contextPath}/public/am-dialog/dist/amazeui.dialog.min.js"></script>
<script type="text/javascript">
	$("#subRole").click(function(){
		$.ajax({
			url:"/HROA/rbac/addRole.html",
			type:'post',
			data:{roleName:$('#role-name').val(),dpId:$('#dpId').val(),roleIntro:$('#role-intro').val()},
			dataType:'json',
			success:function(data){
				if(data.status==1){
					AMUI.dialog.alert({
				    	title: '提示',
				    	content: '角色添加成功!',
				    	onConfirm: function() {
				      		location.reload();
				    	}
				  	});
				}else if(data.status==0){
					AMUI.dialog.alert({
				    	title: '提示',
				    	content: '角色添加失败!',
				    	onConfirm: function() {
				      		location.reload();
				    	}
				  	});
				}else if(data.status==2){
					AMUI.dialog.alert({
				    	title: '提示',
				    	content: '角色已存在!',
				    	onConfirm: function() {
				      		/* location.reload(); */
				    	}
				  	});
				} 
			}
		});
	})
</script>
</html>