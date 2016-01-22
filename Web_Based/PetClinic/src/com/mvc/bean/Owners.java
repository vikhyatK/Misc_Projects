package com.mvc.bean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;



public class Owners implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int	own_id; 
	private String own_fname;
	private String own_lname;
	private String address;
	private int telephone;
	private Set<Pets> pets;
	
	public Owners(){
		
	}
	
	public Owners(int own_id, String own_fname, String own_lname,
			String address, int telephone) {
		this.own_id = own_id;
		this.own_fname = own_fname;
		this.own_lname = own_lname;
		this.address = address;
		this.telephone = telephone;
	}
	public int getOwn_id() {
		return own_id;
	}
	public void setOwn_id(int own_id) {
		this.own_id = own_id;
	}
	public String getOwn_fname() {
		return own_fname;
	}
	public void setOwn_fname(String own_fname) {
		this.own_fname = own_fname;
	}
	public String getOwn_lname() {
		return own_lname;
	}
	public void setOwn_lname(String own_lname) {
		this.own_lname = own_lname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getTelephone() {
		return telephone;
	}
	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}
	public Set<Pets> getPets() {
		if (this.pets == null) {
			this.pets = new HashSet<Pets>();
		}
		return this.pets;
	}
	public void setPets(Set<Pets> pets) {
		this.pets = pets;
	}
	
	
}
