package com.kingray.event.user;

import com.kingray.hibernate.domain.PUser;
import com.xiongyingqi.util.Judgment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Collection;

/**
 * Created by blademainer<a href="http://xiongyingqi.com">xiongyingqi.com</a> on 2014/11/17 0017.
 */
@Component
public class UserSubject {
    @Autowired(required = false)
    private Collection<UserObserver> userObservers;


    public void notifyUserDeleted(PUser user, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        if (Judgment.notEmpty(userObservers)) {
            for (UserObserver userObserver : userObservers) {
                if (Judgment.isNull(userObserver)) {
                    continue;
                }
                try {
                    userObserver.userDeleted(user, request, response, session);
                } catch (Exception e) {
                }
            }
        }
    }

    public void notifyUserAdded(PUser user, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        if (Judgment.notEmpty(userObservers)) {
            for (UserObserver userObserver : userObservers) {
                if (Judgment.isNull(userObserver)) {
                    continue;
                }
                try {
                    userObserver.userAdded(user, request, response, session);
                } catch (Exception e) {
                }
            }
        }
    }

    public void notifyUserUpdated(PUser user, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        if (Judgment.notEmpty(userObservers)) {
            for (UserObserver userObserver : userObservers) {
                if (Judgment.isNull(userObserver)) {
                    continue;
                }
                try {
                    userObserver.userUpdated(user, request, response, session);
                } catch (Exception e) {
                }
            }
        }
    }
}
