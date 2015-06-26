/**
 * 
 */
package practica1.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Alberto Vivas
 *	pagina de tamara
 * 
 */
public class ServletRedirectTamara extends HttpServlet{
	private final Logger log = LogManager.getRootLogger();
	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		log.debug("Entre al doget ServletRedireccionar");
		resp.sendRedirect("http://172.16.1.211:8090/ProjectServlets/");
	}
	
}
