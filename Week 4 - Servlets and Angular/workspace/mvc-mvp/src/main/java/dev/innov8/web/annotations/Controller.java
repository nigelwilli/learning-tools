package dev.innov8.web.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Indicates that the annotated class is a controller class
 * and should be registered with the HandlerMapper at runtime
 * so that requests to the /auth URI are routed to it for servicing.
 * 
 * @author Wezley Singleton
 *
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Controller {

	String name();
	String uri();
	String qualifiedName();
	
}
