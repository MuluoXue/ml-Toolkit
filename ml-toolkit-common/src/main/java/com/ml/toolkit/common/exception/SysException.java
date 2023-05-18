package com.ml.toolkit.common.exception;

import com.ml.toolkit.common.result.ResultCode;

/**
 * 系统自定义异常类型
 * @author ml
 * @date 2022-07-17
 */
public class SysException extends RuntimeException {

    private static final long serialVersionUID = -3964355764463310154L;

    public ResultCode resultCode;

    public SysException(ResultCode resultCode) {
        this.resultCode = resultCode;
    }

    public ResultCode getResultCode() {
        return resultCode;
    }

    public void setResultCode(ResultCode resultCode) {
        this.resultCode = resultCode;
    }
}
