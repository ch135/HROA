<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>工资转账</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/amazeui.min.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/admin.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/salary/salary.css" />
</head>

<body>
<div class="am-cf admin-main">
    <!-- content start -->
    <div class="admin-content">
        <div class="admin-content-body">
            <div class="am-cf am-padding">
                <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">工资转账修改</strong> / <small>Salary Transfer Recompose</small></div>
            </div>
            <form class="am-form" action="/HROA/salary/updateInfo.html" method="post" id="updateInfo" onsubmit="return checkInfo()">
                <fieldset>
                    <input type="hidden" name="id" value="${salary.id}">
                    <div class="am-form-group am-u-md-4">
                        <label for="company">厂名</label>
                        <input type="text" class="" id="company" name="company" placeholder="输入厂名" value="${salary.company}" required>
                    </div>
                    <div class="am-form-group am-u-md-4">
                        <label for="number">工号</label>
                        <input type="text" class="" id="number" name="number" placeholder="输入工号" value="${salary.number}" required>
                    </div>
                    <div class="am-form-group am-u-md-4">
                        <label for="name">名字</label>
                        <input type="text" class="" id="name" name="name" placeholder="输入名字" value="${salary.name}" required>
                    </div>
                    <div class="am-form-group am-u-md-4">
                        <label for="name">性别</label>
                        <c:choose>
                            <c:when test="${salary.sex=='男'}">
                                <div id="sex">
                                    <label class="am-radio-inline">
                                        <input type="radio"  value="男" name="sex" checked>男
                                    </label>
                                    <label class="am-radio-inline">
                                        <input type="radio" name="sex" value="女">女
                                    </label>
                                </div>
                            </c:when>
                            <c:otherwise>
                                <div id="sex">
                                    <label class="am-radio-inline">
                                        <input type="radio"  value="男" name="sex">男
                                    </label>
                                    <label class="am-radio-inline">
                                        <input type="radio" name="sex" value="女" checked>女
                                    </label>
                                </div>
                            </c:otherwise>
                        </c:choose>
                    </div>
                    <div class="am-form-group am-u-md-4">
                        <label for="cardName">开户名</label>
                        <input type="text" class="" id="cardName" name="cardName" placeholder="输入开户名" value="${salary.cardName}" required>
                    </div>
                    <div class="am-form-group am-u-md-4">
                        <label for="bankCard">银行卡号</label>
                        <input type="number" class="js-pattern-Idcard" id="bankCard" name="bankCard" placeholder="输入银行卡号" value="${salary.bankCard}" required>
                        <div id="bankCardError"></div>
                    </div>
                    <div class="am-form-group am-u-md-4">
                        <label for="bank">开户行</label>
                        <input type="text" class="" id="bank" name="bank" placeholder="输入开户行" value="${salary.bank}" required>
                    </div>
                    <div class="am-form-group am-u-md-4">
                        <label for="money">金额</label>
                        <input type="number" class="" id="money" name="money" placeholder="输入金额" min="1" max="99999" value="${salary.money}" required>
                    </div>
                    <div class="am-form-group am-u-md-12">
                        <label for="remark">备注</label>
                        <textarea class="" rows="5" type="text" id="remark" name="remark" placeholder="输入收入说明" >${salary.remark}</textarea>
                    </div>
                    <div class="am-u-md-12">
                        <button type="submit" class="am-btn am-btn-primary am-btn-block">提交</button>
                    </div>
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
<script src="${pageContext.request.contextPath}/js/salary/transferEdit.js"></script>
</body>
</html>
