/**
 * request 组件
 */
layui.define(["jquery"], function (exports) {
    const $ = layui.$;

    const familyRequest = {
        request: function (options, successFunction) {
            $.ajax({
                url: this.getUrl(options.url),
                type: 'post',
                contentType: "application/json",
                data: JSON.stringify(options.param),
                async: true,
                success: function (data) {
                    if (data?.code !== 200) {
                        layer.msg(data?.message);
                    } else {
                        successFunction(data);
                    }
                },
                error: function (xhr) {
                    return layer.msg('Status:' + xhr.status + '，' + xhr.statusText + '，请稍后再试！');
                }
            });
        },
        /**
         * 获取指定链接内容
         * @param href
         * @returns {string}
         */
        getHrefContent: function (href) {
            let content = '';
            $.ajax({
                url: this.getUrl(href),
                type: 'get',
                dataType: 'html',
                async: false,
                success: function (data) {
                    content = data;
                },
                error: function (xhr) {
                    return layer.msg('Status:' + xhr.status + '，' + xhr.statusText + '，请稍后再试！');
                }
            });
            return content;
        },

        getUrl: function (href) {
            const v = new Date().getTime();
            return href.indexOf("?") > -1 ? href + '&v=' + v : href + '?v=' + v;
        }

    }
    exports("familyRequest", familyRequest);
})