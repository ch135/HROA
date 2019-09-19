<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>办公用品管理</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/amazeui.min.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/office/office.css" />
</head>

<body>
<div class="am-cf admin-main">
    <!-- content start -->
    <div class="admin-content">
        <div class="admin-content-body">
            <div class="am-cf am-padding">
                <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">办公用品修改</strong> / <small>Office Supply Recompose</small></div>
            </div>
            <form class="am-form am-u-md-6 am-u-md-centered" action="/HROA/office/updateInfo.html" method="post" id="officeBaseInfo">
                <fieldset>
                    <input type="hidden" name="id" value="${office.id}">
                    <div class="am-form-group">
                        <label for="name">办公用品名称</label>
                        <input type="text" class="" id="name" name="name" placeholder="输入办公用品名称" value="${office.name}" required>
                    </div>
                    <div class="am-form-group">
                        <label for="department">办公用品部门</label>
                        <input type="text" class="" id="department" name="department" placeholder="输入办公用品部门" value="${office.department}" required>
                    </div>
                    <div class="am-form-group">
                        <label for="manager">管理人</label>
                        <input type="text" class="" id="manager" name="manager" placeholder="输入管理人" value="${office.manager}" required>
                    </div>
                    <div class="am-form-group">
                        <label for="sBuyTime">采购日期</label>
                        <input type="date" class="" id="sBuyTime" name="sBuyTime" value="${office.sBuyTime}" required>
                    </div>
                    <div class="am-form-group">
                        <label for="price">采购价格（元）</label>
                        <input type="number" class="" id="price" name="price" placeholder="输入采购价格" min="1" max="99999" value="${office.price}" required>
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
<script src="${pageContext.request.contextPath}/js/office/office.js"></script>
</body>
</html>
