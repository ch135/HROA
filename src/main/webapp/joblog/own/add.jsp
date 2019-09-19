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
		  <li>位置：<a href="${pageContext.request.contextPath}/joblog/own/logList.jsp">我的日报</a></li>
		  <li class="am-active">日报添加</li>
		</ol>
		<div class="am-g">
			<div class="am-u-lg-5 am-u-md-15 am-u-sm-centered">
				<form class="am-form m-form-horizontal" action="#" method="post">
					<div class="am-g am-margin-top">
						<div class="am-u-sm-2 am-text-right">日报名称</div>
						<div class="am-u-sm-8">
							<div class="am-form-group ">
								<div class="field">
									<input type="text" id="jbLog-title" placeholder="日报名称" name="name">
								</div>
							</div>
						</div>
						<div class="am-u-sm-3"></div>
					</div>
					<div class="am-g am-margin-top">
						<div class="am-u-sm-2 am-text-right">日报内容</div>
						<div class="am-u-sm-8">
							<div class="am-form-group">
								<textarea class="" rows="5" id="jbLog-content" placeholder="输入内容"></textarea>
					            <small>1000字以内...</small>
							</div>
						</div>
						<div class="am-u-sm-3"></div>
					</div>
					
					<div class="am-form-group">
						<div class="am-u-sm-9 am-u-sm-push-3">
							<input id="addJbLog" type="button" class="am-btn am-btn-primary" value="添加" />
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
/* if($("#hidden-dpId").val()!=null&&$("#hidden-dpId").val()!=""){
	$("#add").hide();
	$("#alert").css("display","block");
	$("#deptName").val($("#hidden-dpName").val());
} */
$(document).ready(function(){
	$("#addJbLog").click(function(){
		$.ajax({
			url:"/HROA/jbLog/addJbLog.html",
			type:'post',
			data:{title:$('#jbLog-title').val(),content:$("#jbLog-content").val(),classfy:1},
			dataType:'json',
			success:function(data){
				if(data.status>0){
					AMUI.dialog.alert({
				    	title: '提示',
				    	content: '日报添加成功!',
				    	onConfirm: function() {
				      		/* location.reload(); */
				    	}
				  	});
				}else{
					AMUI.dialog.alert({
				    	title: '提示',
				    	content: '日报添加失败!',
				    	onConfirm: function() {
				      		/* location.reload(); */
				    	}
				  	});
				} 
			}
		});
	})
})
</script>
</html>