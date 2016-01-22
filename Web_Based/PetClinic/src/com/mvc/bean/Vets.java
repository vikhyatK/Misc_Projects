package com.mvc.bean;

import java.io.Serializable;


public class Vets implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int vet_id;
	private String vet_fname;
	private String vet_lname;
	private String speciality;
	private int phone;

	public Vets() {
		// TODO Auto-generated constructor stub
	}

	public Vets(int vet_id, String vet_fname, String vet_lname,
			String speciality, int phone) {
		super();
		this.vet_id = vet_id;
		this.vet_fname = vet_fname;
		this.vet_lname = vet_lname;
		this.speciality = speciality;
		this.phone = phone;
	}

	public int getVet_id() {
		return vet_id;
	}

	public void setVet_id(int vet_id) {
		this.vet_id = vet_id;
	}

	public String getVet_fname() {
		return vet_fname;
	}

	public void setVet_fname(String vet_fname) {
		this.vet_fname = vet_fname;
	}

	public String getVet_lname() {
		return vet_lname;
	}

	public void setVet_lname(String vet_lname) {
		this.vet_lname = vet_lname;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Vets [vet_id=" + vet_id + ", vet_fname=" + vet_fname
				+ ", vet_lname=" + vet_lname + ", speciality=" + speciality
				+ ", phone=" + phone + "]";
	}

	
}
