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
import com.hostel.model.Student_Details;
import com.hostel.service.StudentDetailsService;

@RestController
@RequestMapping("/api/v1")
public class StudentDetailsController {

	@Autowired
	private StudentDetailsService service;

	@PostMapping("/insertStudentDetails")
	public ResponseEntity<Response> collectStudentInformation(@Valid @RequestBody Student_Details request) {
		Student_Details studentInfo = new Student_Details();
		studentInfo.setName(request.getName());
		studentInfo.setAdhaarNumber(request.getAdhaarNumber());
		studentInfo.setPermanentAdress(request.getPermanentAdress());
		studentInfo.setLandMark(request.getLandMark());
		studentInfo.setCity(request.getCity());
		studentInfo.setState(request.getState());
		studentInfo.setPincode(request.getPincode());
		studentInfo.setPhoneNumber(request.getPhoneNumber());
		studentInfo.setPurposeOfStay(request.getPurposeOfStay());
		// save studentInfo into db
		service.save(studentInfo);
		Response response = new Response();
		response.setMessage("Inserted Successfully");
		return new ResponseEntity<Response>(response, HttpStatus.OK);

	}

	@GetMapping("/fetchStudentsDetail")
	public List<Student_Details> getStudentDetails() {
		return service.listAll();
	}

	@GetMapping("/fetchStudentsDetail/{aadharNumber}")
	public ResponseEntity<Student_Details> getStudentDetailByName(@Valid @PathVariable Integer aadharNumber) {
		Student_Details details = service.get(aadharNumber); // fetch student detailsbyaadhar from db
		return new ResponseEntity<Student_Details>(details, HttpStatus.OK);

	}

	@DeleteMapping("/deleteStudentsDetail/{aadharNumber}")
	public ResponseEntity<Student_Details> deleteStudentDetailByName(@Valid @PathVariable Integer aadharNumber) {
		service.delete(aadharNumber);
		; // delete student detailsbyaadhar from db
		return new ResponseEntity<Student_Details>(HttpStatus.OK);

	}

}
