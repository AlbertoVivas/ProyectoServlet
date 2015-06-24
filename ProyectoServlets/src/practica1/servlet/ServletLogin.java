/**
 * 
 */
package practica1.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import practica1.hibernate.UsersHibernateDAO;

import tablas_Clases.Users;

/**
 * @author Alberto Vivas
 * 
 * 
 */
@SuppressWarnings("serial")
public class ServletLogin extends HttpServlet {
	private final Logger log = LogManager.getRootLogger();
	private String botom_volver = "<form method=\"get\" action=\"http://localhost:8090/ProyectoServlets/Login.html\"> <button type= \"submit\">Back</button> </form>";

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest
	 * , javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// Session session;
		Users user_get = null;

		UsersHibernateDAO uhdao = new UsersHibernateDAO();

		ServletContext sc = req.getServletContext();
		SessionFactory sf = (SessionFactory) sc.getAttribute("sf");
		Session session = sf.openSession();
		UsersHibernateDAO.setSession(session);

		String nombre = req.getParameter("Nombre");
		String clave = req.getParameter("Pass");

		Users user = new Users(nombre, clave);

		try {
			user_get = uhdao.leerUser(nombre);

			if (user.getNombre().equals(user_get.getNombre())
					&& user.getClave().equals(user_get.getClave())) {
				resp.setContentType("text/html");
				PrintWriter printWriter = resp.getWriter();
				printWriter.println("Bienvenido: " + user.getNombre());
				// printWriter.println("Numero de peticiones: "+num_pet);
				printWriter.println(botom_volver);
			} else {
				resp.setContentType("text/html");
				PrintWriter printWriter = resp.getWriter();
				printWriter.println("Pass incorrecta");
				// printWriter.println("Numero de peticiones: "+num_pet);
				log.error("Pass introducida incorrecta: " + user.getNombre()
						+ " " + user.getClave());
				printWriter.println(botom_volver);
			}

		} catch (Exception e) {
			log.error("Error al obtener usuario: " + user.getNombre() + " "
					+ user.getClave());
			log.error("user_get: " + user_get);
			resp.setContentType("text/html");
			PrintWriter printWriter = resp.getWriter();
			printWriter.println("Error al obtener usuario: " + user.getNombre()
					+ " pass " + user.getClave());
			// printWriter.println("Numero de peticiones: "+num_pet);
			printWriter.println(botom_volver);
		}

		session.close();

	}

}
