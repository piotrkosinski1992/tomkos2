package com.tomkos2.cart.app.web.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import javax.servlet.http.HttpServletRequest;
import org.springframework.core.MethodParameter;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

public class WithUserHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {

    private final Environment environment;

    public WithUserHandlerMethodArgumentResolver(
        Environment environment) {
        this.environment = environment;
    }

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(WithUser.class) &&
                parameter.getParameterType().equals(UserInfo.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter,
                                  ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest,
                                  WebDataBinderFactory binderFactory) throws Exception {

        HttpServletRequest httpServletRequest = (HttpServletRequest) webRequest.getNativeRequest();
        String authorizationHeader = httpServletRequest.getHeader("Authorization");
        authorizationHeader = authorizationHeader.replace("Bearer ", "");
        Claims claims = Jwts.parser()
                .setSigningKey(environment.getProperty("token.secret"))
                .parseClaimsJws(authorizationHeader).getBody();
        String name = (String) claims.get("sub");
        return new UserInfo(name);
    }
}
