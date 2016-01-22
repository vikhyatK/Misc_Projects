package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import beans.TestCollections;

public class ClientCollections {

  public static void main(String[] args) {
    // Find XML
    //String[] files = new String[]{"resources/springCar.xml","resources/springEngine.xml"};
    //ApplicationContext ap = new ClassPathXmlApplicationContext(files);
    ApplicationContext ap = new ClassPathXmlApplicationContext("resources/springCollections.xml");
    // create test class object
    TestCollections t = (TestCollections)ap.getBean("t");
    t.printData();
    ((ConfigurableApplicationContext)ap).close();
  }

}
