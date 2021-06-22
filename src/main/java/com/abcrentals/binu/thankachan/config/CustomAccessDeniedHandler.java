package com.abcrentals.binu.thankachan.config;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.access.AccessDeniedHandler;


/*
 * Class to handle access denied situations where a user is not authorized to access a resource
 * 
 * 
 * 
 */


public class CustomAccessDeniedHandler implements AccessDeniedHandler {

	private Logger logger = Logger.getLogger(getClass().getName());

    @Override
    public void handle(
      HttpServletRequest request,
      HttpServletResponse response, 
      AccessDeniedException exc) throws IOException, ServletException {
        
        Authentication auth 
          = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
        	logger.info("User: " + auth.getName() 
              + " attempted to access the protected URL: "
              + request.getRequestURI());
        }

        response.sendRedirect(request.getContextPath() + "/access-denied");
    }
}