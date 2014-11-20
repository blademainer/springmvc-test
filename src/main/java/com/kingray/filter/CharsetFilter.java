package com.kingray.filter;

import javax.servlet.*;
import java.io.IOException;

public class CharsetFilter implements Filter {

	private String encoding;

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println(request);
		System.out.println("request.getCharacterEncoding() =========== "
				+ request.getCharacterEncoding());
		request.setCharacterEncoding(encoding);
		response.setCharacterEncoding(encoding);
		System.out.println("request.getCharacterEncoding() after =========== "
				+ request.getCharacterEncoding());
		chain.doFilter(request, response);

	}

	public void init(FilterConfig config) throws ServletException {
		encoding = config.getInitParameter("encoding");
		if (encoding == null || "".equals(encoding.trim())) {
			encoding = "UTF-8";
		}
		// encoding = config.getServletContext().getInitParameter("encoding");
	}

}
