package com.revature.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.web.Handler;
import com.revature.web.HandlerContext;
import com.revature.web.annotations.Controller;

@Controller(
	name="BookController", 
	uri="/books",
	qualifiedName="com.revature.controllers.BookController"
)
public class BookController implements Handler {

	@Override
	public Object invoke(HandlerContext hctx, HttpServletRequest req, HttpServletResponse resp) {
		return null;
	}

}
