package io.ravi.pattern.factory.car;

public class LuxuryCar extends Car{

    LuxuryCar(){
        super(CarType.LUXURY);
    }
    @Override
    protected void construct() {

    }
}
