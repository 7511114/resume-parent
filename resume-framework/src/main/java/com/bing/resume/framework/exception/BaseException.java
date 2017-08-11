package com.bing.resume.framework.exception;

import java.util.Arrays;

/**
 * @author chenbing
 * Specification : 文档说明 : 基类异常
 */
public class BaseException extends Exception {

	private static final long serialVersionUID = 3211781519626534715L;
	
	/**
	 * 错误码
	 */
	private String errorCode;
	
	/**
	 * 错误信息
	 */
	private String errorMsg;
	
	/**
	 * 可变参数
	 */
	private Object[] args;
	
	public BaseException(){}
	
	/**
	 * 构造函数
	 * @param errorCode 错误码
	 */
	public BaseException(String errorCode){
		this.errorCode = errorCode;
	}
	
	/**
	 * 构造函数
	 * @param errorCode 错误码
	 * @param errorMsg 错误信息----对error应资源文件的key
	 */
	public BaseException(String errorCode,String errorMsg){
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public Object[] getArgs() {
		return args;
	}

	public void setArgs(Object[] args) {
		this.args = args;
	}

	@Override
	public String toString() {
		return "BaseException [errorCode=" + errorCode + ", errorMsg="
				+ errorMsg + ", args=" + Arrays.toString(args) + "]";
	}
}
