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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Alberto Vivas
 *
 * 
 */
public class ServletAdivinaInicio extends HttpServlet{
	private final Logger log = LogManager.getRootLogger();
	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		/*
		int min =(int)req.getSession(false).getAttribute("min");
		int max =(int)req.getSession(false).getAttribute("max");
		int num =(int)req.getSession(false).getAttribute("num");
		log.debug("min "+min+" max "+max+" num "+num);
		
		switch (req.getParameter("es")) {
		case "1": // es >
			req.getSession(false).setAttribute("min", num);
			resp.sendRedirect("http://172.16.1.57:8090/ProyectoServlets/InicioAdivinaConNumero.jsp");
			log.debug("es >");
			break;
		case "2": // es <
			req.getSession(false).setAttribute("max", num);
			resp.sendRedirect("http://172.16.1.57:8090/ProyectoServlets/InicioAdivinaConNumero.jsp");
			log.debug("es <");
			break;	
		case "3": // es =
			resp.setContentType("text/html");
			PrintWriter printWriter = resp.getWriter();
			printWriter.println("Numero encontrado!!! tu numero es: "+num);
			log.debug("es =");
			break;
		}
		*/
		
		log.debug("es = "+req.getParameter("es"));
		/*switch (req.getParameter("es")) {
		case "1":
			req.setAttribute("es",">");
			break;
		case "2":
			req.setAttribute("es","<");
			break;
		case "3":
			req.setAttribute("es","=");
			break;	
		}*/
		
		if(req.getParameter("es").equals("1"))
		{
			req.getServletContext().setAttribute("es",">");
			log.debug("es pedido: "+req.getSession(false).getAttribute("es"));
		}	
		if(req.getParameter("es").equals("2"))
		{
			req.getServletContext().setAttribute("es","<");
			log.debug("es pedido: "+req.getSession(false).getAttribute("es"));
		}	
		if(req.getParameter("es").equals("3"))
		{	
			req.getServletContext().setAttribute("es","=");
			log.debug("es pedido: "+req.getSession(false).getAttribute("es"));
		}
		resp.sendRedirect("http://172.16.1.57:8090/ProyectoServlets/InicioAdivinaConNumero.jsp");
		
		
	}

}
