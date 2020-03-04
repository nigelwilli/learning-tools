package dev.innov8.web;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.reflections.Reflections;

import dev.innov8.web.annotations.Controller;

public class HandlerMapper {
	
	private Logger log = LogManager.getLogger(HandlerMapper.class);
	
	private Map<String, Handler> handlerMap;
	
	public HandlerMapper() {
		handlerMap = new HashMap<>();
		populateMap();
	}
	
	public void populateMap() {
		
		log.info("Populating handler map");
		
		if(!handlerMap.isEmpty()) return;
		
		Reflections reflections = new Reflections("dev.innov8.web.controllers");
		Set<Class<?>> controllers = reflections.getTypesAnnotatedWith(Controller.class);
		
		controllers.forEach(ctrl -> {
			
			try {
				
				String className = ctrl.getAnnotation(Controller.class).qualifiedName();
				String uri = ctrl.getAnnotation(Controller.class).uri();
				Constructor<?> constructor = Class.forName(className).getConstructor();
				Handler handler = (Handler) constructor.newInstance();
				
				log.info("Registering {} to service requests to {}", className, uri);
				handlerMap.put(uri, handler);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		});
		
		
	}
	
	public Handler getHandler(String uri) {
		log.info("Attempting to fetch handler with URI: {}", uri);
		return handlerMap.get(uri);
	}

}
