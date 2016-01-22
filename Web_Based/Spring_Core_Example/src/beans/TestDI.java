package beans;

public class TestDI {

  private String gender;
  
  private TestDI() {
    System.out.println("Test....");
  }
  public void setGender(String gender) {
    this.gender = gender;
  }
  public void hello(String name) {
    System.out.println("Hello..." + gender + "..." + name);
  }
}
