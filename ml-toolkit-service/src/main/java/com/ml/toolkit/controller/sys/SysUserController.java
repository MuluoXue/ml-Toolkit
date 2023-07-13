package com.ml.toolkit.controller.sys;

import com.ml.toolkit.common.result.Result;
import com.ml.toolkit.domain.sys.SysUser;
import com.ml.toolkit.service.sys.SysUserService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

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
    public Result register(@RequestBody @Valid SysUser user) {
        userService.register(user);
        return Result.success();
    }
}
