/**
 * YIXUN_1.5_EE
 */
package com.kingray.filter;

import com.kingray.servlet.ResponseWrapper;
import com.xiongyingqi.util.StringHelper;
import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

/**
 * 跨域访问接口时，客户端的js一般会使用jsonp来进行访问，其中必定带着jsoncallback或者callback的参数传给后台<br>
 * 当后台响应数据时，js会再捕获该参数的值来判断是哪个函数发出的请求。<p>
 * 因此，后台一定要处理该参数，以便前台能正确的识别是哪个函数发起的请求
 *
 * @author 瑛琪 <a href="http://xiongyingqi.com">xiongyingqi.com</a>
 * @version 2013-9-24 上午9:56:23
 */
public class JSONCallBackFilter implements Filter {
    private static final Logger LOGGER = Logger.getLogger(JSONCallBackFilter.class);

    private String encoding = "UTF-8";
    private String callbackName = "jsoncallback";

    /**
     * <br>
     * 2013-9-24 上午10:04:02
     *
     * @see javax.servlet.Filter#destroy()
     */
    @Override
    public void destroy() {
    }

    /**
     * <br>
     * 2013-9-24 上午10:04:02
     *
     * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest,
     * javax.servlet.ServletResponse, javax.servlet.FilterChain)
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) {
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String jsonCallBack = request.getParameter(callbackName);
        if (jsonCallBack != null) {
            ResponseWrapper responseWrapper;
            try {
                responseWrapper = new ResponseWrapper(httpServletResponse);// 包装response，这样才能获取到servlet设置的页面内容
                try {
                    chain.doFilter(httpServletRequest, responseWrapper);
                } catch (ServletException e) {
                    e.printStackTrace();
                }
                String requestContentType = httpServletRequest.getContentType();
                String responseContentType = responseWrapper.getContentType();
                if (responseContentType != null
                        && (responseContentType.startsWith("application/json") || responseContentType
                        .startsWith("text/plain"))) {
                    String content = buildContent(jsonCallBack, httpServletRequest, responseWrapper);
                    reply(httpServletResponse, content);
                    return;
                }
                backStream(httpServletResponse, responseWrapper);
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {
            try {
                chain.doFilter(request, response);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ServletException e) {
                e.printStackTrace();
            }
        }

        //		ResponseWrapper responseWrapper = new ResponseWrapper(httpServletResponse);// 包装response，这样才能获取到servlet设置的页面内容
        //		chain.doFilter(request, responseWrapper);
        //
        //		String requestContentType = request.getContentType();
        //		String responseContentType = responseWrapper.getContentType();
        //
        //		EntityHelper.print(requestContentType);
        //		EntityHelper.print(responseContentType);
        //		if(responseContentType != null && responseContentType.startsWith("application/json") || responseContentType.startsWith("text/plain")){
        //			String content = buildContent(httpServletRequest, responseWrapper);
        //			reply(httpServletResponse, content);
        //			return;
        //		}
        //
        //		try {
        //			ServletOutputStream out = httpServletResponse.getOutputStream();
        //			out.write(responseWrapper.getResponseData());
        //			out.flush();
        //			out.close();
        //		} catch (Exception e2) {
        //			LOGGER.error(e2);
        //		}
    }

    private void backStream(HttpServletResponse httpServletResponse, ResponseWrapper responseWrapper) {
        try {
            ServletOutputStream out = httpServletResponse.getOutputStream();
            out.write(responseWrapper.getResponseData());
            out.flush();
            out.close();
        } catch (Exception e2) {
            LOGGER.error(e2);
        }
    }

    private void reply(HttpServletResponse httpServletResponse, Object object) {
        try {
            OutputStreamWriter w = new OutputStreamWriter(httpServletResponse.getOutputStream(),
                    encoding);
            PrintWriter out = new PrintWriter(w);
            out.print(object);
            out.flush();
            out.close();
        } catch (Exception e) {
            LOGGER.error(e);
            try {
                PrintWriter out = httpServletResponse.getWriter();
                out.print(object);
                out.flush();
                out.close();
            } catch (Exception e2) {
                LOGGER.error(e2);
            }
        }
    }

    private String buildContent(String jsonCallBack, HttpServletRequest request, ResponseWrapper responseWrapper)
            throws UnsupportedEncodingException, IOException {
        String content = new String(responseWrapper.getResponseData(), encoding);
        if (jsonCallBack == null) {
            return content;
        }

        StringBuilder builder = new StringBuilder();
        builder.append(jsonCallBack);
        builder.append("(");
        builder.append(content);
        builder.append(")");
        content = builder.toString();
        return content;
    }

    /**
     * <br>
     * 2013-9-24 上午10:04:02
     *
     * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
     */
    @Override
    public void init(FilterConfig config) throws ServletException {
        String encoding = config.getInitParameter("encoding");
        if (StringHelper.notNullAndNotEmpty(encoding)) {
            this.encoding = encoding;
        }
        String callbackName = config.getInitParameter("callbackName");
        if (StringHelper.notNullAndNotEmpty(callbackName)) {
            this.callbackName = callbackName;
        }
    }

}
