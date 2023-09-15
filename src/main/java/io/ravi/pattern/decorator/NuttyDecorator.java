package io.ravi.pattern.decorator;

public class NuttyDecorator extends IcecreamDecorator{
    public NuttyDecorator(Icecream specialIcecream) {
        super(specialIcecream);
    }

    @Override
    public String makeIcecream() {
        return specialIcecream.makeIcecream() + addNuts();
    }

    private String addNuts(){
        return " + Chrunchy nuts";
    }
}
