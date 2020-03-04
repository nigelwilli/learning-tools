package com.revature.web;

/**
 * Convenience enumeration holding string values for commonly used
 * HTTP status code descriptions.
 * 
 * @author Wezley Singleton
 *
 */
public enum HttpStatus {

	// 200s
	OK_200("OK"), CREATED_201("Created"), ACCEPTED_202("Accepted"), 
	NO_CONTENT_204("No Content"), PARTIAL_CONTENT_206("Partial Content"),

	// 400s
	BAD_REQUEST_400("Bad Request"), UNAUTHORIZED_401("Unauthorized"), 
	FORBIDDEN_403("Forbidden"), NOT_FOUND_404("Not Found"), CONFLICT_409("Conflict"),
	
	// 500s
	INTERNAL_SERVER_ERROR_500("Internal Server Error"), NOT_IMPLEMENTED_501("Not Implemented");
	
	private String statusDesc;
	
	private HttpStatus(String statusDesc) {
		this.statusDesc = statusDesc;
	}
	
	@Override
	public String toString() {
		return statusDesc;
	}
	
}
