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

/**
 * Servlet implementation class CookiesSample
 */
public class CookiesSample extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletConfig config;
	int counter =0;
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		this.config=config;
		 
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CookiesSample() {
        super();
        // TODO Auto-generated constructor stub
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String data = request.getParameter("Name");
		counter++;
		request.setAttribute("ServletHitCount", counter);
		Cookie cookie = new Cookie(data+"cookie", data);
		// Add cookie to HTTP response.
		cookie.setMaxAge(60);
		response.addCookie(cookie);
		// Write output to browser.
		response.setContentType("text/html");
		System.out.println(request.getAttribute("ServletHitCount"));
		PrintWriter pw = response.getWriter();
		pw.println("<B>MyCookie has been set to");
		pw.println(data);
		pw.close();

	}

}
