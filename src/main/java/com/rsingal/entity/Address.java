package com.rsingal.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "ADDRESS")
public class Address {

	private Integer addressId;
	private String address;

	public Address() {
	}

	public Address(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Address [addressId = " + addressId + ", address = " + address + "]";
	}

	@Id
	@GenericGenerator(name = "mygen1", strategy = "increment")
	@GeneratedValue(generator = "mygen1")
	@Column(name = "ID_ADDRESS", unique = true, nullable = false)
	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer id) {
		this.addressId = id;
	}

	@Column(name = "ADDRESS", nullable = true, length = 256)
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
