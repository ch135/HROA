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
	<link rel="icon" type="image/png" href="/HROA/assets/i/favicon.png">
	<link rel="apple-touch-icon-precomposed" href="/HROA/assets/i/app-icon72x72@2x.png">
	<meta name="apple-mobile-web-app-title" content="Amaze UI" />
	<link rel="stylesheet" href="/HROA/assets/css/amazeui.min.css"/>
	<link rel="stylesheet" href="/HROA/assets/css/admin.css">
	<link rel="stylesheet" href="/HROA/public/am-datatables/dist/amazeui.datatables.css">
</head>
<body>
	<!-- content start -->
	<div class="admin-content">
		<div class="am-cf am-padding am-padding-bottom-0">
        	<div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">系统公告</strong> / <small>公告列表</small></div>
      	</div>
      	<hr>
      	
		<div class="am-g">
		  	<div class="am-u-sm-12 am-u-md-6">
			    <div class="am-btn-toolbar">
			      	<div class="am-btn-group am-btn-group-xs">
				        <button id="addNotice" type="button" class="am-btn am-btn-default">
				        	<span class="am-icon-plus"></span>新增
				        </button>
			      	</div>
			    </div>
		  	</div>
		 	<div class="am-u-sm-12 am-u-md-3">
		    	<div class="am-input-group am-input-group-sm">
			      	<input type="text" class="am-form-field">
			    	<span class="am-input-group-btn">
			      		<button class="am-btn am-btn-default" type="button">搜索</button>
			    	</span>
		    	</div>
		  	</div>
		</div>
		<hr>
		
		<div class="am-g">
			<div class="am-u-sm-12">
				<table style="width:100%" class="am-table am-table-striped am-table-bordered am-table-compact am-text-nowrap" id="notice-list">
					<thead>
						<tr>
						    <th style="width:15%;">编号</th>
			              	<th style="width:25%;">标题</th>
			              	<th style="width:15%;">发布人</th>
			              	<th style="width:15%;">时间</th>
			              	<th style="width:10%;">状态</th>
			              	<th style="width:10%;">操作</th>
						</tr>
					</thead>
					<tbody>
					<%-- <c:if test="${perPageAmount>0}"> --%>
						<c:forEach var="ntList" items="${ntList}">
						<tr>
						  	<td>${ntList.id}</td>
						  	<td>${ntList.title}</td>
						  	<td>${ntList.adduser}</td>
						  	<td class="center">${ntList.addtime}</td>
						  	<c:if test="${ntList.status==0}">
						  		<td class="center">未发布</td>
						  	</c:if>
						  	<c:if test="${ntList.status==1}">
						  		<td class="center">已发布</td>
						  	</c:if>				
						  	<td>
						  		<div class="am-btn-toolbar">
				                    <div class="am-btn-group am-btn-group-xs">
				                      	<!-- <button class="am-btn am-btn-default am-btn-xs am-text-secondary"><span class="am-icon-pencil-square-o"></span>授权</button> -->
				                      	<button class="am-btn am-btn-default am-btn-xs" onclick="lookNtInfo('${ntList.id}')"><span class="am-icon-copy"></span>查看</button>
				                      	<!-- <button class="am-btn am-btn-default am-btn-xs am-text-danger"><span class="am-icon-trash-o"></span>停用</button> -->
				                      	<!-- <button class="am-btn am-btn-default am-btn-xs am-text-danger"><span class="am-icon-trash-o"></span>重置密码</button> -->
				                    </div>
			                  	</div>
						  	</td>
						</tr>
						</c:forEach>
					<%-- </c:if> --%>
					</tbody>
				</table>
				<div class="am-cf">
					<%-- <span>共 ${totalPage*5}条记录&nbsp;&nbsp;</span> --%>
					<div class="am-fr am-pagination">
						<div id="noticePages"></div>
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
<div class="am-popup" id="desc-notice">
  	<div class="am-popup-inner">
	    <div class="am-popup-hd">
	      	<h4 id="notice-title" class="am-popup-title">公告详情</h4>
	     	<span data-am-modal-close class="am-close">&times;</span>
	    </div>
	    <div id="notice-centent" class="am-popup-bd am-text-center am-center">
	    </div>
  	</div>
</div>
<input type="hidden" id="hidden-pages" value="${totalPage}">
<input type="hidden" id="hidden-currentPage" value="${currentPage}">
</body>
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/amazeui.min.js"></script>
<script src="${pageContext.request.contextPath}/public/am-datatables/dist/amazeui.datatables.min.js"></script>
<script src="${pageContext.request.contextPath}/public/am-datatables/dist/dataTables.responsive.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/public/am-page/dist/amazeui.page.js"></script>
<script type="text/javascript">
var $modal = $('#desc-notice');
function lookNtInfo(noticeId){
	$.ajax({
		url:"/HROA/notice/gtNtInfoById.html",
		type:'post',
		data:{noticeId:noticeId},
		dataType:'json',
		success:function(data){
			if(data.status==1){
				document.getElementById("notice-centent").innerHTML=data.centent;
				$("#notice-title").text(data.title);
			    $("#notice-centent").html($("#notice-centent").text());
				$modal.modal('open');
			}
		}
	});
}

function addNotice(userId){
	window.location.href="/HROA/notice/add.jsp";
}

$(document).ready(function(){
	var totalPage=$("#hidden-pages").val();
	var currentPage=$("#hidden-currentPage").val();
	$('#notice-list').DataTable({
	  	responsive: true,
	  	dom: 'ti'
	});
	
	$('#addNotice').on('click',function(){
		window.location.href="/HROA/notice/add.jsp";
	});
	
	$("#noticePages").page({
        pages:totalPage,
        curr:currentPage, 
        groups:2,
        jump:function(context,first){
            if(!first){
            	location.href="/HROA/notice/gtNtList.html?pageSize=10&startPage="+context.option.curr;
            }
        }
    });
	
	var nulTxt=document.getElementsByClassName("dataTables_empty");
	if(nulTxt.length>0){
		$(".dataTables_empty").text("暂无数据！");
		$(".odd").css("text-align","center");
	}
})
</script>
</html>
