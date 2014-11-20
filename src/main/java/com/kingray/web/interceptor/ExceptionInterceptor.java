/**
 * YIXUN_1.5_EE
 */
package com.kingray.web.interceptor;

import com.kingray.vo.CodeVo;
import com.kingray.web.exception.ValidateException;
import com.xiongyingqi.Logger;
import com.xiongyingqi.util.StackTraceHelper;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 错误拦截器，用于捕获抛出的运行时错误springmvc
 * 
 * @author 瑛琪 <a href="http://xiongyingqi.com">xiongyingqi.com</a>
 * @version 2013-10-15 上午10:26:26
 */
@Component
public class ExceptionInterceptor extends HandlerInterceptorAdapter {

	/**
	 * <br>
	 * 2013-10-15 上午10:27:30
	 * 
	 * @throws Exception
	 * 
	 * @see org.springframework.web.servlet.handler.HandlerInterceptorAdapter#afterCompletion(javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse, Object,
	 *      Exception)
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
			Object handler, Exception ex) {
		//		System.out.println(" ------------------- afterCompletion ------------------- ");
		//		EntityHelper.print(request);
		//		EntityHelper.print(response);
		//		EntityHelper.print(handler);
		//		EntityHelper.print(ex);
		if (ex != null) {
            Logger.error(this, ex.getMessage(), ex.getCause());
			response.setStatus(HttpServletResponse.SC_OK);
			response.setContentType("application/json");
			PrintWriter out = null;

			try {
				out = response.getWriter();
				if (ex instanceof ValidateException) {
					out.print(ex.getMessage());
				} else {
					CodeVo codeVo = new CodeVo(CodeVo.SERVER_ERROR.getResultCode(),
							CodeVo.SERVER_ERROR.getResultName(),
							CodeVo.SERVER_ERROR.getResultValue(),
							CodeVo.SERVER_ERROR.getResultReason());
					codeVo.setResultName(ex.getMessage());
					codeVo.setResultValue(ex.getCause() + "");
					codeVo.setResultReason(StackTraceHelper.buildStackTrace(ex.getStackTrace()));
					out.print(codeVo.toJSON());
				}
			} catch (IOException e) {
                Logger.error(this, e.getMessage(), e.getCause());
				e.printStackTrace();
			} finally {
				out.flush();
				out.close();
			}
		}
		//		try {
		//			super.afterCompletion(request, response, handler, ex);
		//		} catch (Exception e) {
		//			e.printStackTrace();
		//		}
	}
}
