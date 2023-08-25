package org.prog.classwork.collections;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetsDemo {

  public static void main(String[] args) {
    Set<String> stringSet = new HashSet<>();
    stringSet.add("a");
    stringSet.add("a");
    stringSet.add("a");
    stringSet.add("a");
    stringSet.add("a");
    stringSet.add("a");
    stringSet.add("a");
    stringSet.add("a");
    stringSet.add("a");
    stringSet.add("b");
    stringSet.add("a");
    System.out.println(stringSet.size());
    Iterator<String> iterator = stringSet.iterator();
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }
  }
}