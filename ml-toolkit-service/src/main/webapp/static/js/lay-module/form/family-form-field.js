/**
 * request 组件
 */
layui.define(['familyFormText','familyFormSelect','familyFormDate'], function (exports) {
    const formConfig = {
        'TEXT': layui.familyFormText,
        'SELECT': layui.familyFormSelect,
        'DATE': layui.familyFormDate
    }
    const familyFormField = {

        /**
         * 根据字段获取html
         * @param fieldList 字段列表
         * @returns {string} html
         */
        renderHtml: function (fieldList) {
            let html = "";
            fieldList.forEach(function (field) {
                const fieldConfig = formConfig[field.type];
                if (fieldConfig) {
                    html += '<div class="layui-form-item"> <label class="layui-form-label">';
                    html += field.name;
                    html += '</label> <div class="layui-input-block">';
                    html += fieldConfig.renderHtml(field);
                    html += '</div></div>'
                }
            })
            return html;
        },

        afterRender: function ($el) {
            layui.laydate.render({
                elem: $el.find("input[lay-verify='date']"),
            });
        }
    }
    exports("familyFormField", familyFormField);
})