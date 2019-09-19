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
					<strong class="am-text-primary am-text-lg">企业列表</strong> / <small>Company</small>
				</div>
			</div>
			<hr>
			<div class="am-g">
				<div class="am-u-sm-9 am-u-md-6" style="margin-bottom: 10px;">
					<div class="am-btn-toolbar">
						<div class="am-btn-group am-btn-group-xs">
							<button type="button" class="am-btn am-btn-default" onclick="location.href='/HROA/JobRecord/addUI.html'">
								<span class="am-icon-plus"></span> 新增
							</button>
						</div>
					</div>
				</div>
				<div class="am-u-sm-3 am-u-md-6  " style="margin-bottom: 10px;">
					<div class="am-btn-group am-btn-group-xs  am-fr">
						<button class="am-btn am-btn-default "   data-am-modal="{target: '#my-popup'}">
							<span class="am-sr-only">导航切换</span> 搜索<span class="am-icon-search"></span>
						</button>
					</div>
				</div>
			</div>

			<div class="am-g">
				<div class="am-u-sm-12">
						<table width="100%" class="am-table am-table-striped  am-table-compact am-text-nowrap" id="data-table">
							<thead>
								<tr>
									<th class="">企业名称</th>
									<th class="">职位</th>
									<th class="">招聘人数</th>
									<th class="">地址</th>
									<th class=" ">状态</th>
									<th class="">操作</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${page.list }" var="item">
									<tr>
										<td>${item.name }</td>
										<td>${item.job }</td>
										<td>${item.number }</td>
										<td>${item.province }${item.city }${item.region }</td>
										<td class="am-hide-sm-only">${item.isFinish==1?'招聘中':'招聘结束'}</td>
										<td>
											<div class="am-btn-group am-btn-group-xs">
											     <button type="button" class="am-btn am-btn-default" onclick="location.href='/HROA/JobRecord/selectUI.html?companyId=${item.id}'">
													 查看
												</button> 
												<button type="button" class="am-btn am-btn-default" onclick="location.href='/HROA/JobRecord/editUI.html?companyId=${item.id}'">
													 编辑
												</button>
												<button type="button" class="am-btn am-btn-default" onclick="finish(${item.id})" ${item.isFinish==0?'disabled':'' }>
													 结束招聘
												</button>
												<button type="button" class="am-btn am-btn-default" onclick="deleteCompany(${item.id})">
													 删除
												</button>
											</div>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<div class="am-cf">
							<div style="float: right;font-size: 12px;">共 ${page.totalRecord } 条记录</div>
							<%-- <div data-am-page="{pages:${page.totalPage },curr:${page.page },jump:'/HROA/ShCompany/listCompanyUI.html?page=%page%'}"></div> --%>
							<div id="page2"></div>
						</div>
				</div>

			</div>
		</div>
		

	<div class="am-popup" id="my-popup" style="overflow: hidden;">
	  <div class="am-popup-inner"  style="overflow-x:hidden">
	    <div class="am-popup-hd">
	      <h4 class="am-popup-title">搜索</h4>
	      <span data-am-modal-close
	            class="am-close">x</span>
	    </div>
	    <div class="am-popup-bd">
	    	<div class="am-u-sm-12 am-u-md-12 ">
          <form id="doc-vld-msg" class="am-form am-form-horizontal" action="/HROA/JobRecord/listUI.html">
            <div class="am-form-group">
              <label for="user-name" class="am-u-sm-3 am-form-label">企业名称</label>
              <div class="am-u-sm-9">
                <input name="name" type="text" id="name" placeholder="企业名称" value="${jobRecord.name }" >
              </div>
            </div>
            
            <div class="am-form-group">
              <label for="user-weibo" class="am-u-sm-3 am-form-label">企业联系人</label>
              <div class="am-u-sm-9">
                <input name="linkMan" type="text" id="user-weibo" placeholder="企业联系人" value="${jobRecord.linkMan }"  >
              </div>
            </div>
            
             <div class="am-form-group">
              <label for="user-weibo" class="am-u-sm-3 am-form-label">开发人</label>
              <div class="am-u-sm-9">
                <input name="developMan" type="text" id="user-weibo" placeholder="开发人"  value="${jobRecord.developMan }" >
              </div>
            </div>
            
             <div class="am-form-group">
              <label for="user-weibo" class="am-u-sm-3 am-form-label">驻厂管理</label>
              <div class="am-u-sm-9">
                <input name="factoryMan" type="text" id="user-weibo" placeholder="驻厂管理 "  value="${jobRecord.factoryMan }" >
              </div>
            </div>
            
            <div class="am-form-group">
              <label for="user-name" class="am-u-sm-3 am-form-label">工作岗位</label>
              <div class="am-u-sm-9">
                <input name="job" type="text" id="name" placeholder="工作岗位" value="${jobRecord.job }"  >
              </div>
            </div>
            
            <div class="am-form-group">
				<label for="user-name" class="am-u-sm-3 am-form-label">合作模式</label>
				<div class="am-u-sm-9">
					<select id="doc-select-1" name="type" >
					<option value="">不限</option>
						<option value="1" ${jobRecord.type=='1'?'selected':'' }>同工同酬</option>
						<option value="0" ${jobRecord.type=='0'?'selected':'' }>小时工</option>
					</select>
				</div>
			</div>
            
            <div class="am-form-group">
            <label for="user-name" class="am-u-sm-3 am-form-label">工作类别</label>
            <div class="am-u-sm-9">
            	<select  id="doc-select-1" name="classify">
            		<option value="">不限</option>
            		<option value="临时工"  ${jobRecord.classify=='临时工'?'selected':'' } >临时工</option>
					<option value="假期工" ${jobRecord.classify=='假期工'?'selected':'' }>假期工</option>
					<option value="长期工" ${jobRecord.classify=='长期工'?'selected':'' }>长期工</option>
					<option value="实习就业" ${jobRecord.classify=='实习就业'?'selected':'' }>实习就业</option>
				</select>
            </div>
            </div>
            
            
             <div class="am-form-group am-form-inline">
              <label for="user-email" class="am-u-sm-3 am-form-label">工作地址</label>
	             <div class="am-u-md-9 am-u-sm-9" style="padding-left: 0px;padding-right: 0px;">
	              <div class=" am-u-sm-6 am-u-md-4">
			      <select id="s_province" name="province"   pattern="^(?!省份).*$" data="${jobRecord.province }"  >
			        <option value="option1">选项一...</option>
			        <option value="option2">选项二.....</option>
			        <option value="option3">选项三........</option>
			      </select>
			    </div>
			    
			     <div class=" am-u-sm-6 am-u-md-4 am-form-group" >
			      <select id="s_city" name="city"   pattern="^(?!地级市).*$"   data="${jobRecord.city }" >
			        <option value="option1">选项一...</option>
			        <option value="option2">选项二.....</option>
			        <option value="option3">选项三........</option>
			      </select>
			    </div>
			    <div class="am-u-sm-12 am-u-md-4  am-u-end">
			      <select id="s_county" name="region"   pattern="^(?!市、县级市).*$"   data="${jobRecord.region }" >
			        <option value="option1">选项一...</option>
			        <option value="option2">选项二.....</option>
			        <option value="option3">选项三........</option>
			      </select>
			    </div>
			    </div>
            </div>
            
            <div class="am-form-group">
				<label for="user-name" class="am-u-sm-3 am-form-label">招聘状态</label>
				<div class="am-u-sm-9">
					<label class="am-radio-inline"> <input
						type="radio" name="isFinish" value="1" ${jobRecord.isFinish==1?'checked':'' }>招聘中
					</label> <label class="am-radio-inline"> <input ${jobRecord.isFinish==0?'checked':'' }
						type="radio" name="isFinish" value="0">招聘结束
					</label> 
				</div>
			</div>
            
            
            <input id="page" type="text" name="page" value="1" style="visibility: hidden;position: absolute;">
             <div class="am-form-group">
              <div class="am-u-sm-12">
              <button  type="button" onclick="searchCompany()" class="am-btn am-btn-primary am-btn-block">搜索企业信息</button>
              </div>
            </div>
          </form>
        </div>
	    
	    
	    </div>
	  </div>
	</div>
	
		<footer class="admin-content-footer">
			<hr>
			<p class="am-padding-left">© 2014 AllMobilize, Inc. Licensed under MIT license.</p>
		</footer>

	</div>
	<!-- content end -->

	<a href="#" class="am-icon-btn am-icon-th-list am-show-sm-only admin-menu" data-am-offcanvas="{target: '#admin-offcanvas'}"></a>

	<footer>
		<hr>
		<p class="am-padding-left">©Copyright &copy;2017 All Rights Reserved huizhouxueyuan development team</p>
	</footer>
	<div class="am-modal am-modal-confirm" tabindex="-1" id="my-confirm">
		<div class="am-modal-dialog">
			<div class="am-modal-hd">Amaze UI</div>
			<div class="am-modal-bd">你，确定要删除这条记录吗？</div>
			<div class="am-modal-footer">
				<span class="am-modal-btn" data-am-modal-cancel>取消</span> <span class="am-modal-btn" data-am-modal-confirm>确定</span>
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
	<script class="resources library" src="/HROA/company/js/area.js" type="text/javascript"></script>

	<script type="text/javascript">
		$(function() {
			$('#data-table').DataTable({
				responsive : true,
				dom : 'ti'
			});
		});
		function show(content, confirm) {
			AMUI.dialog.alert({
				title : 'Tip',
				content : content,
				onConfirm : confirm
			});
		}
		function ajax(url, form, after) {
			$.ajax({
				url : url,
				type : "post",
				data : form,
				success : after
			});
		}
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

		function deleteCompany(companyId) {
			do_confirm("确定删除?",
					function() {
						$("form:first").attr("action","/HROA/JobRecord/delete.html?id="+companyId);
					    var my_input = $('<input type="text" name="id" />');  
					    my_input.attr('value', companyId);  
					    $("form:first").append(my_input);  
						$("form:first").submit();
					});
		}

		function searchCompany() {
			$("#page").val(0);
			 $("#s_province").find("option[value='省份']").attr("value","")
			 $("#s_city").find("option[value='地级市']").attr("value","");
			 $("#s_county").find("option[value='市、县级市']").attr("value","");
			$("form:first").submit();
		}
		
		function finish(companyId){
				do_confirm("确定结束?",
				function() {
					$("form:first").attr("action","/HROA/JobRecord/finish.html?id="+companyId);
				    var my_input = $('<input type="text" name="id" />');  
				    my_input.attr('value', companyId);  
				    $("form:first").append(my_input);  
					$("form:first").submit();
				});
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
					$("#s_province").find("option[value='省份']").attr("value","")
					 $("#s_city").find("option[value='地级市']").attr("value","");
					 $("#s_county").find("option[value='市、县级市']").attr("value","");
					$("#page").val(context.option.curr);
					$("form:first").submit();
				}
			}
		});
		$(function(){
			$("input:radio").bind('click',function(){
			    if($(this).attr('checked')){
			        $(this).removeAttr('checked');
			    }else{
			        $(this).attr('checked','checked');
			    }
			});
		});
		
		
		window.onload=function(){
		_init_area();
		 $("#s_province").find("option[value='${jobRecord.province}']").attr("selected",true);
		 $("#s_province").trigger("change");
		 $("#s_city").find("option[value='${jobRecord.city}']").attr("selected",true);
		 $("#s_city").trigger("change");
		 $("#s_county").find("option[value='${jobRecord.region}']").attr("selected",true);
		
		}
		
	</script>
</body>
</html>
