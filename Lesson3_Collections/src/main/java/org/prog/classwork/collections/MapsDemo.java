package org.prog.classwork.collections;

import org.prog.classwork.cars.Car;

import java.util.HashMap;
import java.util.Map;

public class MapsDemo {

  public static void main(String[] args) {
    Map<String, Car> sMap = new HashMap<>();
    Car ford = new Car();
    Car toyota = new Car();
    Car audi = new Car();
    ford.carBrand = "Ford";
    toyota.carBrand = "Toyota";
    audi.carBrand = "Audi";
    sMap.put("Oleksii", ford);
    sMap.put("Alice", ford);
    sMap.put("Bob", toyota);
    sMap.put("Jane", toyota);
    sMap.put("Jane", audi);
    sMap.put("Judi", audi);

    System.out.println(sMap.get("Oleksii").carBrand);
    System.out.println(sMap.get("Alice").carBrand);
    System.out.println(sMap.get("Bob").carBrand);
    System.out.println(sMap.get("Jane").carBrand);
    System.out.println(sMap.get("Judi").carBrand);

  }
}
