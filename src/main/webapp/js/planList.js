charset="UTF-8"
$(function(){
    getPlanList(0);

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
        $.ajax('../user/savePlan',{
            data:{
                id      : $("input[name=id]").val(),
                content : $("#planContent").val(),
                cycleNum : $("#cycleNum").val()
            },
            dataType:'json',//服务器返回json格式数据
            type:'post',//HTTP请求类型
            timeout:10000,//超时时间设置为10秒；
            success:function(data){
                //服务器返回响应
                if (data.code == 0){
                    var editDiv = document.getElementById("editDiv");
                    editDiv.style.display = "none";0
                    getPlanList(0);
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
function getPlanList(state){
    $.ajax('../user/getPlanList',{
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
                addPlanDiv(data.data.list);
            } else {
                $("#content").empty();
                // 添加空提示
                $("#content").append("<h4 style='color: #777777; text-align: center; padding-top: 20px;'>暂无计划任务!</h4>");
            }
        },
        error:function(xhr,type,errorThrown){
            //异常处理；
            console.log(type);
        }
    });
}

// 添加任务项
function addPlanDiv(data){

    var contentDiv = $("#content").empty();

    $(data).each(function(index){

        var time = new Date(data[index].time);
        var timeStr = time.Format("hh:mm");

        var item =  "<div class='item'>" +
                        "<div class='text' style='width: 42%'>" + data[index].content + "</div>" +
                        "<div class='time'>"+ timeStr +"</div>" +
                        "<div class='cycleNum' style='float: left;width:8%; padding-top: 5px;'>("+ data[index].cycleNum +")</div>" +
                        "<div id="+ data[index].id +" class='btn'>" +
                            "<div class='editBtn' onclick='editPlan( "+ data[index].id + ", \"" + data[index].content + "\"," + data[index].cycleNum + ")'>编辑</div>" +
                            "<div class='deleteBtn'>删除</div>" +
                        "</div>" +
                    "</div>"
        contentDiv.append(item);
    });
    // 完成点击
    //$(".editBtn").click(function(){
    //    var parent = $(this).parent();
    //    var id = parent[0].getAttribute("id") ;
    //    // 请求数据
    //    $.ajax('/completeItem',{
    //        data:{
    //            itemId: id
    //        },
    //        dataType:'json',//服务器返回json格式数据
    //        type:'post',//HTTP请求类型
    //        timeout:10000,//超时时间设置为10秒；
    //        success:function(data){
    //            //服务器返回响应
    //            if (data.code == 0){
    //                getNoteList(0);
    //            }
    //        },
    //        error:function(xhr,type,errorThrown){
    //            //异常处理；
    //            console.log(type);
    //        }
    //    });
    //});
    //放弃点击
    $(".deleteBtn").click(function(){
        var parent = $(this).parent();
        var id = parent[0].getAttribute("id") ;
        // 请求数据
        $.ajax('../user/deletePlan',{
            data:{
                planId: id
            },
            dataType:'json',//服务器返回json格式数据
            type:'post',//HTTP请求类型
            timeout:10000,//超时时间设置为10秒；
            success:function(data){
                //服务器返回响应
                if (data.code == 0){
                    getPlanList(0);
                }
            },
            error:function(xhr,type,errorThrown){
                //异常处理；
                console.log(type);
            }
        });
    });
}

/**
 * 添加或修改计划
 * @param data
 */
function editPlan(id, content, cycleNum){
    var editDiv = document.getElementById("editDiv");
    editDiv.style.display = "block";
    $("#planContent").val("");
    $("#cycleNum").val("");
    $("input[name=id]").val("");
    if(id){
        $("#planContent").val(content);
        $("#cycleNum").val(cycleNum);
        $("input[name=id]").val(id);

    }
}
