package com.esgi.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by alex on 29/05/2016.
 */

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //registry.addViewController("/home").setViewName("home");
        registry.addViewController("/").setViewName("home.html");
        //
        //registry.addViewController("/connexion").setViewName("login.html");

    }

     @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
        registry.addResourceHandler("/static/**").addResourceLocations("/static/");
        registry.addResourceHandler("/static/css/**").addResourceLocations("/static/css/");
        registry.addResourceHandler("/static/images/**").addResourceLocations("/static/images/");
        registry.addResourceHandler("/static/js/**").addResourceLocations("/static/js/");
        registry.addResourceHandler("/static/views/**").addResourceLocations("/static/views/");
    }

}
