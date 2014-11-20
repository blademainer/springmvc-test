package com.kingray.support.login.annotation;

import java.lang.annotation.*;

/**
 * 标志Controller方法必须登录才能访问
 * Created by qi on 2014/11/15 0015.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(value = {ElementType.TYPE, ElementType.METHOD})
public @interface LoginRequired {
    boolean value() default true;
}
