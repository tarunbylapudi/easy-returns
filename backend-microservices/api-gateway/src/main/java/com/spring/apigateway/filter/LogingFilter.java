package com.spring.apigateway.filter;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;


@Component
public class LogingFilter implements GlobalFilter{
	
	Logger logger=LoggerFactory.getLogger(LogingFilter.class);

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		
		logger.info("Request initiated to ---> {}", exchange.getRequest().getPath());
		
		return chain.filter(exchange);
	}

}
