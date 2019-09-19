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
	<link rel="stylesheet" href="/HROA/public/layui/css/layui.css">
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
		  <li>位置：<a href="${pageContext.request.contextPath}/rbac/role/list.jsp">公告管理</a></li>
		  <li class="am-active">公告添加</li>
		</ol>
		<div class="am-g">
			<div class="am-u-sm-12 am-u-md-12 am-u-lg-8 am-u-sm-centered">
				<form class="am-form m-form-horizontal" action="#" method="post">
					<div class="am-g am-margin-top">
						<div class="am-u-sm-1 am-text-right">标题</div>
						<div class="am-u-sm-10">
							<div class="am-form-group ">
								<div class="field">
									<input type="text" id="notice-title" placeholder="公告名称" name="name">
								</div>
							</div>
						</div>
						<div class="am-u-sm-1"></div>
					</div>
					<div class="am-g am-margin-top">
						<div class="am-u-sm-1 am-text-right">内容</div>
						<div class="am-u-sm-10">
							<div class="am-form-group">
								<textarea id="demo" style="display: none;"></textarea>
							</div>
						</div>
						<div class="am-u-sm-2"></div>
					</div>
					
					<div class="am-form-group">
						<div class="am-u-sm-9 am-u-sm-push-3">
							<input id="addNotice" type="button" class="am-btn am-btn-primary" value="添加" />
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
	</footer>	 -->
</body>
<script src="/HROA/js/jquery.min.js"></script>
<script src="/HROA/assets/js/amazeui.min.js"></script>
<script src="${pageContext.request.contextPath}/public/am-dialog/dist/amazeui.dialog.min.js"></script>
<script src="/HROA/public/layui/layui.js"></script>
<script type="text/javascript">
var index,a,layedit;
layui.use('layedit', function(){
	layedit = layui.layedit;
	layedit.set({
		uploadImage: {
			url:'/HROA/notice/upImg.html' //接口url
			,type: 'post' //默认post
		}
	});
	index=layedit.build('demo', {
		tool: ['strong' //加粗
		       ,'italic' //斜体
		       ,'underline' //下划线
		       ,'del' //删除线
		       ,'|' //分割线
		       ,'left' //左对齐
		       ,'center' //居中对齐
		       ,'right' //右对齐
		       ,'link' //超链接
		       ,'unlink' //清除链接
		       /* ,'face' //表情 */
		       ,'image' //插入图片
		       /* ,'help' //帮助 */
		       ]
	});
	
});

$("#addNotice").click(function(){
	var noticeTxt=layedit.getContent(index);
	alert(noticeTxt);
	$.ajax({
		url:"/HROA/notice/addNotice.html",
		type:'post',
		data:{noticeTxt:noticeTxt,noticeTitle:$("#notice-title").val()},
		dataType:'json',
		success:function(data){
			if(data.status==1){
				AMUI.dialog.alert({
			    	title: '提示',
			    	content: '公告添加成功!',
			    	onConfirm: function() {
			      		console.log('close');
			      		location.reload();
			    	}
			  	});
			}
			if(data.status==0){
				AMUI.dialog.alert({
			    	title: '提示',
			    	content: '公告添加失败!',
			    	onConfirm: function() {
			      		console.log('close');
			      		location.reload();
			    	}
			  	});
			}
		}
	});
})
</script>
</html>