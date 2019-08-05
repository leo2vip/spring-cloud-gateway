package com.example.demo.beans;

import com.example.demo.filter.HostAddrKeyResolver;
import com.example.demo.filter.UriKeyResolver;
import com.example.demo.filter.UserKeyResolver;
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
//    @Bean
//    public HostAddrKeyResolver hostAddrKeyResolver() {
//        return new HostAddrKeyResolver();
//    }

    /**
     * uri限流
     * @return
     */
    @Bean
    public UriKeyResolver uriKeyResolver() {
        return new UriKeyResolver();
    }

    /**
     * 用户key限流
     * @return
     */
    @Bean
    public UserKeyResolver userKeyResolver() {
        return new UserKeyResolver();
    }
}
