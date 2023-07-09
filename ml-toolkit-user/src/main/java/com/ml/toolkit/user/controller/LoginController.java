package com.ml.toolkit.user.controller;

import com.ml.toolkit.common.result.Result;
import com.ml.toolkit.user.domain.SysUser;
import com.ml.toolkit.user.service.SysUserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ml
 * @date 2022年12月22日 17:30
 */
@RestController
@RequestMapping("/sys/login")
public class LoginController {

//    @Value("${jwt.tokenHeader}")
//    private String tokenHeader;

    @Resource
    private SysUserService userService;

//    @Resource
//    private JwtTokenUtil jwtTokenUtil;

    @RequestMapping("/login")
    public Result login(@RequestBody SysUser user, HttpServletResponse response){
        SysUser sysUser = userService.login(user);
//        String token = jwtTokenUtil.findAccessToken(sysUser);
//        response.addHeader(tokenHeader, token);
        return Result.success();
    }
}
