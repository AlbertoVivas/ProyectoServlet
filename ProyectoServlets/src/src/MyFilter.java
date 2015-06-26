/**
 * 
 */
package src;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
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
public class MyFilter implements Filter{
	private final Logger log = LogManager.getRootLogger();
	private Long t1;
	private Long t2;
	/* (non-Javadoc)
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		log.trace("Ha entrado al init de MyFilter");
	}
	/* (non-Javadoc)
	 * @see javax.servlet.Filter#destroy()
	 */
	@Override
	public void destroy() {
		log.trace("Ha entrado al destroy de MyFilter");
	}

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,	FilterChain arg2) throws IOException, ServletException {
		log.trace("Ha entrado en doFilter");
		//preprocesamiento
		String login="http://172.16.1.57:8090/ProyectoServlets/Login.html";
		t1=System.currentTimeMillis();
		HttpServletRequest req = (HttpServletRequest) arg0;
		HttpServletResponse resp = (HttpServletResponse) arg1;
		
		String rq_uri = req.getRequestURI(); //La ruta a donde se pide ir
		HttpSession hs = req.getSession(false);
		
		if(null == hs){ //si no tiene sesion
			if(rq_uri.equals(login)){
				arg2.doFilter(arg0, arg1);
			}else{
				resp.sendRedirect(login);
			}
		}else{ // si tengo sesion paso :)
			arg2.doFilter(arg0, arg1);	
		}
		
		
		
		
		
		t2=System.currentTimeMillis();
		Long ts = (t2-t1)/1000;
		Long tm = ts/60;
		Long tsr = ts-tm*60;
		//postprocesamiento
		log.trace("Ha pasado el filter: "+tm+" min "+tsr+" segundos");
	}

	

}
