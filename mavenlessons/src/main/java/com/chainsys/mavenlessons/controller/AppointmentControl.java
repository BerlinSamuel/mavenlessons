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
import com.chainsys.mavenlessons.repository.AppointmentRepository;

@RestController
public class AppointmentControl {
@Autowired
private AppointmentRepository repo;

@GetMapping(value="/getdoctorappointmentid")
public String getDoctorByAppointmentId(int app_id) {
	Appointment app=repo.findById(app_id);
		Doctor doc=app.getDoctor();
		return doc.toString();
	}
@GetMapping("/getappointment")
public Appointment getAppointmentById(int app_id) {
	return repo.findById(app_id);
}
@PostMapping(value="/newappointment", consumes="application/json")
public RedirectView addAppointment(@RequestBody Appointment app) {
	repo.save(app);
	return new RedirectView("/getallappointments");
}
@DeleteMapping("/deleteappointment")
public RedirectView deleteAppointment(int id) {
	 repo.deleteById(id);
		return new RedirectView("/getallappointments");
}
@GetMapping("/getallappointment")
public List<Appointment> getAllAppointment(){
	return repo.findAll();
}
//@GetMapping(value="getappointmentbydoctorid")
//public List<Appointment> getAppointmentByDocId(int id){
//	return repo.findAllDoctorId(id);
//}
@PostMapping("/updateappointment" )
	public RedirectView modifyAppointment(@RequestBody Appointment app) {
		repo.save(app);
		return new RedirectView("/getallappointments");
	}
}
