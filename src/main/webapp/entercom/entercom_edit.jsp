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
        <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">入职记录${leave }"</strong> / <small>Personal information</small></div>
      </div>

      <hr/>

      <div class="am-g">
        <div class="am-u-sm-12 am-u-md-4 am-u-md-push-8">
        </div>

        <div class="am-u-sm-12 am-u-md-8 am-u-md-pull-4">
          <form id="doc-vld-msg" class="am-form am-form-horizontal" action="/HROA/EnterCom/saveEnterComUI.html">
          	<input id="enterComid" type="text" name="enterComid" value="${enterCom.enterComid }" style="visibility: hidden;position: absolute;">
          	<input id="aa" type="text" name="leave" value="${leave }" style="visibility: hidden;position: absolute;">
            <div class="am-form-group">
              <label for="user-name" class="am-u-sm-3 am-form-label">学生姓名</label>
              <div class="am-u-sm-9">
                <input name="realname" type="text" id="name" value="${user.realname}" placeholder="姓名 / Name" required  disabled >
              </div>
            </div>
            
            
          <div class="am-form-group">
            <label for="user-name" class="am-u-sm-3 am-form-label">性别 </label>
            <div class="am-u-sm-9">
            	 <label class="am-radio-inline">
			        <input type="radio"  value="男"  ${user.sex=='男'?'checked':''} name="sex"  disabled >男
			      </label>
			      <label class="am-radio-inline">
			         <input type="radio"  value="男"  ${user.sex=='女'?'checked':''} name="sex"  disabled >女
			      </label>
            </div>
          </div>

            <div class="am-form-group">
              <label for="user-phone" class="am-u-sm-3 am-form-label">联系电话</label>
              <div class="am-u-sm-9">
                <input type="tel" name="telephone" id="user-phone" value="${user.telephone}" placeholder="联系电话 / Telephone" required disabled >
              </div>
            </div>

            <div class="am-form-group">
              <label for="user-QQ" class="am-u-sm-3 am-form-label">身份证</label>
              <div class="am-u-sm-9">
                <input name="idcard"  type="text"   id="idcard"  value="${user.idcard}" placeholder="身份证 / IdCard" required disabled >
              </div>
            </div>
            <hr>
            
              <div class="am-form-group">
              <label for="user-weibo" class="am-u-sm-3 am-form-label">输送单位</label>
              <div class="am-u-sm-9">
                <input name="sendUnit" type="text" id="transport" value="${enterCom.sendUnit}"  placeholder="输送单位 / Transport" required>
              </div>
            </div>

            <div class="am-form-group">
              <label for="user-weibo" class="am-u-sm-3 am-form-label">输送联系人电话</label>
              <div class="am-u-sm-9">
                <input name="sendTelephone" type="text" id="telephone" value="${enterCom.sendTelephone}"  placeholder="输送联系人电话 / Telephone" required>
              </div>
            </div>
            
            <div class="am-form-group">
              <label for="user-weibo" class="am-u-sm-3 am-form-label">所进企业</label>
              <div class="am-u-sm-9">
                <input name="sendCompany" type="text" id="company" value="${enterCom.sendCompany}"  placeholder="所进企业 / Company" required>
              </div>
            </div>
            
            <div class="am-form-group">
              <label for="user-weibo" class="am-u-sm-3 am-form-label">驻厂管理</label>
              <div class="am-u-sm-9">
                <input name="workerId" type="text" id="company" value="${enterCom.workerId}" placeholder="驻厂管理 / Manager" required>
              </div>
            </div>
            
            <div class="am-form-group">
              <label for="user-weibo" class="am-u-sm-3 am-form-label">驻厂管理电话</label>
              <div class="am-u-sm-9">
                <input name="managerTel" type="text" id="company" value="${enterCom.managerTel}"  placeholder="驻厂管理 / Manager" required>
              </div>
            </div>
            
             <div class="am-form-group">
              <label for="user-weibo" class="am-u-sm-3 am-form-label">状态</label>
              <div class="am-u-sm-9">
                 <select name="isWork" class="am-form-field">
	                <option value="true" ${enterCom.isWork==true?'selected':'' }>在职</option>
	                <option value="false" ${enterCom.isWork==false?'selected':'' }>离职</option>
	              </select>
              </div>
            </div>
            
            
            

			 <div class="am-form-group">
              <label for="user-weibo" class="am-u-sm-3 am-form-label">离职时间</label>
              <div class="am-u-sm-9">
                <input name="leaveDate" type="text" id="company" value="${enterCom.leaveDate }" placeholder="离职时间 / LeaveDate" data-am-datepicker="{format: 'yyyy-mm-dd'}"  data-am-datepicker readonly    />
              </div>
            </div>
            
             <div class="am-form-group">
              <label for="user-weibo" class="am-u-sm-3 am-form-label">离职原因</label>
              <div class="am-u-sm-9">
                <input name="leaveReason" type="text" id="company" value="${enterCom.leaveReason }" placeholder="离职原因 / LeaveReason"   />
              </div>
            </div>

            <div class="am-form-group">
              <div class="am-u-sm-9 am-u-sm-push-3">
              <button type="button" onclick="registerUser()" class="am-btn am-btn-primary am-btn-block">提交修改</button>
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
<script src="../assets/js/app.js"></script>
<script type="text/javascript">
var Gid  = document.getElementById ;
var showArea = function(){
	Gid('show').innerHTML = "<h3>省" + Gid('s_province').value + " - 市" + 	
	Gid('s_city').value + " - 县/区" + 
	Gid('s_county').value + "</h3>"
}
//Gid('s_county').setAttribute('onchange','showArea()');

function do_confirm(content,do_confirm_after){
 AMUI.dialog.confirm(
		 { title: '提示', 
		   content: content, 
		   onConfirm: do_confirm_after, 
		   onCancel: function() { console.log('onCancel') 
		 } });
}
function registerUser(){
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
