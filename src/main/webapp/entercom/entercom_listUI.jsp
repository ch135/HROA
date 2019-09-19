<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html class="no-js">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>OA办公系统</title>
<meta name="description" content="这是一个 table 页面">
<meta name="keywords" content="table">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="renderer" content="webkit">
<meta http-equiv="Cache-Control" content="no-siteapp" />
<meta name="apple-mobile-web-app-title" content="Amaze UI" />
<link rel="icon" type="image/png" href="../assets/i/favicon.png">
<link rel="apple-touch-icon-precomposed" href="../assets/i/app-icon72x72@2x.png">
<link rel="stylesheet" href="../assets/css/amazeui.min.css" />
<link rel="stylesheet" href="../assets/css/admin.css">
<link rel="stylesheet" type="text/css" href="../assets/js/dist/amazeui.page.css">
<link rel="stylesheet" href="../js/dist/amazeui.datatables.min.css">

</head>
<body>
	<!--[if lte IE 9]>
<p class="browsehappy">你正在使用<strong>过时</strong>的浏览器，Amaze UI 暂不支持。 请 <a href="http://browsehappy.com/" target="_blank">升级浏览器</a>
  以获得更好的体验！</p>
<![endif]-->

	<!-- content start -->
	<div class="admin-content">
		<div class="admin-content-body">
			<div class="am-cf am-padding am-padding-bottom-0">
				<div class="am-fl am-cf">
					<strong class="am-text-primary am-text-lg">入职记录</strong> / <small>Record</small>
				</div>
			</div>
			<hr>
			<div class="am-g">
				<div class="am-u-sm-9 am-u-md-11" style="margin-bottom: 10px;">
					<div class="am-btn-toolbar">
						<div class="am-btn-group am-btn-group-xs">
							<button type="button" class="am-btn am-btn-default" onclick="location.href='/HROA/user/user_register.jsp'">
								<span class="am-icon-plus"></span> 新增
							</button>
						</div>
					</div>
				</div>
				<div class="am-u-sm-3 am-u-md-1" style="margin-bottom: 10px;">
					<div class="am-btn-toolbar">
						<div class="am-btn-group am-btn-group-xs">
							<button type="button" class="am-btn am-btn-default" data-am-modal="{target: '#my-popup'}">
								<span class="am-icon-plus"></span> 搜索
							</button>
						</div>
					</div>
				</div>
			</div>


		<div class="am-g">
			<div class="am-u-sm-12">
				<table width="100%" class="am-table am-table-striped  am-table-compact am-text-nowrap" id="data-table">
					<thead>
						<tr>
							<th class="">姓名</th>
							<th class="">电话</th>
							<th class="">输送单位</th>
							<th class="">公司</th>
							<th class="">驻厂管理</th>
							<th class=" ">驻厂管理电话</th>
							<th class="">在职</th>
							<th class="">操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${page.list }" var="item">
							<tr>
								<td>${item.shUser.realname }</td>
								<td>${item.shUser.telephone }</td>
								<td>${item.sendUnit}</td>
								<td>${item.sendCompany }</td>
								<td>${item.workerId }</td>
								<td>${item.managerTel }</td>
								<td>${item.isWork==true?'在职':'离职' }</td>
								<td>
									<div class="am-btn-group am-btn-group-xs">
										<button type="button" class="am-btn am-btn-default" onclick="location.href='/HROA/EnterCom/showEnterComUI.html?enterComid=${item.enterComid}'">查看</button>
										<button type="button" class="am-btn am-btn-default" onclick="location.href='/HROA/EnterCom/editEnterComUI.html?enterComid=${item.enterComid}'">编辑</button>
										<button type="button" class="am-btn am-btn-default" onclick="confirm_date(${item.enterComid})" ${item.isWork==true?'':'disabled' }>离职</button>
										<button type="button" class="am-btn am-btn-default" onclick="doDelete(${item.enterComid})">删除</button>
									</div>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<div class="am-cf">
					<div style="float: right;font-size: 12px;">共 ${page.totalRecord } 条记录</div>
					<div id="page2"></div>
				</div>
			</div>

		</div>
	</div>




	<footer class="admin-content-footer">
		<hr>
		<p class="am-padding-left">© 2014 AllMobilize, Inc. Licensed under MIT license.</p>
	</footer>
	
