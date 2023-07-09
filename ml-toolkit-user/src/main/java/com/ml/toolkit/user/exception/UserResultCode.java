package com.ml.toolkit.user.exception;

import com.ml.toolkit.common.result.BaseResultCode;

public enum UserResultCode implements BaseResultCode {

    /* 4000 --4100 区间表示参数错误 */
    ACCOUNT_NOT_FIND(1001, "账户不存在"),
    PASSWORD_ERROR(1002, "密码错误"),
    ACCOUNT_DISABLE(1001, "账户被禁用"),
    ;

    private final int code;
    private final String message;

    UserResultCode(int code, String message) {
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
