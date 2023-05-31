package com.toolkit.sql.conversion.exception;

public class SqlConversionException extends RuntimeException{
    private static final long serialVersionUID = 3921448689637670318L;

    public SqlConversionException() {
    }

    public SqlConversionException(String message) {
        super(message);
    }

    public SqlConversionException(String message, Throwable cause) {
        super(message, cause);
    }
}
