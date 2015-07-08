package practica1.hibernate;

import java.io.Serializable;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.Session;

import tablas_Clases.Departments;
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
	
	@SuppressWarnings("unchecked")
	public List<Employees> listEmpPorDepId(int depid){
		return session.createSQLQuery("SELECT * from EMPLOYEES where DEPARTMENT_ID="+depid).addEntity(Employees.class).list();
	}
	
	public List<Employees> listEmpPorDepId(int depid, HttpServletRequest req){
		ServletContext sc = req.getServletContext();
		SessionFactory sf = (SessionFactory) sc.getAttribute("sf");
		Session session = sf.openSession();
		@SuppressWarnings("unchecked")
		List<Employees> list =session.createSQLQuery("SELECT * from EMPLOYEES where DEPARTMENT_ID="+depid).addEntity(Employees.class).list();
		session.close();
		return list;
	}
}
