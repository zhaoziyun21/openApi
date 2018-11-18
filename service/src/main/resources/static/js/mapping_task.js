

var taskFields = []
var taskTypeList = []
var taskTypeFields = {}
var scriptLanguageList = []
var httpMethodList = []

// var rabbitmqConfigs = []

//添加task
function addTask(){
    var data = {}
    taskFields.forEach(function (item) {
        data[item['fieldName']] = ''
    })

    data['jobID'] = jobID;
    data['sortIndex'] = 99;

    var $form = buildTaskItem(data)

    renderTaskFormItem($(".task-form-container"), $form)
}

//保存task
function saveTask($taskBtn){
    var $taskForm = $taskBtn.prevAll(".task-item-form:first")
    var $configForm = $taskForm.children(".sub-form")

    var configData = {}
    $configForm.find("[sub-name]").each(function (i, item) {
        configData[$(item).attr('sub-name')] = $(item).val()
    })

    var taskData = {}
    $taskForm.children(".layui-form-item").find("[sub-name]").each(function (i, item) {
        taskData[$(item).attr('sub-name')] = $(item).val()
    })

    taskData['configs'] = JSON.stringify(configData)

    ajaxPost("/mock_server/mapping/task/save.ajax", taskData, function (response) {
        layer.msg(response.message ? response.message : "保存成功！")
        if (taskData.taskID == 0){
            $taskForm.find("[sub-name=taskID]").val(response.data)
        }
    })
}

//
function renderTaskFormItem($formContainer, $form){

    buildFormItem($formContainer, $form, "task-btn-remove")

    $add = $("<button class=\"layui-btn layui-btn-xs layui-btn-radius task-btn-save\">保存</button>")

    $formContainer.children(":last").before($add)

    form.render('select');
}

function buildConfigsItem(taskType, dataStr) {

    var $container = $("<div class='sub-form'></div>")

    try {
        var data = JSON.parse(dataStr)

        for ( var fieldName in data) {

            var fieldValue = data[fieldName]

            $formItem = $(" <div class=\"layui-form-item\"></div>")
            $formItem.append($("<label class=\"layui-form-label\">/label>").text(fieldName))

            $block = $("<div class=\"layui-input-block\"></div>")

            if('scriptLanguage' == fieldName) {
                var $field = genSubSelectField(scriptLanguageList, fieldName, fieldValue);

            }else if('systemConfigID' == fieldName){

                var $field = genSubSelectField(taskTypeAndConfigList[taskType], fieldName, fieldValue);

            }else if(['msgData', 'scriptContent', 'body'].indexOf(fieldName) > -1){
                var $field = genSubTextareaField(fieldName, fieldValue);

            }else{
                var $field = genSubInputField( fieldName, fieldValue)
            }
            $field.addClass("task-config-item")


            $block.append($field)
            $formItem.append($block)
            $container.append($formItem)
        }

    }catch (e){
        console.log(e)
    }

    return $container;
}

function buildTaskItem(data){

    var $form = $("<form class=\"task-item-form layui-form\" editing=\"false\" ></form>")
    for ( var fieldName in data) {

        if('updateTime' == fieldName){
            continue;
        }

        var fieldValue = data[fieldName]

        $formItem = $(" <div class=\"layui-form-item\"></div>")
        $formItem.append($("<label class=\"layui-form-label\">/label>").text(fieldName))

        $block = $("<div class=\"layui-input-block\"></div>")

        if ('isActive' == fieldName) {
            var $field = genSubIsActiveField(fieldValue)

        }else if( 'taskType' == fieldName){
            var $field = genSubSelectField(taskTypeList, fieldName, fieldValue);

        }else if('method' == fieldName){
            var $field = genSubSelectField(httpMethodList, fieldName, fieldValue);

        }else{
            var $field = genSubInputField( fieldName, fieldValue)
        }

        if ('taskType' == fieldName){
            $field.attr('lay-filter', 'task-form-task-type')
        }

        $block.append($field)
        $formItem.append($block)
        $form.append($formItem)

        if ([ 'taskID', 'jobID', 'configs' ].indexOf(fieldName) > -1){
            $formItem.addClass("layui-hide")
        }

    }

    var $container = buildConfigsItem(data.taskType, data.configs)
    return $form.append($container)

}


