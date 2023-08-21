package org.prog.hwtask;

import org.prog.hwtask.cars.Car;
import org.prog.hwtask.cars.Truck;

public class Main {

  public static void main(String[] args) {
    Car car1 = new Car();
    Truck truck1 = new Truck();

    car1.color = "red";
    truck1.color = "blue";

    System.out.println("Car color before " + car1.color);
    changeCarColor(car1,"green");
    System.out.println("Car color after " + car1.color);


    System.out.println("Truck color before " + truck1.color);
    changeTruckColor(truck1,"black");
    System.out.println("Truck color after " + truck1.color);
  }

  public static void changeCarColor(Car car, String newColor) {
    car.color = newColor;
  }

  public static void changeTruckColor(Truck truck, String newColor) {
    truck.color = newColor;
  }


}
