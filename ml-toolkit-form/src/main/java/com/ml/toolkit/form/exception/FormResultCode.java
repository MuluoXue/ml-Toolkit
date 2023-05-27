package com.ml.toolkit.form.exception;

import com.ml.toolkit.common.result.BaseResultCode;

public enum FormResultCode implements BaseResultCode {

    /* 4000 --4100 区间表示参数错误 */
    PARAM_ERROR(4001, "参数错误");

    private final int code;
    private final String message;

    FormResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
