package com.revature.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Handler {
	
	Object invoke(HandlerContext hctx, HttpServletRequest req, HttpServletResponse resp);

}