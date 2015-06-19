/**
 * 
 */
package practica1.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * @author Alberto Vivas
 *
 * 
 */
public class SessionManager {

	//private Session session;
	private static Configuration configuration;
	private static StandardServiceRegistryBuilder builder;
	private static SessionFactory factory;
	
	private  static SessionManager sessionManager = new SessionManager();
	

	private SessionManager(){
		configuration = new Configuration().configure();
		builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		factory = configuration.buildSessionFactory(builder.build());
	}
	
	public static Session obtenerSession(){
		return factory.openSession();
	}
	
	public static void disconectSession(Session session){
		try{
			session.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	@SuppressWarnings("static-access")
	public static void closeFactory(){
		try{
			sessionManager.factory.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
}
