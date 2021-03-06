/**
 * 
 */
package practica1.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import practica1.hibernate.DepartamentosHibernate;
import tablas_Clases.Departments;



/**
 * @author Alberto Vivas
 *	Clase que devuelve la losta de departamentos por un menu desplegable
 *	en esta clase el acceso a la BBDD se hace correctamente en una clase 
 *	aparte, adicionalmente se muestra el nuemero de sesiones activas.
 * 
 */
public class ServletListaDepartamentos extends HttpServlet{
	Session session;
	private String boton_volver="<form method=\"get\" action=\"http://localhost:8090/ProyectoServlets/Login.html\"> <button type= \"submit\">Back</button> </form>";
	private String boton_enviar1="<form method=\"get\" action=\"ServletMostrarEmpleadosPorDepId\">";
	private String boton_enviar2="<button type= \"submit\">Enviar</button> </form>";
	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		Departments d;
		
		List<Departments> list = DepartamentosHibernate.obtenerDepartamentos(req);
		resp.setContentType("text/html");
		PrintWriter printWriter = resp.getWriter();
		printWriter.println("<p>");
		printWriter.println("<b>Lista de departaments</b><br>");
		Iterator<Departments> it = list.iterator();
		printWriter.println(boton_enviar1);
		printWriter.println("<select name=\"DepID\">");
		while(it.hasNext()){
			d = it.next();
			printWriter.println("<option value=\""+d.getDepartmentId()+"\">"+d.getDepartmentName()+"</option>");
		}
		printWriter.println("</select>");
		printWriter.println("</p>");
		printWriter.println(boton_enviar2);
		printWriter.println("<p>"+boton_volver+"</p>");
		
	}

}
