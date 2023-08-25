package org.prog.classwork.staticdemo;



import java.util.ArrayList;
import java.util.List;

public class Example {

  private final static List<String> sList = new ArrayList<>();

  public final static String staticValue = "A";
  public String regularValue;

  public static void utilMethod(){
    sList.add("a");
    sList.remove("a");
  }
}