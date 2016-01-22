package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import beans.Car;

public class ClientCEA {

  public static void main(String[] args) {
    // Find XML
    //String[] files = new String[]{"resources/springCar.xml","resources/springEngine.xml"};
    //ApplicationContext ap = new ClassPathXmlApplicationContext(files);
    ApplicationContext ap = new ClassPathXmlApplicationContext("resources/springCEA.xml");
    // create test class object
    Car c = (Car)ap.getBean("c");
    c.printCarData();
    ((ConfigurableApplicationContext)ap).close();
  }

}
