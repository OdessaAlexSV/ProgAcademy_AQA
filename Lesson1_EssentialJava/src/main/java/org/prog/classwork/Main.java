package org.prog.classwork;

import org.prog.classwork.cars.Car;

public class Main {

  /**
   * 000000000010000000000000009000
   * 00000redCar[red]00000000000000
   * 0000000000o1000000000000000000
   * 000000000000000000000000000000
   * 000000000000000o20000000000000
   * greenCar[green]000000000000000
   * 000000000000000000000000000000
   * 000000000000000000000000000000
   *
   * @param args
   */

  public static void main(String[] args) {
    Car redCar = new Car();
    Car greenCar = new Car();

    redCar.color = "red";
    greenCar.color = "green";

    Car bobsCar = redCar;
    System.out.println("Bob's car color is " + bobsCar.color);

    System.out.println(redCar.equals(greenCar));
    System.out.println(redCar == bobsCar);
    redCar.hashCode();


       makeCarGoSomewhere(greenCar);

//        redCar.licensePlate = "test";
//
//        redCar.checkPlate("test");
//        makeCarGoSomewhere(redCar);
//        redCar.checkPlate("test");
//
//        Truck truck = new Truck();
//        HeavyTruck heavyTruck = new HeavyTruck();
//        GiantTruck giantTruck = new GiantTruck();
//
//
//        truck.color = "blue";
//        heavyTruck.color = "yellow";
//        giantTruck.color = "black";
//
//        truck.putCargo();
//        heavyTruck.putCargo();
//        giantTruck.putCargo();
//
//        heavyTruck.putMoreCargo();
//        giantTruck.putMoreCargo();
//
//        System.out.println(1 == 1);
//        System.out.println(1 == 2);
//
//        Object o1 = new Object();
//        Object o2 = new Object();
//
//        System.out.println(o1 == o2);
//        System.out.println(o1.equals(o2));
  }

  public static void makeCarGoSomewhere(Car car) {
    car.licensePlate = null;
    car.accelerate();
    car.slowDown();
  }

  public static void smth(int i){
    i += 10;
  }

}

