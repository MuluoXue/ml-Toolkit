package com.ml.toolkit.exception.sys;

import com.ml.toolkit.common.result.BaseResultCode;
import com.ml.toolkit.common.result.Result;
import com.ml.toolkit.common.util.ObjectUtil;
import com.ml.toolkit.exception.SysExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * 统一异常处理类
 * @author ml
 * @date 2022/4/16 下午9:14
 */
@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class SysUserExceptionHandler extends SysExceptionHandler {

	public static Logger logger = LoggerFactory.getLogger(SysUserExceptionHandler.class);

	@ExceptionHandler(UserException.class)
	public Result handleException(HttpServletRequest request, UserException ex) {

		logger.info("SysUserExceptionHandler handleException Request Url:{},Exception:{}", request.getRequestURL(), ex);

		//系统异常
		BaseResultCode resultCode = ex.getResultCode();
		if (resultCode == null) {
			return super.handleException(request, ex);
		} else {
			return new Result(resultCode.getCode(), ObjectUtil.isNotEmpty(ex.getMessage()) ? ex.getMessage() : resultCode.getMessage());
		}
	}
}
