package com.revature.security;

import java.util.Date;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class JwtGenerator {
	
	public static String createJwt(Principal principal) {
		
		log.info("Creating JWT for: " + principal.getSubject());
		
		SignatureAlgorithm sigAlg = SignatureAlgorithm.HS256;
		long nowMillis = System.currentTimeMillis();
		
		JwtBuilder builder = Jwts.builder()
				.setId(Integer.toString(principal.getId()))
				.setSubject(principal.getSubject())
				.setIssuer("revature")
				.claim("role", principal.getRole())
				.setExpiration(new Date(nowMillis + JwtConfig.EXPIRATION))
				.signWith(sigAlg, JwtConfig.SIGNING_KEY);
		
		log.info("JWT successfully created for: " + principal.getSubject());
		return builder.compact();
		
	}
}
