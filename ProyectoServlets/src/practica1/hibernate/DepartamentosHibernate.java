/**
 * 
 */
package practica1.hibernate;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import tablas_Clases.Departments;

/**
 * @author Alberto Vivas
 *
 * 
 */
public class DepartamentosHibernate {
	
	public static List<Departments> obtenerDepartamentos(HttpServletRequest req){
		ServletContext sc = req.getServletContext();
		SessionFactory sf = (SessionFactory) sc.getAttribute("sf");
		Session session = sf.openSession();
		@SuppressWarnings("unchecked")
		List<Departments> list = session.createSQLQuery("Select * from DEPARTMENTS").addEntity(Departments.class).list();
		session.close();
		return list;
	}
}
