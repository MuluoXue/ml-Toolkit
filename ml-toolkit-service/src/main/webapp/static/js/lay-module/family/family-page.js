/**
 * 页面组件
 */
layui.define(["jquery"],function(exports){

	var layer = layui.layer,
		$ = layui.$;

	var familyPage = {
		/**
		 * 获取弹出层的宽高
		 * @returns {jQuery[]}
		 */
		getOpenWidthHeight: function () {
			var clientWidth = $(".j_lay_ui_content").width();
			var clientHeight = $(".j_lay_ui_content").height();
			var offsetLeft = $(".j_lay_ui_content").offset().left;
			var offsetTop = $(".j_lay_ui_content").offset().top;
			return [clientWidth, clientHeight, offsetTop, offsetLeft];
		}
	}
	exports("familyPage", familyPage);

})