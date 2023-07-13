package com.ml.toolkit.exception.sys;

public class UserException extends RuntimeException {

    private static final long serialVersionUID = 2645887459006892961L;

    public UserResultCode resultCode;

    public UserException(UserResultCode resultCode) {
        this.resultCode = resultCode;
    }

    public UserResultCode getResultCode() {
        return resultCode;
    }

    public void setResultCode(UserResultCode resultCode) {
        this.resultCode = resultCode;
    }
}
