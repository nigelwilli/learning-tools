package com.revature.util;

import javax.servlet.http.HttpServletRequest;

public class RequestViewHelper {
	
	public static String process(HttpServletRequest req) {
		
		switch(req.getRequestURI()) {
		
		case "/revature-book-store_v3/login.view":
			return "partials/login.html";
			
		case "/revature-book-store_v3/register.view":
			return "partials/register.html";
			
		case "/revature-book-store_v3/home.view":
			return "partials/home.html";
			
		default:
			return "index.html";
			
		}
	}

}
