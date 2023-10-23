package com.belov.restauthorisation;

import com.belov.restauthorisation.resolver.UserParamResolver;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration      // без этой аннотации почему-то не будет регистрации резолвера
public class CustomWebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new UserParamResolver());
    }
}