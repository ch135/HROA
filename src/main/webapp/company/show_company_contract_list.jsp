<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html class="no-js">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>OA办公系统</title>
<meta name="description" content="这是一个 企业合同列表页面给企业">
<meta name="keywords" content="table">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="renderer" content="webkit">
<meta http-equiv="Cache-Control" content="no-siteapp" />
<meta name="apple-mobile-web-app-title" content="Amaze UI" />
<link rel="icon" type="image/png" href="../assets/i/favicon.png">
<link rel="apple-touch-icon-precomposed"
	href="../assets/i/app-icon72x72@2x.png">
<link rel="stylesheet" href="../assets/css/amazeui.min.css" />
<link rel="stylesheet" href="../assets/css/admin.css">
<link rel="stylesheet" type="text/css"
	href="../assets/js/dist/amazeui.page.css">
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
					<strong class="am-text-primary am-text-lg">企业合同列表</strong> 
				</div>
			</div>

			<hr>

			<div class="am-g">
				<form class="am-form" action="/HROA/ComContract/showComContractListToCom.html" method="post" >
					<input id="page" type="text" name="page" value="${page.page }"
						style="visibility: hidden;position: absolute;">
				</form>
			</div>
			<div class="am-g">
				<div class="am-u-sm-12">
					<form class="am-form">
						<table width="100%"
							class="am-table am-table-striped  am-table-compact am-text-nowrap"
							id="data-table">
							<thead>
								<tr>
									<th class=" ">合同编号</th>
									<th class="">企业名称</th>
									<th class="">合同签订人</th>
									<th class="">合同签订人ID</th>
									<th class="">签订人联系电话</th>
									<th class="">操作</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${page.list }" var="comContractList">
								
									<tr>
										<td>${comContractList.contractCode }</td>
										<td>${comContractList.cname }</td>
										<td>${comContractList.writer }</td>
										<td>${comContractList.writerId }</td>
										<td class="am-hide-sm-only">${comContractList.phone }</td>
										<td>
											<div class="am-btn-toolbar">
												<div class="am-btn-group am-btn-group-xs">
													<button type="button" class="am-btn am-btn-default am-text-success"
														onclick="location.href='/HROA/ComContract/showComDetails.html?id=${comContractList.id}'">
														<span class="am-icon-pencil-square-o"></span> 查看
													</button>
													<button type="button" class="am-btn am-btn-default am-text-secondary"
													onclick="location.href='/HROA/ComContract/downFile.html?filename=${comContractList.url}'">
														<span class="am-icon-download"></span> 下载合同
													</button>
												
												</div>
											</div>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<div class="am-cf">
							<div style="float: right;font-size: 12px;">共
								${page.totalRecord } 条记录</div>
							<%-- <div data-am-page="{pages:${page.totalPage },curr:${page.page },jump:'/HROA/ShCompany/listCompanyUI.html?page=%page%'}"></div> --%>
							<div id="page2"></div>
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
	<!-- content end -->

	<a href="#"
		class="am-icon-btn am-icon-th-list am-show-sm-only admin-menu"
		data-am-offcanvas="{target: '#admin-offcanvas'}"></a>

	<footer>
		<hr>
		<p class="am-padding-left">©Copyright &copy;2017 All Rights
			Reserved huizhouxueyuan development team</p>
	</footer>
	<script type="text/javascript" src="../assets/js/dist/jquery.min.js"></script>
	<script type="text/javascript" src="../assets/js/amazeui.min.js"></script>
	<script type="text/javascript" src="../assets/js/app.js"></script>
	<script type="text/javascript" src="../assets/js/dist/amazeui.page.js"></script>
	<script type="text/javascript"
		src="../js/dist/amazeui.datatables.min.js"></script>
	<script type="text/javascript"
		src="../js/dist/dataTables.responsive.min.js"></script>
	<script type="text/javascript" src="../js/dist/amazeui.dialog.js"></script>

	<script type="text/javascript">
		$(function() {
			$('#data-table').DataTable({
				responsive : true,
				dom : 'ti'
			});
		});
		function show(content, confirm) {
			AMUI.dialog.alert({
				title : 'Tip',
				content : content,
				onConfirm : confirm
			});
		}
		function ajax(url, form, after) {
			$.ajax({
				url : url,
				type : "post",
				data : form,
				success : after
			});
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

		function deleteComContract(companyId) {
			do_confirm("确定删除?",
					function() {
						$("form:first").attr(
								"action",
								"/HROA/ComContract/delete.html?id="
										+ companyId);
						$("form:first").submit();
					});
		}

		function searchComContract() {
			$("#page").val(0);
			$("form:first").submit();
		}

		$("#page2").page({
			pages : ${page.totalPage},
			curr : ${page.page},
			first : "首页", //设置false则不显示，默认为false  
			last : "尾页", //设置false则不显示，默认为false      
			prev : false, //若不显示，设置false即可，默认为上一页
			next : false, //若不显示，设置false即可，默认为下一页
			groups : 5, //连续显示分页数
			jump : function(context, first) {
				if (!first) {
					$("#page").val(context.option.curr);
					$("form:first").submit();
				}
			}
		});
	</script>
</body>
</html>
