var reg=/^[\\u4e00-\\u9fa5_a-zA-Z0-9-]{1,16}$/;//限制账号昵称密码的字符输入
$("#addUser").click(function(){
	if($('#account').val()==null||$('#account').val()==""){
		AMUI.dialog.alert({
	    	title: '提示',
	    	content: '账号不能为空！',
	    	onConfirm: function() {
	      		console.log('close');
	    	}
	  	});
	}else if(!reg.test($('#account').val())){
		AMUI.dialog.alert({
	    	title: '提示',
	    	content: '账号由英文、数字、减号和下划线组成！',
	    	onConfirm: function() {
	      		console.log('close');
	    	}
	  	});
	}else if($('#nickname').val()==null||$('#nickname').val()==""){
		AMUI.dialog.alert({
	    	title: '提示',
	    	content: '昵称不能为空！',
	    	onConfirm: function() {
	      		console.log('close');
	    	}
	  	});
	}else if(!reg.test($('#nickname').val())){
		AMUI.dialog.alert({
	    	title: '提示',
	    	content: '昵称由英文、数字、减号和下划线组成！',
	    	onConfirm: function() {
	      		console.log('close');
	    	}
	  	});
	}else if($('#password').val()==null||$('#password').val()==""){
		AMUI.dialog.alert({
	    	title: '提示',
	    	content: '密码不能为空！',
	    	onConfirm: function() {
	      		console.log('close');
	    	}
	  	});
	}else if(!reg.test($('#password').val())){
		AMUI.dialog.alert({
	    	title: '提示',
	    	content: '密码由英文、数字、减号和下划线组成！',
	    	onConfirm: function() {
	      		console.log('close');
	    	}
	  	});
	}else if($('#password').val()!=$("#password-again").val()){
		AMUI.dialog.alert({
	    	title: '提示',
	    	content: '两次密码不一致！',
	    	onConfirm: function() {
	      		console.log('close');
	    	}
	  	});
	}else if($('#dpId').val()==0){
		AMUI.dialog.alert({
	    	title: '提示',
	    	content: '请选择至少一个部门！',
	    	onConfirm: function() {
	      		console.log('close');
	    	}
	  	});
	}else {
		$.ajax({
			url:"/HROA/rbac/adduser.html",
			type:'post',
			data:{account:$('#account').val(),password:$('#password').val(),nickname:$('#nickname').val(),dpId:$('#dpId').val()},
			dataType:'json',
			success:function(data){
				if(data.status==1){
					AMUI.dialog.alert({
				    	title: '提示',
				    	content: '用户添加成功!',
				    	onConfirm: function() {
				      		console.log('close');
				      		location.reload();
				    	}
				  	});
				}else if(data.status==2){
					AMUI.dialog.alert({
				    	title: '提示',
				    	content: '用户添加成功!',
				    	onConfirm: function() {
				      		console.log('close');
				      		location.reload();
				    	}
				  	});
				}else{
					AMUI.dialog.alert({
				    	title: '提示',
				    	content: '用户添加失败!',
				    	onConfirm: function() {
				      		console.log('close');
				      		location.reload();
				    	}
				  	});
				} 
			}
		});
	}
})