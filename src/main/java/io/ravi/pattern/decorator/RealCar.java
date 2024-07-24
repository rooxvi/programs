package io.ravi.pattern.decorator;

import io.ravi.pattern.decorator.car.Car;

public class RealCar implements Car {
    @Override
    public void assemble() {
        System.out.println("RealCar assemble");
    }
}
