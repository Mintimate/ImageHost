function do_flash(){
    location.reload(true);
}

function do_download() {
    alert("开始下载了嗷(´▽｀)");
}


function delete_all_check() {
    var gnl = confirm("确认删除么?这可是批量删除嗷");
    if (gnl == true) {
        return true;
    } else {
        return false;
    }
}
function delete_check() {
    var gnl = confirm("确认删除么?不过还好，这个不是批量删除～");
    if (gnl == true) {
        return true;
    } else {
        return false;
    }
}
function egg() {
    alert("即将进入彩蛋环节\n方向键控制小飞机,空格发射,ESC返回")
}

function do_null() {
    alert("暂时没有嗷")

}
function do_view() {
    alert("该链接为记录浏览记录的链接嗷")
}

//分页模块内
$(function(){
    $("#next").click(function(){
        var pages = parseInt($("#pages").html());
        var page = parseInt($("#currentPage").html());
        var ImgType=$("#next").attr("ImageType");
        if(page == pages){
            return;
        }
        page++;
        location.href = "/image?type="+ImgType+"&page="+page;
    })

    // 回到首页
    $("#previous").click(function () {
        var page = parseInt($("#currentPage").html());
        var ImgType=$("#next").attr("ImageType");
        if(page == 1){
            return;
        }
        page--;
        location.href = "/image?type="+ImgType+"&page="+page;
    })

    $("#first").click(function () {
        var ImgType=$("#next").attr("ImageType");
        location.href = "/image?type="+ImgType+"&page=1";
    })

    $("#last").click(function(){
        var pages = parseInt($("#pages").html());
        var ImgType=$("#next").attr("ImageType");
        location.href = "/image?type="+ImgType+"&page="+pages;
    })
})