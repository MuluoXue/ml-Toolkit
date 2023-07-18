/**
 * request 组件
 */
layui.define([], function (exports) {

    const familyFormDate = {

        /**
         * 根据字段获取html
         * @param field 字段
         * @returns {string} html
         */
        renderHtml: function (field) {
            let html = '<input type="text" name="';
            html += field.id;
            html += '" id="' + field.id + '" lay-verify="date" placeholder="yyyy-MM-dd" autoComplete="off" class="layui-input"> ';
            return html;
        }
    }
    exports("familyFormDate", familyFormDate);
})