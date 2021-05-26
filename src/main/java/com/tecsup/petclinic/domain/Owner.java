package com.tecsup.petclinic.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Id;

@Entity(name = "owners" )   
public class Owner {
	@Id
	
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private long id;
	
	@Column( name = "first_name")
	private String firstName;
	
	@Column( name = "last_name")
	private String lastName;
	
	private String address;
	
	private String city;
	
	private String telephone;

	public Owner() {
		super();
	}

	public Owner(long id, String first_name, String last_name, String address, String city, String telephone) {
		super();
		this.id = id;
		this.lastName = last_name;
		this.firstName = first_name;
		this.address = address;
		this.city = city;
		this.telephone = telephone;
	}

	public Owner(long id, String first_name, String last_name) {
		super();
		this.id = id;
		this.lastName = last_name;
		this.firstName = first_name;
	}

	
	
	
	public Owner(String firstName, String lastName, String address, String city, String telephone) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.telephone = telephone;
	}

	public Owner(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirst_name() {
		return firstName;
	}

	public void setFirst_name(String first_name) {
		this.firstName = first_name;
	}

	public String getLast_name() {
		return lastName;
	}

	public void setLast_name(String last_name) {
		this.lastName = last_name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Override
	public String toString() {
		return "Owner [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", address=" + address
				+ ", city=" + city + ", telephone=" + telephone + "]";
	}
	
}
