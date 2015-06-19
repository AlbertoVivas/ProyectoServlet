package practica1.hibernate;

import java.io.Serializable;

import org.hibernate.Transaction;
import org.hibernate.Session;
import practica1.hibernate.SessionManager;
import tablas_Clases.Employees;
import practica1.hibernate.Recuperable;

/**
 * 
 */

/**
 * @author Alberto Vivas
 *
 * 
 */
public class EmpleadoHibernateDAO implements Recuperable {

	/* (non-Javadoc)
	 * @see interfaceRecuperable.Recuperable#leerEmpleado(int)
	 */
	@Override
	public Object leerEmpleado(Object id) {
		Session session =null;
		Employees empleado = null;
		Transaction trans = null;
		try{		
		session =  SessionManager.obtenerSession();	
		trans = session.beginTransaction();
		empleado= (Employees) session.get(Employees.class, (Serializable) id);
		}catch(Exception e){
			e.printStackTrace();
			trans.rollback();
		}finally{
			SessionManager.disconectSession(session);
		}
		return empleado;
	}

}
