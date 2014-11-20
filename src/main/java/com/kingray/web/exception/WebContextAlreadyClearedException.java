/**
 * YIXUN_1.5_EE
 */
package com.kingray.web.exception;

/**
 * @author 瑛琪 <a href="http://xiongyingqi.com">xiongyingqi.com</a>
 * @version 2013-11-7 下午9:56:39
 */
public class WebContextAlreadyClearedException extends Exception {

	/**
	 * 2013-11-7 下午9:57:36 long WebContextAlreadyClearedException.java
	 */
	private static final long serialVersionUID = -7534805911947137614L;

	public WebContextAlreadyClearedException() {
		super("当前的线程已经调用过clear方法，请检查com.kingray.filter.WebContextFilter过滤器的优先级是否在其他过滤器之前！");
	}

	public WebContextAlreadyClearedException(String message) {
		super(message);
	}

	public WebContextAlreadyClearedException(String message, Throwable throwable) {
		super(message, throwable);
	}

	public WebContextAlreadyClearedException(Throwable throwable) {
		super(throwable);
	}
}
