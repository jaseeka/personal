charset="UTF-8"
$(function(){
    getItemList(0);
    bindEvent();
});

/**
 * 绑定事件
 */
function bindEvent(){
    $("#editCancel").click(function () {
        var editDiv = document.getElementById("editDiv");
        editDiv.style.display = "none";
    });

    $("#editSubmit").click(function () {
        $.ajax('../addItem',{
            data:{
                content : $("#itemContent").val(),
                time    : $("input[name=time]").val()
            },
            dataType:'json',//服务器返回json格式数据
            type:'post',//HTTP请求类型
            timeout:10000,//超时时间设置为10秒；
            success:function(data){
                //服务器返回响应
                if (data.code == 0){
                    var editDiv = document.getElementById("editDiv");
                    editDiv.style.display = "none";
                    getItemList(0);
                }
            },
            error:function(xhr,type,errorThrown){
                //异常处理；
                console.log(type);
            }
        });
    });
}

// 获取数据
function getItemList(state){
    $.ajax('../getItemList',{
        data:{
            state:state
        },
        dataType:'json',//服务器返回json格式数据
        type:'post',//HTTP请求类型
        timeout:10000,//超时时间设置为10秒；
        success:function(data){
            //服务器返回响应
            if (data.code == 0){
                //alert("有数据");
                addItemDiv(data.data.list);
            } else {
                $("#content").empty();
                // 添加空提示
                $("#content").append("<h4 style='color: #777777; text-align: center; padding-top: 20px;'>任务已经全部完成!</h4>");
            }
        },
        error:function(xhr,type,errorThrown){
            //异常处理；
            console.log(type);
        }
    });
}

// 添加任务项
function addItemDiv(data){

    var contentDiv = $("#content").empty();

    $(data).each(function(index){

        var time = new Date(data[index].time);
        var timeStr = time.Format("MM-dd");

        var item =  "<div class='item'>" +
                        "<div class='text'>" + data[index].content + "</div>" +
                        "<div class='time'>"+ timeStr +"</div>" +
                        "<div id="+ data[index].id +" class='btn'>" +
                            "<div class='doneBtn'>完成</div>" +
                            "<div class='abandonBtn'>放弃</div>" +
                        "</div>" +
                    "</div>"
        contentDiv.append(item);
    });
    // 完成点击
    $(".doneBtn").click(function(){
        var parent = $(this).parent();
        var id = parent[0].getAttribute("id") ;
        // 请求数据
        $.ajax('../completeItem',{
            data:{
                itemId: id
            },
            dataType:'json',//服务器返回json格式数据
            type:'post',//HTTP请求类型
            timeout:10000,//超时时间设置为10秒；
            success:function(data){
                //服务器返回响应
                if (data.code == 0){
                    getItemList(0);
                }
            },
            error:function(xhr,type,errorThrown){
                //异常处理；
                console.log(type);
            }
        });
    });
    //放弃点击
    $(".abandonBtn").click(function(){
        //$("body").append("<div class='maskDiv' style='width: 100%;height: 96%;background-color:rgba(95, 95, 95, 0.47);'>" +
        //        "<div class='alertDiv' style='background-color: white;width: 70%;height: 20%;left: 15%;top: 20%;border-radius: 15px;border:solid 1px #929292;'>" +
        //            "<div class='alertMsg' style='text-align: center;width: 100%;height: 50%;margin-top: 5%;'>确定删除？</div>" +
        //            "<div class='alertBtn'>" +
        //                "<intut type='button' class='alertDoneBtn' valu='确定' />" +
        //                "<input type='button' class='alertCancelBtn'value='取消' />" +
        //            "</div>" +
        //        "</div>" +
        //    "</div>")
        var parent = $(this).parent();
        var id = parent[0].getAttribute("id") ;
        // 请求数据
        $.ajax('../abandonItem',{
            data:{
                itemId: id
            },
            dataType:'json',//服务器返回json格式数据
            type:'post',//HTTP请求类型
            timeout:10000,//超时时间设置为10秒；
            success:function(data){
                //服务器返回响应
                if (data.code == 0){
                    getItemList(0);
                }
            },
            error:function(xhr,type,errorThrown){
                //异常处理；
                console.log(type);
            }
        });
    });
}

function addItem(){
    var editDiv = document.getElementById("editDiv");
    editDiv.style.display = "block";
}
