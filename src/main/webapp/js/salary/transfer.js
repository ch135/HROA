$(function() {
    $('#excelFile').on('change', function() {
        var fileNames = '';
        $.each(this.files, function() {
            fileNames = "<span style='padding:0.8em 1em'>" + this.name + "</span>";
        });
        $('#fileName').html(fileNames);
    });
});

//查看详细信息
function detailInfo(id) {
	$("#detail").modal({
		relatedTarget: this
	});
	$("#detailInfo").empty();
    $.ajax({
        url: "/HROA/salary/detail.html?id=" + id,
        asny: true,
        dataType: "json",
        success: function (data) {
            if(data!=null){
                var message = "<table class='am-table'><tbody>"+
                    "<tr><td>编号：</td><td>"+data.serial+"</td></tr>"+
                    "<tr><td>财务：</td><td>"+data.adminName+"</td></tr>"+
                    "<tr><td>厂名：</td><td>"+data.company+"</td></tr>"+
                    "<tr><td>工号：</td><td>"+data.number+"</td></tr>"+
                    "<tr><td>名字：</td><td>"+data.name+"</td></tr>"+
                    "<tr><td>性别：</td><td>"+data.sex+"</td></tr>"+
                    "<tr><td>开户名：</td><td>"+data.cardName+"</td></tr>"+
                    "<tr><td>银行卡：</td><td style='width: 65%;'>"+data.bankCard+"</td></tr>"+
                    "<tr><td>开户行：</td><td>"+data.bank+"</td></tr>"+
                    "<tr><td>金额：</td><td>"+data.money+"元</td></tr>"+
                    "<tr><td>说明：</td><td style='width: 65%;'>"+data.remark+"</td></tr></tbody></table>";
                document.getElementById("detailInfo").innerHTML = message;
            }
        }
    });
}

//删除信息
function deleteInfo(id) {
	$("#deleteInfo").modal({
		relatedTarget: this,
		onConfirm: function(options) {
            $.ajax({
                url: "/HROA/salary/delete.html?id=" + id,
                asny: true,
                dataType: "json",
                success: function (data) {
                    if(data>0){
                        var currentPage = document.getElementById("currentPage").value;
                        window.location.href="/HROA/salary/index.html?page="+currentPage;
                    }
                }
            });
		},
		onCancel: function() {
		}
	});
}

//分页查看的信息,ajax返回
// function rebuild(page) {
//     $.ajax({
//         url: "/HROA/salary/info.html?page=" + page,
//         asny: true,
//         dataType: "json",
//         success: function (data) {
//             if (data.length>0) {
//                 var infoList = "";
//                 for (var i = 0; i < data.length; i++) {
//                     infoList = infoList + "<tr><td class='am-hide-sm-only'>" + data[i].company + "</td>" +
//                         "<td>" + data[i].number + "</td>" +
//                         "<td>" + data[i].name + "</td>" +
//                         "<td class='am-hide-sm-only'>" + data[i].bank + "</td>" +
//                         "<td>" + data[i].money + "</td>" +
//                         "<td><div class='am-btn-toolbar' id='edit'>" +
//                         "<div class='am-btn-group am-btn-group-xs'>" +
//                         "<button class='am-btn am-btn-default am-btn-xs am-text-success' onclick='detailInfo(" + data[i].id + ")'><span class='am-icon-circle-o'></span></button>" +
//                         "<a href='/HROA/salary/update.html?id=" + data[i].id + "'>" +
//                         "<button class='am-btn am-btn-default am-btn-xs am-text-secondary'><span class='am-icon-pencil-square-o'></span></button></a>" +
//                         "<button class='am-btn am-btn-default am-btn-xs am-text-danger' onclick='deleteInfo(" + data[i].id + ")'><span class='am-icon-trash-o'></span></button>" +
//                         "</div></div></td></tr>";
//                 }
//                 $("#infoList").empty();
//                 document.getElementById("infoList").innerHTML = infoList;
//             }
//         }
//     });
// }

//时间检索数据
function find(){
    var content = document.getElementById("content").value;
    if(content==""){
        //分页显示
        $("#page").show();
        rebuild(0);
    }else{
        //隐藏分页
        $("#page").hide();
        $.ajax({
            url: "/HROA/salary/search.html?content=" + content,
            asny: true,
            dataType: "json",
            success: function (data) {
                var infoList = "";
                if (data.length>0) {
                    for (var i = 0; i < data.length; i++) {
                        infoList = infoList + "<tr><td class='am-hide-sm-only'>" + data[i].company + "</td>" +
                            "<td>" + data[i].number + "</td>" +
                            "<td>" + data[i].name + "</td>" +
                            "<td class='am-hide-sm-only'>" + data[i].bank + "</td>" +
                            "<td>" + data[i].money + "</td>" +
                            "<td><div class='am-btn-toolbar' id='edit'>" +
                            "<div class='am-btn-group am-btn-group-xs'>" +
                            "<button class='am-btn am-btn-default am-btn-xs am-text-success' onclick='detailInfo(" + data[i].id + ")'><span class='am-icon-circle-o'></span></button>" +
                            "<a href='/HROA/salary/update.html?id=" + data[i].id + "'>" +
                            "<button class='am-btn am-btn-default am-btn-xs am-text-secondary'><span class='am-icon-pencil-square-o'></span></button></a>" +
                            "<button class='am-btn am-btn-default am-btn-xs am-text-danger' onclick='deleteInfo(" + data[i].id + ")'><span class='am-icon-trash-o'></span></button>" +
                            "</div></div></td></tr>";
                    }
                    $("#infoList").empty();
                    document.getElementById('infoList').innerHTML = infoList;
                }else{
                    infoList = "<tr><td colspan='5'>暂时没有该时间的相关数据</td></tr>";
                    $("#infoList").empty();
                    document.getElementById('infoList').innerHTML = infoList;
                }
            }
        });
    }
}

//导出数据到excel
function exportInfo(){
    var content = document.getElementById("content").value;
    if(content!=""){
        window.location.href="/HROA/salary/export.html?salaryDate=" + content;
    }else{
        window.location.href="/HROA/salary/exportAll.html"
    }
}

//导入数据模态框
function message(){
    $("#import").modal({
        relatedTarget: this
    });
}

//JS校验上传文件
function checkData(){
    var fileDir = document.getElementById("excelFile").value;
    var suffix = fileDir.substr(fileDir.lastIndexOf("."));
    var errorInfo ="";
    if("" == fileDir){
        errorInfo += "<span class='am-badge'>选择需要导入的Excel文件</span> ";
        $('#fileName').html(errorInfo);
        return false;
    }
    if(".xls" != suffix && ".xlsx" != suffix ){
        errorInfo += "<span class='am-badge'>选择Excel文件格式导入</span> ";
        $('#fileName').html(errorInfo);
        return false;
    }
    return true;
}