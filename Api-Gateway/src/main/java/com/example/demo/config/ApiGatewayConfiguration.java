package com.example.demo.config;

import java.util.function.Function;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
    	
        return builder.routes()
                .route("event-service-route", r -> r
                        .path("/api/events/**")
                        .uri("lb://event-service"))
                
                .route("user-service-route", r -> r
                        .path("/api/users/**")
                        .uri("lb://user-service"))
                
                .route("ticket-service-route", r -> r
                        .path("/api/tickets/**")
                        .uri("lb://ticket-service"))            
                .build();
    }
}
