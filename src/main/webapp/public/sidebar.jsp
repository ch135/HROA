<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
<body class="no-js">
	<div class="admin-sidebar am-offcanvas" id="admin-offcanvas">
		<div class="am-offcanvas-bar admin-offcanvas-bar">
			<ul class="am-list admin-sidebar-list">
				<li><a href="/HROA"><span class="am-icon-home"></span> 首页</a></li>
				<li class="company_register"><a class="am-cf" data-am-collapse="{target: '#company-nav'}"><span class="am-icon-cloud"></span> 企业登记 <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
					<ul class="am-list am-collapse admin-sidebar-sub" id="company-nav">
						<li><a href="./JobRecord/addUI.html" target="content" class="am-cf"><span class="am-icon-check"></span> 企业录入</a></li>
						<li><a href="./JobRecord/listUI.html" target="content"><span class="am-icon-puzzle-piece"></span> 企业列表</a></li>
						<c:if test="${userPowerMap.p312=='p312'}">
						<li><a href="./company/company_contract.jsp" target="content"><span class="am-icon-pencil-square-o"></span> 录入企业合同</a></li>
						<li><a href="./ComContract/showComContractList.html" target="content"><span class="am-icon-eyedropper"></span> 编辑企业合同列表</a></li>
						</c:if>
