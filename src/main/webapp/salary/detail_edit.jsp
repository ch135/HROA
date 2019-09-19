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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/salary/salary.css" />
</head>

<body>
<div class="am-cf admin-main">
    <!-- content start -->
    <div class="admin-content">
        <div class="admin-content-body">
            <div class="am-cf am-padding">
                <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">工资明细修改</strong> / <small>Salary Detail Recompose</small></div>
            </div>
            <form class="am-form" action="/HROA/detail/updateInfo.html" method="post" id="salaryDetailBaseInfo">
                <fieldset>
                    <input type="hidden" name="id" value="${detail.id}">
                    <div class="am-form-group am-u-md-4">
                        <label for="company">厂名</label>
                        <input type="text" class="" id="company" name="company" placeholder="输入厂名" value="${detail.company}" required>
                    </div>
                    <div class="am-form-group am-u-md-4">
                        <label for="number">工号</label>
                        <input type="text" class="" id="number" name="number" placeholder="输入工号" value="${detail.number}" required>
                    </div>
                    <div class="am-form-group am-u-md-4">
                        <label for="name">名字</label>
                        <input type="text" class="" id="name" name="name" placeholder="输入名字" value="${detail.name}" required>
                    </div>
                    <div class="am-form-group am-u-md-4">
                        <label for="sBuyTime">总工时</label>
                        <input type="number" class="" id="sBuyTime" name="sBuyTime" min="1" value="${detail.worktime}" required>
                    </div>
                    <div class="am-form-group am-u-md-4">
                        <label for="price">工价（元/小时）</label>
                        <input type="number" class="" id="price" name="price" placeholder="输入工价" min="1" value="${detail.price}" required>
                    </div>
                    <div class="am-form-group am-u-md-4">
                        <label for="deserved">应得工资</label>
                        <input type="number" class="" id="deserved" name="deserved" placeholder="输入应得工资" min="1" value="${detail.deserved}" required>
                    </div>
                    <div class="am-form-group am-u-md-4">
                        <label for="meals">伙食补</label>
                        <input type="number" class="" id="meals" name="meals" placeholder="输入伙食补" value="${detail.meals}">
                    </div>
                    <div class="am-form-group am-u-md-4">
                        <label for="dinner">夜餐补</label>
                        <input type="number" class="" id="dinner" name="dinner" placeholder="输入夜餐补" value="${detail.dinner}">
                    </div>
                    <div class="am-form-group am-u-md-4">
                        <label for="otherprofit">其他补贴</label>
                        <input type="number" class="" id="otherprofit" name="otherprofit" placeholder="输入其他补贴"  value="${detail.otherprofit}">
                    </div>
                    <div class="am-form-group am-u-md-4">
                        <label for="salary">总工资</label>
                        <input type="number" class="" id="salary" name="salary" placeholder="输入总工资" min="1" value="${detail.salary}" required>
                    </div>
                    <div class="am-form-group am-u-md-4">
                        <label for="tax">所得税</label>
                        <input type="number" class="" id="tax" name="tax" placeholder="输入所得税" value="${detail.tax}">
                    </div>
                    <div class="am-form-group am-u-md-4">
                        <label for="fine">罚款</label>
                        <input type="number" class="" id="fine" name="fine" placeholder="输入罚款" value="${detail.fine}">
                    </div>
                    <div class="am-form-group am-u-md-4">
                        <label for="sign">签卡</label>
                        <input type="number" class="" id="sign" name="sign" placeholder="输入签卡" value="${detail.sign}" required>
                    </div>
                    <div class="am-form-group am-u-md-4">
                        <label for="sdcost">水电费</label>
                        <input type="number" class="" id="sdcost" name="sdcost" placeholder="输入水电费" value="${detail.sdcost}">
                    </div>
                    <div class="am-form-group am-u-md-4">
                        <label for="nontime">迟到早退</label>
                        <input type="number" class="" id="nontime" name="nontime" placeholder="输入迟到早退" value="${detail.nontime}">
                    </div>
                    <div class="am-form-group am-u-md-4">
                        <label for="otherfine">其他扣款</label>
                        <input type="number" class="" id="otherfine" name="otherfine" placeholder="输入其他扣款" value="${detail.otherfine}">
                    </div>
                    <div class="am-form-group am-u-md-4">
                        <label for="beneficent">爱心资金</label>
                        <input type="number" class="" id="beneficent" name="beneficent" placeholder="输入爱心资金" value="${detail.beneficent}">
                    </div>
                    <div class="am-form-group am-u-md-4">
                        <label for="ownleave">自离扣款</label>
                        <input type="number" class="" id="ownleave" name="ownleave" placeholder="输入自离扣款" value="${detail.ownleave}">
                    </div>
                    <div class="am-form-group am-u-md-4">
                        <label for="insurance">保险</label>
                        <input type="number" class="" id="insurance" name="insurance" placeholder="输入保险" value="${detail.insurance}">
                    </div>
                    <div class="am-form-group am-u-md-4">
                        <label for="borrow">借支</label>
                        <input type="number" class="" id="borrow" name="borrow" placeholder="输入借支" value="${detail.borrow}">
                    </div>
                    <div class="am-form-group am-u-md-4">
                        <label for="boardcost">伙食扣</label>
                        <input type="number" class="" id="boardcost" name="boardcost" placeholder="输入伙食扣" value="${detail.boardcost}">
                    </div>
                    <div class="am-form-group am-u-md-4">
                        <label for="realwages">借支</label>
                        <input type="number" class="" id="realwages" name="realwages" placeholder="输入借支" value="${detail.realwages}">
                    </div>
                    <div class="am-form-group am-u-md-4">
                        <label for="salaryDate">工作月份</label>
                        <input type="month" class="" id="salaryDate" name="salaryDate" placeholder="输入工资月份" value="${detail.salaryDate}">
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
<script src="${pageContext.request.contextPath}/js/salary/detailEdit.js"></script>
</body>
</html>
