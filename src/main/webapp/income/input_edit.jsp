<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>收入管理</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/amazeui.min.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/income/income.css" />
</head>

<body>
<div class="am-cf admin-main">
    <!-- content start -->
    <div class="admin-content">
        <div class="admin-content-body">
            <div class="am-cf am-padding">
                <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">办公用品修改</strong> / <small>Office Supply Recompose</small></div>
            </div>
            <form class="am-form am-u-md-6 am-u-md-centered" action="/HROA/income/updateInfo.html" method="post" id="incomeBaseInfo">
                <fieldset>
                    <input type="hidden" name="id" value="${income.id}">
                    <div class="am-form-group">
                        <label for="department">部门</label>
                        <input type="text" class="" id="department" name="department" placeholder="输入部门名称" value="${income.department}" required>
                    </div>
                    <div class="am-form-group">
                        <label for="linkMan">联系人</label>
                        <input type="text" class="" id="linkMan" name="linkMan" placeholder="输入联系人" value="${income.linkMan}" required>
                    </div>
                    <div class="am-form-group">
                        <label for="origin">来源</label>
                        <input type="text" class="" id="origin" name="origin" placeholder="输入金额来源" value="${income.origin}" required>
                    </div>
                    <div class="am-form-group">
                        <label for="money">金额</label>
                        <input type="number" class="" id="money" name="money" value="${income.money}" placeholder="输入金额大小" min="1" required>
                    </div>
                    <div class="am-form-group">
                        <label for="sIncomeDate">收入时间</label>
                        <input type="date" class="" id="sIncomeDate" name="sIncomeDate" placeholder="输入收入时间" value="${income.sIncomeDate}" required>
                    </div>
                    <div class="am-form-group">
                        <label for="state">说明</label>
                        <textarea class="" rows="5" type="text" id="state" name="state" placeholder="输入收入说明">${income.state}</textarea>
                    </div>
                    <p><button type="submit" class="am-btn am-btn-primary am-btn-block">提交</button></p>
                </fieldset>
            </form>
        </div>
        <footer class="admin-content-footer">
            <hr>
            <p class="am-padding-left">©Copyright &copy;2017 All Rights Reserved 惠州学院软件开发实验室</p>
        </footer>
    </div>
</div>
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/amazeui.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/app.js"></script>
<script src="${pageContext.request.contextPath}/js/income/income.js"></script>
</body>
</html>
