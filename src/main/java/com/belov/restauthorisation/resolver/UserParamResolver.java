package com.belov.restauthorisation.resolver;

import com.belov.restauthorisation.model.User;
import jakarta.validation.Valid;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

public class UserParamResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        //резолвер будет применен к параметрам метода в том случае, если они аннататированы @UserParam
        return parameter.hasParameterAnnotation(UserParam.class);
    }

    @Override
    public User resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        String name = webRequest.getParameter("user");
        String password = webRequest.getParameter("password");
        return new User( name, password);
    }
}