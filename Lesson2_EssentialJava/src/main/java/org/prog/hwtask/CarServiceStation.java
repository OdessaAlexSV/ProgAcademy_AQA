package org.prog.hwtask;

import org.prog.hwtask.cars.AVehicle;

import org.prog.hwtask.exceptions.servicestation.InvalidCarAgeExceptions;
import org.prog.hwtask.exceptions.servicestation.InvalidCarBrandNameExceptions;
import org.prog.hwtask.exceptions.servicestation.InvalidCarCarryCapacityExceptions;

import java.time.Year;
import java.util.List;

public class CarServiceStation {
  public static List<String> SUPPORTED_CAR_BRANDS = List.of("Mercedes", "Volvo", "BMW", "Tesla");

  public String processMaintenance(AVehicle car)
      throws InvalidCarBrandNameExceptions, InvalidCarAgeExceptions, InvalidCarCarryCapacityExceptions {
    if (!SUPPORTED_CAR_BRANDS.contains(car.getBrand())) {
      throw new InvalidCarBrandNameExceptions(String.format("Car brand %s not supported", car.getBrand()));
    }

    if (carAge(car.getYearIssue()) >= 10) {
      throw new InvalidCarAgeExceptions("The car is too old.");
    }

    if (!carTypeAndWeightAccept(car.getBrand(), car.getCarryCapacity())) {
      throw new InvalidCarCarryCapacityExceptions(String.format("The %s brand with a specific carry capacity %s does not maintenance."
          , car.getBrand(), car.getCarryCapacity()));
    }

    return "A car is accepted for service station maintenance.";
  }

  private boolean carTypeAndWeightAccept(String brand, int carryCapacity) {
    if (brand.equals("Mercedes") & carryCapacity >= 2500) {
      return false;
    }
    if (brand.equals("Volvo") & carryCapacity >= 1500) {
      return false;
    }
    if (brand.equals("BMW") & carryCapacity >= 4000) {
      return false;
    }
     return true;
  }

  private int carAge(int yearIssue) {
    return Year.now().getValue() - yearIssue;
  }
}
