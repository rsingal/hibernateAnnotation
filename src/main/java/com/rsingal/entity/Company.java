package com.rsingal.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "COMPANY", uniqueConstraints = { @UniqueConstraint(columnNames = "COMPANY_NAME") })
public class Company {

	private Integer companyId;
	private String companyName;

	public Company() {
	}

	public Company(String companyName) {
		this.companyName = companyName;
	}

	@Override
	public String toString() {
		return "Company [companyId = " + companyId + ", companyName = " + companyName + "]";
	}

	@Id
	@GenericGenerator(name = "mygen1", strategy = "increment")
	@GeneratedValue(generator = "mygen1")
	@Column(name = "ID_COMPANY", unique = true, nullable = false)
	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	@Column(name = "COMPANY_NAME", nullable = false, length = 32)
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
}
