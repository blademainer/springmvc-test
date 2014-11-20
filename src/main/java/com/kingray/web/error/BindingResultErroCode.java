/**
 * YIXUN_1.5_EE
 */
package com.kingray.web.error;

import com.kingray.vo.CodeVo;

/**
 * 对应springmvc的BindingResult检验
 * 
 * @author 瑛琪 <a href="http://xiongyingqi.com">xiongyingqi.com</a>
 * @version 2013-10-17 下午5:39:41
 */
public class BindingResultErroCode extends CodeVo {

	/**
	 * @param errorCode
	 * @param errorName
	 * @param erroValue
	 * @param errorReason
	 */
	public BindingResultErroCode(int errorCode, String errorName, String erroValue,
			String errorReason) {
		super(errorCode, errorName, erroValue, errorReason);
	}

	/**
	 * <br>
	 * 2013-10-17 下午5:39:53
	 * 
	 * @see com.kingray.vo.CodeVo#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("错误类：");
		builder.append(super.getResultName());
		builder.append(", ");
		builder.append("错误属性：");
		builder.append(super.getResultValue());
		builder.append(", ");
		builder.append("错误原因：");
		builder.append(super.getResultReason());
		return builder.toString();
	}

}
