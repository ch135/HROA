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
		  	<li>位置：<a href="#">角色管理</a></li>
		  	<li class="am-active">角色授权(管理员)</li>
		</ol>
		<form class="am-form am-form-horizontal" action="#" method="post">
			<input type="hidden" value="1_2_6_5_3" class="fileds">
			<input type="hidden" value="1" name="currentPage">
			<input type="hidden" value="3" name="id">
			<hr>
			<table class="am-table">
			    <tbody>	
			        <tr class="permission-list0">
			            <td class="permission-list1" style="width:15%;vertical-align: middle;">
			            	<small><input type="checkbox" id="p1" name="assgin-power" value="p1">基本信息中心</small>
			            </td>
			            <td>
							<table class="am-table">
								<tbody>
								    <tr class="permission-list2">
								        <td class="permission-list3" style="border-top-style:none;border-bottom:1px solid #ddd;vertical-align: middle;">
								        	<small class="am-text-primary ">
								        		<input type="checkbox" id="p12" name="assgin-power" value="p12">系统用户管理
								        	</small>
								        </td>
								        <td class="permission-list4" style="border-top-style:none;border-bottom:1px solid #ddd;">
									        <ul class="am-avg-sm-2 am-avg-md-3 am-avg-lg-4">
									  		<li>
										  		<small>
										  			<input type="checkbox" id="p121" name="assgin-power" value="p121">查看用户信息
												</small>
											</li>
											<li>				        
												<small>
													<input type="checkbox" id="p123" name="assgin-power" value="p123"> 修改用户
												</small>
											</li>
											<li>		        
											 	<small>
											 		<input type="checkbox" id="p122" name="assgin-power" value="p122"> 添加用户
												</small>
											</li>
											</ul>        
										</td>
								    </tr>
								    <tr class="permission-list2">
								        <td class="permission-list3" style="border-top-style:none;border-bottom:1px solid #ddd;vertical-align: middle;">
								        	<small class="am-text-primary "><input type="checkbox" id="p11"name="assgin-power" value="p11">用户角色管理</small>
								        </td>
								        <td class="permission-list4" style="border-top-style:none;border-bottom:1px solid #ddd;">
									        <ul class="am-avg-sm-2 am-avg-md-3 am-avg-lg-4">
									  		<li>
										  		<small>
										  			<input type="checkbox" id="p114" name="assgin-power" value="p114"> 添加角色
												</small>
											</li>
											<li>				        
												<small>
													<input type="checkbox" id="p113" name="assgin-power" value="p113"> 修改角色
												</small>
											</li>
											<li>		        
											 	<small>
											 		<input type="checkbox" id="p112" name="assgin-power" value="p112"> 角色授权
												</small>
											</li>
											</ul>        
										</td>
								    </tr>
								   <!--  <hr> -->
								</tbody>
							</table>
						</td>
			        </tr>
			        <tr class="permission-list0">
			            <td class="permission-list1" style="width:15%;vertical-align: middle;">
			            	<small><input type="checkbox" id="p3" name="assgin-power" value="p3">企业管理</small>
			            </td>
			            <td>
							<table class="am-table">
								<tbody>
								    <tr class="permission-list2">
								        <td class="permission-list3" style="border-top-style:none;border-bottom:1px solid #ddd;vertical-align: middle;">
								        	<small class="am-text-primary ">
								        		<input type="checkbox" id="p31" name="assgin-power" value="p31">合同管理
								        	</small>
								        </td>
								        <td class="permission-list4" style="border-top-style:none;border-bottom:1px solid #ddd;">
									        <ul class="am-avg-sm-2 am-avg-md-3 am-avg-lg-4 ">
										  		<li>
											  		<small>
											  			<input type="checkbox" id="p311" name="assgin-power" value="p311">查看所有合同
													</small>
												</li>
												<li>
											  		<small>
											  			<input type="checkbox" id="p312" name="assgin-power" value="p312">编辑所有合同
													</small>
												</li>
											</ul>        
										</td>
								    </tr>
								   <!--  <hr> -->
								</tbody>
							</table>
						</td>
			        </tr>
			        
			        <tr class="permission-list0">
			            <td class="permission-list1" style="width:15%;vertical-align: middle;">
			            	<small><input type="checkbox" id="p4" name="assgin-power" value="p4">代理管理</small>
			            </td>
			            <td>
							<table class="am-table">
								<tbody>
								    <tr class="permission-list2">
								        <td class="permission-list3" style="border-top-style:none;border-bottom:1px solid #ddd;vertical-align: middle;">
								        	<small class="am-text-primary ">
								        		<input type="checkbox" id="p41" name="assgin-power" value="p41">合同管理
								        	</small>
								        </td>
								        <td class="permission-list4" style="border-top-style:none;border-bottom:1px solid #ddd;">
									        <ul class="am-avg-sm-2 am-avg-md-3 am-avg-lg-4 ">
										  		<li>
											  		<small>
											  			<input type="checkbox" id="p411" name="assgin-power" value="p411">查看所有合同
													</small>
												</li>
												<li>
											  		<small>
											  			<input type="checkbox" id="p412" name="assgin-power" value="p412">编辑所有合同
													</small>
												</li>
												<li>
											  		<small>
											  			<input type="checkbox" id="p413" name="assgin-power" value="p413">查看自身合同
													</small>
												</li>
												<li>
											  		<small>
											  			<input type="checkbox" id="p414" name="assgin-power" value="p414">编辑自身合同
													</small>
												</li>
											</ul>        
										</td>
								    </tr>
								   <!--  <hr> -->
								</tbody>
							</table>
						</td>
			        </tr>	  	     	  	        
			    </tbody>
			</table>
			<hr>
			<div class="am-form-group">
			   	<div class="am-u-sm-10 am-u-sm-offset-2">
			     	<input id="sub-power" type="button" class="am-btn am-btn-primary" value="授权">
			  	</div>
			</div>
		</form>
	</div>
		<!-- content end -->
