package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	public void init(ServletConfig config) {
		System.out.println("TestServlet.init() invoked!");
	}
	
	@Override
	public void destroy() {
		System.out.println("TestServlet.destroy() invoked!");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		System.out.println("TestServlet.doGet() invoked!");
		
		PrintWriter writer = resp.getWriter();
		writer.write("<h1>Application deployed successfully!</h1>");
		
		resp.setStatus(200);
		resp.setContentType("text/html");
		
	}
	

}
