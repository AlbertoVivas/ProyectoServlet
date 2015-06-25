/**
 * 
 */
package src;

import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Alberto Vivas
 *
 * 
 */
public class ClaseHttpSessionListener implements HttpSessionListener {
	private final Logger log = LogManager.getRootLogger();
	private Long t1;
	private Long t2;

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpSessionListener#sessionCreated(javax.servlet.http.HttpSessionEvent)
	 */
	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		System.out.println("sessionCreated(HttpSessionEvent arg0)");
		t1=System.currentTimeMillis();
		log.trace("Ha entrado en session created: "+arg0.getSession().getId()+" creada en: "+arg0.getSession().getCreationTime());
		Map<String,HttpSession> map = (Map<String, HttpSession>) arg0.getSession().getServletContext().getAttribute("map");
		map.put(arg0.getSession().getId(), arg0.getSession());
		arg0.getSession().getServletContext().setAttribute("map", map);
		log.trace("Creada la sesion en el map "+arg0.getSession().getId());
		
		Iterator it = map.values().iterator();
		while(it.hasNext()){
			HttpSession httpsession= (HttpSession) it.next();
			log.trace("Imprimo el map, http sesion id: "+httpsession.getId()+" nombre "+httpsession.getAttribute("nombre"));
		}
	}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpSessionListener#sessionDestroyed(javax.servlet.http.HttpSessionEvent)
	 */
	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		System.out.println("sessionDestroyed(HttpSessionEvent arg0)");
		HttpSession httpsession= null;
		t2=System.currentTimeMillis();
		Long t = ((t2-t1)/60000);
		Long ts = (t2-t1)/1000;
		Long tm = ts/60;
		Long tsr = ts-tm*60;
		log.trace("Ha entrado en session destroyed: "+tm+" min "+tsr+" segundos");
		Map<String,HttpSession> map = (Map<String, HttpSession>) arg0.getSession().getServletContext().getAttribute("map");
		log.debug("session destroy, imprimo map antes de destruir la sesion");
		Iterator it = map.values().iterator();
		while(it.hasNext()){
			httpsession = (HttpSession) it.next();
			log.debug("Imprimo el map, http sesion id: "+httpsession.getId()+" nombre "+httpsession.getAttribute("nombre"));
		}
		
		log.debug("procedo a remover del mapa: "+arg0.getSession().getId()+" nombre "+httpsession.getAttribute("nombre"));
		map.remove(arg0.getSession().getId());
		arg0.getSession().getServletContext().setAttribute("map", map);
		log.trace("Borrada la sesion en el map "+arg0.getSession().getId()+" nombre "+httpsession.getAttribute("nombre"));
	}

}
