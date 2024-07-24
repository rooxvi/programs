package io.ravi.pattern.decorator.car;

public class ToyCar implements Car {
    @Override
    public void assemble() {
        System.out.println("Toy Car");
    }
}
