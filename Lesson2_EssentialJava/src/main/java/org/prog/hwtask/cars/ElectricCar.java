package org.prog.hwtask.cars;

public class ElectricCar extends Car implements IMovingCar, IFuelable{

  public ElectricCar(String brand, String type, int carryCapacity, int yearIssue, String color, String fuelType) {
    super(brand, type, carryCapacity, yearIssue, color, fuelType);
  }

  public ElectricCar() {
    super();
  }

  private void chargeCar(String fuelType) {
    System.out.println("Electric car charges\n");
  }

  @Override
  public void moveForward(String distance) {
    System.out.printf("Electric car goes %s", distance);
  }

  @Override
  public void turnRight() {
    System.out.println("Electric car turns right");
  }

  @Override
  public void turnLeft() {
    System.out.println("Electric car turns left");
  }

  @Override
  public void stop() {
    System.out.println("Electric car stops");
  }

  @Override
  public void reverseMovement() {
    System.out.println("Electric car reverses");
  }

  @Override
  public void fuelVehicle(String fuelType) {
    chargeCar(fuelType);
  }

  @Override
  public void changeColor(String newColor) {
    color = newColor;
  }
}
