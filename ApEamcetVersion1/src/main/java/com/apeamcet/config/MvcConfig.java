package com.apeamcet.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.apeamcet.util.Constants;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {
    /*
     * (non-Javadoc)
     * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter#addViewControllers(org.springframework.web.servlet.config.annotation.ViewControllerRegistry)
     * The views are set to urls.
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/home").setViewName(Constants.VIEW_MAINHOME);
        registry.addViewController("/").setViewName(Constants.VIEW_MAINHOME);
        registry.addViewController("/adminhome").setViewName(Constants.VIEW_ADMINHOME);
        registry.addViewController("/login").setViewName(Constants.VIEW_LOGIN);
        registry.addViewController("/upload").setViewName(Constants.VIEW_DATAMANAGE);
        registry.addViewController("/error").setViewName(Constants.VIEW_ERROR);
    }

}
