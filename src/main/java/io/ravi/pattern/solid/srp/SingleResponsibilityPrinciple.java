package io.ravi.pattern.solid.srp;



public class SingleResponsibilityPrinciple {
}

class Employee1{
    private Integer id;
    private String name;
    private Double salary;
    private  CalculateSalary calculateSalary;

    public Employee1(){

    }

}

interface CalculateSalary{
  public double calculate(Employee employee);
}

class SeniorManager implements CalculateSalary{

    @Override
    public double calculate(Employee employee) {
        return 0;
    }
}

class Labour implements CalculateSalary{
    @Override
    public double calculate(Employee employee) {
        return 0;
    }
}

class Connection1{
    void createConnection(){
        return;
    }
}

class DAO{
    public void save(Employee employee){
        Connection1 connection1;
        //code
    }
}
