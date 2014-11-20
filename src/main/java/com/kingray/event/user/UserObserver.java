package com.kingray.event.user;

import com.kingray.hibernate.domain.PUser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by blademainer<a href="http://xiongyingqi.com">xiongyingqi.com</a> on 2014/11/17 0017.
 */
public interface UserObserver {
    /**
     * 用户删除事件
     * @param user
     */
    public void userDeleted(PUser user, HttpServletRequest request, HttpServletResponse response, HttpSession session);

    /**
     * 用户注册事件
     * @param user
     */
    public void userAdded(PUser user, HttpServletRequest request, HttpServletResponse response, HttpSession session);

    /**
     * 用户更新事件
     * @param user
     */
    public void userUpdated(PUser user, HttpServletRequest request, HttpServletResponse response, HttpSession session);


}
