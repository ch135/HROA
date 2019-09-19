$(document).ready(function(){ 
	$("#job-log").click(function(){
		if($("#job-log-nav").hasClass("am-in")){
			$("#jb-log").attr("class", "am-icon-angle-right am-fr am-margin-right");
		}else{
			$("#jb-log").attr("class", "am-icon-angle-down am-fr am-margin-right");
		}
	});
	
	$("#user-center").click(function(){
		if($("#usercenter-nav").hasClass("am-in")){
			//$("#usercenter-nav").removeClass("am-in");
			$("#user").attr("class", "am-icon-angle-right am-fr am-margin-right");
		}else{
			$("#user").attr("class", "am-icon-angle-down am-fr am-margin-right");
		}
	});

	$("#task-assign").click(function(){
		if($("#task-assign-nav").hasClass("am-in")){
			$("#tk-assign").attr("class", "am-icon-angle-right am-fr am-margin-right");
		}else{
			$("#tk-assign").attr("class", "am-icon-angle-down am-fr am-margin-right");
		}
	});
	
	$("#sys-notice").click(function(){
		if($("#sys-notice-nav").hasClass("am-in")){
			$("#s-notice").attr("class", "am-icon-angle-right am-fr am-margin-right");
		}else{
			$("#s-notice").attr("class", "am-icon-angle-down am-fr am-margin-right");
		}
	});

});