package io.ravi.pattern.solid.ocp.after;

import lombok.Data;

public class OpenClosedPrinciple {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        Addition addition = new Addition(1,2);
        Substraction substraction = new Substraction(1,2);
        Multiplication multiplication = new Multiplication(2,3);

        addition.perform();
        substraction.perform();
        multiplication.perform();

        System.out.println(addition.getResult());
        System.out.println(substraction.getResult());
        System.out.println(multiplication.getResult());

    }
}

class Calculator{

    public void calculate(CalculatorOperation calculatorOperation){
       calculatorOperation.perform();
    }
}

interface CalculatorOperation{
    void perform();
}

@Data
class Addition implements CalculatorOperation {

    private double right;
    private double left;
    private double result = 0.0;

    public Addition(double right, double left) {
        this.right = right;
        this.left = left;
    }

    @Override
    public void perform() {
        result = left+right;
    }
}

@Data
class Substraction implements CalculatorOperation {

    private double right;
    private double left;
    private double result = 0.0;

    public Substraction(double right, double left) {
        this.right = right;
        this.left = left;
    }

    @Override
    public void perform() {
        result = left - right;
    }
}


@Data
class Multiplication implements CalculatorOperation {

    private double right;
    private double left;
    private double result = 0.0;

    public Multiplication(double right, double left) {
        this.right = right;
        this.left = left;
    }

    @Override
    public void perform() {
        result = left * right;
    }
}

