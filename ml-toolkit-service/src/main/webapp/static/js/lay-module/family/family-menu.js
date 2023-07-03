/**
 * 菜单组件
 */
layui.define(["element", "jquery", "laytpl", "layer", 'familyRequest'], function (exports) {

    const $ = layui.$,
        layTpl = layui.laytpl,
        layer = layui.layer,
        familyRequest = layui.familyRequest;

    const familyMenu = {
        render: function (options) {
            this.$el = options.parentEl ? options.parentEl : "body";

            this.delegateEvents();
            // this.renderMenus();
        },

        delegateEvents: function () {
            var view = this;
            var $el = $(view.$el);

            /**
             * 点击左侧菜单切换内容
             */
            $el.off('click', '.j_all_menu .j_menu').on('click', '.j_all_menu .js_family_menu', function () {
                let loading = layer.load(0, {shade: false, time: 2 * 1000});
                let $this = $(this);
                let familyHref = $this.attr("family_href");
                if (familyHref) {
                    const hrefContent = familyRequest.getHrefContent(familyHref);
                    $el.find(".j_lay_ui_body .j_lay_ui_content").html(hrefContent);
                    layer.close(loading);
                } else {
                    layer.msg("没有 family_href 信息！");
                }
            });
        },

        renderMenus: function () {
            var view = this;
            var $el = $(view.$el);
            var getTpl = menu - left.innerHTML;
            var menuLeft = $el.find(".j_lay_ui_menu_left");
            layTpl(getTpl).render("", function (html) {
                menuLeft.innerHTML = html;
            });
        }
    }
    exports("familyMenu", familyMenu);
})