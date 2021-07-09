package com.hostel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hostel.model.Student_Details;
import com.hostel.repository.StudentDetailsRepository;

@Service
@Transactional
public class StudentDetailsService {
	   @Autowired
	    private StudentDetailsRepository repo;
	     
	    public List<Student_Details> listAll() {
	        return repo.findAll();
	    }
	     
	    public void save(Student_Details details) {
	        repo.save(details);
	    }
	     
	    public Student_Details get(Integer id) {
	        return repo.findById(id).get();
	    }
	     
	    public void delete(Integer id) {
	        repo.deleteById(id);
	    }
	
}
