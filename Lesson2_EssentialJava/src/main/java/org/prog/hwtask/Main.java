package org.prog.hwtask;

import org.prog.hwtask.cars.*;
import org.prog.hwtask.exceptions.payment.BankProcessingFailureException;
import org.prog.hwtask.exceptions.payment.InvalidPaymentAmountException;
import org.prog.hwtask.exceptions.payment.InvalidPaymentClientIdException;
import org.prog.hwtask.exceptions.payment.InvalidPaymentCurrencyException;
import org.prog.hwtask.exceptions.servicestation.InvalidCarAgeExceptions;
import org.prog.hwtask.exceptions.servicestation.InvalidCarBrandNameExceptions;
import org.prog.hwtask.exceptions.servicestation.InvalidCarCarryCapacityExceptions;

import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    Car car1 = new Car();
    ElectricCar electricCar1 = new ElectricCar();

    car1.setColor("red");
    electricCar1.setColor("white");

    System.out.println("Car color before " + car1.color);
    car1.changeColor("green");
    System.out.println("Car color after " + car1.color);
    car1.fuelVehicle("gas");

    System.out.println("Electric car color before " + electricCar1.color);
    electricCar1.changeColor("blue");
    System.out.println("Electric car color after " + electricCar1.color);
    electricCar1.fuelVehicle("electro");

    System.out.println("-".repeat(15));
    System.out.println("Car service station maintenance");
    System.out.println("-".repeat(15));

    List<AVehicle> preparedCars = new ArrayList<>();
    preparedCars.add(new Car("Jeep", "Car", 1000, 2000, "cyan", "gas"));
    preparedCars.add(new Car("Mercedes", "Car", 1000, 2020, "cyan", "gas"));
    preparedCars.add(new Car("Mercedes", "Car", 3000, 2015, "cyan", "gas"));
    preparedCars.add(new ElectricCar("BMW", "Electric", 2000, 2010, "blue", "electro"));
    preparedCars.add(new ElectricCar("Tesla", "Electric", 1500, 2020, "blue", "electro"));

    CarServiceStation maintenanceCar = new CarServiceStation();

    for (AVehicle car : preparedCars) {
      System.out.println("\nInput data: " + car.toString());
      try {
        System.out.println(maintenanceCar.processMaintenance(car));
      } catch (InvalidCarBrandNameExceptions | InvalidCarAgeExceptions | InvalidCarCarryCapacityExceptions e) {
        System.out.println(e.getMessage());
      }
    }

    System.out.println("-".repeat(15));
    System.out.println("Payment status for the car service maintenance");
    System.out.println("-".repeat(15));

    List<Payment> payments = new ArrayList<>();
    payments.add(new Payment("UAH", 500l, "12345"));
    payments.add(new Payment("UAH", 500l, "12345"));
    payments.add(new Payment("USD", 10l, "12345"));
    payments.add(new Payment("ROL", 500l, "12345"));
    payments.add(new Payment("UAH", 500l, "1234"));
    payments.add(new Payment("USD", 0l, "12345"));

    BankPayment bankPayment = new BankPayment();

    for (Payment payment : payments) {
      System.out.println("\nInput data: " + payment.toString());
      try {
        System.out.println("Payment is successfully handled." +
            "\nResult code is : " + bankPayment.processPayment(payment));
      } catch (InvalidPaymentCurrencyException | InvalidPaymentAmountException | InvalidPaymentClientIdException e) {
        System.out.println(e.getMessage());

      } catch (BankProcessingFailureException e) {
        e.printStackTrace();
        System.out.println("Payment is failed.\n" + e.getMessage() + ".");
      }
    }
  }
}

//public static void fuelVehicle(IFuelable car, String fuelType) {
//    car.fuelVehicle(fuelType);
//  }

//public static void changeColor(AVehicle car, String newColor) {
//    car.changeColor(newColor);
//  }
//}
