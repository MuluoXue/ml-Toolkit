<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <!-- 引入 layui.css -->
    <link rel="stylesheet" href="../../../static/layui/css/layui.css"/>
    <!-- 引入 layui.js -->
    <script src="../../../static/layui/layui.js"></script>
    <script src="../../../static/js/lay-module/family-config.js"></script>
    <script src="../../../static/js/jquery/jquery-3.4.1.min.js" charset="utf-8"></script>
    <script src="../../../static/js/jquery/jquery.particleground.min.js" charset="utf-8"></script>
    <style>
        html, body {
            width: 100%;
            height: 100%;
            overflow: hidden
        }

        body {
            background: #1E9FFF;
        }

        body:after {
            content: '';
            background-repeat: no-repeat;
            background-size: cover;
            -webkit-filter: blur(3px);
            -moz-filter: blur(3px);
            -o-filter: blur(3px);
            -ms-filter: blur(3px);
            filter: blur(3px);
            position: absolute;
            top: 0;
            left: 0;
            right: 0;
            bottom: 0;
            z-index: -1;
        }

        .layui-container {
            width: 100%;
            height: 100%;
            overflow: hidden
        }

        .admin-login-background {
            width: 360px;
            height: 300px;
            position: absolute;
            left: 50%;
            top: 40%;
            margin-left: -180px;
            margin-top: -100px;
        }

        .logo-title {
            text-align: center;
            letter-spacing: 2px;
            padding: 14px 0;
        }

        .logo-title h1 {
            color: #1E9FFF;
            font-size: 25px;
            font-weight: bold;
        }

        .login-form {
            background-color: #fff;
            border: 1px solid #fff;
            border-radius: 3px;
            padding: 14px 20px;
            box-shadow: 0 0 8px #eeeeee;
        }

        .login-form .layui-form-item {
            position: relative;
        }

        .login-form .layui-form-item label {
            position: absolute;
            left: 1px;
            top: 1px;
            width: 38px;
            line-height: 36px;
            text-align: center;
            color: #d2d2d2;
        }

        .login-form .layui-form-item input {
            padding-left: 36px;
        }

        .captcha-img img {
            height: 34px;
            border: 1px solid #e6e6e6;
            height: 36px;
            width: 100%;
        }
    </style>
</head>
<body>
<div class="layui-container">
    <div class="admin-login-background">
        <div class="layui-form login-form">
            <form class="layui-form" lay-filter="js_login_val_filter">
                <div class="layui-form-item logo-title">
                    <h1>ml登录</h1>
                </div>
                <div class="layui-form-item">
                    <label class="layui-icon layui-icon-username"></label>
                    <input type="text" name="account" lay-verify="required|account" placeholder="邮箱" autocomplete="off"
                           class="layui-input" value="15136200812@163.com">
                </div>
                <div class="layui-form-item">
                    <label class="layui-icon layui-icon-password"></label>
                    <input type="password" name="password" lay-verify="required|password" placeholder="密码"
                           autocomplete="off" class="layui-input" value="123">
                </div>
                <%--                <div class="layui-form-item">--%>
                <%--                    <label class="layui-icon layui-icon-vercode" for="captcha"></label>--%>
                <%--                    <input type="text" name="captcha" lay-verify="required|captcha" placeholder="图形验证码" autocomplete="off" class="layui-input verification captcha" value="xszg">--%>
                <%--                    <div class="captcha-img">--%>
                <%--                        <img id="captchaPic" src="../images/captcha.jpg">--%>
                <%--                    </div>--%>
                <%--                </div>--%>
                <div class="layui-form-item">
                    <input type="checkbox" name="rememberMe" value="true" lay-skin="primary" title="记住密码">
                </div>
            </form>
            <div class="layui-form-item">
                <button class="layui-btn layui-btn layui-btn-normal layui-btn-fluid js_login_submit">登 入</button>
            </div>
        </div>
    </div>
</div>
<script src="../../../static/js/api.js"></script>
<script>
    layui.use(['form', 'familyRequest'], function () {
        var form = layui.form,
            layer = layui.layer,
            $ = layui.$,
            familyRequest = layui.familyRequest;

        // 粒子线条背景
        $(document).ready(function () {
            $('.layui-container').particleground({
                dotColor: '#7ec7fd',
                lineColor: '#7ec7fd'
            });
        });

        // 进行登录操作
        $('.js_login_submit').on('click', function () {
            form.submit('js_login_val_filter', function (data) {
                data = data.field;
                familyRequest.requestLogin({url: window.user.login.apiUrl.login, param: data}, function (params) {
                    layer.msg(params?.message);
                    window.location = '/form/page/mainPage';
                },$('.js_login_submit'))
                return false;
            });
        });
    });
</script>
</body>
</html>