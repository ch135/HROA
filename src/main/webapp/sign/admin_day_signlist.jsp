<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!doctype html>
<html class="no-js fixed-layout">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>日签到列表</title>
  <meta name="description" content="这是日签到列表页面">
  <meta name="keywords" content="index">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="renderer" content="webkit">
  <meta http-equiv="Cache-Control" content="no-siteapp" />
  <link rel="icon" type="image/png" href="/HROA/assets/i/favicon.png">
  <link rel="apple-touch-icon-precomposed" href="/HROA/assets/i/app-icon72x72@2x.png">
  <meta name="apple-mobile-web-app-title" content="Amaze UI" />
  <link rel="stylesheet" href="/HROA/assets/css/amazeui.min.css"/>
  <link rel="stylesheet" href="/HROA/assets/css/admin.css">
  <link rel="stylesheet" href="/HROA/css/amazeui.datatables.min.css"/>
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
       <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">在线签到</strong> / <small>签到列表</small></div>
     </div>
     <hr/>
     <div class="am-g">
       <div class="am-u-sm-8 am-u-md-10">
         <div class="am-btn-group">
           <button type="button" class="am-btn am-btn-success am-btn-sm" id="month">月签到情况</button>
         </div>
         <div class="am-btn-group">
         	<button type="button" class="am-btn am-btn-primary am-btn-sm" id="day">日签到情况</button>
         </div>
       </div>
       <div class="am-u-sm-4 am-u-md-2">
         <div class="am-btn-group am-btn-group-xs">
           <span>未签到数目：${allcount }</span>
       	 </div>
       </div>
     </div>
     <br/>
     <div class="am-g">
		<div class="am-u-sm-12">
			<form class="am-form">
				<table width="100%" class="am-table am-table-striped  am-table-compact am-text-nowrap" id="leave-table">
					<thead><th>编号</th><th>姓名</th><th>签到时间</th><th>签到地点</th></thead>
					<tbody>
						<tr>
							<td>wdwwdw</td>
							<td>陈浩</td>
							<td>08:23:20</td>
							<td>惠州学院</td>
						</tr>
						<c:if test="${count>=1}">
							<c:forEach items="${signs}" var="sign">
								<tr>${sign.userid }</tr>
								<tr>${sign.name }</tr>
								<td><fmt:formatDate type="time" value="${sign.time}"/></td>
								<tr>${sian.area }</tr>
							</c:forEach>
						</c:if>
					</tbody>
				</table>
				<c:if test="${count==-1}">
					<p>获取数据失败</p>
				</c:if>
				<div id="page2" class="am-pagination-right"></div>
			</form>
		</div>
	</div>
    </div>
    <footer class="admin-content-footer">
     <hr>
     <p class="am-padding-left">©Copyright &copy;2017 All Rights Reserved huizhouxueyuan development team</p>
    </footer>
  </div>
<!-- content end -->
	<a href="#" class="am-icon-btn am-icon-th-list am-show-sm-only admin-menu" data-am-offcanvas="{target: '#admin-offcanvas'}"></a>
	<script src="/HROA/js/jquery.min.js"></script>
	<script src="/HROA/js/dist/amazeui.datatables.min.js"></script>
	<script src="/HROA/js/dist/dataTables.responsive.min.js"></script>
	<script src="/HROA/assets/js/amazeui.min.js"></script>
	<script src="/HROA/assets/js/amazeui.ie8polyfill.min.js"></script>
	<script src="/HROA/assets/js/dist/amazeui.page.js"></script>
	<script src="/HROA/js/dist/amazeui.dialog.js"></script>
	<script type="text/javascript">
		var page = window.location.search.match(/start=(\d+)/);
		$("#page2").page({
			pages: ${count},
			curr: page?page[1]:1,
          first: "首页", //设置false则不显示，默认为false  
          last: "尾页", //设置false则不显示，默认为false      
          prev: '<', //若不显示，设置false即可，默认为上一页
          next: '>', //若不显示，设置false即可，默认为下一页
          groups: 5, //连续显示分页数
          jump : function(context, first) {
				if (!first) {
					window.location.href = '?start='+context.option.curr+'&name='+'${name}';
				}
			}
		});
		
		${'#month'}.on('click',function(){
			
		});
		
		${'#day'}.on('click',function(){
			
		})
	</script>
</body>
</html>
