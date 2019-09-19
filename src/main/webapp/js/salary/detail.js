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
        url: "/HROA/detail/detail.html?id=" + id,
        asny: true,
        dataType: "json",
        success: function (data) {
            if(data!=null){
                var message = "<table class='am-table'><tbody>"+
                    "<tr><td>编号：</td><td>"+data.serial+"</td></tr>"+
                    "<tr><td>财务：</td><td>"+data.adminName+"</td></tr>"+
                    "<tr><td>厂名：</td><td style='width: 65%;'>"+data.company+"</td></tr>"+
                    "<tr><td>工号：</td><td>"+data.number+"</td></tr>"+
                    "<tr><td>名字：</td><td>"+data.name+"</td></tr>"+
                    "<tr><td>总共时：</td><td>"+data.worktime+"</td></tr>" +
                    "<tr><td>工价：</td><td>"+data.price+"</td></tr>"+
                    "<tr><td>应得工资：</td><td>"+data.deserved+"</td></tr>"+
                    "<tr><td>伙食补：</td><td>"+data.meals+"</td></tr>" +
                    "<tr><td>夜餐补：</td><td>"+data.dinner+"</td></tr>"+
                    "<tr><td>其他补贴：</td><td>"+data.otherprofit+"</td></tr>"+
                    "<tr><td>总工资：</td><td>"+data.salary+"</td></tr>"+
                    "<tr><td>所得税：</td><td>"+data.tax+"</td></tr>" +
                    "<tr><td>罚款：</td><td>"+data.fine+"</td></tr>"+
                    "<tr><td>签卡：</td><td>"+data.sign+"</td></tr>" +
                    "<tr><td>水电：</td><td>"+data.sdcost+"</td></tr>"+
                    "<tr><td>迟到早退：</td><td>"+data.nontime+"</td></tr>" +
                    "<tr><td>其他扣款：</td><td>"+data.otherfine+"</td></tr>"+
                    "<tr><td>爱心资金：</td><td>"+data.beneficent+"</td></tr>" +
                    "<tr><td>自离扣款：</td><td>"+data.ownleave+"</td></tr>"+
                    "<tr><td>保险：</td><td>"+data.insurance+"</td></tr>" +
                    "<tr><td>借支：</td><td>"+data.borrow+"</td></tr>"+
                    "<tr><td>伙食扣：</td><td>"+data.boardcost+"</td></tr>" +
                    "<tr><td>总扣款：</td><td>"+data.allcost+"</td></tr>"+
                    "<tr><td>实发工资：</td><td>"+data.realwages+"</td></tr>"+
                    "<tr><td>时间：</td><td>"+data.salaryDate+"</td></tr></tbody></table>";
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
                url: "/HROA/detail/delete.html?id=" + id,
                asny: true,
                dataType: "json",
                success: function (data) {
                    if(data>0){
                        var currentPage = document.getElementById("currentPage").value;
                        window.location.href="/HROA/detail/index.html?page="+currentPage;
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
//         url: "/HROA/detail/info.html?page=" + page,
//         asny: true,
//         dataType: "json",
//         success: function (data) {
//             if (data.length>0) {
//                 var infoList = "";
//                 for (var i = 0; i < data.length; i++) {
//                     infoList = infoList + "<tr><td class='am-hide-sm-only'>" + data[i].company + "</td>" +
//                         "<td>" + data[i].number + "</td>" +
//                         "<td>" + data[i].name + "</td>" +
//                         "<td class='am-hide-sm-only'>" + data[i].deserved + "</td>" +
//                         "<td class='am-hide-sm-only'>" + data[i].salary + "</td>" +
//                         "<td class='am-hide-sm-only'>" + data[i].allcost + "</td>" +
//                         "<td class='am-hide-sm-only'>" + data[i].salaryDate + "</td>" +
//                         "<td>" + data[i].realwages + "</td>" +
//                         "<td><div class='am-btn-toolbar' id='edit'>" +
//                         "<div class='am-btn-group am-btn-group-xs'>" +
//                         "<button class='am-btn am-btn-default am-btn-xs am-text-success' onclick='detailInfo(" + data[i].id + ")'><span class='am-icon-circle-o'></span></button>" +
//                         "<a href='/HROA/detail/update.html?id=" + data[i].id + "'>" +
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

//根据工号检索数据
function find(){
    var number = document.getElementById("content").value;
    if(number==""){
        //分页显示
        $("#page").show();
        rebuild(0);
    }else{
        //隐藏分页
        $("#page").hide();
        $.ajax({
            url: "/HROA/detail/search.html?number=" + number,
            asny: true,
            dataType: "json",
            success: function (data) {
                var infoList = "";
                if (data.length>0) {
                    for (var i = 0; i < data.length; i++) {
                        infoList = infoList + "<tr><td class='am-hide-sm-only'>" + data[i].company + "</td>" +
                            "<td>" + data[i].number + "</td>" +
                            "<td>" + data[i].name + "</td>" +
                            "<td class='am-hide-sm-only'>" + data[i].deserved + "</td>" +
                            "<td class='am-hide-sm-only'>" + data[i].salary + "</td>" +
                            "<td class='am-hide-sm-only'>" + data[i].allcost + "</td>" +
                            "<td class='am-hide-sm-only'>" + data[i].salaryDate + "</td>" +
                            "<td>" + data[i].realwages + "</td>" +
                            "<td><div class='am-btn-toolbar' id='edit'>" +
                            "<div class='am-btn-group am-btn-group-xs'>" +
                            "<button class='am-btn am-btn-default am-btn-xs am-text-success' onclick='detailInfo(" + data[i].id + ")'><span class='am-icon-circle-o'></span></button>" +
                            "<a href='/HROA/detail/update.html?id=" + data[i].id + "'>" +
                            "<button class='am-btn am-btn-default am-btn-xs am-text-secondary'><span class='am-icon-pencil-square-o'></span></button></a>" +
                            "<button class='am-btn am-btn-default am-btn-xs am-text-danger' onclick='deleteInfo(" + data[i].id + ")'><span class='am-icon-trash-o'></span></button>" +
                            "</div></div></td></tr>";
                    }
                    $("#infoList").empty();
                    document.getElementById('infoList').innerHTML = infoList;
                }else{
                    infoList = "<tr><td colspan='9'>暂时没有时间相关数据</td></tr>";
                    $("#infoList").empty();
                    document.getElementById('infoList').innerHTML = infoList;
                }
            }
        });
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