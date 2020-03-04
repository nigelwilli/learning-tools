package com.revature.web.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.security.JwtConfig;
import com.revature.security.Principal;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;

@WebFilter("/*")
public class AppPreFilter extends HttpFilter {

	private static final long serialVersionUID = 1L;
	private static Logger log = LogManager.getLogger(AppPreFilter.class);
	
	@Override
	public void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain) throws IOException, ServletException {
		log.info("Request intercepted by TokenAuthFilter.doFilter");
		extractPrincipal(req);
		chain.doFilter(req, resp);
		return;
	}
	
	/**
	 * Obtains the token from the Authorization header of the request object,
	 * validates and parses it to extract the payload (a Principal object) - 
	 * which is attached to the request object as an attribute called "principal".
	 * 
	 * If no token is present, no action is taken. The request object is not manipulated
	 * in any way. 
	 * 
	 * @param req
	 * @throws IOException
	 * @throws ServletException
	 */
	public void extractPrincipal(HttpServletRequest req) throws IOException, ServletException {
		log.info("Attempting to extract principal object from JWT...");
		String header = req.getHeader(JwtConfig.HEADER);
		
		if(header == null || !header.startsWith(JwtConfig.PREFIX)) {
			log.info("No token found with required prefix");
			return;
		}
		
		String token = header.replaceAll(JwtConfig.PREFIX, "");
		
		try {
			
			Claims claims = Jwts.parser()
					.setSigningKey(JwtConfig.SIGNING_KEY)
					.parseClaimsJws(token)
					.getBody();
			
			Principal principal = new Principal();
			principal.setId(Integer.parseInt(claims.getId()));
			principal.setSubject(claims.getSubject());
			principal.setRole(claims.get("role", String.class));
			
			req.setAttribute("principal", principal);
			
		} catch (ExpiredJwtException eje) {
			log.info("JWT expired. Reauthentication required.");
		} catch (Exception e) {
			log.error("Error parsing JWT");
			e.printStackTrace();
		}
		
	}

}
