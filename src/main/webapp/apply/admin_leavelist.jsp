<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!doctype html>
<html class="no-js fixed-layout">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>请假申请列表</title>
  <meta name="description" content="这是请假申请页面">
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
       <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">申请中心</strong> / <small>请假申请列表</small></div>
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
       <div class="am-u-sm-6 am-u-md-2">
         <div class="am-btn-group">
           <button type="button" class="am-btn am-btn-success am-btn-sm">待  审  核</button>
         </div>
         <div class="am-btn-group">
         	<button type="button" class="am-btn am-btn-primary am-btn-sm">历史记录</button>
         </div>
       </div>
       <div class="am-u-sm-5 am-u-md-3">
         <div class="am-btn-group am-btn-group-xs">
           <span>申请数目：${allcount }</span>
         </div>
       </div>
     </div>
     
     <br/>
     <div class="am-g">
		<div class="am-u-sm-12">
			<form class="am-form">
				<table width="100%" class="am-table am-table-striped  am-table-compact am-text-nowrap" id="leave-table">
					<thead><th>编号</th><th>姓名</th><th>申请时间</th><th>原因</th><th>管理人</th><th>部门</th><th>手机号</th><th>开始时间</th><th>结束时间</th><th>操作</th><th>状态</th></thead>
					<tbody>
						<c:if test="${count>=1}">
							<c:forEach items="${leaves}" var="leave">
								<c:set var="fristcheck" scope="page" value="${leave.fristcheck }"></c:set>
								<c:set var="secondcheck" scope="page" value="${leave.secondcheck }"></c:set>
								<tr id="${leave.id }">
									<td>${leave.id}</td>
									<td>${leave.name}</td>
									<td><fmt:formatDate type="date" value="${leave.applytime}"/></td>
									<td>${leave.reason}</td>
									<td>${leave.manager}</td>
									<td>${leave.department}</td>
									<td>${leave.phone}</td>
									<td><fmt:formatDate type="date" value="${leave.starttime}"/></td>
									<td><fmt:formatDate type="date" value="${leave.endtime}"/></td>
									<td>
				                    	<c:choose>
				                    		<c:when test="${fristcheck=='0' || secondcheck=='0'}">
				                    			<div class="am-btn-group am-btn-group-xs">
				                    				 <button type="button" class="am-btn am-btn-success" onclick="change('${leave.id}','success')">通  过</button>
				                    			</div>
				                    			<div class="am-btn-group am-btn-group-xs">
				                    				 <button type="button" class="am-btn am-btn-warning" onclick="change('${leave.id}','fail')">拒  绝</button>
				                    			</div>
				                    		</c:when>
				                    		<c:otherwise>
				                    		 	<div class="am-btn-group am-btn-group-xs">
				                    				 <button type="button" class="am-btn am-btn-danger" onclick="delete_confim('${leave.id}','delete')">删  除</button>
				                    			</div>
				                    		</c:otherwise>
				                    	</c:choose>
									</td>
									<c:if test="${fristcheck=='0' || secondcheck=='0'}"><td>待审核</td></c:if>
									<c:if test="${fristcheck=='1' || secondcheck=='1'}"><td>通过</td></c:if>
									<c:if test="${fristcheck=='2' || secondcheck=='2'}"><td>拒绝</td></c:if>
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
	<script src="/HROA/apply/js/leavelist.js"></script>
</body>
</html>
