package org.prog.classwork.collections;

import org.prog.classwork.car.Car;
import org.prog.classwork.car.Owner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapsDemo {

  //TODO: add code that verifies that owners with certain name/lastname have car with certain color
  //TODO: * verify that specific Owner has car with color
  public static void main(String[] args) {
    Owner johnKyiv = getOwner("John", "Doe");
    Owner johnPoltava = getOwner("John", "Doe");

    //John Doe -> AA0000TT
    List<Owner> carOwners = List.of(
        johnKyiv, //red
        johnPoltava, //green
        getOwner("Jane", "Doe"),
        getOwner("Jonny", "Depp"),
        getOwner("Aghata", "Kristie"),
        getOwner("Alan", "Poe")
    );

    List<Car> cars = List.of(
        getCar(carOwners.get(0), "AA0000TT"),
        getCar(carOwners.get(1), "AB0011TT"),
        getCar(carOwners.get(2), "AC0022TT"),
        getCar(carOwners.get(2), "AB0033TT"),
        getCar(carOwners.get(2), "AC0044TT"),
        getCar(carOwners.get(3), "AD0055TT"),
        getCar(carOwners.get(3), "AE0066TT"),
        getCar(carOwners.get(4), "AC0077TT")
    );

//        List<String> ownerNames = cars.stream()
//                .filter(car -> car.plateNumber.startsWith("AC"))
//                .map(car -> car.owner.name)
//                .toList();
//
//       List<String> uniqueOwnerNames = cars.stream()
//               .filter(car -> car.plateNumber.startsWith("AC"))
//               .map(car -> car.owner.name)
//               .distinct()
//               .toList();

//        Optional<String> firstFoundOwner = cars.stream()
//               .filter(car -> car.plateNumber.startsWith("AC"))
//               .map(car -> car.owner.name)
//                .findFirst();

    boolean allPlatesContainDoubleZero = cars.stream()
        .allMatch(c -> c.plateNumber.contains("00"));

    boolean anyPlatesContainAE = cars.stream()
        .anyMatch(c -> c.plateNumber.contains("AE"));

    Map<String, String> map = new HashMap<>();
    map.put("key_1", "value_1");
    map.put("key_2", "value_2");
    map.put("key_3", "value_3");
    map.put("key_4", "value_4");

    map.entrySet().stream()
        .forEach(e -> {
          System.out.println(e.getKey() + " : " + e.getValue());
        });

//        System.out.println(allPlatesContainDoubleZero);
//        System.out.println(anyPlatesContainAE);
  }

  private static Owner getOwner(String name, String lastName) {
    Owner owner = new Owner();
    owner.name = name;
    owner.lastName = lastName;
    return owner;
  }

  //TODO: add color to method and paint car with it
  private static Car getCar(Owner owner, String plateNumber) {
    Car car = new Car();
    car.owner = owner;
    car.plateNumber = plateNumber;
    return car;
  }

  //TODO: Home work NO *
  private static boolean checkCarOwner(String carColor, String name, String lastName) {
    return false;
  }

  //TODO: Home work NO *
  private static boolean checkSpecificOwnerHasCarWithColor(
      //TODO: whatever params you need
  ) {
    return false;
  }
}
