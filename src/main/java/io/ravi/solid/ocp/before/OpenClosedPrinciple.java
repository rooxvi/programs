package io.ravi.solid.ocp.before;

import lombok.Data;

public class OpenClosedPrinciple {
    public static void main(String[] args) {

       Calculator calculator = new Calculator();
       Addition addition = new Addition(1,2);
       Substraction substraction = new Substraction(1,2);

       calculator.calculate(addition);
       calculator.calculate(substraction);

        System.out.println(addition.getResult());
        System.out.println(substraction.getResult());

    }
}


class Calculator{

    public void calculate(CalculatorOperation calculatorOperation){
        if(calculatorOperation instanceof Addition){
            Addition addition = (Addition) calculatorOperation;
            addition.setResult(addition.getLeft()+addition.getRight());
        }else if(calculatorOperation instanceof Substraction){
            Substraction substraction = (Substraction) calculatorOperation;
            substraction.setResult(substraction.getLeft()-substraction.getRight());
        }
        // else if Multiplication
        // else if Division
        //Note: New calculation required new changes
    }
}

interface CalculatorOperation{

}

@Data
class Addition implements CalculatorOperation{

    private double right;
    private double left;
    private double result = 0.0;

    public Addition(double right, double left) {
        this.right = right;
        this.left = left;
    }
}

@Data
class Substraction implements CalculatorOperation{

    private double right;
    private double left;
    private double result = 0.0;

    public Substraction(double right, double left) {
        this.right = right;
        this.left = left;
    }
}