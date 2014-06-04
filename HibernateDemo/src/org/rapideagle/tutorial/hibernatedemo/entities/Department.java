package org.rapideagle.tutorial.hibernatedemo.entities;

// Generated 1 Jun, 2014 6:52:00 PM by Hibernate Tools 4.0.0

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Department generated by hbm2java
 */
@Entity
@Table(name = "department", catalog = "scratchtest", uniqueConstraints = @UniqueConstraint(columnNames = "dept_name"))
public class Department implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3013582493483729201L;
	private Long departmentId;
	private String deptName;
	private Set<Employee> employees = new HashSet<Employee>(0);

	public Department() {
	}

	public Department(String deptName) {
		this.deptName = deptName;
	}

	public Department(String deptName, Set<Employee> employees) {
		this.deptName = deptName;
		this.employees = employees;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "department_id", unique = true, nullable = false)
	public Long getDepartmentId() {
		return this.departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}
	
	@Column(name = "dept_name", unique = true, nullable = false, length = 50)
	public String getDeptName() {
		return this.deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "department")
	public Set<Employee> getEmployees() {
		return this.employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

}
