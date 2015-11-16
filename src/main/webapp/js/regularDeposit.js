charset="UTF-8"
$(function(){
    getRegularDepositList();

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
        $.ajax('../saveRegularDeposit',{
            data:{
                id          : $("input[name=id]").val(),
                content     : $("#regularDepositContent").val(),
                number      : $("#number").val(),
                cycleNum    : $("#cycleNum").val()
            },
            dataType:'json',//服务器返回json格式数据
            type:'post',//HTTP请求类型
            timeout:10000,//超时时间设置为10秒；
            success:function(data){
                //服务器返回响应
                if (data.code == 0){
                    var editDiv = document.getElementById("editDiv");
                    editDiv.style.display = "none";
                    getRegularDepositList();
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
function getRegularDepositList(){
    $.ajax('../getRegularDepositList',{
        data:{
        },
        dataType:'json',//服务器返回json格式数据
        type:'post',//HTTP请求类型
        timeout:10000,//超时时间设置为10秒；
        success:function(data){
            //服务器返回响应
            if (data.code == 0){
                //alert("有数据");
                addRegularDepositDiv(data.data.list);
            } else {
                $("#content").empty();
                // 添加空提示
                $("#content").append("<h4 style='color: #777777; text-align: center; padding-top: 20px;'>暂无定存记录!</h4>");
            }
        },
        error:function(xhr,type,errorThrown){
            //异常处理；
            console.log(type);
        }
    });
}

// 添加任务项
function addRegularDepositDiv(data){

    var contentDiv = $("#content").empty();

    $(data).each(function(index){

        var time = new Date(data[index].time);
        var timeStr = time.Format("hh:mm");

        var item =  "<div class='item'>" +
            "<div class='text'>" + data[index].content + "</div>" +
            "<div class='time'>"+ data[index].number +" </div>" +
            "<div id="+ data[index].id +" class='btn'>" +
            "<div class='editBtn' onclick='editRegularDeposit( "+ data[index].id + ", \"" + data[index].content + "\"," + data[index].number + "," + data[index].cycleNum + ")'>编辑</div>" +
            "<div class='deleteBtn'>删除</div>" +
            "</div>" +
            "</div>"
        contentDiv.append(item);
    });
    //放弃点击
    $(".deleteBtn").click(function(){
        var parent = $(this).parent();
        var id = parent[0].getAttribute("id") ;
        // 请求数据
        $.ajax('../deleteRegularDeposit',{
            data:{
                id: id
            },
            dataType:'json',//服务器返回json格式数据
            type:'post',//HTTP请求类型
            timeout:10000,//超时时间设置为10秒；
            success:function(data){
                //服务器返回响应
                if (data.code == 0){
                    getRegularDepositList();
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
function editRegularDeposit(id, content, number, cycleNum){
    var editDiv = document.getElementById("editDiv");
    editDiv.style.display = "block";
    $("#regularDepositContent").val("");
    $("input[name=id]").val("");
    $("#number").val("");
    $("#cycleNum").val("");
    if(id){
        $("#regularDepositContent").val(content);
        $("input[name=id]").val(id);
        $("#number").val(number);
        $("#cycleNum").val(cycleNum);
    }
}
