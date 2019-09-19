<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html class="no-js">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>OA办公系统</title>
  <meta name="description" content="这是一个 user 页面">
  <meta name="keywords" content="user">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="renderer" content="webkit">
  <meta http-equiv="Cache-Control" content="no-siteapp" />
  <link rel="icon" type="image/png" href="../assets/i/favicon.png">
  <link rel="apple-touch-icon-precomposed" href="../assets/i/app-icon72x72@2x.png">
  <meta name="apple-mobile-web-app-title" content="Amaze UI" />
  <link rel="stylesheet" href="../assets/css/amazeui.min.css"/>
  <link rel="stylesheet" href="../assets/css/admin.css">
</head>
<body>

  <div class="admin-content">
    <div class="admin-content-body">
      <div class="am-cf am-padding am-padding-bottom-0">
        <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">学生资料</strong> / <small>Personal information</small></div>
      </div>

      <hr/>

      <div class="am-g">
        <div class="am-u-sm-12 am-u-md-4 am-u-md-push-8">
        </div>

        <div class="am-u-sm-12 am-u-md-8 am-u-md-pull-4">
          <form id="doc-vld-msg" class="am-form am-form-horizontal" action="/HROA/ShUser/addShUserUI.html">
          	 <div class="am-form-group">
              <label for="user-phone" class="am-u-sm-3 am-form-label">联系电话</label>
              <div class="am-u-sm-9">
                <input type="tel" class="temp" name="telephone" id="telephone" placeholder="联系电话 / Telephone" required>
              </div>
            </div>
          
            <div class="am-form-group">
              <label for="user-name" class="am-u-sm-3 am-form-label">学生姓名</label>
              <div class="am-u-sm-9">
                <input name="realname" class="temp" type="text" id="realname" placeholder="姓名 / Name" required >
              </div>
            </div>
            
            
          <div class="am-form-group">
            <label for="user-name" class="am-u-sm-3 am-form-label">性别</label>
            <div class="am-u-sm-9">
            	 <label class="am-radio-inline">
			        <input id="man"  type="radio"  value="男" name="sex"  checked="checked"  required>男
			      </label>
			      <label class="am-radio-inline">
			        <input id="woman"  type="radio" value="女" name="sex">女
			      </label>
            </div>
          </div>


            <div class="am-form-group">
              <label for="user-QQ" class="am-u-sm-3 am-form-label">身份证</label>
              <div class="am-u-sm-9">
                <input name="idcard" class="temp" type="text"   id="idcard" placeholder="身份证 / IdCard" required>
              </div>
            </div>
            
              <div class="am-form-group am-form-inline">
              <label for="user-email" class="am-u-sm-3 am-form-label">地址</label>
	             <div class="am-u-md-9 am-u-sm-9" style="padding-left: 0px;padding-right: 0px;">
	             <div class=" am-u-sm-6 am-u-md-4">
			      <select id="s_province" name="province"  pattern="^(?!省份).*$" required>
			        <option value="option1">选项一...</option>
			        <option value="option2">选项二.....</option>
			        <option value="option3">选项三........</option>
			      </select>
			    </div>
			     <div class=" am-u-sm-6 am-u-md-4 am-form-group" >
			      <select id="s_city" name="city"  pattern="^(?!地级市).*$" required>
			        <option value="option1">选项一...</option>
			        <option value="option2">选项二.....</option>
			        <option value="option3">选项三........</option>
			      </select>
			    </div>
			    <div class="am-u-sm-12 am-u-md-4  am-u-end">
			      <select id="s_county" name="region"  pattern="^(?!市、县级市).*$"  required>
			        <option value="option1">选项一...</option>
			        <option value="option2">选项二.....</option>
			        <option value="option3">选项三........</option>
			      </select>
			    </div>
			    </div>
            </div>
               
             <div class="am-form-group">
               <div class="am-u-sm-2 am-u-sm-push-1">
               		 <select id="machine_num" name="machine_num" >
               		 <c:if test="${machine_num!=null }">
               		 	<option value="${machine_num }">${machine_num }</option>
               		 </c:if>
			      	</select>
          	  </div>
              <div class="am-u-sm-9">
              <button type="button" onclick="readIdCard()" class="am-btn am-btn-primary am-btn-block">读取身份证</button>
              </div>
            </div>
            
            <hr>
            
              <div class="am-form-group">
              <label for="user-weibo" class="am-u-sm-3 am-form-label">输送单位</label>
              <div class="am-u-sm-9">
                <input name="sendUnit"  value="${enterCom.sendUnit }" type="text" id="transport" placeholder="输送单位 / Transport" required>
              </div>
            </div>

            <div class="am-form-group">
              <label for="user-weibo" class="am-u-sm-3 am-form-label">输送联系人电话</label>
              <div class="am-u-sm-9">
                <input name="sendTelephone"  value="${enterCom.sendTelephone }" type="text" id="telephone" placeholder="输送联系人电话 / Telephone" required>
              </div>
            </div>
            
            <div class="am-form-group">
              <label for="user-weibo" class="am-u-sm-3 am-form-label">所进企业</label>
              <div class="am-u-sm-9">
                <input name="sendCompany" type="text" id="company"  value="${enterCom.sendCompany }"  placeholder="所进企业 / Company" required>
              </div>
            </div>
            
            <div class="am-form-group">
              <label for="user-weibo" class="am-u-sm-3 am-form-label">驻厂管理</label>
              <div class="am-u-sm-9">
                <input name="workerId" type="text" id="company" value="${enterCom.workerId }"  placeholder="驻厂管理 / Manager" required>
              </div>
            </div>
            
            <div class="am-form-group">
              <label for="user-weibo" class="am-u-sm-3 am-form-label">驻厂管理电话</label>
              <div class="am-u-sm-9">
                <input name="managerTel" type="text" id="company"  value="${enterCom.managerTel }"  placeholder="驻厂管理 / Manager" required>
              </div>
            </div>

            <div class="am-form-group">
              <div class="am-u-sm-9 am-u-sm-push-3">
              <button type="button" onclick="registerUser()" class="am-btn am-btn-primary am-btn-block">添加用户信息</button>
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


