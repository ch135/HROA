$(function() {
    autoLeftNav();
    $(window).resize(function() {
        autoLeftNav();
        console.log($(window).width())
    });
})


// 风格切换

$('.tpl-skiner-toggle').on('click', function() {
    $('.tpl-skiner').toggleClass('active');
})

$('.tpl-skiner-content-bar').find('span').on('click', function() {
    $('body').attr('class', $(this).attr('data-color'))
    saveSelectColor.Color = $(this).attr('data-color');
    // 保存选择项
    storageSave(saveSelectColor);

})


// 侧边菜单开关
/*function autoLeftNav() {
	var id = '#my-offcanvas';
	var $myOc = $(id);
	$('.tpl-header-switch-button').on('click', function() {
	  $myOc.offCanvas('close');
	});
	
	$myOc.on('open.offcanvas.amui', function() {
	  console.log(id + ' 打开了。');
	}).on('close.offcanvas.amui', function() {
	  console.log(id + ' 关闭了。');
	    });
	}*/
function autoLeftNav() {
    $('.tpl-header-switch-button').on('click', function() {
    	$("#my-offcanvas").offCanvas('open')
        if ($('.left-sidebar').is('.active')) {
            if ($(window).width() > 1024) {
                $('.tpl-content-wrapper').removeClass('active');
            }
            $('.left-sidebar').removeClass('active');
        } else {

            $('.left-sidebar').addClass('active');
            if ($(window).width() > 1024) {
                $('.tpl-content-wrapper').addClass('active');
            }
        }
    })

    if ($(window).width() < 1024) {
        $('.left-sidebar').addClass('active');
    } else {
        $('.left-sidebar').removeClass('active');
    }
}


// 侧边菜单
$('.sidebar-nav-sub-title').on('click', function() {
    $(this).siblings('.sidebar-nav-sub').slideToggle(80).end().find('.sidebar-nav-sub-ico').toggleClass('sidebar-nav-sub-ico-rotate');
})