<!-- <footer>
    <hr>
    <p class="am-padding-left">©Copyright &copy;2017 All Rights Reserved huizhouxueyuan development team</p>
</footer> -->
<input type="hidden" id="hidden-roleId" value="${roleId}">
</body>
<script src="/HROA/js/jquery.min.js"></script>
<script src="/HROA/assets/js/amazeui.min.js"></script>
<script src="${pageContext.request.contextPath}/public/am-dialog/dist/amazeui.dialog.min.js"></script>
<script type="text/javascript">
/* var powerJson={"p1":"p1","p2":"p2"}; */
/* function getJsonLength(jsonData){    
    var jsonLength = 0;  
    for(var item in jsonData){  
        jsonLength++;  
  
    }  
    return jsonLength;  
}  */ 
/* if(powerJson.p2!=null){
	alert(powerJson.p2);
	$("#"+powerJson.p2).attr("checked","checked");
} */
$(function(){
	$(".permission-list0 .permission-list1 input:checkbox").click(function(){
		$(this).closest("tr").find("td input:checkbox").prop("checked",$(this).prop("checked"));
	});
	
	$(".permission-list2 .permission-list3 input:checkbox").click(function(){
		$(this).parents(".permission-list0").find("td").first().find("input:checkbox").prop("checked",true);
		$(this).parents(".permission-list2").find("ul").closest("ul").find("small input:checkbox").prop("checked",$(this).prop("checked"));
		if($(this).parents(".permission-list0").find(".permission-list2 input:checked").length==0){
			$(this).parents(".permission-list0").find("td").first().find("input:checkbox").prop("checked",false);
		}
	});
	
	$(".permission-list4 li input:checkbox").click(function(){
		$(this).parents(".permission-list2").find("td").first().find("input:checkbox").prop("checked",true);
		$(this).parents(".permission-list0").find("td").first().find("input:checkbox").prop("checked",true);
		if($(this).parents(".permission-list4").find("input:checked").length==0){
			$(this).parents(".permission-list2").find("td").first().find("input:checkbox").prop("checked",false);
			/* $(this).parents(".permission-list0").find("td").first().find("input:checkbox").prop("checked",false); */
		}
		if($(this).parents(".permission-list0").find(".permission-list2 input:checked").length==0){
			$(this).parents(".permission-list0").find("td").first().find("input:checkbox").prop("checked",false);
		}
	});

	$.ajax({
		url:"/HROA/rbac/getPrev.html",
		type:'post',
		data:{method:"alertPrev",roleId:$('#hidden-roleId').val()},
		dataType:'json',
		success:function(data){
			if(data.pre!=null){
				var powerArray= data.pre.split(",");
				for(var power in powerArray){
					$("#"+powerArray[power]).attr("checked","checked");
				}
			}
		}
	});
	
});

var powerList=''; 
function getCompetenceArrayId(){
	var obj=document.getElementsByName('assgin-power'); 
	for(var i=0; i<obj.length;i++){ 
		if(obj[i].checked==true) {
		powerList+=obj[i].value+',';
		} 
	};
}

$("#sub-power").click(function(){
	getCompetenceArrayId();
	if(powerList!=null&&powerList!=""){
		$.ajax({
			url:"/HROA/rbac/assignRole.html",
			type:'post',
			data:{roleId:$('#hidden-roleId').val(),rolePowers:powerList},
			dataType:'json',
			success:function(data){
				if(data.status==1){
					AMUI.dialog.alert({
				    	title: '提示',
				    	content: '授权成功!',
				    	onConfirm: function() {
				      		
				    	}
				  	});
				} 
			}
		});
	}
})
</script>
</html>