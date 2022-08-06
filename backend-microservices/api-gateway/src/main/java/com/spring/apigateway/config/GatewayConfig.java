package com.spring.apigateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@Configuration
public class GatewayConfig {
	
	@Bean
	public RouteLocator myRoutes(RouteLocatorBuilder builder) {
	    return builder.routes()
	    		.route(p -> p.path("/component-processing/**")
	    				.filters(f -> f.rewritePath("/component-processing/(?<remaining>.*)",
	    											"/COMPONENT-PROCESSING-SERVICE/${remaining}"))
	    				.uri("lb://COMPONENT-PROCESSING-SERVICE"))
	    		
	    		.route(p -> p.path("/payment-processing/**")
	    				.filters(f -> f.rewritePath("/payment-processing/(?<remaining>.*)",
	    											"/COMPONENT-PROCESSING-SERVICE/${remaining}"))
	    				.uri("lb://COMPONENT-PROCESSING-SERVICE"))
	    		
	    		.route(p -> p.path("/authenticate/**")
	    				.filters(f -> f.rewritePath("/authenticate/(?<remaining>.*)",
	    											"/AUTHORIZATION-SERVICE/${remaining}"))
	    				.uri("lb://AUTHORIZATION-SERVICE"))
	    		
	    		.route(p -> p.path("/validate/**")
	    				.filters(f -> f.rewritePath("/validate/(?<remaining>.*)",
	    											"/AUTHORIZATION-SERVICE/${remaining}"))
	    				.uri("lb://AUTHORIZATION-SERVICE"))
	    		
	    		
	    		.build();
	}

}
