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

@WebFilter(
	filterName = "CorsFilter",
	servletNames = {"DispatcherServlet"}
)
public class CorsFilter extends HttpFilter {

	private static final long serialVersionUID = 5732793226953410454L;
	private static Logger log = LogManager.getLogger(CorsFilter.class);
	
	@Override
	protected void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain) throws IOException, ServletException {
		log.info("Request intercepted by CorsFilter to apply CORS headers to response object");
		resp.setHeader("Access-Control-Allow-Origin", "*");
		resp.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, PATCH, DELETE");
		resp.setHeader("Access-Control-Allow-Headers", "Content-type, Authorization");
		resp.setHeader("Access-Control-Expose-Headers", "Authorization");
		chain.doFilter(req, resp);
		return;
	}
	
}
