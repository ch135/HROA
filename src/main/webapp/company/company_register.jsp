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
        <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">企业资料</strong> / <small>Personal information</small></div>
      </div>

      <hr/>

      <div class="am-g">
        <div class="am-u-sm-12 am-u-md-4 am-u-md-push-8">
        </div>

        <div class="am-u-sm-12 am-u-md-8 am-u-md-pull-4">
          <form id="doc-vld-msg" class="am-form am-form-horizontal" action="/HROA/ShCompany/addShCompany.html">
            <div class="am-form-group">
              <label for="user-name" class="am-u-sm-3 am-form-label">企业名称</label>
              <div class="am-u-sm-9">
                <input name="name" type="text" id="name" placeholder="姓名 / Name" required>
              </div>
            </div>
            
            
          <div class="am-form-group">
            <label for="user-name" class="am-u-sm-3 am-form-label">企业类别</label>
            <div class="am-u-sm-9">
              <select class="am-form-field" name="label" required>
                <option value="外资">外资</option>
                <option value="台资">台资</option>
                <option value="合资">合资</option>
                 <option value="独资">独资</option>
                  <option value="国有">国有</option>
              </select>
            </div>
          </div>
            
            <div class="am-form-group">
              <label for="user-phone" class="am-u-sm-3 am-form-label">详细地址</label>
              <div class="am-u-sm-9">
                <input type="text" name="details" id="user-phone" placeholder="详细地址 / Detail" required>
              </div>
            </div>

            <div class="am-form-group">
              <label for="user-QQ" class="am-u-sm-3 am-form-label">网址</label>
              <div class="am-u-sm-9">
                <input name="url"  type="text"   id="user-QQ" placeholder="网址/URL" required>
              </div>
            </div>
            
              <div class="am-form-group">
              <label for="user-weibo" class="am-u-sm-3 am-form-label">主要生产产品</label>
              <div class="am-u-sm-9">
                <input name="produce" type="text" id="produce" placeholder="主要生产产品 / Produce" required>
              </div>
            </div>

            <div class="am-form-group">
              <label for="user-weibo" class="am-u-sm-3 am-form-label">企业联系人</label>
              <div class="am-u-sm-9">
                <input name="linkMan" type="text" id="user-weibo" placeholder="企业联系人 / Linkman" required>
              </div>
            </div>
            
            <div class="am-form-group">
              <label for="user-weibo" class="am-u-sm-3 am-form-label">联系人电话</label>
              <div class="am-u-sm-9">
                <input name="linkPhone" type="text" id="user-weibo" placeholder="联系人电话 / telephone" required>
              </div>
            </div>
            
            <div class="am-form-group">
              <label for="user-weibo" class="am-u-sm-3 am-form-label">人数规模</label>
              <div class="am-u-sm-9">
                  <select name="scale" data-am-selected="{btnSize: 'sm'}" required>
	                <option value="0-50人">0-50人</option>
	                <option value="50-100人">50-100人</option>
	                <option value="100-500人">100-500人</option>
	                 <option value="500人以上">500人以上</option>
	              </select>
              </div>
            </div>

			
			<input id="page" type="text" name="cId" value="${company.id }" style="visibility: hidden;position: absolute;">
         	<div class="am-form-group">
              <label for="user-name" class="am-u-sm-3 am-form-label">工作岗位</label>
              <div class="am-u-sm-9">
                <input  type="text" id="name" placeholder="企业名称 / company" value="${company.name }" required >
              </div>
            </div>
          
            <div class="am-form-group">
              <label for="user-name" class="am-u-sm-3 am-form-label">工作岗位</label>
              <div class="am-u-sm-9">
                <input name="job" type="text" id="name" placeholder="姓名 / Job" required>
              </div>
            </div>
            
            <div class="am-form-group">
              <label for="user-name" class="am-u-sm-3 am-form-label">招聘人数</label>
              <div class="am-u-sm-9">
                <input name="number" type="text" id="name" placeholder="招聘人数 / number" required>
              </div>
            </div>
            
            <div class="am-form-group">
            <label for="user-name" class="am-u-sm-3 am-form-label">结算</label>
            <div class="am-u-sm-9">
            	<select  id="doc-select-1" name="type">
					<option value="1" ${type=='1'?'selected':'' }>同工同酬</option>
					<option value="0" ${type=='0'?'selected':'' }>按小时计算</option>
				</select>
            </div>
            </div>
            
             <div class="am-form-group">
            <label for="user-name" class="am-u-sm-3 am-form-label">薪资</label>
            <div class="am-u-sm-9">
            	<select  id="doc-select-1" name="unit">
					<option value="1" ${unit=='1'?'selected':'' }>月薪</option>
					<option value="0" ${unit=='0'?'selected':'' }>时新</option>
				</select>
            </div>
            </div>
            
            <div class="am-form-group">
              <label for="user-name" class="am-u-sm-3 am-form-label">基本工资</label>
              <div class="am-u-sm-9">
                <input name="salary" type="text" id="name" placeholder="基本工资 / Salary" required>
              </div>
            </div>
            
            <div class="am-form-group">
              <label for="user-name" class="am-u-sm-3 am-form-label">加班工资</label>
              <div class="am-u-sm-9">
                <input name="moreSalary" type="text" id="name" placeholder="加班工资 / More-Salary" required>
              </div>
            </div>
           
            
            <div class="am-form-group">
              <label for="user-name" class="am-u-sm-3 am-form-label">联系人</label>
              <div class="am-u-sm-9">
                <input name="linkMan" type="text" id="name" placeholder="联系人 / Link-Man" required>
              </div>
            </div>
            
            <div class="am-form-group">
              <label for="user-name" class="am-u-sm-3 am-form-label">联系人电话</label>
              <div class="am-u-sm-9">
                <input name="linkPhone" type="tel" id="name" placeholder="联系人电话 / Link-Phone" required>
              </div>
            </div>
            
            <div class="am-form-group">
            <label for="user-name" class="am-u-sm-3 am-form-label">工作类别</label>
            <div class="am-u-sm-9">
            	<select  id="doc-select-1" name="classify">
					<option value="假期工" ${classify=='假期工'?'selected':'' }>假期工</option>
					<option value="长期工" ${classify=='长期工'?'selected':'' }>长期工</option>
					<option value="实习就业" ${classify=='实习就业'?'selected':'' }>实习就业</option>
				</select>
            </div>
            </div>
            
            
            <div class="am-form-group">
              <label for="user-name" class="am-u-sm-3 am-form-label">福利</label>
              <div class="am-u-sm-9">
                <input name="label" type="text" id="name" placeholder="福利 / Label" required>
              </div>
            </div>
            
             <div class="am-form-group am-form-inline">
              <label for="user-email" class="am-u-sm-3 am-form-label">工作地址</label>
	             <div class="am-u-md-9 am-u-sm-9" style="padding-left: 0px;padding-right: 0px;">
	              <div class=" am-u-sm-6 am-u-md-4">
			      <select id="s_province" name="province"   pattern="^(?!省份).*$"  required>
			        <option value="option1">选项一...</option>
			        <option value="option2">选项二.....</option>
			        <option value="option3">选项三........</option>
			      </select>
			    </div>
			     <div class=" am-u-sm-6 am-u-md-4 am-form-group" >
			      <select id="s_city" name="city"   pattern="^(?!地级市).*$"  required>
			        <option value="option1">选项一...</option>
			        <option value="option2">选项二.....</option>
			        <option value="option3">选项三........</option>
			      </select>
			    </div>
			    <div class="am-u-sm-12 am-u-md-4  am-u-end">
			      <select id="s_county" name="region"   pattern="^(?!市、县级市).*$"  required>
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
                <input name="details" type="text" id="name" placeholder="具体地址 / details" required>
              </div>
            </div>
			

            <div class="am-form-group">
              <div class="am-u-sm-9 am-u-sm-push-3">
              <button onclick="registerCompany()" type="button" class="am-btn am-btn-primary am-btn-block">添加企业信息</button>
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
<script class="resources library" src="/HROA/company/js/area.js" type="text/javascript"></script>
<script type="text/javascript" src="../js/dist/amazeui.dialog.js"></script>
<script type="text/javascript">_init_area();</script>
<script type="text/javascript">
var s=["s_province2","s_city2","s_county2"];//三个select的name
var opt0 = ["省份","地级市","市、县级市"];//初始值
function _init_area2(){  //初始化函数
	for(i=0;i<s.length-1;i++){
	  document.getElementById(s[i]).onchange=new Function("change("+(i+1)+")");
	}
	change(0);
}
$(function(){
	_init_area2();
})

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

var showArea = function(){
	Gid('show').innerHTML = "<h3>省" + Gid('s_province').value + " - 市" + 	
	Gid('s_city').value + " - 县/区" + 
	Gid('s_county').value + "</h3>"
}

function do_confirm(content,do_confirm_after){
 AMUI.dialog.confirm(
		 { title: '提示', 
		   content: content, 
		   onConfirm: do_confirm_after, 
		   onCancel: function() { console.log('onCancel') 
		 } });
}
function registerCompany(){
	$("form:first").validator('isFormValid')
	if($(".am-field-error").size()==0)
	do_confirm("确认添加?", function() {
		$("form:first").submit();
	});
}

</script>
</body>
</html>
