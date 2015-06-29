/**
 * 
 */
package practica1.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Alberto Vivas
 *
 * 
 */
public class ServletEscucharRadio extends HttpServlet{

	String los40 = "http://en-directo.frequence-radio.com/los-40-principales.html";
	String cad100 = "http://en-directo.frequence-radio.com/cadena-100.html";
	String eufm =  "http://en-directo.frequence-radio.com/europa-fm.html";
	String rad3 = "http://en-directo.frequence-radio.com/radio-3.html";
	
	String mionda = "http://172.16.1.57:8090/ProyectoServlets/OndaCero.html";
	String micad100 = "http://172.16.1.57:8090/ProyectoServlets/Cad100.html";
	String mieufm = "http://172.16.1.57:8090/ProyectoServlets/EuropaFm.html";
	String mirad3 = "http://172.16.1.57:8090/ProyectoServlets/Rad3.html";
	String flaix = "http://172.16.1.57:8090/ProyectoServlets/Flaix.html";
	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String dir = "";
		if (req.getParameter("estacion").equals("1")){
			dir = los40;
		}
		if (req.getParameter("estacion").equals("2")){
			dir = cad100;
		}
		switch (req.getParameter("estacion")) {
		case "1":
			dir = mionda;
			break;
		case "2":
			dir = micad100;
			break;
		case "3":
			dir = flaix;
			break;
		case "4":
			dir = mirad3;
			break;
		}
		resp.sendRedirect(dir);
	}
}
