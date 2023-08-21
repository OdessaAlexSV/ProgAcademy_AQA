package org.prog.classwork;

import org.prog.classwork.cars.*;

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
    //test
    Car gasCar = new Car();
    HeavyTruck dieselCar = new HeavyTruck();

    gasCar.fuelType = "gas";
    dieselCar.htFuelType = "diesel";

    gasCar.fuelType.equals(dieselCar.htFuelType);
//        Truck truck = new Truck();
//        HeavyTruck heavyTruck = new HeavyTruck();
//        GiantTruck giantTruck = new GiantTruck();
//        ElectricCar tesla = new ElectricCar();

//        makeCarGoSomewhere(truck, "300 m", "200 m");
//        makeCarGoSomewhere(heavyTruck, "300 m", "200 m");
//        makeCarGoSomewhere(giantTruck, "300 m", "200 m");
//        makeCarGoSomewhere(tesla, "5 m", "0 m");

    Journey journeyA = new Journey();
    journeyA.from = "Kharkiv";
    journeyA.passingThrough = "Dnipro";
    journeyA.destination = "Kherson";

    Journey journeyB = new Journey();
    journeyB.from = "Kharkiv";
    journeyB.passingThrough = "Dnipro";
    journeyB.destination = "Kherson";

    System.out.println(journeyA);
    System.out.println(journeyA.equals(journeyB));

//        redCar.goTo("Odessa");
//        redCar.goTo("Odessa", "Lviv");
//        redCar.goTo("Odessa", "Kyiv", "Dnipro");
//        redCar.goTo(journeyA);
//        redCar.goTo(journeyB);
  }

  public static void makeCarGoSomewhere(ICar car, String distanceOne, String distanceTwo) {
    car.moveForward(distanceOne);
    car.turnLeft();
    car.moveForward(distanceTwo);
    car.stop();
  }

  public static void smth(IFuleable fuleable) {
    fuleable.fuelVehicle();
  }

}
