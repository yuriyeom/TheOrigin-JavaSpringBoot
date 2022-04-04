package dev.glassym.gateway.routes;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RoutingConfig {
    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder){
        return builder.routes()
                .route("community-shop", predicate -> predicate
                            .path("/api/shop/**") // 이 경로로 루트가 작동한다.
                            .filters(filter -> filter
                                        .rewritePath(
                                                "/api/(?<path>.*)",
                                                "/${path}"
                                        ))
                            .uri("http://localhost:8081")) // 이 뒤에 요청이 들어왔던 경로가 붙는다.
                .build();
    }
}
