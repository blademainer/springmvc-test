package com.kingray.event.login;

import com.kingray.hibernate.domain.PUser;
import com.kingray.vo.CodeVo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 登录拦截器
 * Created by 瑛琪<a href="http://xiongyingqi.com">xiongyingqi.com</a> on 2014/8/11 0011.
 */
public interface LoginInterceptor {

    /**
     * 获取优先级，数字越小优先级越大
     *
     * @return
     */
    public int getPriority();

    /**
     * 登录拦截事件
     *
     * @param user
     * @param request
     * @param response
     * @param session
     * @return 如果通过，则返回null或{@link com.kingray.vo.CodeVo#SUCCESS}，否则返回错误原因
     */
    public CodeVo canLogin(PUser user, HttpServletRequest request, HttpServletResponse response, HttpSession session);
}
