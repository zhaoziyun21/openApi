package com.hualala.api.config;

import com.hualala.api.filter.CrosFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {
    @Autowired
    private CrosFilter crosFilter;

    @Bean
    public FilterRegistrationBean registerCrosFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(crosFilter);
        registration.addUrlPatterns("/*");
        registration.setName("crosFilter");
        registration.setOrder(1);  //值越小，Filter越靠前。
        return registration;
    }

    //如果有多个Filter，再写一个public FilterRegistrationBean registerOtherFilter(){...}即可。
}
