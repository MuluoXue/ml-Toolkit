package com.ml.toolkit.exception;

import com.ml.toolkit.common.exception.SysException;
import com.ml.toolkit.common.result.BaseResultCode;
import com.ml.toolkit.common.result.Result;
import com.ml.toolkit.common.result.ResultCode;
import com.ml.toolkit.common.util.ObjectUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;
import java.util.stream.Collectors;

/**
 * 统一异常处理类
 * @author ml
 * @date 2022/4/16 下午9:14
 */
@RestControllerAdvice
public class SysExceptionHandler {

	public static Logger logger = LoggerFactory.getLogger(SysExceptionHandler.class);

	@ExceptionHandler(Exception.class)
	public Result handleException(HttpServletRequest request, Exception ex) {

		logger.info("Handle Exception Request Url:{},Exception:{}", request.getRequestURL(), ex);

		Result result = new Result();

		//系统异常
		if (ex instanceof SysException) {
			SysException se = (SysException) ex;
			BaseResultCode resultCode = se.getResultCode();
			if (resultCode == null) {
				result = Result.failure(se.getMessage());
			} else {
				result = new Result(resultCode.getCode(), ObjectUtil.isNotEmpty(se.getMessage()) ? se.getMessage() : resultCode.getMessage());
			}
		} else if (ex instanceof ConstraintViolationException) {
			//参数错误
			ConstraintViolationException v = (ConstraintViolationException) ex;
			String message = v.getConstraintViolations().iterator().next()
					.getMessage();
			result.setCode(ResultCode.PARAM_ERROR.getCode());
			result.setMessage(ResultCode.PARAM_ERROR.getMessage() + ":" + message);
		} else if (ex instanceof BindException) {
			//参数校验异常
			BindException v = (BindException) ex;
			String message = v.getAllErrors().stream().map(ObjectError::getDefaultMessage).collect(Collectors.joining(","));
			result.setCode(ResultCode.PARAM_ERROR.getCode());
			result.setMessage(ResultCode.PARAM_ERROR.getMessage() + ":" + message);
		} else if (ex instanceof MethodArgumentNotValidException) {
			//方法参数校验异常
			MethodArgumentNotValidException v = (MethodArgumentNotValidException) ex;
			String message = v.getBindingResult().getAllErrors().stream().map(ObjectError::getDefaultMessage).collect(Collectors.joining(","));
			result.setCode(ResultCode.PARAM_ERROR.getCode());
			result.setMessage(ResultCode.PARAM_ERROR.getMessage() + ":" + message);
		} else if (ex instanceof HttpMessageNotReadableException) {
			result.setCode(ResultCode.PARAM_ERROR.getCode());
			result.setMessage(ResultCode.PARAM_ERROR.getMessage() + ":" + "参数格式错误");
		} else {
			result = Result.failure();
		}
		return result;
	}
}
