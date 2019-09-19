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
                <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">工资转账</strong> / <small>Salary Transfer</small></div>
            </div>
            <div class="am-g">
                <div class="am-u-sm-2 am-u-md-4" style="float: left;">
                    <div class="am-input-group am-input-group-sm">
                        <span class="am-input-group-btn">
                            <button class="am-btn am-btn-default" type="button" onclick="message()">导入</button>
                        </span>
                    </div>
                </div>
                <div class="am-u-sm-10 am-u-md-4" style="float: right;">
                    <div class="am-input-group am-input-group-sm">
                        <input type="month" class="am-form-field" id="content">
                        <span class="am-input-group-btn">
                            <button class="am-btn am-btn-default" type="button" onclick="find()">搜索</button>
                            <button class="am-btn am-btn-default" type="button" onclick="exportInfo()">导出</button>
                        </span>
                    </div>
                </div>
            </div>
            <div class="am-g">
                <div class="am-u-sm-12">
                    <table class="am-table am-table-striped am-table-striped">
                        <thead>
                        <tr>
                            <th class="am-hide-sm-only">厂名</th>
                            <th>工号</th>
                            <th>名字</th>
                            <th class="am-hide-sm-only">开户行</th>
                            <th>金额</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody id="infoList">
                        <c:forEach items="${list}" var="list">
                        <tr>
                            <td class='am-hide-sm-only'>${list.company}</td>
                            <td>${list.number}</td>
                            <td>${list.name}</td>
                            <td class="am-hide-sm-only">${list.bank}</td>
                            <td>${list.money}</td>
                            <td>
                                <div class="am-btn-toolbar" id="edit">
                                    <div class="am-btn-group am-btn-group-xs">
                                        <button class="am-btn am-btn-default am-btn-xs am-text-success" onclick="detailInfo(${list.id})"><span class="am-icon-circle-o"></span></button>
                                        <a href="/HROA/salary/update.html?id=${list.id}">
                                            <button class="am-btn am-btn-default am-btn-xs am-text-secondary"><span class="am-icon-pencil-square-o"></span></button>
                                        </a>
                                        <button class="am-btn am-btn-default am-btn-xs am-text-danger" onclick="deleteInfo(${list.id})"><span class="am-icon-trash-o"></span></button>
                                    </div>
                                </div>
                            </td>
                        </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
            <%--分页--%>
            <div id="page"></div>
            <input type="hidden" id="currentPage" value="${currentPage}">
        </div>
        <!--模态框-->
        <div class="am-modal am-modal-confirm" tabindex="-1" id="deleteInfo">
            <div class="am-modal-dialog">
                <div class="am-modal-hd">数据删除</div>
                <div class="am-modal-bd">
                    确定要删除这条信息吗？
                </div>
                <div class="am-modal-footer">
                    <span class="am-modal-btn" data-am-modal-cancel>取消</span>
                    <span class="am-modal-btn" data-am-modal-confirm>确定</span>
                </div>
            </div>
        </div>
        <div class="am-modal am-modal-confirm" tabindex="-1" id="detail">
            <div class="am-modal-dialog" id="detailInfo">
            </div>
        </div>
        <div class="am-modal am-modal-confirm" tabindex="-1" id="import">
            <div class="am-modal-dialog">
                <form action="/HROA/salary/import.html" id="importInfo" onsubmit="return checkData()" method="post" enctype="multipart/form-data">
                    <div class="am-form-group am-form-file">
                        <button type="button" class="am-btn am-btn-danger am-btn-sm">
                            <i class="am-icon-cloud-upload"></i> 选择要上传的转账文件
                        </button>
                        <input id="excelFile" type="file" name="upfile" multiple>
                        <span id="fileName"></span>
                    </div>
                    <label for="month">月份</label>
                    <input type="month" id="month" name="month" required>
                    <div class="importBtn">
                        <button type="submit" class="am-btn am-btn-primary am-btn-sm am-btn-block">导入数据</button>
                    </div>
                </form>
            </div>
        </div>
        <!--模态框结束-->
        <footer class="admin-content-footer">
            <hr>
            <p class="am-padding-left">©Copyright &copy;2017 All Rights Reserved 惠州学院软件开发实验室</p>
        </footer>
    </div>
</div>
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/amazeui.min.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/app.js"></script>
<script src="${pageContext.request.contextPath}/assets/js/dist/amazeui.page.js"></script>
<script src="${pageContext.request.contextPath}/js/salary/transfer.js"></script>
<script>
    $("#page").page({
        pages:${allPage},
        curr:${currentPage},
        first: "首页", //设置false则不显示，默认为false
        last: "尾页", //设置false则不显示，默认为false
        prev: false, //若不显示，设置false即可，默认为上一页
        next: false, //若不显示，设置false即可，默认为下一页
        groups: 4, //连续显示分页数
        jump:function(context,first){
            //获取当前页的数据
            if(!first){
                var currentPage = context.option.curr;
                window.location.href="/HROA/salary/index.html?page="+currentPage;
            }
        }
    });
</script>
</body>

</html>
