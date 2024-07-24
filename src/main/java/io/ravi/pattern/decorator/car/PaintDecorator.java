package io.ravi.pattern.decorator.car;

public class PaintDecorator extends CarDecorator {

    public PaintDecorator(Car car) {
        super(car);
    }

    @Override
    public void assemble() {
        super.assemble();
        System.out.println("with paint decorator assembled");
    }
}
