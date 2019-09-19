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
	<meta name="apple-mobile-web-app-title" content="Amaze UI" />
	<link rel="icon" type="image/png" href="/HROA/assets/i/favicon.png">
	<link rel="apple-touch-icon-precomposed" href="/HROA/assets/i/app-icon72x72@2x.png">
	<link rel="stylesheet" href="/HROA/assets/css/amazeui.min.css"/>
	<link rel="stylesheet" href="/HROA/assets/css/admin.css">
</head>

<body>
	<!-- content start -->
	<div class="admin-content">
		<div class="am-cf am-padding am-padding-bottom-0">
        	<div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">系统公告</strong> / <small>公告列表</small></div>
      	</div>
      	<hr>
		<div class="am-g">
			<div class="am-u-sm-12 am-u-md-6">
			    <div class="am-btn-toolbar">
			      	<div class="am-btn-group am-btn-group-xs">
				        <button id="addRole" type="button" class="am-btn am-btn-default">
				        	<span class="am-icon-plus"></span>新增
				        </button>
			      	</div>
			    </div>
		  	</div>
		</div>
		<hr>
		<div class="am-g">
	        <div class="am-u-sm-12">
	          	<table class="am-table am-table-bd am-table-striped admin-content-table">
		            <thead>
			            <tr>
			              	<th style="width:20%;">编号</th>
			              	<th style="width:10%;">标题</th>
			              	<th style="width:10%;">发布人</th>
			              	<th style="width:20%;">时间</th>
			              	<th style="width:10%;">状态</th>
			              	<th style="width:20%;">管理</th>
			            </tr>
		            </thead>
	            <tbody>
	            <tr>
		            <td>1</td>
		            <td>John Clark</td>
		            <td><a href="#">Business management</a></td> 
		            <td><span class="am-badge am-badge-success">+20</span></td>
		            <td><span class="am-badge am-badge-success">未发布</span></td>
		            <td>
		                <div class="am-dropdown" data-am-dropdown>
		                  <button class="am-btn am-btn-default am-btn-xs am-dropdown-toggle" data-am-dropdown-toggle><span class="am-icon-cog"></span> <span class="am-icon-caret-down"></span></button>
		                  <ul class="am-dropdown-content">
		                    <li><a href="#">1. 编辑</a></li>
		                    <li><a href="#">2. 下载</a></li>
		                    <li><a href="#">3. 删除</a></li>
		                  </ul>
		                </div>
		            </td>
	            </tr>
	            </tbody>
	          	</table>
	        </div>
      	</div>
	</div>
	<!-- content end -->
<!-- <footer>
   <hr>
   <p class="am-padding-left">©Copyright &copy;2017 All Rights Reserved huizhouxueyuan development team</p>
</footer> -->
<script src="/HROA/js/jquery.min.js"></script>
<script src="/HROA/assets/js/amazeui.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$('#addRole').on('click',function(){
		window.location.href="/HROA/notice/add.jsp";
	});
	$("#assginPrev").on('click',function(){
		window.location.href="/HROA/rbac/role/prev.jsp";
	});
})
</script>
</body>
</html>