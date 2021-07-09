package com.hostel.model;

import java.util.Date;

public class HostelInventory {

	private Room_Details room;
	private Student_Details student;
	private Date joindedDate;
	private Integer securityDeposited;

	public Room_Details getRoom() {
		return room;
	}

	public void setRoom(Room_Details room) {
		this.room = room;
	}

	public Student_Details getStudent() {
		return student;
	}

	public void setStudent(Student_Details student) {
		this.student = student;
	}

	public Date getJoindedDate() {
		return joindedDate;
	}

	public void setJoindedDate(Date joindedDate) {
		this.joindedDate = joindedDate;
	}

	public Integer getSecurityDeposited() {
		return securityDeposited;
	}

	public void setSecurityDeposited(Integer securityDeposited) {
		this.securityDeposited = securityDeposited;
	}

}
