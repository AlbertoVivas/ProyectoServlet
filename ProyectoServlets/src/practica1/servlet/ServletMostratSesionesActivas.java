/**
 * 
 */
package practica1.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Alberto Vivas
 *
 * 
 */
@SuppressWarnings("serial")
public class ServletMostratSesionesActivas extends HttpServlet{
	@SuppressWarnings("unused")
	private final Logger log = LogManager.getRootLogger();
	private String botom_volver = "<form method=\"get\" action=\"http://172.16.1.57:8090/ProyectoServlets/Login.html\"> <button type= \"submit\">Back</button> </form>";
	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		HttpSession httpsession;
		resp.setContentType("text/html");
		PrintWriter printWriter = resp.getWriter();
		
		Map<String,HttpSession> map = (Map<String, HttpSession>) req.getSession().getServletContext().getAttribute("map");
		
		printWriter.println("<b>Map con sesiones Activas</b><br>");
		Iterator it = map.values().iterator();
		while(it.hasNext()){
			httpsession = (HttpSession) it.next();			
			printWriter.println("Imprimo el map, http sesion id: "+httpsession.getId()+" nombre "+httpsession.getAttribute("nombre")+"<br>");
		}
		printWriter.println("<p>Numero de usuarios activos: "+map.size()+"<p>");
		printWriter.println(botom_volver);
	}
}
