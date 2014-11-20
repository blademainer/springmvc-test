/**
 * YIXUN_1.5_EE
 */
package com.kingray.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.util.HashMap;
import java.util.Map;

/**
 * 解决Http协议的Put方法
 * @author xiongyingqi <a href="http://xiongyingqi.com">xiongyingqi.com</a>
 * @version 2014年2月21日 下午5:00:45
 */
public class HttpPutMethodRequestWrapper extends HttpServletRequestWrapper{

	private Map parameterMap;
	/**
	 * @param request
	 */
	public HttpPutMethodRequestWrapper(HttpServletRequest request) {
		super(request);
	}
	/**
	 * @param request
	 */
	public HttpPutMethodRequestWrapper(HttpServletRequest request, Map parameterMap) {
		super(request);
		this.parameterMap = parameterMap;
	}
	
	/**
	 * <br>2014年2月21日 下午5:33:26
	 * @see javax.servlet.ServletRequestWrapper#getParameterMap()
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Map getParameterMap() {
		Map map = super.getParameterMap();
		Map modifiedMap = null;
		if(map != null && this.parameterMap != null){
			modifiedMap = new HashMap();
			modifiedMap.putAll(map);
			modifiedMap.putAll(this.parameterMap);
		}
		return modifiedMap;
	}
	
	/**
	 * Map
	 * @param parameterMap the parameterMap to set
	 */
	public void setParameterMap(Map parameterMap) {
		this.parameterMap = parameterMap;
	}
	
}
