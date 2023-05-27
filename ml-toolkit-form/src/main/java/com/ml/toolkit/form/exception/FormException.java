package com.ml.toolkit.form.exception;

public class FormException extends RuntimeException {

    private static final long serialVersionUID = 2645887459006892961L;

    public FormResultCode resultCode;

    public FormException(FormResultCode resultCode) {
        this.resultCode = resultCode;
    }
    public FormResultCode getResultCode() {
        return resultCode;
    }

    public void setResultCode(FormResultCode resultCode) {
        this.resultCode = resultCode;
    }
}
