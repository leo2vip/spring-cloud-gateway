package com.example.demo.route;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.RewritePathGatewayFilterFactory;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.GatewayFilterSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.gateway.route.builder.UriSpec;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class GatewayRoutes {
    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {
        //实现方式2
        //配置过滤规则
        RewritePathGatewayFilterFactory.Config config = new RewritePathGatewayFilterFactory.Config();
        config.setRegexp("/api-b/(?<segment>.*)");
        config.setReplacement("/${segment}");
        GatewayFilter filter = new RewritePathGatewayFilterFactory()
                .apply(config);
        Function<GatewayFilterSpec, UriSpec> fn = gatewayFilterSpec -> gatewayFilterSpec.filter(filter);
        //http://localhost:7777/api-b/webapp-admin/dimensionWeb/selectRootList
        return builder.routes()
                //basic proxy
                .route(r -> r.path("/api-b/**")
                        //导入配置
                        .filters(fn)
                        .uri("lb://webapp-admin")
                ).build();
    }
}
