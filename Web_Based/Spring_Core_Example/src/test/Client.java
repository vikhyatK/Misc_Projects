package test;

import java.lang.reflect.Constructor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import beans.Test;

public class Client {

  public Client() {
    System.out.println("Client....");
  }
  /**
   * @param args
   */
  @SuppressWarnings("rawtypes")
  public static void main(String[] args) {
    // Find XML
    ApplicationContext ap = new ClassPathXmlApplicationContext("resources/spring.xml");
    
    // create test class object
    Object o1 = ap.getBean("t");
    Object o2 = ap.getBean("t");
    //Object o3 = ap.getBean("t");
    if(o1 == o2) System.out.println("true");
    else System.out.println("false");
    Test t = (Test)o1;
    t.hello();
    
    Class c;
    try {
      c = Class.forName("beans.Test");
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
