package com.example;

import jakarta.servlet.http.*;
import java.io.IOException;

public class HelloWorldServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		try{
			response.setContentType("text/html/charset=UTF-8");

			String name = request.getParameter("name");
			if(name == null || name.isEmpty()) {
				name = "World";
			}

			response.getWriter().println("<h1>Hello, " + name + "!</h1>");
		}catch(IOException e){
			e.printStackTrace();
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
			
	}
}