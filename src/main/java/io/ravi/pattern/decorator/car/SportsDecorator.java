package io.ravi.pattern.decorator.car;

public class SportsDecorator extends CarDecorator {

    public SportsDecorator(Car car) {
        super(car);
    }

    @Override
    public void assemble() {
        super.assemble();
        System.out.println("with sports feature");
    }
}
