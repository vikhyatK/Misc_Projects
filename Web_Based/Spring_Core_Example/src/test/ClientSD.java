package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import beans.TestSetterDependency;

public class ClientSD {

  public ClientSD() {
    System.out.println("Client....");
  }
  /**
   * @param args
   */
  public static void main(String[] args) {
    // Find XML
    ApplicationContext ap = new ClassPathXmlApplicationContext("resources/springSD.xml");
    
    // create test class object
    TestSetterDependency t = (TestSetterDependency)ap.getBean("t");
    t.printData();
    ((ConfigurableApplicationContext)ap).close();
  }

}
