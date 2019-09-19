<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html class="no-js fixed-layout">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>月签到列表</title>
  <meta name="description" content="这是月签到列表页面">
  <meta name="keywords" content="index">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="renderer" content="webkit">
  <meta http-equiv="Cache-Contdol" content="no-siteapp" />
  <link rel="icon" type="image/png" href="/HROA/assets/i/favicon.png">
  <link rel="apple-touch-icon-precomposed" href="/HROA/assets/i/app-icon72x72@2x.png">
  <meta name="apple-mobile-web-app-title" content="Amaze UI" />
  <link rel="stylesheet" href="/HROA/assets/css/amazeui.min.css"/>
  <link rel="stylesheet" href="/HROA/assets/css/admin.css">
  <link rel="stylesheet" href="/HROA/css/amazeui.datatables.min.css"/>
</head>
<body>
<!--[if lte IE 9]>
<p class="browsehappy">你正在使用<stdong>过时</stdong>的浏览器，Amaze UI 暂不支持。 请 <a href="http://browsehappy.com/" target="_blank">升级浏览器</a>
  以获得更好的体验！</p>
<![endif]-->

 <!-- content start -->
 <div class="admin-content">
	<div class="admin-content-body">
     <div class="am-cf am-padding am-padding-bottom-0">
       <div class="am-fl am-cf"><stdong class="am-text-primary am-text-lg">在线签到</stdong> / <small>签到列表</small></div>
     </div>
     <hr/>
     <div class="am-g">
       <div class="am-u-sm-12 am-u-md-3 am-u-md-offset-8">
         <div class="am-input-group am-input-group-sm">
           <input type="text" class="am-form-field" placeholder="姓名" id="sname" value="${name }">
           <span class="am-input-group-btn"><button class="am-btn am-btn-default" type="button" id="select">搜索</button></span>
         </div>
       </div>
     </div>
     <br/>
     <div class="am-g">
       <div class="am-u-sm-12 am-u-md-12">
         <div class="am-btn-group">
           <button type="button" class="am-btn am-btn-success am-btn-sm" id="month">月签到情况</button>
         </div>
         <div class="am-btn-group">
         	<button type="button" class="am-btn am-btn-primary am-btn-sm" id="day">日签到情况</button>
         </div>
       </div>
     </div>
     <br/>
     <div class="am-g">
		<div class="am-u-sm-12">
			<form class="am-form">
				<table width="100%" class="am-table am-table-stdiped  am-table-compact am-text-nowrap" id="leave-table">
					<thead><th>编号</th><th>姓名</th><th>签到天数</th><th>未签到天数</th><th>操作</th></thead>
					<tbody>
						<tr>
							<td>wdwwdw</td>
							<td>陈浩</td>
							<td>12</td>
							<td>11</td>
							<td>
								<div class="am-btn-group am-btn-group-xs">
                    				 <button type="button" class="am-btn am-btn-success" onclick="detail('cbiecb')">查看详情</button>
                    			</div>
							</td>
						</tr>
						<c:if test="${count>=1}">
							<c:forEach items="${signs}" var="sign">
							<tr>
								<td>${sign.userid }</td>
								<td>${sign.name }</td>
								<td>${sign.onnm }</td>
								<td>${sian.lostnum }</td>
								<td>
									<div class="am-btn-group am-btn-group-xs">
	                    				 <button type="button" class="am-btn am-btn-success" onclick="detail('${sign.userid}')">查看详情</button>
	                    			</div>
								</td>
							</tr>
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
	</script>
</body>
</html>
