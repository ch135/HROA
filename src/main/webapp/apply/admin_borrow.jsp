<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page contentType="text/html;charset=UTF-8"%>
<!doctype html>
<html class="no-js fixed-layout">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>借资申请</title>
  <meta name="description" content="这是借资申请页面">
  <meta name="keywords" content="index">
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
<!--[if lte IE 9]>
<p class="browsehappy">你正在使用<strong>过时</strong>的浏览器，Amaze UI 暂不支持。 请 <a href="http://browsehappy.com/" target="_blank">升级浏览器</a>
  以获得更好的体验！</p>
<![endif]-->
  <!-- content start -->
  <div class="admin-content">
     <div class="am-cf am-padding">
       <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">申请中心</strong> / <small>借资申请</small></div>
     </div>
     <hr/>
	<div class="am-g">
      <div class="am-u-sm-12 am-u-md-8 am-u-md-pull-4 am-u-md-offset-4">
         <form class="am-form am-form-horizontal" action="/HROA/borrow/addBorrow.html" method="post" onsubmit="return check()">
            <div class="am-form-group">
              <label for="user-name" class="am-u-sm-3 am-form-label">手机号: </label>
              <div class="am-u-sm-9">
                <input type="tel" id="user-phone" name="phone"/>
              </div>
            </div>

            <div class="am-form-group">
              <label for="user-email" class="am-u-sm-3 am-form-label">申请人： </label>
              <div class="am-u-sm-9">
                <input type="text" id="user-name" name="name"/>
              </div>
            </div>
            
            <div class="am-form-group">
              <label for="user-email" class="am-u-sm-3 am-form-label">申请金额： </label>
              <div class="am-u-sm-9">
                <input type="text" id="user-money" name="money"/>
              </div>
            </div>
            
             <div class="am-form-group">
              <label for="user-email" class="am-u-sm-3 am-form-label">管理人： </label>
              <div class="am-u-sm-9">
                <input type="text" id="manager-name" name="manager"/>
              </div>
            </div>
            
            <div class="am-form-group">
              <label for="user-phone" class="am-u-sm-3 am-form-label">部门： </label>
              <div class="am-u-sm-9">
                <input type="text" id="user-depa" name="department"/>
              </div>
            </div>

            <div class="am-form-group">
              <label for="user-QQ" class="am-u-sm-3 am-form-label">借资日期: </label>
              <div class="am-u-sm-9">
                <input type="date" id="user-start" name="apply"/>
              </div>
            </div>

            <div class="am-form-group">
              <label for="user-weibo" class="am-u-sm-3 am-form-label">归还日期: </label>
              <div class="am-u-sm-9">
                <input type="date" id="user-end" name="back">
              </div>
            </div>

            <div class="am-form-group">
              <label for="user-intro" class="am-u-sm-3 am-form-label">原因： </label>
              <div class="am-u-sm-9">
                <textarea class="" rows="5" id="user-reason" name="reason"></textarea>
              </div>
            </div>

            <div class="am-form-group">
              <div class="am-u-sm-9 am-u-sm-push-3">
                <button type="submit" class="am-btn am-btn-primary">提交</button>
              </div>
            </div>
            </form>
        </div>
      </div>
    </div>
    <footer class="admin-content-footer">
      <p class="am-padding-left">©Copyright &copy;2017 All Rights Reserved huizhouxueyuan development team</p>
    </footer>
  </div>
  <!-- content end -->

<a href="#" class="am-icon-btn am-icon-th-list am-show-sm-only admin-menu" data-am-offcanvas="{target: '#admin-offcanvas'}"></a>

	<!--[if lt IE 9]>
	<script src="http://libs.baidu.com/jquery/1.11.1/jquery.min.js"></script>
	<script src="http://cdn.staticfile.org/modernizr/2.8.3/modernizr.js"></script>
	<script src="assets/js/amazeui.ie8polyfill.min.js"></script>
	<![endif]-->

	<!--[if (gte IE 9)|!(IE)]><!-->
	<script src="/HROA/js/jquery.min.js"></script>
	<!--<![endif]-->
	<script src="/HROA/assets/js/amazeui.ie8polyfill.min.js"></script>
	<script src="/HROA/assets/js/amazeui.min.js"></script>
	<script src="/HROA/js/dist/amazeui.dialog.js"></script>
	<script src="/HROA/apply/js/borrow.js"></script>
	<script>
		var result="${result}";
		if(result!=""){
			alert_(result);
		}
		
		function alert_(title){
			AMUI.dialog.alert({
			  title: title,
			  onConfirm: function() {
			      console.log('请假'+title);
			    }
		});
	}
	</script>
</body>
</html>