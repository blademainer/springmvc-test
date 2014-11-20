package com.kingray.spring.mvc.method.annotation;

import com.xiongyingqi.util.EntityHelper;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.annotation.ErrorsMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * Created by blademainer<a href="http://xiongyingqi.com">xiongyingqi.com</a> on 2014/11/20 0020.
 */
public class MyErrorsMethodArgumentResolver extends ErrorsMethodArgumentResolver {

    public MyErrorsMethodArgumentResolver() {
        super();
    }

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return super.supportsParameter(parameter);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory){
        EntityHelper.print(parameter);
        EntityHelper.print(mavContainer);
        EntityHelper.print(webRequest);
        EntityHelper.print(binderFactory);

        try {
            return super.resolveArgument(parameter, mavContainer, webRequest, binderFactory);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
