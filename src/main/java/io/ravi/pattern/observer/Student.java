package io.ravi.pattern.observer;

import java.util.Observable;
import java.util.Observer;

public class Student implements Observer {
    private String name;
    public Student(String name){
        this.name = name;
    }
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("I am "+name+", got message: "+arg);
    }
}
