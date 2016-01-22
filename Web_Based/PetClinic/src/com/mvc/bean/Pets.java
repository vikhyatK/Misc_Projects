package com.mvc.bean;

import java.io.Serializable;
import java.util.Date;

public class Pets implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int pet_id;
	private String pet_name;
	private Date birth_date;
	private String type;
	private int owner_id;
	//private static final String DATE_PATTERN="dd:mm:yy";
	//private static SimpleDateFormat sdf;
	//private Set<Visit> visits;
	
	/*static
	{
		sdf=new SimpleDateFormat(DATE_PATTERN);
	}*/
	
	public Pets() {
		System.out.println("In default constr of Pets");
	}

	public Pets(int pet_id, String pet_name, Date birth_date, String type,
			int owner_id) {
		super();
		this.pet_id = pet_id;
		this.pet_name = pet_name;
		this.birth_date = birth_date;
		this.type = type;
		this.owner_id = owner_id;
	}

	public int getPet_id() {
		return pet_id;
	}

	public void setPet_id(int pet_id) {
		System.out.println("In setters of pet_id");
		this.pet_id = pet_id;
	}

	public String getPet_name() {
		return pet_name;
	}

	public void setPet_name(String pet_name) {
		System.out.println("In setters of pet_name");
		this.pet_name = pet_name;
	}

	public Date getBirth_date() {
		return birth_date;
	}

	public void setBirth_date(Date birth_date) {
		//try {
			System.out.println("In seter of birth_date.. String got:"+birth_date);
			this.birth_date = birth_date;
			System.out.println("Date > "+this.birth_date);
		/*} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		System.out.println("In setters of type");
		this.type = type;
	}

	public int getOwner_id() {
		return owner_id;
	}

	public void setOwner_id(int owner_id) {
		System.out.println("In setter of owner_id");
		this.owner_id = owner_id;
	}

	/*public void setVisits(Set<Visit> visits) {
		this.visits = visits;
	}

	public Set<Visit> getVisits() {
		if (this.visits == null) {
			this.visits = new HashSet<Visit>();
		}
		return this.visits;
	}*/
}
