/**
 * 
 */
package practica1.hibernate;

import java.sql.SQLException;

import practica1.hibernate.Recuperable;

/**
 * @author Alberto Vivas
 *
 * 
 */
public class EmployeesServices {
	private Recuperable obj_dao;
	
	public void setRecuperable(Recuperable obj_dao){
		this.obj_dao=obj_dao;
	}
	
	public Object leerEmpleado(int nombre) throws SQLException{
		return obj_dao.leerEmpleado(nombre);
	}
	
}
