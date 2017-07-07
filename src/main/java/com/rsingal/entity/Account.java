package com.rsingal.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "ACCOUNT")
public class Account {

	private Integer accountId;
	private String bankName;
	private Integer accountNumber;
	private Employee employee;

	public Account() {
	}

	public Account(String bankName, Integer accountNumber) {
		this.bankName = bankName;
		this.accountNumber = accountNumber;
	}

	@Override
	public String toString() {
		return "Account [accountId = " + accountId + ", bankName = " + bankName + ", accountNumber = " + accountNumber + ", employeeId = " + employee.getEmployeeId() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountNumber == null) ? 0 : accountNumber.hashCode());
		result = prime * result + ((bankName == null) ? 0 : bankName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (accountNumber == null) {
			if (other.accountNumber != null)
				return false;
		} else if (!accountNumber.equals(other.accountNumber))
			return false;
		if (bankName == null) {
			if (other.bankName != null)
				return false;
		} else if (!bankName.equals(other.bankName))
			return false;
		return true;
	}

	@Id
	@GenericGenerator(name = "mygen1", strategy = "increment")
	@GeneratedValue(generator = "mygen1")
	@Column(name = "ID_ACCOUNT", unique = true, nullable = false)
	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer id) {
		this.accountId = id;
	}

	@Column(name = "BANK_NAME", nullable = false, length = 32)
	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	@Column(name = "ACCOUNT_NUMBER", nullable = false, length = 16)
	public Integer getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Integer accountNumber) {
		this.accountNumber = accountNumber;
	}

	@ManyToOne
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
}
