/**
 * request 组件
 */
layui.define(["jquery"], function (exports) {
    const $ = layui.$;

    const familyFormField = {

        /**
         * 根据字段获取html
         * @param fieldList 字段列表
         * @returns {string} html
         */
        renderHtml: function (fieldList) {
            let html = "";
            fieldList.forEach(function (field) {
                html += '<div class="layui-form-item"> <label class="layui-form-label">';
                html += field.name;
                html += '</label> <div class="layui-input-block"><input type="text" name="';
                html += field.id;
                html += '" lay-verify="required" placeholder="请输入" autoComplete="off" class="layui-input"> </div></div>';
            })
            return html;
        }

    }
    exports("familyFormField", familyFormField);
})