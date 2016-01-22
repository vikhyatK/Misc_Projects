package utils;

import org.hibernate.cfg.*;
import org.hibernate.*;
import org.hibernate.service.*;

//role --- to set up Hibernate configuration
//attach singleton immutable inst SF to the same
//add method to get hib session
public class HibernateUtils {
	private static SessionFactory factory;
	private static Session session;
	static {
		System.out.println("in static init block");
		// time consuming steps --- BEST to be invoked
		// @ Context startup time.
		// create empty configure inst & confugure the same
		Configuration cfg = new Configuration().configure();
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(
				cfg.getProperties()).buildServiceRegistry();
		factory=cfg.buildSessionFactory(reg);

	}
	public static SessionFactory getFactory() {
		return factory;
	}
	
	public static Session getSession() {
		return factory.openSession();
	}
	

}
