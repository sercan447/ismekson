package com.ismek.config;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;


public class CustomBasicAuthenticationEntryPoint extends BasicAuthenticationEntryPoint {

	
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,AuthenticationException authException) throws IOException, ServletException {
		//super.commence(request, response, authException);
		
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
		response.addHeader("WWW-Authenticate","Basic realm="+getRealmName()+"");
		
		PrintWriter writer = response.getWriter();
		request.setCharacterEncoding("UTF8");
		writer.print("Bu Web Servislere Erisim için Authenticate islemleri erisim gerçeklestirilmektedir .: "+authException.getMessage());
		
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		//super.afterPropertiesSet();
		setRealmName("MY_TEST_REALM");
		
		
	}
	
}
