/**
 * 
 */
package practica1.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Alberto Vivas
 *
 * 
 */
public class ServletSession extends HttpServlet{
	private final Logger log = LogManager.getRootLogger();

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		log.trace("entre al doget de servlet session");
	
		HttpSession http_session = req.getSession(false);
		
		if(http_session==null){
			http_session = req.getSession();
			log.trace("req.getSession(false)==null   get new session");
		}else{
			log.trace("req.getSession(false)!=null   get old session");
		}
		
		
		
		
		
	}
}
