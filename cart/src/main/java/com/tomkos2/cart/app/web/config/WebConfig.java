package com.tomkos2.cart.app.web.config;

import java.util.List;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

  private final Environment environment;

  public WebConfig(Environment environment) {
    this.environment = environment;
  }

  @Override
  public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
    resolvers.add(new WithUserHandlerMethodArgumentResolver(environment));
  }
}
