/**
 * 
 */
package practica1.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Alberto Vivas
 *
 * 
 */
public class ServletLogout extends HttpServlet {

	private String botom_volver = "<form method=\"get\" action=\"http://172.16.1.57:8090/ProyectoServlets/Login.html\"> <button type= \"submit\">Back</button> </form>";
	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		String nombre = (String) req.getSession(false).getAttribute("nombre");
		req.getSession().invalidate();
		resp.setContentType("text/html");
		PrintWriter printWriter = resp.getWriter();
		printWriter.println("<head>");
		printWriter.println("<meta http-equiv=\"Refresh\" content = 5, url = http://172.16.1.57:8090/ProyectoServlets/Login.html\"/>");
		printWriter.println("Ha cerrado con exito la session: "+nombre);
		printWriter.println(botom_volver);
		printWriter.println("</head>");
		
	}
}
