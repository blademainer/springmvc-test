package com.kingray.support.login;

import com.kingray.support.login.annotation.LoginRequired;
import com.kingray.support.login.handler.LoginRequiredHandler;
import com.xiongyingqi.util.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Method;

@LoginRequired(false)
public class LoginRequiredHandlerTest {
    private LoginRequiredHandler loginRequiredHandler;

    @Before
    public void setUp() throws Exception {
        loginRequiredHandler = new LoginRequiredHandler();
        loginRequiredHandler.scan(this);
    }

    @LoginRequired
    @Test
    public void testIsRequireLogin() throws Exception {
        Method method = LoginRequiredHandlerTest.class.getDeclaredMethod("testIsRequireLogin");
        boolean requireLogin = loginRequiredHandler.isRequireLogin(method);
        Assert.isTrue(requireLogin);
        Method method2 = LoginRequiredHandlerTest.class.getDeclaredMethod("setUp");
        boolean requireLogin2 = loginRequiredHandler.isRequireLogin(method2);
        Assert.notTrue(requireLogin2);
    }
}