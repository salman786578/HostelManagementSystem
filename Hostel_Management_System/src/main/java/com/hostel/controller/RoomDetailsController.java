package com.hostel.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hostel.model.Response;
import com.hostel.model.Room_Details;
import com.hostel.service.RoomDetailsService;

@RestController
@RequestMapping("/api/v1")
public class RoomDetailsController {

	@Autowired
	private RoomDetailsService service;

	@PostMapping("/insertRoomDetails")
	public ResponseEntity<Response> collectStudentInformation(@Valid @RequestBody Room_Details request) {
		Room_Details roomInfo = new Room_Details();
		roomInfo.setRoomNumber(request.getRoomNumber());
		roomInfo.setIsVacant(request.getIsVacant());
		roomInfo.setRent(request.getRent());
		// save studentInfo into db
		service.save(roomInfo);
		Response response = new Response();
		response.setMessage("Inserted Successfully");
		return new ResponseEntity<Response>(response, HttpStatus.OK);

	}

	@GetMapping("/fetchRoomDetail")
	public List<Room_Details> getRoomDetails() {
		return service.listAll();
	}

	@GetMapping("/fetchRoomDetail/{roomNumber}")
	public ResponseEntity<Room_Details> getRoomDetailByRoomNumber(@Valid @PathVariable Integer roomNumber) {
		Room_Details details = service.get(roomNumber); // fetch room detailsbyroomnumber from db
		return new ResponseEntity<Room_Details>(details, HttpStatus.OK);

	}

	@DeleteMapping("/deleteRoomDetail/{roomNumber}")
	public ResponseEntity<Room_Details> deleteRoomDetailByName(@Valid @PathVariable Integer roomNumber) {
		service.delete(roomNumber);
		; // delete student detailsbyaadhar from db
		return new ResponseEntity<Room_Details>(HttpStatus.OK);

	}

}
