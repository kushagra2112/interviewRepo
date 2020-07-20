package com.xangars.interview.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xangars.interview.exceptions.TokenNotValidException;
import com.xangars.interview.model.CustomerPolicy;
import com.xangars.interview.model.OtpLogger;
import com.xangars.interview.repository.OtpLoggerRepository;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtUtil {
	private static final Logger logger = LogManager.getLogger();
	
	@Autowired
	OtpLoggerRepository otpLogger;

    private String secret = "interview";
    private String secret2  = "longInterview";

    public String extractUsername(String token, int tokenType) {
    	try {
    		return extractClaim(token, Claims::getSubject, tokenType);
    	}catch(Exception e) {
    		throw new TokenNotValidException("Token not valid or expired");
    	}
    }

    public Date extractExpiration(String token, int index) {
    	try {
    		return extractClaim(token, Claims::getExpiration, index);
    	}catch(Exception e) {
    		throw new TokenNotValidException("Token not valid or expired");
    	}
        
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver, int index) {
    	try {
	    	if(index  == 1) {
	    		final Claims claims = extractAllClaims(token);
	            return claimsResolver.apply(claims);
	    	}else {
	    		final Claims claims = extractAllClaims2(token);
	            return claimsResolver.apply(claims);
	    	}
    	}catch(Exception e) {
    		throw new TokenNotValidException("Token not valid or expired");
    	}
        
    }
    private Claims extractAllClaims(String token) {
    	try {
    		return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    	}catch(Exception e) {
    		throw new TokenNotValidException("Token not valid or expired");
    	}
    }
    
    private Claims extractAllClaims2(String token) {
    	try {
    		return Jwts.parser().setSigningKey(secret2).parseClaimsJws(token).getBody();
    	}catch(Exception e) {
    		throw new TokenNotValidException("Token not valid or expired");
    	}
    }

    private boolean isTokenExpired(String token, int tokenType) {
    	return extractExpiration(token, tokenType).before(new Date());
    }

    public String generateToken(OtpLogger otpLogger) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, otpLogger);
    }

    private String createToken(Map<String, Object> claims, OtpLogger otpLogger) {
    	logger.info(otpLogger.toString());
        return Jwts.builder().setClaims(claims).setSubject(otpLogger.getMobileNumber()+"").setIssuedAt(otpLogger.getCreatedTime())
                .setExpiration(otpLogger.getExpireTime())
                .signWith(SignatureAlgorithm.HS256, secret).compact();
    }
    
    public String generateRefreshToken(OtpLogger otpLogger) {
        Map<String, Object> claims = new HashMap<>();
        return createRefreshToken(claims, otpLogger);
    }

    private String createRefreshToken(Map<String, Object> claims, OtpLogger otpLogger) {
    	logger.info(otpLogger.toString());
        return Jwts.builder().setClaims(claims).setSubject(otpLogger.getMobileNumber()+"").setIssuedAt(otpLogger.getCreatedTime())
                .setExpiration(otpLogger.getExpireTime())
                .signWith(SignatureAlgorithm.HS512, secret2).compact();
    }

   /* public Boolean validateToken(String token, UserDetails userDetails, int tokeyType) {
        final String mobileNumber = extractUsername(token, tokeyType);
        return (mobileNumber.equals(userDetails.getUsername()) && !isTokenExpired(token, tokeyType));
    }*/
    
    public Boolean validateToken(String token, CustomerPolicy customerDetails, int tokeyType) {
        final String mobileNumber = extractUsername(token, tokeyType);
        return (mobileNumber.equals(customerDetails.getMobileNumber()+"") && !isTokenExpired(token, tokeyType));
    }
}