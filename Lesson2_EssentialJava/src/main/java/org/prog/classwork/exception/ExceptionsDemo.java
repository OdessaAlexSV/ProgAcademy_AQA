package org.prog.classwork.exception;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ExceptionsDemo {

  public static void main(String[] args) throws FileNotFoundException {
    brokenMethod();
  }

  private static void brokenMethod() throws FileNotFoundException {
    try {
      FileReader fileReader = new FileReader(new File("abc.txt"));
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
    } finally {
      System.out.println("This is executed always");
    }
    System.out.println("test");
  }
}
