/**
 * @author chenhao
 * @time 2017/6/29 11:49
 */
applyNum=function(){
	$.ajax({
		'type':'post',
		'url':'/HROA/num/getnum.html',
		success:function(date){
			var num=JSON.parse(date);
			var numlist=$('.am-badge-secondary');
			for(var i=0;i<numlist.length;i++){
				numlist[i].innerHTML='';
			}
			if(num.leavenum!=0){
				numlist[0].innerHTML=num.leavenum;
			}
			if(num.tripnum!=0){
				numlist[1].innerHTML=num.tripnum;
			}
			if(num.moneynum!=0){
				numlist[2].innerHTML=num.moneynum;
			}
			if(num.borrownum!=0){
				numlist[3].innerHTML=num.borrownum;
			}
		},
		error:function(XMLHttpRequest,textStatus,errorThrown){
			console.log(XMLHttpRequest.status);
			console.log(textStatus.readyState);
			console.log("出错信息："+errorThrown);
		}
	})
}