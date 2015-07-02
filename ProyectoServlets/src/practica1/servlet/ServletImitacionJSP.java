/**
 * 
 */
package practica1.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Alberto Vivas
 *
 * 
 */
public class ServletImitacionJSP extends HttpServlet {

	
	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String parte1 = "<html>"+ 
							"<head>"+ 
								"<title>Hola Mundo</title>"+
							"</head>" +
							"<body>"+ 
							"<p>Hola, esto es una página JSP.</p>"+ 
							"<p>La hora del servidor es"; 
		String parte2 = "%></p>"+ 
							"</body>" +
						"</html>";
		resp.setContentType("text/html");
		PrintWriter printWriter = resp.getWriter();
		printWriter.println(parte1+new Date()+parte2);
	}
}
