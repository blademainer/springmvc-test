/**
 * YIXUN_1.5_EE
 */
package com.kingray.web.exception;

/**
 * @author 瑛琪 <a href="http://xiongyingqi.com">xiongyingqi.com</a>
 * @version 2013-10-11 下午4:34:45
 */
public class ValidateException extends RuntimeException {
	/**
	 * 2013-10-17 下午3:07:56 long ValidateException.java
	 */
	private static final long serialVersionUID = -3031713568024130462L;

	public ValidateException() {

	}

	public ValidateException(String message) {
		super(message);
	}

	public ValidateException(String message, Throwable throwable) {
		super(message, throwable);
	}

	public ValidateException(Throwable throwable) {
		super(throwable);
	}
}
