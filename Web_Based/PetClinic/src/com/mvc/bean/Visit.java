package com.mvc.bean;

import java.io.Serializable;
import java.util.Date;

public class Visit implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int visit_id;
	private int pet_id;
	private int vet_id;
	private String description;
	private Date date;
	
	public int getVisit_id() {
		return visit_id;
	}
	public void setVisit_id(int visit_id) {
		this.visit_id = visit_id;
	}
	public int getPet_id() {
		return pet_id;
	}
	public void setPet_id(int pet_id) {
		System.out.println("In setters of pet_id");
		this.pet_id = pet_id;
	}
	public int getVet_id() {
		return vet_id;
	}
	public void setVet_id(int vet_id) {
		System.out.println("In setters of vet_id");
		this.vet_id = vet_id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		System.out.println("In setters of description");
		this.description = description;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		System.out.println("In setters of date");
		this.date = date;
	}

	

}
