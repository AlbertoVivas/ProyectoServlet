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
 *	Clase que me lleva a la pagina de i�aki
 * 
 */
public class ServlerRedirectIgnacio extends HttpServlet{
	private final Logger log = LogManager.getRootLogger();
	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		log.debug("Entre al doget ServletRedireccionar");
		//resp.sendRedirect("http://www.wikipedia.org");
		resp.sendRedirect("http://172.16.1.50:8090/JaveandoWebs/");
	}
}
