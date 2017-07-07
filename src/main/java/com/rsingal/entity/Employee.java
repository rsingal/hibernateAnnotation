package com.rsingal.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "EMPLOYEE")
public class Employee {

	private Integer employeeId;
	private String employeeName;
	private Address address;
	private Company company;
	private Set<Account> accounts = new HashSet<Account>();
	private Set<Training> trainings = new HashSet<Training>();
	private Set<EmpTrngMappingExtended> empTrngMappingExts = new HashSet<EmpTrngMappingExtended>();

	public Employee() {
	}

	public Employee(String name) {
		this.employeeName = name;
	}

	@Override
	public String toString() {
		return "\n  Employee [employeeId = " + employeeId + ", employeeName = " + employeeName + //
				"\n    address = " + address + //
				"\n    company = " + company + //
				"\n    accounts = " + accounts + //
				"\n    trainings = " + trainings + //
				"\n    empTrngMappingExts = " + empTrngMappingExts + //
				"]";
	}

	@Id
	@GenericGenerator(name = "mygen1", strategy = "increment")
	@GeneratedValue(generator = "mygen1")
	@Column(name = "ID_EMPLOYEE", unique = true, nullable = false)
	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer id) {
		this.employeeId = id;
	}

	@Column(name = "EMPLOYEE_NAME", nullable = false, length = 32)
	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String name) {
		this.employeeName = name;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@Cascade({ CascadeType.ALL })
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@ManyToOne
	@Cascade({ CascadeType.SAVE_UPDATE })
	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
	@Cascade({ CascadeType.ALL })
	@Fetch(FetchMode.SELECT)
	public Set<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(Set<Account> accounts) {
		this.accounts = accounts;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@Cascade({ CascadeType.SAVE_UPDATE })
	@JoinTable(name = "EMP_TRNG_MAPPING", joinColumns = { @JoinColumn(name = "ID_EMPLOYEE", nullable = false) }, inverseJoinColumns = { @JoinColumn(name = "ID_TRAINING", nullable = false) })
	public Set<Training> getTrainings() {
		return trainings;
	}

	public void setTrainings(Set<Training> trainings) {
		this.trainings = trainings;
	}

	@SuppressWarnings("deprecation")
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "empTrngMappingExtId.employee")
	@Cascade({ CascadeType.ALL, CascadeType.DELETE_ORPHAN })
	@Fetch(FetchMode.SELECT)
	public Set<EmpTrngMappingExtended> getEmpTrngMappingExts() {
		return empTrngMappingExts;
	}

	public void setEmpTrngMappingExts(Set<EmpTrngMappingExtended> empTrngMappingExts) {
		this.empTrngMappingExts = empTrngMappingExts;
	}
}
