<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page contentType="text/html;charset=UTF-8"%>
<!doctype html>
<html class="no-js fixed-layout">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>费用报销申请</title>
  <meta http-equiv="Content-Security-Policy" content="upgrade-insecure-requests">
  <meta name="description" content="这是出差申请页面">
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
       <div class="am-fl am-cf am-u-sm-10"><strong class="am-text-primary am-text-lg">申请中心</strong> / <small>费用报销申请</small></div>
        <div class="am-u-sm-2">
        	<a href="##" class="am-icon-home am-icon-lg" data-am-modal="{target: '#money'}"></a>
        </div>
     </div>
     <hr/>
	<div class="am-g">
      <div class="am-u-sm-12 am-u-md-8 am-u-md-pull-4 am-u-md-offset-4">
         <form class="am-form am-form-horizontal" action="/HROA/money/addmoney.html" method="post" onsubmit="return check()">
            <div class="am-form-group">
              <label for="user-name" class="am-u-sm-3 am-form-label">手机号: </label>
              <div class="am-u-sm-9">
                <input type="number" id="user-phone" name="phone"/>
              </div>
            </div>

            <div class="am-form-group">
              <label for="user-email" class="am-u-sm-3 am-form-label">开支报销人： </label>
              <div class="am-u-sm-9">
                <input type="text" id="user-name" name="username"/>
              </div>
            </div>
            
             <div class="am-form-group">
              <label for="user-email" class="am-u-sm-3 am-form-label">消费日期： </label>
              <div class="am-u-sm-9">
                <input type="date" id="use-time" name="time"/>
              </div>
            </div>
            
            <div class="am-form-group">
              <label for="user-phone" class="am-u-sm-3 am-form-label">消费类别： </label>
              <div class="am-u-sm-9">
                <input type="text" id="use-type" name="usetype"/>
              </div>
            </div>

            <div class="am-form-group">
              <label for="user-QQ" class="am-u-sm-3 am-form-label">消费对象: </label>
              <div class="am-u-sm-9">
                <input type="text" id="use-people" name="usepeople"/>
              </div>
            </div>

            <div class="am-form-group">
              <label for="user-weibo" class="am-u-sm-3 am-form-label">承担部门: </label>
              <div class="am-u-sm-9">
                <input type="text" id="department" name="department">
              </div>
            </div>
            
			<div class="am-form-group">
              <label for="user-weibo" class="am-u-sm-3 am-form-label">开支单位: </label>
              <div class="am-u-sm-9">
                <input type="text" id="spendunit" name="spendunit">
              </div>
            </div>
            
            <div class="am-form-group">
              <label for="user-weibo" class="am-u-sm-3 am-form-label">消费地点: </label>
              <div class="am-u-sm-9" style="text-align: center;">
              	<span id="useplace" name="useplace"></span>
              	<input type="hidden" name="useplace" id="place"/>
              </div>
            </div>
            
            <div class="am-form-group">
              <label for="user-weibo" class="am-u-sm-3 am-form-label">付款方式: </label>
              <div class="am-u-sm-9">
                <input type="text" id="applytype" name="applytype"/>
              </div>
            </div>
            
             <div class="am-form-group">
              <label for="user-weibo" class="am-u-sm-3 am-form-label">报销费用: </label>
              <div class="am-u-sm-9">
                <input type="text" id="use-money" name="umoney" placeholder="单位：元"/>
              </div>
            </div>
            
            <div class="am-form-group">
              <label for="user-intro" class="am-u-sm-3 am-form-label">说明： </label>
              <div class="am-u-sm-9">
                <textarea rows="5" id="user-describe" name="detail"></textarea>
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
  
	<div class="am-modal am-modal-alert" tabindex="-1" id="money">
	  <div class="am-modal-dialog">
	    <div class="am-modal-hd">费用报销说明</div>
	    <div class="am-modal-bd" style="text-align: center;">
	       	<h5>总经理</h5>  
	       	<span>报销费用<=5000元</span>
		    <h5>运营总监、IT部长 财务</h5>
		    <span>报销费用<=3000元</span>
		    <h5>人力资源开发部部长、就业安置部部长、管理部经理</h5>
		    <span>报销费用<=1000元</span>
		    <h5>代理、驻厂管理、普通职员</h5>
		    <span>报销费用<=500元</span>
	    </div>
	    <div class="am-modal-footer">
	      <span class="am-modal-btn">确定</span>
	    </div>
	  </div>
	</div>
	<a href="#" class="am-icon-btn am-icon-th-list am-show-sm-only admin-menu" data-am-offcanvas="{target: '#admin-offcanvas'}"></a>

	<!--[if lt IE 9]>
	<script src="http://libs.baidu.com/jquery/1.11.1/jquery.min.js"></script>
	<script src="http://cdn.staticfile.org/modernizr/2.8.3/modernizr.js"></script>
	<script src="assets/js/amazeui.ie8polyfill.min.js"></script>
	<![endif]-->

	<!--[if (gte IE 9)|!(IE)]><!-->
	<script src="/HROA/js/jquery.min.js"></script>
	<!--<![endif]-->
	<script src="/HROA/assets/js/amazeui.min.js"></script>
	<script src="/HROA/assets/js/amazeui.ie8polyfill.min.js"></script>
	<script src="/HROA/js/dist/amazeui.dialog.js"></script>
	<script src="/HROA/apply/js/money.js"></script>
	<script src="http://api.map.baidu.com/api?v=2.0&ak=5TxxLi6fk0I2nqtjeFbw5n0Q0N352xXs"></script>
	<script type="text/javascript">
		$('#money').on('click',function(){
			$('#money').modal();
		});
		var result="${result}";
		if(result!=""){
			_alert_(result);
		}
		
		function _alert_(title){
			AMUI.dialog.alert({
			  title: title,
			  onConfirm: function() {
			      console.log('费用报销'+title);
			    }
			});
		}
	</script>
</body>
</html>
