package com.ismek.exphandler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.access.AccessDeniedHandler;

import com.fasterxml.jackson.databind.ObjectMapper;


public class CustomAccessDeniedHandler implements AccessDeniedHandler {

	@Override
	public void handle(HttpServletRequest req, HttpServletResponse res, AccessDeniedException arg2) throws IOException, ServletException {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		if(auth != null) {
			System.out.println("name : "+auth.getName()+"\n protected URI : "+req.getRequestURI());
		}
		res.sendRedirect(req.getContextPath()+"/hata");
		
	}

}
