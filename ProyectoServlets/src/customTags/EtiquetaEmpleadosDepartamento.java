/**
 * 
 */
package customTags;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import practica1.hibernate.EmpleadoHibernateDAO;
import tablas_Clases.Employees;

/**
 * @author Alberto Vivas
 *
 * 
 */
public class EtiquetaEmpleadosDepartamento extends SimpleTagSupport{
	private final Logger log = LogManager.getRootLogger();
	private String botom_volver = "<form method=\"get\" action=\"http://172.16.1.57:8090/ProyectoServlets/Login.html\"> <button type= \"submit\">Back</button> </form>";
	private int depid;
	public int getDepid() {
		return depid;
	}
	public void setDepid(int depid) {
		this.depid = depid;
	}
	/* (non-Javadoc)
	 * @see javax.servlet.jsp.tagext.SimpleTagSupport#doTag()
	 */
	@Override
	public void doTag() throws JspException, IOException {
		log.debug("dotag EtiquetaEmpleadosDepartamento, depid="+depid);
		String tabla1="<table border='1' bordercolor='#0000FF'>" +
							"<tr align='center'>" +
								"<td bgcolor='#00BFFF'>Nombre</td>" +
								"<td bgcolor='#00BFFF'>Apellido</td>" +
								"<td bgcolor='#00BFFF'>email</td>" +
								"<td bgcolor='#00BFFF'>salario</td>";
		
		
		getJspContext().getOut().println("Los empleados del departamento "+depid+" son:");
		EmpleadoHibernateDAO e_dao = new EmpleadoHibernateDAO();
		Employees e = null;
		
		PageContext pc = (PageContext) getJspContext();
		HttpServletRequest req = (HttpServletRequest) pc.getRequest();
		List<Employees> le = e_dao.listEmpPorDepId(depid,req);
		Iterator<Employees> it = le.iterator();
		getJspContext().getOut().println(tabla1);
		while(it.hasNext()){
			e=it.next();
			getJspContext().getOut().println("<tr align='center'>" +
												"<td>"+e.getFirstName()+"</td>" +
												"<td>"+e.getLastName()+"</td>" +
												"<td>"+e.getEmail()+"</td>" +
												"<td>"+e.getSalary()+"</td>" +
										    "</tr>");		
			
		}
		getJspContext().getOut().println("</table>");
		getJspContext().getOut().println(botom_volver);
	}
}
