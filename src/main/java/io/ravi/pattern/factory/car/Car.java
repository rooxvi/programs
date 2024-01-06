package io.ravi.pattern.factory.car;

public abstract class Car {
    private CarType model;
    public Car(CarType model){
        this.model = model;
    }

    public CarType getModel(){
        return model;
    }

    protected abstract void construct();
}
