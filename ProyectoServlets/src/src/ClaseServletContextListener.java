/**
 * 
 */
package src;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import practica1.hibernate.SessionManager;

/**
 * @author Alberto Vivas
 *
 * 
 */
public class ClaseServletContextListener implements ServletContextListener {

	/* (non-Javadoc)
	 * @see javax.servlet.ServletContextListener#contextDestroyed(javax.servlet.ServletContextEvent)
	 */
	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		
		// TODO Auto-generated method stub
		System.out.println("contextDestroyed(ServletContextEvent arg0)");
		
		ServletContext sc = servletContextEvent.getServletContext();
		SessionFactory sf = (SessionFactory) sc.getAttribute("sf");
		sf.close();
	}

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
		// TODO Auto-generated method stub
		System.out.println("contextInitialized(ServletContextEvent arg0)");
		sc = servletContextEvent.getServletContext();
		sc.setAttribute("sf", sf);
	}

}
