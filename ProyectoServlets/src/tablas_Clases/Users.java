package tablas_Clases;

public class Users implements java.io.Serializable {

	private String nombre;
	private String clave;

	public Users() {
	}

	public Users(String nombre, String clave) {
		this.nombre = nombre;
		this.clave = clave;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getClave() {
		return this.clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}
	
	@Override
	public String toString() {
		String res = "";
		res += "Nombre: "+ this.nombre + ", Contraseña: " + this.clave;
		return res;
	}

}