package org.web.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bms_address")
public class Address {
@Id
@Column(name = "email", length = 100, nullable = false)
private String email;	

@Column(name = "street", length = 100, nullable = false)
private String street;

@Column(name = "address", length = 100, nullable = false)
private String address;

@Column(name = "zip", length = 100, nullable = false)
private String zip;

@Column(name = "state", length = 100, nullable = false)
private String state;

@Column(name = "phone", length = 100, nullable = false)
private String phone;

@Column(name = "country", length = 100, nullable = false)
private String country;

@Column(name = "firstname", length = 22, nullable = false)
private String firstName;

@Column(name = "lastname", length = 22, nullable = false)
private String lastName;

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getStreet() {
	return street;
}

public void setStreet(String street) {
	this.street = street;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}



public String getState() {
	return state;
}

public void setState(String state) {
	this.state = state;
}



public String getPhone() {
	return phone;
}

public void setPhone(String phone) {
	this.phone = phone;
}

public String getCountry() {
	return country;
}

public void setCountry(String country) {
	this.country = country;
}

public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public String getZip() {
	return zip;
}

public void setZip(String zip) {
	this.zip = zip;
}



}
