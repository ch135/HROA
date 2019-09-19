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
        <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">工作资料</strong> / <small>Personal information</small></div>
      </div>

      <hr/>

      <div class="am-g">
        <div class="am-u-sm-12 am-u-md-4 am-u-md-push-8">
        </div>

        <div class="am-u-sm-12 am-u-md-8 am-u-md-pull-4">
          <form id="doc-vld-msg" class="am-form am-form-horizontal" action="/HROA/Jobinfo/addJobinfo.html">
          <input id="page" type="text" name="cId" value="${company.id }" style="visibility: hidden;position: absolute;">
         	<div class="am-form-group">
              <label for="user-name" class="am-u-sm-3 am-form-label">工作岗位</label>
              <div class="am-u-sm-9">
                <input  type="text" id="name" placeholder="企业名称 / company" value="${company.name }" required disabled="disabled">
              </div>
            </div>
          
            <div class="am-form-group">
              <label for="user-name" class="am-u-sm-3 am-form-label">工作岗位</label>
              <div class="am-u-sm-9">
                <input name="job" type="text" id="name" placeholder="姓名 / Job" value="${jobinfo.job }" required disabled="disabled">
              </div>
            </div>
            
            <div class="am-form-group">
              <label for="user-name" class="am-u-sm-3 am-form-label">招聘人数</label>
              <div class="am-u-sm-9">
                <input name="number" type="text" id="name" placeholder="招聘人数 / number"  value="${jobinfo.number }"  disabled="disabled">
              </div>
            </div>
            
            <div class="am-form-group">
            <label for="user-name" class="am-u-sm-3 am-form-label">结算</label>
            <div class="am-u-sm-9">
            	<select  id="doc-select-1" name="type" disabled="disabled">
					<option value="1" ${type=='1'?'selected':'' }>同工同酬</option>
					<option value="0" ${type=='0'?'selected':'' }>按小时计算</option>
				</select>
            </div>
            </div>
            
             <div class="am-form-group">
            <label for="user-name" class="am-u-sm-3 am-form-label">薪资</label>
            <div class="am-u-sm-9">
            	<select  id="doc-select-1" name="unit" disabled="disabled">
					<option value="1" ${unit=='1'?'selected':'' }>月薪</option>
					<option value="0" ${unit=='0'?'selected':'' }>时新</option>
				</select>
            </div>
            </div>
            
            <div class="am-form-group">
              <label for="user-name" class="am-u-sm-3 am-form-label">基本工资</label>
              <div class="am-u-sm-9">
                <input name="salary" type="text" id="name" value="${jobinfo.salary }" placeholder="基本工资 / Salary" required disabled="disabled">
              </div>
            </div>
            
            <div class="am-form-group">
              <label for="user-name" class="am-u-sm-3 am-form-label">加班工资</label>
              <div class="am-u-sm-9">
                <input name="moreSalary" type="text" id="name"  value="${jobinfo.moreSalary }"  placeholder="加班工资 / More-Salary" required disabled="disabled">
              </div>
            </div>
           
            
            <div class="am-form-group">
              <label for="user-name" class="am-u-sm-3 am-form-label">联系人</label>
              <div class="am-u-sm-9">
                <input name="linkMan" type="text" id="name" value="${jobinfo.linkMan }" placeholder="联系人 / Link-Man" required disabled="disabled">
              </div>
            </div>
            
            <div class="am-form-group">
              <label for="user-name" class="am-u-sm-3 am-form-label">联系人电话</label>
              <div class="am-u-sm-9">
                <input name="linkPhone" type="tel" id="name" value="${jobinfo.linkPhone}" placeholder="联系人电话 / Link-Phone" required disabled="disabled">
              </div>
            </div>
            
            <div class="am-form-group">
            <label for="user-name" class="am-u-sm-3 am-form-label">工作类别</label>
            <div class="am-u-sm-9">
            	<select  id="doc-select-1" name="classify" disabled="disabled">
					<option value="假期工" ${classify=='假期工'?'selected':'' }>假期工</option>
					<option value="长期工" ${classify=='长期工'?'selected':'' }>长期工</option>
					<option value="实习就业" ${classify=='实习就业'?'selected':'' }>实习就业</option>
				</select>
            </div>
            </div>
            
            
            <div class="am-form-group">
              <label for="user-name" class="am-u-sm-3 am-form-label">福利</label>
              <div class="am-u-sm-9">
                <input name="label" type="text" id="name" value="${jobinfo.label }" placeholder="福利 / Label" required disabled="disabled">
              </div>
            </div>
            
             <div class="am-form-group am-form-inline">
              <label for="user-email" class="am-u-sm-3 am-form-label">工作地址</label>
	             <div class="am-u-md-9 am-u-sm-9" style="padding-left: 0px;padding-right: 0px;">
	             <div class=" am-u-sm-6 am-u-md-4">
			      <select id="s_province" name="province" disabled="disabled">
			        <option value="option1">选项一...</option>
			        <option value="option2">选项二.....</option>
			        <option value="option3">选项三........</option>
			      </select>
			    </div>
			     <div class=" am-u-sm-6 am-u-md-4 am-form-group" >
			      <select id="s_city" name="city" disabled="disabled">
			        <option value="option1">选项一...</option>
			        <option value="option2">选项二.....</option>
			        <option value="option3">选项三........</option>
			      </select>
			    </div>
			    <div class="am-u-sm-12 am-u-md-4  am-u-end">
			      <select id="s_county" name="region" disabled="disabled">
			        <option value="option1">选项一...</option>
			        <option value="option2">选项二.....</option>
			        <option value="option3">选项三........</option>
			      </select>
			    </div>
			    </div>
            </div>

			<div class="am-form-group">
              <label for="user-name" class="am-u-sm-3 am-form-label">具体地址</label>
              <div class="am-u-sm-9">
                <input name="details" type="text" id="name" value="${jobinfo.details }" placeholder="具体地址 / details" required disabled="disabled">
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

<!--[if (gte IE 9)|!(IE)]><!-->
<script src="../assets/js/jquery.min.js"></script>
<!--<![endif]-->
<script src="../assets/js/amazeui.min.js"></script>
<script type="text/javascript" src="../js/dist/amazeui.dialog.js"></script>
<script class="resources library" src="/HROA/company/js/area.js" type="text/javascript"></script>
<script type="text/javascript">_init_area();</script>
<script src="../assets/js/app.js"></script>
<script type="text/javascript">
var Gid  = document.getElementById ;
var showArea = function(){
	Gid('show').innerHTML = "<h3>省" + Gid('s_province').value + " - 市" + 	
	Gid('s_city').value + " - 县/区" + 
	Gid('s_county').value + "</h3>"
}

window.onload=function(){
 $("#s_province").find("option[value='${jobinfo.province}']").attr("selected",true);
 $("#s_province").trigger("change");
 $("#s_city").find("option[value='${jobinfo.city}']").attr("selected",true);
 $("#s_city").trigger("change");
 $("#s_county").find("option[value='${jobinfo.region}']").attr("selected",true);
}


function do_confirm(content,do_confirm_after){
 AMUI.dialog.confirm(
		 { title: '提示', 
		   content: content, 
		   onConfirm: do_confirm_after, 
		   onCancel: function() { console.log('onCancel') 
		 } });
}
function do_add(){
	do_confirm("确认提交?", function() {
		$("form:first").submit();
	});
}
$('#doc-vld-msg').validator({
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
</script>
</body>
</html>
