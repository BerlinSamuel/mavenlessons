package com.chainsys.mavenlessons.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Doctor")
public class Doctor {
	@Id
	private int id;
	private String doctor_name;
	private Date dob;
	private String speciality;
	private String city;
	private long phoneno;
	private float standard_fees;

	@OneToMany(mappedBy = "doctor", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Appointment> appointments;

	public List<Appointment> getAppointments() {
		return this.appointments;
	}

	public int getDoctor_id() {
		return id;
	}
	// thank you sir

	public void setDoctor_id(int doctor_id) {
		this.id = doctor_id;
	}

	public String getDoctor_name() {
		return doctor_name;
	}

	public void setDoctor_name(String doctor_name) {
		this.doctor_name = doctor_name;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public long getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(long phoneno) {
		this.phoneno = phoneno;
	}

	public float getStandard_fees() {
		return standard_fees;
	}

	public void setStandard_fees(float standard_fees) {
		this.standard_fees = standard_fees;
	}

	@Override
	public String toString() {
		return String.format("%d,%s,%s,%s,%s,%s,%.2f", id, doctor_name, dob, speciality, city, phoneno, standard_fees);
	}
}