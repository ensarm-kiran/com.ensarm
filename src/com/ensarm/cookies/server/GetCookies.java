package com.ensarm.cookies.server;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetCookies extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 515418214022774992L;
	int counter =0;
	private ServletConfig config;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		this.config=config;
	}
	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return super.getServletConfig();
	}
	@Override
	public ServletContext getServletContext() {
		
		return config.getServletContext();
	}
	 /**
     * @see HttpServlet#HttpServlet()
     */
    public GetCookies() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		counter++;
		request.setAttribute("ServletHitCount", counter);
		Cookie[] cookies = request.getCookies();
		// Display these cookies.
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		//pw.println("<B>");
		
		for(int i = 0; i < cookies.length; i++) {
		String name = cookies[i].getName();
		String value = cookies[i].getValue();
		/*pw.println("name = " + name +
		"; value = " + value);*/
		pw.println(value);
		}
		System.out.println(request.getAttribute("ServletHitCount"));
		pw.close();

	}
}
