package com.mvc.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.mvc.bean.Owners;
import com.mvc.bean.Pets;
import com.mvc.bean.Vets;

public class SelectDAO extends HibernateDaoSupport {
	ArrayList<Owners> ownerList = null;
	ArrayList<Vets> vetList = null;
	ArrayList<Pets> petList = null;

	public SelectDAO() {
		System.out.println("In Select DAO constr...");
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Owners> selectOwnerName(int own_id) {
		System.out.println("In selectOwnerName by Own_id dao method.. ");

		ownerList = new ArrayList<Owners>();
		ownerList = (ArrayList<Owners>) getHibernateTemplate().find(
				"FROM Owners o where o.own_id = ?", own_id);

		return ownerList;
	}

	@SuppressWarnings("rawtypes")
	public Owners selectOwnerDetails(String name) {
		System.out.println("In selectOwnerDetails dao method.. ");
		Owners own_obj = null;

		List obj_list = getHibernateTemplate().find(
				"FROM Owners o where o.own_fname = ?", name);
		if (obj_list.isEmpty())
			return own_obj;
		own_obj = (Owners) obj_list.get(0);
		return own_obj;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Owners> selectOwners() {
		System.out.println("In selectOwners dao method.. ");
		ownerList = new ArrayList<Owners>();

		Session sess = getHibernateTemplate().getSessionFactory().openSession();
		try {
			String hql = "FROM Owners";
			Query query = sess.createQuery(hql);
			ownerList = (ArrayList<Owners>) query.list();
		} catch (Exception e) {
			System.out.println("err in Insert Owner DAO " + e);
			// throw e;
		} finally {
			if (sess != null)
				sess.close();
		}

		return ownerList;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Owners> selectOwnerName(String name) {
		System.out.println("In selectOwnerName by Own_name dao method.. ");
		ownerList = null;
		if (ownerList == null)
			ownerList = new ArrayList<Owners>();

		String name_toPass = name + "%";
		ownerList = (ArrayList<Owners>) getHibernateTemplate().find(
				"FROM Owners o where o.own_fname LIKE ?", name_toPass);

		return ownerList;
	}

	

	@SuppressWarnings("rawtypes")
	public Pets selectPetDetails(int petId) {
		System.out.println("In selectPetDetails dao method.. ");
		Pets pet_obj = null;

		List obj_list = getHibernateTemplate().find(
				"FROM Pets p where p.pet_id = ?", petId);
		if (obj_list.isEmpty())
			return pet_obj;
		pet_obj = (Pets) obj_list.get(0);
		return pet_obj;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Pets> selectPetsDetails(int ownerId) {
		System.out.println("In selectPetsDetails dao method.. ");
		petList = new ArrayList<Pets>();

		petList = (ArrayList<Pets>) getHibernateTemplate().find(
				"FROM Pets p where p.owner_id = ?", ownerId);

		return petList;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Vets> selectVets() {
		System.out.println("In selectVets dao method.. ");
		vetList = new ArrayList<Vets>();
		Session sess = getHibernateTemplate().getSessionFactory().openSession();
		try {
			String hql = "FROM Vets";
			Query query = sess.createQuery(hql);
			vetList = (ArrayList<Vets>) query.list();
		} catch (Exception e) {
			System.out.println("err in Insert Owner DAO " + e);
			// throw e;
		} finally {
			if (sess != null)
				sess.close();
		}

		return vetList;
	}
	@SuppressWarnings("unchecked")
	public ArrayList<Owners> selectOwnerNameById(String name_id) {
		System.out.println("In selectOwnerNameById by name_id dao method.. ");
		ownerList = null;
		if (ownerList == null) {
			ownerList = new ArrayList<Owners>();
		}
		int id;
		String name_toPass = name_id + "%";
		try {
			id = Integer.parseInt(name_id);

		} catch (Exception e) {
			ownerList = (ArrayList<Owners>) getHibernateTemplate().find(
					"FROM Owners o where o.own_fname LIKE ?", name_toPass);
			return ownerList;
		}
		ownerList = (ArrayList<Owners>) getHibernateTemplate().find(
				"FROM Owners o where o.own_id = ?",id);

		return ownerList;
	}
}