//查询task字段
function queryTaskFields() {
    ajaxPost("/mock_server/mapping/task/db/field.ajax", {}, function (response) {
        taskFields = response.data.list
    })

}


//查询计划列表
function queryTasks($formContainer, jobID) {
    ajaxPost("/mock_server/mapping/task/list.ajax", {jobID: jobID}, function (response) {
        $formContainer.children().remove()

        for ( var i in response.data.list){
            var tasks = response.data.list[i]
            var $form = buildTaskItem(tasks)

            renderTaskFormItem($formContainer, $form)
        }

        // $("body").append($formContainer)
        //
        // setTimeout(function () {
        //
        //     // var content = $("body").children(":last").get(0).outerHTML
        //     var content = $(".task-form-container").get(0).outerHTML
        //     // $("body").children(":last").remove()
        //     console.log(content)
        //
        //
        //     layer.open({
        //         type : 1
        //         // ,title : '任务列表'
        //         ,title : '<button class="layui-btn layui-btn-xs layui-btn-radius task-btn-add">添加任务</button>'
        //         ,content : content
        //         ,area : ['100%', '100%']
        //     })
        // }, 1)
    })
}

//taskType  && typeFields
function queryTaskTypeList() {
    ajaxPost("/mock_server/enum/task/type/list.ajax", {}, function (response) {
        taskTypeList = response.data.list;

        taskTypeList.forEach(function (taskTypeItem) {
            var taskType = taskTypeItem.value;

            ajaxPost("/mock_server/enum/task/type/field.ajax", { type: taskType}, function (response) {
                taskTypeFields[taskType] = response.data.list
            })
        })
    })
}


function removeTask($btn) {
    msg = "确定要删除?"
    window.layer.confirm(msg, function(index){

        ~(function (remove) {

            if ( $btn.prevAll(".task-item-form:first").find("[sub-name=taskID]").length > 0  && $btn.prevAll(".task-item-form:first").find("[sub-name=taskID]").val() > 0){

                var taskID = $btn.prevAll(".task-item-form:first").find("[sub-name=taskID]").val();
                ajaxPost("/mock_server/mapping/task/delete.ajax", { taskID: taskID}, function (response) {
                    remove()
                })
            }else{
                remove()
            }

        })(function () {
            $btn.prev(".task-item-form:first").remove()
            $btn.next(".layui-bg-blue:first").remove()
            $btn.remove();
        })

        window.layer.close(index);
    })
}


$(function () {
    // 在layer弹出层使用该页面时，注释掉layui初始化内容，因为原页面已经存在了
    // layui.use(['layer', 'form'], function(){
    //     window.layer = layui.layer
    //     window.form = layui.form;


        //添加任务计划
        $(document).on("click", ".task-btn-add", function () {
            // var self = this;

            addTask()
        })


        //添加任务计划
        $(document).on("click", ".task-btn-save", function () {
            // var self = this;

            saveTask($(this))
        })


        //删除任务计划
        $(document).on("click", ".task-btn-remove", function () {
            // var self = this;
            removeTask($(this))
        })


        //获取支持的脚本语言类型
        ajaxPost("/mock_server/enum/language/list.ajax", {}, function (response) {
            scriptLanguageList = response.data.list
        })


        //获取http method类型
        ajaxPost("/mock_server/enum/http/method/list.ajax", {}, function (response) {
            httpMethodList = response.data.list
        })

        //初始化task表字段
        queryTaskFields()

        //初始化task支持的所有类型
        queryTaskTypeList()


        form.on('select(task-form-task-type)', function(data){
            var taskType = data.value;

            var currentTypeFields = taskTypeFields[taskType]
            var configs = {}
            currentTypeFields.forEach(function (item) {
                configs[item.fieldName] = ''
            })

            var $taskType = $(data.elem)

            $taskType.parents(".task-item-form:first").children(".sub-form:last").remove()

            var $container = buildConfigsItem(taskType, JSON.stringify(configs))

            $taskType.parents(".task-item-form:first").append($container)

            form.render("select")

        });
    //
    // });

})