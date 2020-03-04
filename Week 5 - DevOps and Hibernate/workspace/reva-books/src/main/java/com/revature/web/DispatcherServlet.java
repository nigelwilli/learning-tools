package com.revature.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *	Acts as the single entry point for all HTTP requests to
 *	this web application. It will dispatch requests to the 
 *	appropriate controller logic depending upon the URI being
 *	requested.
 * 
 * @author Wezley Singleton
 */
@WebServlet(
	name = "DispatcherServlet",
	loadOnStartup = 1,
	urlPatterns = {"/*"}
)
public class DispatcherServlet extends HttpServlet {
	
	private static Logger log = LogManager.getLogger(DispatcherServlet.class);
	private static final long serialVersionUID = -3997889480412719447L;
	
	private HandlerMapper handlerMapper;
	
	public DispatcherServlet() {
		super();
		handlerMapper = new HandlerMapper();
	}
	
	@Override
	public void init() throws ServletException {
		log.info("DispatcherServlet instantiated");
	}
	
	@Override
	public void destroy() {
		log.info("DispatcherServlet being destroyed");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		dispatchReply(req, resp, HttpMethod.GET);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		dispatchReply(req, resp, HttpMethod.POST);
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		dispatchReply(req, resp, HttpMethod.PUT);
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		dispatchReply(req, resp, HttpMethod.DELETE);
	}
	
	/**
	 * 
	 * Dispatches the request from the client to the appropriate
	 * controller logic through the use of the dispatch() which 
	 * provides the data (if any) to be returned to the requester.
	 * This data is written to the body of the response using the 
	 * reply() method.
	 * 
	 * @param req
	 * @param resp
	 * @param method
	 * @throws ServletException
	 * @throws IOException
	 */
	public void dispatchReply(HttpServletRequest req, HttpServletResponse resp, HttpMethod method) throws ServletException, IOException {
		log.info("DispatcherServlet.dispatchReply invoked");
		
		resp.setContentType("application/json");
		
		String path = req.getPathInfo();
		HandlerContext hctx = new HandlerContext(path, method);
		Object responsePayload = null;
		
		try {
			log.info("Dispatching request to handler for payload retrieval");
			responsePayload = dispatch(hctx, req, resp);
		} catch (Exception e) {
			log.error("Something went wrong...");
			sendExceptionError(e, hctx, req, resp);
			return;
		}
		
		log.info("Checking HandlerContext status");
		if (!hctx.isDone()) {
			log.info("HandlerContext does not have a status of done");
			sendMappingError(hctx, req, resp);
			
		} else {
			log.info("HandlerContext has a status of done");
			reply(responsePayload, hctx, req, resp);
		}
		
	}
	
	public Object dispatch(HandlerContext hctx, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info("DispatcherServlet.dispatch invoked");
		Handler handler = getHandler(hctx, req);
		
		if(handler != null) {
			log.info("Handler located, dispatching to request");
			return handler.invoke(hctx, req, resp);
		}
		
		log.warn("No handler found using provided path");
		return null;
	}
	
	public void reply(Object data, HandlerContext hctx, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log.info("DispatcherServlet.reply invoked");
		
		PrintWriter writer = resp.getWriter();
		ObjectMapper mapper = new ObjectMapper();
		try {
			writer.write(mapper.writeValueAsString(data));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Handler getHandler(HandlerContext hctx, HttpServletRequest req) {
		log.info("Fetching handler based on provided context");
		return handlerMapper.getHandler(hctx.getPath());
	}
	
	public void sendExceptionError(Exception e, HandlerContext hctx, HttpServletRequest req, HttpServletResponse resp) {
		log.info("DispatcherServlet.sendErrorException invoked");
	}
	
	public void sendMappingError(HandlerContext hctx, HttpServletRequest req, HttpServletResponse resp) {
		log.info("DispatcherServlet.sendMappingException invoked");
	}

}
