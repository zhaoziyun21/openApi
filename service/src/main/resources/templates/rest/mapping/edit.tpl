<#include "../../common/header.tpl">
 <div class="layui-body">
    <!-- 内容主体区域 -->
    <script src="/js/jquery.form.js"></script>
	<form class="layui-form" action="//mock_server/rest/mapping/save" method="post" id="item-form"  style="padding: 15px;">
	  <input type="hidden" name="requestID" value="0">

	  <#list fields as field >
		<#if 'groupID' == field.fieldName>
			<div class="layui-form-item layui-hide">
				<label class="layui-form-label">${field.fieldName}</label>
				<div class="layui-input-block">
					<input type="text" name="${field.fieldName}" required  lay-verify="required" placeholder="${field.fieldName}" autocomplete="off" class="layui-input" value="${groupID}" >
				</div>
			</div>
		<#elseif 'groupCode' == field.fieldName >
			<div class="layui-form-item layui-hide">
				<label class="layui-form-label">${field.fieldName}</label>
				<div class="layui-input-block">
					<input type="text" name="${field.fieldName}" required  lay-verify="required" placeholder="${field.fieldName}" autocomplete="off" class="layui-input" value="${groupCode}" >
				</div>
			</div>
		<#else>
			<div class="layui-form-item">
				<label class="layui-form-label">${field.fieldName}</label>
				<#if 'isActive' == field.fieldName>
					<div class="layui-input-block">
						<select name="${field.fieldName}" lay-verify="">
							<option value="true">有效</option>
							<option value="false">无效</option>
						</select>
					</div>

				<#elseif 'responseType' == field.fieldName >
					<div class="layui-input-block">
						<select name="${field.fieldName}" lay-verify="">
						<#list responseTypes as typeEnum >
							<option value="${typeEnum.type}" >${typeEnum.type}</option>
						</#list>
						</select>
					</div>
				<#elseif 'responseBody' == field.fieldName >
					<div class="layui-input-block">
						<textarea name="responseBody" class="layui-textarea"></textarea>

					</div>
				<#else>
					<div class="layui-input-block">
						<input type="text" name="${field.fieldName}" required  lay-verify="required" placeholder="${field.fieldName}" autocomplete="off"
						<#if 'sortIndex' == field.fieldName >
							class="layui-input" value="99"
						<#else>
							class="layui-input"
						</#if>
						>
					</div>
				</#if>
			 </div>
		</#if>
	  </#list>
	  <div class="layui-form-item">
	    <div class="layui-input-block">
	      <button class="layui-btn" lay-submit lay-filter="mapping">保存</button>
	      <button type="reset" class="layui-btn layui-btn-primary">重置</button>
	    </div>
	  </div>
	</form>

	<fieldset class="layui-elem-field layui-field-title" style="margin-top: 30px;">
		<legend>扩展内容</legend>
	</fieldset>

	<div class="layui-collapse" lay-filter="collapse">
		<div class="layui-colla-item" >
			<h2 class="layui-colla-title">脚本列表</h2>

			<div class="layui-colla-content mapping-scripts">
				<blockquote class="layui-elem-quote layui-quote-nm layui-bg-gray">
					脚本提供4个内置参数，类型为字典。
					params（请求参数）、vars（自定义变量）、headers 、cookies：
				</blockquote>

				<div class="layui-colla-content-item">

				</div>
				<button class="layui-btn layui-btn-xs layui-btn-radius script-btn-add">
					<i class="layui-icon">&#xe608;</i> 添加
				</button>
				<button class="layui-btn layui-btn-xs layui-btn-radius layui-btn-warm script-btn-save">
					<i class="layui-icon">&#xe608;</i> 保存
				</button>
			</div>
		</div>
		<div class="layui-colla-item">
			<h2 class="layui-colla-title">匹配条件</h2>
			<div class="layui-colla-content mapping-rules" editing="false">
				<div class="layui-colla-content-item">

				</div>

				<button class="layui-btn layui-btn-xs layui-btn-radius rules-btn-add">
					<i class="layui-icon">&#xe608;</i> 添加
				</button>
				<button class="layui-btn layui-btn-xs layui-btn-radius layui-btn-warm rules-btn-save">
					<i class="layui-icon">&#xe608;</i> 保存
				</button>
			</div>
		</div>
		<div class="layui-colla-item" lay-filter="jobs" editing="false" >
			<h2 class="layui-colla-title">回调任务</h2>
			<div class="layui-colla-content mapping-jobs">
				<div class="layui-colla-content-item">

				</div>

				<button class="layui-btn layui-btn-xs layui-btn-radius job-btn-add">
					<i class="layui-icon">&#xe608;</i> 添加计划
				</button>
				<button class="layui-btn layui-btn-xs layui-btn-radius layui-btn-warm job-btn-save">
					<i class="layui-icon">&#xe608;</i> 保存
				</button>
			</div>
		</div>
	</div>

