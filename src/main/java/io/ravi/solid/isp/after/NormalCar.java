package io.ravi.solid.isp.after;

public class NormalCar implements Car {
    @Override
    public void engine() {
        System.out.println("Engine");
    }

    @Override
    public void door() {
        System.out.println("Dual door");
    }

    @Override
    public void tank() {
        System.out.println("Petrol tank");
    }

}
