package com.revature.web;

/**
 * An enumeration that represents the HTTP verbs which this 
 * web application will respond to.
 * 
 * @author Wezley Singleton
 *
 */
public enum HttpMethod {
	
	GET("GET"), 
	POST("POST"), 
	PUT("PUT"), 
	DELETE("DELETE"), 
	OPTIONS("OPTIONS");
	
	private String methodName;
	
	private HttpMethod(String methodName) {
		this.methodName = methodName;
	}
	
	@Override
	public String toString() {
		return this.methodName;
	}
}
