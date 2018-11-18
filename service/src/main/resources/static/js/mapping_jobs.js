
var jobFields = []



function addJob(){
    var data = {}
    jobFields.forEach(function (item) {
        data[item['fieldName']] = ''
    })

    data['requestID'] = requestID;
    data['protocol'] = protocol;
    data['sortIndex'] = 99;

    var $form = buildJobItem(data)
    renderJobFormItem($form)
}

function renderJobFormItem($form){
    var $formContainer = $(".mapping-jobs .layui-colla-content-item");

    buildFormItem($formContainer, $form, "job-btn-remove")

    $btn = $("<button class=\"layui-btn layui-btn-xs layui-btn-radius task-btn-list\">任务列表</button>")
    $task = $("<button class=\"layui-btn layui-btn-xs layui-btn-radius task-btn-add\">添加任务</button>")
    // $subForm = $("<div class='task-form-container' style='display: none; padding-left:55px'></div>");

    // $formContainer.children(":eq(-2)").before($subForm)
    $formContainer.children(":last").before($btn)
        // .before($task)
    form.render('select');
}

function buildJobItem(data){

    var $form = $("<form class=\"layui-form job-form\" editing=\"false\" jobID=\""+ data.jobID +"\"></form>")
    for ( var fieldName in data) {

        if('updateTime' == fieldName){
            continue;
        }

        var fieldValue = data[fieldName]


        $formItem = $(" <div class=\"layui-form-item\"></div>")
        $formItem.append($("<label class=\"layui-form-label\">/label>").text(fieldName))

        $block = $("<div class=\"layui-input-block\"></div>")

        if ('isActive' == fieldName){
            var $field = genIsActiveField(fieldValue)
        }else{
            var $field = genInputField( fieldName, fieldValue)
        }

        $block.append($field)
        $formItem.append($block)
        $form.append($formItem)

        if ([ 'protocol', 'requestID', 'jobID' ].indexOf(fieldName) > -1){
            $formItem.addClass("layui-hide")
        }
    }

    return $form

}


//获取job任务的字段
function queryJobFields() {
    ajaxPost("/mock_server/mapping/job/db/field.ajax", {}, function (response) {
        jobFields = response.data.list
    })

}


//查询计划列表
function queryJobs() {
    ajaxPost("/mock_server/mapping/job/list.ajax", {requestID: requestID, protocol:protocol}, function (response) {
        $(".mapping-jobs .layui-colla-content-item").children().remove()

        for ( var i in response.data.list){
            var jobs = response.data.list[i]
            var $form = buildJobItem(jobs)

            renderJobFormItem($form)
        }
    })
}



function removeJobs($btn) {
    msg = "确定要删除?"
    window.layer.confirm(msg, function(index){
        var jobID = $btn.prevAll(".job-form:first").find("[name=jobID]").val();

        
        ~(function (remove) {
            if ( jobID > 0 ){
                ajaxPost("/mock_server/mapping/job/delete.ajax", { jobID: jobID}, function (response) {
                    remove()
                })
            }else{
                remove()
            }
        })(function(){
            $btn.prevAll(".job-form:first").remove()
            $btn.nextAll().remove(".task-btn-list:first")
            $btn.remove();
        })


        window.layer.close(index);
    })
}

var saveJobSuccess = true;

function saveJob() {

    $(".mapping-jobs .layui-colla-content-item .layui-form[editing=true]").each(function (i, item) {

        var data = $(item).serializeObject();
        if ( !!requestID ){
            data['requestID'] = requestID;
        }
        if ( !!protocol ){
            data['protocol'] = protocol;
        }

        ajaxPost("/mock_server/mapping/job/save.ajax", data, function (response) {

            $(item).attr('editing', 'false')
            if(!data.jobID){
                $(item).find("[name=jobID]").val(response.data)
            }
        },function () {
            saveJobSuccess = false;
        })
    })

}





$(function () {

    //注意：折叠面板 依赖 element 模块，否则无法进行功能性操作
    // layui.use('element', function(){
    //     var element = layui.element;
    //
    //     //折叠面板
    //     element.on('collapse(collapse)', function(data){
    //         if(data.show) {
    //             queryJobs()
    //         }
    //     });
    //
    // })


    //添加任务计划
    $(document).on("click", ".job-btn-add", function () {
        // var self = this;
        addJob()
    })



    //保存任务
    $(document).on("click", ".job-btn-save", function () {
        // var self = this;
        saveJob()
    })


    //删除任务
    $(document).on("click", ".job-btn-remove", function () {
        // var self = this;
        removeJobs($(this))
    })


    //管理任务列表
    $(document).on("click", ".task-btn-list", function () {

        var jobID = $(this).prevAll(".job-form:first").find("[name=jobID]").val();

        if(jobID > 0 ){

            $.get("/mock_server/mapping/task/list.html", {jobID:jobID}, function (resp) {

                layer.open({
                    type : 1
                    // ,title : '任务列表'
                    ,title : '任务列表'
                    ,content : resp
                    ,area : ['100%', '100%']
                })


                var $taskContainer = $(".task-form-container")
                if(jobID > 0 ){
                    queryTasks($taskContainer, jobID)
                }

            }, 'html')


        }else{
            layer.msg("请先保存回调计划！")
        }

    })




    //初始化配置字段
    queryJobFields()

})