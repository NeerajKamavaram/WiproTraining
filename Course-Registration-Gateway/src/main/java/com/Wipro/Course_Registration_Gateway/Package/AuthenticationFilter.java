package com.Wipro.Course_Registration_Gateway.Package;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.stereotype.Component;


@Component
public class AuthenticationFilter extends AbstractGatewayFilterFactory<AuthenticationFilter.Config>
{
	@Autowired
	private com.Wipro.Course_Registration_Gateway.Util.JwtUtil jwtUtil;
		
	@Autowired
	private com.Wipro.Course_Registration_Gateway.Util.RouterValidater validator;
	
	public AuthenticationFilter() 
	{
		super(Config.class);
	}

	public static class Config {

	}

	@Override
	public GatewayFilter apply(Config config)
	{
		
		return ((exchange, chain) -> {
			if (validator.isSecured.test((ServerHttpRequest) exchange.getRequest())) {
				// header contains token or not
				if (!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
					throw new RuntimeException("missing authorization header");
				}

				String authHeader = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);
				if (authHeader != null && authHeader.startsWith("Bearer ")) {
					authHeader = authHeader.substring(7);
				}
				try
				{
//	                    //REST call to AUTH service
//	                    template.getForObject("http://IDENTITY-SERVICE//validate?token" + authHeader, String.class);
					jwtUtil.validateToken(authHeader);

				} catch (Exception e) 
				{
					System.out.println("invalid access...!");
					throw new RuntimeException("un authorized access to application");
				}
			}
			return chain.filter(exchange);
		});
	}
}
