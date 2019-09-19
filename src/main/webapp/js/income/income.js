//表单验证
$(function() {
    $('#incomeBaseInfo').validator({
        onValid: function(validity) {
            $(validity.field).closest('.am-form-group').find('.am-alert').hide();
        },

        onInValid: function(validity) {
            var $field = $(validity.field);
            var $group = $field.closest('.am-form-group');
            var $alert = $group.find('.am-alert');
            // 使用自定义的提示信息 或 插件内置的提示信息
            var msg = $field.data('validationMessage') || this.getValidationMessage(validity);
            $alert.html(msg).show();
        }
    });
});

//查看详细信息
function detailInfo(id) {
	$("#detail").modal({
		relatedTarget: this
	});
	$("#detailInfo").empty();
    $.ajax({
        url: "/HROA/income/detail.html?id=" + id,
        asny: true,
        dataType: "json",
        success: function (data) {
            if(data!=null){
                var message = "<table class='am-table'><tbody>"+
                    "<tr><td>编号：</td><td>"+data.serial+"</td></tr>"+
                    "<tr><td>财务：</td><td>"+data.adminName+"</td></tr>"+
                    "<tr><td>部门：</td><td>"+data.department+"</td></tr>"+
                    "<tr><td>联系人：</td><td>"+data.linkMan+"</td></tr>"+
                    "<tr><td>来源：</td><td>"+data.origin+"</td></tr>"+
                    "<tr><td>金额：</td><td>"+data.money+"元</td></tr>"+
                    "<tr><td>收入时间：</td><td>"+data.sIncomeDate+"</td></tr>"+
                    "<tr><td>说明：</td><td style='width: 65%;'>"+data.state+"</td></tr></tbody></table>";
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
                url: "/HROA/income/delete.html?id=" + id,
                asny: true,
                dataType: "json",
                success: function (data) {
                    if(data>0){
                        var currentPage = document.getElementById("currentPage").value;
                        window.location.href="/HROA/income/index.html?page="+currentPage;
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
    //记录当前页
    // document.getElementById("currentPage").value = page;
    // $.ajax({
    //     url: "/HROA/income/info.html?page=" + page,
    //     asny: true,
    //     dataType: "json",
    //     success: function (data) {
    //         if (data.length>0) {
    //             var infoList = "";
    //             for (var i = 0; i < data.length; i++) {
    //                 infoList = infoList + "<tr><td class='am-hide-sm-only'>" + data[i].department + "</td>" +
    //                     "<td>" + data[i].linkMan + "</td>" +
    //                     "<td>" + data[i].money + "</td>" +
    //                     "<td class='am-hide-sm-only'>" + data[i].sIncomeDate + "</td>" +
    //                     "<td><div class='am-btn-toolbar' id='edit'>" +
    //                     "<div class='am-btn-group am-btn-group-xs'>" +
    //                     "<button class='am-btn am-btn-default am-btn-xs am-text-success' onclick='detailInfo(" + data[i].id + ")'><span class='am-icon-circle-o'></span></button>" +
    //                     "<a href='/HROA/income/update.html?id=" + data[i].id + "'>" +
    //                     "<button class='am-btn am-btn-default am-btn-xs am-text-secondary'><span class='am-icon-pencil-square-o'></span></button></a>" +
    //                     "<button class='am-btn am-btn-default am-btn-xs am-text-danger' onclick='deleteInfo(" + data[i].id + ")'><span class='am-icon-trash-o'></span></button>" +
    //                     "</div></div></td></tr>";
    //             }
    //             $("#infoList").empty();
    //             document.getElementById("infoList").innerHTML = infoList;
    //         }
    //     }
    // });
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
            url: "/HROA/income/search.html?content=" + content,
            asny: true,
            dataType: "json",
            success: function (data) {
                var infoList = "";
                if (data.length>0) {
                    for (var i = 0; i < data.length; i++) {
                        infoList = infoList + "<tr><td class='am-hide-sm-only'>" + data[i].department + "</td>" +
                            "<td>" + data[i].linkMan + "</td>" +
                            "<td>" + data[i].money + "</td>" +
                            "<td class='am-hide-sm-only'>" + data[i].sIncomeDate + "</td>" +
                            "<td><div class='am-btn-toolbar' id='edit'>" +
                            "<div class='am-btn-group am-btn-group-xs'>" +
                            "<button class='am-btn am-btn-default am-btn-xs am-text-success' onclick='detailInfo(" + data[i].id + ")'><span class='am-icon-circle-o'></span></button>" +
                            "<a href='/HROA/income/update.html?id=" + data[i].id + "'>" +
                            "<button class='am-btn am-btn-default am-btn-xs am-text-secondary'><span class='am-icon-pencil-square-o'></span></button></a>" +
                            "<button class='am-btn am-btn-default am-btn-xs am-text-danger' onclick='deleteInfo(" + data[i].id + ")'><span class='am-icon-trash-o'></span></button>" +
                            "</div></div></td></tr>";
                    }
                    $("#infoList").empty();
                    document.getElementById('infoList').innerHTML = infoList;
                }else{
                    infoList = "<tr><td colspan='5'>暂时没有时间相关数据</td></tr>";
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
        window.location.href="/HROA/income/export.html?content=" + content;
    }else{
        window.location.href="/HROA/income/exportAll.html"
    }
}