<div class="am-popup" id="my-popup" >
  <div class="am-popup-inner" style="overflow-x:hidden">
    <div class="am-popup-hd">
      <h4 class="am-popup-title">搜索</h4>
      <span data-am-modal-close
            class="am-close">&times;</span>
    </div>
    <div class="am-popup-bd">
      
      <div class="am-g">
        <div class="am-u-sm-12 am-u-md-12">
          <form id="doc-vld-msg" class="am-form am-form-horizontal" action="/HROA/EnterCom/listEnterComUI.html" method="post">
          	<input id="enterComid" type="text" name="enterComid" value="${enterCom.enterComid }" style="visibility: hidden;position: absolute;">
          	<input id="page" type="text" name="page" value="${page.page}" style="visibility: hidden;position: absolute;">
            <div class="am-form-group">
              <label for="user-name" class="am-u-sm-3 am-form-label">学生姓名</label>
              <div class="am-u-sm-9">
                <input name="shUser.realname" type="text" id="name" value="${enterCom.shUser.realname}" placeholder="姓名 / Name" required   >
              </div>
            </div>
            
            
            <div class="am-form-group">
              <label for="user-phone" class="am-u-sm-3 am-form-label">联系电话</label>
              <div class="am-u-sm-9">
                <input type="tel" name="shUser.telephone" id="user-phone" value="${enterCom.shUser.telephone}" placeholder="联系电话 / Telephone" required  >
              </div>
            </div>

            <div class="am-form-group">
              <label for="user-QQ" class="am-u-sm-3 am-form-label">身份证</label>
              <div class="am-u-sm-9">
                <input name="shUser.idcard"  type="text"   id="idcard"  value="${enterCom.shUser.idcard}" placeholder="身份证 / IdCard" required  >
              </div>
            </div>
              <div class="am-form-group">
              <label for="user-weibo" class="am-u-sm-3 am-form-label">输送单位</label>
              <div class="am-u-sm-9">
                <input name="sendUnit" type="text" id="transport" value="${enterCom.sendUnit}"  placeholder="输送单位 / Transport" required>
              </div>
            </div>
            
            <div class="am-form-group">
              <label for="user-weibo" class="am-u-sm-3 am-form-label">日期</label>
              <div class="am-u-sm-4">
           		   <input value="${page.pageMap.startDate }" type="text" name="startDate" class="am-form-field" placeholder="日历组件" data-am-datepicker  />
              </div>
              <div class="am-u-sm-1">
              -
              </div>
               <div class="am-u-sm-4">
           		   <input  value="${page.pageMap.endDate }" type="text"  name="endDate" class="am-form-field" placeholder="日历组件" data-am-datepicker  />
              </div>
            </div>

			 <div class="am-form-group">
              <label for="user-weibo" class="am-u-sm-3 am-form-label">在职</label>
              <div class="am-u-sm-9">
                <select name="isWork" class="am-form-field">
					<option value="" >不限</option>
					<option value="true" ${enterCom.isWork==true?'selected':'' }>在职</option>
					<option value="false" ${enterCom.isWork==false?'selected':'' }>离职</option>
				</select>
              </div>
            </div>

            <div class="am-form-group">
              <label for="user-weibo" class="am-u-sm-3 am-form-label">联系人电话</label>
              <div class="am-u-sm-9">
                <input name="sendTelephone" type="text" id="telephone" value="${enterCom.sendTelephone}"  placeholder="输送联系人电话 / Telephone" >
              </div>
            </div>
            
            <div class="am-form-group">
              <label for="user-weibo" class="am-u-sm-3 am-form-label">所进企业</label>
              <div class="am-u-sm-9">
                <input name="sendCompany" type="text" id="company" value="${enterCom.sendCompany}"  placeholder="所进企业 / Company" >
              </div>
            </div>
            
            <div class="am-form-group">
              <label for="user-weibo" class="am-u-sm-3 am-form-label">驻厂管理</label>
              <div class="am-u-sm-9">
                <input name="workerId" type="text" id="company" value="${enterCom.workerId}" placeholder="驻厂管理 / Manager" >
              </div>
            </div>
            
            <div class="am-form-group">
              <div class="am-u-sm-12">
              <button type="button" onclick="do_search()" class="am-btn am-btn-primary am-btn-block">搜索</button>
              </div>
            </div>
          </form>
        </div>
      </div>
    </div>
    </div>
  </div>
