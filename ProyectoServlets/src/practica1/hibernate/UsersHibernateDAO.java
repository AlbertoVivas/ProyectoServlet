/**
 * 
 */
package practica1.hibernate;

import java.io.Serializable;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;


import tablas_Clases.Users;

/**
 * @author Alberto Vivas
 *
 * 
 */
public class UsersHibernateDAO  {
	
	private final Logger log = LogManager.getRootLogger();
	private static Session session;
	public static Session getSession() {
		return session;
	}
	public static void setSession(Session session) {
		UsersHibernateDAO.session = session;
	}
	/* (non-Javadoc)
	 * @see interfaceRecuperable.Recuperable#leerEmpleado(int)
	 */
	
	public Users leerUser(String id) {
		Users user = null;
		try{			
		log.trace("id:"+id);
		user= (Users) session.get(Users.class, id);
		log.trace("user: "+user);
		}catch(Exception e){
			log.error("Error en leer User: "+id);
			e.printStackTrace();
		}
		return user;
	}

}
