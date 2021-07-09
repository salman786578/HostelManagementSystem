package com.hostel.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity(name = "student_details")
public class Student_Details {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull(message = "AadharNumber should be specified")
	@Size(min = 1, max = 12)
	private Integer adhaarNumber;
	@NotNull(message = "Name should be specified")
	private String name;
	@NotNull(message = "PhoneNumber should be specified")
	private Integer phoneNumber;
	@NotNull(message = "PurposeOfStay should be specified")
	private String purposeOfStay;
	@NotNull(message = "PermanentAddress should be specified")
	private String permanentAdress;
	@NotNull(message = "LandMark should be specified")
	private String landMark;
	@NotNull(message = "City should be specified")
	private String city;
	@NotNull(message = "State should be specified")
	private String state;
	@NotNull(message = "Pincode should be specified")
	private Integer pincode;

	public Integer getAdhaarNumber() {
		return adhaarNumber;
	}

	public void setAdhaarNumber(Integer adhaarNumber) {
		this.adhaarNumber = adhaarNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Integer phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPurposeOfStay() {
		return purposeOfStay;
	}

	public void setPurposeOfStay(String purposeOfStay) {
		this.purposeOfStay = purposeOfStay;
	}

	public String getPermanentAdress() {
		return permanentAdress;
	}

	public void setPermanentAdress(String permanentAdress) {
		this.permanentAdress = permanentAdress;
	}

	public String getLandMark() {
		return landMark;
	}

	public void setLandMark(String landMark) {
		this.landMark = landMark;
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

	public Integer getPincode() {
		return pincode;
	}

	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}

}
