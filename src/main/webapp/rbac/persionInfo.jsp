<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html class="no-js fixed-layout">
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
		<!-- content start -->
		<%-- <div class="admin-content">
			 <ol class="am-breadcrumb">
			  <li>位置：<a href="${pageContext.request.contextPath}/rbac/gtUserlist.html?pageSize=10&startPage=0">系统用户管理</a></li>
			  <li class="am-active">用户信息修改</li>
			</ol>
			<div class="am-g">
				<div class="am-u-lg-5 am-u-md-12 am-u-sm-centered">
				<form class="am-form m-form-horizontal" action="#" method="post">
					<div class="am-g am-margin-top">
						<div class="am-u-sm-2 am-text-right">用户昵称</div>
						<div class="am-u-sm-8">
							<div class="am-form-group ">
								<div class="field">
									<input type="text" id="role-name" placeholder="用户昵称" name="name">
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
									<select name="dpId">
										<option value="">--选择部门--</option>
										<c:forEach items="${deptList}" var="dp">
											<option value="${dp.id }">${dp.dpname }</option>
										</c:forEach>
									</select>
								</div>
							</div>
						</div>
						<div class="am-u-sm-3"></div>
					</div>
	
					<div class="am-form-group">
						<div class="am-u-sm-9 am-u-sm-push-3">
							<input type="button" class="am-btn am-btn-primary" value="添加" />
						</div>
					</div>
				</form>
			</div>
			</div>
		</div> --%>
		  <div class="admin-content">
    <div class="admin-content-body">
      <div class="am-cf am-padding am-padding-bottom-0">
        <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">个人资料</strong> / <small>Personal information</small></div>
      </div>

      <hr/>

      <div class="am-g">
        <!-- <div class="am-u-sm-12 am-u-md-4 am-u-md-push-8">
          <div class="am-panel am-panel-default">
            <div class="am-panel-bd">
              <div class="am-g">
                <div class="am-u-md-4">
                  <img class="am-img-circle am-img-thumbnail" src="http://s.amazeui.org/media/i/demos/bw-2014-06-19.jpg?imageView/1/w/200/h/200/q/80" alt=""/>
                </div>
                <div class="am-u-md-8">
                  <p>你可以使用<a href="#">gravatar.com</a>提供的头像或者使用本地上传头像。 </p>
                  <form class="am-form">
                    <div class="am-form-group">
                      <input type="file" id="user-pic">
                      <p class="am-form-help">请选择要上传的文件...</p>
                      <button type="button" class="am-btn am-btn-primary am-btn-xs">保存</button>
                    </div>
                  </form>
                </div>
              </div>
            </div>
          </div>

          <div class="am-panel am-panel-default">
            <div class="am-panel-bd">
              <div class="user-info">
                <p>等级信息</p>
                <div class="am-progress am-progress-sm">
                  <div class="am-progress-bar" style="width: 60%"></div>
                </div>
                <p class="user-info-order">当前等级：<strong>LV8</strong> 活跃天数：<strong>587</strong> 距离下一级别：<strong>160</strong></p>
              </div>
              <div class="user-info">
                <p>信用信息</p>
                <div class="am-progress am-progress-sm">
                  <div class="am-progress-bar am-progress-bar-success" style="width: 80%"></div>
                </div>
                <p class="user-info-order">信用等级：正常当前 信用积分：<strong>80</strong></p>
              </div>
            </div>
          </div>

        </div> -->

        <div class="am-u-sm-12 am-u-md-8">
          <form class="am-form am-form-horizontal">
            <div class="am-form-group">
              <label for="user-name" class="am-u-sm-3 am-form-label">姓名 / Name</label>
              <div class="am-u-sm-9">
                <input type="text" id="user-name" placeholder="姓名 / Name">
                <small>输入你的名字，让我们记住你。</small>
              </div>
            </div>

            <div class="am-form-group">
              <label for="user-email" class="am-u-sm-3 am-form-label">电子邮件 / Email</label>
              <div class="am-u-sm-9">
                <input type="email" id="user-email" placeholder="输入你的电子邮件 / Email">
                <small>邮箱你懂得...</small>
              </div>
            </div>

            <div class="am-form-group">
              <label for="user-phone" class="am-u-sm-3 am-form-label">电话 / Telephone</label>
              <div class="am-u-sm-9">
                <input type="tel" id="user-phone" placeholder="输入你的电话号码 / Telephone">
              </div>
            </div>

            <div class="am-form-group">
              <label for="user-QQ" class="am-u-sm-3 am-form-label">QQ</label>
              <div class="am-u-sm-9">
                <input type="number" pattern="[0-9]*" id="user-QQ" placeholder="输入你的QQ号码">
              </div>
            </div>

            <div class="am-form-group">
              <label for="user-weibo" class="am-u-sm-3 am-form-label">微博 / Twitter</label>
              <div class="am-u-sm-9">
                <input type="text" id="user-weibo" placeholder="输入你的微博 / Twitter">
              </div>
            </div>

            <div class="am-form-group">
              <label for="user-intro" class="am-u-sm-3 am-form-label">简介 / Intro</label>
              <div class="am-u-sm-9">
                <textarea class="" rows="5" id="user-intro" placeholder="输入个人简介"></textarea>
                <small>250字以内写出你的一生...</small>
              </div>
            </div>

            <div class="am-form-group">
              <div class="am-u-sm-9 am-u-sm-push-3">
                <button type="button" class="am-btn am-btn-primary">保存修改</button>
              </div>
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
<!-- <footer>
    <hr>
    <p class="am-padding-left">©Copyright &copy;2017 All Rights Reserved huizhouxueyuan development team</p>
</footer> -->
</body>
<script src="/HROA/js/jquery.min.js"></script>
<script src="/HROA/assets/js/amazeui.min.js"></script>
</html>
