package com.kingray.web.helper;

import com.xiongyingqi.util.StringHelper;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by blademainer<a href="http://xiongyingqi.com">xiongyingqi.com</a> on 2014/11/18 0018.
 */
public abstract class ServletHelper {

    public static String getIp(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    public static String getServerHost(HttpServletRequest request) {
        StringBuffer requestURL = request.getRequestURL();
        return getHost(requestURL.toString());
    }

    public static String getHost(String requestUrl) {
        if (StringHelper.nullOrEmpty(requestUrl)) {
            return null;
        }
        int i = requestUrl.indexOf("//");
        int i1 = requestUrl.indexOf("/", i + 2);
        if (i1 <= 0) {
            i1 = requestUrl.length();
        }
        String host = requestUrl.substring(0, i1);
        return host;
    }

    public static void main(String[] args) {
        String requestUrl = "http://120.24.54.6:8080/p2p-web/log/error.html";
        System.out.println(getHost(requestUrl));
        requestUrl = "http://120.24.54.6:8080";
        System.out.println(getHost(requestUrl));
    }
}
