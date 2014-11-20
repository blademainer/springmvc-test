/**
 * YIXUN_1.5_EE
 */
package com.kingray.session;

import com.xiongyingqi.util.EntityHelper;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.Collection;
import java.util.LinkedList;

/**
 * @author 瑛琪 <a href="http://xiongyingqi.com">xiongyingqi.com</a>
 * @version 2013-11-7 下午5:17:10
 */
@Component
public class UserSessionListener implements HttpSessionListener {
	private static Collection<HttpSession> sessions = new LinkedList<HttpSession>();

	/**
	 * <br>
	 * 2013-11-7 下午5:18:59
	 * 
	 * @see javax.servlet.http.HttpSessionListener#sessionCreated(javax.servlet.http.HttpSessionEvent)
	 */
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		EntityHelper.print("sessionCreated");
		sessions.add(se.getSession());
	}

	/**
	 * <br>
	 * 2013-11-7 下午5:18:59
	 * 
	 * @see javax.servlet.http.HttpSessionListener#sessionDestroyed(javax.servlet.http.HttpSessionEvent)
	 */
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		sessions.remove(se.getSession());
	}

	/**
	 * Collection<HttpSession>
	 * 
	 * @return the sessions
	 */
	public static Collection<HttpSession> getSessions() {
		return sessions;
	}

}
