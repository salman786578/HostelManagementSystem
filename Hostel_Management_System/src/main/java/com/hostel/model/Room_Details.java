package com.hostel.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity(name = "room_details")
public class Room_Details {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull(message = "RoomNumber should be specified")
	private Integer roomNumber;
	@NotNull(message = "IsVacant should be specified")
	private Boolean isVacant;
	@NotNull(message = "Rent should be specified")
	private Integer rent;

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Boolean getIsVacant() {
		return isVacant;
	}

	public void setIsVacant(Boolean isVacant) {
		this.isVacant = isVacant;
	}

	public Integer getRent() {
		return rent;
	}

	public void setRent(Integer rent) {
		this.rent = rent;
	}

}
