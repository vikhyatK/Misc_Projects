package beans;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.Vector;

public class TestCollections {

  /*private List fruits;
  private Set cricketers;
  private Map cc;*/
  
  private Vector fruits;
  private TreeSet cricketers;
  private Hashtable cc;

  public void setFruits(Vector fruits) {
    this.fruits = fruits;
  }
  public void setCricketers(TreeSet cricketers) {
    this.cricketers = cricketers;
  }
  public void setCc(Hashtable cc) {
    this.cc = cc;
  }

  public void printData() {
    System.out.println("Fruits");
    for(Object o : fruits) {
      System.out.println(o);
    }
    
    System.out.println("\nCricketers");
    for(Object o : cricketers) {
      System.out.println(o);
    }
    
    System.out.println("\nCountries and Capitals");
    Set es = cc.entrySet();
    for(Object o : es) {
      System.out.println(o);
    }
  }
}