<!-- 						<li><a href="./ComContract/showComContractListToCom.html" target="content"><span class="am-icon-eye"></span> 查看本企业合同列表</a></li>
 -->						
 						<c:if test="${userPowerMap.p311=='p311'}">
 						<li><a href="./ComContract/showComContractListToManager.html" target="content"><span class="am-icon-table"></span> 查看企业合同列表</a></li>
 						</c:if>
					</ul>
				</li>
				<li class="student_register"><a class="am-cf" data-am-collapse="{target: '#student-nav'}"><span class="am-icon-user-plus"></span> 学生登记 <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
					<ul class="am-list am-collapse admin-sidebar-sub" id="student-nav">
						<li><a href="./user/user_register.jsp" target="content" class="am-cf"><span class="am-icon-check"></span> 学生录入</a></li>
						<li><a href="./ShUser/listUserUI.html" target="content"><span class="am-icon-puzzle-piece"></span> 学生列表</a></li>
						<li><a href="./EnterCom/listEnterComUI.html" target="content"><span class="am-icon-th"></span> 入职记录</a></li>
					</ul>
				</li>
				
				<li class="student_register"><a class="am-cf" data-am-collapse="{target: '#agent-nav'}"><span class="am-icon-hand-stop-o"></span> 代理模块 <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
					<ul class="am-list am-collapse admin-sidebar-sub" id="agent-nav">
						  <li><a href="./agent/agent_register.jsp" target="content" class="am-cf"><span class="am-icon-check"></span> 代理录入</a></li>
						<li><a href="./Agent/listAgentUI.html" target="content"><span class="am-icon-puzzle-piece"></span> 代理列表</a></li>
						<c:if test="${userPowerMap.p412=='p412'}">
						 <li><a href="./agent/agent_contract.jsp" target="content"><span class="am-icon-pencil-square-o"></span> 录入代理合同</a></li>
						 <li><a href="./AgentContract/showAgentContractList.html" target="content"><span class="am-icon-eyedropper"></span> 编辑代理合同列表</a></li>
						 </c:if>
						<!--  <li><a href="./AgentContract/showAgentContractListToAgent.html" target="content"><span class="am-icon-eye"></span> 查看本代理合同列表</a></li> -->
						 <c:if test="${userPowerMap.p411=='p411'}">
						 <li><a href="./AgentContract/showAgentContractListToManager.html" target="content"><span class="am-icon-table"></span> 查看代理合同列表</a></li>
						 </c:if>
					</ul>
				</li>
				<li class="student_register"><a href="${pageContext.request.contextPath}/office/index.html" class="am-cf" target="content">
					<span class="am-icon-suitcase"></span> 办公用品<span class="am-icon-angle-right am-fr am-margin-right"></span></a>
				</li>
				<li class="student_register"><a href="${pageContext.request.contextPath}/income/index.html" class="am-cf" target="content">
					<span class="am-icon-reorder"></span> 收入管理<span class="am-icon-angle-right am-fr am-margin-right"></span></a>
				</li>
				<li class="student_register"><a class="am-cf" data-am-collapse="{target: '#salary-nav'}"><span class="am-icon-anchor"></span> 工资管理<span class="am-icon-angle-right am-fr am-margin-right"></span></a>
					<ul class="am-list am-collapse admin-sidebar-sub" id="salary-nav">
						<li><a href="${pageContext.request.contextPath}/salary/index.html" target="content"><span class="am-icon-file-text-o"></span> 工资转账</a></li>
						<li><a href="${pageContext.request.contextPath}/detail/index.html" target="content"><span class="am-icon-rmb"></span> 工资明细</a></li>
					</ul>
				</li>
				<!-- job-log start -->
				<li class="admin-parent">
					<a id="job-log" class="am-cf" data-am-collapse="{target: '#job-log-nav'}">
						<span class="am-icon-calendar-check-o"></span> 工作日志 
						<span id="jb-log" class="am-icon-angle-right am-fr am-margin-right"></span>
					</a>
		            <ul id="job-log-nav" class="am-list am-collapse admin-sidebar-sub">
			          	<li><a href="${pageContext.request.contextPath}/joblog/own/logList.jsp" target="content"><span class="am-icon-map-o"></span>我的日报</a></li>
			          	<li><a href="${pageContext.request.contextPath}/jbLog/gtJbLg.html?pageSize=10&startPage=1" target="content"><span class="am-icon-bars"></span>日报列表</a></li>
			          	<li><a href="${pageContext.request.contextPath}/joblog/week/planList.jsp" target="content"><span class="am-icon-edit"></span>周计划书</a></li>
			          	<li><a href="${pageContext.request.contextPath}/joblog/month/planList.jsp" target="content"><span class="am-icon-folder-open-o"></span>月计划书</a></li>
		            </ul>
        		</li>
        		<!-- job-log end -->
        		<!-- task-assign start -->
				<li class="admin-parent">
					<a id="task-assign" class="am-cf" data-am-collapse="{target: '#task-assign-nav'}">
						<span class="am-icon-newspaper-o"></span> 任务管理 
						<span id="tk-assign" class="am-icon-angle-right am-fr am-margin-right"></span>
					</a>
		            <ul id="task-assign-nav" class="am-list am-collapse admin-sidebar-sub">
		            	<li><a href="${pageContext.request.contextPath}/task/mylist.jsp" target="content"><span class="am-icon-book"></span>我的任务</a></li>
			          	<li><a href="${pageContext.request.contextPath}/task/gtTask.html?pageSize=10&startPage=1" target="content"><span class="am-icon-tasks"></span>任务列表</a></li>
		            </ul>
        		</li>
        		<!-- task-assign end -->
				<!-- user-center start -->
				<li class="admin-parent">
					<a id="user-center" class="am-cf" data-am-collapse="{target: '#usercenter-nav'}">
						<span class="am-icon-user"></span> 用户中心 
						<span id="user" class="am-icon-angle-right am-fr am-margin-right"></span>
					</a>
		            <ul id="usercenter-nav" class="am-list am-collapse admin-sidebar-sub">
			          	<li><a href="${pageContext.request.contextPath}/rbac/getRlList.html?pageSize=5&startPage=1" target="content"><span class="am-icon-user-secret"></span>  用户角色管理</a></li>
			          	<li><a href="${pageContext.request.contextPath}/rbac/gtUserList.html?pageSize=10&startPage=1" target="content"><span class="am-icon-users"></span> 系统用户管理</a></li>
			          	<li><a href="${pageContext.request.contextPath}/rbac/gtDpList.html?pageSize=5&startPage=1" target="content"><span class="am-icon-gear"></span> 系统部门管理</a></li>
		            </ul>
        		</li>
        		<!-- user-center end -->
        		<!-- sys-notice start -->
				<li class="admin-parent">
					<a id="sys-notice" class="am-cf" data-am-collapse="{target: '#sys-notice-nav'}">
						<span class="am-icon-commenting-o"></span> 系统公告 
						<span id="s-notice" class="am-icon-angle-right am-fr am-margin-right"></span>
					</a>
		            <ul id="sys-notice-nav" class="am-list am-collapse admin-sidebar-sub">
			          	<li><a href="${pageContext.request.contextPath}/notice/gtNtList.html?pageSize=10&startPage=1" target="content"><span class="am-icon-table"></span> 公告列表</a></li>
		            </ul>
        		</li>
        		<!-- sys-notice end -->
				<li class="student_register">
		          <a data-am-collapse="{target: '#apply-nav'}" onclick="applyNum()"><span class="am-icon-file"></span>申请中心 <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
		          <ul class="am-list am-collapse admin-sidebar-sub" id="apply-nav">
		            <li><a href="/HROA/apply/admin_leave.jsp" target="content" class="am-cf"><span class="am-icon-check"></span>请假申请</a></li>
		            <li><a href="/HROA/leave/getleave.html?start=1&name=" target="content"><span class="am-icon-calendar"></span>请假申请列表<span class="am-badge am-badge-secondary am-round"></span></a></li>
		            <li><a href="/HROA/apply/admin_trip.jsp" target="content" class="am-cf"><span class="am-icon-tripadvisor"></span>出差申请</a></li>
		            <li><a href="/HROA/trip/gettrip.html?start=1&name=" target="content"><span class="am-icon-calendar"></span>出差申请列表<span class="am-badge am-badge-secondary am-round"></span></a></li>
		            <li><a href="/HROA/apply/admin_money.jsp" target="content"><span class="am-icon-money"></span>费用报销</a></li>
		            <li><a href="/HROA/money/getmoney.html?start=1&name=" target="content"><span class="am-icon-calendar"></spa>费用报销列表<span class="am-badge am-badge-secondary am-round"></span></a></li>
		            <li><a href="/HROA/apply/admin_borrow.jsp" target="content"><span class="am-icon-bug"></spa>借资申请</a></li>
		            <li><a href="/HROA/borrow/getborrow.html?start=1&name=" target="content"><span class="am-icon-calendar"></spa>借资申请列表<span class="am-badge am-badge-secondary am-round"></span></a></li>
		          </ul>
		        </li>
		        <li>
		         <a data-am-collapse="{target: '#sign-nav'}"><span class="am-icon-circle"></span>在线签到 <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
		          <ul class="am-list am-collapse admin-sidebar-sub" id="sign-nav">
		            <li><a href="/HROA/sign/admin_sign.jsp" target="content" class="am-cf"><span class="am-icon-magic"></span>签  到</a></li>
		            <li><a href="/HROA/sign/monthsign.html" target="content" class="am-cf"><span class="am-icon-calendar"></span>签到列表</a></li>
		          </ul>
		       </li>
			</ul>
			<div class="am-panel am-panel-default admin-sidebar-panel">
				<div class="am-panel-bd">
					<p>
						<span class="am-icon-bookmark"></span> 公告
					</p>
					<p>欢迎访问囧职网OA系统</p>
				</div>
			</div>
		</div>
	</div>
	<a href="#" class="am-icon-btn am-icon-th-list am-show-sm-only admin-menu" data-am-offcanvas="{target: '#admin-offcanvas'}"></a>
	<script type="text/javascript" src="/HROA/js/jquery.min.js"></script>
	<script type="text/javascript" src="public/js/ApplyNum.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/rbac/js/userCenter.js"></script>
</body>
</html>