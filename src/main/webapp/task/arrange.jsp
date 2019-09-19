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
</head>
<style>
	@media screen and (min-width:375px) and (max-width:675px){
		  	.am-u-sm-2 {
			    width: 20%;
			}
	  	}
</style>
<body>
  	<!-- content start -->
  	<div class="admin-content">
      	<ol class="am-breadcrumb">
		  	<li>位置：<a href="#">任务列表</a></li>
		  	<li class="am-active">任务分配</li>
		</ol>
		<form class="am-form am-form-horizontal" action="#" method="post">
			<hr>
			<div class="am-g">
			  	<div class="am-u-sm-10">
				  	<div class="am-g">
					  	<div class="am-u-sm-3 am-vertical-align dpname">
						  	<div class="am-vertical-align-middle dpname-select">
							  	<input id="deptName" type="checkbox"> 
							  	<small  class="am-text-primary" ><strong>${deptName}</strong></small>
						  	</div>
					  	</div>
					  	<c:forEach var="rowAmount" begin="0" end="${lineAmount-1}">
					  		<div class="am-u-sm-9 am-fr task">
					  			<ul class="am-avg-sm-2 am-avg-md-3 am-avg-lg-4 task-select">
					  			<c:choose>
							  		<c:when test="${rowAmount==(lineAmount-1)}">
							  			<c:forEach var="colAmount" begin="${rowAmount*4}"  end="${totalAmount-1}">
							  			<li>
									  		<small>
									  			<input type="checkbox" id="user${adminList[colAmount].id}" name="user-id" value="${adminList[colAmount].id}">${adminList[colAmount].nickname}
											</small>
										</li>
							  			</c:forEach>
							  		</c:when>
							  		<c:otherwise>
							  			<c:forEach var="colAmount" begin="${rowAmount*4}"  end="${(rowAmount+1)*4-1}">
							  			<li>
									  		<small>
									  			<input type="checkbox" id="user${adminList[colAmount].id}" name="user-id" value="${adminList[colAmount].id}">${adminList[colAmount].nickname}
											</small>
										</li>
							  			</c:forEach>
							  		</c:otherwise>
							  	</c:choose>
					  			</ul>
					  		</div>
					  	</c:forEach>
				  	</div>
			  	</div>
			</div>
			<hr>
			<div class="am-form-group">
			   	<div class="am-u-sm-10 am-u-sm-offset-2">
			     	<input type="button" id="arrangeUsers" class="am-btn am-btn-primary" value="分配">
			  	</div>
			</div>
		</form>
	</div>
		<!-- content end -->
<!-- <footer>
    <hr>
    <p class="am-padding-left">©Copyright &copy;2017 All Rights Reserved huizhouxueyuan development team</p>
</footer> -->
<input type="hidden" id="hidden-taskId" value="${taskId}">
</body>
<script src="/HROA/js/jquery.min.js"></script>
<script src="/HROA/assets/js/amazeui.min.js"></script>
<script src="${pageContext.request.contextPath}/public/am-dialog/dist/amazeui.dialog.min.js"></script>
<script type="text/javascript">
$(function(){
	$(".dpname .dpname-select input:checkbox").click(function(){
		$(this).closest(".am-g").find("li input:checkbox").prop("checked",$(this).prop("checked"));
	});
	
	$(".task .task-select input:checkbox").click(function(){
		$(this).parents(".am-g").find(".dpname-select").first().find("input:checkbox").prop("checked",true);
		if($(this).parents(".am-g").find(".task input:checked").length==0){
			$(this).parents(".am-g").find(".dpname-select").first().find("input:checkbox").prop("checked",false);
		}
	});
	
	$.ajax({
		url:"/HROA/task/getUsersId.html",
		type:'post',
		data:{taskId:$('#hidden-taskId').val()},
		dataType:'json',
		success:function(data){
			if(data.usersId!=null){
				var usersIdArray= data.usersId.split(",");
				for(var userId in usersIdArray){
					$("#user"+userId).attr("checked","checked");
				}
				$("#deptName").attr("checked",true);
			}
		}
	});
});

var taskToUserList=''; 
function getTaskToUsers(){
	var obj=document.getElementsByName('user-id'); 
	for(var i=0; i<obj.length; i++){
		if(obj[i].checked) {
			taskToUserList+=obj[i].value+',';
		} 
	};
}


$("#arrangeUsers").click(function(){
	getTaskToUsers();
	$.ajax({
		url:"/HROA/task/gtTsListByUsId.html",
		type:'post',
		data:{taskId:$("#hidden-taskId").val(),users_id:taskToUserList},
		dataType:'json',
		success:function(data){
			if(data.status==1){
				AMUI.dialog.alert({
			    	title: '提示',
			    	content: '分配成功!',
			    	onConfirm: function() {
			      		/* location.reload(); */
			    	}
			  	});
			} 
		}
	});
})
</script>
</html>