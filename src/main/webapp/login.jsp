<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head lang="en">
	<meta charset="UTF-8">
	<title>OA办公系统</title>
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="format-detection" content="telephone=no">
	<meta name="renderer" content="webkit">
	<meta http-equiv="Cache-Control" content="no-siteapp" />
	<link rel="alternate icon" type="image/png" href="${pageContext.request.contextPath}/assets/i/favicon.png">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/amazeui.min.css"/>
	<style>
	.header,.copyright{
	  	text-align: center;
	}
	.header h1 {
		font-size: 200%;
		color: #333;
		margin-top: 30px;
	}
	.header p {
	  	font-size: 14px;
	}
	.copy {
	  	text-align: center;
	}
	</style>
</head>
<body>
<!-- header start -->
<div class="header">
    <div class="am-g">
    	<h1>OA 办公系统</h1>
    	<p>账号密码:admin<br/>
    	<p>welcome access system<br/>欢迎访问系统</p>
    </div>
  	<hr />
</div>
<!-- header end -->

<!-- tips start -->
<%@include file="./public/tips.jsp" %>
<!-- tips end -->

<!-- main start -->
<div class="am-g">
	<div class="am-u-lg-4 am-u-md-8 am-u-sm-centered">
	    <form method="post" class="am-form">
	        <div class="am-form-group ">
		        <div class="am-input-group am-input-group-primary">
				    <span class="am-input-group-label"><i class="am-icon-user am-icon-fw"></i></span>
				    <input id="account" type="text" class="am-form-field" placeholder="账号">
			    </div>
	        </div>
	        
		    <div class="am-form-group ">
			    <div class="am-input-group am-input-group-primary">
				    <span class="am-input-group-label"><i class="am-icon-lock am-icon-fw"></i></span>
				    <input id="password" type="password" class="am-form-field" placeholder="密码">
			    </div>
	        </div>
	        
	        <div class="am-cf">
		        <input id="lg" type="button" name="" value="登 录" class="am-btn am-btn-primary am-btn-sm am-fl am-u-sm-12">
		        <!-- <input type="submit" name="" value="忘记密码 ^_^? " class="am-	tn am-btn-default am-btn-sm am-fr"> -->
	        </div>
	    </form>
	    <hr>
	    <p class="am-padding-left copyright">&copy;Copyright 2017 All Rights  <br/> Reserved huizhouxueyuan development team</p>
	</div>
</div>
<!-- main end -->
</body>
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/amazeui.js"></script>
<script type="text/javascript">
if (top.location != self.location){     
    top.location=self.location;     
}
$(function() {
    var $modal= $('#lg-tips');
    $('#lg').on('click', function(e) {
    	if($("#account").val()==null||$("#account").val()==""){
    		$("#inner-text").text("账号不能为空!");
    		$modal.modal();
    	}else if($("#password").val()==null||$("#password").val()==""){
    		$("#inner-text").text("密码不能为空！");
    		$modal.modal();
    	}else{
    		$.ajax({
				url:"/HROA/lg/userlg.html",
				type:'post',
				data:{account:$('#account').val(),password:$('#password').val()},
				dataType:'json',
				success:function(data){
					if(data.lgstatus==1){
						location.href="/HROA/index.jsp";
					}else{
						location.href="/HROA/index.jsp";
					} 
				}
			});
    	}
    });
});
</script>
</html>
