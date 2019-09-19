<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>OA办公系统</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="renderer" content="webkit">
	<meta http-equiv="Cache-Control" content="no-siteapp" />
	<link rel="icon" type="image/png" href="/HROA/assets/i/favicon.png">
	<link rel="apple-touch-icon-precomposed" href="/HROA/assets/i/app-icon72x72@2x.png">
	<meta name="apple-mobile-web-app-title" content="Amaze UI" />
	<link rel="stylesheet" href="/HROA/assets/css/amazeui.min.css"/>
	<link rel="stylesheet" href="/HROA/assets/css/admin.css">
</head>
<body>
	<!-- content start -->
	<div class="admin-content">
		<div class="am-cf am-padding am-padding-bottom-0">
        	<div class="am-fl am-cf">
        		<strong class="am-text-primary am-text-lg">用户中心</strong>/<small>系统部门管理</small>
        	</div>
      	</div>
      	<hr>
      	
		<div class="am-g">
			<div class="am-u-md-6 am-cf">
				<div class="am-fl am-cf">
					<div class="am-btn-toolbar am-fl">
						<div class="am-btn-group am-btn-group-xs">
							<a class="am-btn am-btn-default" href="${pageContext.request.contextPath}/rbac/department/add.jsp">
								<span class="am-icon-plus"></span>新增
							</a>
						</div>
					</div>
				</div>
			</div>
		</div>
		<hr>
		
		<div class="am-g">
			<div class="am-u-sm-12">
				<table class="am-table am-table-bordered am-table-radius box-shadow">
					<thead>
						<tr>
							<th>编号</th>
							<th>部门名称</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${deptList}" var="dp">
							<tr>
								<td>${dp.id}</td>
								<td>${dp.dpname}</td>
								<td>
									<div class="am-btn-toolbar">
										<div class="am-btn-group am-btn-group-xs">
											<button id="alert-dpname" class="am-btn am-btn-default am-btn-xs am-text-secondary" onclick="alertDpname('${dp.id}')"><span class="am-icon-pencil-square-o"></span>修改 </button>
										</div>
									</div>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<div class="am-cf">
					<span>共 ${totalPage*5}条记录&nbsp;&nbsp;</span>
					<div class="am-fr am-pagination">
						<div id="deptPages"></div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- content end -->
<!-- <footer>
    <hr>
    <p class="am-padding-left">©Copyright &copy;2017 All Rights Reserved huizhouxueyuan development team</p>
</footer> -->
<input type="hidden" id="hidden-pages" value="${totalPage}">
<input type="hidden" id="hidden-currentPage" value="${currentPage}">
</body>
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/amazeui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/public/am-page/dist/amazeui.page.js"></script>
<script type="text/javascript">
	var totalPage=$("#hidden-pages").val();
	var currentPage=$("#hidden-currentPage").val();
	$("#deptPages").page({
        pages:totalPage,
        curr:currentPage, 
        groups: 2,
        jump:function(context,first){
            if(!first){
            	location.href="/HROA/rbac/gtDpList.html?pageSize=5&startPage="+context.option.curr;
            }
        }
    });
	function alertDpname(id){
		location.href="/HROA/rbac/gtAlDeptInfo.html?method=gtInfo&dpId="+id;
	}
</script>
</html>