package org.prog.hwtask.cars;

public class Car extends AVehicle implements IMovingCar, IFuelable {

  public Car() {
    super();
  }

  public Car(String brand, String type, int carryCapacity, int yearIssue, String color, String fuelType) {
    super(brand, type, carryCapacity, yearIssue, color, fuelType);
  }

  private void fuelCar(String fuelType) {
    System.out.printf("Pour car some %s \n", fuelType);
  }

  @Override
  public void moveForward(String distance) {
    System.out.printf("Car goes %s", distance);
  }

  @Override
  public void turnRight() {
    System.out.println("Car turns right");
  }

  @Override
  public void turnLeft() {
    System.out.println("Car turns left");
  }

  @Override
  public void stop() {
    System.out.println("Car stops");
  }

  @Override
  public void reverseMovement() {
    System.out.println("Car reverses");
  }

  @Override
  public void changeColor(String newColor) {
    color = newColor;
  }

  @Override
  public void fuelVehicle(String fuelType) {
    fuelCar(fuelType);
  }

  @Override
  public String toString() {
    return "Car{" +
        " brand='" + brand + '\'' +
        ", type='" + type + '\'' +
        ", fuelType='" + fuelType + '\'' +
        ", carryCapacity='" + carryCapacity + '\'' +
        ", color='" + color + '\'' +
   '}';
  }
}
