/**
 * @author chenhao
 * @time 2017/6/15 20:58
 * 出差审核列表js
 */
//更改请假状态
//更改请假状态
function delete_confim(id,result){
	AMUI.dialog.confirm({
	  title: '确认删除吗？',
	  content: '确认后该记录从列表中移除',
	  onConfirm: function() {
	  		$.ajax({
				"url":"/HROA/trip/uptrip.html",
				"type":"post",
				"data":{
					"id": id,
					"result":result
				},
				error: function(){
					console.log("ajax书写出错");
				},
				success:function(result){
					if(result=="操作失败！"){
						alert_('操作失败','请重新尝试！');
					}else{
						alert_('操作成功！','');
					}
				}
			})
	  },
	  onCancel: function() {
	    history.go(0);
	  }
	});
}

//更改请假状态
function change(id,result){
	$.ajax({
		"url":"/HROA/trip/uptrip.html",
		"type":"post",
		"data":{
			"id": id,
			"result":result
		},
		success:function(result){
			if(result=="操作失败！"){
				alert_("操作失败，请重新尝试！");
			}else{
				alert_('操作成功！','');
			}
		}
	});
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

$(function(){
	$("#select").click(function(){
		var name=$("#sname").val();
		window.location.href = '?start=1&name='+name;
	})
	
	$(".am-btn-primary").click(function(){
		window.location.href = '?start=1&name=history';
	})
	
	$(".am-btn-success").click(function(){
		window.location.href = '?start=1&name=';
	})
	
	$("#trip-table").DataTable({
	  responsive: true,
	  dom: 'ti'
	});
	
	
})