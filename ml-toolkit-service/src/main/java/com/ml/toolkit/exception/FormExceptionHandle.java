package com.ml.toolkit.exception;

import com.ml.toolkit.common.result.BaseResultCode;
import com.ml.toolkit.common.result.Result;
import com.ml.toolkit.common.util.ObjectUtil;
import com.ml.toolkit.form.exception.FormException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * Form模块统一异常处理类
 * @date 2022/4/16 下午9:44
 * @author ml
 */
@Slf4j
@RestControllerAdvice
public class FormExceptionHandle extends SysExceptionHandler {

    @ExceptionHandler(FormException.class)
    public Result handleException(HttpServletRequest request, FormException ex) {

        log.info("FinanceExceptionHandle handleException Request Url:{},FinanceException:{}", request.getRequestURL(), ex);
        Result result;
        //系统异常
        BaseResultCode resultCode = ex.getResultCode();
        if (resultCode == null) {
            result = Result.failure(ex.getMessage());
        } else {
            result = new Result(resultCode.getCode(), ObjectUtil.isNotEmpty(ex.getMessage()) ? ex.getMessage() : resultCode.getMessage());
        }
        return result;
    }
}
