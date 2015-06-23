package practica1.hibernate;

import java.io.Serializable;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Transaction;
import org.hibernate.Session;
import tablas_Clases.Employees;
import practica1.hibernate.Recuperable;

/**
 * @author Alberto Vivas
 *
 * 
 */
public class EmpleadoHibernateDAO implements Recuperable {
	
	private final Logger log = LogManager.getRootLogger();
	private static Session session;
	public static Session getSession() {
		return session;
	}
	public static void setSession(Session session) {
		EmpleadoHibernateDAO.session = session;
	}
	/* (non-Javadoc)
	 * @see interfaceRecuperable.Recuperable#leerEmpleado(int)
	 */
	@Override
	public Object leerEmpleado(Object id) {
		Employees empleado = null;
		Transaction trans = null;
		try{			
		if(session!= null){
		trans = session.beginTransaction();
		empleado= (Employees) session.get(Employees.class,(Serializable) id);
		}
		}catch(Exception e){
			log.error("Error en leer empleado: "+id);
			e.printStackTrace();
			trans.rollback();
		}
		return empleado;
	}

}
