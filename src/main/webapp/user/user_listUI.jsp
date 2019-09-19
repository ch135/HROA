<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html class="no-js">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>OA办公系统</title>
<meta name="description" content="这是一个 table 页面">
<meta name="keywords" content="table">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="renderer" content="webkit">
<meta http-equiv="Cache-Control" content="no-siteapp" />
<meta name="apple-mobile-web-app-title" content="Amaze UI" />
<link rel="icon" type="image/png" href="../assets/i/favicon.png">
<link rel="apple-touch-icon-precomposed" href="../assets/i/app-icon72x72@2x.png">
<link rel="stylesheet" href="../assets/css/amazeui.min.css" />
<link rel="stylesheet" href="../assets/css/admin.css">
<link rel="stylesheet" type="text/css" href="../assets/js/dist/amazeui.page.css">
<link rel="stylesheet" href="../js/dist/amazeui.datatables.min.css">

</head>
<body>
	<!--[if lte IE 9]>
<p class="browsehappy">你正在使用<strong>过时</strong>的浏览器，Amaze UI 暂不支持。 请 <a href="http://browsehappy.com/" target="_blank">升级浏览器</a>
  以获得更好的体验！</p>
<![endif]-->

	<!-- content start -->
	<div class="admin-content">
		<div class="admin-content-body">
			<div class="am-cf am-padding am-padding-bottom-0">
				<div class="am-fl am-cf">
					<strong class="am-text-primary am-text-lg">用户列表</strong> / <small>Company</small>
				</div>
			</div>
			<hr>
			<div class="am-g">
				<div class="am-u-sm-9 am-u-md-6" style="margin-bottom: 10px;">
					<div class="am-btn-toolbar">
						<div class="am-btn-group am-btn-group-xs">
						</div>
					</div>
				</div>
				<div class="am-u-sm-3 am-u-md-6 am-show-sm-only " style="margin-bottom: 10px;">
					<div class="am-btn-group am-btn-group-xs  am-fr">
						<button class="am-btn am-btn-default " data-am-collapse="{target: '#topbar-collapse'}">
							<span class="am-sr-only">导航切换</span> 搜索<span class="am-icon-search"></span>
						</button>
					</div>
				</div>
				<div class="am-collapse am-topbar-collapse " id="topbar-collapse">
					<form class="am-form" action="/HROA/ShUser/listUserUI.html" method="post">
						<div class="am-u-sm-12 am-u-md-2">
							<div class="am-form-group am-input-group-sm">
								<select class="am-form-field" name="searchType">
									<option value="telephone" ${searchType=='telephone'?'selected':'' }>电话</option>
									<option value="realname" ${searchType=='realname'?'selected':'' }>姓名</option>
									<option value="idcard" ${searchType=='idcard'?'selected':'' }>身份证</option>
								</select>
							</div>
						</div>
						<input id="page" type="text" name="page" value="${page.page }" style="visibility: hidden;position: absolute;">
						<div class="am-u-sm-12 am-u-md-3">
							<div class="am-input-group am-input-group-sm">
								<input type="text" class="am-form-field" name="searchValue" value="${searchValue }"> <span class="am-input-group-btn">
									<button class="am-btn am-btn-default" type="button" onclick="do_search()">搜索</button>
								</span>
							</div>
						</div>
					</form>
				</div>
			</div>
			
			
			<div class="am-g">
				<div class="am-u-sm-12">
					<form class="am-form">
						<table width="100%" class="am-table am-table-striped  am-table-compact am-text-nowrap"  id="data-table">
							<thead>
								<tr>
									<th class="">编号</th>
									<th class="">姓名</th>
									<th class="">性别</th>
									<th class="">电话</th>
									<th class=" ">身份证</th>
									<th class="">操作</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${page.list }" var="item">
									<tr>
										<td>${item.id }</td>
										<td>${item.realname }</td>
										<td>${item.sex }</td>
										<td>${item.telephone }</td>
										<td class="am-hide-sm-only">${item.idcard }</td>
										<td>
												<div class="am-btn-group am-btn-group-xs">
													<button  type="button"  class="am-btn am-btn-default" onclick="location.href='/HROA/ShUser/showShUserUI.html?userId=${item.id}'">
														 查看
													</button>
													<button  type="button"  class="am-btn am-btn-default" onclick="location.href='/HROA/ShUser/editShUserUI.html?userId=${item.id}'">
														编辑
													</button>
													<button type="button" class="am-btn am-btn-default"  onclick="location.href='/HROA/EnterCom/listEnterComUserUI.html?shUser.id=${item.id}'">
														入职记录
													</button>
													<button type="button" class="am-btn am-btn-default" onclick="doDelete(${item.id})">
														删除
													</button>
												</div>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<div class="am-cf">
							<div style="float: right;font-size: 12px;">共 ${page.totalRecord } 条记录</div>
							<div id="page2" data-am-page="{pages:${page.totalPage },curr:${page.page },jump:'/HROA/ShUser/listUserUI.html?page=%page%&searchType=${searchType}&searchValue=${searchValue}'}"></div>
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
	<!-- content end -->

	<a href="#" class="am-icon-btn am-icon-th-list am-show-sm-only admin-menu" data-am-offcanvas="{target: '#admin-offcanvas'}"></a>

	<footer>
		<hr>
		<p class="am-padding-left">©Copyright &copy;2017 All Rights Reserved huizhouxueyuan development team</p>
	</footer>

	<script type="text/javascript" src="../assets/js/dist/jquery.min.js"></script>
	<script type="text/javascript" src="../assets/js/amazeui.min.js"></script>
	<script type="text/javascript" src="../assets/js/app.js"></script>
	<script type="text/javascript" src="../assets/js/dist/amazeui.page.js"></script>
	<script type="text/javascript" src="../js/dist/amazeui.datatables.min.js"></script>
	<script type="text/javascript" src="../js/dist/dataTables.responsive.min.js"></script>
	<script type="text/javascript" src="../js/dist/amazeui.dialog.js"></script>
	<script type="text/javascript">
		$(function(){
			 $('#data-table').DataTable({
			  responsive: true,
			  dom: 'ti'
			});
		});
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
		function doDelete(id) {
			do_confirm("确定删除？", function() {
				$("form:first").attr("action","/HROA/ShUser/deleteShUserUI.html?userId=" + id);
				$("form:first").submit();
			});
		}
		function do_search() {
			$("#page").val(0);
			$("form:first").submit();
		}
	</script>
</body>
</html>
