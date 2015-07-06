/**
 * 
 */
package practica1.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import practica1.hibernate.EmpleadoHibernateDAO;
import practica1.hibernate.EmployeesServices;
import practica1.hibernate.Recuperable;
import tablas_Clases.Employees;

/**
 * @author Alberto Vivas
 *
 * 
 */
public class ServletObtenerEmpleadoJsp extends HttpServlet{

	private final Logger log = LogManager.getRootLogger();
	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		log.debug("entre en doget ServletObtenerEmpleadoJsp ");
		ServletContext sc = req.getServletContext();
		SessionFactory sf = (SessionFactory) sc.getAttribute("sf");
		Session session = sf.openSession();
		EmpleadoHibernateDAO.setSession(session);
		
		String parametro = req.getParameter("ID");
		Integer i = new Integer(parametro);
		EmployeesServices es = new EmployeesServices();
		Recuperable emp_hiber = new EmpleadoHibernateDAO();
		es.setRecuperable(emp_hiber);
		Employees e = null;
		
		try {
			e = (Employees) es.leerEmpleado(i);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		req.setAttribute("empleado", e);
		session.close();
		req.getRequestDispatcher("/MostratEmpleado.jsp").forward(req, resp);
	}
}