</div>
<style>
	/*.mapping-rules .operator.layui-form-item:first-child {display:none}*/
	.mapping-rules .operator.layui-form-item:first-child {visibility:hidden;}

</style>
<script>



var protocol = '${protocol}';
var requestID = '${requestID}'
var form;
var scriptLanguageList = []
var scriptFields = []
var rulesFields = []

var groupID = '${groupID}';
var groupCode = '${groupCode}';
var path = '';

var serverInfo;

var saveScriptsSuccess = true;


function loadJs(url){
	$("body").append($("<script>").attr("src", url))
}

$(function () {

    layui.use(['layer', 'element', 'form'], function(){

        window.layer = layui.layer
        window.form = layui.form;
        window.element = layui.element;
        
		var jsList = [ "/js/rest_script.js", "/js/mapping_rules.js", "/js/mapping_jobs.js", "/js/mapping_task.js"]

        jsList.forEach(function (url) {
            loadJs(url)
        })

        if (requestID > 0){
            ajaxPost("/mock_server/rest/mapping/get.ajax", {requestID: requestID}, function (response) {
                for ( var fieldName in response.data){
                    var fieldValue = response.data[fieldName]
                    $('[name='+ fieldName +']').val(fieldValue + '')

                    if (fieldName == 'isActive'){
                        $('[name='+ fieldName +']').next(".layui-form-select").find("input").val(fieldValue ? "有效" : "无效")
                    }

                }

                groupID = response.data.groupID
                groupCode = response.data.groupCode
                path = response.data.path
            })
        }

        //获取mock服务的配置
        ajaxPost("/mock_server/system/server/get.ajax", {protocol: protocol}, function (response) {
            serverInfo = response.data
        })

        //获取支持的脚本语言类型
        ajaxPost("/mock_server/enum/language/list.ajax", {}, function (response) {
            scriptLanguageList = response.data.list
        })

        //获取脚本的字段
        ajaxPost("/mock_server/rest/script/db/field.ajax", {}, function (response) {
            scriptFields = response.data.list
        })

        //获取匹配规则的字段
        ajaxPost("/mock_server/mapping/rules/db/field.ajax", {}, function (response) {
            rulesFields = response.data.list
        })


        // $(".script-btn-add").click(addScript)

        //////////////////////////  脚本
        //添加脚本事件
        $(document).on("click", ".script-btn-add", addScript)

        //删除脚本事件
        $(document).on("click", ".script-btn-remove", function () {
            removeScript($(this))
        })

        //保存脚本事件
        $(document).on("click", ".script-btn-save", function () {
            saveScripts()

            setTimeout(function () {
                if (saveScriptsSuccess) {

                    queryScripts(groupID, path)
                }else{
                    saveScriptsSuccess = true
                }
            }, 500)

        })




        //保存 mapping
        form.on('submit(mapping)', function(){
            var data = $("#item-form").serializeObject();
            ajaxPost("/mock_server/rest/mapping/save.ajax", data, function (response) {
                layer.msg(response.message)
                if (data['requestID'] == 0){
                    $("[name=requestID]").val(response.data)
                    requestID = response.data

                }

                var newPath =  $("[name=path]:first").val()
                if(newPath != path){
                    $(".mapping-scripts .layui-colla-content-item .layui-form").attr("editing", "true")
                    path = newPath
                    saveScripts();
                }

            })
            return false;
        });


        //注意：折叠面板 依赖 element 模块，否则无法进行功能性操作
        element.on('collapse(collapse)', function(data){
            if(data.show) {

                if ($(data.content).hasClass("mapping-scripts")) {
                    var groupID = $("[name=groupID]").val().trim()
                    var path = $("[name=path]").val().trim()

                    queryScripts(groupID, path)

                } else if ($(data.content).hasClass("mapping-rules")) {
                    var requestID = $("[name=requestID]").val().trim()

                    queryRules(requestID, protocol);


                } else if ($(data.content).hasClass("mapping-jobs")) {

                    var requestID = $("[name=requestID]").val().trim()

                    queryJobs(requestID, protocol);
                }
            }
        });
    })

})




///////////////////////////////////


</script>


<#include "../../common/footer.tpl">