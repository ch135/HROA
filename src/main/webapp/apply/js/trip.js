/**
 * @author chenhao
 * @date 2017/6/15 19:45
 */
//格式限制
function check(){
	var phone=$("#user-phone").val();
	var name=$("#user-name").val();
	var manager=$("#manager-name").val();
	var depatement=$("#user-depa").val();
	var start=$("#user-start").val();
	var end=$("#user-end").val();
	var reason=$("#user-reason").val();
	var place=$("#user-place").val();
	var tool=$("#user-traffic").val();
	var money=$("#user-money").val();
	if(phone!=""&&name!=""&&manager!=""&&depatement!=""&&start!=""&&end!=""&&reason!=""&&place!=""&&tool!=""&&money!=""){
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

$("#user-phone").change(function(){
	var phone=$("#user-phone").val();
	if(phone!=""){
		$.ajax({
			"type":"post",
			"url":"/HROA/trip/gettripByphone.html",
			"data":{
				"phone":phone
			},
			success:function(date){
				if(date!=""){
					date=JSON.parse(date);
					$("#user-name").val(date.name);
					$("#manager-name").val(date.manager);
					$("#user-depa").val(date.department);
				}else{
					$("#user-name").val("");
					$("#manager-name").val("");
					$("#user-depa").val("");
				}
			}
		});
	}
})