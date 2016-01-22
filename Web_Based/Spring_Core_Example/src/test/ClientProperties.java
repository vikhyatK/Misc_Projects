package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import beans.TestProperties;

public class ClientProperties {

  public static void main(String[] args) {
    // Find XML
    ApplicationContext ap = new ClassPathXmlApplicationContext("resources/springProperties.xml");
    // create test class object
    TestProperties t = (TestProperties)ap.getBean("t");
    t.printData();
    ((ConfigurableApplicationContext)ap).close();
  }

}
