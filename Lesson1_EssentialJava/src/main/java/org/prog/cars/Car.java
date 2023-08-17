package org.prog.cars;

public class Car {

    public String color;
    public String licensePlate;

    public void accelerate() {
        consumeFuel();
        System.out.println(color + " Car is accelerating");
    }

    public void slowDown() {
        System.out.println(color + " Car is slowing down");
    }

    private void consumeFuel() {
        System.out.println("Car is consuming fuel");
    }

    public void checkPlate(String example) {
        System.out.println(licensePlate.equals(example));
    }

    @Override
    public boolean equals(Object o){
        return true;
    }
}
