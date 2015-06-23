/**
 * 
 */
package practica1.jdbc;

/**
 * @author Alberto Vivas
 *
 * 
 */
public class InstruccionesSQL {
	//public static string consultaSueldo
	
	public static String leerEmpleadoPorID(){
		return "select * from EMPLOYEES WHERE Employee_ID=?";
	}
}
