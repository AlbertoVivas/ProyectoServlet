package tablas_Clases;

// default package
// Generated 09-jun-2015 15:28:21 by Hibernate Tools 4.0.0

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Employees generated by hbm2java
 */
public class Employees implements java.io.Serializable {

	private int employeeId;
	private Jobs jobs;
	private Departments departments;
	private Employees employees;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private Date hireDate;
	private BigDecimal salary;
	private BigDecimal commissionPct;
	private Set employeeses = new HashSet(0);
	private Set departmentses = new HashSet(0);
	private Set jobHistories = new HashSet(0);

	public Employees() {
	}

	public Employees(int employeeId, Jobs jobs, String lastName, String email,
			Date hireDate) {
		this.employeeId = employeeId;
		this.jobs = jobs;
		this.lastName = lastName;
		this.email = email;
		this.hireDate = hireDate;
	}

	public Employees(int employeeId, Jobs jobs, Departments departments,
			Employees employees, String firstName, String lastName,
			String email, String phoneNumber, Date hireDate, BigDecimal salary,
			BigDecimal commissionPct, Set employeeses, Set departmentses,
			Set jobHistories) {
		this.employeeId = employeeId;
		this.jobs = jobs;
		this.departments = departments;
		this.employees = employees;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.hireDate = hireDate;
		this.salary = salary;
		this.commissionPct = commissionPct;
		this.employeeses = employeeses;
		this.departmentses = departmentses;
		this.jobHistories = jobHistories;
	}

	public int getEmployeeId() {
		return this.employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public Jobs getJobs() {
		return this.jobs;
	}

	public void setJobs(Jobs jobs) {
		this.jobs = jobs;
	}

	public Departments getDepartments() {
		return this.departments;
	}

	public void setDepartments(Departments departments) {
		this.departments = departments;
	}

	public Employees getEmployees() {
		return this.employees;
	}

	public void setEmployees(Employees employees) {
		this.employees = employees;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getHireDate() {
		return this.hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public BigDecimal getSalary() {
		return this.salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public BigDecimal getCommissionPct() {
		return this.commissionPct;
	}

	public void setCommissionPct(BigDecimal commissionPct) {
		this.commissionPct = commissionPct;
	}

	public Set getEmployeeses() {
		return this.employeeses;
	}

	public void setEmployeeses(Set employeeses) {
		this.employeeses = employeeses;
	}

	public Set getDepartmentses() {
		return this.departmentses;
	}

	public void setDepartmentses(Set departmentses) {
		this.departmentses = departmentses;
	}

	public Set getJobHistories() {
		return this.jobHistories;
	}

	public void setJobHistories(Set jobHistories) {
		this.jobHistories = jobHistories;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return firstName+" "+lastName+" "+salary.intValue();
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		Employees e = (Employees)obj;
		return this.employeeId==e.getEmployeeId() && this.firstName.equals(e.getFirstName())&& this.lastName.equals(e.getLastName());
	}
	
	public String imprime(){
		String srt_dev="";
		srt_dev+=this.firstName+" ";
		srt_dev+=this.lastName+" ";
		for (int i = 0; i < 22-(this.firstName.length()+this.lastName.length()+2); i++) {
			srt_dev+=" ";
		}
		srt_dev+=this.departments.getDepartmentId()+"        "+this.salary;
		
		return srt_dev;
		//return this.firstName+" "+this.lastName+" "+this.departments.getDepartmentId()+" "+this.salary;
	}
	public String imprimeme(){
		return firstName+" "+lastName+" "+departments.getDepartmentId()+" "+salary;
	}
	public String toStringjdbc() {
		String respuesta="";
		
		respuesta+="-------------------------------------"+"<br>\n";
		//respuesta+="Identificador de empleado: "+employeeId+"<br>\n";
		respuesta+="Nombre: "+firstName+"<br>\n";
		respuesta+="Apellido: "+lastName+"<br>\n";
		respuesta+="Email: "+email+"<br>\n";
		respuesta+="Numero de tel�fono: "+phoneNumber+"<br>\n";
		respuesta+="Fecha de inicio de contrato: "+hireDate+"<br>\n";
		//respuesta+="Identificador de Trabajo: "+jobs.getJobId()+"<br>\n";
		respuesta+="Salario: "+salary+"<br>\n";
		respuesta+="Comision(%): "+commissionPct+"<br>\n";
		//respuesta+="Identificador del Manager: "+employees+"<br>\n";
		//respuesta+="Identidicador del Departamento: "+departments.getDepartmentId()+"<br>\n";
		respuesta+="-------------------------------------<br>";
		return respuesta;
		//return this.first_name+" "+this.last_name+" "+this.salary;
	}
}
