package com.ml.toolkit.common.result;

/**
 * @author ml
 */

public enum ResultCode implements BaseResultCode {


	SYS_ERROR(-1, "系统异常"),

	/* 200 -- 299 成功  */
	SUCCESS(200, "成功"),

	/* 1000～1999 区间表示参数错误 */
	PARAM_ERROR(1000, "参数错误"),
	PARAM_IS_BLANK(1002, "参数为空"),

	/* 2000～2999 区间表示用户错误 */
	USER_NOT_LOGGED_IN(2001, "用户未登录,访问的路径需要验证,请登录")
	/* 3000～3999 区间表示接口异常 */;

	/**
	 * code
	 */
	private int code;

	/**
	 * msg
	 */
	private String message;

	ResultCode(int code, String message) {
		this.code = code;
		this.message = message;
	}

	/**
	 * 获取状态吗
	 *
	 * @return code
	 */
	@Override
	public int getCode() {
		return code;
	}

	/**
	 * 获取提示信息
	 *
	 * @return msg
	 */
	@Override
	public String getMessage() {
		return message;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
