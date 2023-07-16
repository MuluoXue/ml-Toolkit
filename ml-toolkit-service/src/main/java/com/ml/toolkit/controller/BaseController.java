package com.ml.toolkit.controller;

import com.ml.toolkit.common.exception.SysException;
import com.ml.toolkit.common.result.ResultCode;
import com.ml.toolkit.common.util.ObjectUtil;
import com.ml.toolkit.form.domain.sys.SimpleUser;
import com.ml.toolkit.jwt.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;

public class BaseController implements Serializable {
    private static final long serialVersionUID = 1306227174937328870L;

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Resource
    private JwtTokenUtil jwtTokenUtil;

    protected SimpleUser getCurrentUser() {
        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (sra == null) {
            return null;
        }
        return getCurrentUser(sra.getRequest());
    }

    private SimpleUser getCurrentUser(HttpServletRequest request) {
        String token = request.getHeader(tokenHead);
        if (ObjectUtil.isNotEmpty(token)) {
            return jwtTokenUtil.getCurrentUser(token);
        }
        return null;
    }
}
