<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<!doctype html>
<html class="no-js">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>OA办公系统</title>
  <meta name="description" content="这是企业合同给企业看的页面">
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
        <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">企业合同信息</strong></div>
      </div>

      <hr/>

      <div class="am-g">
        <div class="am-u-sm-12 am-u-md-4 am-u-md-push-8">
        </div>

        <div class="am-u-sm-12 am-u-md-8 am-u-md-pull-4">
          <form class="am-form am-form-horizontal" action="${pageContext.request.contextPath}/ComContract/add.html" method="post" enctype="multipart/form-data">
            <div class="am-form-group">
              <label for="user-name" class="am-u-sm-3 am-form-label">企业名称 </label>
              <div class="am-u-sm-9">
                <input name="cName" type="text" id="cName" value="${comContract.cname }" disabled="disabled" placeholder="企业名称">
              </div>
            </div>
            
            <div class="am-form-group">
              <label for="user-name" class="am-u-sm-3 am-form-label">企业ID </label>
              <div class="am-u-sm-9">
                <input name="cId" type="text" id="cId" value="${comContract.cId }" disabled="disabled" placeholder="企业ID">
              </div>
            </div>
            
            
            
            <div class="am-form-group">
              <label for="user-name" class="am-u-sm-3 am-form-label">合同签订人 </label>
              <div class="am-u-sm-9">
                <input name="officeHolder" type="text" id="officeHolder" value="${comContract.writer }"  disabled="disabled" placeholder="姓名 / Name">
              </div>
            </div>
            
            <div class="am-form-group">
              <label for="user-name" class="am-u-sm-3 am-form-label">合同签订人ID </label>
              <div class="am-u-sm-9">
                <input name="officeId" type="text" id="officeId" value="${comContract.writerId }"   disabled="disabled" placeholder="姓名 / Name">
              </div>
            </div>

            
            
            
            <div class="am-form-group">
              <label for="user-name" class="am-u-sm-3 am-form-label">签订人电话 </label>
              <div class="am-u-sm-9">
                <input name="officePhone" type="text"  disabled="disabled" value="${comContract.phone }"  id="officePhone" >
              </div>
            </div>
            
            <div class="am-form-group">
              <label for="user-name" class="am-u-sm-3 am-form-label">签订日期 </label>
              <div class="am-u-sm-9">
                <input name="cDate" type="date" id="cDate" value="${comContract.signDate }"  disabled="disabled" placeholder="">
              </div>
            </div>
            
           <!--  <div class="am-form-group am-form-file">
            		<label for="user-name" class="am-u-sm-3 am-form-label">合同文件 </label>
            		<div class="am-u-sm-9">
 				 				<button type="button" class="am-btn am-btn-danger am-btn-sm">
  				  		<i class="am-icon-cloud-upload"></i> 选择要上传的文件</button>
  							<input id="doc-form-file" type="file" name="comContract" multiple>
  					</div>
  					<div class="am-u-sm-9">
  					<div id="file-list"></div>
  					</div>
			</div>
			 -->

            <div class="am-form-group">
              <div class="am-u-sm-9 am-u-sm-push-3">
              <button onclick="location.href='/HROA/ComContract/downFile.html?filename=${comContract.url}'" type="button" class="am-btn am-btn-primary am-btn-block">下载合同文件</button>
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
<script type="text/javascript">

function do_confirm(content,do_confirm_after){
 AMUI.dialog.confirm(
		 { title: '提示', 
		   content: content, 
		   onConfirm: do_confirm_after, 
		   onCancel: function() { console.log('onCancel') 
		 } });
}
function downLoad(){
	do_confirm("确认下载?", function() {
		$("form:first").submit();
	});
}

$(function() {
    $('#doc-form-file').on('change', function() {
      var fileNames = '';
      $.each(this.files, function() {
        fileNames += '<span class="am-badge">' + this.name + '</span> ';
      });
      $('#file-list').html(fileNames);
    });
  });
</script>
</body>
</html>
