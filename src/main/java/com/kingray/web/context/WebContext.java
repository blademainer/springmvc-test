package com.kingray.web.context;

import com.kingray.web.exception.WebContextAlreadyClearedException;
import com.kingray.web.helper.ServletHelper;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class WebContext {
    /**
     * 局部线程实例
     */
    private static ThreadLocal<WebContext> local = new ThreadLocal<WebContext>();
    private HttpServletRequest request;
    private HttpServletResponse response;
    private ServletContext context;
    private HttpSession session;

    public HttpServletRequest getRequest() {
        return request;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    public HttpServletResponse getResponse() {
        return response;
    }

    public void setResponse(HttpServletResponse response) {
        this.response = response;
    }

    public ServletContext getContext() {
        return context;
    }

    public void setContext(ServletContext context) {
        this.context = context;
    }

    /**
     * HttpSession
     *
     * @return the session
     */
    public HttpSession getSession() {
        return session;
    }

    /**
     * HttpSession
     *
     * @param session the session to set
     */
    public void setSession(HttpSession session) {
        this.session = session;
    }

    /**
     * 获取当前线程的上下文对象<br>
     * 如果当前线程在调用本方法之前已经有调用过WebContext.clear()方法，线程内的持有对象都已经被清楚，本方法将会抛出异常 。<br>
     * 例如以下代码，如果先调用a方法再调用b方法，那么就会抛出异常<br>
     * <b>注意：在Servlet返回响应时，轮到WebContextFilter过滤时，WebContextFilter会调用clear方法</b>
     * 2013-11-7 下午9:58:47
     * <p/>
     * <pre>
     * public void a() {
     * 	WebContext context = WebContext.getInstance();
     * 	//do something....
     * 	WebContext.clear();
     * }
     *
     * public void b() {
     * 	WebContext.getInstance();
     * }
     * </pre>
     *
     * @return
     * @throws WebContextAlreadyClearedException
     * @see #clear()
     * @see com.kingray.filter.WebContextFilter#doFilter(javax.servlet.ServletRequest,
     * javax.servlet.ServletResponse, javax.servlet.FilterChain)
     */
    public static WebContext getInstance() throws WebContextAlreadyClearedException {
        WebContext instance = local.get();
        if (instance == null) {
            throw new WebContextAlreadyClearedException();
        }
        return instance;
    }

    private WebContext(HttpServletRequest request, HttpServletResponse response,
                       HttpSession session, ServletContext context) {
        this.request = request;
        this.response = response;
        this.session = session;
        this.context = context;
    }

    /**
     * 在线程内创建实例 <br>
     * 2013-11-7 下午10:23:14
     *
     * @param request
     * @param response
     * @param session
     * @param context
     */
    public static void create(HttpServletRequest request, HttpServletResponse response,
                              HttpSession session, ServletContext context) {
        WebContext webContext = new WebContext(request, response, session, context);
        local.set(webContext);
    }

    public String getIp() {
        return ServletHelper.getIp(request);
    }

    /**
     * 清除线程内保存的对象，如果线程内还有对象调用了WebContext.getInstance则会抛出异常 <br>
     * 2013-11-7 下午9:52:52
     */
    public static void clear() {
        local.set(null);// 调用了clear方法，那么给标志设置为true，如果线程内还有对象调用了WebContext.getInstance则会抛出异常
    }

}
