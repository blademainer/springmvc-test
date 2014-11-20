package com.kingray.filter;

import com.kingray.web.context.WebContext;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 每次访问都将request和response放入WebContext中，方便其他类调用
 * 
 * @author qi
 * 
 */
public class WebContextFilter implements Filter {
	private ServletContext servletContext;

	@Override
	public void init(FilterConfig config) throws ServletException {
		this.servletContext = config.getServletContext();
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		HttpSession session = httpServletRequest.getSession();
		WebContext.create(httpServletRequest, httpServletResponse, session, servletContext);
		chain.doFilter(httpServletRequest, httpServletResponse);
		WebContext.clear();
	}

	@Override
	public void destroy() {

	}

}
