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
                <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">办公用品管理</strong> / <small>Office Supply Management</small></div>
            </div>
            <div class="am-tabs" data-am-tabs="{noSwipe: 1}" id="doc-tab-demo-1">
                <ul class="am-tabs-nav am-nav am-nav-tabs">
                    <li class="am-active">
                        <a href="javascript: void(0)">数据列表</a>
                    </li>
                    <li>
                        <a href="javascript: void(0)">数据添加</a>
                    </li>
                </ul>

                <div class="am-tabs-bd">
                    <div class="am-tab-panel am-active">
                        <div class="am-g">
                            <div class="am-u-sm-12 am-u-md-3" style="float: right;">
                                <div class="am-input-group am-input-group-sm">
                                    <input type="text" class="am-form-field" placeholder="输入部门名称查看数据" id="content">
                                    <span class="am-input-group-btn">
                                        <button class="am-btn am-btn-default" type="button" onclick="find()">搜索</button>
                                    </span>
                                </div>
                            </div>
                        </div>
                        <div class="am-g">
                            <div class="am-u-sm-12">
                                <table class="am-table am-table-striped am-table-striped">
                                    <thead>
                                    <tr>
                                        <th class="am-hide-sm-only">编号</th>
                                        <th>用品名称</th>
                                        <th>采购价格</th>
                                        <th class="am-hide-sm-only">所属部门</th>
                                        <th>操作</th>
                                    </tr>
                                    </thead>
                                    <tbody id="infoList">
                                    <c:forEach items="${list}" var="list">
                                    <tr>
                                        <td class='am-hide-sm-only'>${list.serial}</td>
                                        <td>${list.name}</td>
                                        <td>${list.price}</td>
                                        <td class="am-hide-sm-only">${list.department}</td>
                                        <td>
                                            <div class="am-btn-toolbar" id="edit">
                                                <div class="am-btn-group am-btn-group-xs">
                                                    <button class="am-btn am-btn-default am-btn-xs am-text-success" onclick="detailInfo(${list.id})"><span class="am-icon-circle-o"></span></button>
                                                    <a href="/HROA/office/update.html?id=${list.id}">
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
                    <div class="am-tab-panel">
                        <form class="am-form" action="/HROA/office/issue.html" method="post" id="officeBaseInfo">
                            <fieldset>
                                <div class="am-form-group">
                                    <label for="name">办公用品名称</label>
                                    <input type="text" class="" id="name" name="name" placeholder="输入办公用品名称" required>
                                </div>
                                <div class="am-form-group">
                                    <label for="department">办公用品部门</label>
                                    <input type="text" class="" id="department" name="department" placeholder="输入办公用品部门" required>
                                </div>
                                <div class="am-form-group">
                                    <label for="manager">管理人</label>
                                    <input type="text" class="" id="manager" name="manager" placeholder="输入管理人" required>
                                </div>
                                <div class="am-form-group">
                                    <label for="sBuyTime">采购日期</label>
                                    <input type="date" class="" id="sBuyTime" name="sBuyTime" required>
                                </div>
                                <div class="am-form-group">
                                    <label for="price">采购价格（元）</label>
                                    <input type="number" class="" id="price" name="price" placeholder="价格需大于1，小于99999" min="1" max="99999" required>
                                </div>
                                <p><button type="submit" class="am-btn am-btn-primary am-btn-block">提交</button></p>
                            </fieldset>
                        </form>
                    </div>
                </div>
            </div>
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
<script src="${pageContext.request.contextPath}/js/office/office.js"></script>
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
            if(!first){
                var currentPage = context.option.curr;
                window.location.href="/HROA/office/index.html?page="+currentPage;
            }
        }
    });
</script>
</body>

</html>
