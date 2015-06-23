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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Alberto Vivas
 *
 * 
 */
public class MyFilterJDBC implements Filter{
	private final Logger log = LogManager.getRootLogger();
	/* (non-Javadoc)
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		log.trace("Ha entrado al init de MyFilter de JDBC");
	}
	/* (non-Javadoc)
	 * @see javax.servlet.Filter#destroy()
	 */
	@Override
	public void destroy() {
		log.trace("Ha entrado al destroy de MyFilter de JDBC");
	}

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,	FilterChain arg2) throws IOException, ServletException {
		log.trace("Ha entrado en doFilter de JDBC");
		// TODO Auto-generated method stub
		//preprocesamiento
		Long t0 = System.currentTimeMillis();
		arg2.doFilter(arg0, arg1);
		Long t1 = System.currentTimeMillis();
		log.trace("Tiempo JDBC t1-t0="+(t1-t0));
		//postprocesamiento
	}

	

}
