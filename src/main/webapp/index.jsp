<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page contentType="text/html;charset=UTF-8"%>
<!doctype html>
<html class="no-js fixed-layout">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>OA办公系统</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="assets/css/amazeui.min.css"/>
  <link rel="stylesheet" href="assets/css/admin.css">
</head>
<body>
<jsp:include page="public/header.jsp"></jsp:include>
<div class="am-cf admin-main">
  <jsp:include page="public/sidebar.jsp"></jsp:include>
  <div class="admin-content" style="overflow: hidden;">
    <iframe src="admin-index.jsp"  width="100%" height="100%" name="content"></iframe>
  </div>
</div>
<script src="assets/js/amazeui.ie8polyfill.min.js"></script>
<script src="js/jquery.min.js"></script>
<script src="assets/js/amazeui.min.js"></script>
<script src="assets/js/app.js"></script>
</body>
</html>
