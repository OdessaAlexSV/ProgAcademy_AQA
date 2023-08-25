package org.prog.hwtask.car;

import org.prog.hwtask.car.Owner;

public class Car {
  public Owner owner;
  public String plateNumber;
  public String color;

  public void paintCarWithColor(String newColor) {
     this.color = newColor;
  }
}
