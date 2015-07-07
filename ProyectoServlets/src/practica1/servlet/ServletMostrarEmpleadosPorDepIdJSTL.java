/**
 * 
 */
package practica1.servlet;

import java.io.IOException;
import java.util.List;

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
import tablas_Clases.Employees;

/**
 * @author Alberto Vivas
 *
 * 
 */
public class ServletMostrarEmpleadosPorDepIdJSTL extends HttpServlet{

	private final Logger log = LogManager.getRootLogger();
	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		EmpleadoHibernateDAO ehdao = new EmpleadoHibernateDAO();
		ServletContext sc = req.getServletContext();
		SessionFactory sf = (SessionFactory) sc.getAttribute("sf");
		Session session = sf.openSession();
		EmpleadoHibernateDAO.setSession(session);
		log.debug("doGet ServletMostrarEmpleadosPorDepIdJSTL"); 
		int depid =Integer.parseInt(req.getParameter("DepID"));
		log.debug("depid="+depid);
		List<Employees> le = ehdao.listEmpPorDepId(depid);
		session.close();
		req.setAttribute("ListaEmpleados", le);
		req.getRequestDispatcher("EmpPorDepJSTL.jsp").forward(req, resp);
	}
}
