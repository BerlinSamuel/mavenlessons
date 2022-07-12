package com.chainsys.mavenlessons.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Appointments")
public class Appointment {
	@Id
	@Column(name = "app_id")
	private int appointment_id;
	@Column(name = "app_date")
	private Date appointment_date;
//	@Column(name = "doctor_id")
//	private int doctor_id;
	@Column(name = "patient_name")
	private String patient_name;
	@Column(name = "fees_collected")
	private float fees_collected;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="doctor_id",nullable=false,insertable=false,updatable=false)
	@JsonIgnore
	private Doctor doctor;
	
	public Doctor getDoctor() {
		return doctor;
	}

	public int getAppointment_id() {
		return appointment_id;
	}
	public void setAppointment_id(int appointment_id) {
		this.appointment_id = appointment_id;
	}
	public Date getAppointment_date() {
		return appointment_date;
	}
	public void setAppointment_date(Date appointment_date) {
		this.appointment_date = appointment_date;
	}
	public String getPatient_name() {
		return patient_name;
	}
	public void setPatient_name(String patient_name) {
		this.patient_name = patient_name;
	}
	public float getFees_collected() {
		return fees_collected;
	}
	public void setFees_collected(float fees_collected) {
		this.fees_collected = fees_collected;
	}

	@Override
	public String toString() {
		return String.format("%d, %s, %s, %2.f", appointment_id,appointment_date,patient_name,fees_collected);	
		}

}
