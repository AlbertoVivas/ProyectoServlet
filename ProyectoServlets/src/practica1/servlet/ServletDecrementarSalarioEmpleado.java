/**
 * 
 */
package practica1.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Iterator;
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
import org.hibernate.Transaction;

import tablas_Clases.Employees;

/**
 * @author Alberto Vivas
 *
 * 
 */
public class ServletDecrementarSalarioEmpleado extends HttpServlet {
	private final Logger log = LogManager.getRootLogger();
	private String botom_volver="<form method=\"get\" action=\"http://localhost:8090/ProyectoServlets/Empleado.html\"> <button type= \"submit\">Back</button> </form>";
	/* (non-Javadoc) 
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
			System.out.println("Ha llamado a doget");
			log.trace("Ha llamado al doget, en ServletObtenerEmpleado");
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
		
		String gsc = getServletContext().getInitParameter("dec");
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
			Employees e = it.next();
			printWriter.println(e.toString()+"<br>");
			System.out.println(e.toString());
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
