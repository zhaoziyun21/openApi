<#include "../../common/header.tpl">

<div class="layui-body">
    <!-- 内容主体区域 -->
    <div class="layui-btn-container" style="padding: 15px 0px 0px 5px">
        <a class="layui-btn" href="/mock_server/rest/mapping/info.html?groupID=${groupID}&groupCode=${groupCode}">新增映射</a>
    </div>
    <div style="/* padding: 15px; */" id="item-list" lay-even ></div>
</div>


<script>

    layui.use('table', function(){
        var table = layui.table;

        table.render({
            elem: '#item-list'
            ,url:'/mock_server/rest/mapping/list.ajax'
            ,method:"post"
            ,contentType : "application/json"
            ,where: {groupID: ${groupID}}
            ,cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
            ,cols: [[
            <#list fields as field >
                {field:'${field.fieldName}', title: '${field.fieldName}'},
            </#list>
                {fixed: 'right', align:'center', toolbar: '#barDemo', title:'管理'} //这里的toolbar值是模板元素的选择器

            ]]
            ,parseData : function (res) {
                var data = {
                    "code": res.code, //解析接口状态
                    "msg": res.message, //解析提示文本
                    "count": res.data.total, //解析数据长度
                    "data": res.data.list //解析数据列表
                };
                return data;
            }
            // ,response : {
            //     statusCode: 200
            // }
        });
    });

    function deleteItem(requestID, name){
        msg = "确定要删除<span style='color:red'>" + name + "</span>?"
        layer.confirm(msg, function(index){
            ajaxPost('/mock_server/rest/mapping/delete.ajax', {requestID:requestID},function(response) {
                location.reload();
            })
            layer.close(index);
        })


    }


</script>

    <script type="text/html" id="barDemo">
        <a class="layui-btn layui-btn-xs" lay-event="edit" href="/mock_server/rest/mapping/info.html?requestID={{d.requestID}}">编辑</a>
        <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del" href="javascript:deleteItem({{d.requestID}}, '{{ d.path + "(" + d.memo.replace(/["\']/g, "") + ")" }}');">删除</a>

        <!-- 这里同样支持 laytpl 语法，如： -->

    </script>




<#include "../../common/footer.tpl">