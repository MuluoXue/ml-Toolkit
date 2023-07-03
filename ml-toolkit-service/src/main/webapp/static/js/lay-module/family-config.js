/**
 * lay-ui 自定义扩展
 */
window.rootPath = window.location.protocol + "//" + window.location.host;


const form_config = {
    familyFormField: "form/family-form-field"
}

layui.config({
    base: rootPath + "/static/js/lay-module/",
    version: true
}).extend({
    familyMenu: "family/family-menu",
    familyPage: "family/family-page",
    familyRequest: "family/family-request",
    ...form_config
});

