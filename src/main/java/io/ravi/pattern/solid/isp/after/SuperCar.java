package io.ravi.pattern.solid.isp.after;

public class SuperCar implements Car,AdvancedCar {
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

    @Override
    public void turbo() {
        System.out.println("Super turbo car engine");
    }
}
