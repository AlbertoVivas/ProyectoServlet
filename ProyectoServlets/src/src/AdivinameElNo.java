/**
 * 
 */
package src;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Alberto Vivas
 *
 * 
 */
public class AdivinameElNo {
	private final static Logger log = LogManager.getRootLogger();
	
	public static int num_aleatorio (int lim_inf, int lim_sup){
		int resp;
		resp = (int)(Math.random()*(lim_sup-lim_inf+1)+lim_inf);
		log.debug("pase por num_aleatorio, lim_inf="+lim_inf+" lim_sup="+lim_sup +" y es: "+resp);
		return resp;
	}
}
