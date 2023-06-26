/**
 * 菜单组件
 */
layui.define(["element","jquery","laytpl","layer"],function(exports){

	var $ = layui.$,
		layTpl = layui.laytpl,
		layer = layui.layer;

	var familyMenu = {
		render: function(options){
			this.$el = options.parentEl?options.parentEl:"body";

			this.delegateEvents();
			// this.renderMenus();
		},
		delegateEvents: function(){
			var view =this;
			var $el = $(view.$el);

			/**
			 * 点击左侧菜单切换内容
			 */
			$el.off('click','.j_all_menu .j_menu').on('click','.j_all_menu .j_menu',function(){
				var loading = layer.load(0, {shade: false, time: 2 * 1000});
				var $this = $(this);
				var attrHref = $this.attr("attr_href");
				if(attrHref){
					$.ajax({
						url: attrHref,
						type: 'get',
						dataType: 'html',
						async: false,
						success: function (data) {
							$el.find(".j_lay_ui_body .j_lay_ui_content").html(data);
							layer.close(loading);
						},
						error: function (xhr, textstatus, thrown) {
							return layer.msg('Status:' + xhr.status + '，' + xhr.statusText + '，请稍后再试！');
						}
					});
				}else{
					layer.msg("没有attr_href 信息！");
				}
			});

		},

		renderMenus: function(){
			var view =this;
			var $el = $(view.$el);
			var getTpl = menu-left.innerHTML;
			var menuLeft = $el.find(".j_lay_ui_menu_left");
			layTpl(getTpl).render("", function(html){
				menuLeft.innerHTML = html;
			});
		}
	}
	exports("familyMenu", familyMenu);
})