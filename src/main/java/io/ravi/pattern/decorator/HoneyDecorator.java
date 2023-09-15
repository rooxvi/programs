package io.ravi.pattern.decorator;

import java.util.SplittableRandom;

public class HoneyDecorator extends IcecreamDecorator{
    public HoneyDecorator(Icecream specialIcecream) {
        super(specialIcecream);
    }

    @Override
    public String makeIcecream() {
        return specialIcecream.makeIcecream() + addHoney();
    }

    private String addHoney(){
        return " + sweet Honey";
    }
}
