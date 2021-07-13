package com.hostel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hostel.model.Room_Details;
import com.hostel.repository.RoomDetailsRepository;

@Service
@Transactional
public class RoomDetailsService {
	   @Autowired
	    private RoomDetailsRepository repo;
	     
	    public List<Room_Details> listAll() {
	        return repo.findAll();
	    }
	     
	    public void save(Room_Details details) {
	        repo.save(details);
	    }
	     
	    public Room_Details get(Integer id) {
	        return repo.findById(id).get();
	    }
	     
	    public void delete(Integer id) {
	        repo.deleteById(id);
	    }
	
}
