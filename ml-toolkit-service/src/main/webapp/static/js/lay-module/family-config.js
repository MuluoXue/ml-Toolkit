/**
 * lay-ui 自定义扩展
 */
window.rootPath = window.location.protocol + "//" + window.location.host;

layui.config({
    base: rootPath + "/static/js/lay-module/",
    version: true
}).extend({
    familyMenu: "family-menu",
    familyPage: "family-page",
    familyModel: "family-model"
});