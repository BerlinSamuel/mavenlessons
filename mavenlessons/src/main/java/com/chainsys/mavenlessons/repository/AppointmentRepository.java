package com.chainsys.mavenlessons.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.chainsys.mavenlessons.entity.Appointment;


public interface AppointmentRepository extends CrudRepository<Appointment,Integer>{
	Appointment findById(int id);
	Appointment save(Appointment appointment);
	void deleteById(int id);
	List<Appointment> findAll();
	//@Query(value="select a from Appointment a where a.doctor_id=?1")
	//jpql - java persistent query language
	//here 'a' is an instance of appointment entity
	//List<Appointment> findAllDoctorId(int id);
	List<Appointment> findByDoctorId(int drId);
}
