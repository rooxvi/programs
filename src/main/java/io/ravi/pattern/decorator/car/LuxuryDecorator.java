package io.ravi.pattern.decorator.car;

public class LuxuryDecorator extends CarDecorator {

    public LuxuryDecorator(Car car) {
        super(car);
    }

    @Override
    public void assemble() {
        super.assemble();
        System.out.println("with luxury assembled");
    }
}
