<#include "../../common/header.tpl">

<div class="layui-body">
    <!-- 内容主体区域 -->
    <div class="layui-btn-container" style="padding: 15px 0px 0px 5px">
        <a class="layui-btn" href="/mock_server/rest/group/info.html">新增分组</a>
    </div>
    <div style="/* padding: 15px; */" id="group-list" lay-even ></div>
</div>


<script>

    layui.use('table', function(){
        var table = layui.table;

        table.render({
            elem: '#group-list'
            ,url:'/mock_server/rest/group/list.ajax'
            ,method:"post"
            ,contentType : "application/json"
            ,cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
            ,cols: [[
                //{field:'groupCode', width:'10%', title: '主题'}
                //{field:'groupCode', title: '主题'}
                //,{field:'groupName', title: '描述', sort: true}
                //,{field:'sourceHost', title: '发版时间'}
                //,{field:'sourcePort', title: '发版时间'}
                //,{field:'proxyIP', title: '发版时间'}
                //,{field:'memo', title: '发版时间'}
                //,{field:'sortIndex', title: '发版时间'}
                //,{field:'isActive', title: '发版时间'}

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

    function deleteItem(groupID, name){
        msg = "确定要删除<span style='color:red'>" + name + "</span>?"
        layer.confirm(msg, function(index){
            ajaxPost('/mock_server/rest/group/delete.ajax', {groupID:groupID},function(response) {
                location.reload();
            })
            layer.close(index);
        })


    }


</script>

    <script type="text/html" id="barDemo">
        <a class="layui-btn layui-btn-xs" lay-event="edit" href="/mock_server/rest/group/info.html?groupID={{d.groupID}}">编辑</a>
        <a class="layui-btn layui-btn-xs" lay-event="detail" href="/mock_server/rest/mapping/list.html?groupID={{d.groupID}}&groupCode={{d.groupCode}}">管理接口</a>
        <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del" href="javascript:deleteItem({{d.groupID}}, '{{ d.sourceHost.replace(/["\']/g, "")}}');">删除</a>

        <!-- 这里同样支持 laytpl 语法，如： -->

    </script>




<#include "../../common/footer.tpl">