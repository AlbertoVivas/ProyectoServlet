/**
 * 
 */
package practica1.hibernate;

import java.sql.SQLException;

/**
 * @author Alberto Vivas
 *
 * 
 */
public interface Recuperable {
	Object leerEmpleado(Object id) throws SQLException;
}
