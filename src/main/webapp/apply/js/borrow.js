
//提交前检查填写的信息
function check(){
	var phone=$("#user-phone").val();
	var name=$("#user-name").val();
	var manager=$("#manager-name").val();
	var department=$("#user-depa").val();
	var applytime=$("#user-start").val();
	var backtime=$("#user-end").val();
	var reason=$("#user-reason").val();
	var money=$("#user-money").val();
	
	if(phone!=""&&name!=""&&manager!=""&&department!=""&&applytime!=""&&backtime!=""&&reason!=""&&money!=""){
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

//根据手机号获得相关信息
$("#user-phone").change(function(){
	var phone=$("#user-phone").val();
	if(phone!=""){
		$.ajax({
			"type":"post",
			"url":"/HROA/borrow/getborrowph.html",
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