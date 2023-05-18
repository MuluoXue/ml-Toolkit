package com.ml.toolkit.common.result;

import java.io.Serializable;

/**
 * 接口格式输出类
 * @author ml
 * @date 2022/4/16 下午8:18
 */
public class Result implements Serializable {

	private static final long serialVersionUID = -4503937308285934566L;

	/**
	 * code
	 */
	private int code;

	/**
	 * message
	 */
	private String message;

	/**
	 * data
	 */
	private Object data;

	public Result() {
	}

	public Result(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public static Result result(ResultCode resultCode) {
		Result result = new Result();
		result.setCode(resultCode.getCode());
		result.setMessage(resultCode.getMessage());
		return result;
	}

	public Result result(ResultCode resultCode, Object data) {
		Result result = result(resultCode);
		result.setData(data);
		return result;
	}

	public static Result success() {
		return result(ResultCode.SUCCESS);
	}

	public static Result success(Object data) {
		Result result = success();
		result.setData(data);
		return result;
	}

	public static Result failure() {
		return result(ResultCode.SYS_ERROR);
	}

	public static Result failure(String msg) {
		Result result = result(ResultCode.SYS_ERROR);
		result.setMessage(msg);
		return result;
	}

	public Result failure(ResultCode resultCode, Object data) {
		return this.result(resultCode, data);
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}
