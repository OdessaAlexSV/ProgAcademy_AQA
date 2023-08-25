package org.prog.classwork.exceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ExceptionsDemo {

  private static String localString;

  public static void main(String[] args) throws FileNotFoundException {
    Object o = null;

  }

  public static void printStringLength(){
    if (localString == null){
      localString = "asd";
    }
    printLocalStringLength();
  }

  private static void printLocalStringLength() {
//        if (localString == null) {
//            throw new RuntimeException("empty string!");
//        }
    System.out.println(localString.length());
  }

  private static void brokenMethod(boolean flag) throws FileNotFoundException {
    try {
      if (flag) {
        FileReader fileReader = new FileReader(new File("abc.txt"));
      }
    } finally {
      System.out.println("this is executed");
    }
    System.out.println("this is NOT executed");
  }

  private static void processableExceptionExample() {
    try {
      FileReader fileReader = new FileReader(new File("abc.txt"));
    } catch (FileNotFoundException e) {
      System.err.println("OOOPS!");
    } catch (Throwable th) {
      System.out.println("this is another exception");
    } finally {
      System.out.println("This is executed always");
    }
    System.out.println("test");
  }
}
