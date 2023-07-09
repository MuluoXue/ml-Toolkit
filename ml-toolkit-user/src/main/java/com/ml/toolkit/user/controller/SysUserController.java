package com.ml.toolkit.user.controller;

import com.ml.toolkit.common.result.Result;
import com.ml.toolkit.user.domain.SysUser;
import com.ml.toolkit.user.service.SysUserService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author ml
 * @date 2022年12月21日 21:51
 */
@RestController
@RequestMapping("/sys/user")
public class SysUserController {

    @Resource
    private SysUserService userService;

    @RequestMapping("/register")
    public Result register(@RequestBody SysUser user) {
        userService.register(user);
        return Result.success();
    }
}
