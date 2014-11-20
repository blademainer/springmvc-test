package com.kingray.event.login;

import com.kingray.hibernate.domain.PUser;
import com.kingray.vo.CodeVo;
import com.xiongyingqi.util.Judgment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by 瑛琪<a href="http://xiongyingqi.com">xiongyingqi.com</a> on 2014/8/11 0011.
 */
@Component
public class LoginSubject {
    @Autowired(required = false)
    private Collection<LoginObserver> loginObservers;

    @Autowired(required = false)
    private ArrayList<LoginInterceptor> loginInterceptors;

    /**
     * 通知登录事件
     *
     * @param user
     * @param request
     * @param response
     * @param session
     */
    public void notifyUserLogin(PUser user, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        if (Judgment.notEmpty(loginObservers)) {
            for (LoginObserver loginObserver : loginObservers) {
                if (Judgment.isNull(loginObserver)) {
                    continue;
                }
                try {
                    loginObserver.userLogin(user, request, response, session);
                } catch (Exception e) {
                }
            }
        }
    }

    /**
     * 通知注销事件
     *
     * @param user
     * @param request
     * @param response
     * @param session
     */
    public void notifyUserLogout(PUser user, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        if (Judgment.notEmpty(loginObservers)) {
            for (LoginObserver loginObserver : loginObservers) {
                if (Judgment.isNull(loginObserver)) {
                    continue;
                }
                try {
                    loginObserver.userLogout(user, request, response, session);
                } catch (Exception e) {
                }
            }
        }
    }

    /**
     * 通知拦截链
     *
     * @param user
     * @param request
     * @param response
     * @param session
     * @return 如果通过，则返回null或{@link com.kingray.vo.CodeVo#SUCCESS}，否则返回错误原因{@link com.kingray.vo.CodeVo}
     * @see com.kingray.vo.CodeVo
     */
    public CodeVo notifyLoginInterceptor(PUser user, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        if (Judgment.notEmpty(loginInterceptors)) {
            Collections.sort(loginInterceptors, new Comparator<LoginInterceptor>() {
                @Override
                public int compare(LoginInterceptor o1, LoginInterceptor o2) {
                    if (!Judgment.notNull(o1, o2)) {// 如果有null对象，则不用比较
                        return 0;
                    }
                    return o1.getPriority() - o2.getPriority();
                }
            });


            for (LoginInterceptor loginInterceptor : loginInterceptors) {
                if (Judgment.isNull(loginInterceptor)) {
                    continue;
                }
                try {
                    CodeVo codeVo = loginInterceptor.canLogin(user, request, response, session);
                    if (codeVo != null && codeVo != CodeVo.SUCCESS) {
                        return codeVo;
                    }
                } catch (Exception e) {
                }
            }
        }
        return CodeVo.SUCCESS;
    }


}
