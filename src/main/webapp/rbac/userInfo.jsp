<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
</head>
<body>
<!-- content start -->
<div class="admin-content">
  	<div class="admin-content-body">
	    <ol class="am-breadcrumb">
		  <li>位置：<a href="${pageContext.request.contextPath}/rbac/gtUserlist.html?pageSize=10&startPage=1">系统用户管理</a></li>
		  <li class="am-active">用户信息修改</li>
		</ol>
    	<hr>

	    <div class="am-tabs am-margin" data-am-tabs>
	      	<ul class="am-tabs-nav am-nav am-nav-tabs">
		        <li id="info" class="am-active"><a href="#tab1">基本信息</a></li>
		       	<%-- <c:if test="${userPowerMap.p22!=null}">  --%>
		       	<li id="role" ><a href="#tab2">角色分配</a></li>
		       	<%-- </c:if> --%>
		        <!-- <li><a href="#tab3">密码重设</a></li> -->
	      	</ul>
	      	<div class="am-tabs-bd">
		        <div class="am-tab-panel am-fade am-in am-active" id="tab1">
	          	<form class="am-form" action="#">
					<div class="am-g am-margin-top">
						<div class="am-u-sm-4 am-u-md-2 am-text-right">用户昵称</div>
						<div class="am-u-sm-8 am-u-md-4">
							<div class="am-form-group ">
								<div class="field">
									<input type="text" id="role-name" placeholder="用户昵称" name="name" value="${userInfo.nickname}">
								</div>
							</div>
						</div>
						<div class="am-u-sm-3"></div>
					</div>
					<div class="am-g am-margin-top">
						<div class="am-u-sm-4 am-u-md-2 am-text-right">部门</div>
						<div class="am-u-sm-8 am-u-md-4">
							<div class="am-form-group ">
								<div class="field">
									<select name="dpId">
										<c:forEach items="${deptList}" var="dp">
											<c:choose>
											<c:when test="${dp.dpname==userInfo.deptInfo.dpname}">
												<option selected="selected" value="${userInfo.deptid}">${userInfo.deptInfo.dpname}</option>
											</c:when>
											<c:otherwise>
												<option value="${dp.id }">${dp.dpname }</option>
											</c:otherwise>
											</c:choose>
										</c:forEach>
									</select>
								</div>
							</div>
						</div>
						<div class="am-u-sm-3"></div>
					</div>
				</form>
		        </div>
				<%-- <c:if test="${userPowerMap.p22!=null}"> --%>
		        <div class="am-tab-panel am-fade" id="tab2">
		          <form id="assignRole" class="am-form">
		            <div class="am-g am-margin-top-sm">
		              <div class="am-u-sm-4 am-u-md-2 am-text-right">
		                	用户昵称
		              </div>
		              <div class="am-u-sm-8 am-u-md-4 am-u-end">
		                <input type="text">
		              </div>
		            </div>
					<div class="am-g am-margin-top-sm">
		              <div class="am-u-sm-4 am-u-md-2 am-text-right">
		                	用户账号
		              </div>
		              <div class="am-u-sm-8 am-u-md-4 am-u-end">
		                <input type="text">
		              </div>
		            </div>
		            <div class="am-g am-margin-top-sm">
		              <div class="am-u-sm-4 am-u-md-2 am-text-right">
		                	所属角色
		              </div>
		              <div class="am-u-sm-8 am-u-md-4 am-u-end">
		                <div class="am-form-group ">
								<div class="field">
									<select name="dpId">
										<c:forEach items="${roleList}" var="rl">
											<c:choose>
												<c:when test="${rl.role_name==userInfoRoleName}">
													<option selected="selected" value="${userInfo.role_id}">${userInfoRoleName}</option>
												</c:when>
												<c:otherwise>
											        <option value="${rl.id }">${rl.role_name}</option>
											    </c:otherwise>
										    </c:choose>
										</c:forEach>
									</select>
								</div>
							</div>
		              </div>
		            </div>
		          </form>
		        </div>
		        <%-- </c:if> --%>
		       <!--  <div class="am-tab-panel am-fade" id="tab3">
		          	<form class="am-form">
		            <div class="am-g am-margin-top">
		              	<div class="am-u-sm-4 am-u-md-2 am-text-right"> 新密码</div>
		              	<div class="am-u-sm-8 am-u-md-4 am-u-end">
			              	<div class="am-form-group ">
				              	<div class="field">
				                	<input type="text" placeholder="用户昵称">
				                </div>
			                </div>
		              	</div>
		            </div>
		            <div class="am-g am-margin-top">
		              <div class="am-u-sm-4 am-u-md-2 am-text-right"> 确定密码</div>
		              <div class="am-u-sm-8 am-u-md-4 am-u-end col-end">
		              <div class="am-form-group ">
		                <input type="text">
		               </div>
		              </div>
		            </div>
		          	</form>
		        </div> -->
	      	</div>
	    </div>

	  <div id="alet-info" class="am-margin">
	    	<button type="button" class="am-btn am-btn-primary am-btn-xs">提交保存</button>
	    	<button type="button" class="am-btn am-btn-primary am-btn-xs">放弃修改</button>
	  </div>
	  <div id="assgin-role" class="am-margin" style="display:none">
	    	<button type="button" class="am-btn am-btn-primary am-btn-xs">提交</button>
	    	<button type="button" class="am-btn am-btn-primary am-btn-xs">返回</button>
	  </div>
  </div>
</div>
<!-- content end -->
<!-- <footer>
  <hr>
  <p class="am-padding-left">©Copyright &copy;2017 All Rights Reserved huizhouxueyuan development team</p>
</footer> -->
</body>
<script src="/HROA/js/jquery.min.js"></script>
<script src="/HROA/assets/js/amazeui.min.js"></script>
<script type="text/javascript">
	$("#info").click(function(){
		$("#assgin-role").hide();
		$("#alet-info").show();
	})
	$("#role").click(function(){
		$("#alet-info").hide();
		$("#assgin-role").show();
	})
</script>
</html>
