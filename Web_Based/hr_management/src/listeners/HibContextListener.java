package listeners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.hibernate.SessionFactory;

import utils.HibernateUtils;

/**
 * Application Lifecycle Listener implementation class HibContextListener
 *
 */
@WebListener
public class HibContextListener implements ServletContextListener {
	private SessionFactory factory;
    /**
     * Default constructor. 
     */
    public HibContextListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0) {
        //load entire hib frmwork @ ctx init time
    	System.out.println("in ctx init");
    	factory=HibernateUtils.getFactory();
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0) {
        System.out.println("in ctx destroy");
        factory.close();
    }
	
}
