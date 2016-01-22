package beans;

public class TestSetterDependency {

  private String name;
  private int age;
  private String email;
  
  
  public void setName(String name) {
    this.name = name;
  }


  public void setAge(int age) {
    this.age = age;
  }


  public void setEmail(String email) {
    this.email = email;
  }

  public void printData() {
    System.out.println("Name : " + name + "\nAge : " + age + "\nEmail : " + email);
  }

  TestSetterDependency(String name, int age, String email){
    this.name = name;
    this.age = age;
    this.email = email;
  }
}
