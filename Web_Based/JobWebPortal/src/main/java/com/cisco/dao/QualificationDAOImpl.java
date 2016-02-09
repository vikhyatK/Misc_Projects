package com.cisco.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.cisco.models.Qualification;

@Repository
@EnableTransactionManagement
public class QualificationDAOImpl implements QualificationDAO{

	public QualificationDAOImpl() {

	}
	
	private static final Logger logger = LoggerFactory.getLogger(QualificationDAOImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	@Transactional
	@Override
	public long addQualification(Qualification p){
		long id = 0;
		try {
			Session session = this.sessionFactory.getCurrentSession();
			id =  (long) session.save(p);
		} catch (Exception e) {
	        e.printStackTrace();
	    }
		logger.info("Qualification saved successfully, Qualification Details="+p);
		return id;
	}

	
	public void updateQualification(Qualification p) {
		
	}

	@Override
	public List<Qualification> listQualification() {

		return null;
	}

	@Override
	public Qualification getQualificationById(int id) {

		return null;
	}

	@Override
	public void removeQualification(int id) {
		
	} 
	
}