<a href="#" class="am-icon-btn am-icon-th-list am-show-sm-only admin-menu" data-am-offcanvas="{target: '#admin-offcanvas'}"></a>

<footer>
  <hr>
  <p class="am-padding-left">©Copyright &copy;2017 All Rights Reserved huizhouxueyuan development team</p>
</footer>

<!--[if lt IE 9]>
<script src="http://libs.baidu.com/jquery/1.11.3/jquery.min.js"></script>
<script src="http://cdn.staticfile.org/modernizr/2.8.3/modernizr.js"></script>
<script src="assets/js/amazeui.ie8polyfill.min.js"></script>
<![endif]-->

<script src="../assets/js/jquery.min.js"></script>
<script src="../assets/js/amazeui.min.js"></script>
<script src="../assets/js/app.js"></script>
<script type="text/javascript" src="../js/dist/amazeui.dialog.js"></script>
<script class="resources library" src="/HROA/company/js/area.js" type="text/javascript"></script>
<script type="text/javascript">_init_area();</script>
<script type="text/javascript">
function ajax(url, form, after) {
	$.ajax({
		url : url,
		type : "post",
		data : form,
		success : after
	});
}
function check(){
$('form:first').validator({
    onValid: function(validity) {
      $(validity.field).closest('.am-form-group').find('.am-alert').hide();
    },
    onInValid: function(validity) {
      var $field = $(validity.field);
      var $group = $field.closest('.am-form-group');
      var $alert = $group.find('.am-alert');
      // 使用自定义的提示信息 或 插件内置的提示信息
      var msg = $field.data('validationMessage') || this.getValidationMessage(validity);
      $alert.html(msg).show();
    }
 });
}


//提示
function do_confirm(content,do_confirm_after){
 AMUI.dialog.confirm(
		 { title: '提示', 
		   content: content, 
		   onConfirm: do_confirm_after, 
		   onCancel: function() { console.log('onCancel') 
		 } });
}

//提交表单
function registerUser(){
	$("form:first").removeAttr("novalidate");
	check();
	$("form:first").validator('isFormValid');
	if($(".am-field-error").size()==0)
	do_confirm("确认提交?", function() {
		ajax("/HROA/ShUser/addShUser.html",$("form:first").serialize(),function(data){
		var obj = eval('(' + data + ')');
		if(obj.result=='success')
		  AMUI.dialog.alert({
		      title: '提示',
		      content: "添加成功",
		      onConfirm: function() {
		      	$("form:first").submit();
		      }
		    });
		});
	}); 
}
//读取身份证
function readIdCard(){
	var value=$("#machine_num").find("option:selected").val();
	if(value>=0){
		$.getJSON("/HROA/ShUser/readIdCard.html?num="+value, function(json){
			showIdCard(json);
		});
	}
}
$('#telephone').bind('input propertychange', function() {
    var telephone=$(this).val();
 	$.getJSON("/HROA/ShUser/getShUser.html?telephone="+telephone, function(json){
 		showIdCard(json);
	});
});

function showIdCard(json){
		$("#s_province").find("option[value='省份']").attr("selected",true);
		$("#s_province").trigger("change");
		$("#realname").val(json.realname);
		$("#realname").trigger("change");
 		$("#idcard").val(json.idcard);
 		$("#idcard").trigger("change");
 		$("input[name='sex']").removeAttr("checked");
 		if(json.sex=='男'){
 		$("input[name='sex']:eq(0)").attr("checked",'checked'); 
 		$("input[name='sex']:eq(0)").click();
 		}else if(json.sex=='女'){
 		$("input[name='sex']:eq(1)").attr("checked",'checked'); 
 		$("input[name='sex']:eq(1)").click();
 		}
 		$("input[name='sex']:eq(1)").trigger("change");
 		 if(json.province==null){
 		 	 $("#s_province").find("option[value='省份']").attr("selected",true);
			 $("#s_province").trigger("change");
 		 }
 		 if(json.province!=null){
 		 	 $("#s_province").find("option[value^="+json.province+"]").attr("selected",true);
			 $("#s_province").trigger("change");
			 $("#s_city").find("option[value^="+json.city+"]").attr("selected",true);
			 $("#s_city").trigger("change");
			 $("#s_county").find("option[value^="+json.region+"]").attr("selected",true);
			 $("#s_county").trigger("change");
 		 }
}

$(function(){
	getMachineNum();
});

function getMachineNum(){
	$.getJSON("/HROA/ShUser/getCode.html",function(data){
		var  value=$("#machine_num").find("option:selected").text();
		$("#machine_num").html("");
		for(var item in data){
		 	$("#machine_num").append("<option value='"+data[item]+"'>"+data[item]+"</option>");
		}
		if(value)
		$("#machine_num").find("option[value="+value+"]").attr("selected",true);
		setTimeout(getMachineNum,5000);
	});
}
</script>
</body>
</html>
