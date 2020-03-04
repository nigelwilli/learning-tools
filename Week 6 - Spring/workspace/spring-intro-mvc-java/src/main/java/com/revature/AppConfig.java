package com.revature;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebMvc // XML equivalent: <mvc:annotation-driven/>
@ComponentScan // XML equivalent: <context:component-scan base-package="com.revature"/>
@Configuration // XML equivalent: <beans>...</beans>
public class AppConfig implements WebMvcConfigurer, WebApplicationInitializer {

	/*
	 * Within this method, whose implementation is required by the WebApplicationInitializer
	 * interface, we will dynamically register the Spring DispatcherServlet with our servlet
	 * container.
	 * 
	 * What we do in this method is effectively the equivalent of what we would normally do 
	 * to register the DispatcherServlet with the servlet container in the web.xml.
	 */
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		
		// Create a IOC container for our web application and register this configuration class with it
		AnnotationConfigWebApplicationContext container = new AnnotationConfigWebApplicationContext();
		container.register(AppConfig.class);
		
		// Add our ContextLoaderListener to the provided ServletContext
		servletContext.addListener(new ContextLoaderListener(container));
		ServletRegistration.Dynamic dispatcher = servletContext.addServlet("DispatcherServlet", new DispatcherServlet(container));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");
		
	}

}
