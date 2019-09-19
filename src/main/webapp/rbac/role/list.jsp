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
        	<div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">用户中心</strong> / <small>用户角色管理</small></div>
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
				<form class="am-form" action="#">
					<table class="am-table am-table-bordered am-table-radius am-table-striped" style="table-layout: fixed;">
						<thead>
							<tr>
								<th>编号</th>
								<th>角色名称</th>
								<th>角色描述</th>
								<th>角色部门</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${roleList}" var="rl">
								<tr>
									<td>${rl.id}</td>
									<td>${rl.role_name}</td>
									<td style="white-space: nowrap;text-overflow: ellipsis;overflow: hidden; ">${rl.role_describes}</td>
									<td>${rl.dpname}</td>
									<td>
										<div class="am-btn-toolbar">
						                    <div class="am-btn-group am-btn-group-xs">
						                      	<button type="button" id="assginPrev" type="button" class="am-btn am-btn-default am-btn-xs am-text-secondary" onclick="getPrev('${rl.id}')"><span class="am-icon-pencil-square-o"></span>授权</button>
						                      	<button type="button" id="alertRole" class="am-btn am-btn-default am-btn-xs" onclick="alertRoleInfo('${rl.id}')"><span class="am-icon-copy"></span>编辑</button>
						                    </div>					                 
					                  	</div>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<div class="am-cf">
					<%-- <span>共 ${totalPage*5}条记录&nbsp;&nbsp;</span> --%>
					<div class="am-fr am-pagination">
						<div id="rolePages"></div>
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
<input type="hidden" id="hidden-pages" value="${totalPage}">
<input type="hidden" id="hidden-currentPage" value="${currentPage}">
</body>
<script src="/HROA/js/jquery.min.js"></script>
<script src="/HROA/assets/js/amazeui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/public/am-page/dist/amazeui.page.js"></script>
<script type="text/javascript">
function alertRoleInfo(roleId){
	location.href="/HROA/rbac/altRole.html?roleId="+roleId;
}

function getPrev(roleId){
	location.href="/HROA/rbac/getPrev.html?method=jumpPrev&roleId="+roleId;
}

$(document).ready(function(){
	var totalPage=$("#hidden-pages").val();
	var currentPage=$("#hidden-currentPage").val();
	$('#addRole').on('click',function(){
		window.location.href="/HROA/rbac/jpToAddRl.html";
	});

	$("#rolePages").page({
        pages:totalPage,
        curr:currentPage, 
        groups:2,
        jump:function(context,first){
            if(!first){
            	location.href="/HROA/rbac/getRlList.html?pageSize=5&startPage="+context.option.curr;
            }
        }
    });
})
</script>
</html>