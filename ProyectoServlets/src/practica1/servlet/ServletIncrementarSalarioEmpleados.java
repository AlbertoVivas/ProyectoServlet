/**
 * 
 */
package practica1.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Transaction;
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
public class ServletIncrementarSalarioEmpleados extends HttpServlet {
	private final Logger log = LogManager.getRootLogger();
	private String botom_volver="<form method=\"get\" action=\"http://localhost:8090/ProyectoServlets/Empleado.html\"> <button type= \"submit\">Back</button> </form>";
	/* (non-Javadoc) 
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {

		Session session = null;
		try {
			System.out.println("Ha llamado a doget");
			log.trace("Ha llamado al doget, en ServletObtenerEmpleado");
			ServletContext sc = req.getServletContext();
			SessionFactory sf = (SessionFactory) sc.getAttribute("sf");
			session = sf.openSession();
			EmpleadoHibernateDAO.setSession(session);
			
			int num_pet = (int) sc.getAttribute("num_pet");
			num_pet++;
			sc.setAttribute("num_pet", num_pet);

			String parametro = req.getParameter("id");
			// Integer i = new Integer(nombre);
			Employees e = null;
			try {
				Integer i = new Integer(parametro);
				EmployeesServices es = new EmployeesServices();
				Recuperable emp_hiber = new EmpleadoHibernateDAO();
				es.setRecuperable(emp_hiber);
				e = (Employees) es.leerEmpleado(i);
				if (e != null) {
					resp.setContentType("text/html");
					PrintWriter printWriter = resp.getWriter();
					printWriter.println(e.toStringjdbc());
					printWriter.println("Numero de peticiones: "+num_pet);
					printWriter.println(botom_volver);
				} else {
					resp.setContentType("text/html");
					PrintWriter printWriter = resp.getWriter();
					printWriter.println("no existe el empleado: " + i);
					printWriter.println("Numero de peticiones: "+num_pet);
					log.error("No existe el empleado: " + i);
					printWriter.println(botom_volver);
				}
			} catch (NumberFormatException n) {
				resp.setContentType("text/html");
				PrintWriter printWriter = resp.getWriter();
				printWriter.println("Error al introducir la id de empleado, " + parametro+ " no es un int");
				printWriter.println("Numero de peticiones: "+num_pet);
				log.error("Error al introducir la id de empleado, " + parametro+ " no es un int");
				printWriter.println(botom_volver);
			}

		} catch (SQLException e) {
			log.error("Error en doGet en ServletObtenerEmpleado");
			e.printStackTrace();
		} finally {
			session.close();
		}
		
	}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		
		Session session;
		System.out.println("Ha llamado a dopost");
		log.trace("Ha llamado a dopost, de ServletObtenerEmpleado");
		
		ServletContext sc = req.getServletContext();
		SessionFactory sf = (SessionFactory) sc.getAttribute("sf");
		session = sf.openSession();
		
		int num_pet = (int) sc.getAttribute("num_pet");
		num_pet++;
		sc.setAttribute("num_pet", num_pet);
		
		String gsc = getServletContext().getInitParameter("inc");
		BigDecimal d = new BigDecimal(gsc);
		incrementarSalarioXporCiento(d, session);
		
		
		if(d.signum()==-1){
			resp.setContentType("text/html");
			PrintWriter printWriter = resp.getWriter();
			printWriter.println("Decrementando el salario en: "+d+ "%");
			printWriter.println("Numero de peticiones: "+num_pet);
			printWriter.println(botom_volver);
			//System.out.println("\n Decrementando el salario en: "+d+ "%\n" );
		}
		if (d.signum()==1){
			resp.setContentType("text/html");
			PrintWriter printWriter = resp.getWriter();
			printWriter.println("Incrementando el salario en: "+d+"%");
			printWriter.println("Numero de peticiones: "+num_pet);
			printWriter.println(botom_volver);
			//System.out.println("\n Incrementando el salario en: "+d+"%\n");
		}
		if (d.signum()==0){
			resp.setContentType("text/html");
			PrintWriter printWriter = resp.getWriter();
			printWriter.println("No incrementamos el salario, inc = "+d+"%");
			printWriter.println("Numero de peticiones: "+num_pet);
			printWriter.println(botom_volver);
			//System.out.println("\n No incrementamos el salario, inc = "+d+"%\n");
		}
		
		List<Employees> list = session.createSQLQuery("SELECT * FROM EMPLOYEES").addEntity(Employees.class).list();//entity es el objeto java asociada a la base de datos
		Iterator<Employees> it = list.iterator();
		resp.setContentType("text/html");
		PrintWriter printWriter = resp.getWriter();
		while(it.hasNext()){
			printWriter.println(it.next().toString()+"<br>");
			System.out.println(it.next());
		}
		session.close();
	}
	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#service(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Ha llamado a service");
		log.trace("Ha llamado a service, de ServletObtenerEmpleado");
		super.service(arg0, arg1);
	}
	
	
	
	public boolean incrementarSalarioXporCiento(BigDecimal d, Session session){
		boolean respuesta = false;
		Transaction trans= null;
		try {
			if(d.signum()==-1){
				System.out.println("\n Decrementando el salario en: "+d+ "%\n" );
			}
			if (d.signum()==1){
				System.out.println("\n Incrementando el salario en: "+d+"%\n");
			}
			if (d.signum()==0){
				System.out.println("\n No incrementamos el salario, inc = "+d+"%\n");
			}
		//	obtenerSession();
			trans = session.beginTransaction();
			@SuppressWarnings("unchecked")
			List<Employees> list = session.createSQLQuery("SELECT * FROM EMPLOYEES").addEntity(Employees.class).list();//entity es el objeto java asociada a la base de datos
			Iterator<Employees> it = list.iterator();
			Employees employees =null;
			BigDecimal n_salary = new BigDecimal(0);
			BigDecimal inc = new BigDecimal(1).add(d.divide(new BigDecimal(100)));
			while(it.hasNext()){
				employees=it.next();
				n_salary= employees.getSalary().multiply(inc);
				employees.setSalary(n_salary);
				session.saveOrUpdate(employees);
			}
			
			trans.commit();
			respuesta = true;
			
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
		}finally{
			//disconectSession();
			//session.close();
		}
		return respuesta;
	}
	
}