</div>
	

	<!-- content end -->

	<a href="#" class="am-icon-btn am-icon-th-list am-show-sm-only admin-menu" data-am-offcanvas="{target: '#admin-offcanvas'}"></a>

	<footer>
		<hr>
		<p class="am-padding-left">©Copyright &copy;2017 All Rights Reserved huizhouxueyuan development team</p>
	</footer>
	<div class="am-modal am-modal-prompt" tabindex="-1" id="my-prompt">
		<div class="am-modal-dialog">
			<div class="am-modal-hd">填写离职日期</div>
			<div class="am-modal-bd">
			<form class="am-form" id="comfirmDate">
				<div class="am-form-group am-input-group-sm am-form-icon">
					<i class="am-icon-calendar"></i> <input type="text" value="" name="dateTime" class="am-form-field" data-am-datepicker="{format: 'yyyy-mm-dd'}" placeholder="离职时间"  data-am-datepicker readonly  required="required"/>
				</div>
				<div class="am-form-group am-input-group-sm am-form-icon">
				  <textarea name="leaveReason" class="" rows="5" id="doc-ta-1" placeholder="离职原因"  required></textarea>
				</div>
			</form>
			</div>
			<div class="am-modal-footer">
				<span class="am-modal-btn" data-am-modal-cancel>取消</span> <span class="am-modal-btn" data-am-modal-confirm>提交</span>
			</div>
		
		</div>
	</div>
	<script type="text/javascript" src="../assets/js/dist/jquery.min.js"></script>
	<script type="text/javascript" src="../assets/js/amazeui.min.js"></script>
	<script type="text/javascript" src="../assets/js/app.js"></script>
	<script type="text/javascript" src="../assets/js/dist/amazeui.page.js"></script>
	<script type="text/javascript" src="../js/dist/amazeui.datatables.min.js"></script>
	<script type="text/javascript" src="../js/dist/dataTables.responsive.min.js"></script>
	<script type="text/javascript" src="../js/dist/amazeui.dialog.js"></script>
	<script type="text/javascript">
	$('#comfirmDate').validator({
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
	
	
		$(function() {
			$('#data-table').DataTable({
				responsive : true,
				dom : 'ti'
			});
		});
		function do_search() {
			$("#page").val(0);
			$("form:first").submit();
		}

		$("#page2").page({
			pages : ${page.totalPage},
			curr : ${page.page},
			first : "首页", //设置false则不显示，默认为false  
			last : "尾页", //设置false则不显示，默认为false      
			prev : false, //若不显示，设置false即可，默认为上一页
			next : false, //若不显示，设置false即可，默认为下一页
			groups : 5, //连续显示分页数
			jump : function(context, first) {
				if (!first) {
					$("#page").val(context.option.curr);
					$("form:first").submit();
				}
			}
		});
		function do_confirm(content, do_confirm_after) {
			AMUI.dialog.confirm({
				title : '提示',
				content : content,
				onConfirm : do_confirm_after,
				onCancel : function() {
					console.log('onCancel')
				}
			});
		}
		function doDelete(id) {
			do_confirm("确定删除？", function() {
				$("form:first").attr("action","/HROA/EnterCom/deleteEnterCom.html?id=" + id);
				$("form:first").submit();
			});
		}

		function confirm_date(id) {
			var enterComid=id;
			$('#my-prompt').modal({relatedElement : this,onConfirm : function(data) {
					var time1 = new Date(data.timeStamp).Format("yyyy-MM-dd");
					var url="/HROA/EnterCom/confirmEnterCom.html?id="+ id;
			 		var my_input = $('<input id="enterCom_id" type="text" name="id" style="visibility=hidden" />');  
				    my_input.attr('value',id);  
				    $("form:eq(1)").append(my_input);   
					$("form:eq(1)").attr("action",url);
					if($(".am-field-error").size()==0)
					$("form:eq(1)").submit();
					$("#enterCom_id").remove();   
					return false;
				},
				onCancel : function() {
				},closeOnConfirm:false
			});
		};

Date.prototype.Format = function(fmt) { //author: meizz 
	var o = {
		"M+" : this.getMonth() + 1, //月份 
		"d+" : this.getDate(), //日 
		"h+" : this.getHours(), //小时 
		"m+" : this.getMinutes(), //分 
		"s+" : this.getSeconds(), //秒 
		"q+" : Math.floor((this.getMonth() + 3) / 3), //季度 
		"S" : this.getMilliseconds()//毫秒 
	};
	if (/(y+)/.test(fmt))
		fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
	for ( var k in o)
		if (new RegExp("(" + k + ")").test(fmt))
			fmt = fmt.replace(RegExp.$1,(RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
	return fmt;
}

$("#page2").page({
	pages : ${page.totalPage},
	curr : ${page.page},
	first : "首页", //设置false则不显示，默认为false  
	last : "尾页", //设置false则不显示，默认为false      
	prev : false, //若不显示，设置false即可，默认为上一页
	next : false, //若不显示，设置false即可，默认为下一页
	groups : 5, //连续显示分页数
	jump : function(context, first) {
		if (!first) {
			$("#page").val(context.option.curr);
			$("form:first").submit();
		}
	}
});

</script>
</body>
</html>
