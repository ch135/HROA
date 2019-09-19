<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page contentType="text/html;charset=UTF-8"%>
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
	<link rel="icon" type="image/png" href="assets/i/favicon.png">
	<link rel="apple-touch-icon-precomposed" href="assets/i/app-icon72x72@2x.png">
	<meta name="apple-mobile-web-app-title" content="Amaze UI" />
	<link rel="stylesheet" href="../assets/css/amazeui.min.css"/>
	<link rel="stylesheet" href="../assets/css/admin.css">
</head>
<body>
	<!-- header start -->
	<%@include file="/public/header.jsp" %>
	<!-- header end -->
	<%-- <%@include file="/public/tools.jsp" %> --%>
	<div class="am-cf admin-main">
		<!-- sidebar start -->
		<%@include file="/public/sidebar.jsp" %>
		<!-- sidebar end -->

		<!-- content start -->
		<div class="admin-content">

			 <ol class="am-breadcrumb">
			  <li>位置：<a href="${pageContext.request.contextPath}/system/user/user_list">用户管理</a></li>
			  <li class="am-active">用户角色分配</li>
			</ol>

			<div class="am-g">
				<div class="am-u-lg-5 am-u-md-15 ">
					<form class="am-form am-form-horizontal"
						action="${pageContext.request.contextPath}/system/user/userPrev"
						method="post" submit-method="ajax">
						<div class="am-g am-margin-top">
							<div class="am-u-sm-2 am-text-right">选择角色</div>
							<div class="am-u-sm-8">
								<div class="am-form-group ">
									<div class="field">
										<select name="rId" data-validate="required:不能为空" id="dp">
											<option value="">--选择角色--</option>
											<c:forEach items="${requestScope.ros}" var="p">
												<c:choose>
													<c:when test="${p.id == requestScope.ro.id}">
														<option value="${p.id }" selected="selected">${p.roleName
															}</option>
													</c:when>
													<c:otherwise>
														<option value="${p.id }">${p.roleName }</option>
													</c:otherwise>
												</c:choose>
											</c:forEach>
										</select> <input name="id" value="${requestScope.id }" type="hidden"
											class="required">
									</div>
								</div>
							</div>
							<div class="am-u-sm-3"></div>
						</div>
						<div class="am-form-group">
							<div class="am-u-sm-9 am-u-sm-push-3">
								<input type="submit" class="am-btn am-btn-primary" value="授权" /><%-- <%@include
									file="/WEB-INF/jsp/public/tooltip.jsp"%> --%>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
		<!-- content end -->
	</div>
	<footer>
	    <hr>
	    <p class="am-padding-left">©Copyright &copy;2017 All Rights Reserved huizhouxueyuan development team</p>
	</footer>
</body>
</html>
