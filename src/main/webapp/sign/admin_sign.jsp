<%@page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!doctype html>
<html class="no-js fixed-layout">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>实时签到</title>
  <meta name="description" content="这是日签到列表页面">
  <meta name="keywords" content="index">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="renderer" content="webkit">
  <meta http-equiv="Cache-Control" content="no-siteapp" />
  <link rel="icon" type="image/png" href="/HROA/assets/i/favicon.png">
  <link rel="apple-touch-icon-precomposed" href="/HROA/assets/i/app-icon72x72@2x.png">
  <meta name="apple-mobile-web-app-title" content="Amaze UI" />
  <link rel="stylesheet" href="/HROA/assets/css/amazeui.min.css"/>
</head>
<body>
	<p>实时签到！</p>
	<script src="/HROA/js/jquery.min.js"></script>
	<script src="/HROA/assets/js/amazeui.min.js"></script>
	<script src="/HROA/js/dist/amazeui.dialog.js"></script>
	<script type="text/javascript">
		$(function(){
			var geolocation = new $.AMUI.Geolocation({
			  enableHighAccuracy: true,  //精确定位,耗流量
			  timeout: 7000
		  });
		  geolocation.get().then(function(position){
			var latitude=position.coords.latitude;//纬度
			var longtitude= position.coords.longitude;//经度
			var accuracy=position.coords.accuracy;//精确度
			showPosition(latitude,longtitude);
		  },
		  function(err) {
		    baidu_alert_('获取位置失败','请重新尝试！');
		    console.log("错误信息："+err);
		  });
		})
		
		//百度地图WebAPI 坐标转地址
		function showPosition(latitude,longtitude) {
		    var url = 'https://api.map.baidu.com/geocoder/v2/?ak=5TxxLi6fk0I2nqtjeFbw5n0Q0N352xXs&callback=?&location=' +latitude+ ',' + longtitude + '&output=json&pois=0&coordtype=bd09ll&batch=false';
		    $.getJSON(url, function (res) {
		    	var sematic=res.result.sematic_description;
		    	var district=res.result.addressComponent.district;
		    	var street=res.result.addressComponent.street;
		    	var area=district+" "+sematic;
		    	addsign(area);
		    });
		}
		
		function baidu_alert_(title,word){
			AMUI.dialog.alert({
			  title: title,
			  content:word
			});
		}
		
		function addsign(area){
			$.ajax({
				'url':'/HROA/sign/addsign.html',
				'type':'post',
				'data':{
					'area':area
				},
				success:function(date){
					baidu_alert_('签到结果',date);
				},
				error:function(){
					baidu_alert_('签到结果','签到失败');
					console.log('ajax请求失败');
				}
			})
		}
	</script>
</body>
</html>
