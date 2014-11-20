package com.kingray.event.login;

import com.kingray.hibernate.domain.PUser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 登录事件
 * Created by 瑛琪<a href="http://xiongyingqi.com">xiongyingqi.com</a> on 2014/8/11 0011.
 */
public interface LoginObserver {
    /**
     * 用户登录事件
     *
     * @param user
     * @param request
     * @param response
     * @param session
     */
    public void userLogin(PUser user, HttpServletRequest request, HttpServletResponse response, HttpSession session);

    /**
     * 用户注销事件
     *
     * @param user
     * @param request
     * @param response
     * @param session
     */
    public void userLogout(PUser user, HttpServletRequest request, HttpServletResponse response, HttpSession session);


}
