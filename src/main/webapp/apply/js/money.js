/**
 * @author chenhao
 * @date 2017/6/19 9:57
 */
//格式限制
function check(){
	var phone=$("#user-phone").val();
	var name=$("#user-name").val();
	var usepeople=$("#use-people").val();
	var spendunit=$("#spendunit").val();
	var money=$("#usemoney").val();
	var time=$("#use-time").val();
	if(phone!=""&&name!=""&&usepeople!=""&&spendunit!=""&&money!=""&&time!=""){
		return true;
	}else{
		alert_("请填写完整信息");
		return false;
	}
}
function alert_(title,word){
	AMUI.dialog.alert({
	  title: title,
	  content:word,
	  onConfirm: function() {
	      history.go(0);
	    }
	});
}

//获取地理位置
$(function() {
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
});

//百度地图WebAPI 坐标转地址
function showPosition(latitude,longtitude) {
    var url = 'https://api.map.baidu.com/geocoder/v2/?ak=5TxxLi6fk0I2nqtjeFbw5n0Q0N352xXs&callback=?&location=' +latitude+ ',' + longtitude + '&output=json&pois=0&coordtype=bd09ll&batch=false';
    $.getJSON(url, function (res) {
    	var sematic=res.result.sematic_description;
    	var district=res.result.addressComponent.district;
    	var street=res.result.addressComponent.street;
    	$("#useplace").html(district+" "+sematic);
    	$("#place").val(district+" "+sematic);
    	console.log(res.result);
    });
}

function baidu_alert_(title,word){
	AMUI.dialog.alert({
	  title: title,
	  content:word
	});
}

//百度地图获取坐标
function getAddr() {
    var geolocation = new BMap.Geolocation();
    var pt;
    geolocation.getCurrentPosition(function (r) {
        if (this.getStatus() == BMAP_STATUS_SUCCESS) {
            alert(r.point.lng + " ， " + r.point.lat);
            pt = r;
            showPosition(pt);
        }
    });
}

//百度地图JS API 坐标转地址，没有加载地图时获取不到rs,总是null
function getLocation(myGeo,pt,rs) {
    // 根据坐标得到地址描述 
    myGeo.getLocation(pt, function (rs) {
        if (rs) {
            var addComp = rs.addressComponents;
            window.clearInterval(interval);
            alert(addComp);
        }
        return rs;
    });
}

//初始化地图
function initMap(point){
	var map=new BMap.Map('map');
	map.addControl(new BMap.NavigationControl()); 
	map.addControl(new BMap.ScaleControl()); 
	map.addControl(new BMap.OverviewMapControl()); 
	map.centerAndZoom(point, 15); 
	map.addOverlay(new BMap.Marker(point)) 
}