/**
 * 后台请求组件
 */
layui.define(["jquery"], function (exports) {

	var $ = layui.$;

	var FamilyModel = {

		/**
		 * 发送post请求
		 * @param url 地址
		 * @param param 参数
		 * @param callback 回调
		 * @param dataType 类型
		 * @param async 是否异步
		 */
		sendPost: function (url, param, callback, dataType, async) {
			$.ajax({
				contentType: 'application/json;charset=UTF-8',
				type: "post",
				url: url,
				async: async ? async : true,
				dataType: dataType ? dataType : 'json',
				data: JSON.stringify(param),
				success: function (data) {
					if (callback) callback(data);
				}
			});
		}

	}
	exports("familyModel", FamilyModel);
})