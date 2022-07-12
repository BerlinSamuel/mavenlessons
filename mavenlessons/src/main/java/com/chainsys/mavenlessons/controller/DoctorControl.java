package com.chainsys.mavenlessons.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.chainsys.mavenlessons.entity.Appointment;
import com.chainsys.mavenlessons.entity.Doctor;
import com.chainsys.mavenlessons.repository.DoctorRepository;


@RestController
public class DoctorControl {
	@Autowired
	private DoctorRepository repo;
//	@GetMapping("/getdoctor")
//	public Doctor getDoctor(int id) {
//		return repo.findById(id);
//	}

	@GetMapping("/getdoctorappointment")
	public String getDoctor(int id) {
		return repo.findById(id).toString();
	}
	
	@GetMapping("/getdoctorappointments")
	public String getAppointments(int id) {
		Doctor doc =  repo.findById(id);
		List<Appointment> appointments = doc.getAppointments();
		return appointments.toString();
	}
	@PostMapping(value="/newdoctor", consumes="application/json" )
	// we need give from where to read data from the HTTP request and also the content type("application/json")
	public RedirectView addNewDoctor(@RequestBody Doctor dr) {
		//System.out.println("Doctor:"+dr.getDoctor_id()+" "+dr.getDoctor_name());
		repo.save(dr);
		return new RedirectView("/getalldoctor");
	}
	@DeleteMapping("/deletedoctor")
	public RedirectView deleteDoctor(int id) {
		repo.deleteById(id);
		return new RedirectView("/getalldoctor");
	}
	@GetMapping("/getalldoctor")
	public List<Doctor> getAllDoctor(){
		return repo.findAll();
	}
	@PostMapping(value="/updatedoctor", consumes="application/json" )
	// we need give from where to read data from the HTTP request and also the content type("application/json")
	public String modifyDoctor(Doctor dr) {
		repo.save(dr);
		return "redirect:/getalldoctor";
	}
}
