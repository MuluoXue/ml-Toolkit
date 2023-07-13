package com.ml.toolkit.config;

import com.ml.toolkit.common.exception.SysException;
import com.ml.toolkit.common.result.ResultCode;
import com.ml.toolkit.common.util.ObjectUtil;
import com.ml.toolkit.jwt.JwtTokenUtil;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ml
 * @date 2022年12月27日 19:24
 */
@Slf4j
@Component
public class TokenHandlerInterceptor implements HandlerInterceptor {

    @Resource
    private JwtTokenUtil jwtTokenUtil;

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Override
    public boolean preHandle(HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull Object handler) throws Exception {
        String requestUrl = request.getRequestURI();
        if (requestUrl.startsWith("/static") ||
                requestUrl.contains("/papi") ||
                JwtTokenUtil.matcherHasRule(".*/login/.*", requestUrl) ||
                JwtTokenUtil.matcherHasRule(".*/page/.*", requestUrl) ||
                JwtTokenUtil.matcherHasRule(".*/register$", requestUrl)) {
            log.info("免登接口 {}", requestUrl);
        } else {
            String token = request.getHeader(tokenHead);
            if (ObjectUtil.isEmpty(token)) {
                log.info("非免登接口 {}", requestUrl);
                throw new SysException(ResultCode.USER_NOT_LOGGED_IN);
            }
            try {
                //获取用户token
                jwtTokenUtil.parseToken(token);
            } catch (Exception e) {
                throw new SysException(ResultCode.USER_NOT_LOGGED_IN);
            }
        }

        return HandlerInterceptor.super.preHandle(request, response, handler);
    }
}
