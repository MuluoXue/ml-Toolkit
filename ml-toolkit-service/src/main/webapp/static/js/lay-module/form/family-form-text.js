/**
 * request 组件
 */
layui.define([], function (exports) {

    const familyFormText = {

        /**
         * 根据字段获取html
         * @param field 字段
         * @returns {string} html
         */
        renderHtml: function (field) {
            let html = '<input type="text" name="';
            html += field.id;
            html += '" placeholder="请输入" autoComplete="off" class="layui-input"> ';
            return html;
        }
    }
    exports("familyFormText", familyFormText);
})