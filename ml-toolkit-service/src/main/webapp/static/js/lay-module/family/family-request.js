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
                data: options?.param ? JSON.stringify(options.param) : "",
                async: true,
                headers: {
                    "Bearer": window.localStorage.getItem('mlToken')
                },
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
        requestLogin: function (options, successFunction) {
            $.ajax({
                url: this.getUrl(options.url),
                type: 'post',
                contentType: "application/json",
                data: options?.param ? JSON.stringify(options.param) : "",
                async: true,
                success: function (data, status,xhr) {
                    //获取服务端自定义的header信息
                    const token = xhr.getResponseHeader('Authorization');
                    if (token) {
                        window.localStorage.setItem('mlToken',token)
                    }
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