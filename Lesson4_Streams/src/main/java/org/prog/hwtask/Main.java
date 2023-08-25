package org.prog.hwtask;


import org.prog.hwtask.car.Car;
import org.prog.hwtask.car.Owner;

import java.util.List;

public class Main {

  //TODO: add code that verifies that owners with certain name/lastname have car with certain color
  //TODO: * verify that specific Owner has car with color
  public static void main(String[] args) {
    Owner johnKyiv = getOwner("John", "Doe", "Kyiv");
    Owner johnPoltava = getOwner("John", "Doe", "Poltava");

    List<Owner> carOwners = List.of(
        johnKyiv, //red
        johnPoltava, //green
        getOwner("Jane", "Doe", "Odesa"),
        getOwner("Jonny", "Depp", "Mykolaiv"),
        getOwner("Aghata", "Kristie", "Dnipro"),
        getOwner("Alan", "Poe", "Vinnytsia")
    );

    List<Car> cars = List.of(
        getCar(carOwners.get(0), "AA0000TT", "plum"),
        getCar(carOwners.get(1), "AB0011TT", "green"),
        getCar(carOwners.get(2), "AC0022TT", "red"),
        getCar(carOwners.get(2), "AB0033TT", "blue"),
        getCar(carOwners.get(2), "AC0044TT", "cyan"),
        getCar(carOwners.get(3), "AD0055TT", "white"),
        getCar(carOwners.get(3), "AE0066TT", "marine"),
        getCar(carOwners.get(4), "AC0077TT", "gray")
    );

    System.out.printf("Does owner %s have a %s color car? - %s",
        carOwners.get(0).toString(),
        "green",
        checkCarOwner("green", carOwners.get(0).name, carOwners.get(0).lastName, cars) ? "True" : "False");
  }

  private static Owner getOwner(String name, String lastName, String homeRegister) {
    Owner owner = new Owner();
    owner.name = name;
    owner.lastName = lastName;
    owner.homeRegister = homeRegister;
    return owner;
  }

  //TODO: add color to method and paint car with it - DONE
  private static Car getCar(Owner owner, String plateNumber, String color) {
    Car car = new Car();
    car.owner = owner;
    car.plateNumber = plateNumber;
    car.color = color;
    return car;
  }

  //TODO: Home work NO * - DONE
  private static boolean checkCarOwner(String carColor, String name, String lastName, List<Car> cars) {
    return cars.stream()
        .anyMatch(s -> s.color.equals(carColor) && s.owner.name.equals(name) && s.owner.lastName.equals(lastName));
  }

  //TODO: Home work NO *
  private static boolean checkSpecificOwnerHasCarWithColor(
      //TODO: whatever params you need
  ) {
    return false;
  }
}


