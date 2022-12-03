package com.cestar.model;

import java.util.Date;

/*
 * Model class to store Patient details
 */
public class Patient {
	private int patientId;
	private String name;
	private String contact;
	private String region;
	private String disease;
	private String visitDate;

	public Patient(int patientId, String name, String contact, String region, String disease, String visitDate) {
		super();
		this.patientId = patientId;
		this.name = name;
		this.contact = contact;
		this.region = region;
		this.disease = disease;
		this.visitDate = visitDate;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getDisease() {
		return disease;
	}

	public void setDisease(String disease) {
		this.disease = disease;
	}

	public String getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(String visitDate) {
		this.visitDate = visitDate;
	}

	@Override
	public String toString() {
		return "patientId=" + patientId + ", name=" + name + ", contact=" + contact + ", region=" + region
				+ ", disease=" + disease + ", visitDate=" + visitDate + "\n";
	}

}
