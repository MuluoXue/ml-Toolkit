<%--
  Created by IntelliJ IDEA.
  User: muluo
  Date: 2023/6/25
  Time: 21:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>Title</title>
    <!-- 引入 layui.css -->
    <link rel="stylesheet" href="../../../static/layui/css/layui.css"/>
    <!-- 引入 layui.js -->
    <script src="../../../static/layui/layui.js"></script>
    <script src ="../../../static/js/lay-module/family-config.js"></script>
</head>

<body>
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo layui-hide-xs layui-bg-black">layout demo</div>
        <!-- 头部区域（可配合layui 已有的水平导航） -->
        <ul class="layui-nav layui-layout-left">
            <!-- 移动端显示 -->
            <li class="layui-nav-item layui-show-xs-inline-block layui-hide-sm" lay-header-event="menuLeft">
                <i class="layui-icon layui-icon-spread-left"></i>
            </li>
            <li class="layui-nav-item layui-hide-xs"><a href="javascript:;">nav 1</a></li>
            <li class="layui-nav-item layui-hide-xs"><a href="javascript:;">nav 2</a></li>
            <li class="layui-nav-item layui-hide-xs"><a href="javascript:;">nav 3</a></li>
            <li class="layui-nav-item">
                <a href="javascript:;">nav groups</a>
                <dl class="layui-nav-child">
                    <dd><a href="javascript:;">menu 11</a></dd>
                    <dd><a href="javascript:;">menu 22</a></dd>
                    <dd><a href="javascript:;">menu 33</a></dd>
                </dl>
            </li>
        </ul>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item layui-hide layui-show-sm-inline-block">
                <a href="javascript:;">
                    <img src="//unpkg.com/outeres@0.0.10/img/layui/icon-v2.png" class="layui-nav-img">
                    tester
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="javascript:;">Your Profile</a></dd>
                    <dd><a href="javascript:;">Settings</a></dd>
                    <dd><a href="javascript:;">Sign out</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item" lay-header-event="menuRight" lay-unselect>
                <a href="javascript:;">
                    <i class="layui-icon layui-icon-more-vertical"></i>
                </a>
            </li>
        </ul>
    </div>
    <!-- 左侧导航栏 -->
    <div class="layui-side layui-bg-black j_lay_ui_menu_left">
        <div class="layui-side-scroll j_all_menu">
            <ul class="layui-nav layui-nav-tree"  lay-filter="test">
                <li class="layui-nav-item layui-nav-itemed">
                    <a>表单管理</a>
                    <dl class="layui-nav-child">
                        <dd class="j_menu"><a href="javascript:;">表单列表</a></dd>
                        <dd class="j_menu"><a href="javascript:;">新建表单</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="j_menu" attr_href="/static/page/apply.html"> 费用申请单(大陆)</a>
                </li>
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="j_menu" attr_href="/static/page/hk/reimbursement.html">费用报销单(香港)</a>
                </li>
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="j_menu" attr_href="/static/page/hk/apply.html"> 费用申请单(香港)</a>
                </li>
            </ul>
        </div>
    </div>

    <div class="layui-body j_lay_ui_body">
        <!-- 内容主体区域 -->
        <div class="j_lay_ui_content"></div>
    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
        底部固定区域
    </div>
</div>

<script>
    layui.use(["jquery","familyMenu"],function(){
        var familyMenu = layui.familyMenu;
        familyMenu.render({
            parentEl:"body"
        })
    })
</script>
</body>
</html>
