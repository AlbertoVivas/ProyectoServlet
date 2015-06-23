/**
 * 
 */
package practica1.jdbc;


/**
 * @author Alberto Vivas
 *
 * 
 */
public class EmpleadoDTO implements Comparable<EmpleadoDTO>{
	private String employee_id;
	private String first_name;
	private String last_name;
	private String email;
	private String phone_number;
	private String hire_date;
	private String job_id;
	private int salary;
	private String commision_pct;
	private String mannager_id;
	private String department_id;
	
	
	public EmpleadoDTO(String employee_id, String first_name, String last_name,
			String email, String phone_number, String hire_date, String job_id,
			int salary, String commision_pct, String mannager_id,
			String department_id) {
		this.employee_id = employee_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.phone_number = phone_number;
		this.hire_date = hire_date;
		this.job_id = job_id;
		this.salary = salary;
		this.commision_pct = commision_pct;
		this.mannager_id = mannager_id;
		this.department_id = department_id;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String respuesta="";
		
		respuesta+="-------------------------------------"+"\n";
		respuesta+="Identificador de empleado: "+employee_id+"\n";
		respuesta+="Nombre: "+first_name+"\n";
		respuesta+="Apellido: "+last_name+"\n";
		respuesta+="Email: "+email+"\n";
		respuesta+="Numero de teléfono: "+phone_number+"\n";
		respuesta+="Fecha de inicio de contrato: "+hire_date+"\n";
		respuesta+="Identificador de Trabajo: "+job_id+"\n";
		respuesta+="Salario: "+salary+"\n";
		respuesta+="Comision(%): "+commision_pct+"\n";
		respuesta+="Identificador del Manager: "+mannager_id+"\n";
		respuesta+="Identidicador del Departamento: "+department_id+"\n";
		respuesta+="-------------------------------------";
		return respuesta;
		//return this.first_name+" "+this.last_name+" "+this.salary;
	}
	
	public String imprime(){
		return first_name+" "+last_name+" "+department_id+" "+salary;
	}
	
	/**
	 * 
	 */
	@Override
	public int compareTo(EmpleadoDTO e) {
		// TODO Auto-generated method stub
		return e.getSalary()-this.getSalary();
	}

	public String getEmployee_id() {
		return employee_id;
	}


	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
	}


	public String getFirst_name() {
		return first_name;
	}


	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}


	public String getLast_name() {
		return last_name;
	}


	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhone_number() {
		return phone_number;
	}


	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}


	public String getHire_date() {
		return hire_date;
	}


	public void setHire_date(String hire_date) {
		this.hire_date = hire_date;
	}


	public String getJob_id() {
		return job_id;
	}


	public void setJob_id(String job_id) {
		this.job_id = job_id;
	}


	public int getSalary() {
		return salary;
	}


	public void setSalary(int salary) {
		this.salary = salary;
	}


	public String getCommision_pct() {
		return commision_pct;
	}


	public void setCommision_pct(String commision_pct) {
		this.commision_pct = commision_pct;
	}


	public String getMannager_id() {
		return mannager_id;
	}


	public void setMannager_id(String mannager_id) {
		this.mannager_id = mannager_id;
	}


	public String getDepartment_id() {
		return department_id;
	}


	public void setDepartment_id(String department_id) {
		this.department_id = department_id;
	}
	
	public String toStringjdbc() {
		String respuesta="";
		
		respuesta+="-------------------------------------"+"<br>\n";
		//respuesta+="Identificador de empleado: "+employeeId+"<br>\n";
		respuesta+="Nombre: "+first_name+"<br>\n";
		respuesta+="Apellido: "+last_name+"<br>\n";
		respuesta+="Email: "+email+"<br>\n";
		respuesta+="Numero de teléfono: "+phone_number+"<br>\n";
		respuesta+="Fecha de inicio de contrato: "+hire_date+"<br>\n";
		//respuesta+="Identificador de Trabajo: "+jobs.getJobId()+"<br>\n";
		respuesta+="Salario: "+salary+"<br>\n";
		respuesta+="Comision(%): "+commision_pct+"<br>\n";
		//respuesta+="Identificador del Manager: "+employees+"<br>\n";
		//respuesta+="Identidicador del Departamento: "+departments.getDepartmentId()+"<br>\n";
		respuesta+="-------------------------------------<br>";
		return respuesta;
		//return this.first_name+" "+this.last_name+" "+this.salary;
	}
}