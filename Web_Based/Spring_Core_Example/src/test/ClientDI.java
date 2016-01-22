package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import beans.TestDI;

public class ClientDI {

  public ClientDI() {
    System.out.println("Client....");
  }
  /**
   * @param args
   */
  public static void main(String[] args) {
    // Find XML
    ApplicationContext ap = new ClassPathXmlApplicationContext("resources/springDI.xml");
    
    TestDI t = (TestDI)ap.getBean("t");
    t.hello("Vikhyat");
    ((ConfigurableApplicationContext)ap).close();
  }

}
