<#include "../common/header.tpl">

<div class="layui-body">
    <!-- 内容主体区域 -->
    <div class="layui-btn-container" style="padding: 15px 0px 0px 5px">
        <a class="layui-btn" href="/project/edit.html">新增项目</a>
        <a class="layui-btn" href="javascript:ayncK8sStatus()">同步k8s状态</a>
        <a class="layui-btn" href="javascript:ayncApmStatus()">同步APM状态</a>
        <a class="layui-btn layui-btn-primary total-records" href="javascript:void(0);">总记录数：</a>
    </div>
    <div style="/* padding: 15px; */" id="item-list" lay-even ></div>
</div>


<script>

    layui.use('table', function(){
        var table = layui.table;

        table.render({
            elem: '#item-list'
            ,url:'/project/${method}.ajax'
            ,method:"post"
            ,contentType : "application/json"
            ,cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
            ,cols: [[
                {field:'serviceName', title: '服务名'},
                {field:'jenkinsJobName', title: 'jenkinsJobName'},
                {field:'serviceDescribe', title: '服务描述'},
                {field:'business', title: '业务领域'},
                {field:'needDeploy', title: '是否需要部署'},
                {field:'k8sStatus', title: 'k8s服务状态'},
                {field:'apmStatus', title: '探针状态'},
                {field:'remark', title: '备注'},
                {fixed: 'right', align:'center', toolbar: '#barDemo', title:'管理'} //这里的toolbar值是模板元素的选择器

            ]]
            ,parseData : function (res) {
                var data = {
                    "code": res.code, //解析接口状态
                    "msg": res.message, //解析提示文本
                    "count": res.data.total, //解析数据长度
                    "data": res.data.list //解析数据列表
                };

                $(".total-records").text('总记录数：'+ res.data.total)

                return data;
            }
        });

    });

    function ayncApmStatus(){
        ajaxPost('/project/syncApmStatus.ajax', {},function(response) {
            layer.msg("同步完成")
            setTimeout(function () {
                location.reload();
            },2000)
        })

        return false;
    }

    function ayncK8sStatus(){
        ajaxPost('/project/ayncK8sStatus.ajax', {},function(response) {
            layer.msg("同步完成")
            setTimeout(function () {
                location.reload();
            },2000)
        })

        return false;
    }

    function deleteItem(ID, name){
        msg = "确定要删除<span style='color:red'>" + name + "</span>?"
        layer.confirm(msg, function(index){
            ajaxPost('/project/delete.ajax', {ID:ID},function(response) {
                location.reload();
            })
            layer.close(index);
        })
    }

    function reloadK8s(jenkinsJobName, name){
        msg = "确定要重启K8s:<span style='color:red'>" + name + "</span>?"

        layer.confirm(msg, function(index){
            ajaxPost('/project/reloadK8s.ajax', {jenkinsJobName:jenkinsJobName}, function(response) {
                // location.reload();
                layer.msg("已执行操作")
            })
            layer.close(index);
        })
    }


    function getK8sStatus(jenkinsJobName){
        ajaxPost('/project/getK8sStatus.ajax', {jenkinsJobName:jenkinsJobName}, function(response) {
            layer.msg(response.message, {time: 5000})
        })

        return false;
    }


    function reloadAllFailK8s(jenkinsJobName){
        msg = "确定要重启<span style='color:red'>所有无活跃探针的服务</span>?"

        layer.confirm(msg, function(index){
            ajaxPost('/project/reloadK8s.ajax', {jenkinsJobName:jenkinsJobName},function(response) {
                layer.msg("已执行操作")
            })
            layer.close(index);
        })
    }





</script>

    <script type="text/html" id="barDemo">

        <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del" href="javascript:deleteItem({{d.ID}}, '{{ d.serviceDescribe.replace(/["\']/g, "")}}');">删除</a>
        <a class="layui-btn layui-btn-xs" lay-event="edit"  href="javascript:reloadK8s('{{d.jenkinsJobName}}', '{{ d.serviceDescribe.replace(/["\']/g, "")}}');">重启k8s</a>
        <a class="layui-btn layui-btn-xs" lay-event="edit"  href="javascript:getK8sStatus('{{d.jenkinsJobName}}', '{{ d.serviceDescribe.replace(/["\']/g, "")}}');">获取k8s状态</a>

        <!-- 这里同样支持 laytpl 语法，如： -->

    </script>




<#include "../common/footer.tpl">