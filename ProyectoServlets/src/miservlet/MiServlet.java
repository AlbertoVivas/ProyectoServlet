/**
 * 
 */
package miservlet;

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
@SuppressWarnings("serial")
public class MiServlet extends HttpServlet{
	/* (non-Javadoc) 
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Ha llamado a doget");
		String nombre = req.getParameter("nombre");
		System.out.println("doget nombre: "+nombre);
		String respuesta= "el numero de letras del nombre: "+nombre+" es: "+nombre.length();
		resp.setContentType(respuesta);
		PrintWriter printWriter = resp.getWriter();
		printWriter.println(respuesta);
		//super.doGet(req, resp);
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
		System.out.println("ha llamado a service");
		super.service(arg0, arg1);
	}
}
