package com.example.config;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

@Configuration
public class ContainerConfig implements WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> {

    @Bean
    @Override
    public void customize(ConfigurableServletWebServerFactory factory) {
        factory.addErrorPages(new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/error/500"));
        factory.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/error/404"));
    }

//    @Bean
//    @Override
//    public void customize(TomcatServletWebServerFactory factory) {
//        factory.addErrorPages(new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/error/500"));
//        factory.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/error/404"));
//    }
}
