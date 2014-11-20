package com.kingray.json.filter.aop;

import com.xiongyingqi.jackson.FilterPropertyHandler;
import com.xiongyingqi.jackson.impl.JavassistFilterPropertyHandler;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;

/**
 * @author 瑛琪 <a href="http://xiongyingqi.com">xiongyingqi.com</a>
 * @version 2013-9-27 下午5:41:12
 */
@Aspect
public class IgnorePropertyAspect {
    public static final Logger LOGGER = Logger.getLogger(IgnorePropertyAspect.class);

    @Pointcut("execution(* com.kingray.web.*.*(..))")
    private void anyMethod() {

    }

    @Around("anyMethod()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        Object returnVal = pjp.proceed(); // 返回源结果
        try {
            FilterPropertyHandler filterPropertyHandler = new JavassistFilterPropertyHandler(true);
            Method method = ((MethodSignature) pjp.getSignature()).getMethod();
            returnVal = filterPropertyHandler.filterProperties(method, returnVal);
        } catch (Exception e) {
            LOGGER.error(e);
            e.printStackTrace();
        }

        return returnVal;
    }

    @AfterThrowing(pointcut = "anyMethod()", throwing = "e")
    public void doAfterThrowing(Exception e) throws Exception {
        System.out.println(" -------- AfterThrowing -------- ");
        throw new Exception(e);
    }
}
