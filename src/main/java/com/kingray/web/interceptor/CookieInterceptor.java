package com.kingray.web.interceptor;

import com.kingray.web.helper.ServletHelper;
import com.xiongyingqi.Logger;
import com.xiongyingqi.util.EntityHelper;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by blademainer<a href="http://xiongyingqi.com">xiongyingqi.com</a> on 2014/11/6 0006.
 */
@Component
public class CookieInterceptor extends HandlerInterceptorAdapter {
    private boolean enable = true;

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Logger.error("serverIp: " + ServletHelper.getServerHost(request));
        Logger.error("localIp: " + ServletHelper.getIp(request));

        if (enable) {
            String remoteAddr = request.getRemoteAddr();
            Logger.info("remoteAddr: " + remoteAddr);
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    EntityHelper.print("cookie.name: " + cookie.getName() + ", cookie.value: " + cookie.getValue());
                    Logger.info("cookie.name: " + cookie.getName() + ", cookie.value: " + cookie.getValue());
                }
            }
        }
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if(cookie != null){
                    cookie.setPath("/");// 重新设置uri，防止其他地址无法读取
                }
            }
        }

        return super.preHandle(request, response, handler);
    }
}
