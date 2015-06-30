/**
 * 
 */
package practica1.servlet;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Alberto Vivas
 *
 * 
 */
public class ServletCookie extends HttpServlet {

	
	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		Cookie[] a_cook =req.getCookies();
		
		if(a_cook != null){
			int tam = a_cook.length;
			int i = 0;
			boolean encontrado = false;
			while(i<tam || !encontrado){
			encontrado=a_cook[i].getName().equals("micookie");	
			i++;		
			}
			if(i==tam && !encontrado){
				Cookie cookie = new Cookie("micokie","30/06/15 21:18");
				cookie.setMaxAge(60*60);//1h
				cookie.setValue("n_conex");
				resp.addCookie(cookie);
			}
			
			if(encontrado){
				Cookie miCookie = a_cook[i];
				miCookie.getValue();
			}
			
		}
		
		
		
	}
	
}
