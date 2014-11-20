package com.kingray.support.login.handler;

import com.kingray.support.login.annotation.LoginRequired;
import com.xiongyingqi.util.AopTargetUtils;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;

/**
 * Created by qi on 2014/11/15 0015.
 */
@Component
public class LoginRequiredHandler implements ApplicationContextAware {
    protected Class<LoginRequired> supportAnnotation = LoginRequired.class;
    private Collection<Method> methods;

    public LoginRequiredHandler() {
        methods = new HashSet<Method>();
    }

    public void scan(Object o) {
        Class<?> aClass = o.getClass();
        try {
            aClass = AopTargetUtils.getTarget(o).getClass();// 获取真实对象
        } catch (Exception e) {
            e.printStackTrace();
        }

        Method[] declaredMethods = aClass.getDeclaredMethods();
        boolean typeAnnotationPresent = aClass.isAnnotationPresent(supportAnnotation);
        boolean typeLoginRequired = false;
        if (typeAnnotationPresent) {
            LoginRequired annotation = aClass.getAnnotation(supportAnnotation);
            typeLoginRequired = annotation.value();
        }
        for (Method declaredMethod : declaredMethods) {

            boolean methodAnnotationPresent = declaredMethod.isAnnotationPresent(supportAnnotation);
            boolean methodLoginRequired = false;
            if (methodAnnotationPresent) {
                LoginRequired loginRequired = declaredMethod.getAnnotation(supportAnnotation);
                methodLoginRequired = loginRequired.value();
            }
            if (methodLoginRequired) {// 如果方法上注解了LoginRequired，则加入methods
                methods.add(declaredMethod);
            } else {
                if (typeLoginRequired && !methodAnnotationPresent) {// 如果类上注解了LoginRequired为true且方法上没有注解，则加入methods
                    methods.add(declaredMethod);
                }
            }
        }
    }

    public boolean isRequireLogin(Method method) {
        return methods.contains(method);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Map<String, Object> beansWithAnnotation = applicationContext.getBeansWithAnnotation(Controller.class);
        for (Map.Entry<String, Object> stringObjectEntry : beansWithAnnotation.entrySet()) {
            Object value = stringObjectEntry.getValue();
            if (value != null) {
                scan(value);
            }
        }
    }

    public Collection<Method> getMethods() {
        return methods;
    }

    public Class<LoginRequired> getSupportAnnotation() {
        return supportAnnotation;
    }
}
