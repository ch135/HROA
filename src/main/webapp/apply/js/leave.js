/**
 * @author chenhao
 * @date 2017/6/4 20:37
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
	
	if(phone!=""&&name!=""&&manager!=""&&depatement!=""&&start!=""&&end!=""&&reason!=""){
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
			"url":"/HROA/leave/getleavep.html",
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