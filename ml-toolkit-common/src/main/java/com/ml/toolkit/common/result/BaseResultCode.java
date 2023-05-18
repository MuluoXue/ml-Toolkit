package com.ml.toolkit.common.result;

/**
 * 状态码统一返回接口
 * @author ml
 */
public interface BaseResultCode {

	/**
	 * 获取状态吗
	 * @return code
	 */
	int getCode();

	/**
	 * 获取提示信息
	 * @return msg
	 */
	String getMessage();
}
