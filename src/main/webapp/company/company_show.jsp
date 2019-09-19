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
          <form class="am-form am-form-horizontal" action="/HROA/ShCompany/saveShCompany.html">
            <div class="am-form-group">
              <label for="user-name" class="am-u-sm-3 am-form-label">企业名称</label>
              <div class="am-u-sm-9">
                <input name="name" type="text" id="name" placeholder="姓名 / Name" value="${company.name }" disabled>
              </div>
            </div>
          <div class="am-form-group">
            <label for="user-name" class="am-u-sm-3 am-form-label">企业类别</label>
            <div class="am-u-sm-9">
              <select class="am-form-field" name="label" disabled>
                <option value="外资" ${company.label=='外资'?'selected':'' }>外资</option>
                <option value="台资" ${company.label=='台资'?'selected':'' }>台资</option>
                <option value="合资" ${company.label=='合资'?'selected':'' }>合资</option>
                 <option value="独资" ${company.label=='独资'?'selected':'' }>独资</option>
                  <option value="国有" ${company.label=='国有'?'selected':'' }>国有</option>
              </select>
            </div>
          </div>

           <div class="am-form-group am-form-inline">
              <label for="user-email" class="am-u-sm-3 am-form-label">地址</label>
	             <div class="am-u-md-9 am-u-sm-9" style="padding-left: 0px;padding-right: 0px;">
	             <div class=" am-u-sm-6 am-u-md-4">
			      <select id="s_province" name="province" disabled="disabled">
			        <option value="option1">选项一...</option>
			        <option value="option2">选项二.....</option>
			        <option value="option3">选项三........</option>
			      </select>
			    </div>
			     <div class=" am-u-sm-6 am-u-md-4 am-form-group" >
			      <select id="s_city" name="city" disabled>
			        <option value="option1">选项一...</option>
			        <option value="option2">选项二.....</option>
			        <option value="option3">选项三........</option>
			      </select>
			    </div>
			    <div class="am-u-sm-12 am-u-md-4  am-u-end">
			      <select id="s_county" name="region" disabled>
			        <option value="option1">选项一...</option>
			        <option value="option2">选项二.....</option>
			        <option value="option3">选项三........</option>
			      </select>
			    </div>
			    </div>
            </div>

            <div class="am-form-group">
              <label for="user-phone" class="am-u-sm-3 am-form-label">详细地址</label>
              <div class="am-u-sm-9">
                <input type="tel" name="details" id="user-phone" placeholder="详细地址 / Detail" value="${company.details }" disabled>
              </div>
            </div>

            <div class="am-form-group">
              <label for="user-QQ" class="am-u-sm-3 am-form-label">网址</label>
              <div class="am-u-sm-9">
                <input name="url"  type="text"   id="user-QQ" placeholder="网址/URL" value="${company.url }" disabled>
              </div>
            </div>
            
              <div class="am-form-group">
              <label for="user-weibo" class="am-u-sm-3 am-form-label">主要生产产品 / Produce</label>
              <div class="am-u-sm-9">
                <input name="produce" type="text" id="produce" placeholder="主要生产产品 / Produce" value="${company.produce }" disabled>
              </div>
            </div>

            <div class="am-form-group">
              <label for="user-weibo" class="am-u-sm-3 am-form-label">企业联系人</label>
              <div class="am-u-sm-9">
                <input name="linkMan" type="text" id="user-weibo" placeholder="企业联系人 / Linkman" value="${company.linkMan }" disabled>
              </div>
            </div>
            
            <div class="am-form-group">
              <label for="user-weibo" class="am-u-sm-3 am-form-label">联系人电话</label>
              <div class="am-u-sm-9">
                <input name="linkPhone" type="text" id="user-weibo" placeholder="联系人电话 / telephone" value="${company.linkPhone }" disabled>
              </div>
            </div>
            
            <div class="am-form-group">
              <label for="user-weibo" class="am-u-sm-3 am-form-label">人数规模</label>
              <div class="am-u-sm-9">
                  <select name="scale" class="am-form-field"  disabled>
	                <option value="0-50人" ${company.scale=='0-50人'?'selected':'' }>0-50人</option>
	                <option value="50-100人"  ${company.scale=='50-100人'?'selected':'' }>50-100人</option>
	                <option value="100-500人"  ${company.scale=='100-500人'?'selected':'' }>100-500人</option>
	                 <option value="500人以上"  ${company.scale=='500人以上'?'selected':'' }>500人以上</option>
	              </select>
              </div>
            </div>

            <div class="am-form-group">
              <label for="user-intro" class="am-u-sm-3 am-form-label">简介</label>
              <div class="am-u-sm-9">
                <textarea name="describes" class="" rows="5" id="user-intro" placeholder="简介 / Intro"  disabled>${company.describes}</textarea>
                <small>250字以内...</small>
              </div>
            </div>

            <div class="am-form-group">
              <div class="am-u-sm-9 am-u-sm-push-3">
              <button type="button" onclick="upateCompany()" class="am-btn am-btn-primary am-btn-block">修改企业信息</button>
              </div>
            </div>
            <input name="id" type="text" id="id"  value="${company.id }" style="visibility: hidden;width:1px;height:1px;">
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
<script src="../assets/js/app.js"></script>

<script class="resources library" src="/HROA/company/js/area.js" type="text/javascript"></script>
	<script type="text/javascript" src="../js/dist/amazeui.dialog.js"></script>
<script type="text/javascript">_init_area();</script>
<script type="text/javascript">
var Gid  = document.getElementById ;
var showArea = function(){
	Gid('show').innerHTML = "<h3>省" + Gid('s_province').value + " - 市" + 	
	Gid('s_city').value + " - 县/区" + 
	Gid('s_county').value + "</h3>"
}
window.onload=function(){
 $("#s_province").find("option[value='${company.province}']").attr("selected",true);
 $("#s_province").trigger("change");
 $("#s_city").find("option[value='${company.city}']").attr("selected",true);
 $("#s_city").trigger("change");
 $("#s_county").find("option[value='${company.region}']").attr("selected",true);
}
function do_confirm(content,do_confirm_after){
 AMUI.dialog.confirm(
		 { title: '提示', 
		   content: content, 
		   onConfirm: do_confirm_after, 
		   onCancel: function() { console.log('onCancel') 
		 } });
}
function upateCompany(){
	do_confirm("确认修改?", function() {
		$("form:first").submit();
	});
}
</script>
</body>
</html>
