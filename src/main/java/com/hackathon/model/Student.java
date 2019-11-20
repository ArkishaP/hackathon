package com.hackathon.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

//CREATE TABLE student(
//		id VARCHAR2(5) NOT NULL PRIMARY KEY,
//		first_name VARCHAR2(50),
//		last_name VARCHAR2(50),
//		gender VARCHAR2(10),
//		email VARCHAR2(100),
//		password VARCHAR2(100),
//		birth_date DATE,
//		address VARCHAR2(100),
//		contact_number VARCHAR2(10)	
//	);

@Entity
public class Student {
	@Id
	@Column(name="id")
	private String studentId;
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	private String gender;
	private String email;
	private String password;
	@Temporal(TemporalType.DATE)
	@Column(name="birth_date")
	private Date dob;
	private String city;
	private String state;
	@Column(name="contact_number")
	private String contactNumber;
	
	public Student() {
		super();
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", firstName=" + firstName + ", lastName=" + lastName + ", gender="
				+ gender + ", email=" + email + ", password=" + password + ", dob=" + dob + ", city=" + city
				+ ", state=" + state + ", contactNumber=" + contactNumber + "]";
	}
	
	
}