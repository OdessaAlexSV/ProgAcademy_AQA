package org.prog.classwork.cars;

public class ElectricCar implements ICar, IFueleable {

  public void chargeCar(){
    System.out.println("Charge car");
  }
  @Override
  public void moveForward(String distance) {
    System.out.println("Electric car goes " + distance);
  }

  @Override
  public void turnRight() {
    System.out.println("Electric car turns Right");
  }

  @Override
  public void turnLeft() {
    System.out.println("Electric car turns Left");
  }

  @Override
  public void stop() {
    System.out.println("Electric car stops ");
  }

  @Override
  public void reverseMovement() {
    System.out.println("Electric car reverse movement direction");
  }

  @Override
  public void fuelVehicle() {
    chargeCar();
  }
}
