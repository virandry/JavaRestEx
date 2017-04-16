package io.virandry.servlet;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class MovieUpdate extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	final static Logger logger = Logger.getLogger(MovieUpdate.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = "movie-update.xhtml";
		String objectId = req.getParameter("objectId");
	
		try {
			req.setAttribute("generatedId", objectId);
			RequestDispatcher dispatcher = req.getRequestDispatcher(url);
			
			
			dispatcher.forward(req, resp);	
		} catch (Exception e){
			logger.debug(e);
		}
		
	}

}
