/**
 * 
 */
package practica1.servlet;

import practica1.hibernate.Recuperable;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import practica1.hibernate.EmployeesServices;
import practica1.hibernate.EmpleadoHibernateDAO;


import java.sql.SQLException;
import tablas_Clases.Employees;


/**
 * @author Alberto Vivas
 *
 * 
 */
@SuppressWarnings("serial")
public class ServletObtenerEmpleado extends HttpServlet {

	/* (non-Javadoc) 
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
		System.out.println("Ha llamado a doget");
		
		ServletContext sc = req.getServletContext();
		SessionFactory sf = (SessionFactory) sc.getAttribute("sf");
		Session session = sf.openSession();
		session.close();
		
		String nombre = req.getParameter("id");
		Integer i = new Integer(nombre);
	
		EmployeesServices es = new EmployeesServices();
		
		Recuperable emp_hiber = new EmpleadoHibernateDAO();
		es.setRecuperable(emp_hiber);
		Employees e = (Employees) es.leerEmpleado(i);
		if(e!=null){
		resp.setContentType("text/html");
		PrintWriter printWriter = resp.getWriter();
		printWriter.println(e.toStringjdbc());
		}else{
			resp.setContentType("text/html");
			PrintWriter printWriter = resp.getWriter();
			printWriter.println("no existe el empleado: "+i);
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("Ha llamado a dopost");
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#service(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Ha llamado a service");
		super.service(arg0, arg1);
	}
}
