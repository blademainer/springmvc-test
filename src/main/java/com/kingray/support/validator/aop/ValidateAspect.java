package com.kingray.support.validator.aop;

import com.kingray.vo.CodeVo;
import com.kingray.web.context.WebContext;
import com.xiongyingqi.Logger;
import com.xiongyingqi.util.SpringMVCHelper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.PrintWriter;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import static com.xiongyingqi.util.EntityHelper.print;

/**
 * BindingResult自动检查
 * Created by blademainer<a href="http://xiongyingqi.com">xiongyingqi.com</a> on 2014/11/20 0020.
 */
@Aspect
public class ValidateAspect {
    @Pointcut("execution(* com.kingray..*Controller.*(..))")
    private void anyMethod() {
    }

    @Around("anyMethod()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        print("around");
        Method method = ((MethodSignature) pjp.getSignature()).getMethod();
        Annotation[][] parameterAnnotations = method.getParameterAnnotations();// 获取参数的注解

        try {
            for (int i = 0; i < parameterAnnotations.length; i++) {
                Annotation[] parameterAnnotation = parameterAnnotations[i];
                for (int i1 = 0; i1 < parameterAnnotation.length; i1++) {
                    print(parameterAnnotation[i1].annotationType());
                    if (parameterAnnotation[i1].annotationType() == Valid.class) {
                        if (i < parameterAnnotations.length - 1 && Errors.class.isAssignableFrom(method.getParameterTypes()[i + 1])) {
                            BindingResult bindingResult = (BindingResult) pjp.getArgs()[i + 1];
                            if (bindingResult.hasErrors()) {
                                CodeVo codeVo = SpringMVCHelper.builderBindingResult(bindingResult);
                                HttpServletResponse response = WebContext.getInstance().getResponse();
                                response.setContentType("application/json");
                                response.setCharacterEncoding("UTF-8");
                                //返回错误信息
                                PrintWriter out = response.getWriter();
                                out.print(codeVo.toJSON());
                                out.flush();
                                out.close();
                                return null;//CodeVo.NO_LOGIN_ERROR
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            Logger.error(e);
        }

        return pjp.proceed();

    }
}
