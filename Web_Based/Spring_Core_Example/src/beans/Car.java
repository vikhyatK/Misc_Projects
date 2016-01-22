package beans;

public class Car {

  private String[] carName;
  private Engine[] engine;

  public Car(){
    System.out.println("Car");
  }
  public void setCarName(String[] carName) {
    this.carName = carName;
  }

  public void setEngine(Engine[] engine) {
    this.engine = engine;
  }

  public void printCarData() {
    for (String name : carName) {
      System.out.println("Car Name : " + name);
    }
    for (Engine eng: engine) {
      System.out.println("Model Year : " + eng.getModelYear());
    }
  }
}
