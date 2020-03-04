package com.revature.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.revature.dtos.Principal;
import com.revature.security.JwtConfig;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Component
@WebFilter("/*")
public class AuthFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse resp, FilterChain chain) throws ServletException, IOException {

        String header = req.getHeader(JwtConfig.HEADER);

        if (header == null || !header.startsWith(JwtConfig.PREFIX)) {
            chain.doFilter(req, resp);
            return;
        }

        String token = header.replaceAll(JwtConfig.PREFIX, "");

        Claims claims = Jwts.parser()
                .setSigningKey(JwtConfig.SECRET.getBytes())
                .parseClaimsJws(token)
                .getBody();

        int id = Integer.parseInt(claims.getId());
        String username = claims.getSubject();
        String role = claims.get("role", String.class);
        Principal principal = new Principal(id, username, role);
        req.setAttribute("principal", principal);
    
        chain.doFilter(req, resp);
        
    }

}