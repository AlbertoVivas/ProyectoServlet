package tablas_Clases;

// default package
// Generated 09-jun-2015 15:28:21 by Hibernate Tools 4.0.0

import java.util.Date;

/**
 * JobHistory generated by hbm2java
 */
@SuppressWarnings("serial")
public class JobHistory implements java.io.Serializable {

	private JobHistoryId id;
	private Employees employees;
	private Jobs jobs;
	private Departments departments;
	private Date endDate;

	public JobHistory() {
	}

	public JobHistory(JobHistoryId id, Employees employees, Jobs jobs,
			Date endDate) {
		this.id = id;
		this.employees = employees;
		this.jobs = jobs;
		this.endDate = endDate;
	}

	public JobHistory(JobHistoryId id, Employees employees, Jobs jobs,
			Departments departments, Date endDate) {
		this.id = id;
		this.employees = employees;
		this.jobs = jobs;
		this.departments = departments;
		this.endDate = endDate;
	}

	public JobHistoryId getId() {
		return this.id;
	}

	public void setId(JobHistoryId id) {
		this.id = id;
	}

	public Employees getEmployees() {
		return this.employees;
	}

	public void setEmployees(Employees employees) {
		this.employees = employees;
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

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

}
