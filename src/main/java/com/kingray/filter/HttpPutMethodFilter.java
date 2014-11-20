/**
 * YIXUN_1.5_EE
 */
package com.kingray.filter;

import com.kingray.servlet.HttpPutMethodRequestWrapper;
import com.xiongyingqi.util.EntityHelper;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URLDecoder;
import java.util.*;
import java.util.Map.Entry;

/**
 * 解决Http协议的Put方法
 * @author xiongyingqi <a href="http://xiongyingqi.com">xiongyingqi.com</a>
 * @version 2014年2月21日 下午5:34:32
 * @see com.kingray.servlet.HttpPutMethodRequestWrapper
 */
public class HttpPutMethodFilter implements Filter {
	private String encoding = "UTF-8";

	/**
	 * <br>
	 * 2014年2月21日 下午5:34:44
	 * 
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		String encoding = filterConfig.getInitParameter("encoding");
		if(encoding != null){
			this.encoding = encoding;
		}
	}

	/**
	 * <br>
	 * 2014年2月21日 下午5:34:44
	 * 
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest,
	 *      javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		String method = httpServletRequest.getMethod();
		EntityHelper.print("method: " + method);
		if (method != null && "PUT".equals(method.toUpperCase())) {
			if (request.getInputStream() != null) {
				String queryString = "";
				BufferedReader reader = new BufferedReader(new InputStreamReader(
						request.getInputStream(), encoding));
				String line;
				while ((line = reader.readLine()) != null) {
					queryString += line;
				}
				queryString = URLDecoder.decode(queryString, encoding);
				EntityHelper.print(queryString);
				Map map = parseParameters(queryString);
				httpServletRequest = new HttpPutMethodRequestWrapper(httpServletRequest, map);
			}
		}
		chain.doFilter(httpServletRequest, response);
	}

	public Map parseParameters(String queryString) {
		Map<String, Set<String>> parameterMap = new HashMap<String, Set<String>>();
		StringTokenizer stringTokenizer = new StringTokenizer(queryString, "&");
		while (stringTokenizer.hasMoreElements()) {
			String parameter = (String) stringTokenizer.nextElement();
			System.out.println(parameter);

			StringTokenizer parameterTokenizer = new StringTokenizer(parameter, "=");

			String key = null;
			String value = null;
			if (parameterTokenizer.hasMoreElements()) {
				key = (String) parameterTokenizer.nextElement();
			}
			if (parameterTokenizer.hasMoreElements()) {
				value = (String) parameterTokenizer.nextElement();
			}
			System.out.println("key ========== " + key);
			System.out.println("value ========== " + value);
			putKeyAndValueToMap(parameterMap, key, value);
		}
		
		return parseSetToArray(parameterMap);
	}
	
	public Map parseSetToArray(Map<String, Set<String>> map){
		if(map == null){
			return null;
		}
		Map<String, String[]> rsMap = new HashMap<String, String[]>();
		Set<Entry<String, Set<String>>> entries = map.entrySet();
		for (Entry<String, Set<String>> entry : entries) {
			String key = entry.getKey();
			Set<String> value = entry.getValue();
			if(value == null){
				rsMap.put(key, null);
			} else {
				String[] strings = value.toArray(new String[]{});
				rsMap.put(key, strings);
			}
		}
		return rsMap;
	}

	public void putKeyAndValueToMap(Map<String, Set<String>> map, String key, String value) {
		Set<String> values = map.get(key);
		if (values == null) {
			values = new HashSet<String>();
		}
		values.add(value);
		map.put(key, values);
	}

	public static void main(String[] args) {
		HttpPutMethodFilter filter = new HttpPutMethodFilter();
		filter.parseParameters("department.departmentId=4&department.departmentName=IT部&department.departmentPinyin=IT Bu&department.departmentColor=#2AE&departmentManagerId[0]=2&viceDepartmentManagerId[0]=9&viceDepartmentManagerId[1]=5&viceDepartmentManagerId[2]=6&viceDepartmentManagerId[3]=3&directDepartmentManagerId[0]=3&separateDepartmentManagerId[0]=9");
	}

	/**
	 * <br>
	 * 2014年2月21日 下午5:34:44
	 * 
	 * @see javax.servlet.Filter#destroy()
	 */
	@Override
	public void destroy() {

	}

}
