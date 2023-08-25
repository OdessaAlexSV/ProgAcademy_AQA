package org.prog.classwork.collections;

import java.util.ArrayList;
import java.util.List;

public class ListsDemo {

  public static void main(String[] args) {
    List<String> arrayList = new ArrayList<>();
    arrayList.add("kooojkf");
    arrayList.add("kosdjfiouh123");
    arrayList.add(null);
    arrayList.add("asdknol");
    arrayList.add("oiyhaiusdh");

//        for (int i = 0; i < arrayList.size(); i++) {
//            if (arrayList.get(i) != null && arrayList.get(i).contains("a")) {
//                results.add(arrayList.get(i).length());
//            }
//        }
//
//        for (String s : arrayList) {
//            if (s != null && s.contains("a")) {
//                results.add(s.length());
//            }
//        }


    List<Integer> integers = getStringsLength(arrayList, "a");
    System.out.println(integers.size());
  }

  public static List<Integer> getStringsLength(List<String> strings, String letter){
    return strings.stream()
        .filter(s -> s != null)
        .filter(s -> s.contains(letter))
        .map(s -> s.length())
        .toList();
  }

}
