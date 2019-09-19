<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
<link rel="stylesheet" href="../assets/css/amazeui.min.css" />
<link rel="stylesheet" href="../assets/css/admin.css">
</head>
<body>

	<div class="admin-content">
		<div class="admin-content-body">
			<div class="am-cf am-padding am-padding-bottom-0">
				<div class="am-fl am-cf">
					<strong class="am-text-primary am-text-lg">企业资料</strong> / <small>Personal information</small>
				</div>
			</div>

			<hr />

			<div class="am-g">
				<div class="am-u-sm-12 am-u-md-4 am-u-md-push-8"></div>

				<div class="am-u-sm-12 am-u-md-8 am-u-md-pull-4">
					<form id="doc-vld-msg" class="am-form am-form-horizontal" action="/HROA/JobRecord/edit.html">
						<div class="am-form-group">
							<label for="user-name" class="am-u-sm-3 am-form-label">企业名称</label>
							<div class="am-u-sm-9">
								<input name="name" type="text" id="name" placeholder="企业名称" value="${jobRecord.name }" required>
							</div>
						</div>


						<div class="am-form-group">
							<label for="user-weibo" class="am-u-sm-3 am-form-label">企业联系人</label>
							<div class="am-u-sm-9">
								<input name="linkMan" type="text" id="user-weibo" value="${jobRecord.linkMan }" placeholder="企业联系人 " required >
							</div>
						</div>

						<div class="am-form-group">
							<label for="user-weibo" class="am-u-sm-3 am-form-label">联系人电话</label>
							<div class="am-u-sm-9">
								<input name="linkPhone" type="text" id="user-weibo" value="${jobRecord.linkPhone }" placeholder="联系人电话  " required >
							</div>
						</div>
						
						<div class="am-form-group">
							<label for="user-name" class="am-u-sm-3 am-form-label">开发人</label>
							<div class="am-u-sm-9">
								<input name="developMan" type="text" id="name" value="${jobRecord.developMan }" placeholder="开发人" required >
							</div>
						</div>

						<div class="am-form-group">
							<label for="user-name" class="am-u-sm-3 am-form-label">开发人电话</label>
							<div class="am-u-sm-9">
								<input name="developLink" type="number" id="name" value="${jobRecord.developLink }" placeholder="开发人电话" required >
							</div>
						</div>
						
							<div class="am-form-group">
							<label for="user-name" class="am-u-sm-3 am-form-label">驻厂管理</label>
							<div class="am-u-sm-9">
								<input  name="factoryMan" type="text" id="name" value="${jobRecord.factoryMan }" placeholder="驻厂管理" required>
							</div>
						</div>

						<div class="am-form-group">
							<label for="user-name" class="am-u-sm-3 am-form-label">驻厂管理电话</label>
							<div class="am-u-sm-9">
								<input  name="factoryPhone" type="tel" id="name" value="${jobRecord.factoryPhone }" placeholder="驻厂管理电话" required>
							</div>
						</div>
						
						<div class="am-form-group">
							<label for="user-name" class="am-u-sm-3 am-form-label">工作岗位</label>
							<div class="am-u-sm-9">
								<input name="job" type="text" id="name" placeholder="工作岗位" value="${jobRecord.job }" value="${company.name }" required >
							</div>
						</div>
						
							<div class="am-form-group am-form-inline">
							<label for="user-email" class="am-u-sm-3 am-form-label">工作地址</label>
							<div class="am-u-md-9 am-u-sm-9" style="padding-left: 0px;padding-right: 0px;">
								<div class=" am-u-sm-6 am-u-md-4">
									<select id="s_province" name="province" pattern="^(?!省份).*$"  >
										<option value="option1">选项一...</option>
										<option value="option2">选项二.....</option>
										<option value="option3">选项三........</option>
									</select>
								</div>
								<div class=" am-u-sm-6 am-u-md-4 am-form-group">
									<select id="s_city" name="city" pattern="^(?!地级市).*$"  >
										<option value="option1">选项一...</option>
										<option value="option2">选项二.....</option>
										<option value="option3">选项三........</option>
									</select>
								</div>
								<div class="am-u-sm-12 am-u-md-4  am-u-end">
									<select id="s_county" name="region" pattern="^(?!市、县级市).*$"  >
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
								<input name="details" type="text" id="name" value="${jobRecord.details }" placeholder="具体地址 / details"  >
							</div>
						</div>
						
							<div class="am-form-group">
							<label for="user-name" class="am-u-sm-3 am-form-label">招聘人数</label>
							<div class="am-u-sm-9">
								<input name="number"  type="number" id="name" value="${jobRecord.number }" placeholder="招聘人数"  >
							</div>
						</div>
						

						<div class="am-form-group">
							<label for="user-weibo" class="am-u-sm-3 am-form-label">主要生产产品</label>
							<div class="am-u-sm-9">
								<input name="produce" type="text" id="produce" value="${jobRecord.produce }" placeholder="主要生产产品 "   >
							</div>
						</div>

						<div class="am-form-group">
							<label for="user-name" class="am-u-sm-3 am-form-label">网址</label>
							<div class="am-u-sm-9">
								<input name="url" type="text" id="name" placeholder="网址" value="${jobRecord.url }" >
							</div>
							
						</div>

						<div class="am-form-group">
							<label for="user-weibo" class="am-u-sm-3 am-form-label">人数规模</label>
							<div class="am-u-sm-9">
								<select name="scale" >
									<option value="0-50人" ${jobRecord.scale=='0-50人'?'selected':'' }>0-50人</option>
									<option value="50-100人" ${jobRecord.scale=='50-100人'?'selected':'' }>50-100人</option>
									<option value="100-500人" ${jobRecord.scale=='100-500人'?'selected':'' }>100-500人</option>
									<option value="500人以上" ${jobRecord.scale=='500人以上'?'selected':'' }>500人以上</option>
								</select>
							</div>
						</div>

						<div class="am-form-group">
							<label for="user-name" class="am-u-sm-3 am-form-label">合作模式</label>
							<div class="am-u-sm-9">
								<select id="doc-select-1" name="type " >
									<option value="1" ${jobRecord.type=='1'?'selected':'' }>同工同酬</option>
									<option value="0" ${jobRecord.type=='0'?'selected':'' }>小时工</option>
								</select>
							</div>
						</div>
						
						 <div class="am-form-group">
			            <label for="user-name" class="am-u-sm-3 am-form-label">工作类别</label>
			            <div class="am-u-sm-9">
			            	<select  id="doc-select-1" name="classify">
			            		<option value="临时工" ${jobRecord.classify=='临时工'?'selected':'' } >临时工</option>
								<option value="假期工"  ${jobRecord.classify=='假期工'?'selected':'' }>假期工</option>
								<option value="长期工"  ${jobRecord.classify=='长期工'?'selected':'' }>长期工</option>
								<option value="实习就业"  ${jobRecord.classify=='实习就业'?'selected':'' }>实习就业</option>
							</select>
			            </div>
		            	</div>
						


						<div class="am-form-group">
							<label for="user-name" class="am-u-sm-3 am-form-label">基本工资</label>
							<div class="am-u-sm-9">
								<input name="salary" type="number" id="name" value="${jobRecord.salary }" placeholder="基本工资"  >
							</div>
						</div>

						<div class="am-form-group">
							<label for="user-name" class="am-u-sm-3 am-form-label">加班工资</label>
							<div class="am-u-sm-9">
								<input name="moreSalary" type="number" id="name" value="${jobRecord.moreSalary }" placeholder="加班工资"  >
							</div>
						</div>





						<div class="am-form-group">
							<label for="user-name" class="am-u-sm-3 am-form-label">企业描述</label>
							<div class="am-u-sm-9">
								<textarea name="describes" class="" rows="4" id="doc-ta-1" >${jobRecord.describes }</textarea>
							</div>
						</div>



						<div class="am-form-group">
							<label for="user-name" class="am-u-sm-3 am-form-label">作业方式</label>
							<div class="am-u-sm-9">
								<label class="am-radio-inline"> <input type="radio" ${jobRecord.workType=='坐班'?'checked="checked"':'' } value="坐班"  name="workType"> 坐班
								</label> <label class="am-radio-inline"> <input type="radio" 
									${jobRecord.workType== '站班'?'checked="checked" ':'' }
									name="workType" value="站班"> 站班
								</label>
							</div>
						</div>

						<div class="am-form-group">
							<label for="user-name" class="am-u-sm-3 am-form-label">服装要求</label>
							<div class="am-u-sm-9">
								<label class="am-radio-inline"> <input type="radio"  name="clothesType" value="普通工业" ${jobRecord.clothesType=='普通工业'?'checked="checked"':'' }> 普通工业
								</label> <label class="am-radio-inline"> <input type="radio" 
									${jobRecord.clothesType== '静电服'?'checked="checked" ':'' }
									name="clothesType" value="静电服"> 静电服
								</label> <label class="am-radio-inline"> <input type="radio" 
									${jobRecord.clothesType== '防尘服'?'checked="checked" ':'' }
									name="clothesType" value="防尘服"> 防尘服
								</label>
							</div>
						</div>

						<div class="am-form-group">
							<label for="user-name" class="am-u-sm-3 am-form-label">时间要求</label>
							<div class="am-u-sm-9">
								<label class="am-radio-inline"> <input type="radio"  value="长白班" ${jobRecord.workTime=='长白班'?'checked="checked"':'' } name="workTime"> 长白班
								</label> <label class="am-radio-inline"> <input type="radio"  value="两班倒" ${jobRecord.workTime=='两班倒'?'checked="checked"':'' } name="workTime"> 两班倒
								</label>
							</div>
						</div>

						<div class="am-form-group">
							<label for="user-name" class="am-u-sm-3 am-form-label">住宿环境</label>
							<div class="am-u-sm-9">
								<label class="am-checkbox-inline"> <input  type="checkbox" value="单人间" name="live" <c:if test="${fn:contains(jobRecord.live,'单人间')}">checked="checked"</c:if>> 单人间
								</label> <label class="am-checkbox-inline"> <input  <c:if test="${fn:contains(jobRecord.live,'多人间')}">checked="checked"</c:if> type="checkbox" name="live" value="多人间"> 多人间
								</label> <label class="am-checkbox-inline" > <input   type="checkbox" name="docInlineRadio" value=" 卫生间" <c:if test="${fn:contains(jobRecord.live,'卫生间')}">checked="checked"</c:if>> 卫生间
								</label><br> <label class="am-checkbox-inline"> <input  type="checkbox" name="live" value="冲凉房" <c:if test="${fn:contains(jobRecord.live,'冲凉房')}">checked="checked"</c:if>> 冲凉房
								</label> <label class="am-checkbox-inline" > <input  type="checkbox" name="live" value="热水" <c:if test="${fn:contains(jobRecord.live,'热水')}">checked="checked"</c:if>> 热水
								</label> <label class="am-checkbox-inline"> <input  type="checkbox" name="live" value="空调" <c:if test="${fn:contains(jobRecord.live,'空调')}">checked="checked"</c:if>>空调
								</label> <br> <label class="am-checkbox-inline"> <input  type="checkbox" name="live" value="厂区内" <c:if test="${fn:contains(jobRecord.live,'厂区内')}">checked="checked"</c:if>>厂区内
								</label> <label class="am-checkbox-inline"> <input  type="checkbox" name="live" value="厂区外" <c:if test="${fn:contains(jobRecord.live,'厂区外')}">checked="checked"</c:if>>厂区外
								</label>
							</div>
						</div>

						<div class="am-form-group">
							<label for="user-name" class="am-u-sm-3 am-form-label">就餐方式</label>
							<div class="am-u-sm-9">
								<label class="am-radio-inline"> <input type="radio" ${jobRecord.eatType=='标准餐'?'checked="checked"':'' } value="标准餐" name="eatType"> 标准餐
								</label> <label class="am-radio-inline"> <input type="radio" ${jobRecord.eatType=='自助餐'?'checked="checked"':'' } value="自助餐" name="eatType">自助餐
								</label> </label> <label class="am-radio-inline"> <input type="radio" ${jobRecord.eatType=='不提供'?'checked="checked"':'' } name="eatType">不提供
								</label>
							</div>
						</div>

						<div class="am-form-group">
							<label for="user-name" class="am-u-sm-3 am-form-label">吃饭标准</label>
							<div class="am-u-sm-9">
								<label class="am-radio-inline"> <input type="radio" ${jobRecord.eatStandard=='一日两餐'?'checked="checked"':'' } name="eatStandard" value="一日两餐">一日两餐
								</label> <label class="am-radio-inline"> <input  type="radio" ${jobRecord.eatStandard=='一日三餐'?'checked="checked"':'' } name="eatStandard" value="一日三餐">一日三餐
								</label> <br> <label class="am-radio-inline"> <input  type="radio" ${jobRecord.eatStandard=='一日四餐'?'checked="checked"':'' } name="eatStandard" value="一日四餐">一日四餐
								</label> </label> <label class="am-radio-inline"> <input  type="radio" ${jobRecord.eatStandard=='不提供'?'checked="checked"':'' } name="eatStandard" value="不提供">不提供
								</label>
							</div>
						</div>

						<div class="am-form-group">
							<label for="user-name" class="am-u-sm-3 am-form-label">吃饭标准补充</label>
							<div class="am-u-sm-9">
								<input  name="eatStandardEx" type="text" id="name" value="${jobRecord.eatStandardEx }" placeholder="吃饭标准补充"  >
							</div>
						</div>

						<hr>

						<div class="am-form-group">
							<label for="user-name" class="am-u-sm-3 am-form-label">证件要求</label>
							<div class="am-u-sm-9">
								<input name="certificates" type="text" id="name" placeholder="证件要求" value="${jobRecord.certificates }"  >
							</div>
						</div>

						<div class="am-form-group">
							<label for="user-name" class="am-u-sm-3 am-form-label">年龄要求</label>
							<div class="am-u-sm-4">
								<input  name="minage" type="text" class="am-form-field" placeholder="最小年龄" value="${jobRecord.minage }">
							</div>
							<div class="am-u-sm-1">至</div>
							<div class="am-u-sm-4">
								<input  name="maxage" type="text" class="am-form-field" placeholder="最大年龄" value="${jobRecord.maxage }">
							</div>
						</div>



						<div class="am-form-group">
							<label for="user-name" class="am-u-sm-3 am-form-label">入职要求</label>
							<div class="am-u-sm-9">
								<textarea  name="required" class="" rows="4" id="doc-ta-1">${jobRecord.required }</textarea>
							</div>
						</div>
						
						<div class="am-form-group">
							<label for="user-name" class="am-u-sm-3 am-form-label">招聘状态</label>
							<div class="am-u-sm-9">
								 <label class="am-radio-inline"> <input  type="radio"  ${jobRecord.isFinish==1?'checked="checked"':'' }  name="isFinish" value="1">正在招聘
								</label>
								<label class="am-radio-inline"> <input type="radio" ${jobRecord.isFinish==0?'checked="checked"':'' } name="isFinish" value="0">已结束
								</label>
							</div>
						</div>
						
						
						<div class="am-form-group">
							<div class="am-u-sm-9 am-u-sm-push-3">
								<button onclick="registerCompany()" type="button"
									class="am-btn am-btn-primary am-btn-block">修改企业信息</button>
							</div>
						</div>
						<input name="id" type="text" id="id"  value="${jobRecord.id }" style="visibility: hidden;width:1px;height:1px;">
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
	<script type="text/javascript">
		var showArea = function() {
			Gid('show').innerHTML = "<h3>省" + Gid('s_province').value + " - 市"
					+ Gid('s_city').value + " - 县/区" + Gid('s_county').value
					+ "</h3>"
		}
		
		window.onload=function(){
		 $("#s_province").find("option[value='${jobRecord.province}']").attr("selected",true);
		 $("#s_province").trigger("change");
		 $("#s_city").find("option[value='${jobRecord.city}']").attr("selected",true);
		 $("#s_city").trigger("change");
		 $("#s_county").find("option[value='${jobRecord.region}']").attr("selected",true);
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
		function registerCompany() {
			$("form:first").validator('isFormValid')
			if ($(".am-field-error").size() == 0)
				do_confirm("确认修改?", function() {
					$("form:first").submit();
				});
		}
		
		$(function(){
		_init_area();
			$("input:radio").bind('click',function(){
			    if($(this).attr('checked')){
			        $(this).removeAttr('checked');
			    }else{
			        $(this).attr('checked','checked');
			    }
			});
		});
	</script>
</body>
</html>
