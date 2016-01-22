package test;

import java.lang.reflect.Constructor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client1 {

  public Client1() {
    System.out.println("Client....");
  }
  /**
   * @param args
   */
  @SuppressWarnings("rawtypes")
  public static void main(String[] args) {
    // Find XML
    ApplicationContext ap = new ClassPathXmlApplicationContext("resources/spring.xml");
    
    // Access private constructor through reflection
    try {
      Class c = Class.forName("beans.Test");
      Constructor con[] = c.getDeclaredConstructors();
      con[0].setAccessible(true);
      con[0].newInstance();
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    ((ConfigurableApplicationContext)ap).close();
  }

}
