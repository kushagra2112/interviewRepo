package com.tata.aia.filter;


import com.tata.aia.exceptions.TokenNotValidException;
import com.tata.aia.service.OtpLoggerServiceImp;
import com.tata.aia.service.JwtUtil;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtFilter extends OncePerRequestFilter {
	private static final Logger logger = LogManager.getLogger();
	
    @Autowired
    private JwtUtil jwtUtil;
    
    @Autowired
    private OtpLoggerServiceImp service;


    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {

        String authorizationHeader = httpServletRequest.getHeader("Authorization");
        
        int tokenType =1;
        try{
        	if(httpServletRequest.getHeader("TokenType") != null) {
        		tokenType =2;
        	}else {
        		tokenType = 1;
        	}
        }catch(Exception e) {
        	tokenType = 1;
        }

        String token = null;
        String userName = null;

        if (authorizationHeader != null) {
            token = authorizationHeader;
            try {
            	userName = jwtUtil.extractUsername(token, tokenType);
            }catch(Exception e){
            	logger.error(e.getMessage());
            }
            
            logger.info("Decripted User name in the request : " ,  userName);
        }

        if (userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {

            UserDetails userDetails = service.loadUserByUsername(Long.parseLong(userName));
            try {
            	if (jwtUtil.validateToken(token, userDetails, tokenType)) {

                    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                            new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    usernamePasswordAuthenticationToken
                            .setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
                    SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
                }else {
                	throw new TokenNotValidException("Token is not valid");
                }
            }catch(Exception e) {
            	throw new TokenNotValidException("Token is not valid");
            }
            
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}

