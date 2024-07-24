package io.ravi.pattern.decorator.car;

import io.ravi.pattern.decorator.RealCar;

public class App {
    public static void main(String[] args) {
        Car car = new RealCar();
        car = new LuxuryDecorator(car);
        car = new SportsDecorator(car);
        car = new PaintDecorator(car);

        car.assemble();

    }
}
