package org.prog.classwork.collections;

import org.prog.classwork.cars.Car;

import java.util.ArrayList;
import java.util.List;

public class ListDemo {

  public static void main(String[] args) {
    List<Car> ownedCars = new ArrayList<>();
    List<Car> unsoldCars = new ArrayList<>();
    List<Car> allCars = new ArrayList<>();
    Car myCar = new Car();
    Car bobsCar = new Car();
    Car joesCar = new Car();
    Car unsoldCarRed = new Car();
    Car unsoldCarBlue = new Car();
    ownedCars.add(myCar);
    ownedCars.add(bobsCar);
    ownedCars.add(joesCar);
    unsoldCars.add(unsoldCarBlue);
    unsoldCars.add(unsoldCarRed);

    System.out.println(ownedCars.size());
    System.out.println(unsoldCars.size());

    allCars.addAll(ownedCars);
    allCars.addAll(unsoldCars);

    System.out.println(allCars.size());

    allCars.removeAll(ownedCars);

    System.out.println(allCars.size());
  }

  private static void demoStream() {

  }
}