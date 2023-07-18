
layui.define([], function (exports) {

    const familyFormSelect = {

        /**
         * 根据字段获取html
         * @param field 字段
         * @returns {string} html
         */
        renderHtml: function (field) {
            let html = '<select name="';
            html += field.id;
            html += '" <option value="TEXT" selected>TEXT</option><option value="DATE" >DATE</option></select>';
            return html;
        }
    }
    exports("familyFormSelect", familyFormSelect);
})