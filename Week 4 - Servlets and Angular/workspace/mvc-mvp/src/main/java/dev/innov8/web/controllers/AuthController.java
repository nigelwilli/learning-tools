package dev.innov8.web.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;

import dev.innov8.web.Handler;
import dev.innov8.web.HandlerContext;
import dev.innov8.web.HttpMethod;
import dev.innov8.web.HttpStatus;
import dev.innov8.web.annotations.Controller;
import dev.innov8.web.security.Credentials;
import dev.innov8.web.security.Principal;

/**
 * Controller used to process authentication requests to 
 * the web application.
 * 
 * @author Wezley Singleton
 *
 */
@Controller(
	name="AuthController", 
	uri="/auth",
	qualifiedName="dev.innov8.web.controllers.AuthController"
)
public class AuthController implements Handler {
	
	private static Logger log = LogManager.getLogger(AuthController.class);

	@Override
	public Object invoke(HandlerContext hctx, HttpServletRequest req, HttpServletResponse resp) {
		log.info("AuthController invoked");
		
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			
			if(hctx.getMethod().equals(HttpMethod.POST)) {
				log.info("Post request received, extracting credentials object and passing it to authenticate()");
				Credentials creds = mapper.readValue(req.getInputStream(), Credentials.class);
				hctx.setDone(true);
				return authenticate(creds);
			}
			
		} catch (IOException ioe) {
			throw new RuntimeException(HttpStatus.BAD_REQUEST_400.toString());
		}
		
		return null;
	}
	
	/**
	 * Used to service authentication requests. Currently only works with a 
	 * predefined dummy user value.
	 * 
	 * @param creds
	 * @return A principal object if successful, otherwise null.
	 */
	public Principal authenticate(Credentials creds) {
		
		if(creds == null || creds.getUsername() == null || creds.getPassword() == null) {
			throw new RuntimeException(HttpStatus.BAD_REQUEST_400.toString());
		}
		
		if(!creds.getUsername().equals("wsingleton") && !creds.getPassword().equals("p4ssw0rd")) {
			throw new RuntimeException(HttpStatus.UNAUTHORIZED_401.toString());
		}
		
		return new Principal(1, "wsingleton", "ADMIN");
		
	}

}
