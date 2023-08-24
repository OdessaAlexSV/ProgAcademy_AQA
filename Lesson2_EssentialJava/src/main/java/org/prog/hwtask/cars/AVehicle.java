package org.prog.hwtask.cars;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class AVehicle {
  public String brand;
  public String type;
  public int    carryCapacity;
  public int    yearIssue;
  public String color;
  public String fuelType;

  public AVehicle() { }

  public AVehicle(String brand, String type, int carryCapacity, int yearIssue, String color, String fuelType) {
    this.brand = brand;
    this.type = type;
    this.carryCapacity = carryCapacity;
    this.yearIssue = yearIssue;
    this.color = color;
    this.fuelType = fuelType;
  }
  public abstract void changeColor(String newColor);
}
