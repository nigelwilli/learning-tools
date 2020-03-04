package com.revature.web.annotations;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.CLASS;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import com.revature.web.HttpMethod;

@Documented
@Retention(CLASS)
@Target({ TYPE, METHOD })
public @interface RequestMapping {
	
	HttpMethod requestMethod();
	String produces();
	String consumes();
	
}
