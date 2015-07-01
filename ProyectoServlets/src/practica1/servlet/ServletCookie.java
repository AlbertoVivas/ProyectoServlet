/**
 * 
 */
package practica1.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
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




public class ServletCookie extends HttpServlet {
	private final Logger log = LogManager.getRootLogger();
	
	
	public void resetcokie(Cookie c, HttpServletResponse r){
		c.setValue("01/07/15 15:22 0");
		r.addCookie(c);
		
	}
	
	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int n_veces = 0;
		Cookie[] a_cook =req.getCookies();
		log.trace("en doget cookie");
		//int asdasd = null;
		if (a_cook != null) {
			log.trace("array de cookies != null");
			int tam = a_cook.length;
			log.trace("tamaño: "+tam);
			int i = 0;
			String valor = "";
			boolean encontrado = false;
			while (i < tam && !encontrado) {
				encontrado = a_cook[i].getName().equals("micokie");
				log.trace("entre while, i= "+i+" encontrado = "+encontrado);
				if(!encontrado)i++;
			}
			log.debug("salgo while, i="+i+" encontrado = "+encontrado);
			if (i == tam && !encontrado) {
				log.trace("if(i == tam && !encontrado)");
				//Cookie cookie = new Cookie("micokie", "01/07/15 15:22 0");
				Cookie cookie = new Cookie("micokie", "0");
				cookie.setMaxAge(60 * 60);// 1h
				// cookie.setValue("n_conex");
				resp.addCookie(cookie);
				log.trace("creada nueva cookie ");
				resp.setContentType("text/html");
				PrintWriter printWriter = resp.getWriter();
				printWriter.println("Bienvenido, ha accedido: " + n_veces+ " de 3");
				printWriter.println("cookie "+cookie.getName()+" "+cookie.getValue());
			}

			if (encontrado) {
				Cookie miCookie = a_cook[i];
				
				//n_veces = miCookie.getValue().charAt(miCookie.getValue().length() - 1);
				n_veces = Integer.parseInt(miCookie.getValue());
				log.trace("Encontrado!!! value: " + miCookie.getValue()+ " num veces: " + n_veces);

				if (n_veces >= 3) {
					valor = miCookie.getValue();
					n_veces++;
					//valor = valor.substring(0, valor.length() - 2) + n_veces;
					//miCookie.setValue(valor);
					miCookie.setValue(""+n_veces);
					resp.addCookie(miCookie);

					resp.setContentType("text/html");
					PrintWriter printWriter = resp.getWriter();
					printWriter.println("Numero de accesos maximos alcanzados: "+ n_veces);
					printWriter.println("<br>cookie: "+miCookie.getName()+" "+miCookie.getValue());
					log.debug("Numero de accesos maximos alcanzados: "+ n_veces);
					miCookie.setMaxAge(0);
					resp.addCookie(miCookie);
					//resetcokie(miCookie, resp);
				} else {
					valor = miCookie.getValue();
					log.debug("valor cookie" + valor);
					n_veces++;
					//valor = valor.substring(0, valor.length() - 2) + n_veces;
					//miCookie.setValue(valor);
					miCookie.setValue(""+n_veces);
					resp.addCookie(miCookie);
					resp.setContentType("text/html");
					PrintWriter printWriter = resp.getWriter();
					printWriter.println("Bienvenido, ha accedido: " + n_veces+ " de 3");
				}

			}

		} else {
			log.trace("array de cookies = null y me creo mi cookie");
			//Cookie cookie = new Cookie("micokie", "01/07/15 15:22 0");
			Cookie cookie = new Cookie("micokie", "0");
			cookie.setMaxAge(60 * 60);// 1h
			// cookie.setValue("n_conex");
			resp.addCookie(cookie);
			resp.setContentType("text/html");
			PrintWriter printWriter = resp.getWriter();
			printWriter.println("Bienvenido, ha accedido: " + n_veces + " de 3");
		}

	}
	
}
