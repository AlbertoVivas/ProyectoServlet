/**
 * 
 */
package src;



import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * @author Alberto Vivas
 * un objeto que crea el servidor cuando se arranca el servidor, es una especie de saco o 
 * almacen que permite comunicarnos en varios servlets.
 * 
 */
public class ClaseServletContextListener implements ServletContextListener {
	private final Logger log = LogManager.getRootLogger();

	/* (non-Javadoc)
	 * @see javax.servlet.ServletContextListener#contextInitialized(javax.servlet.ServletContextEvent)
	 */
	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
	//De este modo puedo eliminar mi Session manager, y dejo que se cree y destruya por html.
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		SessionFactory sf = configuration.buildSessionFactory(builder.build());
	
		ServletContext sc = null;
		System.out.println("contextInitialized(ServletContextEvent arg0)");
		sc = servletContextEvent.getServletContext();
		sc.setAttribute("sf", sf);
		int num_pet=0;
		sc.setAttribute("num_pet", num_pet);
		log.trace("contextInitialized, setted atribute sf&num_pet of server context");
	}
	/* (non-Javadoc)
	 * @see javax.servlet.ServletContextListener#contextDestroyed(javax.servlet.ServletContextEvent)
	 */
	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		System.out.println("contextDestroyed(ServletContextEvent arg0)");
		
		ServletContext sc = servletContextEvent.getServletContext();
		SessionFactory sf = (SessionFactory) sc.getAttribute("sf");
		sf.close();
		log.trace("contextDestroyed, session factory closed");
	}

	

}
