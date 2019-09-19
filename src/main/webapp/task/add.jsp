<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
	<link rel="icon" type="image/png" href="${pageContext.request.contextPath}/assets/i/favicon.png">
	<link rel="apple-touch-icon-precomposed" href="${pageContext.request.contextPath}/assets/i/app-icon72x72@2x.png">
	<meta name="apple-mobile-web-app-title" content="Amaze UI" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/amazeui.min.css"/>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin.css">
</head>
	<style>
		.dept-name{
			margin-top:5px;
		}
	</style>
<body>
	<!-- content start -->
	<div class="admin-content">
		<ol class="am-breadcrumb">
		  <li>位置：<a href="${pageContext.request.contextPath}/task/list.jsp">任务列表</a></li>
		  <li class="am-active">任务添加</li>
		</ol>
		<div class="am-g">
			<div class="am-u-sm-8 am-u-md-12 am-u-lg-5 am-u-sm-centered">
				<form action="#" method="post" class="am-form">
				<div class="am-g am-margin-top">
						<div class="am-u-sm-2 am-text-right">标题</div>
						<div class="am-u-sm-8">
							<div class="am-form-group ">
								<div class="field">
									<input type="text" id="task-title" placeholder="任务标题" name="name">
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
						<div class="am-u-sm-2 am-text-right">任务内容</div>
						<div class="am-u-sm-8">
							<div class="am-form-group">
								<textarea class="" rows="5" id="task-content" placeholder="描述......"></textarea>
					            <small>200字以内...</small>
							</div>
						</div>
						<div class="am-u-sm-3"></div>
					</div>
				  	<div class="am-form-group">
				    	<div class="am-u-sm-10 am-u-sm-offset-2">
				      		<button id="addTask" type="button" class="am-btn am-btn-primary">提交</button>
				    	</div>
				  	</div>
				</form>
			</div>
		</div>
	</div>
	<!-- content end -->
<!-- <footer>
    <hr>
    <p class="am-padding-left">©Copyright &copy;2017 All Rights Reserved huizhouxueyuan development team</p>
</footer> -->
</body>
<input type="hidden" id="hidden-dpId" value="${deptInfo.id}">
<input type="hidden" id="hidden-dpName" value="${deptInfo.dpname}">
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/amazeui.min.js"></script>
<script src="${pageContext.request.contextPath}/public/am-dialog/dist/amazeui.dialog.min.js"></script>
<script type="text/javascript">
if($("#hidden-dpId").val()!=null&&$("#hidden-dpId").val()!=""){
	$("#add").hide();
	$("#alert").css("display","block");
	$("#deptName").val($("#hidden-dpName").val());
}
$(document).ready(function(){
	$("#addTask").click(function(){
		$.ajax({
			url:"/HROA/task/addTask.html",
			type:'post',
			data:{deptId:$('#dpId').val(),title:$("#task-title").val(),content:$("#task-content").val()},
			dataType:'json',
			success:function(data){
				if(data.status>0){
					AMUI.dialog.alert({
				    	title: '提示',
				    	content: '任务添加成功!',
				    	onConfirm: function() {
				      		/* location.reload(); */
				    	}
				  	});
				}else{
					AMUI.dialog.alert({
				    	title: '提示',
				    	content: '任务添加失败!',
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
