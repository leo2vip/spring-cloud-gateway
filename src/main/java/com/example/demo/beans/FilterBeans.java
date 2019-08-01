package com.example.demo.beans;

import com.example.demo.filter.HostAddrKeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 拦截器bean
 */
@Configuration
public class FilterBeans {
    /**
     * ip拦截
     * @return
     */
    @Bean
    public HostAddrKeyResolver hostAddrKeyResolver() {
        return new HostAddrKeyResolver();
    }
}
