package org.prog.hwtask;


import org.prog.hwtask.car.Car;
import org.prog.hwtask.car.Owner;

import java.util.List;

public class Main {

  private static List<Car> cars;
  private static List<Owner> carOwners;

  //TODO: add code that verifies that owners with certain name/lastname have car with certain color
  //TODO: * verify that specific Owner has car with color
  public static void main(String[] args) {
    Owner johnKyiv = getOwner("John", "Doe", "Kyiv");
    Owner johnPoltava = getOwner("John", "Doe", "Poltava");
    Owner johnKherson = getOwner("John", "Doe", "Kherson");

    //red
    //green
    // plum
    carOwners = List.of(
        johnKyiv,    //red
        johnPoltava, //green
        johnKherson, // plum
        getOwner("Jane", "Doe", "Odesa"),
        getOwner("Jonny", "Depp", "Mykolaiv"),
        getOwner("Aghata", "Kristie", "Dnipro"),
        getOwner("Bruce", "Wales", "NY"),
        getOwner("Leonel", "Messi", "Maymi"),
        getOwner("William", "Poe", "Vinnytsia")
    );

    cars = List.of(
        getCar(carOwners.get(0), "AA0000TT", "red"),
        getCar(carOwners.get(1), "AB0011TT", "green"),
        getCar(carOwners.get(2), "AB0022TT", "red"),
        getCar(carOwners.get(3), "AC0033TT", "red"),
        getCar(carOwners.get(4), "AB0044TT", "blue"),
        getCar(carOwners.get(5), "AC0055TT", "cyan"),
        getCar(carOwners.get(6), "AD0066TT", "white"),
        getCar(carOwners.get(7), "AE0077TT", "marine"),
        getCar(carOwners.get(8), "AC0088TT", "gray")
    );


    String interestedCarColor = "green";
    String interestedHomeRegistration = "Poltava";

    System.out.printf("Is there a \"%s\" owner who has a \"%s\" colored car? - %s",
        carOwners.get(0).toString(),
        interestedCarColor,
        checkCarOwner(interestedCarColor, carOwners.get(0).name, carOwners.get(0).lastName) ? "True" : "False");
    System.out.printf("\nHow many owners of \"%s\" exist who have a \"%s\" color car? - %d",
        carOwners.get(0).toString(),
        interestedCarColor,
        countCarOwnerWithSpecificCarColor(interestedCarColor, carOwners.get(0).name, carOwners.get(0).lastName));
    System.out.printf("\nIs there among \"%s\" owner(s) of the \"%s\" color car living in %s? - %s",
        johnKyiv,
        interestedCarColor,
        interestedHomeRegistration,
        checkSpecificOwnerHasCarWithColor(interestedCarColor, johnPoltava, interestedHomeRegistration) ? "True" : "False");

  }

  private static Owner getOwner(String name, String lastName, String homeRegister) {
    Owner owner = new Owner();
    owner.name = name;
    owner.lastName = lastName;
    owner.homeRegister = homeRegister;
    return owner;
  }


  //TODO: Home work NO * - DONE
  private static boolean checkCarOwner(String carColor, String name, String lastName) {
    return cars.stream()
        .anyMatch(s -> s.color.equals(carColor) && s.owner.name.equals(name) && s.owner.lastName.equals(lastName));
  }

  //TODO: Home work - DONE
  private static Long countCarOwnerWithSpecificCarColor(String carColor, String name, String lastName) {
    return cars.stream()
        .filter(s -> s.owner.name.equals(name) && s.owner.lastName.equals(lastName) && s.color.equals(carColor))
        .count();
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
  private static boolean checkSpecificOwnerHasCarWithColor(String carColor, Owner owner, String interestedHomeRegistration) {
    return cars.stream()
        .anyMatch(s -> s.color.equals(carColor)
            && s.owner.equals(owner)
            && s.owner.homeRegister.equals(interestedHomeRegistration) );
  }
}



